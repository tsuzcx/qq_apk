package com.tencent.mm.live.b.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  public static Pair<String, Long> gRb;
  private static c gRc;
  public com.tencent.mm.sdk.e.e db;
  public a gRd;
  
  static
  {
    AppMethodBeat.i(195651);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(195651);
  }
  
  private c(h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(195641);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.xO(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ad.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    ad.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.sJ(l2);
    ad.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(195641);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(195642);
    g.ajD();
    g.ajA().aiF();
    if (gRc == null) {
      gRc = new c(g.ajC().gBq);
    }
    c localc = gRc;
    AppMethodBeat.o(195642);
    return localc;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(195644);
    boolean bool = insert(paramb);
    if (this.gRd != null) {
      this.gRd.xS(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(195644);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(195645);
    paramLinkedList = paramLinkedList.iterator();
    boolean bool = true;
    if (paramLinkedList.hasNext())
    {
      if (insert((b)paramLinkedList.next())) {
        break label66;
      }
      bool = false;
    }
    label66:
    for (;;)
    {
      break;
      if (this.gRd != null) {
        this.gRd.xS(paramString);
      }
      AppMethodBeat.o(195645);
      return bool;
    }
  }
  
  public final boolean aoy()
  {
    AppMethodBeat.i(195650);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    ad.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(195650);
    return bool;
  }
  
  public final void rn(long paramLong)
  {
    AppMethodBeat.i(195646);
    Object localObject1 = "SELECT * FROM LiveTipsBar WHERE liveId = '" + paramLong + "'";
    ad.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", new Object[] { Long.valueOf(paramLong), localObject1 });
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
      if ((gRb != null) && (((Long)gRb.second).longValue() == paramLong)) {
        gRb = null;
      }
      if (i < 0)
      {
        ad.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
        if ((localObject1 != null) && (this.gRd != null)) {
          this.gRd.xS((String)localObject1);
        }
        AppMethodBeat.o(195646);
        return;
      }
      if (localObject1 == null)
      {
        localObject2 = "";
        label224:
        if (this.gRd != null) {
          break label276;
        }
      }
      label276:
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.LiveTipsBarStorage", "deleteByLiveId success, liveId:%d, hostRoomId:%s, liveTipsBarNotify null:%b", new Object[] { Long.valueOf(paramLong), localObject2, Boolean.valueOf(bool) });
        break;
        localObject2 = localObject1;
        break label224;
      }
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public final void v(String paramString, long paramLong)
  {
    AppMethodBeat.i(195647);
    ad.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    gRb = new Pair(paramString, Long.valueOf(paramLong));
    if (this.gRd != null) {
      this.gRd.xS(paramString);
    }
    AppMethodBeat.o(195647);
  }
  
  public final LinkedList<b> xP(String paramString)
  {
    AppMethodBeat.i(195643);
    LinkedList localLinkedList = new LinkedList();
    if ((gRb != null) && (((String)gRb.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + gRb.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      ad.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(195643);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(195643);
    return localLinkedList;
  }
  
  public final void xQ(String paramString)
  {
    AppMethodBeat.i(195648);
    ad.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((gRb != null) && (((String)gRb.first).equals(paramString))) {
      gRb = null;
    }
    if (this.gRd != null) {
      this.gRd.xS(paramString);
    }
    AppMethodBeat.o(195648);
  }
  
  public final void xR(String paramString)
  {
    AppMethodBeat.i(195649);
    if ((gRb != null) && (((String)gRb.first).equals(paramString))) {
      gRb = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      ad.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(195649);
      return;
    }
    ad.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(195649);
  }
  
  public static abstract interface a
  {
    public abstract void xS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c.c
 * JD-Core Version:    0.7.0.1
 */