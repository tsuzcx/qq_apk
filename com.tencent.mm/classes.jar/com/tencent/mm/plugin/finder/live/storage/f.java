package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.a.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.c.co;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import kotlin.g.b.p;

public class f
  extends com.tencent.c.a.a.a.d.f
{
  private final ISQLiteDatabase db;
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.access$getInfo$cp(), "FinderLiveNotifyExposureInfo", co.INDEX_CREATE);
    AppMethodBeat.i(233642);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(233642);
  }
  
  public final void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(233654);
    e locale = Lv(paramLong);
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "updateLiveStatus ,msgId = " + paramLong + ", liveStatus = " + paramInt);
    if (locale.systemRowid != -1L)
    {
      locale.field_liveStatus = paramInt;
      updateNotify(locale, false, null);
    }
    AppMethodBeat.o(233654);
  }
  
  public final void Lt(long paramLong)
  {
    AppMethodBeat.i(233647);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(233647);
      return;
    }
    e locale = Lv(paramLong);
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onFinderNotifyExpose ,msgId = " + paramLong + ", rowId = " + locale.systemRowid);
    if (locale.systemRowid != -1L)
    {
      locale.field_exposureStatus = 1;
      updateNotify(locale, false, null);
    }
    AppMethodBeat.o(233647);
  }
  
  public final boolean Lu(long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(233658);
    e locale = Lv(paramLong);
    if (locale.systemRowid != -1L) {
      bool = deleteNotify(locale.systemRowid, false);
    }
    AppMethodBeat.o(233658);
    return bool;
  }
  
  public final e Lv(long paramLong)
  {
    AppMethodBeat.i(233664);
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where msgId = ".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null);
    e locale = new e();
    locale.field_msgId = paramLong;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locale.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(233664);
    return locale;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(233644);
    e locale = aCL(parame.field_liveId);
    if (locale.systemRowid == -1L)
    {
      boolean bool = insertNotify(parame, false);
      Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onReceiveFinderNotify insert " + bool + " liveID " + parame.field_liveId + " field_tipsId " + parame.field_tipsId + "field_revokeId " + parame.field_revokeId + " msgid " + parame.field_msgId);
      AppMethodBeat.o(233644);
      return;
    }
    Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "onReceiveFinderNotify already insert msgId = " + parame.field_msgId + " info.systemRowid " + locale.systemRowid);
    AppMethodBeat.o(233644);
  }
  
  public final e aCK(String paramString)
  {
    AppMethodBeat.i(233651);
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where revokeId = '" + paramString + "'";
    localObject = this.db.rawQuery((String)localObject, null);
    e locale = new e();
    locale.field_revokeId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locale.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(233651);
    return locale;
  }
  
  public final e aCL(String paramString)
  {
    AppMethodBeat.i(233653);
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where liveId = '" + paramString + "'";
    localObject = this.db.rawQuery((String)localObject, null);
    e locale = new e();
    locale.field_liveId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locale.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(233653);
    return locale;
  }
  
  public final long dDP()
  {
    AppMethodBeat.i(233657);
    Cursor localCursor = this.db.rawQuery("select *, rowid from FinderLiveNotifyExposureInfo where exposureStatus = 0 and liveStatus = 0 ORDER BY rowid", null);
    Object localObject;
    if (localCursor != null)
    {
      e locale = null;
      localObject = locale;
      if (localCursor.moveToNext())
      {
        locale = new e();
        locale.convertFrom(localCursor);
        localObject = aj.AGc;
        p.k(locale, "info");
        int i;
        if (locale.systemRowid != -1L)
        {
          i = 1;
          label83:
          if (i == 0) {
            break label147;
          }
          localObject = locale;
          label91:
          if (localObject == null) {
            break label153;
          }
        }
        label147:
        label153:
        for (boolean bool = d.dr(((e)localObject).field_controlFlag, 2);; bool = false)
        {
          localObject = locale;
          if (!bool) {
            break label158;
          }
          Log.i("MicroMsg.FinderLiveNotifyExposureInfoStorage", "this info can not be replace : " + locale.field_liveId);
          break;
          i = 0;
          break label83;
          localObject = null;
          break label91;
        }
      }
      label158:
      localCursor.close();
    }
    for (;;)
    {
      if ((localObject != null) && (((e)localObject).systemRowid != -1L))
      {
        long l = ((e)localObject).field_msgId;
        AppMethodBeat.o(233657);
        return l;
      }
      AppMethodBeat.o(233657);
      return -1L;
      localObject = null;
    }
  }
  
  public final boolean dDQ()
  {
    AppMethodBeat.i(233661);
    this.db.rawQuery("delete from FinderLiveNotifyExposureInfo", null);
    AppMethodBeat.o(233661);
    return false;
  }
  
  public final ArrayList<e> dDR()
  {
    AppMethodBeat.i(233666);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select *, rowid from FinderLiveNotifyExposureInfo where insertTime > " + (cm.bfF() - 172800);
    localObject = this.db.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      e locale = new e();
      locale.convertFrom((Cursor)localObject);
      localArrayList.add(locale);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(233666);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.f
 * JD-Core Version:    0.7.0.1
 */