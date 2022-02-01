package com.tencent.mm.live.b.c;

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
  public static Pair<String, Long> kyx;
  private static c kyy;
  public ISQLiteDatabase db;
  public a kyz;
  
  static
  {
    AppMethodBeat.i(254219);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(254219);
  }
  
  public c(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(254199);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    Log.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    Log.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.endTransaction(l2);
    Log.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(254199);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(254202);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    if (kyy == null) {
      kyy = new c(com.tencent.mm.kernel.h.aHG().kcF);
    }
    c localc = kyy;
    AppMethodBeat.o(254202);
    return localc;
  }
  
  public final void FM(long paramLong)
  {
    AppMethodBeat.i(254207);
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
      if ((kyx != null) && (((Long)kyx.second).longValue() == paramLong)) {
        kyx = null;
      }
      if (i < 0)
      {
        Log.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
        if ((localObject1 != null) && (this.kyz != null)) {
          this.kyz.Ol((String)localObject1);
        }
        AppMethodBeat.o(254207);
        return;
      }
      if (localObject1 == null)
      {
        localObject2 = "";
        label222:
        if (this.kyz != null) {
          break label273;
        }
      }
      label273:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.LiveTipsBarStorage", "deleteByLiveId success, liveId:%d, hostRoomId:%s, liveTipsBarNotify null:%b", new Object[] { Long.valueOf(paramLong), localObject2, Boolean.valueOf(bool) });
        break;
        localObject2 = localObject1;
        break label222;
      }
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public final LinkedList<b> Oi(String paramString)
  {
    AppMethodBeat.i(254203);
    LinkedList localLinkedList = new LinkedList();
    if ((kyx != null) && (((String)kyx.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + kyx.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      Log.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(254203);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(254203);
    return localLinkedList;
  }
  
  public final void Oj(String paramString)
  {
    AppMethodBeat.i(254209);
    Log.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((kyx != null) && (((String)kyx.first).equals(paramString))) {
      kyx = null;
    }
    if (this.kyz != null) {
      this.kyz.Ol(paramString);
    }
    AppMethodBeat.o(254209);
  }
  
  public final void Ok(String paramString)
  {
    AppMethodBeat.i(254213);
    if ((kyx != null) && (((String)kyx.first).equals(paramString))) {
      kyx = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(254213);
      return;
    }
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(254213);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(254205);
    boolean bool = insert(paramb);
    if (this.kyz != null) {
      this.kyz.Ol(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(254205);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(254206);
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
      if (this.kyz != null) {
        this.kyz.Ol(paramString);
      }
      AppMethodBeat.o(254206);
      return bool;
    }
  }
  
  public final boolean aPo()
  {
    AppMethodBeat.i(254216);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    Log.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(254216);
    return bool;
  }
  
  public final void t(String paramString, long paramLong)
  {
    AppMethodBeat.i(254208);
    Log.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    kyx = new Pair(paramString, Long.valueOf(paramLong));
    if (this.kyz != null) {
      this.kyz.Ol(paramString);
    }
    AppMethodBeat.o(254208);
  }
  
  public static abstract interface a
  {
    public abstract void Ol(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c.c
 * JD-Core Version:    0.7.0.1
 */