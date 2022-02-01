package com.tencent.mm.live.model.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;

public class c
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  public static Pair<String, Long> nbU;
  private static c nbV;
  public ISQLiteDatabase db;
  public a nbW;
  
  static
  {
    AppMethodBeat.i(246784);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(246784);
  }
  
  private c(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(246771);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    Log.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    Log.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.endTransaction(l2);
    Log.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(246771);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(246778);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    if (nbV == null) {
      nbV = new c(com.tencent.mm.kernel.h.baE().mCN);
    }
    c localc = nbV;
    AppMethodBeat.o(246778);
    return localc;
  }
  
  public final LinkedList<b> Gv(String paramString)
  {
    AppMethodBeat.i(246795);
    LinkedList localLinkedList = new LinkedList();
    if ((nbU != null) && (((String)nbU.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + nbU.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      Log.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(246795);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(246795);
    return localLinkedList;
  }
  
  public final void Gw(String paramString)
  {
    AppMethodBeat.i(246819);
    Log.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((nbU != null) && (((String)nbU.first).equals(paramString))) {
      nbU = null;
    }
    if (this.nbW != null) {
      this.nbW.Gy(paramString);
    }
    AppMethodBeat.o(246819);
  }
  
  public final void Gx(String paramString)
  {
    AppMethodBeat.i(246821);
    if ((nbU != null) && (((String)nbU.first).equals(paramString))) {
      nbU = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(246821);
      return;
    }
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(246821);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(246802);
    boolean bool = insert(paramb);
    if (this.nbW != null) {
      this.nbW.Gy(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(246802);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(246807);
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
      if (this.nbW != null) {
        this.nbW.Gy(paramString);
      }
      AppMethodBeat.o(246807);
      return bool;
    }
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(246827);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(246827);
    return bool;
  }
  
  public final void hT(long paramLong)
  {
    AppMethodBeat.i(246812);
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
      if ((nbU != null) && (((Long)nbU.second).longValue() == paramLong)) {
        nbU = null;
      }
      if (i < 0)
      {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
        if ((localObject1 != null) && (this.nbW != null)) {
          this.nbW.Gy((String)localObject1);
        }
        AppMethodBeat.o(246812);
        return;
      }
      if (localObject1 == null)
      {
        localObject2 = "";
        label230:
        if (this.nbW != null) {
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
  
  public final void u(String paramString, long paramLong)
  {
    AppMethodBeat.i(246816);
    Log.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    nbU = new Pair(paramString, Long.valueOf(paramLong));
    if (this.nbW != null) {
      this.nbW.Gy(paramString);
    }
    AppMethodBeat.o(246816);
  }
  
  public static abstract interface a
  {
    public abstract void Gy(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.model.c.c
 * JD-Core Version:    0.7.0.1
 */