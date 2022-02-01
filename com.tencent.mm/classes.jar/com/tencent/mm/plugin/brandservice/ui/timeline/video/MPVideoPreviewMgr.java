package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ad;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.at;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lkotlin.o<Lcom.tencent.mm.storage.z;Landroid.view.View;>;>;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "blackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSetAlpha", "cgiQueue", "currentVid", "hotLocation", "", "infoToCard", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lkotlin/collections/HashMap;", "previewInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "urlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "videoLocation", "weakParent", "Landroid/view/ViewGroup;", "weakPreview", "Landroid/view/View;", "weakTimer", "Landroid/widget/TextView;", "weakVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "weakVideoWrapper", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoWrapper;", "addBlackList", "", "vid", "autoPlayTime", "", "cgiPlayUrl", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "changeStatus", "status", "checkPosition", "reason", "list", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "checkSameTopVideo", "lastVid", "chooseVideo", "videoInfoList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "clickCard", "extra", "destroy", "doPauseForResume", "event", "doStatusElse", "filterCard", "getAutoPlayId", "getPlayUrl", "isAutoPlay", "registerCard", "cardTmpl", "removeBlackList", "saveVideoInTimeline", "setPlayUrl", "url", "startPreview", "parent", "height", "playUrl", "startTimer", "stopPreviewAd", "except", "stopPreviewVideo", "stopTimer", "triggerEvent", "getBizMMReader", "Lcom/tencent/mm/message/BizMMReader;", "getTitle", "getTopBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getUrl", "getVid", "EmptyControlBar", "Event", "PreviewInfo", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr
{
  public static final boolean pJj;
  public static WeakReference<ViewGroup> pJk;
  public static WeakReference<View> pJl;
  public static WeakReference<AppBrandVideoView> pJm;
  public static WeakReference<AppBrandVideoWrapper> pJn;
  public static WeakReference<TextView> pJo;
  public static MTimerHandler pJp;
  public static final a pJq;
  public static boolean pJr;
  public static String pJs;
  private static int[] pJt;
  public static int[] pJu;
  private static final MMKVSlotManager pJv;
  public static HashSet<String> pJw;
  public static HashMap<Long, WeakReference<ad>> pJx;
  private static final HashSet<String> pJy;
  public static final MPVideoPreviewMgr pJz;
  
  static
  {
    AppMethodBeat.i(195955);
    pJz = new MPVideoPreviewMgr();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
    pJj = com.tencent.mm.plugin.webview.ui.tools.video.a.gic();
    pJq = new a();
    pJs = "";
    localObject = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewMgr");
    p.g(localObject, "MultiProcessMMKV.getMMKV(TAG)");
    pJv = new MMKVSlotManager((MultiProcessMMKV)localObject, 14400L);
    pJw = new HashSet();
    pJx = new HashMap();
    pJy = new HashSet();
    AppMethodBeat.o(195955);
  }
  
  private static void BM(long paramLong)
  {
    AppMethodBeat.i(195937);
    Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewAd except = ".concat(String.valueOf(paramLong)));
    Iterator localIterator = ((Map)pJx).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Number)((Map.Entry)localObject).getKey()).longValue() != paramLong)
      {
        localObject = (ad)((WeakReference)((Map.Entry)localObject).getValue()).get();
        if (localObject != null) {
          ((ad)localObject).setVideoStatus(3);
        }
      }
    }
    AppMethodBeat.o(195937);
  }
  
  private static void I(LinkedList<kotlin.o<z, View>> paramLinkedList)
  {
    kotlin.g.a.q localq = null;
    AppMethodBeat.i(195936);
    Object localObject2 = (kotlin.g.a.b)c.pJO;
    Object localObject1 = new LinkedList();
    Object localObject3 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label118:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (((Number)((kotlin.g.a.b)localObject2).invoke(((kotlin.o)localObject4).second)).floatValue() != 0.0F) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label118;
        }
        paramLinkedList.add(localObject4);
        break;
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList size = " + ((LinkedList)localObject1).size());
    if (Util.isNullOrNil((List)localObject1))
    {
      cqK();
      cqJ();
      AppMethodBeat.o(195936);
      return;
    }
    if (((LinkedList)localObject1).size() <= 1) {
      paramLinkedList = (kotlin.o)((LinkedList)localObject1).get(0);
    }
    label291:
    label1446:
    label1455:
    for (;;)
    {
      localObject2 = (z)paramLinkedList.first;
      localObject3 = r((z)localObject2);
      pJq.pJA = ((z)localObject2);
      switch (((z)localObject2).field_type)
      {
      default: 
        if (((z)localObject2).gAs())
        {
          localObject1 = ((z)localObject2).NQr;
          if (localObject1 != null)
          {
            localObject1 = ((dkr)localObject1).MOG;
            if (localObject1 == null) {
              break label1446;
            }
            pJq.akb = ((z)localObject2).NQr.MOG.size();
            localObject1 = paramLinkedList.second;
            paramLinkedList = (LinkedList<kotlin.o<z, View>>)localObject1;
            if (!(localObject1 instanceof ViewGroup)) {
              paramLinkedList = null;
            }
            localObject1 = (ViewGroup)paramLinkedList;
            paramLinkedList = aiK((String)localObject3);
          }
        }
        break;
      }
      for (;;)
      {
        if (pJw.contains(localObject3))
        {
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition in blacklist");
          AppMethodBeat.o(195936);
          return;
          paramLinkedList = ((LinkedList)localObject1).get(0);
          p.g(paramLinkedList, "hotList[0]");
          paramLinkedList = (kotlin.o)paramLinkedList;
          localObject1 = ((LinkedList)localObject1).get(1);
          p.g(localObject1, "hotList[1]");
          localObject1 = (kotlin.o)localObject1;
          if (((Number)((kotlin.g.a.b)localObject2).invoke(paramLinkedList.second)).floatValue() >= 0.5D) {
            break label1455;
          }
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList second");
          paramLinkedList = (LinkedList<kotlin.o<z, View>>)localObject1;
          break;
          pJq.d(null);
          localObject1 = null;
          paramLinkedList = "";
          continue;
          localObject1 = s((z)localObject2);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition error");
            AppMethodBeat.o(195936);
            return;
          }
          pJq.d((v)localObject1);
          localObject1 = pJq;
          localObject4 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((z)localObject2).field_msgId, ((z)localObject2).field_content);
          if (localObject4 != null)
          {
            localObject4 = ((u)localObject4).iAd;
            if (localObject4 == null) {}
          }
          for (i = ((LinkedList)localObject4).size();; i = 0)
          {
            ((a)localObject1).akb = i;
            localObject1 = paramLinkedList.second;
            paramLinkedList = (LinkedList<kotlin.o<z, View>>)localObject1;
            if (!(localObject1 instanceof ViewGroup)) {
              paramLinkedList = null;
            }
            localObject1 = (ViewGroup)paramLinkedList;
            paramLinkedList = aiK((String)localObject3);
            break;
          }
          localObject1 = (pi)((pj)((z)localObject2).gAD().Nga.KUf.get(0)).KWy.get(0);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reccard error");
            AppMethodBeat.o(195936);
            return;
          }
          pJq.pJB = ((pi)localObject1);
          pJq.akb = ((z)localObject2).gAD().Nga.KUf.size();
          localObject1 = paramLinkedList.second;
          paramLinkedList = (LinkedList<kotlin.o<z, View>>)localObject1;
          if (!(localObject1 instanceof ViewGroup)) {
            paramLinkedList = null;
          }
          localObject1 = (ViewGroup)paramLinkedList;
          paramLinkedList = aiK((String)localObject3);
          continue;
          localObject1 = null;
          break label291;
        }
        if (((z)localObject2).gAs()) {
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.prt;
        }
        while (((z)localObject2).field_type == 637534257)
        {
          cqK();
          BM(((z)localObject2).field_msgId);
          paramLinkedList = (WeakReference)pJx.get(Long.valueOf(((z)localObject2).field_msgId));
          if (paramLinkedList != null)
          {
            paramLinkedList = (ad)paramLinkedList.get();
            if (paramLinkedList != null)
            {
              paramLinkedList.setVideoStatus(1);
              AppMethodBeat.o(195936);
              return;
              i = com.tencent.mm.plugin.brandservice.ui.timeline.b.prs;
              continue;
            }
          }
          AppMethodBeat.o(195936);
          return;
        }
        if ((((z)localObject2).field_type == 285212721) || (((z)localObject2).field_type == 620757041) || (((z)localObject2).gAs()))
        {
          if ((localObject1 == null) || (((ViewGroup)localObject1).getContext() == null) || (Util.isNullOrNil(paramLinkedList)))
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview parent null or url = ".concat(String.valueOf(paramLinkedList)));
            AppMethodBeat.o(195936);
            return;
          }
          cqJ();
          localObject4 = ((ViewGroup)localObject1).getContext();
          localObject2 = pJk;
          boolean bool1;
          if (localObject2 != null)
          {
            localObject2 = (ViewGroup)((WeakReference)localObject2).get();
            if (localObject2 != null)
            {
              localObject2 = ((ViewGroup)localObject2).getContext();
              bool1 = p.j(localObject4, localObject2);
              localObject2 = pJk;
              if (localObject2 == null) {
                break label1108;
              }
            }
          }
          boolean bool2;
          boolean bool3;
          label1108:
          for (localObject2 = (ViewGroup)((WeakReference)localObject2).get();; localObject2 = null)
          {
            bool2 = p.j(localObject1, localObject2);
            bool3 = p.j(pJs, localObject3);
            localObject4 = new StringBuilder("startPreview sameContext = ").append(bool1).append(", sameParent = ").append(bool2).append(", sameVid = ").append(bool3).append(", visible = ");
            Object localObject5 = pJm;
            localObject2 = localq;
            if (localObject5 != null)
            {
              localObject5 = (AppBrandVideoView)((WeakReference)localObject5).get();
              localObject2 = localq;
              if (localObject5 != null) {
                localObject2 = Integer.valueOf(((AppBrandVideoView)localObject5).getVisibility());
              }
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", localObject2);
            if ((!bool1) || (!bool2) || (!bool3)) {
              break label1114;
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview replay");
            AppMethodBeat.o(195936);
            return;
            localObject2 = null;
            break;
          }
          label1114:
          localObject2 = (kotlin.g.a.m)g.pJS;
          localq = (kotlin.g.a.q)f.pJR;
          localObject4 = ((ViewGroup)localObject1).getContext();
          p.g(localObject4, "context");
          ((kotlin.g.a.m)localObject2).invoke(Boolean.valueOf(bool1), localObject4);
          localq.d(Boolean.valueOf(bool2), localObject1, Integer.valueOf(i));
          if (!bool3)
          {
            localObject1 = pJm;
            if (localObject1 != null)
            {
              localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
              if (localObject1 != null) {
                ((AppBrandVideoView)localObject1).pause();
              }
            }
          }
          pJr = true;
          localObject1 = pJl;
          if (localObject1 != null)
          {
            localObject1 = (View)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((View)localObject1).setAlpha(0.0F);
            }
          }
          pJq.pJI = System.currentTimeMillis();
          pJq.pJD = String.valueOf(System.currentTimeMillis());
          pJq.aiO("PREPARE");
          pJs = (String)localObject3;
          localObject1 = pJm;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setAutoPlay(true);
            }
          }
          localObject1 = pJm;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setMute(true);
            }
          }
          localObject1 = pJm;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setLoop(true);
            }
          }
          localObject1 = pJm;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).e(paramLinkedList, false, 0);
            }
          }
          paramLinkedList = pJm;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null)
            {
              paramLinkedList.start();
              AppMethodBeat.o(195936);
              return;
            }
          }
        }
        AppMethodBeat.o(195936);
        return;
        localObject1 = null;
        paramLinkedList = "";
      }
    }
  }
  
  private static void J(LinkedList<kotlin.o<z, View>> paramLinkedList)
  {
    AppMethodBeat.i(195944);
    HashSet localHashSet = new HashSet();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      String str = r((z)((kotlin.o)paramLinkedList.next()).first);
      if (pJw.contains(str))
      {
        localHashSet.add(str);
        Log.i("MicroMsg.MPVideoPreviewMgr", "removeBlackList still vid = ".concat(String.valueOf(str)));
      }
    }
    pJw = localHashSet;
    AppMethodBeat.o(195944);
  }
  
  public static void a(z paramz, ad paramad)
  {
    AppMethodBeat.i(195953);
    p.h(paramz, "info");
    p.h(paramad, "cardTmpl");
    if (!pJj)
    {
      AppMethodBeat.o(195953);
      return;
    }
    ((Map)pJx).put(Long.valueOf(paramz.field_msgId), new WeakReference(paramad));
    AppMethodBeat.o(195953);
  }
  
  public static void a(final z paramz, String paramString)
  {
    AppMethodBeat.i(195954);
    p.h(paramz, "info");
    p.h(paramString, "extra");
    if (!pJj)
    {
      AppMethodBeat.o(195954);
      return;
    }
    d locald = new d(paramString, paramz);
    switch (paramz.field_type)
    {
    default: 
      if (paramz.gAs()) {
        locald.invoke();
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(195954);
          return;
          switch (paramString.hashCode())
          {
          default: 
            AppMethodBeat.o(195954);
            return;
          }
        } while (!paramString.equals("PAUSE_FOR_RESUME"));
        aiH("PAUSE_FOR_RESUME");
        AppMethodBeat.o(195954);
        return;
        locald.invoke();
        AppMethodBeat.o(195954);
        return;
        BM(0L);
      } while (pJq.pJA == null);
      paramz = pJq.pJA;
    } while ((paramz != null) && (paramz.field_type == 637534257));
    aiH("PAUSE_FOR_RESUME");
    AppMethodBeat.o(195954);
  }
  
  public static void aiH(String paramString)
  {
    AppMethodBeat.i(195942);
    if (!pJj)
    {
      AppMethodBeat.o(195942);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195942);
      return;
    }
    pJq.aiO(paramString);
    AppMethodBeat.o(195942);
  }
  
  public static void aiI(String paramString)
  {
    AppMethodBeat.i(195943);
    if (!pJj)
    {
      AppMethodBeat.o(195943);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195943);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", "triggerEvent status = " + pJq.pJC + ", event = " + paramString);
    Object localObject = pJq.pJC;
    if (localObject == null) {}
    while (paramString == null)
    {
      AppMethodBeat.o(195943);
      return;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case -103903604: 
        if (((String)localObject).equals("PAUSE_FOR_RESUME"))
        {
          if (paramString == null)
          {
            AppMethodBeat.o(195943);
            return;
          }
          switch (paramString.hashCode())
          {
          default: 
          case -592677033: 
            do
            {
              AppMethodBeat.o(195943);
              return;
            } while ((!paramString.equals("ONPAUSE")) || (Util.isNullOrNil(pJs)));
            paramString = pJm;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.pause();
              }
            }
            paramString = pJq;
            localObject = pJm;
            if (localObject != null)
            {
              localObject = (AppBrandVideoView)((WeakReference)localObject).get();
              if (localObject == null) {
                break;
              }
            }
            break;
          }
          for (long l = ((AppBrandVideoView)localObject).getCurrPosMs();; l = 0L)
          {
            paramString.pJH = l;
            pJq.pl(4);
            AppMethodBeat.o(195943);
            return;
            if ((!paramString.equals("ONRESUME")) || (Util.isNullOrNil(pJs))) {
              break;
            }
            paramString = pJm;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.start();
              }
            }
            pJq.pJI = System.currentTimeMillis();
            pJq.pJJ = System.currentTimeMillis();
            pJq.pJD = String.valueOf(System.currentTimeMillis());
            aiH("PLAY");
            pJq.pl(2);
            break;
          }
        }
        break;
      }
    }
    switch (paramString.hashCode())
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(195943);
        return;
        if ((paramString.equals("ONPAUSE")) && (!Util.isNullOrNil(pJs))) {
          MMHandlerThread.postToMainThreadDelayed((Runnable)e.pJQ, 500L);
        }
      }
    } while (!paramString.equals("ONRESUME"));
    AppMethodBeat.o(195943);
  }
  
  public static void aiJ(String paramString)
  {
    AppMethodBeat.i(195945);
    if (!pJj)
    {
      AppMethodBeat.o(195945);
      return;
    }
    if (Util.isNullOrNil(pJs))
    {
      AppMethodBeat.o(195945);
      return;
    }
    Object localObject1;
    if (p.j(pJs, paramString))
    {
      localObject1 = pJn;
      if (localObject1 != null)
      {
        localObject1 = (AppBrandVideoWrapper)((WeakReference)localObject1).get();
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(195945);
        return;
      }
      p.g(localObject1, "weakVideoWrapper?.get() ?: return");
      Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
      localObject2 = pJs;
      int i = ((AppBrandVideoWrapper)localObject1).getCurrPosSec();
      int j = (int)(System.currentTimeMillis() / 1000L + 600L);
      if (localObject1 != null)
      {
        localObject1 = ((AppBrandVideoWrapper)localObject1).getTexture();
        if (localObject1 != null)
        {
          localObject1 = ((TextureView)localObject1).getBitmap();
          com.tencent.mm.plugin.webview.ui.tools.video.a.a((String)localObject2, i, j, (Bitmap)localObject1);
          Log.i("MicroMsg.MPVideoPreviewMgr", "addBlackList vid = ".concat(String.valueOf(paramString)));
          pJw.add(paramString);
        }
      }
    }
    else
    {
      paramString = pJq;
      localObject1 = pJm;
      if (localObject1 == null) {
        break label258;
      }
      localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        break label258;
      }
    }
    label258:
    for (long l = ((AppBrandVideoView)localObject1).getCurrPosMs();; l = 0L)
    {
      paramString.pJH = l;
      pJq.pl(4);
      pJq.pl(3);
      pJq.pJA = null;
      pJq.d(null);
      aiH("IDLE");
      AppMethodBeat.o(195945);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private static String aiK(String paramString)
  {
    AppMethodBeat.i(195947);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid null");
      AppMethodBeat.o(195947);
      return "";
    }
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)pJv.getSlot();
    String str = localMultiProcessMMKV.decodeString("MicroMsg.MPVideoPreviewMgr_" + paramString + "_url");
    if (!Util.isNullOrNil(str))
    {
      long l = localMultiProcessMMKV.decodeLong("MicroMsg.MPVideoPreviewMgr_" + paramString + "_time");
      if (System.currentTimeMillis() - l > 14400000L)
      {
        Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl expire");
        str = "";
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + paramString + ", url = " + str);
      AppMethodBeat.o(195947);
      return str;
    }
  }
  
  public static int aiL(String paramString)
  {
    AppMethodBeat.i(195948);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)pJq.pJF.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(195948);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static int aiM(String paramString)
  {
    AppMethodBeat.i(195949);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)pJq.pJG.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(195949);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static String aiN(String paramString)
  {
    AppMethodBeat.i(195950);
    if (!pJj)
    {
      AppMethodBeat.o(195950);
      return "";
    }
    String str = "";
    if (p.j(pJs, paramString)) {
      str = pJq.pJD;
    }
    AppMethodBeat.o(195950);
    return str;
  }
  
  public static void cqK()
  {
    AppMethodBeat.i(195939);
    Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewVideo");
    Object localObject1 = pJq;
    Object localObject2 = pJm;
    long l;
    if (localObject2 != null)
    {
      localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        l = ((AppBrandVideoView)localObject2).getCurrPosMs();
        ((a)localObject1).pJH = l;
        pJq.pl(4);
        pJq.pJA = null;
        pJq.d(null);
        pJq.aiO("IDLE");
        localObject1 = pJm;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).setAutoPlay(false);
          }
        }
        localObject1 = pJm;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).pause();
          }
        }
        localObject1 = pJm;
        if (localObject1 == null) {
          break label232;
        }
        localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break label232;
        }
      }
    }
    label232:
    for (int i = ((AppBrandVideoView)localObject1).getCurrPosSec();; i = 0)
    {
      if (i > 0)
      {
        localObject1 = pJm;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).bIX();
          }
        }
      }
      localObject1 = pJl;
      if (localObject1 != null)
      {
        localObject1 = (View)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((View)localObject1).setAlpha(0.0F);
        }
      }
      pJs = "";
      stopTimer();
      AppMethodBeat.o(195939);
      return;
      l = 0L;
      break;
    }
  }
  
  public static void q(z arg0)
  {
    v localv = null;
    AppMethodBeat.i(195946);
    p.h(???, "info");
    if (!pJj)
    {
      AppMethodBeat.o(195946);
      return;
    }
    kotlin.g.a.m localm = (kotlin.g.a.m)b.pJM;
    Object localObject3;
    switch (???.field_type)
    {
    default: 
      if (!???.gAs()) {
        break label718;
      }
      ??? = ???.NQr;
      if (??? == null) {
        break label718;
      }
      ??? = ???.MOG;
      if (??? == null) {
        break label718;
      }
      ??? = (dlb)???.get(0);
      if (??? == null) {
        break label718;
      }
      localObject3 = ???.MOY;
      if (localObject3 == null) {
        break label718;
      }
      ??? = ((cdu)localObject3).Mjm;
      if (??? == null) {
        break;
      }
    }
    boolean bool;
    for (??? = ???.KSu; (Util.isNullOrNil(???)) || (Util.isNullOrNil(((cdu)localObject3).KSj)); ??? = null)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
      AppMethodBeat.o(195946);
      return;
      ??? = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(???.field_msgId, ???.field_content);
      if (??? != null)
      {
        if (??? != null)
        {
          ??? = ???.iAd;
          if (??? != null)
          {
            localv = (v)???.get(0);
            if (localv != null)
            {
              if (localv.type == 5) {}
              synchronized (pJz)
              {
                bool = pJy.contains(localv.vid);
                if (bool)
                {
                  AppMethodBeat.o(195946);
                  return;
                }
                localObject3 = x.SXb;
                if (Util.isNullOrNil(aiK(localv.vid)))
                {
                  pJy.add(localv.vid);
                  localm.invoke(localv.vid, localv.url);
                }
                AppMethodBeat.o(195946);
                return;
              }
            }
          }
        }
        AppMethodBeat.o(195946);
        return;
      }
      AppMethodBeat.o(195946);
      return;
      ??? = ???.gAD();
      if (??? != null)
      {
        ??? = ???.Nga;
        if (??? != null)
        {
          ??? = ???.KUf;
          if (??? != null)
          {
            ??? = (pj)???.get(0);
            if (??? != null)
            {
              ??? = ???.KWy;
              if (??? != null)
              {
                pi localpi = (pi)???.get(0);
                if (localpi != null)
                {
                  if ((Util.isNullOrNil(localpi.KSu)) || (Util.isNullOrNil(localpi.KSj)))
                  {
                    Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
                    AppMethodBeat.o(195946);
                    return;
                  }
                  synchronized (pJz)
                  {
                    bool = pJy.contains(localpi.KSu);
                    if (bool)
                    {
                      AppMethodBeat.o(195946);
                      return;
                    }
                    localObject3 = x.SXb;
                    if (Util.isNullOrNil(aiK(localpi.KSu)))
                    {
                      pJy.add(localpi.KSu);
                      localm.invoke(localpi.KSu, localpi.KSj);
                    }
                    AppMethodBeat.o(195946);
                    return;
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(195946);
      return;
    }
    for (;;)
    {
      synchronized (pJz)
      {
        Iterable localIterable = (Iterable)pJy;
        ??? = ((cdu)localObject3).Mjm;
        if (??? != null)
        {
          ??? = ???.KSu;
          bool = j.a(localIterable, ???);
          if (bool) {
            AppMethodBeat.o(195946);
          }
        }
        else
        {
          ??? = null;
          continue;
        }
        ??? = x.SXb;
        ??? = ((cdu)localObject3).Mjm;
        if (??? != null)
        {
          ??? = ???.KSu;
          if (Util.isNullOrNil(aiK(???)))
          {
            ??? = pJy;
            ??? = ((cdu)localObject3).Mjm;
            if (??? == null) {
              break label713;
            }
            ??? = ???.KSu;
            if (??? == null) {
              p.hyc();
            }
            ((HashSet)???).add(???);
            ??? = ((cdu)localObject3).Mjm;
            ??? = localObject2;
            if (??? != null) {
              ??? = ((eqv)???).KSu;
            }
            localm.invoke(???, ((cdu)localObject3).KSj);
          }
          AppMethodBeat.o(195946);
          return;
        }
      }
      ??? = null;
      continue;
      label713:
      ??? = null;
    }
    label718:
    AppMethodBeat.o(195946);
  }
  
  private static String r(z paramz)
  {
    AppMethodBeat.i(195951);
    String str = "";
    Object localObject;
    if (paramz.gAs())
    {
      paramz = paramz.NQr;
      if (paramz != null)
      {
        paramz = paramz.MOG;
        if (paramz != null)
        {
          paramz = (dlb)paramz.get(0);
          if (paramz != null)
          {
            paramz = paramz.MOY;
            if (paramz != null)
            {
              paramz = paramz.Mjm;
              if (paramz != null)
              {
                localObject = paramz.KSu;
                paramz = (z)localObject;
                if (localObject != null) {
                  break label79;
                }
              }
            }
          }
        }
      }
      paramz = "";
      label79:
      AppMethodBeat.o(195951);
      return paramz;
    }
    switch (paramz.field_type)
    {
    default: 
      localObject = str;
      if (paramz.gAs())
      {
        paramz = paramz.NQr;
        if (paramz != null)
        {
          paramz = paramz.MOG;
          if (paramz != null)
          {
            paramz = (dlb)paramz.get(0);
            if (paramz != null)
            {
              paramz = paramz.MOY;
              if (paramz != null)
              {
                paramz = paramz.Mjm;
                if (paramz != null)
                {
                  paramz = paramz.KSu;
                  localObject = paramz;
                  if (paramz != null) {
                    break;
                  }
                }
              }
            }
          }
        }
        localObject = "";
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(195951);
      return localObject;
      paramz = s(paramz);
      if (paramz != null)
      {
        paramz = paramz.vid;
        localObject = paramz;
        if (paramz != null) {}
      }
      else
      {
        localObject = "";
        continue;
        localObject = str;
        if (paramz.gAD() != null) {
          switch (paramz.gAD().style)
          {
          default: 
            localObject = str;
            break;
          case 101: 
          case 102: 
            localObject = ((pi)((pj)paramz.gAD().Nga.KUf.get(0)).KWy.get(0)).KSu;
            p.g(localObject, "this.tlRecCardWrapper.ex…Info[0].AppMsg[0].VideoId");
            continue;
            paramz = paramz.gAG();
            localObject = paramz;
            if (paramz == null) {
              localObject = "";
            }
            break;
          }
        }
      }
    }
  }
  
  private static v s(z paramz)
  {
    AppMethodBeat.i(195952);
    paramz = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramz.field_msgId, paramz.field_content);
    if ((paramz != null) && (paramz != null))
    {
      paramz = paramz.iAd;
      if (paramz != null)
      {
        paramz = (v)paramz.get(0);
        if ((paramz != null) && (paramz.type == 5))
        {
          AppMethodBeat.o(195952);
          return paramz;
        }
      }
    }
    AppMethodBeat.o(195952);
    return null;
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(195940);
    if (pJp == null) {
      pJp = new MTimerHandler((MTimerHandler.CallBack)h.pJU, true);
    }
    MTimerHandler localMTimerHandler = pJp;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    localMTimerHandler = pJp;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.startTimer(1000L);
      AppMethodBeat.o(195940);
      return;
    }
    AppMethodBeat.o(195940);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(195941);
    MTimerHandler localMTimerHandler = pJp;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.stopTimer();
      AppMethodBeat.o(195941);
      return;
    }
    AppMethodBeat.o(195941);
  }
  
  public final void a(String paramString, StoryListView paramStoryListView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(195935);
    p.h(paramString, "reason");
    p.h(paramStoryListView, "list");
    p.h(paramb, "adapter");
    if (!pJj)
    {
      AppMethodBeat.o(195935);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reason = ".concat(String.valueOf(paramString)));
    if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!h.isFreeSimCard()))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition not wifi");
      AppMethodBeat.o(195935);
      return;
    }
    if (pJt != null)
    {
      paramString = pJt;
      if ((paramString == null) || (paramString[1] != 0)) {}
    }
    else
    {
      paramString = new int[2];
      paramStoryListView.getLocationInWindow(paramString);
      localObject = new int[2];
      pJt = (int[])localObject;
      localObject[0] = paramString[1];
      localObject = pJt;
      if (localObject == null) {
        p.hyc();
      }
      paramString[1] += paramStoryListView.getHeight() * 2 / 3;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = paramStoryListView.getFirstVisiblePosition();
    int k = paramStoryListView.getLastVisiblePosition();
    Object localObject = new StringBuilder("checkPosition x = ");
    paramString = pJt;
    label237:
    int i;
    label297:
    z localz;
    if (paramString != null)
    {
      paramString = Integer.valueOf(paramString[0]);
      localObject = ((StringBuilder)localObject).append(paramString).append(", y = ");
      paramString = pJt;
      if (paramString == null) {
        break label548;
      }
      paramString = Integer.valueOf(paramString[1]);
      Log.i("MicroMsg.MPVideoPreviewMgr", paramString + ", height = " + paramStoryListView.getHeight() + ", startPos = " + j + ", endPos = " + k);
      if (j > k) {
        break label1028;
      }
      i = j;
      if (i != 0)
      {
        localz = paramb.De(i - 1);
        if (localz != null) {
          switch (localz.field_type)
          {
          default: 
            if (localz.gAs())
            {
              paramString = (WeakReference)pJx.get(Long.valueOf(localz.field_msgId));
              if (paramString == null) {
                break label1023;
              }
            }
            break;
          }
        }
      }
    }
    label548:
    label1021:
    label1023:
    for (paramString = (ad)paramString.get();; paramString = null)
    {
      if ((paramString != null) && (paramString.cmS() == true) && (paramString.getVideoView() != null))
      {
        localObject = localz.NQr;
        if (localObject != null)
        {
          localObject = ((dkr)localObject).MOG;
          if (localObject != null)
          {
            localObject = (dlb)((LinkedList)localObject).get(0);
            if (localObject != null)
            {
              localObject = ((dlb)localObject).MOY;
              if ((localObject != null) && (((cdu)localObject).iAb == 5))
              {
                paramString = paramString.getVideoView();
                if (paramString == null) {
                  p.hyc();
                }
                localLinkedList.add(new kotlin.o(localz, paramString));
                ((Map)pJq.pJE).put(r(localz), Integer.valueOf(i));
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i == k) {
          break label1028;
        }
        i += 1;
        break label297;
        paramString = null;
        break;
        paramString = null;
        break label237;
        paramString = (WeakReference)pJx.get(Long.valueOf(localz.field_msgId));
        if (paramString != null) {}
        for (paramString = (ad)paramString.get();; paramString = null)
        {
          if ((paramString == null) || (!paramString.cmS()) || (paramString.getVideoView() == null) || (Util.isNullOrNil(localz.gAG()))) {
            break label675;
          }
          localObject = r(localz);
          paramString = paramString.getVideoView();
          if (paramString == null) {
            p.hyc();
          }
          localLinkedList.add(new kotlin.o(localz, paramString));
          ((Map)pJq.pJE).put(localObject, Integer.valueOf(i));
          break;
        }
        continue;
        v localv = s(localz);
        if (localv != null)
        {
          paramString = paramStoryListView.getChildAt(i - j);
          if (paramString != null) {}
          for (paramString = paramString.getTag();; paramString = null)
          {
            localObject = paramString;
            if (!(paramString instanceof ak)) {
              localObject = null;
            }
            paramString = (ak)localObject;
            if (paramString == null) {
              break;
            }
            paramString = paramString.pxN;
            if (paramString == null) {
              break;
            }
            paramString = paramString.ptQ;
            if (paramString == null) {
              break;
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition has TopVideo, index = " + (i - j));
            localLinkedList.add(new kotlin.o(localz, paramString));
            paramString = (Map)pJq.pJE;
            localObject = localv.vid;
            p.g(localObject, "top.vid");
            paramString.put(localObject, Integer.valueOf(i));
            break;
          }
          paramString = (WeakReference)pJx.get(Long.valueOf(localz.field_msgId));
          if (paramString != null) {}
          for (paramString = (ad)paramString.get();; paramString = null)
          {
            if ((paramString == null) || (!paramString.cmS()) || (paramString.getVideoView() == null) || (localz.gAD() == null)) {
              break label1021;
            }
            switch (localz.gAD().style)
            {
            default: 
              break;
            case 101: 
            case 102: 
              if (((pi)((pj)localz.gAD().Nga.KUf.get(0)).KWy.get(0)).iAb != 5) {
                break;
              }
              paramString = paramString.getVideoView();
              if (paramString == null) {
                p.hyc();
              }
              localLinkedList.add(new kotlin.o(localz, paramString));
              ((Map)pJq.pJE).put(r(localz), Integer.valueOf(i));
              break;
            }
          }
        }
      }
    }
    label675:
    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition videoInfoList size = " + localLinkedList.size());
    label1028:
    J(localLinkedList);
    if (Util.isNullOrNil((List)localLinkedList))
    {
      cqK();
      cqJ();
      AppMethodBeat.o(195935);
      return;
    }
    I(localLinkedList);
    AppMethodBeat.o(195935);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "", "()V", "autoPlayId", "", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "autoPlayTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAutoPlayTime", "()Ljava/util/HashMap;", "setAutoPlayTime", "(Ljava/util/HashMap;)V", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getBizInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setBizInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "bufferEnd", "", "getBufferEnd", "()J", "setBufferEnd", "(J)V", "bufferStart", "getBufferStart", "setBufferStart", "curPosMs", "getCurPosMs", "setCurPosMs", "hasAutoPlay", "getHasAutoPlay", "setHasAutoPlay", "value", "Lcom/tencent/mm/message/BizReaderItem;", "item", "getItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "prepareEnd", "getPrepareEnd", "setPrepareEnd", "prepareStart", "getPrepareStart", "setPrepareStart", "recAppMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "getRecAppMsg", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "setRecAppMsg", "(Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;)V", "status", "getStatus", "setStatus", "vidToPos", "getVidToPos", "setVidToPos", "videoDuration", "getVideoDuration", "setVideoDuration", "destroy", "", "report", "event", "Status", "plugin-brandservice_release"})
  public static final class a
  {
    public int akb;
    private v iAi;
    public z pJA;
    pi pJB;
    String pJC;
    public String pJD;
    public HashMap<String, Integer> pJE;
    HashMap<String, Integer> pJF;
    HashMap<String, Integer> pJG;
    public long pJH;
    public long pJI;
    public long pJJ;
    public long pJK;
    public long pJL;
    private int videoDuration;
    
    public a()
    {
      AppMethodBeat.i(195914);
      this.pJC = "IDLE";
      this.pJD = "";
      this.pJE = new HashMap();
      this.pJF = new HashMap();
      this.pJG = new HashMap();
      AppMethodBeat.o(195914);
    }
    
    public final void aiO(String paramString)
    {
      AppMethodBeat.i(195912);
      this.pJC = paramString;
      Log.i("MicroMsg.MPVideoPreviewMgr", "PreviewInfo status = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195912);
    }
    
    public final void d(v paramv)
    {
      AppMethodBeat.i(195911);
      this.iAi = paramv;
      if (paramv != null)
      {
        ((Map)this.pJF).put(paramv.vid, Integer.valueOf(1));
        AppMethodBeat.o(195911);
        return;
      }
      this.akb = 0;
      AppMethodBeat.o(195911);
    }
    
    public final void pl(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(195913);
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.pLS;
      localObject1 = this.pJA;
      int i;
      if (localObject1 != null)
      {
        Object localObject3 = MPVideoPreviewMgr.pJz;
        localObject1 = MPVideoPreviewMgr.t((z)localObject1);
        localObject3 = this.pJA;
        if (localObject3 != null)
        {
          localObject2 = MPVideoPreviewMgr.pJz;
          localObject2 = MPVideoPreviewMgr.u((z)localObject3);
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.setEventType(paramInt);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.setVid((String)localObject1);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.aiV((String)localObject2);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.aiU(this.pJD);
          localObject2 = (Integer)((Map)this.pJE).get(localObject1);
          if (localObject2 == null) {
            break label186;
          }
          i = ((Integer)localObject2).intValue();
          label118:
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.DT(i);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BP(this.videoDuration);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(0L);
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(0L);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.report();
        AppMethodBeat.o(195913);
        return;
        localObject1 = null;
        break;
        label186:
        i = 0;
        break label118;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(this.pJJ - this.pJI);
        continue;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(this.pJL - this.pJK);
        if (this.pJJ != 0L)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
          continue;
          if (this.pJJ != 0L)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
            ((Map)this.pJG).put(localObject1, Integer.valueOf((int)com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.crc()));
            continue;
            if (this.pJJ != 0L) {
              com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
            }
          }
        }
      }
    }
    
    public final void setVideoDuration(int paramInt)
    {
      this.videoDuration = (paramInt * 1000);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "vid", "", "url", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.m<String, String, x>
  {
    public static final b pJM;
    
    static
    {
      AppMethodBeat.i(195918);
      pJM = new b();
      AppMethodBeat.o(195918);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "view", "Landroid/view/View;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, Float>
  {
    public static final c pJO;
    
    static
    {
      AppMethodBeat.i(195920);
      pJO = new c();
      AppMethodBeat.o(195920);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"onClick", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(String paramString, z paramz)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(195922);
      Object localObject = this.pJP;
      switch (((String)localObject).hashCode())
      {
      }
      do
      {
        localObject = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.aiJ(MPVideoPreviewMgr.t(paramz));
        localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
        localObject = MPVideoPreviewMgr.pJz;
        com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(MPVideoPreviewMgr.t(paramz));
        AppMethodBeat.o(195922);
        return;
      } while (!((String)localObject).equals("PAUSE_FOR_RESUME"));
      localObject = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.aiH("PAUSE_FOR_RESUME");
      AppMethodBeat.o(195922);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e pJQ;
    
    static
    {
      AppMethodBeat.i(195924);
      pJQ = new e();
      AppMethodBeat.o(195924);
    }
    
    public final void run()
    {
      AppMethodBeat.i(195923);
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqT();
      AppMethodBeat.o(195923);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "same", "", "parent", "Landroid/view/ViewGroup;", "height", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, ViewGroup, Integer, x>
  {
    public static final f pJR;
    
    static
    {
      AppMethodBeat.i(195926);
      pJR = new f();
      AppMethodBeat.o(195926);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "same", "", "context", "Landroid/content/Context;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, Context, x>
  {
    public static final g pJS;
    
    static
    {
      AppMethodBeat.i(195932);
      pJS = new g();
      AppMethodBeat.o(195932);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements MTimerHandler.CallBack
  {
    public static final h pJU;
    
    static
    {
      AppMethodBeat.i(195934);
      pJU = new h();
      AppMethodBeat.o(195934);
    }
    
    public final boolean onTimerExpired()
    {
      int k = 0;
      AppMethodBeat.i(195933);
      Object localObject = MPVideoPreviewMgr.pJz;
      localObject = MPVideoPreviewMgr.cqR();
      TextView localTextView;
      int i;
      if (localObject != null)
      {
        localTextView = (TextView)((WeakReference)localObject).get();
        if (localTextView != null)
        {
          localObject = MPVideoPreviewMgr.pJz;
          localObject = MPVideoPreviewMgr.cqS();
          if (localObject == null) {
            break label162;
          }
          localObject = (AppBrandVideoView)((WeakReference)localObject).get();
          if (localObject == null) {
            break label162;
          }
          i = ((AppBrandVideoView)localObject).getDuration();
          localObject = MPVideoPreviewMgr.pJz;
          localObject = MPVideoPreviewMgr.cqS();
          int j = k;
          if (localObject != null)
          {
            localObject = (AppBrandVideoView)((WeakReference)localObject).get();
            j = k;
            if (localObject != null) {
              j = ((AppBrandVideoView)localObject).getCurrPosMs();
            }
          }
          p.g(localTextView, "it");
          localObject = com.tencent.mm.ag.m.rJ((i * 1000 - j) / 1000);
          if (localObject == null) {
            break label167;
          }
        }
      }
      label162:
      label167:
      for (localObject = (CharSequence)localObject;; localObject = (CharSequence)"")
      {
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(195933);
        return true;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr
 * JD-Core Version:    0.7.0.1
 */