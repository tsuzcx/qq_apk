package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.database.Cursor;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.protocal.protobuf.flb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/BatchSyncVersionUtils;", "", "()V", "TAG", "", "collectPreDownloadWhiteListReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "database", "Lcom/tencent/mm/storagebase/SqliteDB;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a qIG;
  
  static
  {
    AppMethodBeat.i(320409);
    qIG = new a();
    AppMethodBeat.o(320409);
  }
  
  public static final Map<String, flb> b(h paramh)
  {
    AppMethodBeat.i(320403);
    s.u(paramh, "database");
    HashMap localHashMap = new HashMap();
    Object localObject3 = AppBrandGlobalSystemConfig.ckD();
    s.s(localObject3, "obtain()");
    Object localObject1 = ((AppBrandGlobalSystemConfig)localObject3).qXi.qXW;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.AppBrand.BatchSyncVersionUtils", s.X("collectPreDownloadWhiteListReqList, preDownloadList:", localObject1));
    }
    int i;
    int k;
    int j;
    long l1;
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      try
      {
        localObject1 = ((AppBrandGlobalSystemConfig)localObject3).qXi.qXW;
        if (localObject1 == null) {
          break label212;
        }
        i = 0;
        k = ((LongSparseArray)localObject1).size();
        if (k <= 0) {
          break label212;
        }
        j = i + 1;
        l1 = ((LongSparseArray)localObject1).keyAt(i);
        localObject4 = (Iterable)((LongSparseArray)localObject1).valueAt(i);
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label240;
        }
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (CharSequence)localObject5;
        if (localObject6 == null) {
          break label654;
        }
        if (((CharSequence)localObject6).length() != 0) {
          break label235;
        }
      }
      catch (Exception paramh)
      {
        label183:
        Log.e("MicroMsg.AppBrand.BatchSyncVersionUtils", s.X("collectPreDownloadWhiteListReqList get exception:", paramh));
      }
      if (i == 0)
      {
        ((Collection)localObject3).add(localObject5);
        continue;
        label212:
        paramh = (Map)localHashMap;
        AppMethodBeat.o(320403);
        return paramh;
        localObject1 = ((LongSparseArray)localObject1).toString();
        break;
        label235:
        i = 0;
      }
    }
    label240:
    Object localObject4 = (List)localObject3;
    if (!((List)localObject4).isEmpty())
    {
      long l2 = Util.nowSecond();
      long l3 = Math.max(0L, l1);
      localObject3 = " select distinct  WxaAttributesTable.username, WxaAttributesTable.appId, WxaAttributesTable.versionInfo  from AppBrandAppLaunchUsernameDuplicateRecord2 left outer join WxaAttributesTable  on AppBrandAppLaunchUsernameDuplicateRecord2.usernameHash = WxaAttributesTable.usernameHash  where AppBrandAppLaunchUsernameDuplicateRecord2.updateTime >= " + (l2 - l3) + "  and (" + p.a((Iterable)localObject4, (CharSequence)" or ", null, null, 0, null, (kotlin.g.a.b)a.a.qIH, 30) + ')';
      Log.i("MicroMsg.AppBrand.BatchSyncVersionUtils", s.X("collectPreDownloadWhiteListReqList, execute sql:", localObject3));
      localObject4 = ((Collection)localObject4).toArray(new String[0]);
      if (localObject4 == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(320403);
        throw paramh;
      }
      localObject3 = paramh.rawQuery((String)localObject3, (String[])localObject4, 2);
      if (localObject3 != null) {
        localObject3 = (Closeable)localObject3;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (Cursor)localObject3;
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject5 = ((Cursor)localObject4).getString(0);
          localObject6 = ((Cursor)localObject4).getString(1);
          Object localObject7 = (CharSequence)localObject5;
          if (localObject7 == null) {
            break label659;
          }
          if (((CharSequence)localObject7).length() == 0)
          {
            break label659;
            if (i == 0)
            {
              localObject7 = (Map)localHashMap;
              s.s(localObject5, "username");
              flb localflb = new flb();
              localflb.aaLU = ((String)localObject5);
              localWxaVersionInfo = WxaAttributes.WxaVersionInfo.XW(((Cursor)localObject4).getString(2));
              if (localWxaVersionInfo != null) {
                continue;
              }
              i = 0;
              localflb.abLC = i;
              ((Map)localObject7).put(localObject5, localflb);
              Log.i("MicroMsg.AppBrand.BatchSyncVersionUtils", "collectPreDownloadWhiteListReqList, matched username:" + localObject5 + ", appId:" + localObject6 + ", usedTime:" + l1);
            }
            if (((Cursor)localObject4).moveToNext()) {
              continue;
            }
          }
        }
        else
        {
          localObject4 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject3, null);
          if (j >= k) {
            break label212;
          }
          i = j;
          break;
        }
        i = 0;
        continue;
        i = localWxaVersionInfo.appVersion;
        continue;
        i = 1;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(320403);
          throw paramh;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject3, paramh);
          AppMethodBeat.o(320403);
        }
      }
      label654:
      break label183;
      label659:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.a
 * JD-Core Version:    0.7.0.1
 */