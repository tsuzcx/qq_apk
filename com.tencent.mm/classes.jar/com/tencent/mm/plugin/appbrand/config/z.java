package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pm;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class z
  extends x
{
  public z(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    AppMethodBeat.i(44905);
    Cursor localCursor;
    if (bLz())
    {
      paramISQLiteDatabase = (ISQLiteDatabaseEx)paramISQLiteDatabase;
      if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vmr, false))
      {
        Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
        localCursor = paramISQLiteDatabase.rawQuery("select appInfo from WxaAttributesTable", null, 2);
        if ((localCursor == null) || (localCursor.isClosed()))
        {
          Log.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
          AppMethodBeat.o(44905);
          return;
        }
        if (!localCursor.moveToFirst()) {
          break label367;
        }
        Object localObject1 = new LinkedList();
        Object localObject2 = localCursor.getString(0);
        if (!Util.isNullOrNil((String)localObject2)) {}
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2);
            localObject2 = ((JSONObject)localObject3).optString("Appid");
            localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
            if (!Util.isNullOrNil((String)localObject2))
            {
              boolean bool = Util.isNullOrNil((String)localObject3);
              if (!bool) {
                continue;
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject3;
            long l;
            ContentValues localContentValues;
            continue;
            paramISQLiteDatabase.endTransaction(l);
            Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = paramISQLiteDatabase.beginTransaction(Thread.currentThread().getId());
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (Pair)((Iterator)localObject1).next();
          paramISQLiteDatabase.update("WxaAttributesTable", (ContentValues)((Pair)localObject2).second, "appId=?", new String[] { (String)((Pair)localObject2).first });
          continue;
          localContentValues = new ContentValues(1);
          localContentValues.put("roundedSquareIconURL", (String)localObject3);
          ((List)localObject1).add(Pair.create(localObject2, localContentValues));
        }
      }
    }
    for (;;)
    {
      if (!localCursor.isClosed()) {
        localCursor.close();
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vmr, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label367:
      Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(final WxaAttributes paramWxaAttributes, final fnv paramfnv)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, paramfnv);
    if ((bool) && ("WxaAppInfo".equals(paramfnv.CRg)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      paramfnv = paramfnv.Izj;
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44904);
          try
          {
            eu localeu = u.H(new JSONObject(paramfnv));
            q.b(paramWxaAttributes, localeu.RJF);
            AppMethodBeat.o(44904);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(44904);
          }
        }
      }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44908);
    return bool;
  }
  
  public final boolean a(String paramString, final com.tencent.mm.cd.b paramb, List<fnv> paramList)
  {
    AppMethodBeat.i(44906);
    if (!com.tencent.mm.kernel.h.aHE().kbT)
    {
      Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return false;
    }
    boolean bool = super.a(paramString, paramb, paramList);
    paramb = super.c(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
    if (paramb == null)
    {
      Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return bool;
    }
    paramString = paramb.bLH();
    if ((paramString != null) && (paramString.cwX == 0))
    {
      paramString = m.bFP();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.bLH());
      }
    }
    if (bool) {
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44903);
          try
          {
            z.f(paramb);
            AppMethodBeat.o(44903);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.WxaAttrStorageWC", localException, "flushContactInMainDB", new Object[0]);
            AppMethodBeat.o(44903);
          }
        }
      }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44906);
    return bool;
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(284218);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(284218);
  }
  
  protected final boolean o(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.o(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = c(paramString, new String[] { "appOpt" });
      pm localpm = new pm();
      localpm.fOf.fuO = paramString;
      localpm.fOf.fOg = localWxaAttributes.field_appOpt;
      EventCenter.instance.publish(localpm);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.z
 * JD-Core Version:    0.7.0.1
 */