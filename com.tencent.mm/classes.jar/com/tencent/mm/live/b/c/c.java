package com.tencent.mm.live.b.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  public static Pair<String, Long> gxq;
  private static c gxr;
  public com.tencent.mm.sdk.e.e db;
  public a gxs;
  
  static
  {
    AppMethodBeat.i(192922);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(192922);
  }
  
  private c(h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(192912);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.vE(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ac.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    ac.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.qL(l2);
    ac.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(192912);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(192913);
    g.agS();
    g.agP().afT();
    if (gxr == null) {
      gxr = new c(g.agR().ghG);
    }
    c localc = gxr;
    AppMethodBeat.o(192913);
    return localc;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(192915);
    boolean bool = insert(paramb);
    if (this.gxs != null) {
      this.gxs.vc(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(192915);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(192916);
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
      if (this.gxs != null) {
        this.gxs.vc(paramString);
      }
      AppMethodBeat.o(192916);
      return bool;
    }
  }
  
  public final boolean alL()
  {
    AppMethodBeat.i(192921);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    ac.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(192921);
    return bool;
  }
  
  public final void pm(long paramLong)
  {
    AppMethodBeat.i(192917);
    Object localObject = "SELECT * FROM LiveTipsBar WHERE liveId = '" + paramLong + "'";
    ac.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", new Object[] { Long.valueOf(paramLong), localObject });
    Cursor localCursor = this.db.rawQuery((String)localObject, null);
    if (localCursor != null) {
      if (localCursor.moveToFirst())
      {
        localObject = new b();
        ((b)localObject).convertFrom(localCursor);
        localObject = ((b)localObject).field_hostRoomId;
        localCursor.close();
      }
    }
    for (;;)
    {
      int i = this.db.delete("LiveTipsBar", "liveId= ? ", new String[] { String.valueOf(paramLong) });
      if ((gxq != null) && (((Long)gxq.second).longValue() == paramLong)) {
        gxq = null;
      }
      if (i < 0) {
        ac.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
      }
      if ((localObject != null) && (this.gxs != null)) {
        this.gxs.vc((String)localObject);
      }
      AppMethodBeat.o(192917);
      return;
      localObject = null;
      break;
      localObject = null;
    }
  }
  
  public final void t(String paramString, long paramLong)
  {
    AppMethodBeat.i(192918);
    ac.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    gxq = new Pair(paramString, Long.valueOf(paramLong));
    if (this.gxs != null) {
      this.gxs.vc(paramString);
    }
    AppMethodBeat.o(192918);
  }
  
  public final LinkedList<b> uZ(String paramString)
  {
    AppMethodBeat.i(192914);
    LinkedList localLinkedList = new LinkedList();
    if ((gxq != null) && (((String)gxq.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + gxq.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      ac.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      ac.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(192914);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(192914);
    return localLinkedList;
  }
  
  public final void va(String paramString)
  {
    AppMethodBeat.i(192919);
    ac.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((gxq != null) && (((String)gxq.first).equals(paramString))) {
      gxq = null;
    }
    if (this.gxs != null) {
      this.gxs.vc(paramString);
    }
    AppMethodBeat.o(192919);
  }
  
  public final void vb(String paramString)
  {
    AppMethodBeat.i(192920);
    if ((gxq != null) && (((String)gxq.first).equals(paramString))) {
      gxq = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      ac.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(192920);
      return;
    }
    ac.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(192920);
  }
  
  public static abstract interface a
  {
    public abstract void vc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c.c
 * JD-Core Version:    0.7.0.1
 */