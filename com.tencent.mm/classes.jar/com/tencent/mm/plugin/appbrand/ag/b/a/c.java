package com.tencent.mm.plugin.appbrand.ag.b.a;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.d.a;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbPlayerInitLogic;", "", "()V", "APP_BRAND_PROXY_SERVICE_TYPE", "", "DEFAULT_PROXY_SERVICE_TYPE", "MMKV_TTPLAYER_PRELOAD", "", "TAG", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "useIsolateProxy", "", "getCacheDirs", "Lkotlin/Pair;", "processName", "getFileIdFromVideoUrl", "url", "getPreloadSizeFromFileId", "", "fileId", "getPreloadSizeFromVideoUrl", "getTTPlayerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getUrlPreloadSuccessKeyFromFieldId", "fieldId", "initIfNeed", "", "context", "Landroid/content/Context;", "initIfNeedInner", "initIfNeedInner$luggage_tp_video_ext_release", "initProxy", "process", "isPreloadSuccess", "markPreloadSuccess", "resetPreloadData", "storePreloadSizeWithVideoUrl", "size", "luggage-tp-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c utd;
  public static final boolean ute = false;
  private static final AtomicBoolean utf;
  
  static
  {
    AppMethodBeat.i(318114);
    utd = new c();
    utf = new AtomicBoolean(false);
    AppMethodBeat.o(318114);
  }
  
  public static void ab(String paramString, long paramLong)
  {
    AppMethodBeat.i(318079);
    for (;;)
    {
      try
      {
        paramString = agJ(paramString);
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label85;
        }
        if (!n.bp(localCharSequence)) {
          break label90;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(318079);
        return;
      }
      if (i != 0)
      {
        AppMethodBeat.o(318079);
        return;
      }
      ((MultiProcessMMKV)cNY().getSlotForWrite()).encode(paramString, paramLong);
      AppMethodBeat.o(318079);
      return;
      label85:
      int i = 1;
      continue;
      label90:
      i = 0;
    }
  }
  
  private static void ag(Context paramContext, String paramString)
  {
    AppMethodBeat.i(318029);
    int i;
    if (ute) {
      i = 101;
    }
    for (;;)
    {
      ITPDownloadProxy localITPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i);
      Object localObject1 = agI(paramString);
      paramString = (String)((r)localObject1).bsC;
      localObject1 = (String)((r)localObject1).bsD;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("VodCacheEnable", true);
        ((JSONObject)localObject2).put("MemoryAjustInterval", 2147483647);
        ((JSONObject)localObject2).put("EnableOnlyHttpsUseCurl", false);
        label81:
        localObject2 = ((JSONObject)localObject2).toString();
        s.s(localObject2, "JSONObject()\n           …              .toString()");
        localITPDownloadProxy.init(paramContext, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(paramContext), a.getGuid(), paramString, (String)localObject1, (String)localObject2));
        localITPDownloadProxy.setUserData("max_use_memory", Integer.valueOf(5));
        localITPDownloadProxy.setMaxStorageSizeMB(512L);
        AppMethodBeat.o(318029);
        return;
        i = 100;
      }
      catch (Exception localException)
      {
        break label81;
      }
    }
  }
  
  private static r<String, String> agI(String paramString)
  {
    AppMethodBeat.i(318037);
    Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", s.X("getCacheDirs, processName: ", paramString));
    Object localObject = new u(com.tencent.mm.loader.i.b.bmz(), "ThumbVideoCache/TPDownload");
    y.bDX(ah.v(((u)localObject).jKT()));
    paramString = new u((u)localObject, paramString);
    y.bDX(ah.v(paramString.jKT()));
    localObject = ah.v(new u(paramString, "cache").jKT());
    y.bDX((String)localObject);
    localObject = y.n((String)localObject, true);
    paramString = ah.v(new u(paramString, "data").jKT());
    y.bDX(paramString);
    paramString = v.Y(localObject, y.n(paramString, true));
    AppMethodBeat.o(318037);
    return paramString;
  }
  
  public static String agJ(String paramString)
  {
    AppMethodBeat.i(318051);
    Object localObject1;
    int i;
    Object localObject2;
    if (paramString != null)
    {
      try
      {
        localObject4 = Uri.parse(paramString);
        localObject1 = (CharSequence)((Uri)localObject4).getQuery();
        if (localObject1 == null) {
          break label329;
        }
        if (!n.bp((CharSequence)localObject1)) {
          break label228;
        }
      }
      catch (Exception paramString)
      {
        Object localObject4;
        Object localObject3;
        label94:
        label113:
        Log.e("MicroMsg.AppBrand.ThumbPlayerInitLogic", s.X("getFileIdFromVideoUrl  error: ", paramString.getMessage()));
        AppMethodBeat.o(318051);
        return "";
      }
      if (i == 0)
      {
        localObject2 = ((Uri)localObject4).getQueryParameter("vid");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((Uri)localObject4).getQueryParameter("format_id");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (n.bp((CharSequence)localObject1))
        {
          i = 1;
          if (i != 0)
          {
            if (!n.bp((CharSequence)localObject2)) {
              break label238;
            }
            i = 1;
            break label334;
          }
          localObject3 = new StringBuilder();
          localObject4 = ((Uri)localObject4).getQuery();
          s.checkNotNull(localObject4);
          s.s(localObject4, "uri.query!!");
          localObject1 = n.m(paramString, (String)localObject4, "", false) + (String)localObject1 + '_' + (String)localObject2;
          break label341;
        }
      }
    }
    label176:
    label329:
    label334:
    label341:
    for (;;)
    {
      localObject2 = d.UTF_8;
      if (localObject1 == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(318051);
        throw paramString;
        label228:
        i = 0;
        break;
        i = 0;
        break label94;
        label238:
        i = 0;
      }
      while (i != 0)
      {
        localObject1 = paramString;
        break label341;
        localObject2 = ((String)localObject1).getBytes((Charset)localObject2);
        s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = g.getMessageDigest((byte[])localObject2);
        Log.i("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getFileIdFromVideoUrl: newUrl: " + (String)localObject1 + "   url:" + paramString + "  fileId:" + localObject2);
        s.s(localObject2, "fileId");
        AppMethodBeat.o(318051);
        return localObject2;
        localObject1 = "";
        break label176;
        i = 1;
        break;
      }
      break label113;
    }
  }
  
  public static long agK(String paramString)
  {
    AppMethodBeat.i(318061);
    long l = agL(agJ(paramString));
    AppMethodBeat.o(318061);
    return l;
  }
  
  public static long agL(String paramString)
  {
    AppMethodBeat.i(318070);
    for (;;)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label81;
        }
        if (!n.bp(localCharSequence)) {
          break label86;
        }
      }
      catch (Exception paramString)
      {
        long l;
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(318070);
        return 0L;
      }
      if (i != 0)
      {
        AppMethodBeat.o(318070);
        return 0L;
      }
      l = cNY().decodeLong(paramString, 0L);
      AppMethodBeat.o(318070);
      return l;
      label81:
      int i = 1;
      continue;
      label86:
      i = 0;
    }
  }
  
  public static boolean agM(String paramString)
  {
    AppMethodBeat.i(318086);
    for (;;)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label84;
        }
        if (!n.bp(localCharSequence)) {
          break label89;
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(318086);
        return false;
      }
      if (i != 0)
      {
        AppMethodBeat.o(318086);
        return false;
      }
      bool = cNY().decodeBool(s.X("su", paramString), false);
      AppMethodBeat.o(318086);
      return bool;
      label84:
      int i = 1;
      continue;
      label89:
      i = 0;
    }
  }
  
  public static String agN(String paramString)
  {
    AppMethodBeat.i(370008);
    paramString = s.X("su", paramString);
    AppMethodBeat.o(370008);
    return paramString;
  }
  
  public static MMKVSlotManager cNY()
  {
    AppMethodBeat.i(318099);
    Object localObject = MultiProcessMMKV.getMMKV("ttplayer_preload_file");
    s.s(localObject, "getMMKV(MMKV_TTPLAYER_PRELOAD)");
    localObject = new MMKVSlotManager((MultiProcessMMKV)localObject, 1800L);
    AppMethodBeat.o(318099);
    return localObject;
  }
  
  public static void fq(Context paramContext)
  {
    AppMethodBeat.i(318016);
    s.u(paramContext, "context");
    if (!utf.compareAndSet(false, true))
    {
      Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "initIfNeed, already init");
      AppMethodBeat.o(318016);
      return;
    }
    TPPlayerMgr.setOnLogListener((TPPlayerMgr.OnLogListener)new c.a());
    TPPlayerMgr.initSdk(paramContext.getApplicationContext(), "60303", 1);
    Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", s.X("initIfNeed, useIsolateProxy: ", Boolean.valueOf(ute)));
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setProxyServiceType(100);
    TPDownloadProxyHelper.setUseService(false);
    ag(paramContext, b.cwY());
    if (ute)
    {
      TPDownloadProxyHelper.setContext(paramContext.getApplicationContext());
      TPDownloadProxyFactory.ensurePlayManagerService(new c..ExternalSyntheticLambda0(paramContext));
    }
    AppMethodBeat.o(318016);
  }
  
  private static final void fr(Context paramContext)
  {
    AppMethodBeat.i(318105);
    s.u(paramContext, "$context");
    Log.i("MicroMsg.AppBrand.ThumbPlayerInitLogic", "onBindSuccess");
    TPDownloadProxyHelper.setUseService(true);
    ag(paramContext, "main");
    AppMethodBeat.o(318105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a.c
 * JD-Core Version:    0.7.0.1
 */