package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends j<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final Long fMe;
  private e db;
  
  static
  {
    AppMethodBeat.i(182146);
    fMe = Long.valueOf(604800000L);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "GroupTodo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS todoIdIndex ON GroupTodo ( todoid )", "CREATE INDEX IF NOT EXISTS todoIdRoomNameIndex ON GroupTodo ( todoid,roomname )", "CREATE INDEX IF NOT EXISTS roomNameIndex ON GroupTodo ( roomname )" };
    AppMethodBeat.o(182146);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "GroupTodo", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean Yp()
  {
    AppMethodBeat.i(182144);
    try
    {
      i = this.db.delete("GroupTodo", "createtime<?", new String[] { cf.aCL() - fMe.longValue() });
      if (i > 0)
      {
        AppMethodBeat.o(182144);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.roomTodo.GroupTodoStorage", "deleteExpireData  Exception：[%s %s]", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = 0;
      }
      AppMethodBeat.o(182144);
    }
    return false;
  }
  
  public final c ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182140);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(182140);
      return null;
    }
    paramString1 = this.db.query("GroupTodo", c.info.columns, "roomname=? and todoid=?", new String[] { paramString1, paramString2 }, null, null, null);
    if (paramString1 == null)
    {
      AppMethodBeat.o(182140);
      return null;
    }
    try
    {
      paramString2 = new ArrayList();
      while (paramString1.moveToNext())
      {
        c localc = new c();
        localc.convertFrom(paramString1);
        paramString2.add(localc);
      }
      i = paramString2.size();
    }
    finally
    {
      paramString1.close();
      AppMethodBeat.o(182140);
    }
    int i;
    if (i == 0)
    {
      paramString1.close();
      AppMethodBeat.o(182140);
      return null;
    }
    paramString2 = (c)paramString2.get(0);
    paramString1.close();
    AppMethodBeat.o(182140);
    return paramString2;
  }
  
  public final boolean f(c paramc)
  {
    AppMethodBeat.i(182139);
    if (paramc == null)
    {
      AppMethodBeat.o(182139);
      return false;
    }
    boolean bool = super.insert(paramc);
    AppMethodBeat.o(182139);
    return bool;
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(182141);
    if (paramc == null)
    {
      AppMethodBeat.o(182141);
      return false;
    }
    boolean bool = update(paramc.systemRowid, paramc);
    AppMethodBeat.o(182141);
    return bool;
  }
  
  public final boolean h(c paramc)
  {
    AppMethodBeat.i(182142);
    if (paramc == null)
    {
      AppMethodBeat.o(182142);
      return true;
    }
    if (paramc.systemRowid == -1L)
    {
      c localc = ag(paramc.field_roomname, paramc.field_todoid);
      if (localc == null)
      {
        AppMethodBeat.o(182142);
        return true;
      }
      paramc.systemRowid = localc.systemRowid;
    }
    boolean bool = delete(paramc.systemRowid);
    AppMethodBeat.o(182142);
    return bool;
  }
  
  public final c uP(String paramString)
  {
    AppMethodBeat.i(213428);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213428);
      return null;
    }
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and username=? and state!=?", new String[] { paramString, "roomannouncement@app.origin", "2" }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(213428);
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        c localc2 = new c();
        localc2.convertFrom(paramString);
        localArrayList.add(localc2);
      }
      i = localObject.size();
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(213428);
    }
    int i;
    if (i == 0)
    {
      paramString.close();
      AppMethodBeat.o(213428);
      return null;
    }
    c localc1 = (c)localObject.get(0);
    paramString.close();
    AppMethodBeat.o(213428);
    return localc1;
  }
  
  public final List<c> uQ(String paramString)
  {
    AppMethodBeat.i(182143);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    long l = cf.aCN();
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and createtime>=? AND state IN (0,1)", new String[] { paramString, l - fMe.longValue() }, null, null, "updatetime DESC limit 20");
    if (paramString == null)
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    try
    {
      c localc;
      if (paramString.moveToNext()) {
        localc = new c();
      }
      return localList;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(182143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.d
 * JD-Core Version:    0.7.0.1
 */