package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends j<c>
  implements n.b
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final Long fOi;
  private e db;
  
  static
  {
    AppMethodBeat.i(182146);
    fOi = Long.valueOf(604800000L);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "GroupTodo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS todoIdIndex ON GroupTodo ( todoid )", "CREATE INDEX IF NOT EXISTS todoIdRoomNameIndex ON GroupTodo ( todoid,roomname )", "CREATE INDEX IF NOT EXISTS roomNameIndex ON GroupTodo ( roomname )" };
    AppMethodBeat.o(182146);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "GroupTodo", INDEX_CREATE);
    this.db = parame;
  }
  
  public final void a(int paramInt, n paramn, final Object paramObject)
  {
    AppMethodBeat.i(217144);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(217144);
      return;
    }
    paramObject = (String)paramObject;
    if ((paramInt == 5) && ((paramn instanceof br)))
    {
      ae.i("MicroMsg.roomTodo.GroupTodoStorage", "delete, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217141);
          ae.i("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange delete expire data : %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().vm(paramObject)) });
          AppMethodBeat.o(217141);
        }
      });
    }
    AppMethodBeat.o(217144);
  }
  
  public final c ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182140);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
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
  
  public final c vk(String paramString)
  {
    AppMethodBeat.i(217142);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217142);
      return null;
    }
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and username=? and state!=?", new String[] { paramString, "roomannouncement@app.origin", "2" }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(217142);
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
      AppMethodBeat.o(217142);
    }
    int i;
    if (i == 0)
    {
      paramString.close();
      AppMethodBeat.o(217142);
      return null;
    }
    c localc1 = (c)localObject.get(0);
    paramString.close();
    AppMethodBeat.o(217142);
    return localc1;
  }
  
  public final List<c> vl(String paramString)
  {
    AppMethodBeat.i(182143);
    ArrayList localArrayList = new ArrayList();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    long l = ch.aDd();
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and createtime>=? AND state IN (0,1)", new String[] { paramString, l - fOi.longValue() }, null, null, "updatetime DESC limit 20");
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
  
  public final boolean vm(String paramString)
  {
    AppMethodBeat.i(217143);
    try
    {
      i = this.db.delete("GroupTodo", "createtime<? and username=?", new String[] { ch.aDb() - fOi.longValue(), paramString });
      if (i > 0)
      {
        AppMethodBeat.o(217143);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.roomTodo.GroupTodoStorage", "deleteExpireData Exception：[%s %s]", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        int i = 0;
      }
      AppMethodBeat.o(217143);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.d
 * JD-Core Version:    0.7.0.1
 */