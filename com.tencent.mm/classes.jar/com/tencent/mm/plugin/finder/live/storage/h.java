package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.d.a.a.a.d.a.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cv;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;

public class h
  extends com.tencent.d.a.a.a.d.h
{
  private final ISQLiteDatabase db;
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.access$getInfo$cp(), "FinderLiveNotifyExposureInfo", cv.INDEX_CREATE);
    AppMethodBeat.i(351379);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(351379);
  }
  
  public final void V(long paramLong, int paramInt)
  {
    AppMethodBeat.i(351432);
    g localg = oC(paramLong);
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "updateLiveStatus ,msgId = " + paramLong + ", liveStatus = " + paramInt);
    if (localg.systemRowid != -1L)
    {
      localg.field_liveStatus = paramInt;
      updateNotify(localg, false, null);
    }
    AppMethodBeat.o(351432);
  }
  
  public final void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(351398);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramg.field_liveId;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject1 = new g();
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        ((g)localObject1).field_exposureStatus = 1;
      }
      if (((g)localObject1).systemRowid != -1L) {
        break;
      }
      paramBoolean = insertNotify(paramg, false);
      Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onReceiveFinderNotify insert " + paramBoolean + " liveID " + paramg.field_liveId + " field_tipsId " + paramg.field_tipsId + "field_revokeId " + paramg.field_revokeId + " msgid " + paramg.field_msgId);
      AppMethodBeat.o(351398);
      return;
      Object localObject2 = "select *, rowid from FinderLiveNotifyExposureInfo where liveId = '" + (String)localObject1 + "'";
      Cursor localCursor = this.db.rawQuery((String)localObject2, null);
      localObject2 = new g();
      ((g)localObject2).field_liveId = ((String)localObject1);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        if (localCursor.moveToFirst()) {
          ((g)localObject2).convertFrom(localCursor);
        }
        localCursor.close();
        localObject1 = localObject2;
        continue;
        localObject1 = axL(paramg.field_revokeId);
      }
    }
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onReceiveFinderNotify already insert msgId = " + paramg.field_msgId + " info.systemRowid " + ((g)localObject1).systemRowid);
    AppMethodBeat.o(351398);
  }
  
  public final g axL(String paramString)
  {
    AppMethodBeat.i(351422);
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where revokeId = '" + paramString + "'";
    localObject = this.db.rawQuery((String)localObject, null);
    g localg = new g();
    localg.field_revokeId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localg.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(351422);
    return localg;
  }
  
  public final long etZ()
  {
    Object localObject = null;
    AppMethodBeat.i(351442);
    Cursor localCursor = this.db.rawQuery("select *, rowid from FinderLiveNotifyExposureInfo where exposureStatus = 0 and liveStatus = 0 ORDER BY rowid", null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        g localg = new g();
        localg.convertFrom(localCursor);
        localObject = localg;
        if (!((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(localg)) {
          break;
        }
        Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "this info can not be replace : " + localg.field_liveId);
        localObject = localg;
      }
      localCursor.close();
    }
    for (;;)
    {
      if ((localObject != null) && (localObject.systemRowid != -1L))
      {
        long l = localObject.field_msgId;
        AppMethodBeat.o(351442);
        return l;
      }
      AppMethodBeat.o(351442);
      return -1L;
      localObject = null;
    }
  }
  
  public final boolean eua()
  {
    AppMethodBeat.i(351462);
    this.db.rawQuery("delete from FinderLiveNotifyExposureInfo", null);
    AppMethodBeat.o(351462);
    return false;
  }
  
  public final ArrayList<g> eub()
  {
    AppMethodBeat.i(351474);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where insertTime > " + (cn.getSyncServerTimeSecond() - 172800);
    localObject = this.db.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      g localg = new g();
      localg.convertFrom((Cursor)localObject);
      localArrayList.add(localg);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(351474);
    return localArrayList;
  }
  
  public final void oA(long paramLong)
  {
    AppMethodBeat.i(351409);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(351409);
      return;
    }
    g localg = oC(paramLong);
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onFinderNotifyExpose ,msgId = " + paramLong + ", rowId = " + localg.systemRowid);
    if (localg.systemRowid != -1L)
    {
      localg.field_exposureStatus = 1;
      updateNotify(localg, false, null);
    }
    AppMethodBeat.o(351409);
  }
  
  public final boolean oB(long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(351455);
    g localg = oC(paramLong);
    if (localg.systemRowid != -1L) {
      bool = deleteNotify(localg.systemRowid, false);
    }
    AppMethodBeat.o(351455);
    return bool;
  }
  
  public final g oC(long paramLong)
  {
    AppMethodBeat.i(351467);
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where msgId = ".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null);
    g localg = new g();
    localg.field_msgId = paramLong;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localg.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(351467);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.h
 * JD-Core Version:    0.7.0.1
 */