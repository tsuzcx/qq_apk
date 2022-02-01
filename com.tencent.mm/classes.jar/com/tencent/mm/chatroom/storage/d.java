package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends MAutoStorage<c>
  implements MStorageEx.IOnStorageChange
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final Long gtt;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(182146);
    gtt = Long.valueOf(604800000L);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "GroupTodo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS todoIdIndex ON GroupTodo ( todoid )", "CREATE INDEX IF NOT EXISTS todoIdRoomNameIndex ON GroupTodo ( todoid,roomname )", "CREATE INDEX IF NOT EXISTS roomNameIndex ON GroupTodo ( roomname )" };
    AppMethodBeat.o(182146);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "GroupTodo", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final c DB(String paramString)
  {
    AppMethodBeat.i(194056);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194056);
      return null;
    }
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and username=? and state!=?", new String[] { paramString, "roomannouncement@app.origin", "2" }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(194056);
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
      AppMethodBeat.o(194056);
    }
    int i;
    if (i == 0)
    {
      paramString.close();
      AppMethodBeat.o(194056);
      return null;
    }
    c localc1 = (c)localObject.get(0);
    paramString.close();
    AppMethodBeat.o(194056);
    return localc1;
  }
  
  public final List<c> DC(String paramString)
  {
    AppMethodBeat.i(182143);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182143);
      return localArrayList;
    }
    long l = cl.aWB();
    paramString = this.db.query("GroupTodo", c.info.columns, "roomname=? and createtime>=? AND state IN (0,1)", new String[] { paramString, l - gtt.longValue() }, null, null, "updatetime DESC limit 20");
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
  
  public final boolean DD(String paramString)
  {
    AppMethodBeat.i(194057);
    try
    {
      i = this.db.delete("GroupTodo", "createtime<? and username=?", new String[] { cl.aWz() - gtt.longValue(), paramString });
      if (i > 0)
      {
        AppMethodBeat.o(194057);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.roomTodo.GroupTodoStorage", "deleteExpireData Exception：[%s %s]", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        int i = 0;
      }
      AppMethodBeat.o(194057);
    }
    return false;
  }
  
  public final c ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182140);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
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
      c localc = ai(paramc.field_roomname, paramc.field_todoid);
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
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(194058);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(194058);
      return;
    }
    paramObject = (String)paramObject;
    if ((paramInt == 5) && ((paramMStorageEx instanceof bw)))
    {
      Log.i("MicroMsg.roomTodo.GroupTodoStorage", "delete, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194055);
          Log.i("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange delete expire data : %s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DD(paramObject)) });
          AppMethodBeat.o(194055);
        }
      });
    }
    AppMethodBeat.o(194058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.d
 * JD-Core Version:    0.7.0.1
 */