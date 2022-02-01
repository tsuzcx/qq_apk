package com.tencent.mm.plugin.appbrand.ae.a.a;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyBindServiceCallback;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.d.a;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbPlayerInitLogic;", "", "()V", "APP_BRAND_PROXY_SERVICE_TYPE", "", "DEFAULT_PROXY_SERVICE_TYPE", "MMKV_TTPLAYER_PRELOAD", "", "TAG", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "useIsolateProxy", "", "getCacheDirs", "Lkotlin/Pair;", "processName", "getFileIdFromVideoUrl", "url", "getPreloadSizeFromFileId", "", "fileId", "getPreloadSizeFromVideoUrl", "getSimpleProcessName", "getTTPlayerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getUrlPreloadSuccessKeyFromFieldId", "fieldId", "initIfNeed", "", "context", "Landroid/content/Context;", "initIfNeedInner", "initIfNeedInner$plugin_compat_release", "initProxy", "process", "isPreloadSuccess", "markPreloadSuccess", "resetPreloadData", "storePreloadSizeWithVideoUrl", "size", "plugin-compat_release"})
public final class c
{
  public static final boolean rkj = false;
  private static final AtomicBoolean rkk;
  public static final c rkl;
  
  static
  {
    AppMethodBeat.i(207602);
    rkl = new c();
    rkk = new AtomicBoolean(false);
    AppMethodBeat.o(207602);
  }
  
  public static void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(207593);
    for (;;)
    {
      try
      {
        paramString = anp(paramString);
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label85;
        }
        if (!n.ba(localCharSequence)) {
          break label90;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(207593);
        return;
      }
      if (i != 0)
      {
        AppMethodBeat.o(207593);
        return;
      }
      ((MultiProcessMMKV)cmr().getSlotForWrite()).encode(paramString, paramLong);
      AppMethodBeat.o(207593);
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
    AppMethodBeat.i(207580);
    int i;
    if (rkj) {
      i = 101;
    }
    for (;;)
    {
      ITPDownloadProxy localITPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i);
      Object localObject1 = ano(paramString);
      paramString = (String)((o)localObject1).Mx;
      localObject1 = (String)((o)localObject1).My;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("MemoryAjustInterval", 2147483647);
        ((JSONObject)localObject2).put("EnableOnlyHttpsUseCurl", false);
        label72:
        localObject2 = ((JSONObject)localObject2).toString();
        p.j(localObject2, "JSONObject()\n           …              .toString()");
        localITPDownloadProxy.init(paramContext, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(paramContext), a.getGuid(), paramString, (String)localObject1, (String)localObject2));
        localITPDownloadProxy.setUserData("max_use_memory", Integer.valueOf(5));
        localITPDownloadProxy.setMaxStorageSizeMB(512L);
        AppMethodBeat.o(207580);
        return;
        i = 100;
      }
      catch (Exception localException)
      {
        break label72;
      }
    }
  }
  
  private static o<String, String> ano(String paramString)
  {
    AppMethodBeat.i(207585);
    Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getCacheDirs, processName: ".concat(String.valueOf(paramString)));
    Object localObject = new q(b.aSL(), "ThumbVideoCache");
    u.bBD(((q)localObject).bOF());
    localObject = new q((q)localObject, paramString);
    u.bBD(((q)localObject).bOF());
    paramString = new q((q)localObject, "cache").bOF();
    u.bBD(paramString);
    p.j(paramString, "VFSFile(curThumbCacheDir…leOp.mkdirs(it)\n        }");
    localObject = new q((q)localObject, "data").bOF();
    u.bBD((String)localObject);
    p.j(localObject, "VFSFile(curThumbCacheDir…leOp.mkdirs(it)\n        }");
    paramString = s.M(paramString, localObject);
    AppMethodBeat.o(207585);
    return paramString;
  }
  
  public static String anp(String paramString)
  {
    AppMethodBeat.i(207587);
    Object localObject1;
    int i;
    label67:
    Object localObject2;
    if (paramString != null)
    {
      try
      {
        localObject4 = Uri.parse(paramString);
        p.j(localObject4, "uri");
        localObject1 = (CharSequence)((Uri)localObject4).getQuery();
        if (localObject1 == null) {
          break label319;
        }
        if (!n.ba((CharSequence)localObject1)) {
          break label225;
        }
      }
      catch (Exception paramString)
      {
        Object localObject4;
        Object localObject3;
        Log.e("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getFileIdFromVideoUrl  error: " + paramString.getMessage());
        AppMethodBeat.o(207587);
        return "";
      }
      if (i == 0)
      {
        localObject1 = ((Uri)localObject4).getQueryParameter("vid");
        if (localObject1 != null) {
          break label310;
        }
        localObject1 = "";
        p.j(localObject1, "uri.getQueryParameter(\"vid\") ?: \"\"");
        localObject3 = ((Uri)localObject4).getQueryParameter("format_id");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        p.j(localObject2, "uri.getQueryParameter(\"format_id\") ?: \"\"");
        localObject3 = new StringBuilder();
        localObject4 = ((Uri)localObject4).getQuery();
        if (localObject4 == null) {
          p.iCn();
        }
        p.j(localObject4, "uri.query!!");
        localObject1 = n.l(paramString, (String)localObject4, "", false) + (String)localObject1 + (String)localObject2;
        break label324;
      }
    }
    label310:
    label319:
    label324:
    for (;;)
    {
      localObject2 = d.UTF_8;
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(207587);
        throw paramString;
        label225:
        i = 0;
        break;
        localObject1 = paramString;
        break label324;
      }
      localObject2 = ((String)localObject1).getBytes((Charset)localObject2);
      p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = g.getMessageDigest((byte[])localObject2);
      Log.i("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getFileIdFromVideoUrl: newUrl: " + (String)localObject1 + "   url:" + paramString + "  fileId:" + (String)localObject2);
      p.j(localObject2, "fileId");
      AppMethodBeat.o(207587);
      return localObject2;
      break label67;
      localObject1 = "";
      continue;
      i = 1;
      break;
    }
  }
  
  public static long anq(String paramString)
  {
    AppMethodBeat.i(207590);
    for (;;)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label81;
        }
        if (!n.ba(localCharSequence)) {
          break label86;
        }
      }
      catch (Exception paramString)
      {
        long l;
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(207590);
        return 0L;
      }
      if (i != 0)
      {
        AppMethodBeat.o(207590);
        return 0L;
      }
      l = cmr().decodeLong(paramString, 0L);
      AppMethodBeat.o(207590);
      return l;
      label81:
      int i = 1;
      continue;
      label86:
      i = 0;
    }
  }
  
  public static long blh(String paramString)
  {
    AppMethodBeat.i(292908);
    long l = anq(anp(paramString));
    AppMethodBeat.o(292908);
    return l;
  }
  
  public static void bwi(String paramString)
  {
    AppMethodBeat.i(292909);
    for (;;)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label84;
        }
        if (!n.ba(localCharSequence)) {
          break label89;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(292909);
        return;
      }
      if (i != 0)
      {
        AppMethodBeat.o(292909);
        return;
      }
      ((MultiProcessMMKV)cmr().getSlotForWrite()).encode(bxE(paramString), true);
      AppMethodBeat.o(292909);
      return;
      label84:
      int i = 1;
      continue;
      label89:
      i = 0;
    }
  }
  
  public static boolean bxA(String paramString)
  {
    AppMethodBeat.i(292910);
    for (;;)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label81;
        }
        if (!n.ba(localCharSequence)) {
          break label86;
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(292910);
        return false;
      }
      if (i != 0)
      {
        AppMethodBeat.o(292910);
        return false;
      }
      bool = cmr().decodeBool(bxE(paramString), false);
      AppMethodBeat.o(292910);
      return bool;
      label81:
      int i = 1;
      continue;
      label86:
      i = 0;
    }
  }
  
  private static String bxE(String paramString)
  {
    AppMethodBeat.i(292911);
    paramString = "su".concat(String.valueOf(paramString));
    AppMethodBeat.o(292911);
    return paramString;
  }
  
  public static MMKVSlotManager cmr()
  {
    AppMethodBeat.i(207597);
    Object localObject = MultiProcessMMKV.getMMKV("ttplayer_preload_file");
    p.j(localObject, "MultiProcessMMKV.getMMKV(MMKV_TTPLAYER_PRELOAD)");
    localObject = new MMKVSlotManager((MultiProcessMMKV)localObject, 1800L);
    AppMethodBeat.o(207597);
    return localObject;
  }
  
  public static void eu(Context paramContext)
  {
    AppMethodBeat.i(207579);
    p.k(paramContext, "context");
    if (!rkk.compareAndSet(false, true))
    {
      Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "initIfNeed, already init");
      AppMethodBeat.o(207579);
      return;
    }
    TPPlayerMgr.setOnLogListener((TPPlayerMgr.OnLogListener)new c.a());
    TPPlayerMgr.initSdk(paramContext.getApplicationContext(), "60303", 1);
    Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "initIfNeed, useIsolateProxy: " + rkj);
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setProxyServiceType(100);
    TPDownloadProxyHelper.setUseService(false);
    String str = MMApplicationContext.getProcessName();
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      i = n.a((CharSequence)str, ':', 0, false, 6);
      if ((i >= 0) && (i + 1 <= str.length())) {
        if (str == null)
        {
          paramContext = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(207579);
          throw paramContext;
          i = 0;
        }
        else
        {
          str = str.substring(i + 1);
          p.j(str, "(this as java.lang.String).substring(startIndex)");
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getSimpleProcessName, simpleProcessName: ".concat(String.valueOf(str)));
      ag(paramContext, str);
      if (rkj)
      {
        TPDownloadProxyHelper.setContext(paramContext.getApplicationContext());
        TPDownloadProxyFactory.ensurePlayManagerService((TPDLProxyBindServiceCallback)new b(paramContext));
      }
      AppMethodBeat.o(207579);
      return;
      str = "main";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onBindSuccess"})
  static final class b
    implements TPDLProxyBindServiceCallback
  {
    b(Context paramContext) {}
    
    public final void onBindSuccess()
    {
      AppMethodBeat.i(207642);
      Log.i("MicroMsg.AppBrand.ThumbPlayerInitLogic", "onBindSuccess");
      TPDownloadProxyHelper.setUseService(true);
      c localc = c.rkl;
      c.ev(this.$context);
      AppMethodBeat.o(207642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.c
 * JD-Core Version:    0.7.0.1
 */