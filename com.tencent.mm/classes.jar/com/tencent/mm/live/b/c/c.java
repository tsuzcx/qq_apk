package com.tencent.mm.live.b.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  public static Pair<String, Long> gTJ;
  private static c gTK;
  public com.tencent.mm.sdk.e.e db;
  public a gTL;
  
  static
  {
    AppMethodBeat.i(220219);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "LiveTipsBar") };
    AppMethodBeat.o(220219);
  }
  
  private c(h paramh)
  {
    super(paramh, b.info, "LiveTipsBar", null);
    AppMethodBeat.i(220209);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.yi(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ae.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", new Object[] { "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )" });
    paramh.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
    ae.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.sW(l2);
    ae.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(220209);
  }
  
  public static c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(220210);
    g.ajS();
    g.ajP().aiU();
    if (gTK == null) {
      gTK = new c(g.ajR().gDX);
    }
    c localc = gTK;
    AppMethodBeat.o(220210);
    return localc;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(220212);
    boolean bool = insert(paramb);
    if (this.gTL != null) {
      this.gTL.yB(paramb.field_hostRoomId);
    }
    AppMethodBeat.o(220212);
    return bool;
  }
  
  public final boolean a(LinkedList<b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(220213);
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
      if (this.gTL != null) {
        this.gTL.yB(paramString);
      }
      AppMethodBeat.o(220213);
      return bool;
    }
  }
  
  public final boolean aoN()
  {
    AppMethodBeat.i(220218);
    boolean bool = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
    ae.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(220218);
    return bool;
  }
  
  public final void rA(long paramLong)
  {
    AppMethodBeat.i(220214);
    Object localObject1 = "SELECT * FROM LiveTipsBar WHERE liveId = '" + paramLong + "'";
    ae.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", new Object[] { Long.valueOf(paramLong), localObject1 });
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
      if ((gTJ != null) && (((Long)gTJ.second).longValue() == paramLong)) {
        gTJ = null;
      }
      if (i < 0)
      {
        ae.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", new Object[] { Integer.valueOf(i) });
        if ((localObject1 != null) && (this.gTL != null)) {
          this.gTL.yB((String)localObject1);
        }
        AppMethodBeat.o(220214);
        return;
      }
      if (localObject1 == null)
      {
        localObject2 = "";
        label224:
        if (this.gTL != null) {
          break label276;
        }
      }
      label276:
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.LiveTipsBarStorage", "deleteByLiveId success, liveId:%d, hostRoomId:%s, liveTipsBarNotify null:%b", new Object[] { Long.valueOf(paramLong), localObject2, Boolean.valueOf(bool) });
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
    AppMethodBeat.i(220215);
    ae.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", new Object[] { Long.valueOf(paramLong) });
    gTJ = new Pair(paramString, Long.valueOf(paramLong));
    if (this.gTL != null) {
      this.gTL.yB(paramString);
    }
    AppMethodBeat.o(220215);
  }
  
  public final void yA(String paramString)
  {
    AppMethodBeat.i(220217);
    if ((gTJ != null) && (((String)gTJ.first).equals(paramString))) {
      gTJ = null;
    }
    int i = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[] { paramString });
    if (i < 0)
    {
      ae.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(220217);
      return;
    }
    ae.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(220217);
  }
  
  public final LinkedList<b> yy(String paramString)
  {
    AppMethodBeat.i(220211);
    LinkedList localLinkedList = new LinkedList();
    if ((gTJ != null) && (((String)gTJ.first).equals(paramString))) {}
    for (Object localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' AND liveId != '" + gTJ.second + "' ORDER BY timeStamp";; localObject = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + paramString + "' ORDER BY timeStamp")
    {
      ae.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", new Object[] { localObject });
      localObject = this.db.rawQuery((String)localObject, null);
      if (localObject != null) {
        break;
      }
      ae.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", new Object[] { paramString });
      AppMethodBeat.o(220211);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      paramString = new b();
      paramString.convertFrom((Cursor)localObject);
      localLinkedList.add(paramString);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(220211);
    return localLinkedList;
  }
  
  public final void yz(String paramString)
  {
    AppMethodBeat.i(220216);
    ae.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
    if ((gTJ != null) && (((String)gTJ.first).equals(paramString))) {
      gTJ = null;
    }
    if (this.gTL != null) {
      this.gTL.yB(paramString);
    }
    AppMethodBeat.o(220216);
  }
  
  public static abstract interface a
  {
    public abstract void yB(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c.c
 * JD-Core Version:    0.7.0.1
 */