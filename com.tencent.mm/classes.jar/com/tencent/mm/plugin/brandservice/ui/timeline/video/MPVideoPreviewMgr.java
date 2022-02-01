package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ab;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "blackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSetAlpha", "cgiQueue", "currentVid", "hotLocation", "", "previewInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "urlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "videoLocation", "weakParent", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "weakPreview", "Landroid/view/View;", "weakTimer", "Landroid/widget/TextView;", "weakVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "weakVideoWrapper", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoWrapper;", "addBlackList", "", "vid", "addPreview", "parent", "height", "", "playUrl", "autoPlayTime", "cgiPlayUrl", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "changeStatus", "status", "checkPosition", "reason", "list", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "checkSameTopVideo", "lastVid", "destroy", "doPauseForResume", "event", "doStatusElse", "getPlayUrl", "isAutoPlay", "removeBlackList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/message/BizMMReader;", "resetPreview", "saveVideoInTimeline", "setPlayUrl", "url", "startTimer", "stopTimer", "triggerEvent", "EmptyControlBar", "Event", "PreviewInfo", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr
{
  private static final f ovN;
  public static WeakReference<ViewGroup> ovO;
  public static WeakReference<View> ovP;
  public static WeakReference<AppBrandVideoView> ovQ;
  public static WeakReference<AppBrandVideoWrapper> ovR;
  public static final a ovS;
  public static boolean ovT;
  public static String ovU;
  private static int[] ovV;
  public static int[] ovW;
  private static final as ovX;
  public static final HashSet<String> ovY;
  public static final MPVideoPreviewMgr ovZ;
  public static WeakReference<TextView> tRG;
  public static aw vVH;
  public static HashSet<String> vVI;
  
  static
  {
    AppMethodBeat.i(209137);
    ovZ = new MPVideoPreviewMgr();
    ovN = d.g.O((d.g.a.a)MPVideoPreviewMgr.b.owj);
    ovS = new a();
    ovU = "";
    ay localay = ay.aRW("MicroMsg.MPVideoPreviewMgr");
    p.g(localay, "MultiProcessMMKV.getMMKV(TAG)");
    ovX = new as(localay, 14400L);
    vVI = new HashSet();
    ovY = new HashSet();
    AppMethodBeat.o(209137);
  }
  
  public static String YI(String paramString)
  {
    AppMethodBeat.i(209134);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid null");
      AppMethodBeat.o(209134);
      return "";
    }
    ay localay = (ay)ovX.fnP();
    String str = localay.decodeString("MicroMsg.MPVideoPreviewMgr_" + paramString + "_url");
    if (!bu.isNullOrNil(str))
    {
      long l = localay.decodeLong("MicroMsg.MPVideoPreviewMgr_" + paramString + "_time");
      if (System.currentTimeMillis() - l > 14400000L)
      {
        ae.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl expire");
        str = "";
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + paramString + ", url = " + str);
      AppMethodBeat.o(209134);
      return str;
    }
  }
  
  public static void a(String paramString, StoryListView paramStoryListView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(209132);
    p.h(paramString, "reason");
    p.h(paramStoryListView, "list");
    p.h(paramb, "adapter");
    if (!bSZ())
    {
      AppMethodBeat.o(209132);
      return;
    }
    ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reason = ".concat(String.valueOf(paramString)));
    if ((!az.isWifi(ak.getContext())) && (!h.esu()))
    {
      ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition not wifi");
      AppMethodBeat.o(209132);
      return;
    }
    if (ovV != null)
    {
      paramString = ovV;
      if ((paramString == null) || (paramString[1] != 0)) {}
    }
    else
    {
      paramString = new int[2];
      paramStoryListView.getLocationInWindow(paramString);
      localObject1 = new int[2];
      ovV = (int[])localObject1;
      localObject1[0] = paramString[1];
      localObject1 = ovV;
      if (localObject1 == null) {
        p.gkB();
      }
      paramString[1] += paramStoryListView.getHeight() * 2 / 3;
    }
    Object localObject2 = new LinkedList();
    int j = paramStoryListView.getFirstVisiblePosition();
    int k = paramStoryListView.getLastVisiblePosition();
    Object localObject1 = new StringBuilder("checkPosition x = ");
    paramString = ovV;
    label237:
    int i;
    if (paramString != null)
    {
      paramString = Integer.valueOf(paramString[0]);
      localObject1 = ((StringBuilder)localObject1).append(paramString).append(", y = ");
      paramString = ovV;
      if (paramString == null) {
        break label362;
      }
      paramString = Integer.valueOf(paramString[1]);
      ae.i("MicroMsg.MPVideoPreviewMgr", paramString + ", height = " + paramStoryListView.getHeight() + ", startPos = " + j + ", endPos = " + k);
      if (j > k) {
        break label599;
      }
      i = j;
      label296:
      if (i != 0)
      {
        paramString = paramb.zz(i - 1);
        if (paramString != null) {
          switch (paramString.field_type)
          {
          }
        }
      }
    }
    label362:
    Object localObject3;
    for (;;)
    {
      if (i != k)
      {
        i += 1;
        break label296;
        paramString = null;
        break;
        paramString = null;
        break label237;
        ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hasAd");
        bTa();
        AppMethodBeat.o(209132);
        return;
        localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramString.field_msgId, paramString.field_content);
        if ((localObject3 != null) && (localObject3 != null))
        {
          paramString = ((u)localObject3).hFT;
          if (paramString != null)
          {
            v localv = (v)paramString.get(0);
            if ((localv != null) && (localv.type == 5))
            {
              paramString = paramStoryListView.getChildAt(i - j);
              if (paramString != null) {}
              for (paramString = paramString.getTag();; paramString = null)
              {
                localObject1 = paramString;
                if (!(paramString instanceof ab)) {
                  localObject1 = null;
                }
                paramString = (ab)localObject1;
                if (paramString == null) {
                  break;
                }
                paramString = paramString.olu;
                if (paramString == null) {
                  break;
                }
                paramString = paramString.oio;
                if (paramString == null) {
                  break;
                }
                ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition has TopVideo, index = " + (i - j));
                ((LinkedList)localObject2).add(new d.o(localObject3, paramString));
                paramString = (Map)ovS.owb;
                localObject1 = localv.hCa;
                p.g(localObject1, "top.vid");
                paramString.put(localObject1, Integer.valueOf(i));
                break;
              }
            }
          }
        }
      }
    }
    label599:
    ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition videoList size = " + ((LinkedList)localObject2).size());
    bu((LinkedList)localObject2);
    if (bu.ht((List)localObject2))
    {
      bTa();
      AppMethodBeat.o(209132);
      return;
    }
    paramb = (d.g.a.b)g.owq;
    paramStoryListView = new LinkedList();
    localObject1 = (Iterable)localObject2;
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label758:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (((Number)paramb.invoke(((d.o)localObject2).second)).floatValue() != 0.0F) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label758;
        }
        paramString.add(localObject2);
        break;
      }
    }
    paramStoryListView.addAll((Collection)paramString);
    ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList size = " + paramStoryListView.size());
    if (bu.ht((List)paramStoryListView))
    {
      bTa();
      AppMethodBeat.o(209132);
      return;
    }
    if (paramStoryListView.size() <= 1) {
      paramString = (d.o)paramStoryListView.get(0);
    }
    label965:
    label1631:
    for (;;)
    {
      if (paramString != null)
      {
        paramStoryListView = (u)paramString.first;
        if (paramStoryListView != null)
        {
          paramStoryListView = paramStoryListView.hFT;
          if (paramStoryListView == null) {}
        }
      }
      for (paramStoryListView = (v)paramStoryListView.get(0);; paramStoryListView = null)
      {
        if (paramStoryListView != null) {
          break label965;
        }
        ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition error");
        AppMethodBeat.o(209132);
        return;
        paramString = paramStoryListView.get(0);
        p.g(paramString, "hotList[0]");
        paramString = (d.o)paramString;
        paramStoryListView = paramStoryListView.get(1);
        p.g(paramStoryListView, "hotList[1]");
        paramStoryListView = (d.o)paramStoryListView;
        if (((Number)paramb.invoke(paramString.second)).floatValue() >= 0.5D) {
          break label1631;
        }
        ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList second");
        paramString = paramStoryListView;
        break;
      }
      if (vVI.contains(paramStoryListView.hCa))
      {
        ae.i("MicroMsg.MPVideoPreviewMgr", "checkPosition in blacklist");
        AppMethodBeat.o(209132);
        return;
      }
      ovS.g(paramStoryListView);
      paramb = ovS;
      if (paramString != null)
      {
        localObject1 = (u)paramString.first;
        if (localObject1 != null)
        {
          localObject1 = ((u)localObject1).hFT;
          if (localObject1 == null) {}
        }
      }
      for (i = ((LinkedList)localObject1).size();; i = 0)
      {
        paramb.ajO = i;
        paramb = paramString.second;
        paramString = paramb;
        if (!(paramb instanceof ViewGroup)) {
          paramString = null;
        }
        localObject1 = (ViewGroup)paramString;
        paramb = YI(paramStoryListView.hCa);
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofU;
        paramStoryListView = paramStoryListView.hCa;
        if ((localObject1 != null) && (((ViewGroup)localObject1).getContext() != null) && (!bu.isNullOrNil(paramb))) {
          break;
        }
        ae.i("MicroMsg.MPVideoPreviewMgr", "addPreview parent null or url = ".concat(String.valueOf(paramb)));
        AppMethodBeat.o(209132);
        return;
      }
      localObject2 = ((ViewGroup)localObject1).getContext();
      paramString = ovO;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramString != null)
      {
        paramString = (ViewGroup)paramString.get();
        if (paramString != null)
        {
          paramString = paramString.getContext();
          bool1 = p.i(localObject2, paramString);
          paramString = ovO;
          if (paramString == null) {
            break label1326;
          }
          paramString = (ViewGroup)paramString.get();
          bool2 = p.i(localObject1, paramString);
          bool3 = p.i(ovU, paramStoryListView);
          localObject2 = new StringBuilder("addPreview sameContext = ").append(bool1).append(", sameParent = ").append(bool2).append(", sameVid = ").append(bool3).append(", visible = ");
          paramString = ovQ;
          if (paramString == null) {
            break label1331;
          }
          paramString = (AppBrandVideoView)paramString.get();
          if (paramString == null) {
            break label1331;
          }
        }
      }
      for (paramString = Integer.valueOf(paramString.getVisibility());; paramString = null)
      {
        ae.i("MicroMsg.MPVideoPreviewMgr", paramString);
        if ((!bool1) || (!bool2) || (!bool3)) {
          break label1336;
        }
        ae.i("MicroMsg.MPVideoPreviewMgr", "addPreview replay");
        AppMethodBeat.o(209132);
        return;
        paramString = null;
        break;
        paramString = null;
        break label1187;
      }
      paramString = (m)MPVideoPreviewMgr.d.owl;
      localObject2 = (d.g.a.q)MPVideoPreviewMgr.c.owk;
      localObject3 = ((ViewGroup)localObject1).getContext();
      p.g(localObject3, "context");
      paramString.p(Boolean.valueOf(bool1), localObject3);
      ((d.g.a.q)localObject2).d(Boolean.valueOf(bool2), localObject1, Integer.valueOf(i));
      if (!bool3)
      {
        paramString = ovQ;
        if (paramString != null)
        {
          paramString = (AppBrandVideoView)paramString.get();
          if (paramString != null) {
            paramString.pause();
          }
        }
      }
      ovT = true;
      paramString = ovP;
      if (paramString != null)
      {
        paramString = (View)paramString.get();
        if (paramString != null) {
          paramString.setAlpha(0.0F);
        }
      }
      ovS.owf = System.currentTimeMillis();
      ovS.owa = String.valueOf(System.currentTimeMillis());
      ovS.aJg("PREPARE");
      ovU = paramStoryListView;
      paramString = ovQ;
      if (paramString != null)
      {
        paramString = (AppBrandVideoView)paramString.get();
        if (paramString != null) {
          paramString.setAutoPlay(true);
        }
      }
      paramString = ovQ;
      if (paramString != null)
      {
        paramString = (AppBrandVideoView)paramString.get();
        if (paramString != null) {
          paramString.setMute(true);
        }
      }
      paramString = ovQ;
      if (paramString != null)
      {
        paramString = (AppBrandVideoView)paramString.get();
        if (paramString != null) {
          paramString.setLoop(true);
        }
      }
      paramString = ovQ;
      if (paramString != null)
      {
        paramString = (AppBrandVideoView)paramString.get();
        if (paramString != null) {
          paramString.e(paramb, false, 0);
        }
      }
      paramString = ovQ;
      if (paramString != null)
      {
        paramString = (AppBrandVideoView)paramString.get();
        if (paramString != null)
        {
          paramString.start();
          AppMethodBeat.o(209132);
          return;
        }
      }
      AppMethodBeat.o(209132);
      return;
    }
  }
  
  public static void aII(String paramString)
  {
    AppMethodBeat.i(224156);
    if (!bSZ())
    {
      AppMethodBeat.o(224156);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224156);
      return;
    }
    ae.i("MicroMsg.MPVideoPreviewMgr", "triggerEvent status = " + ovS.puH + ", event = " + paramString);
    Object localObject = ovS.puH;
    if (localObject == null) {}
    while (paramString == null)
    {
      AppMethodBeat.o(224156);
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
            AppMethodBeat.o(224156);
            return;
          }
          switch (paramString.hashCode())
          {
          default: 
          case -592677033: 
            do
            {
              AppMethodBeat.o(224156);
              return;
            } while ((!paramString.equals("ONPAUSE")) || (bu.isNullOrNil(ovU)));
            paramString = ovQ;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.pause();
              }
            }
            paramString = ovS;
            localObject = ovQ;
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
            paramString.owe = l;
            ovS.md(4);
            AppMethodBeat.o(224156);
            return;
            if ((!paramString.equals("ONRESUME")) || (bu.isNullOrNil(ovU))) {
              break;
            }
            paramString = ovQ;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.start();
              }
            }
            ovS.owf = System.currentTimeMillis();
            ovS.owg = System.currentTimeMillis();
            ovS.owa = String.valueOf(System.currentTimeMillis());
            ail("PLAY");
            ovS.md(2);
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
        AppMethodBeat.o(224156);
        return;
        if ((paramString.equals("ONPAUSE")) && (!bu.isNullOrNil(ovU))) {
          ar.o((Runnable)f.vVJ, 500L);
        }
      }
    } while (!paramString.equals("ONRESUME"));
    AppMethodBeat.o(224156);
  }
  
  public static void aIJ(String paramString)
  {
    AppMethodBeat.i(224158);
    ae.i("MicroMsg.MPVideoPreviewMgr", "addBlackList vid = ".concat(String.valueOf(paramString)));
    vVI.add(paramString);
    AppMethodBeat.o(224158);
  }
  
  public static int aIK(String paramString)
  {
    AppMethodBeat.i(224159);
    int i;
    if (!bu.isNullOrNil(paramString))
    {
      paramString = (Integer)ovS.owc.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(224159);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static int aJf(String paramString)
  {
    AppMethodBeat.i(224160);
    int i;
    if (!bu.isNullOrNil(paramString))
    {
      paramString = (Integer)ovS.owd.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(224160);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static void ail(String paramString)
  {
    AppMethodBeat.i(224155);
    if (!bSZ())
    {
      AppMethodBeat.o(224155);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224155);
      return;
    }
    ovS.aJg(paramString);
    AppMethodBeat.o(224155);
  }
  
  public static boolean bSZ()
  {
    AppMethodBeat.i(209131);
    boolean bool = ((Boolean)ovN.getValue()).booleanValue();
    AppMethodBeat.o(209131);
    return bool;
  }
  
  public static void bTa()
  {
    AppMethodBeat.i(209133);
    ae.i("MicroMsg.MPVideoPreviewMgr", "resetPreview");
    Object localObject1 = ovS;
    Object localObject2 = ovQ;
    long l;
    if (localObject2 != null)
    {
      localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        l = ((AppBrandVideoView)localObject2).getCurrPosMs();
        ((a)localObject1).owe = l;
        ovS.md(4);
        ovS.g(null);
        ovS.aJg("IDLE");
        localObject1 = ovQ;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).setAutoPlay(false);
          }
        }
        localObject1 = ovQ;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).pause();
          }
        }
        localObject1 = ovQ;
        if (localObject1 == null) {
          break label225;
        }
        localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break label225;
        }
      }
    }
    label225:
    for (int i = ((AppBrandVideoView)localObject1).getCurrPosSec();; i = 0)
    {
      if (i > 0)
      {
        localObject1 = ovQ;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).bnt();
          }
        }
      }
      localObject1 = ovP;
      if (localObject1 != null)
      {
        localObject1 = (View)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((View)localObject1).setAlpha(0.0F);
        }
      }
      ovU = "";
      stopTimer();
      AppMethodBeat.o(209133);
      return;
      l = 0L;
      break;
    }
  }
  
  private static void bu(LinkedList<d.o<u, View>> paramLinkedList)
  {
    AppMethodBeat.i(224157);
    HashSet localHashSet = new HashSet();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      d.o localo = (d.o)paramLinkedList.next();
      String str = ((v)((u)localo.first).hFT.get(0)).hCa;
      if (vVI.contains(((v)((u)localo.first).hFT.get(0)).hCa))
      {
        localHashSet.add(str);
        ae.i("MicroMsg.MPVideoPreviewMgr", "removeBlackList still vid = ".concat(String.valueOf(str)));
      }
    }
    vVI = localHashSet;
    AppMethodBeat.o(224157);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(224153);
    if (vVH == null) {
      vVH = new aw((aw.a)MPVideoPreviewMgr.h.vVK, true);
    }
    aw localaw = vVH;
    if (localaw != null) {
      localaw.stopTimer();
    }
    localaw = vVH;
    if (localaw != null)
    {
      localaw.Dv(1000L);
      AppMethodBeat.o(224153);
      return;
    }
    AppMethodBeat.o(224153);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(224154);
    aw localaw = vVH;
    if (localaw != null)
    {
      localaw.stopTimer();
      AppMethodBeat.o(224154);
      return;
    }
    AppMethodBeat.o(224154);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$EmptyControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addOnVisibilityChangedListener", "", "onVisibilityChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarVisibilityChangedListener;", "enterFullScreen", "flowShow", "getLayoutId", "hide", "hideCenterPlayBtnIfNeed", "init", "isAutoHide", "", "isControlProgressShowing", "isDanmakuBtnOpen", "isFullScreenState", "isShow", "onDestroy", "onFullScreenChange", "quitFullScreen", "resetAutoHideTimer", "seek", "position", "seekForPoint", "setAutoHide", "autoHide", "setBtnCloseListener", "listener", "Landroid/view/View$OnClickListener;", "setDanmakuBtnIcon", "setDanmakuBtnOnClickListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnDanmakuBtnOnClickListener;", "setDanmakuBtnOpen", "setExitFullScreenBtnOnClickListener", "setFullScreenBtn", "setFullScreenBtnOnClickListener", "setFullScreenTitleBar", "setIsPlay", "isPlay", "setMuteBtnOnClickListener", "setMuteBtnState", "isMute", "setOnPlayButtonClickListener", "setOnUpdateProgressLenListener", "onUpdateProgressLenListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarProgressChangedListener;", "setPlayBtn", "setPlayBtnInCenterPosition", "playBtnInCenterPosition", "setPlayBtnState", "setRootLayout", "setShowControlProgress", "showControlProgress", "setShowDanmakuBtn", "show", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setStatePorter", "porter", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "setTimeTextSize", "setTitle", "title", "", "setVideoTotalTime", "seconds", "setVisibility", "visibility", "showCenterPlayBtnIfNeed", "showControlProgressInternal", "stopCacheUpdate", "toggleDanmakuBtn", "toggleShow", "triggerCacheUpdate", "updateLayoutMargins", "updateMiddleBar", "updateProgress", "progressLen", "totalLen", "updateVideoStatus", "plugin-brandservice_release"})
  public static final class EmptyControlBar
    extends VideoPlayerSeekBar
    implements e.a, e.b
  {
    public EmptyControlBar(Context paramContext)
    {
      super();
      AppMethodBeat.i(209106);
      AppMethodBeat.o(209106);
    }
    
    public EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(209107);
      AppMethodBeat.o(209107);
    }
    
    public EmptyControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(209108);
      AppMethodBeat.o(209108);
    }
    
    public final void a(e.f paramf)
    {
      AppMethodBeat.i(209105);
      p.h(paramf, "onVisibilityChangedListener");
      AppMethodBeat.o(209105);
    }
    
    public final void blp() {}
    
    public final boolean bnP()
    {
      return false;
    }
    
    public final void bnQ() {}
    
    public final void bnR() {}
    
    public final boolean bnS()
    {
      return false;
    }
    
    public final void bnT() {}
    
    public final boolean bnU()
    {
      return false;
    }
    
    public final boolean bnV()
    {
      return true;
    }
    
    public final void bnW() {}
    
    public final void bnX() {}
    
    public final void bnY() {}
    
    public final void bnZ() {}
    
    public final void bnv() {}
    
    public final boolean boa()
    {
      return false;
    }
    
    public final void bpi() {}
    
    public final void gS(boolean paramBoolean) {}
    
    public final int getLayoutId()
    {
      return 2131496515;
    }
    
    public final void hide() {}
    
    public final void init() {}
    
    public final void onDestroy() {}
    
    public final void seek(int paramInt) {}
    
    public final void setAutoHide(boolean paramBoolean) {}
    
    public final void setBtnCloseListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(209097);
      p.h(paramOnClickListener, "listener");
      AppMethodBeat.o(209097);
    }
    
    public final void setDanmakuBtnOnClickListener(e.g paramg)
    {
      AppMethodBeat.i(209103);
      p.h(paramg, "listener");
      AppMethodBeat.o(209103);
    }
    
    public final void setDanmakuBtnOpen(boolean paramBoolean) {}
    
    public final void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(209099);
      p.h(paramOnClickListener, "listener");
      AppMethodBeat.o(209099);
    }
    
    public final void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(209102);
      p.h(paramOnClickListener, "listener");
      AppMethodBeat.o(209102);
    }
    
    public final void setIsPlay(boolean paramBoolean) {}
    
    public final void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(209098);
      p.h(paramOnClickListener, "listener");
      AppMethodBeat.o(209098);
    }
    
    public final void setMuteBtnState(boolean paramBoolean) {}
    
    public final void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(209100);
      p.h(paramOnClickListener, "listener");
      AppMethodBeat.o(209100);
    }
    
    public final void setOnUpdateProgressLenListener(e.e parame)
    {
      AppMethodBeat.i(209104);
      p.h(parame, "onUpdateProgressLenListener");
      AppMethodBeat.o(209104);
    }
    
    public final void setPlayBtnInCenterPosition(boolean paramBoolean) {}
    
    public final void setShowControlProgress(boolean paramBoolean) {}
    
    public final void setShowDanmakuBtn(boolean paramBoolean) {}
    
    public final void setShowFullScreenBtn(boolean paramBoolean) {}
    
    public final void setShowMuteBtn(boolean paramBoolean) {}
    
    public final void setShowPlayBtn(boolean paramBoolean) {}
    
    public final void setShowProgress(boolean paramBoolean) {}
    
    public final void setStatePorter(e.i parami)
    {
      AppMethodBeat.i(209096);
      p.h(parami, "porter");
      AppMethodBeat.o(209096);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(209101);
      p.h(paramString, "title");
      AppMethodBeat.o(209101);
    }
    
    public final void setVideoTotalTime(int paramInt) {}
    
    public final void setVisibility(int paramInt) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "", "()V", "autoPlayId", "", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "autoPlayTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAutoPlayTime", "()Ljava/util/HashMap;", "setAutoPlayTime", "(Ljava/util/HashMap;)V", "bufferEnd", "", "getBufferEnd", "()J", "setBufferEnd", "(J)V", "bufferStart", "getBufferStart", "setBufferStart", "curPosMs", "getCurPosMs", "setCurPosMs", "hasAutoPlay", "getHasAutoPlay", "setHasAutoPlay", "value", "Lcom/tencent/mm/message/BizReaderItem;", "item", "getItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "prepareEnd", "getPrepareEnd", "setPrepareEnd", "prepareStart", "getPrepareStart", "setPrepareStart", "status", "getStatus", "setStatus", "vidToPos", "getVidToPos", "setVidToPos", "videoDuration", "getVideoDuration", "setVideoDuration", "destroy", "", "report", "event", "Status", "plugin-brandservice_release"})
  public static final class a
  {
    public int ajO;
    v hFY;
    String owa;
    public HashMap<String, Integer> owb;
    HashMap<String, Integer> owc;
    HashMap<String, Integer> owd;
    public long owe;
    public long owf;
    public long owg;
    public long owh;
    public long owi;
    String puH;
    private int videoDuration;
    
    public a()
    {
      AppMethodBeat.i(209111);
      this.puH = "IDLE";
      this.owa = "";
      this.owb = new HashMap();
      this.owc = new HashMap();
      this.owd = new HashMap();
      AppMethodBeat.o(209111);
    }
    
    public final void Ae(int paramInt)
    {
      this.videoDuration = (paramInt * 1000);
    }
    
    public final void aJg(String paramString)
    {
      AppMethodBeat.i(224148);
      this.puH = paramString;
      ae.i("MicroMsg.MPVideoPreviewMgr", "PreviewInfo status = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224148);
    }
    
    public final void g(v paramv)
    {
      AppMethodBeat.i(209109);
      this.hFY = paramv;
      if (paramv != null)
      {
        ((Map)this.owc).put(paramv.hCa, Integer.valueOf(1));
        AppMethodBeat.o(209109);
        return;
      }
      this.ajO = 0;
      AppMethodBeat.o(209109);
    }
    
    public final void md(int paramInt)
    {
      v localv1 = null;
      AppMethodBeat.i(209110);
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.oyo;
      label55:
      int i;
      if (this.hFY != null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.setEventType(paramInt);
        localObject = this.hFY;
        if (localObject == null) {
          break label181;
        }
        localObject = ((v)localObject).hCa;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.YO((String)localObject);
        localObject = this.hFY;
        if (localObject == null) {
          break label186;
        }
        localObject = ((v)localObject).url;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.YQ((String)localObject);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.YP(this.owa);
        Map localMap = (Map)this.owb;
        v localv2 = this.hFY;
        localObject = localv1;
        if (localv2 != null) {
          localObject = localv2.hCa;
        }
        localObject = (Integer)localMap.get(localObject);
        if (localObject == null) {
          break label191;
        }
        i = ((Integer)localObject).intValue();
        label116:
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.Ao(i);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tK(this.videoDuration);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tL(0L);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tJ(0L);
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.report();
        AppMethodBeat.o(209110);
        return;
        label181:
        localObject = null;
        break;
        label186:
        localObject = null;
        break label55;
        label191:
        i = 0;
        break label116;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tL(this.owg - this.owf);
        continue;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tL(this.owi - this.owh);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tJ(System.currentTimeMillis() - this.owg);
        continue;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.tJ(System.currentTimeMillis() - this.owg);
        localObject = (Map)this.owd;
        localv1 = this.hFY;
        if (localv1 == null) {
          p.gkB();
        }
        ((Map)localObject).put(localv1.hCa, Integer.valueOf((int)com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.bTr()));
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f vVJ;
    
    static
    {
      AppMethodBeat.i(224150);
      vVJ = new f();
      AppMethodBeat.o(224150);
    }
    
    public final void run()
    {
      AppMethodBeat.i(224149);
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.bTi();
      AppMethodBeat.o(224149);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "view", "Landroid/view/View;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<View, Float>
  {
    public static final g owq;
    
    static
    {
      AppMethodBeat.i(209130);
      owq = new g();
      AppMethodBeat.o(209130);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr
 * JD-Core Version:    0.7.0.1
 */