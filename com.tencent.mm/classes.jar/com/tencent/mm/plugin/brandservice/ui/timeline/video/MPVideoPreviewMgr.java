package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.as;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.fxo;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lkotlin.r<Lcom.tencent.mm.storage.ab;Landroid.view.View;>;>;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "blackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSetAlpha", "cgiQueue", "currentVid", "hotLocation", "", "infoToCard", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lkotlin/collections/HashMap;", "previewInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "urlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "videoLocation", "weakParent", "Landroid/view/ViewGroup;", "weakPreview", "Landroid/view/View;", "weakTimer", "Landroid/widget/TextView;", "weakVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "weakVideoWrapper", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoWrapper;", "addBlackList", "", "vid", "autoPlayTime", "", "cgiPlayUrl", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "changeStatus", "status", "checkPosition", "reason", "list", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "checkSameTopVideo", "lastVid", "chooseVideo", "videoInfoList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "clickCard", "extra", "destroy", "doPauseForResume", "event", "doStatusElse", "filterCard", "getAutoPlayId", "getPlayUrl", "isAutoPlay", "registerCard", "cardTmpl", "removeBlackList", "saveVideoInTimeline", "setPlayUrl", "url", "startPreview", "parent", "height", "playUrl", "startTimer", "stopPreviewAd", "except", "stopPreviewVideo", "stopTimer", "triggerEvent", "getBizMMReader", "Lcom/tencent/mm/message/BizMMReader;", "getTitle", "getTopBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getUrl", "getVid", "EmptyControlBar", "Event", "PreviewInfo", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MPVideoPreviewMgr
{
  public static final a vXA;
  public static boolean vXB;
  public static String vXC;
  private static int[] vXD;
  public static int[] vXE;
  private static final MMKVSlotManager vXF;
  public static HashSet<String> vXG;
  public static HashMap<Long, WeakReference<com.tencent.mm.plugin.brandservice.ui.timeline.item.ab>> vXH;
  private static final HashSet<String> vXI;
  public static final MPVideoPreviewMgr vXs;
  public static final boolean vXt;
  public static WeakReference<ViewGroup> vXu;
  public static WeakReference<View> vXv;
  public static WeakReference<AppBrandVideoView> vXw;
  public static WeakReference<AppBrandVideoWrapper> vXx;
  public static WeakReference<TextView> vXy;
  public static MTimerHandler vXz;
  
  static
  {
    AppMethodBeat.i(302365);
    vXs = new MPVideoPreviewMgr();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
    vXt = com.tencent.mm.plugin.webview.ui.tools.video.a.iBO();
    vXA = new a();
    vXC = "";
    localObject = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewMgr");
    s.s(localObject, "getMMKV(TAG)");
    vXF = new MMKVSlotManager((MultiProcessMMKV)localObject, 14400L);
    vXG = new HashSet();
    vXH = new HashMap();
    vXI = new HashSet();
    AppMethodBeat.o(302365);
  }
  
  private static void M(LinkedList<r<com.tencent.mm.storage.ab, View>> paramLinkedList)
  {
    AppMethodBeat.i(302160);
    Object localObject2 = (kotlin.g.a.b)c.vXW;
    Object localObject1 = new LinkedList();
    Object localObject3 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label95:
    label122:
    label125:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (((Number)((kotlin.g.a.b)localObject2).invoke(((r)localObject4).bsD)).floatValue() == 0.0F)
      {
        i = 1;
        if (i != 0) {
          break label122;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label125;
        }
        paramLinkedList.add(localObject4);
        break;
        i = 0;
        break label95;
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    Log.i("MicroMsg.MPVideoPreviewMgr", s.X("checkPosition hotList size = ", Integer.valueOf(((LinkedList)localObject1).size())));
    if (Util.isNullOrNil((List)localObject1))
    {
      dhC();
      dhB();
      AppMethodBeat.o(302160);
      return;
    }
    if (((LinkedList)localObject1).size() <= 1) {
      paramLinkedList = (r)((LinkedList)localObject1).get(0);
    }
    label1410:
    for (;;)
    {
      localObject4 = (com.tencent.mm.storage.ab)paramLinkedList.bsC;
      localObject3 = q((com.tencent.mm.storage.ab)localObject4);
      localObject2 = "";
      vXA.vXJ = ((com.tencent.mm.storage.ab)localObject4);
      switch (((com.tencent.mm.storage.ab)localObject4).field_type)
      {
      default: 
        if (((com.tencent.mm.storage.ab)localObject4).iYd())
        {
          localObject1 = ((com.tencent.mm.storage.ab)localObject4).acFJ;
          if (localObject1 == null)
          {
            localObject1 = null;
            label291:
            if (localObject1 == null) {
              break label1401;
            }
            vXA.bUo = ((com.tencent.mm.storage.ab)localObject4).acFJ.abrC.size();
            paramLinkedList = paramLinkedList.bsD;
            if (!(paramLinkedList instanceof ViewGroup)) {
              break label714;
            }
            paramLinkedList = (ViewGroup)paramLinkedList;
            label330:
            localObject1 = ajV((String)localObject3);
          }
        }
        break;
      }
      for (;;)
      {
        if (vXG.contains(localObject3))
        {
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition in blacklist");
          AppMethodBeat.o(302160);
          return;
          paramLinkedList = ((LinkedList)localObject1).get(0);
          s.s(paramLinkedList, "hotList[0]");
          paramLinkedList = (r)paramLinkedList;
          localObject1 = ((LinkedList)localObject1).get(1);
          s.s(localObject1, "hotList[1]");
          localObject1 = (r)localObject1;
          if (((Number)((kotlin.g.a.b)localObject2).invoke(paramLinkedList.bsD)).floatValue() >= 0.5D) {
            break label1410;
          }
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList second");
          paramLinkedList = (LinkedList<r<com.tencent.mm.storage.ab, View>>)localObject1;
          break;
          vXA.d(null);
          paramLinkedList = null;
          localObject1 = localObject2;
          continue;
          localObject1 = r((com.tencent.mm.storage.ab)localObject4);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition error");
            AppMethodBeat.o(302160);
            return;
          }
          vXA.d((v)localObject1);
          localObject1 = vXA;
          localObject2 = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(((com.tencent.mm.storage.ab)localObject4).field_msgId, ((com.tencent.mm.storage.ab)localObject4).field_content);
          if (localObject2 == null)
          {
            i = 0;
            label531:
            ((a)localObject1).bUo = i;
            paramLinkedList = paramLinkedList.bsD;
            if (!(paramLinkedList instanceof ViewGroup)) {
              break label590;
            }
          }
          label590:
          for (paramLinkedList = (ViewGroup)paramLinkedList;; paramLinkedList = null)
          {
            localObject1 = ajV((String)localObject3);
            break;
            localObject2 = ((com.tencent.mm.message.u)localObject2).nUC;
            if (localObject2 == null)
            {
              i = 0;
              break label531;
            }
            i = ((LinkedList)localObject2).size();
            break label531;
          }
          localObject1 = (qn)((qo)((com.tencent.mm.storage.ab)localObject4).iYp().abLM.YSB.get(0)).YVI.get(0);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reccard error");
            AppMethodBeat.o(302160);
            return;
          }
          vXA.vXK = ((qn)localObject1);
          vXA.bUo = ((com.tencent.mm.storage.ab)localObject4).iYp().abLM.YSB.size();
          paramLinkedList = paramLinkedList.bsD;
          if ((paramLinkedList instanceof ViewGroup)) {}
          for (paramLinkedList = (ViewGroup)paramLinkedList;; paramLinkedList = null)
          {
            localObject1 = ajV((String)localObject3);
            break;
          }
          localObject1 = ((ene)localObject1).abrC;
          break label291;
          label714:
          paramLinkedList = null;
          break label330;
        }
        if (((com.tencent.mm.storage.ab)localObject4).iYd()) {}
        for (i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGd; ((com.tencent.mm.storage.ab)localObject4).field_type == 637534257; i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGc)
        {
          dhC();
          ko(((com.tencent.mm.storage.ab)localObject4).field_msgId);
          paramLinkedList = (WeakReference)vXH.get(Long.valueOf(((com.tencent.mm.storage.ab)localObject4).field_msgId));
          if (paramLinkedList == null) {
            break label1384;
          }
          paramLinkedList = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)paramLinkedList.get();
          if (paramLinkedList == null) {
            break label1384;
          }
          paramLinkedList.setVideoStatus(1);
          AppMethodBeat.o(302160);
          return;
        }
        if ((((com.tencent.mm.storage.ab)localObject4).field_type == 285212721) || (((com.tencent.mm.storage.ab)localObject4).field_type == 620757041) || (((com.tencent.mm.storage.ab)localObject4).iYd()))
        {
          if ((paramLinkedList == null) || (paramLinkedList.getContext() == null) || (Util.isNullOrNil((String)localObject1)))
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", s.X("startPreview parent null or url = ", localObject1));
            AppMethodBeat.o(302160);
            return;
          }
          dhB();
          localObject4 = paramLinkedList.getContext();
          localObject2 = vXu;
          boolean bool1;
          label916:
          boolean bool2;
          boolean bool3;
          if (localObject2 == null)
          {
            localObject2 = null;
            bool1 = s.p(localObject4, localObject2);
            localObject2 = vXu;
            if (localObject2 != null) {
              break label1062;
            }
            localObject2 = null;
            bool2 = s.p(paramLinkedList, localObject2);
            bool3 = s.p(vXC, localObject3);
            localObject4 = new StringBuilder("startPreview sameContext = ").append(bool1).append(", sameParent = ").append(bool2).append(", sameVid = ").append(bool3).append(", visible = ");
            localObject2 = vXw;
            if (localObject2 != null) {
              break label1075;
            }
            localObject2 = null;
          }
          for (;;)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", localObject2);
            if ((!bool1) || (!bool2) || (!bool3)) {
              break label1109;
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview replay");
            AppMethodBeat.o(302160);
            return;
            localObject2 = (ViewGroup)((WeakReference)localObject2).get();
            if (localObject2 == null)
            {
              localObject2 = null;
              break;
            }
            localObject2 = ((ViewGroup)localObject2).getContext();
            break;
            label1062:
            localObject2 = (ViewGroup)((WeakReference)localObject2).get();
            break label916;
            label1075:
            localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
            if (localObject2 == null) {
              localObject2 = null;
            } else {
              localObject2 = Integer.valueOf(((AppBrandVideoView)localObject2).getVisibility());
            }
          }
          label1109:
          localObject2 = (kotlin.g.a.m)MPVideoPreviewMgr.e.vXY;
          localObject4 = (q)MPVideoPreviewMgr.d.vXX;
          Context localContext = paramLinkedList.getContext();
          s.s(localContext, "context");
          ((kotlin.g.a.m)localObject2).invoke(Boolean.valueOf(bool1), localContext);
          ((q)localObject4).invoke(Boolean.valueOf(bool2), paramLinkedList, Integer.valueOf(i));
          if (!bool3)
          {
            paramLinkedList = vXw;
            if (paramLinkedList != null)
            {
              paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
              if (paramLinkedList != null) {
                paramLinkedList.pause();
              }
            }
          }
          vXB = true;
          paramLinkedList = vXv;
          if (paramLinkedList != null) {
            break label1390;
          }
        }
        label1384:
        label1390:
        for (paramLinkedList = null;; paramLinkedList = (View)paramLinkedList.get())
        {
          if (paramLinkedList != null) {
            paramLinkedList.setAlpha(0.0F);
          }
          vXA.vXR = System.currentTimeMillis();
          vXA.vXM = String.valueOf(System.currentTimeMillis());
          vXA.ajZ("PREPARE");
          vXC = (String)localObject3;
          paramLinkedList = vXw;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null) {
              paramLinkedList.setAutoPlay(true);
            }
          }
          paramLinkedList = vXw;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null) {
              paramLinkedList.setMute(true);
            }
          }
          paramLinkedList = vXw;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null) {
              paramLinkedList.setLoop(true);
            }
          }
          paramLinkedList = vXw;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null) {
              paramLinkedList.e((String)localObject1, false, 0);
            }
          }
          paramLinkedList = vXw;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null) {
              paramLinkedList.start();
            }
          }
          AppMethodBeat.o(302160);
          return;
        }
        label1401:
        paramLinkedList = null;
        localObject1 = localObject2;
      }
    }
  }
  
  private static void N(LinkedList<r<com.tencent.mm.storage.ab, View>> paramLinkedList)
  {
    AppMethodBeat.i(302214);
    HashSet localHashSet = new HashSet();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      String str = q((com.tencent.mm.storage.ab)((r)paramLinkedList.next()).bsC);
      if (vXG.contains(str))
      {
        localHashSet.add(str);
        Log.i("MicroMsg.MPVideoPreviewMgr", s.X("removeBlackList still vid = ", str));
      }
    }
    vXG = localHashSet;
    AppMethodBeat.o(302214);
  }
  
  public static void a(com.tencent.mm.storage.ab paramab, com.tencent.mm.plugin.brandservice.ui.timeline.item.ab paramab1)
  {
    AppMethodBeat.i(302263);
    s.u(paramab, "info");
    s.u(paramab1, "cardTmpl");
    if (!vXt)
    {
      AppMethodBeat.o(302263);
      return;
    }
    ((Map)vXH).put(Long.valueOf(paramab.field_msgId), new WeakReference(paramab1));
    AppMethodBeat.o(302263);
  }
  
  public static void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    AppMethodBeat.i(302266);
    s.u(paramab, "info");
    s.u(paramString, "extra");
    if (!vXt)
    {
      AppMethodBeat.o(302266);
      return;
    }
    switch (paramab.field_type)
    {
    default: 
      if (paramab.iYd()) {
        a(paramString, paramab);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(302266);
      return;
      if (s.p(paramString, "PAUSE_FOR_RESUME"))
      {
        ajS("PAUSE_FOR_RESUME");
        AppMethodBeat.o(302266);
        return;
        a(paramString, paramab);
        AppMethodBeat.o(302266);
        return;
        ko(0L);
        if (vXA.vXJ != null)
        {
          paramab = vXA.vXJ;
          if ((paramab != null) && (paramab.field_type == 637534257)) {}
          for (int i = 1; i == 0; i = 0)
          {
            ajS("PAUSE_FOR_RESUME");
            AppMethodBeat.o(302266);
            return;
          }
        }
      }
    }
  }
  
  private static final void a(String paramString, com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(302279);
    if (s.p(paramString, "PAUSE_FOR_RESUME"))
    {
      ajS("PAUSE_FOR_RESUME");
      AppMethodBeat.o(302279);
      return;
    }
    ajU(q(paramab));
    paramString = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
    com.tencent.mm.plugin.webview.ui.tools.video.a.bmO(q(paramab));
    AppMethodBeat.o(302279);
  }
  
  private static void ajS(String paramString)
  {
    AppMethodBeat.i(302196);
    if (!vXt)
    {
      AppMethodBeat.o(302196);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(302196);
      return;
    }
    vXA.ajZ(paramString);
    AppMethodBeat.o(302196);
  }
  
  public static void ajT(String paramString)
  {
    AppMethodBeat.i(302211);
    if (!vXt)
    {
      AppMethodBeat.o(302211);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(302211);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", "triggerEvent status = " + vXA.vXL + ", event = " + paramString);
    if (s.p(vXA.vXL, "PAUSE_FOR_RESUME"))
    {
      if (s.p(paramString, "ONPAUSE"))
      {
        if (!Util.isNullOrNil(vXC))
        {
          paramString = vXw;
          if (paramString != null)
          {
            paramString = (AppBrandVideoView)paramString.get();
            if (paramString != null) {
              paramString.pause();
            }
          }
          paramString = vXA;
          Object localObject = vXw;
          long l;
          if (localObject == null) {
            l = 0L;
          }
          for (;;)
          {
            paramString.vXQ = l;
            vXA.rG(4);
            AppMethodBeat.o(302211);
            return;
            localObject = (AppBrandVideoView)((WeakReference)localObject).get();
            if (localObject == null) {
              l = 0L;
            } else {
              l = ((AppBrandVideoView)localObject).getCurrPosMs();
            }
          }
        }
      }
      else if ((s.p(paramString, "ONRESUME")) && (!Util.isNullOrNil(vXC)))
      {
        paramString = vXw;
        if (paramString != null)
        {
          paramString = (AppBrandVideoView)paramString.get();
          if (paramString != null) {
            paramString.start();
          }
        }
        vXA.vXR = System.currentTimeMillis();
        vXA.vXS = System.currentTimeMillis();
        vXA.vXM = String.valueOf(System.currentTimeMillis());
        ajS("PLAY");
        vXA.rG(2);
      }
      AppMethodBeat.o(302211);
      return;
    }
    if (s.p(paramString, "ONPAUSE"))
    {
      if (!Util.isNullOrNil(vXC))
      {
        MMHandlerThread.postToMainThreadDelayed(MPVideoPreviewMgr..ExternalSyntheticLambda1.INSTANCE, 500L);
        AppMethodBeat.o(302211);
      }
    }
    else {
      s.p(paramString, "ONRESUME");
    }
    AppMethodBeat.o(302211);
  }
  
  public static void ajU(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(302222);
    if (!vXt)
    {
      AppMethodBeat.o(302222);
      return;
    }
    if (Util.isNullOrNil(vXC))
    {
      AppMethodBeat.o(302222);
      return;
    }
    Object localObject1;
    if (s.p(vXC, paramString))
    {
      localObject1 = vXx;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (AppBrandVideoWrapper)((WeakReference)localObject1).get())
      {
        AppMethodBeat.o(302222);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
      localObject2 = vXC;
      int i = ((AppBrandVideoWrapper)localObject1).getCurrPosSec();
      int j = (int)(System.currentTimeMillis() / 1000L + 600L);
      localObject1 = ((AppBrandVideoWrapper)localObject1).getTexture();
      if (localObject1 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.webview.ui.tools.video.a.a((String)localObject2, i, j, (Bitmap)localObject1);
        Log.i("MicroMsg.MPVideoPreviewMgr", s.X("addBlackList vid = ", paramString));
        vXG.add(paramString);
      }
    }
    else
    {
      paramString = vXA;
      localObject1 = vXw;
      if (localObject1 != null) {
        break label228;
      }
    }
    for (;;)
    {
      paramString.vXQ = l;
      vXA.rG(4);
      vXA.rG(3);
      vXA.vXJ = null;
      vXA.d(null);
      ajS("IDLE");
      AppMethodBeat.o(302222);
      return;
      localObject1 = ((TextureView)localObject1).getBitmap();
      break;
      label228:
      localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
      if (localObject1 != null) {
        l = ((AppBrandVideoView)localObject1).getCurrPosMs();
      }
    }
  }
  
  private static String ajV(String paramString)
  {
    AppMethodBeat.i(302228);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid null");
      AppMethodBeat.o(302228);
      return "";
    }
    String str = MMKVSlotManager.decodeString$default(vXF, "MicroMsg.MPVideoPreviewMgr_" + paramString + "_url", null, 2, null);
    if (!Util.isNullOrNil(str))
    {
      long l = MMKVSlotManager.decodeLong$default(vXF, "MicroMsg.MPVideoPreviewMgr_" + paramString + "_time", 0L, 2, null);
      if (System.currentTimeMillis() - l > 14400000L)
      {
        Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl expire");
        str = "";
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + paramString + ", url = " + str);
      AppMethodBeat.o(302228);
      return str;
    }
  }
  
  public static int ajW(String paramString)
  {
    AppMethodBeat.i(302232);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)vXA.vXO.get(paramString);
      if (paramString == null) {
        i = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(302232);
      return i;
      i = paramString.intValue();
      continue;
      i = 0;
    }
  }
  
  public static int ajX(String paramString)
  {
    AppMethodBeat.i(302236);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)vXA.vXP.get(paramString);
      if (paramString == null) {
        i = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(302236);
      return i;
      i = paramString.intValue();
      continue;
      i = 0;
    }
  }
  
  public static String ajY(String paramString)
  {
    AppMethodBeat.i(302243);
    if (!vXt)
    {
      AppMethodBeat.o(302243);
      return "";
    }
    String str = "";
    if (s.p(vXC, paramString)) {
      str = vXA.vXM;
    }
    AppMethodBeat.o(302243);
    return str;
  }
  
  public static void dhC()
  {
    AppMethodBeat.i(302174);
    Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewVideo");
    Object localObject1 = vXA;
    Object localObject2 = vXw;
    long l;
    int i;
    if (localObject2 == null)
    {
      l = 0L;
      ((a)localObject1).vXQ = l;
      vXA.rG(4);
      vXA.vXJ = null;
      vXA.d(null);
      vXA.ajZ("IDLE");
      localObject1 = vXw;
      if (localObject1 != null)
      {
        localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((AppBrandVideoView)localObject1).setAutoPlay(false);
        }
      }
      localObject1 = vXw;
      if (localObject1 != null)
      {
        localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((AppBrandVideoView)localObject1).pause();
        }
      }
      localObject1 = vXw;
      if (localObject1 != null) {
        break label218;
      }
      i = 0;
      label124:
      if (i > 0)
      {
        localObject1 = vXw;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).c(0.0D, false);
          }
        }
      }
      localObject1 = vXv;
      if (localObject1 != null) {
        break label243;
      }
    }
    label218:
    label243:
    for (localObject1 = null;; localObject1 = (View)((WeakReference)localObject1).get())
    {
      if (localObject1 != null) {
        ((View)localObject1).setAlpha(0.0F);
      }
      vXC = "";
      stopTimer();
      AppMethodBeat.o(302174);
      return;
      localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        l = 0L;
        break;
      }
      l = ((AppBrandVideoView)localObject2).getCurrPosMs();
      break;
      localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
      if (localObject1 == null)
      {
        i = 0;
        break label124;
      }
      i = ((AppBrandVideoView)localObject1).getCurrPosSec();
      break label124;
    }
  }
  
  private static final boolean dhD()
  {
    int j = 0;
    AppMethodBeat.i(302270);
    Object localObject = vXy;
    TextView localTextView;
    int i;
    if (localObject != null)
    {
      localTextView = (TextView)((WeakReference)localObject).get();
      if (localTextView != null)
      {
        localObject = vXw;
        if (localObject != null) {
          break label84;
        }
        i = 0;
        localObject = vXw;
        if (localObject != null) {
          break label109;
        }
        label46:
        localObject = com.tencent.mm.message.m.uD((i * 1000 - j) / 1000);
        if (localObject != null) {
          break label129;
        }
      }
    }
    label129:
    for (localObject = (CharSequence)"";; localObject = (CharSequence)localObject)
    {
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(302270);
      return true;
      label84:
      localObject = (AppBrandVideoView)((WeakReference)localObject).get();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((AppBrandVideoView)localObject).getDuration();
      break;
      label109:
      localObject = (AppBrandVideoView)((WeakReference)localObject).get();
      if (localObject == null) {
        break label46;
      }
      j = ((AppBrandVideoView)localObject).getCurrPosMs();
      break label46;
    }
  }
  
  private static final void dhE()
  {
    AppMethodBeat.i(302273);
    dhC();
    AppMethodBeat.o(302273);
  }
  
  private static void ko(long paramLong)
  {
    AppMethodBeat.i(302165);
    Log.i("MicroMsg.MPVideoPreviewMgr", s.X("stopPreviewAd except = ", Long.valueOf(paramLong)));
    Iterator localIterator = ((Map)vXH).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Number)((Map.Entry)localObject).getKey()).longValue() != paramLong)
      {
        localObject = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)((WeakReference)((Map.Entry)localObject).getValue()).get();
        if (localObject != null) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject).setVideoStatus(3);
        }
      }
    }
    AppMethodBeat.o(302165);
  }
  
  private static String q(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(302252);
    String str = "";
    if (paramab.iYd())
    {
      paramab = paramab.acFJ;
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      paramab = paramab.abrC;
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      paramab = (enp)paramab.get(0);
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      paramab = paramab.abse;
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      paramab = paramab.aaID;
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      paramab = paramab.YQV;
      if (paramab == null)
      {
        AppMethodBeat.o(302252);
        return "";
      }
      AppMethodBeat.o(302252);
      return paramab;
    }
    Object localObject;
    switch (paramab.field_type)
    {
    default: 
      localObject = str;
      if (paramab.iYd())
      {
        paramab = paramab.acFJ;
        if (paramab != null) {
          break label339;
        }
        localObject = "";
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(302252);
      return localObject;
      paramab = r(paramab);
      if (paramab == null)
      {
        localObject = "";
      }
      else
      {
        paramab = paramab.vid;
        localObject = paramab;
        if (paramab == null)
        {
          localObject = "";
          continue;
          localObject = str;
          if (paramab.iYp() != null) {
            switch (paramab.iYp().style)
            {
            default: 
              localObject = str;
              break;
            case 101: 
            case 102: 
              localObject = ((qn)((qo)paramab.iYp().abLM.YSB.get(0)).YVI.get(0)).YQV;
              s.s(localObject, "this.tlRecCardWrapper.ex…Info[0].AppMsg[0].VideoId");
              continue;
              paramab = paramab.iYs();
              localObject = paramab;
              if (paramab == null)
              {
                localObject = "";
                continue;
                label339:
                paramab = paramab.abrC;
                if (paramab == null)
                {
                  localObject = "";
                }
                else
                {
                  paramab = (enp)paramab.get(0);
                  if (paramab == null)
                  {
                    localObject = "";
                  }
                  else
                  {
                    paramab = paramab.abse;
                    if (paramab == null)
                    {
                      localObject = "";
                    }
                    else
                    {
                      paramab = paramab.aaID;
                      if (paramab == null)
                      {
                        localObject = "";
                      }
                      else
                      {
                        paramab = paramab.YQV;
                        localObject = paramab;
                        if (paramab == null) {
                          localObject = "";
                        }
                      }
                    }
                  }
                }
              }
              break;
            }
          }
        }
      }
    }
  }
  
  private static v r(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(302256);
    paramab = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
    if (paramab != null)
    {
      paramab = paramab.nUC;
      if (paramab != null)
      {
        paramab = (v)paramab.get(0);
        if ((paramab != null) && (paramab.type == 5))
        {
          AppMethodBeat.o(302256);
          return paramab;
        }
      }
    }
    AppMethodBeat.o(302256);
    return null;
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(302182);
    if (vXz == null) {
      vXz = new MTimerHandler(MPVideoPreviewMgr..ExternalSyntheticLambda0.INSTANCE, true);
    }
    MTimerHandler localMTimerHandler = vXz;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    localMTimerHandler = vXz;
    if (localMTimerHandler != null) {
      localMTimerHandler.startTimer(1000L);
    }
    AppMethodBeat.o(302182);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(302187);
    MTimerHandler localMTimerHandler = vXz;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    AppMethodBeat.o(302187);
  }
  
  public final void a(String paramString, StoryListView paramStoryListView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(302387);
    s.u(paramString, "reason");
    s.u(paramStoryListView, "list");
    s.u(paramb, "adapter");
    if (!vXt)
    {
      AppMethodBeat.o(302387);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", s.X("checkPosition reason = ", paramString));
    if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!g.isFreeSimCard()))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition not wifi");
      AppMethodBeat.o(302387);
      return;
    }
    int i;
    if (vXD != null)
    {
      paramString = vXD;
      if ((paramString == null) || (paramString[1] != 0)) {
        break label590;
      }
      i = 1;
      if (i == 0) {}
    }
    else
    {
      paramString = new int[2];
      paramStoryListView.getLocationInWindow(paramString);
      localObject = new int[2];
      vXD = (int[])localObject;
      s.checkNotNull(localObject);
      localObject[0] = paramString[1];
      localObject = vXD;
      s.checkNotNull(localObject);
      paramString[1] += paramStoryListView.getHeight() * 2 / 3;
    }
    LinkedList localLinkedList = new LinkedList();
    int k = paramStoryListView.getFirstVisiblePosition();
    int m = paramStoryListView.getLastVisiblePosition();
    Object localObject = new StringBuilder("checkPosition x = ");
    paramString = vXD;
    if (paramString == null)
    {
      paramString = null;
      label210:
      localObject = ((StringBuilder)localObject).append(paramString).append(", y = ");
      paramString = vXD;
      if (paramString != null) {
        break label606;
      }
      paramString = null;
      label234:
      Log.i("MicroMsg.MPVideoPreviewMgr", paramString + ", height = " + paramStoryListView.getHeight() + ", startPos = " + k + ", endPos = " + m);
      if (k <= m) {
        i = k;
      }
    }
    for (;;)
    {
      com.tencent.mm.storage.ab localab;
      if (i != 0)
      {
        localab = paramb.Hk(i - 1);
        if (localab != null) {
          switch (localab.field_type)
          {
          default: 
            if (localab.iYd())
            {
              paramString = (WeakReference)vXH.get(Long.valueOf(localab.field_msgId));
              if (paramString != null) {
                break label1070;
              }
              paramString = null;
              label384:
              if ((paramString == null) || (paramString.ddC() != true)) {
                break label1081;
              }
              j = 1;
              label399:
              if (j != 0)
              {
                if (paramString != null) {
                  break label1087;
                }
                localObject = null;
                label411:
                if (localObject != null)
                {
                  localObject = localab.acFJ;
                  if (localObject == null) {
                    break label1096;
                  }
                  localObject = ((ene)localObject).abrC;
                  if (localObject == null) {
                    break label1096;
                  }
                  localObject = (enp)((LinkedList)localObject).get(0);
                  if (localObject == null) {
                    break label1096;
                  }
                  localObject = ((enp)localObject).abse;
                  if ((localObject == null) || (((ddb)localObject).nUA != 5)) {
                    break label1096;
                  }
                }
              }
            }
            break;
          }
        }
      }
      label1068:
      label1070:
      label1081:
      label1087:
      label1096:
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          paramString = paramString.getVideoView();
          s.checkNotNull(paramString);
          localLinkedList.add(new r(localab, paramString));
          ((Map)vXA.vXN).put(q(localab), Integer.valueOf(i));
        }
        for (;;)
        {
          if (i != m) {
            break label1114;
          }
          Log.i("MicroMsg.MPVideoPreviewMgr", s.X("checkPosition videoInfoList size = ", Integer.valueOf(localLinkedList.size())));
          N(localLinkedList);
          if (!Util.isNullOrNil((List)localLinkedList)) {
            break label1102;
          }
          dhC();
          dhB();
          AppMethodBeat.o(302387);
          return;
          label590:
          i = 0;
          break;
          paramString = Integer.valueOf(paramString[0]);
          break label210;
          label606:
          paramString = Integer.valueOf(paramString[1]);
          break label234;
          paramString = (WeakReference)vXH.get(Long.valueOf(localab.field_msgId));
          if (paramString == null) {}
          for (paramString = null;; paramString = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)paramString.get())
          {
            if ((paramString == null) || (!paramString.ddC()) || (paramString.getVideoView() == null) || (Util.isNullOrNil(localab.iYs()))) {
              break label735;
            }
            localObject = q(localab);
            paramString = paramString.getVideoView();
            s.checkNotNull(paramString);
            localLinkedList.add(new r(localab, paramString));
            ((Map)vXA.vXN).put(localObject, Integer.valueOf(i));
            break;
          }
          label735:
          continue;
          localObject = r(localab);
          if (localObject != null)
          {
            paramString = paramStoryListView.getChildAt(i - k);
            if (paramString == null)
            {
              paramString = null;
              label765:
              if (!(paramString instanceof aj)) {
                break label884;
              }
            }
            label884:
            for (paramString = (aj)paramString;; paramString = null)
            {
              if (paramString == null) {
                break label887;
              }
              paramString = paramString.vMM;
              if (paramString == null) {
                break;
              }
              paramString = paramString.vIV;
              if (paramString == null) {
                break;
              }
              Log.i("MicroMsg.MPVideoPreviewMgr", s.X("checkPosition has TopVideo, index = ", Integer.valueOf(i - k)));
              localLinkedList.add(new r(localab, paramString));
              paramString = (Map)vXA.vXN;
              localObject = ((v)localObject).vid;
              s.s(localObject, "top.vid");
              paramString.put(localObject, Integer.valueOf(i));
              break;
              paramString = paramString.getTag();
              break label765;
            }
            label887:
            continue;
            paramString = (WeakReference)vXH.get(Long.valueOf(localab.field_msgId));
            if (paramString == null) {}
            for (paramString = null;; paramString = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)paramString.get())
            {
              if ((paramString == null) || (!paramString.ddC()) || (paramString.getVideoView() == null) || (localab.iYp() == null)) {
                break label1068;
              }
              switch (localab.iYp().style)
              {
              default: 
                break;
              case 101: 
              case 102: 
                if (((qn)((qo)localab.iYp().abLM.YSB.get(0)).YVI.get(0)).nUA != 5) {
                  break;
                }
                paramString = paramString.getVideoView();
                s.checkNotNull(paramString);
                localLinkedList.add(new r(localab, paramString));
                ((Map)vXA.vXN).put(q(localab), Integer.valueOf(i));
                break;
              }
            }
          }
        }
        paramString = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)paramString.get();
        break label384;
        j = 0;
        break label399;
        localObject = paramString.getVideoView();
        break label411;
      }
      label1102:
      M(localLinkedList);
      AppMethodBeat.o(302387);
      return;
      label1114:
      i += 1;
    }
  }
  
  public final void p(com.tencent.mm.storage.ab paramab)
  {
    ah localah = null;
    AppMethodBeat.i(302400);
    s.u(paramab, "info");
    if (!vXt)
    {
      AppMethodBeat.o(302400);
      return;
    }
    kotlin.g.a.m localm = (kotlin.g.a.m)MPVideoPreviewMgr.b.vXV;
    ddb localddb;
    switch (paramab.field_type)
    {
    default: 
      if (!paramab.iYd()) {
        break label636;
      }
      paramab = paramab.acFJ;
      if (paramab == null) {
        break label636;
      }
      paramab = paramab.abrC;
      if (paramab == null) {
        break label636;
      }
      paramab = (enp)paramab.get(0);
      if (paramab == null) {
        break label636;
      }
      localddb = paramab.abse;
      if (localddb == null) {
        break label636;
      }
      paramab = localddb.aaID;
      if (paramab != null) {
        break;
      }
    }
    boolean bool;
    for (paramab = null; (Util.isNullOrNil(paramab)) || (Util.isNullOrNil(localddb.YQK)); paramab = paramab.YQV)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
      AppMethodBeat.o(302400);
      return;
      paramab = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
      if (paramab == null) {
        break label636;
      }
      paramab = paramab.nUC;
      if (paramab != null)
      {
        paramab = (v)paramab.get(0);
        if ((paramab == null) || (paramab.type != 5)) {}
      }
      try
      {
        bool = vXI.contains(paramab.vid);
        if (bool) {
          return;
        }
        localah = ah.aiuX;
        if (Util.isNullOrNil(ajV(paramab.vid)))
        {
          vXI.add(paramab.vid);
          localm.invoke(paramab.vid, paramab.url);
        }
        AppMethodBeat.o(302400);
        return;
      }
      finally
      {
        AppMethodBeat.o(302400);
      }
      paramab = paramab.iYp();
      if (paramab == null) {
        break label636;
      }
      paramab = paramab.abLM;
      if (paramab == null) {
        break label636;
      }
      paramab = paramab.YSB;
      if (paramab == null) {
        break label636;
      }
      paramab = (qo)paramab.get(0);
      if (paramab == null) {
        break label636;
      }
      paramab = paramab.YVI;
      if (paramab == null) {
        break label636;
      }
      paramab = (qn)paramab.get(0);
      if (paramab == null) {
        break label636;
      }
      if ((Util.isNullOrNil(paramab.YQV)) || (Util.isNullOrNil(paramab.YQK)))
      {
        Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
        AppMethodBeat.o(302400);
        return;
      }
      try
      {
        bool = vXI.contains(paramab.YQV);
        if (bool) {
          return;
        }
        localah = ah.aiuX;
        if (Util.isNullOrNil(ajV(paramab.YQV)))
        {
          vXI.add(paramab.YQV);
          localm.invoke(paramab.YQV, paramab.YQK);
        }
        AppMethodBeat.o(302400);
        return;
      }
      finally
      {
        AppMethodBeat.o(302400);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (Iterable)vXI;
        paramab = localddb.aaID;
        if (paramab == null)
        {
          paramab = null;
          bool = p.a((Iterable)localObject, paramab);
          if (!bool) {}
        }
        else
        {
          paramab = paramab.YQV;
          continue;
        }
        paramab = ah.aiuX;
        paramab = localddb.aaID;
        if (paramab == null)
        {
          paramab = null;
          if (Util.isNullOrNil(ajV(paramab)))
          {
            localObject = vXI;
            paramab = localddb.aaID;
            if (paramab != null) {
              break label662;
            }
            paramab = null;
            s.checkNotNull(paramab);
            ((HashSet)localObject).add(paramab);
            paramab = localddb.aaID;
            if (paramab != null) {
              break label670;
            }
            paramab = localah;
            localm.invoke(paramab, localddb.YQK);
          }
          label636:
          AppMethodBeat.o(302400);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(302400);
      }
      paramab = paramab.YQV;
      continue;
      label662:
      paramab = paramab.YQV;
      continue;
      label670:
      paramab = paramab.YQV;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$EmptyControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addOnVisibilityChangedListener", "", "onVisibilityChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarVisibilityChangedListener;", "enterFullScreen", "flowShow", "getLayoutId", "hide", "hideCenterPlayBtnIfNeed", "init", "isAutoHide", "", "isControlProgressShowing", "isDanmakuBtnOpen", "isFullScreenState", "isShow", "onDestroy", "onFullScreenChange", "quitFullScreen", "resetAutoHideTimer", "seek", "position", "seekForPoint", "setAutoHide", "autoHide", "setBtnCloseListener", "listener", "Landroid/view/View$OnClickListener;", "setDanmakuBtnIcon", "setDanmakuBtnOnClickListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnDanmakuBtnOnClickListener;", "setDanmakuBtnOpen", "setExitFullScreenBtnOnClickListener", "setFullScreenBtn", "setFullScreenBtnOnClickListener", "setFullScreenTitleBar", "setIsPlay", "isPlay", "setMuteBtnOnClickListener", "setMuteBtnState", "isMute", "setOnPlayButtonClickListener", "setOnUpdateProgressLenListener", "onUpdateProgressLenListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarProgressChangedListener;", "setPlayBtn", "setPlayBtnInCenterPosition", "playBtnInCenterPosition", "setPlayBtnState", "setRootLayout", "setShowControlProgress", "showControlProgress", "setShowDanmakuBtn", "show", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setStatePorter", "porter", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "setTimeTextSize", "setTitle", "title", "", "setVideoTotalTime", "seconds", "setVisibility", "visibility", "showCenterPlayBtnIfNeed", "showControlProgressInternal", "stopCacheUpdate", "toggleDanmakuBtn", "toggleShow", "triggerCacheUpdate", "updateLayoutMargins", "updateMiddleBar", "updateProgress", "progressLen", "totalLen", "updateVideoStatus", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class EmptyControlBar
    extends VideoPlayerSeekBar
    implements d.a, d.b
  {
    public EmptyControlBar(Context paramContext)
    {
      super();
      AppMethodBeat.i(302081);
      AppMethodBeat.o(302081);
    }
    
    public EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(302086);
      AppMethodBeat.o(302086);
    }
    
    public EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(302095);
      AppMethodBeat.o(302095);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.f paramf)
    {
      AppMethodBeat.i(302300);
      s.u(paramf, "onVisibilityChangedListener");
      AppMethodBeat.o(302300);
    }
    
    public final void anJ() {}
    
    public final void csz() {}
    
    public final void cuX() {}
    
    public final boolean cvA()
    {
      return false;
    }
    
    public final boolean cvq()
    {
      return false;
    }
    
    public final void cvr() {}
    
    public final void cvs() {}
    
    public final boolean cvt()
    {
      return false;
    }
    
    public final boolean cvu()
    {
      return false;
    }
    
    public final boolean cvv()
    {
      return true;
    }
    
    public final void cvw() {}
    
    public final void cvx() {}
    
    public final void cvy() {}
    
    public final void cvz() {}
    
    public final void cxb() {}
    
    public final int getLayoutId()
    {
      return com.tencent.mm.plugin.brandservice.d.f.biz_timeline_preview_control_bar;
    }
    
    public final void hide() {}
    
    public final void init() {}
    
    public final void jJ(boolean paramBoolean) {}
    
    public final void onDestroy() {}
    
    public final void seek(int paramInt) {}
    
    public final void setAutoHide(boolean paramBoolean) {}
    
    public final void setBtnCloseListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(302128);
      s.u(paramOnClickListener, "listener");
      AppMethodBeat.o(302128);
    }
    
    public final void setDanmakuBtnOnClickListener(d.g paramg)
    {
      AppMethodBeat.i(302201);
      s.u(paramg, "listener");
      AppMethodBeat.o(302201);
    }
    
    public final void setDanmakuBtnOpen(boolean paramBoolean) {}
    
    public final void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(302139);
      s.u(paramOnClickListener, "listener");
      AppMethodBeat.o(302139);
    }
    
    public final void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(302193);
      s.u(paramOnClickListener, "listener");
      AppMethodBeat.o(302193);
    }
    
    public final void setIsPlay(boolean paramBoolean) {}
    
    public final void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(302132);
      s.u(paramOnClickListener, "listener");
      AppMethodBeat.o(302132);
    }
    
    public final void setMuteBtnState(boolean paramBoolean) {}
    
    public final void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(302145);
      s.u(paramOnClickListener, "listener");
      AppMethodBeat.o(302145);
    }
    
    public final void setOnUpdateProgressLenListener(d.e parame)
    {
      AppMethodBeat.i(302293);
      s.u(parame, "onUpdateProgressLenListener");
      AppMethodBeat.o(302293);
    }
    
    public final void setPlayBtnInCenterPosition(boolean paramBoolean) {}
    
    public final void setShowControlProgress(boolean paramBoolean) {}
    
    public final void setShowDanmakuBtn(boolean paramBoolean) {}
    
    public final void setShowFullScreenBtn(boolean paramBoolean) {}
    
    public final void setShowMuteBtn(boolean paramBoolean) {}
    
    public final void setShowPlayBtn(boolean paramBoolean) {}
    
    public final void setShowProgress(boolean paramBoolean) {}
    
    public final void setStatePorter(d.i parami)
    {
      AppMethodBeat.i(302101);
      s.u(parami, "porter");
      AppMethodBeat.o(302101);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(302150);
      s.u(paramString, "title");
      AppMethodBeat.o(302150);
    }
    
    public final void setVideoTotalTime(int paramInt) {}
    
    public final void setVisibility(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "", "()V", "autoPlayId", "", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "autoPlayTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAutoPlayTime", "()Ljava/util/HashMap;", "setAutoPlayTime", "(Ljava/util/HashMap;)V", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getBizInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setBizInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "bufferEnd", "", "getBufferEnd", "()J", "setBufferEnd", "(J)V", "bufferStart", "getBufferStart", "setBufferStart", "curPosMs", "getCurPosMs", "setCurPosMs", "hasAutoPlay", "getHasAutoPlay", "setHasAutoPlay", "value", "Lcom/tencent/mm/message/BizReaderItem;", "item", "getItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "prepareEnd", "getPrepareEnd", "setPrepareEnd", "prepareStart", "getPrepareStart", "setPrepareStart", "recAppMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "getRecAppMsg", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "setRecAppMsg", "(Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;)V", "status", "getStatus", "setStatus", "vidToPos", "getVidToPos", "setVidToPos", "videoDuration", "getVideoDuration", "setVideoDuration", "destroy", "", "report", "event", "Status", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int bUo;
    private v nUG;
    public com.tencent.mm.storage.ab vXJ;
    qn vXK;
    String vXL;
    public String vXM;
    public HashMap<String, Integer> vXN;
    HashMap<String, Integer> vXO;
    HashMap<String, Integer> vXP;
    public long vXQ;
    public long vXR;
    public long vXS;
    public long vXT;
    public long vXU;
    private int videoDuration;
    
    public a()
    {
      AppMethodBeat.i(302064);
      this.vXL = "IDLE";
      this.vXM = "";
      this.vXN = new HashMap();
      this.vXO = new HashMap();
      this.vXP = new HashMap();
      AppMethodBeat.o(302064);
    }
    
    public final void ajZ(String paramString)
    {
      AppMethodBeat.i(302088);
      this.vXL = paramString;
      Log.i("MicroMsg.MPVideoPreviewMgr", s.X("PreviewInfo status = ", paramString));
      AppMethodBeat.o(302088);
    }
    
    public final void d(v paramv)
    {
      AppMethodBeat.i(302074);
      this.nUG = paramv;
      if (paramv != null)
      {
        ((Map)this.vXO).put(paramv.vid, Integer.valueOf(1));
        AppMethodBeat.o(302074);
        return;
      }
      this.bUo = 0;
      AppMethodBeat.o(302074);
    }
    
    public final void rG(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(302117);
      Object localObject1 = c.vYt;
      localObject1 = this.vXJ;
      Object localObject3;
      label34:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = this.vXJ;
        if (localObject3 != null) {
          break label170;
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          c.HW(paramInt);
          c.setVid((String)localObject1);
          c.akd((String)localObject2);
          c.akc(this.vXM);
          localObject2 = (Integer)((Map)this.vXN).get(localObject1);
          if (localObject2 != null) {
            break label185;
          }
          i = 0;
          label94:
          c.HU(i);
          c.kq(this.videoDuration);
          c.kr(0L);
          c.kp(0L);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        c.report();
        AppMethodBeat.o(302117);
        return;
        localObject3 = MPVideoPreviewMgr.vXs;
        localObject1 = MPVideoPreviewMgr.t((com.tencent.mm.storage.ab)localObject1);
        break;
        label170:
        localObject2 = MPVideoPreviewMgr.vXs;
        localObject2 = MPVideoPreviewMgr.u((com.tencent.mm.storage.ab)localObject3);
        break label34;
        label185:
        i = ((Integer)localObject2).intValue();
        break label94;
        c.kr(this.vXS - this.vXR);
        continue;
        c.kr(this.vXU - this.vXT);
        if (this.vXS != 0L)
        {
          c.kp(System.currentTimeMillis() - this.vXS);
          continue;
          if (this.vXS != 0L)
          {
            c.kp(System.currentTimeMillis() - this.vXS);
            ((Map)this.vXP).put(localObject1, Integer.valueOf((int)c.dhN()));
            continue;
            if (this.vXS != 0L) {
              c.kp(System.currentTimeMillis() - this.vXS);
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
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "view", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<View, Float>
  {
    public static final c vXW;
    
    static
    {
      AppMethodBeat.i(302050);
      vXW = new c();
      AppMethodBeat.o(302050);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr
 * JD-Core Version:    0.7.0.1
 */