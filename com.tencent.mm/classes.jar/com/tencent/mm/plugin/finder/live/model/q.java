package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
import kotlin.Metadata;
import kotlin.ah;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader;", "", "()V", "TAG", "", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "giftCache", "", "kotlin.jvm.PlatformType", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "", "getGiftCache", "()Ljava/util/Map;", "giftFullPagDurationMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getGiftFullPagDurationMap", "()Ljava/util/HashMap;", "giftFullPagMd5Map", "getGiftFullPagMd5Map", "giftPreviewPagMd5Map", "getGiftPreviewPagMd5Map", "released", "attachGiftPagTaskInfo", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "checkGiftMd5", "", "debugThumbRes", "", "pos", "fetchPag", "url", "id", "name", "isPreview", "fillDebugData", "getGiftInfo", "isPreciousGift", "giftId", "isValidGift", "pagPath", "isPreviewPag", "prepareLocalGift", "release", "tryFetchGiftRes", "trySyncGift", "updatePagMd5Cache", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q CFU;
  private static final Map<String, com.tencent.d.a.a.a.d.a.d> CFV;
  private static final Map<String, String> CFW;
  private static final Map<String, String> CFX;
  private static final HashMap<String, Long> CFY;
  private static final String TAG;
  private static boolean debug;
  private static volatile boolean released;
  
  static
  {
    AppMethodBeat.i(359539);
    CFU = new q();
    TAG = "Finder.FinderLiveGiftLoader";
    CFV = Collections.synchronizedMap((Map)new LinkedHashMap());
    CFW = Collections.synchronizedMap((Map)new HashMap());
    CFX = Collections.synchronizedMap((Map)new HashMap());
    CFY = new HashMap();
    AppMethodBeat.o(359539);
  }
  
  private static boolean a(String paramString1, String paramString2, com.tencent.mm.g.e parame)
  {
    AppMethodBeat.i(359510);
    try
    {
      String str = new URL(paramString1).getHost();
      int i = com.tencent.mm.network.d.a(str, false, (List)new ArrayList());
      int j = com.tencent.mm.network.d.a(str, true, (List)new ArrayList());
      parame.field_mediaId = MD5Util.getMD5String(paramString1);
      parame.url = paramString1;
      parame.host = str;
      parame.lwD = paramString2;
      parame.lwG = i;
      parame.lwH = j;
      parame.isColdSnsData = false;
      parame.signalQuality = kotlin.g.b.s.X("", Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)));
      parame.snsScene = "";
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(TAG, "attachGiftPagTaskInfo imageUrl:%s", new Object[] { paramString1 });
      AppMethodBeat.o(359510);
      return true;
    }
    catch (MalformedURLException paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "", new Object[0]);
      Log.w(TAG, kotlin.g.b.s.X("attachGiftPagTaskInfo fail:", paramString1));
      AppMethodBeat.o(359510);
    }
    return false;
  }
  
  public static com.tencent.d.a.a.a.d.a.d awx(String paramString)
  {
    AppMethodBeat.i(359480);
    paramString = (com.tencent.d.a.a.a.d.a.d)CFV.get(paramString);
    AppMethodBeat.o(359480);
    return paramString;
  }
  
  public static boolean awy(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359496);
    com.tencent.d.a.a.a.d.a.d locald = (com.tencent.d.a.a.a.d.a.d)CFV.get(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isPreciousGift id:");
    Object localObject1;
    if (locald == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" name:");
      if (locald != null) {
        break label132;
      }
      localObject1 = null;
      label62:
      localStringBuilder = localStringBuilder.append(localObject1).append(" animationPagUrl:");
      if (locald != null) {
        break label140;
      }
      localObject1 = null;
      label82:
      Log.i(str, localObject1);
      if (!bv(paramString, false)) {
        break label156;
      }
      if (locald != null) {
        break label148;
      }
    }
    label132:
    label140:
    label148:
    for (paramString = localObject2;; paramString = locald.field_animationPagUrl)
    {
      if (Util.isNullOrNil(paramString)) {
        break label156;
      }
      AppMethodBeat.o(359496);
      return true;
      localObject1 = locald.field_rewardProductId;
      break;
      localObject1 = locald.field_name;
      break label62;
      localObject1 = locald.field_animationPagUrl;
      break label82;
    }
    label156:
    AppMethodBeat.o(359496);
    return false;
  }
  
  public static String bu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(359469);
    if (debug)
    {
      if (paramBoolean)
      {
        paramString = "preview_" + paramString + ".pag";
        AppMethodBeat.o(359469);
        return paramString;
      }
      paramString = "gift_" + paramString + ".pag";
      AppMethodBeat.o(359469);
      return paramString;
    }
    Object localObject = (com.tencent.d.a.a.a.d.a.d)CFV.get(paramString);
    if ((localObject != null) && (paramString != null))
    {
      if (paramBoolean)
      {
        localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        str = ((com.tencent.d.a.a.a.d.a.d)localObject).field_previewPagUrl;
        kotlin.g.b.s.s(str, "giftInfo.field_previewPagUrl");
        localObject = ((com.tencent.d.a.a.a.d.a.d)localObject).field_name;
        kotlin.g.b.s.s(localObject, "giftInfo.field_name");
        paramString = localh.a(new o(str, paramString, (String)localObject, true));
        AppMethodBeat.o(359469);
        return paramString;
      }
      com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      String str = ((com.tencent.d.a.a.a.d.a.d)localObject).field_animationPagUrl;
      kotlin.g.b.s.s(str, "giftInfo.field_animationPagUrl");
      localObject = ((com.tencent.d.a.a.a.d.a.d)localObject).field_name;
      kotlin.g.b.s.s(localObject, "giftInfo.field_name");
      paramString = localh.a(new o(str, paramString, (String)localObject, false));
      AppMethodBeat.o(359469);
      return paramString;
    }
    AppMethodBeat.o(359469);
    return "";
  }
  
  public static boolean bv(String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(359489);
    com.tencent.d.a.a.a.d.a.d locald = (com.tencent.d.a.a.a.d.a.d)CFV.get(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isValidGift isPreview:").append(paramBoolean).append(" id:");
    if (locald == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" name:");
      if (locald != null) {
        break label217;
      }
      localObject1 = null;
      label80:
      localStringBuilder = localStringBuilder.append(localObject1).append(" previewMd5:");
      if (locald != null) {
        break label226;
      }
      localObject1 = null;
      label101:
      localStringBuilder = localStringBuilder.append(localObject1).append(" filePreviewMd5:").append(CFX.get(paramString)).append(" fullMd5:");
      if (locald != null) {
        break label235;
      }
      localObject1 = null;
      label140:
      Log.i(str, localObject1 + " fileFulMd5:" + CFW.get(paramString));
      if (!paramBoolean) {
        break label253;
      }
      if (locald != null) {
        break label244;
      }
    }
    label217:
    label226:
    label235:
    label244:
    for (Object localObject1 = localObject2;; localObject1 = locald.field_previewPagMd5)
    {
      paramBoolean = Util.isEqual((String)localObject1, (String)CFX.get(paramString));
      AppMethodBeat.o(359489);
      return paramBoolean;
      localObject1 = locald.field_rewardProductId;
      break;
      localObject1 = locald.field_name;
      break label80;
      localObject1 = locald.field_previewPagMd5;
      break label101;
      localObject1 = locald.field_animationPagMd5;
      break label140;
    }
    label253:
    if (locald == null) {}
    for (localObject1 = localObject3;; localObject1 = locald.field_animationPagMd5)
    {
      paramBoolean = Util.isEqual((String)localObject1, (String)CFW.get(paramString));
      AppMethodBeat.o(359489);
      return paramBoolean;
    }
  }
  
  private static void e(String paramString1, final String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(359460);
    if (released)
    {
      Log.i(TAG, "skip fetch pag, live is released");
      AppMethodBeat.o(359460);
      return;
    }
    com.tencent.mm.g.e locale = new com.tencent.mm.g.e();
    locale.taskName = "task_FinderCdnDownloader";
    paramString3 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(new o(paramString1, paramString2, paramString3, paramBoolean));
    y.deleteFile(paramString3);
    y.bDX(new u(paramString3).jKO());
    if (a(paramString1, paramString3, locale))
    {
      locale.lwL = ((g.a)new a(paramBoolean, paramString2));
      if (k.bHW().b((com.tencent.mm.g.g)locale, -1))
      {
        Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
        AppMethodBeat.o(359460);
        return;
      }
      Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
      AppMethodBeat.o(359460);
      return;
    }
    Log.w(TAG, "attachSnsImgTaskInfo failed");
    AppMethodBeat.o(359460);
  }
  
  public static Map<String, com.tencent.d.a.a.a.d.a.d> ekL()
  {
    return CFV;
  }
  
  public static HashMap<String, Long> ekM()
  {
    return CFY;
  }
  
  public static void ekN()
  {
    AppMethodBeat.i(359411);
    released = false;
    CFV.clear();
    Object localObject1 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().etX();
    Object localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "prepareLocalGift giftList from db is nullOrNil");
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.d.a.a.a.d.a.d)((Iterator)localObject1).next();
        Map localMap = CFV;
        kotlin.g.b.s.s(localMap, "giftCache");
        localMap.put(((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId, localObject2);
      }
    }
    Log.i(TAG, kotlin.g.b.s.X("prepareLocalGift cur gift cache:", CFV));
    AppMethodBeat.o(359411);
  }
  
  public static void ekO()
  {
    AppMethodBeat.i(359429);
    CFV.clear();
    Object localObject1 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().etX();
    Object localObject3 = (Collection)localObject1;
    if ((localObject3 == null) || (((Collection)localObject3).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "skip fetch gift, giftList from db is nullOrNil");
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.d.a.a.a.d.a.d)((Iterator)localObject1).next();
        ??? = CFV;
        kotlin.g.b.s.s(???, "giftCache");
        ???.put(((com.tencent.d.a.a.a.d.a.d)localObject3).field_rewardProductId, localObject3);
      }
    }
    Log.i(TAG, kotlin.g.b.s.X("cur gift cache:", CFV));
    localObject1 = new LinkedHashMap();
    ((LinkedHashMap)localObject1).putAll(CFV);
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
        localObject1 = (com.tencent.d.a.a.a.d.a.d)((Map.Entry)localObject1).getValue();
        if (!((com.tencent.d.a.a.a.d.a.d)localObject1).jWq()) {
          break label773;
        }
        localObject3 = new u(bu(str, true));
        if (((u)localObject3).jKS())
        {
          localObject3 = com.tencent.mm.b.g.a((u)localObject3, (int)((u)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).field_name + " isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).jWq() + " filePreviewPagMd5:" + localObject3 + " giftInfo.field_previewPagMd5:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).field_previewPagMd5);
          Map localMap2 = CFX;
          kotlin.g.b.s.s(localMap2, "giftPreviewPagMd5Map");
          localMap2.put(str, localObject3);
          localObject3 = new u(bu(str, false));
          if (!((u)localObject3).jKS()) {
            break label691;
          }
          localObject3 = com.tencent.mm.b.g.a((u)localObject3, (int)((u)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).field_name + " isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).jWq() + " filePagMd5:" + localObject3 + " giftInfo.field_animationPagMd5:" + ((com.tencent.d.a.a.a.d.a.d)localObject1).field_animationPagMd5);
          localObject1 = CFW;
          kotlin.g.b.s.s(localObject1, "giftFullPagMd5Map");
          ((Map)localObject1).put(str, localObject3);
          localObject3 = (Long)CFY.get(str);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Long.valueOf(0L);
          }
          if (0L != ((Long)localObject1).longValue()) {
            continue;
          }
          localObject1 = new PAGView(MMApplicationContext.getContext());
          ((PAGView)localObject1).setFile(PAGFile.Load(bu(str, false)));
          ((Map)CFY).put(str, Long.valueOf(((PAGView)localObject1).duration()));
          Log.i(TAG, "checkGiftMd5 giftFullPagDurationMap: giftId = " + str + ", duration = " + CFY.get(str));
        }
      }
      locald.jWt();
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().a(locald);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locald.field_name + " isFullPag:" + locald.jWq() + " pagFile not exist, skip check");
      continue;
      label691:
      locald.jWt();
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().a(locald);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locald.field_name + " isFullPag:" + locald.jWq() + " pagFile not exist, skip check");
      continue;
      label773:
      localObject3 = new u(bu(str, true));
      if (((u)localObject3).jKS())
      {
        localObject3 = com.tencent.mm.b.g.a((u)localObject3, (int)((u)localObject3).length());
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + locald.field_name + " isFullPag:" + locald.jWq() + " filePreviewPagMd5:" + localObject3 + " giftInfo.field_previewPagMd5:" + locald.field_previewPagMd5);
        localObject2 = CFX;
        kotlin.g.b.s.s(localObject2, "giftPreviewPagMd5Map");
        ((Map)localObject2).put(str, localObject3);
      }
      else
      {
        ((com.tencent.d.a.a.a.d.a.d)localObject2).jWt();
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.d.a.a.a.d.a.d)localObject2);
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name + " isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWq() + " pagFile not exist, skip check");
      }
    }
    Object localObject2 = ah.aiuX;
    ekP();
    AppMethodBeat.o(359429);
  }
  
  private static void ekP()
  {
    AppMethodBeat.i(359447);
    Map localMap = CFV;
    kotlin.g.b.s.s(localMap, "giftCache");
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
        localObject2 = (com.tencent.d.a.a.a.d.a.d)((Map.Entry)localObject2).getValue();
        Object localObject3 = p.ExI;
        p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(((com.tencent.d.a.a.a.d.a.d)localObject2).field_thumbnailFileUrl, v.FKZ)).blf();
        Object localObject4;
        if ((!((com.tencent.d.a.a.a.d.a.d)localObject2).jWr()) || (!Util.isEqual(((com.tencent.d.a.a.a.d.a.d)localObject2).field_previewPagMd5, (String)CFX.get(str1))))
        {
          localObject3 = TAG;
          localObject4 = new StringBuilder("do fetch preview gift. fetched:");
          if (!((com.tencent.d.a.a.a.d.a.d)localObject2).jWr())
          {
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.d.a.a.a.d.a.d)localObject2).field_previewPagMd5, (String)CFX.get(str1))) {
              break label613;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId + ", name:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name + ", isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWq() + ']');
            localObject3 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_previewPagUrl;
            kotlin.g.b.s.s(localObject3, "giftInfo.field_previewPagUrl");
            localObject4 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId;
            kotlin.g.b.s.s(localObject4, "giftInfo.field_rewardProductId");
            String str2 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name;
            kotlin.g.b.s.s(str2, "giftInfo.field_name");
            e((String)localObject3, (String)localObject4, str2, true);
          }
        }
        else
        {
          if ((((com.tencent.d.a.a.a.d.a.d)localObject2).jWq()) && ((!((com.tencent.d.a.a.a.d.a.d)localObject2).jWs()) || (!Util.isEqual(((com.tencent.d.a.a.a.d.a.d)localObject2).field_animationPagMd5, (String)CFW.get(str1)))))
          {
            localObject3 = TAG;
            localObject4 = new StringBuilder("do fetch full gift. fetched:");
            if (((com.tencent.d.a.a.a.d.a.d)localObject2).jWs()) {
              break label618;
            }
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.d.a.a.a.d.a.d)localObject2).field_animationPagMd5, (String)CFW.get(str1))) {
              break label623;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId + ", name:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name + ", isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWq() + ']');
            str1 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_animationPagUrl;
            kotlin.g.b.s.s(str1, "giftInfo.field_animationPagUrl");
            localObject3 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId;
            kotlin.g.b.s.s(localObject3, "giftInfo.field_rewardProductId");
            localObject4 = ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name;
            kotlin.g.b.s.s(localObject4, "giftInfo.field_name");
            e(str1, (String)localObject3, (String)localObject4, false);
          }
          Log.i(TAG, "id:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId + " name:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name + " isFullPag:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWq() + " prePagFetched:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWr() + " fullPagFetched:" + ((com.tencent.d.a.a.a.d.a.d)localObject2).jWs());
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(359447);
      }
      continue;
      label613:
      boolean bool = false;
      continue;
      label618:
      bool = false;
      continue;
      label623:
      bool = false;
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(359447);
  }
  
  public static void release()
  {
    AppMethodBeat.i(359514);
    released = true;
    CFV.clear();
    CFW.clear();
    CFX.clear();
    AppMethodBeat.o(359514);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader$fetchPag$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    a(boolean paramBoolean, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(359786);
      kotlin.g.b.s.u(paramString, "mediaId");
      Log.i(q.aUw(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean + " isPreview:" + this.CFZ);
      if (q.ekQ())
      {
        Log.i(q.aUw(), "skip fetch pag callback, live is released");
        AppMethodBeat.o(359786);
        return 0;
      }
      if (paramd == null)
      {
        Log.i(q.aUw(), "skip fetch pag callback, sceneResult == null");
        AppMethodBeat.o(359786);
        return 0;
      }
      if (paramd.field_retCode != 0)
      {
        Log.w(q.aUw(), kotlin.g.b.s.X("skip fetch pag callback, fetch pag fail:", Integer.valueOf(paramd.field_retCode)));
        AppMethodBeat.o(359786);
        return 0;
      }
      paramString = q.CFU;
      paramc = (com.tencent.d.a.a.a.d.a.d)q.ekL().get(paramString2);
      if (paramc != null)
      {
        paramBoolean = this.CFZ;
        paramString = paramString2;
        if (!paramBoolean) {
          break label237;
        }
      }
      label237:
      for (paramc.field_state |= 0x1;; paramc.field_state |= 0x2)
      {
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().replace((IAutoDBItem)paramc);
        paramc = q.CFU;
        q.bw(paramString, paramBoolean);
        AppMethodBeat.o(359786);
        return 0;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(359797);
      kotlin.g.b.s.u(paramString, "mediaId");
      kotlin.g.b.s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(359797);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(359802);
      kotlin.g.b.s.u(paramString, "mediaId");
      kotlin.g.b.s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(359802);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.q
 * JD-Core Version:    0.7.0.1
 */