package com.tencent.mm.live.b.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class b
  extends j<a>
{
  private static long DKr;
  public static final String[] SQL_CREATE;
  public a Fwx;
  public e db;
  
  static
  {
    AppMethodBeat.i(203922);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "LiveTipsBar") };
    DKr = 0L;
    AppMethodBeat.o(203922);
  }
  
  public b(h paramh)
  {
    super(paramh, a.info, "LiveTipsBar", null);
    AppMethodBeat.i(203916);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.rb(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ad.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    ad.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.mX(l2);
    ad.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(203916);
  }
  
  public final void Bj(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(203919);
    Object localObject3 = "SELECT * FROM LiveTipsBar WHERE liveId = '" + paramLong + "'";
    ad.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", new Object[] { Long.valueOf(paramLong), localObject3 });
    localObject3 = this.db.rawQuery((String)localObject3, null);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new a();
        ((a)localObject1).convertFrom((Cursor)localObject3);
        localObject1 = ((a)localObject1).field_hostRoomId;
      }
      ((Cursor)localObject3).close();
    }
    int i = this.db.delete("LiveTipsBar", "liveId= ? ", new String[] { String.valueOf(paramLong) });
    if (i < 0)
    {
      ad.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(203919);
      return;
    }
    if ((localObject1 != null) && (this.Fwx != null)) {
      this.Fwx.aUu((String)localObject1);
    }
    AppMethodBeat.o(203919);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(203918);
    boolean bool = insert(parama);
    if (this.Fwx != null) {
      this.Fwx.aUu(parama.field_hostRoomId);
    }
    AppMethodBeat.o(203918);
    return bool;
  }
  
  public final LinkedList<a> aUt(String paramString)
  {
    AppMethodBeat.i(203917);
    LinkedList localLinkedList = new LinkedList();
    if (DKr == 0L) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + DKr + "' ORDER BY timeStamp")
    {
      ad.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(203917);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new a();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(203917);
    return localLinkedList;
  }
  
  public final boolean cWA()
  {
    AppMethodBeat.i(203921);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    ad.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(203921);
    return bool;
  }
  
  public final void ci(String paramString, long paramLong)
  {
    AppMethodBeat.i(203920);
    ad.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    DKr = paramLong;
    this.Fwx.aUu(paramString);
    AppMethodBeat.o(203920);
  }
  
  public static abstract interface a
  {
    public abstract void aUu(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.c.b
 * JD-Core Version:    0.7.0.1
 */