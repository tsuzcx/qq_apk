package com.tencent.mm.live.b.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  public static Pair<String, Long> hLd;
  private static c hLe;
  public ISQLiteDatabase db;
  public a hLf;
  
  static
  {
    AppMethodBeat.i(224112);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(224112);
  }
  
  private c(h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(224102);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    Log.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    Log.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.endTransaction(l2);
    Log.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(224102);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(224103);
    g.aAi();
    g.aAf().azk();
    if (hLe == null) {
      hLe = new c(g.aAh().hqK);
    }
    c localc = hLe;
    AppMethodBeat.o(224103);
    return localc;
  }
  
  public final LinkedList<b> GX(String paramString)
  {
    AppMethodBeat.i(224104);
    LinkedList localLinkedList = new LinkedList();
    if ((hLd != null) && (((String)hLd.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + hLd.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      Log.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(224104);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(224104);
    return localLinkedList;
  }
  
  public final void GY(String paramString)
  {
    AppMethodBeat.i(224109);
    Log.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((hLd != null) && (((String)hLd.first).equals(paramString))) {
      hLd = null;
    }
    if (this.hLf != null) {
      this.hLf.Ha(paramString);
    }
    AppMethodBeat.o(224109);
  }
  
  public final void GZ(String paramString)
  {
    AppMethodBeat.i(224110);
    if ((hLd != null) && (((String)hLd.first).equals(paramString))) {
      hLd = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(224110);
      return;
    }
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(224110);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(224105);
    boolean bool = insert(paramb);
    if (this.hLf != null) {
      this.hLf.Ha(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(224105);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(224106);
    paramLinkedList = paramLinkedList.iterator();
    boolean bool = true;
    if (paramLinkedList.hasNext())
    {
      if (insert((b)paramLinkedList.next())) {
        break label68;
      }
      bool = false;
    }
    label68:
    for (;;)
    {
      break;
      if (this.hLf != null) {
        this.hLf.Ha(paramString);
      }
      AppMethodBeat.o(224106);
      return bool;
    }
  }
  
  public final boolean aHo()
  {
    AppMethodBeat.i(224111);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(224111);
    return bool;
  }
  
  public final void w(String paramString, long paramLong)
  {
    AppMethodBeat.i(224108);
    Log.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    hLd = new Pair(paramString, Long.valueOf(paramLong));
    if (this.hLf != null) {
      this.hLf.Ha(paramString);
    }
    AppMethodBeat.o(224108);
  }
  
  public final void zF(long paramLong)
  {
    AppMethodBeat.i(224107);
    Object localObject1 = "SELECT * FROM LiveTipsBar WHERE liveId = '" + paramLong + "'";
    Log.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", new Object[] { Long.valueOf(paramLong), localObject1 });
    Object localObject2 = this.db.rawQuery((String)localObject1, null);
    if (localObject2 != null) {
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new b();
        ((b)localObject1).convertFrom((Cursor)localObject2);
        localObject1 = ((b)localObject1).field_hostRoomId;
        ((Cursor)localObject2).close();
      }
    }
    for (;;)
    {
      int i = this.db.delete("LiveTipsBar", "liveId= ? ", new String[] { String.valueOf(paramLong) });
      if ((hLd != null) && (((Long)hLd.second).longValue() == paramLong)) {
        hLd = null;
      }
      if (i < 0)
      {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
        if ((localObject1 != null) && (this.hLf != null)) {
          this.hLf.Ha((String)localObject1);
        }
        AppMethodBeat.o(224107);
        return;
      }
      if (localObject1 == null)
      {
        localObject2 = "";
        label230:
        if (this.hLf != null) {
          break label282;
        }
      }
      label282:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.LiveTipsBarStorage", "deleteByLiveId success, liveId:%d, hostRoomId:%s, liveTipsBarNotify null:%b", new Object[] { Long.valueOf(paramLong), localObject2, Boolean.valueOf(bool) });
        break;
        localObject2 = localObject1;
        break label230;
      }
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ha(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c.c
 * JD-Core Version:    0.7.0.1
 */