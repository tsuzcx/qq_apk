package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.e.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader;", "", "()V", "TAG", "", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "giftCache", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "", "getGiftCache", "()Ljava/util/Map;", "giftFullPagDurationMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getGiftFullPagDurationMap", "()Ljava/util/HashMap;", "giftFullPagMd5Map", "getGiftFullPagMd5Map", "giftPreviewPagMd5Map", "getGiftPreviewPagMd5Map", "released", "attachGiftPagTaskInfo", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "checkGiftMd5", "", "debugThumbRes", "", "pos", "fetchPag", "url", "id", "name", "isPreview", "fillDebugData", "getGiftInfo", "isPreciousGift", "giftId", "isValidGift", "pagPath", "isPreviewPag", "prepareLocalGift", "release", "tryFetchGiftRes", "trySyncGift", "updatePagMd5Cache", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderLiveGiftLoader";
  private static boolean aXs;
  private static volatile boolean released;
  private static final Map<String, String> uiA;
  private static final Map<String, String> uiB;
  private static final HashMap<String, Long> uiC;
  public static final e uiD;
  private static final Map<String, com.tencent.mm.plugin.finder.storage.s> uiz;
  
  static
  {
    AppMethodBeat.i(246101);
    uiD = new e();
    TAG = "Finder.FinderLiveGiftLoader";
    uiz = Collections.synchronizedMap((Map)new LinkedHashMap());
    uiA = Collections.synchronizedMap((Map)new HashMap());
    uiB = Collections.synchronizedMap((Map)new HashMap());
    uiC = new HashMap();
    AppMethodBeat.o(246101);
  }
  
  private static boolean a(String paramString1, String paramString2, com.tencent.mm.i.e parame)
  {
    AppMethodBeat.i(246099);
    try
    {
      String str = new URL(paramString1).getHost();
      int i = com.tencent.mm.network.d.a(str, false, (List)new ArrayList());
      int j = com.tencent.mm.network.d.a(str, true, (List)new ArrayList());
      parame.field_mediaId = MD5Util.getMD5String(paramString1);
      parame.url = paramString1;
      parame.host = str;
      parame.gqq = paramString2;
      parame.gqt = i;
      parame.gqu = j;
      parame.isColdSnsData = false;
      parame.signalQuality = NetStatusUtil.getStrength(MMApplicationContext.getContext());
      parame.snsScene = "";
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(TAG, "attachGiftPagTaskInfo imageUrl:%s", new Object[] { paramString1 });
      AppMethodBeat.o(246099);
      return true;
    }
    catch (MalformedURLException paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "", new Object[0]);
      Log.w(TAG, "attachGiftPagTaskInfo fail:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(246099);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.s atA(String paramString)
  {
    AppMethodBeat.i(246095);
    paramString = (com.tencent.mm.plugin.finder.storage.s)uiz.get(paramString);
    AppMethodBeat.o(246095);
    return paramString;
  }
  
  public static boolean atB(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(246097);
    com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)uiz.get(paramString);
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isPreciousGift id:");
    if (locals != null)
    {
      str1 = locals.field_rewardProductId;
      localStringBuilder = localStringBuilder.append(str1).append(" name:");
      if (locals == null) {
        break label143;
      }
      str1 = locals.field_name;
      label68:
      localStringBuilder = localStringBuilder.append(str1).append(" animationPagUrl:");
      if (locals == null) {
        break label148;
      }
    }
    label143:
    label148:
    for (String str1 = locals.field_animationPagUrl;; str1 = null)
    {
      Log.i(str2, str1);
      if (!bg(paramString, false)) {
        break label153;
      }
      paramString = localObject;
      if (locals != null) {
        paramString = locals.field_animationPagUrl;
      }
      if (Util.isNullOrNil(paramString)) {
        break label153;
      }
      AppMethodBeat.o(246097);
      return true;
      str1 = null;
      break;
      str1 = null;
      break label68;
    }
    label153:
    AppMethodBeat.o(246097);
    return false;
  }
  
  public static String bf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246092);
    if (aXs)
    {
      if (paramBoolean)
      {
        paramString = "preview_" + paramString + ".pag";
        AppMethodBeat.o(246092);
        return paramString;
      }
      paramString = "gift_" + paramString + ".pag";
      AppMethodBeat.o(246092);
      return paramString;
    }
    Object localObject1 = (com.tencent.mm.plugin.finder.storage.s)uiz.get(paramString);
    if ((localObject1 != null) && (paramString != null))
    {
      if (paramBoolean)
      {
        localObject2 = al.waC;
        localObject2 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_previewPagUrl;
        kotlin.g.b.p.g(localObject2, "giftInfo.field_previewPagUrl");
        localObject1 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_name;
        kotlin.g.b.p.g(localObject1, "giftInfo.field_name");
        paramString = al.a(new com.tencent.mm.plugin.finder.loader.l((String)localObject2, paramString, (String)localObject1, true));
        AppMethodBeat.o(246092);
        return paramString;
      }
      Object localObject2 = al.waC;
      localObject2 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_animationPagUrl;
      kotlin.g.b.p.g(localObject2, "giftInfo.field_animationPagUrl");
      localObject1 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_name;
      kotlin.g.b.p.g(localObject1, "giftInfo.field_name");
      paramString = al.a(new com.tencent.mm.plugin.finder.loader.l((String)localObject2, paramString, (String)localObject1, false));
      AppMethodBeat.o(246092);
      return paramString;
    }
    AppMethodBeat.o(246092);
    return "";
  }
  
  public static boolean bg(String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(246096);
    com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)uiz.get(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isValidGift isPreview:").append(paramBoolean).append(" id:");
    if (locals != null)
    {
      localObject1 = locals.field_rewardProductId;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      if (locals == null) {
        break label241;
      }
      localObject1 = locals.field_name;
      label88:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" previewMd5:");
      if (locals == null) {
        break label246;
      }
      localObject1 = locals.field_previewPagMd5;
      label113:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" filePreviewMd5:").append((String)uiB.get(paramString)).append(" fullMd5:");
      if (locals == null) {
        break label251;
      }
    }
    label241:
    label246:
    label251:
    for (Object localObject1 = locals.field_animationPagMd5;; localObject1 = null)
    {
      Log.i(str, (String)localObject1 + " fileFulMd5:" + (String)uiA.get(paramString));
      if (!paramBoolean) {
        break label256;
      }
      localObject1 = localObject2;
      if (locals != null) {
        localObject1 = locals.field_previewPagMd5;
      }
      paramBoolean = Util.isEqual((String)localObject1, (String)uiB.get(paramString));
      AppMethodBeat.o(246096);
      return paramBoolean;
      localObject1 = null;
      break;
      localObject1 = null;
      break label88;
      localObject1 = null;
      break label113;
    }
    label256:
    localObject1 = localObject3;
    if (locals != null) {
      localObject1 = locals.field_animationPagMd5;
    }
    paramBoolean = Util.isEqual((String)localObject1, (String)uiA.get(paramString));
    AppMethodBeat.o(246096);
    return paramBoolean;
  }
  
  private static void d(String paramString1, final String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(246091);
    if (released)
    {
      Log.i(TAG, "skip fetch pag, live is released");
      AppMethodBeat.o(246091);
      return;
    }
    com.tencent.mm.i.e locale = new com.tencent.mm.i.e();
    locale.taskName = "task_FinderCdnDownloader";
    al localal = al.waC;
    paramString3 = al.a(new com.tencent.mm.plugin.finder.loader.l(paramString1, paramString2, paramString3, paramBoolean));
    com.tencent.mm.vfs.s.deleteFile(paramString3);
    com.tencent.mm.vfs.s.boN(new o(paramString3).getParent());
    if (a(paramString1, paramString3, locale))
    {
      locale.gqy = ((g.a)new a(paramBoolean, paramString2));
      if (com.tencent.mm.an.f.baQ().e((com.tencent.mm.i.g)locale))
      {
        Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
        AppMethodBeat.o(246091);
        return;
      }
      Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
      AppMethodBeat.o(246091);
      return;
    }
    Log.w(TAG, "attachSnsImgTaskInfo failed");
    AppMethodBeat.o(246091);
  }
  
  private static void dfA()
  {
    AppMethodBeat.i(246090);
    Map localMap = uiz;
    kotlin.g.b.p.g(localMap, "giftCache");
    for (;;)
    {
      try
      {
        Iterator localIterator = localMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (com.tencent.mm.plugin.finder.storage.s)((Map.Entry)localObject2).getValue();
        Object localObject3 = m.uJa;
        localObject3 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(((com.tencent.mm.plugin.finder.storage.s)localObject2).field_thumbnailFileUrl, com.tencent.mm.plugin.finder.storage.x.vEo));
        ((com.tencent.mm.loader.a.b)localObject3).hYt = ((com.tencent.mm.loader.e.b.d)new a());
        localObject3 = new com.tencent.mm.loader.f((com.tencent.mm.loader.a.b)localObject3, ((com.tencent.mm.loader.a.b)localObject3).hYE);
        ((com.tencent.mm.loader.f)localObject3).hYv = true;
        ((com.tencent.mm.loader.f)localObject3).hYs = ((com.tencent.mm.loader.f)localObject3).hYw.hYD;
        ((com.tencent.mm.loader.f)localObject3).aJu();
        Object localObject4;
        if ((!((com.tencent.mm.plugin.finder.storage.s)localObject2).dxO()) || (!Util.isEqual(((com.tencent.mm.plugin.finder.storage.s)localObject2).field_previewPagMd5, (String)uiB.get(str1))))
        {
          localObject3 = TAG;
          localObject4 = new StringBuilder("do fetch preview gift. fetched:");
          if (!((com.tencent.mm.plugin.finder.storage.s)localObject2).dxO())
          {
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.mm.plugin.finder.storage.s)localObject2).field_previewPagMd5, (String)uiB.get(str1))) {
              break label667;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_rewardProductId + ", name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name + ", isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxN() + ']');
            localObject3 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_previewPagUrl;
            kotlin.g.b.p.g(localObject3, "giftInfo.field_previewPagUrl");
            localObject4 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_rewardProductId;
            kotlin.g.b.p.g(localObject4, "giftInfo.field_rewardProductId");
            String str2 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name;
            kotlin.g.b.p.g(str2, "giftInfo.field_name");
            d((String)localObject3, (String)localObject4, str2, true);
          }
        }
        else
        {
          if ((((com.tencent.mm.plugin.finder.storage.s)localObject2).dxN()) && ((!((com.tencent.mm.plugin.finder.storage.s)localObject2).dxP()) || (!Util.isEqual(((com.tencent.mm.plugin.finder.storage.s)localObject2).field_animationPagMd5, (String)uiA.get(str1)))))
          {
            localObject3 = TAG;
            localObject4 = new StringBuilder("do fetch full gift. fetched:");
            if (((com.tencent.mm.plugin.finder.storage.s)localObject2).dxP()) {
              break label672;
            }
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.mm.plugin.finder.storage.s)localObject2).field_animationPagMd5, (String)uiA.get(str1))) {
              break label677;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_rewardProductId + ", name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name + ", isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxN() + ']');
            str1 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_animationPagUrl;
            kotlin.g.b.p.g(str1, "giftInfo.field_animationPagUrl");
            localObject3 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_rewardProductId;
            kotlin.g.b.p.g(localObject3, "giftInfo.field_rewardProductId");
            localObject4 = ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name;
            kotlin.g.b.p.g(localObject4, "giftInfo.field_name");
            d(str1, (String)localObject3, (String)localObject4, false);
          }
          Log.i(TAG, "id:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_rewardProductId + " name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name + " isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxN() + " prePagFetched:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxO() + " fullPagFetched:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxP());
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(246090);
      }
      continue;
      label667:
      boolean bool = false;
      continue;
      label672:
      bool = false;
      continue;
      label677:
      bool = false;
    }
    kotlin.x localx = kotlin.x.SXb;
    AppMethodBeat.o(246090);
  }
  
  public static void dfB()
  {
    AppMethodBeat.i(246094);
    int i = 0;
    while (i < 6)
    {
      com.tencent.mm.plugin.finder.storage.s locals = new com.tencent.mm.plugin.finder.storage.s();
      locals.field_rewardProductId = String.valueOf(i);
      locals.field_name = "礼物".concat(String.valueOf(i));
      locals.field_price = 10.0F;
      locals.field_animationPagUrl = ("gift_" + i + ".pag");
      locals.field_previewPagUrl = ("preview_" + i + ".pag");
      locals.field_businessType = 0;
      Map localMap = uiz;
      kotlin.g.b.p.g(localMap, "giftCache");
      localMap.put(String.valueOf(i), locals);
      i += 1;
    }
    AppMethodBeat.o(246094);
  }
  
  private static void dfC()
  {
    AppMethodBeat.i(246098);
    Object localObject1 = new LinkedHashMap();
    ((LinkedHashMap)localObject1).putAll(uiz);
    for (;;)
    {
      String str;
      synchronized ((Map)localObject1)
      {
        Iterator localIterator = ???.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (com.tencent.mm.plugin.finder.storage.s)((Map.Entry)localObject1).getValue();
        if (!((com.tencent.mm.plugin.finder.storage.s)localObject1).dxN()) {
          break label642;
        }
        localObject3 = new o(bf(str, true));
        if (((o)localObject3).exists())
        {
          localObject3 = com.tencent.mm.b.g.a((o)localObject3, (int)((o)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_name + " isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).dxN() + " filePreviewPagMd5:" + (String)localObject3 + " giftInfo.field_previewPagMd5:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_previewPagMd5);
          Map localMap2 = uiB;
          kotlin.g.b.p.g(localMap2, "giftPreviewPagMd5Map");
          localMap2.put(str, localObject3);
          localObject3 = new o(bf(str, false));
          if (!((o)localObject3).exists()) {
            break label562;
          }
          localObject3 = com.tencent.mm.b.g.a((o)localObject3, (int)((o)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_name + " isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).dxN() + " filePagMd5:" + (String)localObject3 + " giftInfo.field_animationPagMd5:" + ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_animationPagMd5);
          localObject1 = uiA;
          kotlin.g.b.p.g(localObject1, "giftFullPagMd5Map");
          ((Map)localObject1).put(str, localObject3);
          localObject3 = (Long)uiC.get(str);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Long.valueOf(0L);
          }
          if ((!(localObject1 instanceof Long)) || (0L != ((Long)localObject1).longValue())) {
            continue;
          }
          localObject1 = new PAGView(MMApplicationContext.getContext());
          ((PAGView)localObject1).setFile(PAGFile.Load(bf(str, false)));
          ((Map)uiC).put(str, Long.valueOf(((PAGView)localObject1).duration()));
          Log.i(TAG, "checkGiftMd5 giftFullPagDurationMap: giftId = " + str + ", duration = " + (Long)uiC.get(str));
        }
      }
      locals.dxQ();
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b(locals);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locals.field_name + " isFullPag:" + locals.dxN() + " pagFile not exist, skip check");
      continue;
      label562:
      locals.dxQ();
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b(locals);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locals.field_name + " isFullPag:" + locals.dxN() + " pagFile not exist, skip check");
      continue;
      label642:
      Object localObject3 = new o(bf(str, true));
      if (((o)localObject3).exists())
      {
        localObject3 = com.tencent.mm.b.g.a((o)localObject3, (int)((o)localObject3).length());
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locals.field_name + " isFullPag:" + locals.dxN() + " filePreviewPagMd5:" + (String)localObject3 + " giftInfo.field_previewPagMd5:" + locals.field_previewPagMd5);
        localObject2 = uiB;
        kotlin.g.b.p.g(localObject2, "giftPreviewPagMd5Map");
        ((Map)localObject2).put(str, localObject3);
      }
      else
      {
        ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxQ();
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b((com.tencent.mm.plugin.finder.storage.s)localObject2);
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_name + " isFullPag:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).dxN() + " pagFile not exist, skip check");
      }
    }
    Object localObject2 = kotlin.x.SXb;
    AppMethodBeat.o(246098);
  }
  
  public static Map<String, com.tencent.mm.plugin.finder.storage.s> dfw()
  {
    return uiz;
  }
  
  public static HashMap<String, Long> dfx()
  {
    return uiC;
  }
  
  public static void dfy()
  {
    AppMethodBeat.i(246088);
    released = false;
    uiz.clear();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().dxR();
    if (((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "prepareLocalGift giftList from db is nullOrNil");
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)((Iterator)localObject).next();
        Map localMap = uiz;
        kotlin.g.b.p.g(localMap, "giftCache");
        localMap.put(locals.field_rewardProductId, locals);
      }
    }
    Log.i(TAG, "prepareLocalGift cur gift cache:" + uiz);
    AppMethodBeat.o(246088);
  }
  
  public static void dfz()
  {
    AppMethodBeat.i(246089);
    uiz.clear();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().dxR();
    if (((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "skip fetch gift, giftList from db is nullOrNil");
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)((Iterator)localObject).next();
        Map localMap = uiz;
        kotlin.g.b.p.g(localMap, "giftCache");
        localMap.put(locals.field_rewardProductId, locals);
      }
    }
    Log.i(TAG, "cur gift cache:" + uiz);
    dfC();
    dfA();
    AppMethodBeat.o(246089);
  }
  
  public static boolean getDebug()
  {
    return aXs;
  }
  
  public static void release()
  {
    AppMethodBeat.i(246100);
    released = true;
    uiz.clear();
    uiA.clear();
    uiB.clear();
    AppMethodBeat.o(246100);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader$fetchPag$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    a(boolean paramBoolean, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(246085);
      kotlin.g.b.p.h(paramString, "mediaId");
      paramc = e.uiD;
      Log.i(e.dfD(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean + " isPreview:" + this.uiE);
      paramString = e.uiD;
      if (e.dfE())
      {
        paramString = e.uiD;
        Log.i(e.dfD(), "skip fetch pag callback, live is released");
        AppMethodBeat.o(246085);
        return 0;
      }
      if (paramd == null)
      {
        paramString = e.uiD;
        Log.i(e.dfD(), "skip fetch pag callback, sceneResult == null");
        AppMethodBeat.o(246085);
        return 0;
      }
      if (paramd.field_retCode != 0)
      {
        paramString = e.uiD;
        Log.w(e.dfD(), "skip fetch pag callback, fetch pag fail:" + paramd.field_retCode);
        AppMethodBeat.o(246085);
        return 0;
      }
      paramString = e.uiD;
      paramString = (com.tencent.mm.plugin.finder.storage.s)e.dfw().get(paramString2);
      if (paramString != null) {
        if (!this.uiE) {
          break label258;
        }
      }
      label258:
      for (paramString.field_state |= 0x1;; paramString.field_state |= 0x2)
      {
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().replace((IAutoDBItem)paramString);
        paramString = e.uiD;
        e.bh(paramString2, this.uiE);
        AppMethodBeat.o(246085);
        return 0;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(246086);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(246086);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(246087);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(246087);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e
 * JD-Core Version:    0.7.0.1
 */