package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qz;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.gku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class af
  extends ac
{
  public af(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    AppMethodBeat.i(44905);
    Cursor localCursor;
    if (ckW())
    {
      paramISQLiteDatabase = (ISQLiteDatabaseEx)paramISQLiteDatabase;
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acNM, false))
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
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNM, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label367:
      Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(WxaAttributes paramWxaAttributes, gku paramgku)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, paramgku);
    if ((bool) && ("WxaAppInfo".equals(paramgku.ILw)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      paramgku = paramgku.OzQ;
      com.tencent.threadpool.h.ahAA.g(new af.2(this, paramgku, paramWxaAttributes), "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44908);
    return bool;
  }
  
  protected final boolean a(final String paramString, com.tencent.mm.bx.b paramb, List<gku> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(323323);
    if (!com.tencent.mm.kernel.h.baC().mBZ)
    {
      Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(323323);
      return false;
    }
    paramBoolean = super.a(paramString, paramb, paramList, paramBoolean);
    if (paramBoolean) {
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44903);
          try
          {
            WxaAttributes localWxaAttributes = af.this.d(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
            if (localWxaAttributes == null)
            {
              AppMethodBeat.o(44903);
              return;
            }
            af.f(localWxaAttributes);
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
    AppMethodBeat.o(323323);
    return paramBoolean;
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(323319);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(323319);
  }
  
  protected final boolean p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.p(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      qz localqz = new qz();
      localqz.hTX.hzi = paramString;
      localqz.hTX.hTY = localWxaAttributes.field_appOpt;
      localqz.publish();
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.af
 * JD-Core Version:    0.7.0.1
 */