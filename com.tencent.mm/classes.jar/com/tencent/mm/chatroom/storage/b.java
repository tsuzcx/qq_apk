package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final Long ftn;
  private e db;
  
  static
  {
    AppMethodBeat.i(182146);
    ftn = Long.valueOf(604800000L);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "GroupTodo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS todoIdIndex ON GroupTodo ( todoid )", "CREATE INDEX IF NOT EXISTS todoIdRoomNameIndex ON GroupTodo ( todoid,roomname )", "CREATE INDEX IF NOT EXISTS roomNameIndex ON GroupTodo ( roomname )" };
    AppMethodBeat.o(182146);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "GroupTodo", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean VV()
  {
    AppMethodBeat.i(182144);
    try
    {
      i = this.db.delete("GroupTodo", "createtime<?", new String[] { ce.azI() - ftn.longValue() });
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
        ac.e("MicroMsg.roomTodo.GroupTodoStorage", "deleteExpireData  Exception：[%s %s]", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        int i = 0;
      }
      AppMethodBeat.o(182144);
    }
    return false;
  }
  
  public final a af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182140);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(182140);
      return null;
    }
    paramString1 = this.db.query("GroupTodo", a.info.columns, "roomname=? and todoid=?", new String[] { paramString1, paramString2 }, null, null, null);
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
        a locala = new a();
        locala.convertFrom(paramString1);
        paramString2.add(locala);
      }
      i = paramString2.size();
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
      AppMethodBeat.o(182140);
    }
    int i;
    if (i == 0)
    {
      if (paramString1 != null) {
        paramString1.close();
      }
      AppMethodBeat.o(182140);
      return null;
    }
    paramString2 = (a)paramString2.get(0);
    if (paramString1 != null) {
      paramString1.close();
    }
    AppMethodBeat.o(182140);
    return paramString2;
  }
  
  public final boolean f(a parama)
  {
    AppMethodBeat.i(182139);
    if (parama == null)
    {
      AppMethodBeat.o(182139);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(182139);
    return bool;
  }
  
  public final boolean g(a parama)
  {
    AppMethodBeat.i(182141);
    if (parama == null)
    {
      AppMethodBeat.o(182141);
      return false;
    }
    boolean bool = update(parama.systemRowid, parama);
    AppMethodBeat.o(182141);
    return bool;
  }
  
  public final boolean h(a parama)
  {
    AppMethodBeat.i(182142);
    if (parama == null)
    {
      AppMethodBeat.o(182142);
      return true;
    }
    if (parama.systemRowid == -1L)
    {
      a locala = af(parama.field_roomname, parama.field_todoid);
      if (locala == null)
      {
        AppMethodBeat.o(182142);
        return true;
      }
      parama.systemRowid = locala.systemRowid;
    }
    boolean bool = delete(parama.systemRowid);
    AppMethodBeat.o(182142);
    return bool;
  }
  
  public final List<a> sa(String paramString)
  {
    AppMethodBeat.i(182143);
    ArrayList localArrayList = new ArrayList();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    long l = ce.azK();
    paramString = this.db.query("GroupTodo", a.info.columns, "roomname=? and createtime>=? AND state IN (0,1)", new String[] { paramString, l - ftn.longValue() }, null, null, "updatetime DESC limit 20");
    if (paramString == null)
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    try
    {
      a locala;
      if (paramString.moveToNext()) {
        locala = new a();
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
 * Qualified Name:     com.tencent.mm.chatroom.storage.b
 * JD-Core Version:    0.7.0.1
 */