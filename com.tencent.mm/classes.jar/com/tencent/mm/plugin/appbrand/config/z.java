package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fcu;
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
    if (bAh())
    {
      paramISQLiteDatabase = (ISQLiteDatabaseEx)paramISQLiteDatabase;
      if (!g.aAh().azQ().getBoolean(ar.a.NYr, false))
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
      g.aAh().azQ().set(ar.a.NYr, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label367:
      Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(final WxaAttributes paramWxaAttributes, final fcu paramfcu)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, paramfcu);
    if ((bool) && ("WxaAppInfo".equals(paramfcu.xMX)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      paramfcu = paramfcu.Cyk;
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44904);
          try
          {
            ex localex = u.E(new JSONObject(paramfcu));
            q.b(paramWxaAttributes, localex.KIo);
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
  
  public final boolean a(String paramString, final b paramb, List<fcu> paramList)
  {
    AppMethodBeat.i(44906);
    if (!g.aAf().hpY)
    {
      Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return false;
    }
    boolean bool = super.a(paramString, paramb, paramList);
    paramb = super.d(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
    if (paramb == null)
    {
      Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return bool;
    }
    paramString = paramb.bAp();
    if ((paramString != null) && (paramString.cyu == 0))
    {
      paramString = n.buL();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.bAp());
      }
    }
    if (bool) {
      h.RTc.b(new Runnable()
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
    AppMethodBeat.i(226475);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(226475);
  }
  
  protected final boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.k(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      op localop = new op();
      localop.dUD.dCl = paramString;
      localop.dUD.dUE = localWxaAttributes.field_appOpt;
      EventCenter.instance.publish(localop);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.z
 * JD-Core Version:    0.7.0.1
 */