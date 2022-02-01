package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.e.b.a;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.q;
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
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader;", "", "()V", "TAG", "", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "giftCache", "", "kotlin.jvm.PlatformType", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "", "getGiftCache", "()Ljava/util/Map;", "giftFullPagDurationMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getGiftFullPagDurationMap", "()Ljava/util/HashMap;", "giftFullPagMd5Map", "getGiftFullPagMd5Map", "giftPreviewPagMd5Map", "getGiftPreviewPagMd5Map", "released", "attachGiftPagTaskInfo", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "checkGiftMd5", "", "debugThumbRes", "", "pos", "fetchPag", "url", "id", "name", "isPreview", "fillDebugData", "getGiftInfo", "isPreciousGift", "giftId", "isValidGift", "pagPath", "isPreviewPag", "prepareLocalGift", "release", "tryFetchGiftRes", "trySyncGift", "updatePagMd5Cache", "plugin-finder_release"})
public final class m
{
  private static final String TAG = "Finder.FinderLiveGiftLoader";
  private static boolean aGM;
  private static volatile boolean released;
  private static final Map<String, com.tencent.c.a.a.a.d.a.b> yfs;
  private static final Map<String, String> yft;
  private static final Map<String, String> yfu;
  private static final HashMap<String, Long> yfv;
  public static final m yfw;
  
  static
  {
    AppMethodBeat.i(276397);
    yfw = new m();
    TAG = "Finder.FinderLiveGiftLoader";
    yfs = Collections.synchronizedMap((Map)new LinkedHashMap());
    yft = Collections.synchronizedMap((Map)new HashMap());
    yfu = Collections.synchronizedMap((Map)new HashMap());
    yfv = new HashMap();
    AppMethodBeat.o(276397);
  }
  
  private static boolean a(String paramString1, String paramString2, e parame)
  {
    AppMethodBeat.i(276394);
    try
    {
      String str = new URL(paramString1).getHost();
      int i = com.tencent.mm.network.d.a(str, false, (List)new ArrayList());
      int j = com.tencent.mm.network.d.a(str, true, (List)new ArrayList());
      parame.field_mediaId = MD5Util.getMD5String(paramString1);
      parame.url = paramString1;
      parame.host = str;
      parame.iUy = paramString2;
      parame.iUB = i;
      parame.iUC = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null);
      parame.snsScene = "";
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(TAG, "attachGiftPagTaskInfo imageUrl:%s", new Object[] { paramString1 });
      AppMethodBeat.o(276394);
      return true;
    }
    catch (MalformedURLException paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "", new Object[0]);
      Log.w(TAG, "attachGiftPagTaskInfo fail:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(276394);
    }
    return false;
  }
  
  public static com.tencent.c.a.a.a.d.a.b aCc(String paramString)
  {
    AppMethodBeat.i(276390);
    paramString = (com.tencent.c.a.a.a.d.a.b)yfs.get(paramString);
    AppMethodBeat.o(276390);
    return paramString;
  }
  
  public static boolean aCd(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(276392);
    com.tencent.c.a.a.a.d.a.b localb = (com.tencent.c.a.a.a.d.a.b)yfs.get(paramString);
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isPreciousGift id:");
    if (localb != null)
    {
      str1 = localb.field_rewardProductId;
      localStringBuilder = localStringBuilder.append(str1).append(" name:");
      if (localb == null) {
        break label144;
      }
      str1 = localb.field_name;
      label69:
      localStringBuilder = localStringBuilder.append(str1).append(" animationPagUrl:");
      if (localb == null) {
        break label149;
      }
    }
    label144:
    label149:
    for (String str1 = localb.field_animationPagUrl;; str1 = null)
    {
      Log.i(str2, str1);
      if (!bj(paramString, false)) {
        break label154;
      }
      paramString = localObject;
      if (localb != null) {
        paramString = localb.field_animationPagUrl;
      }
      if (Util.isNullOrNil(paramString)) {
        break label154;
      }
      AppMethodBeat.o(276392);
      return true;
      str1 = null;
      break;
      str1 = null;
      break label69;
    }
    label154:
    AppMethodBeat.o(276392);
    return false;
  }
  
  public static String bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(276386);
    if (aGM)
    {
      if (paramBoolean)
      {
        paramString = "preview_" + paramString + ".pag";
        AppMethodBeat.o(276386);
        return paramString;
      }
      paramString = "gift_" + paramString + ".pag";
      AppMethodBeat.o(276386);
      return paramString;
    }
    Object localObject1 = (com.tencent.c.a.a.a.d.a.b)yfs.get(paramString);
    if ((localObject1 != null) && (paramString != null))
    {
      if (paramBoolean)
      {
        localObject2 = av.AJz;
        localObject2 = ((com.tencent.c.a.a.a.d.a.b)localObject1).field_previewPagUrl;
        p.j(localObject2, "giftInfo.field_previewPagUrl");
        localObject1 = ((com.tencent.c.a.a.a.d.a.b)localObject1).field_name;
        p.j(localObject1, "giftInfo.field_name");
        paramString = av.a(new s((String)localObject2, paramString, (String)localObject1, true));
        AppMethodBeat.o(276386);
        return paramString;
      }
      Object localObject2 = av.AJz;
      localObject2 = ((com.tencent.c.a.a.a.d.a.b)localObject1).field_animationPagUrl;
      p.j(localObject2, "giftInfo.field_animationPagUrl");
      localObject1 = ((com.tencent.c.a.a.a.d.a.b)localObject1).field_name;
      p.j(localObject1, "giftInfo.field_name");
      paramString = av.a(new s((String)localObject2, paramString, (String)localObject1, false));
      AppMethodBeat.o(276386);
      return paramString;
    }
    AppMethodBeat.o(276386);
    return "";
  }
  
  public static boolean bj(String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(276391);
    com.tencent.c.a.a.a.d.a.b localb = (com.tencent.c.a.a.a.d.a.b)yfs.get(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("isValidGift isPreview:").append(paramBoolean).append(" id:");
    if (localb != null)
    {
      localObject1 = localb.field_rewardProductId;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      if (localb == null) {
        break label241;
      }
      localObject1 = localb.field_name;
      label88:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" previewMd5:");
      if (localb == null) {
        break label246;
      }
      localObject1 = localb.field_previewPagMd5;
      label113:
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" filePreviewMd5:").append((String)yfu.get(paramString)).append(" fullMd5:");
      if (localb == null) {
        break label251;
      }
    }
    label241:
    label246:
    label251:
    for (Object localObject1 = localb.field_animationPagMd5;; localObject1 = null)
    {
      Log.i(str, (String)localObject1 + " fileFulMd5:" + (String)yft.get(paramString));
      if (!paramBoolean) {
        break label256;
      }
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.field_previewPagMd5;
      }
      paramBoolean = Util.isEqual((String)localObject1, (String)yfu.get(paramString));
      AppMethodBeat.o(276391);
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
    if (localb != null) {
      localObject1 = localb.field_animationPagMd5;
    }
    paramBoolean = Util.isEqual((String)localObject1, (String)yft.get(paramString));
    AppMethodBeat.o(276391);
    return paramBoolean;
  }
  
  private static void dyA()
  {
    AppMethodBeat.i(276393);
    Object localObject1 = new LinkedHashMap();
    ((LinkedHashMap)localObject1).putAll(yfs);
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
        localObject1 = (com.tencent.c.a.a.a.d.a.b)((Map.Entry)localObject1).getValue();
        if (!((com.tencent.c.a.a.a.d.a.b)localObject1).inu()) {
          break label646;
        }
        localObject3 = new q(bi(str, true));
        if (((q)localObject3).ifE())
        {
          localObject3 = com.tencent.mm.b.g.a((q)localObject3, (int)((q)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).field_name + " isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).inu() + " filePreviewPagMd5:" + (String)localObject3 + " giftInfo.field_previewPagMd5:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).field_previewPagMd5);
          Map localMap2 = yfu;
          p.j(localMap2, "giftPreviewPagMd5Map");
          localMap2.put(str, localObject3);
          localObject3 = new q(bi(str, false));
          if (!((q)localObject3).ifE()) {
            break label564;
          }
          localObject3 = com.tencent.mm.b.g.a((q)localObject3, (int)((q)localObject3).length());
          Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).field_name + " isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).inu() + " filePagMd5:" + (String)localObject3 + " giftInfo.field_animationPagMd5:" + ((com.tencent.c.a.a.a.d.a.b)localObject1).field_animationPagMd5);
          localObject1 = yft;
          p.j(localObject1, "giftFullPagMd5Map");
          ((Map)localObject1).put(str, localObject3);
          localObject3 = (Long)yfv.get(str);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Long.valueOf(0L);
          }
          if ((!(localObject1 instanceof Long)) || (0L != ((Long)localObject1).longValue())) {
            continue;
          }
          localObject1 = new PAGView(MMApplicationContext.getContext());
          ((PAGView)localObject1).setFile(PAGFile.Load(bi(str, false)));
          ((Map)yfv).put(str, Long.valueOf(((PAGView)localObject1).duration()));
          Log.i(TAG, "checkGiftMd5 giftFullPagDurationMap: giftId = " + str + ", duration = " + (Long)yfv.get(str));
        }
      }
      localb.inx();
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().a(localb);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + localb.field_name + " isFullPag:" + localb.inu() + " pagFile not exist, skip check");
      continue;
      label564:
      localb.inx();
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().a(localb);
      Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + localb.field_name + " isFullPag:" + localb.inu() + " pagFile not exist, skip check");
      continue;
      label646:
      Object localObject3 = new q(bi(str, true));
      if (((q)localObject3).ifE())
      {
        localObject3 = com.tencent.mm.b.g.a((q)localObject3, (int)((q)localObject3).length());
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + localb.field_name + " isFullPag:" + localb.inu() + " filePreviewPagMd5:" + (String)localObject3 + " giftInfo.field_previewPagMd5:" + localb.field_previewPagMd5);
        localObject2 = yfu;
        p.j(localObject2, "giftPreviewPagMd5Map");
        ((Map)localObject2).put(str, localObject3);
      }
      else
      {
        ((com.tencent.c.a.a.a.d.a.b)localObject2).inx();
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.c.a.a.a.d.a.b)localObject2);
        Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name + " isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inu() + " pagFile not exist, skip check");
      }
    }
    Object localObject2 = kotlin.x.aazN;
    AppMethodBeat.o(276393);
  }
  
  public static Map<String, com.tencent.c.a.a.a.d.a.b> dyu()
  {
    return yfs;
  }
  
  public static HashMap<String, Long> dyv()
  {
    return yfv;
  }
  
  public static void dyw()
  {
    AppMethodBeat.i(276381);
    released = false;
    yfs.clear();
    Object localObject = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().dDN();
    if (((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "prepareLocalGift giftList from db is nullOrNil");
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.c.a.a.a.d.a.b localb = (com.tencent.c.a.a.a.d.a.b)((Iterator)localObject).next();
        Map localMap = yfs;
        p.j(localMap, "giftCache");
        localMap.put(localb.field_rewardProductId, localb);
      }
    }
    Log.i(TAG, "prepareLocalGift cur gift cache:" + yfs);
    AppMethodBeat.o(276381);
  }
  
  public static void dyx()
  {
    AppMethodBeat.i(276382);
    yfs.clear();
    Object localObject = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().dDN();
    if (((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w(TAG, "skip fetch gift, giftList from db is nullOrNil");
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.c.a.a.a.d.a.b localb = (com.tencent.c.a.a.a.d.a.b)((Iterator)localObject).next();
        Map localMap = yfs;
        p.j(localMap, "giftCache");
        localMap.put(localb.field_rewardProductId, localb);
      }
    }
    Log.i(TAG, "cur gift cache:" + yfs);
    dyA();
    dyy();
    AppMethodBeat.o(276382);
  }
  
  private static void dyy()
  {
    AppMethodBeat.i(276384);
    Map localMap = yfs;
    p.j(localMap, "giftCache");
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
        localObject2 = (com.tencent.c.a.a.a.d.a.b)((Map.Entry)localObject2).getValue();
        Object localObject3 = t.ztT;
        localObject3 = t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x(((com.tencent.c.a.a.a.d.a.b)localObject2).field_thumbnailFileUrl, com.tencent.mm.plugin.finder.storage.u.Alz));
        ((com.tencent.mm.loader.a.b)localObject3).kMX = ((com.tencent.mm.loader.e.b.d)new a());
        localObject3 = new com.tencent.mm.loader.f((com.tencent.mm.loader.a.b)localObject3, ((com.tencent.mm.loader.a.b)localObject3).kNi);
        ((com.tencent.mm.loader.f)localObject3).kMZ = true;
        ((com.tencent.mm.loader.f)localObject3).kMW = ((com.tencent.mm.loader.f)localObject3).kNa.kNh;
        ((com.tencent.mm.loader.f)localObject3).aRu();
        Object localObject4;
        if ((!((com.tencent.c.a.a.a.d.a.b)localObject2).inv()) || (!Util.isEqual(((com.tencent.c.a.a.a.d.a.b)localObject2).field_previewPagMd5, (String)yfu.get(str1))))
        {
          localObject3 = TAG;
          localObject4 = new StringBuilder("do fetch preview gift. fetched:");
          if (!((com.tencent.c.a.a.a.d.a.b)localObject2).inv())
          {
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.c.a.a.a.d.a.b)localObject2).field_previewPagMd5, (String)yfu.get(str1))) {
              break label667;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId + ", name:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name + ", isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inu() + ']');
            localObject3 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_previewPagUrl;
            p.j(localObject3, "giftInfo.field_previewPagUrl");
            localObject4 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId;
            p.j(localObject4, "giftInfo.field_rewardProductId");
            String str2 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name;
            p.j(str2, "giftInfo.field_name");
            e((String)localObject3, (String)localObject4, str2, true);
          }
        }
        else
        {
          if ((((com.tencent.c.a.a.a.d.a.b)localObject2).inu()) && ((!((com.tencent.c.a.a.a.d.a.b)localObject2).inw()) || (!Util.isEqual(((com.tencent.c.a.a.a.d.a.b)localObject2).field_animationPagMd5, (String)yft.get(str1)))))
          {
            localObject3 = TAG;
            localObject4 = new StringBuilder("do fetch full gift. fetched:");
            if (((com.tencent.c.a.a.a.d.a.b)localObject2).inw()) {
              break label672;
            }
            bool = true;
            localObject4 = ((StringBuilder)localObject4).append(bool).append(" md5Check:");
            if (Util.isEqual(((com.tencent.c.a.a.a.d.a.b)localObject2).field_animationPagMd5, (String)yft.get(str1))) {
              break label677;
            }
            bool = true;
            Log.i((String)localObject3, bool + " : [id:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId + ", name:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name + ", isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inu() + ']');
            str1 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_animationPagUrl;
            p.j(str1, "giftInfo.field_animationPagUrl");
            localObject3 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId;
            p.j(localObject3, "giftInfo.field_rewardProductId");
            localObject4 = ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name;
            p.j(localObject4, "giftInfo.field_name");
            e(str1, (String)localObject3, (String)localObject4, false);
          }
          Log.i(TAG, "id:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId + " name:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name + " isFullPag:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inu() + " prePagFetched:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inv() + " fullPagFetched:" + ((com.tencent.c.a.a.a.d.a.b)localObject2).inw());
          continue;
        }
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(276384);
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
    kotlin.x localx = kotlin.x.aazN;
    AppMethodBeat.o(276384);
  }
  
  public static void dyz()
  {
    AppMethodBeat.i(276389);
    int i = 0;
    while (i < 6)
    {
      com.tencent.c.a.a.a.d.a.b localb = new com.tencent.c.a.a.a.d.a.b();
      localb.field_rewardProductId = String.valueOf(i);
      localb.field_name = "礼物".concat(String.valueOf(i));
      localb.field_price = 10.0F;
      localb.field_animationPagUrl = ("gift_" + i + ".pag");
      localb.field_previewPagUrl = ("preview_" + i + ".pag");
      localb.field_businessType = 0;
      Map localMap = yfs;
      p.j(localMap, "giftCache");
      localMap.put(String.valueOf(i), localb);
      i += 1;
    }
    AppMethodBeat.o(276389);
  }
  
  private static void e(String paramString1, final String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(276385);
    if (released)
    {
      Log.i(TAG, "skip fetch pag, live is released");
      AppMethodBeat.o(276385);
      return;
    }
    e locale = new e();
    locale.taskName = "task_FinderCdnDownloader";
    av localav = av.AJz;
    paramString3 = av.a(new s(paramString1, paramString2, paramString3, paramBoolean));
    com.tencent.mm.vfs.u.deleteFile(paramString3);
    com.tencent.mm.vfs.u.bBD(new q(paramString3).ifA());
    if (a(paramString1, paramString3, locale))
    {
      locale.iUG = ((g.a)new a(paramBoolean, paramString2));
      if (com.tencent.mm.aq.f.bkg().e((com.tencent.mm.i.g)locale))
      {
        Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
        AppMethodBeat.o(276385);
        return;
      }
      Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
      AppMethodBeat.o(276385);
      return;
    }
    Log.w(TAG, "attachSnsImgTaskInfo failed");
    AppMethodBeat.o(276385);
  }
  
  public static boolean getDebug()
  {
    return aGM;
  }
  
  public static void release()
  {
    AppMethodBeat.i(276395);
    released = true;
    yfs.clear();
    yft.clear();
    yfu.clear();
    AppMethodBeat.o(276395);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader$fetchPag$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    a(boolean paramBoolean, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(287173);
      p.k(paramString, "mediaId");
      paramc = m.yfw;
      Log.i(m.dyB(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean + " isPreview:" + this.yfx);
      paramString = m.yfw;
      if (m.dyC())
      {
        paramString = m.yfw;
        Log.i(m.dyB(), "skip fetch pag callback, live is released");
        AppMethodBeat.o(287173);
        return 0;
      }
      if (paramd == null)
      {
        paramString = m.yfw;
        Log.i(m.dyB(), "skip fetch pag callback, sceneResult == null");
        AppMethodBeat.o(287173);
        return 0;
      }
      if (paramd.field_retCode != 0)
      {
        paramString = m.yfw;
        Log.w(m.dyB(), "skip fetch pag callback, fetch pag fail:" + paramd.field_retCode);
        AppMethodBeat.o(287173);
        return 0;
      }
      paramString = m.yfw;
      paramString = (com.tencent.c.a.a.a.d.a.b)m.dyu().get(paramString2);
      if (paramString != null) {
        if (!this.yfx) {
          break label260;
        }
      }
      label260:
      for (paramString.field_state |= 0x1;; paramString.field_state |= 0x2)
      {
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().replace((IAutoDBItem)paramString);
        paramString = m.yfw;
        m.bk(paramString2, this.yfx);
        AppMethodBeat.o(287173);
        return 0;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(287174);
      p.k(paramString, "mediaId");
      p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(287174);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(287175);
      p.k(paramString, "mediaId");
      p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(287175);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.m
 * JD-Core Version:    0.7.0.1
 */