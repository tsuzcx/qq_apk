package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ae;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.av;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
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
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "blackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSetAlpha", "cgiQueue", "currentVid", "hotLocation", "", "infoToCard", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lkotlin/collections/HashMap;", "previewInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "urlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "videoLocation", "weakParent", "Landroid/view/ViewGroup;", "weakPreview", "Landroid/view/View;", "weakTimer", "Landroid/widget/TextView;", "weakVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "weakVideoWrapper", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoWrapper;", "addBlackList", "", "vid", "autoPlayTime", "", "cgiPlayUrl", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "changeStatus", "status", "checkPosition", "reason", "list", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "checkSameTopVideo", "lastVid", "chooseVideo", "videoInfoList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "clickCard", "extra", "destroy", "doPauseForResume", "event", "doStatusElse", "filterCard", "getAutoPlayId", "getPlayUrl", "isAutoPlay", "registerCard", "cardTmpl", "removeBlackList", "saveVideoInTimeline", "setPlayUrl", "url", "startPreview", "parent", "height", "playUrl", "startTimer", "stopPreviewAd", "except", "stopPreviewVideo", "stopTimer", "triggerEvent", "getBizMMReader", "Lcom/tencent/mm/message/BizMMReader;", "getTitle", "getTopBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getUrl", "getVid", "EmptyControlBar", "Event", "PreviewInfo", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr
{
  public static final boolean sRX;
  public static WeakReference<ViewGroup> sRY;
  public static WeakReference<View> sRZ;
  public static WeakReference<AppBrandVideoView> sSa;
  public static WeakReference<AppBrandVideoWrapper> sSb;
  public static WeakReference<TextView> sSc;
  public static MTimerHandler sSd;
  public static final a sSe;
  public static boolean sSf;
  public static String sSg;
  private static int[] sSh;
  public static int[] sSi;
  private static final MMKVSlotManager sSj;
  public static HashSet<String> sSk;
  public static HashMap<Long, WeakReference<ae>> sSl;
  private static final HashSet<String> sSm;
  public static final MPVideoPreviewMgr sSn;
  
  static
  {
    AppMethodBeat.i(267051);
    sSn = new MPVideoPreviewMgr();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
    sRX = com.tencent.mm.plugin.webview.ui.tools.video.a.hbB();
    sSe = new a();
    sSg = "";
    localObject = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewMgr");
    p.j(localObject, "MultiProcessMMKV.getMMKV(TAG)");
    sSj = new MMKVSlotManager((MultiProcessMMKV)localObject, 14400L);
    sSk = new HashSet();
    sSl = new HashMap();
    sSm = new HashSet();
    AppMethodBeat.o(267051);
  }
  
  private static void HW(long paramLong)
  {
    AppMethodBeat.i(267032);
    Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewAd except = ".concat(String.valueOf(paramLong)));
    Iterator localIterator = ((Map)sSl).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Number)((Map.Entry)localObject).getKey()).longValue() != paramLong)
      {
        localObject = (ae)((WeakReference)((Map.Entry)localObject).getValue()).get();
        if (localObject != null) {
          ((ae)localObject).setVideoStatus(3);
        }
      }
    }
    AppMethodBeat.o(267032);
  }
  
  private static void J(LinkedList<o<z, View>> paramLinkedList)
  {
    kotlin.g.a.q localq = null;
    AppMethodBeat.i(267031);
    Object localObject2 = (kotlin.g.a.b)c.sSC;
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
      if (((Number)((kotlin.g.a.b)localObject2).invoke(((o)localObject4).My)).floatValue() != 0.0F) {}
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
      cEa();
      cDZ();
      AppMethodBeat.o(267031);
      return;
    }
    if (((LinkedList)localObject1).size() <= 1) {
      paramLinkedList = (o)((LinkedList)localObject1).get(0);
    }
    label291:
    label1446:
    label1455:
    for (;;)
    {
      localObject2 = (z)paramLinkedList.Mx;
      localObject3 = r((z)localObject2);
      sSe.sSo = ((z)localObject2);
      switch (((z)localObject2).field_type)
      {
      default: 
        if (((z)localObject2).hwz())
        {
          localObject1 = ((z)localObject2).Ven;
          if (localObject1 != null)
          {
            localObject1 = ((dug)localObject1).UaA;
            if (localObject1 == null) {
              break label1446;
            }
            sSe.afI = ((z)localObject2).Ven.UaA.size();
            localObject1 = paramLinkedList.My;
            paramLinkedList = (LinkedList<o<z, View>>)localObject1;
            if (!(localObject1 instanceof ViewGroup)) {
              paramLinkedList = null;
            }
            localObject1 = (ViewGroup)paramLinkedList;
            paramLinkedList = aqw((String)localObject3);
          }
        }
        break;
      }
      for (;;)
      {
        if (sSk.contains(localObject3))
        {
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition in blacklist");
          AppMethodBeat.o(267031);
          return;
          paramLinkedList = ((LinkedList)localObject1).get(0);
          p.j(paramLinkedList, "hotList[0]");
          paramLinkedList = (o)paramLinkedList;
          localObject1 = ((LinkedList)localObject1).get(1);
          p.j(localObject1, "hotList[1]");
          localObject1 = (o)localObject1;
          if (((Number)((kotlin.g.a.b)localObject2).invoke(paramLinkedList.My)).floatValue() >= 0.5D) {
            break label1455;
          }
          Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList second");
          paramLinkedList = (LinkedList<o<z, View>>)localObject1;
          break;
          sSe.d(null);
          localObject1 = null;
          paramLinkedList = "";
          continue;
          localObject1 = s((z)localObject2);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition error");
            AppMethodBeat.o(267031);
            return;
          }
          sSe.d((v)localObject1);
          localObject1 = sSe;
          localObject4 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(((z)localObject2).field_msgId, ((z)localObject2).field_content);
          if (localObject4 != null)
          {
            localObject4 = ((u)localObject4).lpz;
            if (localObject4 == null) {}
          }
          for (i = ((LinkedList)localObject4).size();; i = 0)
          {
            ((a)localObject1).afI = i;
            localObject1 = paramLinkedList.My;
            paramLinkedList = (LinkedList<o<z, View>>)localObject1;
            if (!(localObject1 instanceof ViewGroup)) {
              paramLinkedList = null;
            }
            localObject1 = (ViewGroup)paramLinkedList;
            paramLinkedList = aqw((String)localObject3);
            break;
          }
          localObject1 = (pe)((pf)((z)localObject2).hwL().UsF.RVd.get(0)).RXM.get(0);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reccard error");
            AppMethodBeat.o(267031);
            return;
          }
          sSe.sSp = ((pe)localObject1);
          sSe.afI = ((z)localObject2).hwL().UsF.RVd.size();
          localObject1 = paramLinkedList.My;
          paramLinkedList = (LinkedList<o<z, View>>)localObject1;
          if (!(localObject1 instanceof ViewGroup)) {
            paramLinkedList = null;
          }
          localObject1 = (ViewGroup)paramLinkedList;
          paramLinkedList = aqw((String)localObject3);
          continue;
          localObject1 = null;
          break label291;
        }
        if (((z)localObject2).hwz()) {
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAr;
        }
        while (((z)localObject2).field_type == 637534257)
        {
          cEa();
          HW(((z)localObject2).field_msgId);
          paramLinkedList = (WeakReference)sSl.get(Long.valueOf(((z)localObject2).field_msgId));
          if (paramLinkedList != null)
          {
            paramLinkedList = (ae)paramLinkedList.get();
            if (paramLinkedList != null)
            {
              paramLinkedList.setVideoStatus(1);
              AppMethodBeat.o(267031);
              return;
              i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAq;
              continue;
            }
          }
          AppMethodBeat.o(267031);
          return;
        }
        if ((((z)localObject2).field_type == 285212721) || (((z)localObject2).field_type == 620757041) || (((z)localObject2).hwz()))
        {
          if ((localObject1 == null) || (((ViewGroup)localObject1).getContext() == null) || (Util.isNullOrNil(paramLinkedList)))
          {
            Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview parent null or url = ".concat(String.valueOf(paramLinkedList)));
            AppMethodBeat.o(267031);
            return;
          }
          cDZ();
          localObject4 = ((ViewGroup)localObject1).getContext();
          localObject2 = sRY;
          boolean bool1;
          if (localObject2 != null)
          {
            localObject2 = (ViewGroup)((WeakReference)localObject2).get();
            if (localObject2 != null)
            {
              localObject2 = ((ViewGroup)localObject2).getContext();
              bool1 = p.h(localObject4, localObject2);
              localObject2 = sRY;
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
            bool2 = p.h(localObject1, localObject2);
            bool3 = p.h(sSg, localObject3);
            localObject4 = new StringBuilder("startPreview sameContext = ").append(bool1).append(", sameParent = ").append(bool2).append(", sameVid = ").append(bool3).append(", visible = ");
            Object localObject5 = sSa;
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
            AppMethodBeat.o(267031);
            return;
            localObject2 = null;
            break;
          }
          label1114:
          localObject2 = (kotlin.g.a.m)MPVideoPreviewMgr.g.sSG;
          localq = (kotlin.g.a.q)MPVideoPreviewMgr.f.sSF;
          localObject4 = ((ViewGroup)localObject1).getContext();
          p.j(localObject4, "context");
          ((kotlin.g.a.m)localObject2).invoke(Boolean.valueOf(bool1), localObject4);
          localq.c(Boolean.valueOf(bool2), localObject1, Integer.valueOf(i));
          if (!bool3)
          {
            localObject1 = sSa;
            if (localObject1 != null)
            {
              localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
              if (localObject1 != null) {
                ((AppBrandVideoView)localObject1).pause();
              }
            }
          }
          sSf = true;
          localObject1 = sRZ;
          if (localObject1 != null)
          {
            localObject1 = (View)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((View)localObject1).setAlpha(0.0F);
            }
          }
          sSe.sSw = System.currentTimeMillis();
          sSe.sSr = String.valueOf(System.currentTimeMillis());
          sSe.aqA("PREPARE");
          sSg = (String)localObject3;
          localObject1 = sSa;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setAutoPlay(true);
            }
          }
          localObject1 = sSa;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setMute(true);
            }
          }
          localObject1 = sSa;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).setLoop(true);
            }
          }
          localObject1 = sSa;
          if (localObject1 != null)
          {
            localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((AppBrandVideoView)localObject1).f(paramLinkedList, false, 0);
            }
          }
          paramLinkedList = sSa;
          if (paramLinkedList != null)
          {
            paramLinkedList = (AppBrandVideoView)paramLinkedList.get();
            if (paramLinkedList != null)
            {
              paramLinkedList.start();
              AppMethodBeat.o(267031);
              return;
            }
          }
        }
        AppMethodBeat.o(267031);
        return;
        localObject1 = null;
        paramLinkedList = "";
      }
    }
  }
  
  private static void K(LinkedList<o<z, View>> paramLinkedList)
  {
    AppMethodBeat.i(267040);
    HashSet localHashSet = new HashSet();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      String str = r((z)((o)paramLinkedList.next()).Mx);
      if (sSk.contains(str))
      {
        localHashSet.add(str);
        Log.i("MicroMsg.MPVideoPreviewMgr", "removeBlackList still vid = ".concat(String.valueOf(str)));
      }
    }
    sSk = localHashSet;
    AppMethodBeat.o(267040);
  }
  
  public static void a(z paramz, ae paramae)
  {
    AppMethodBeat.i(267049);
    p.k(paramz, "info");
    p.k(paramae, "cardTmpl");
    if (!sRX)
    {
      AppMethodBeat.o(267049);
      return;
    }
    ((Map)sSl).put(Long.valueOf(paramz.field_msgId), new WeakReference(paramae));
    AppMethodBeat.o(267049);
  }
  
  public static void a(z paramz, String paramString)
  {
    AppMethodBeat.i(267050);
    p.k(paramz, "info");
    p.k(paramString, "extra");
    if (!sRX)
    {
      AppMethodBeat.o(267050);
      return;
    }
    MPVideoPreviewMgr.d locald = new MPVideoPreviewMgr.d(paramString, paramz);
    switch (paramz.field_type)
    {
    default: 
      if (paramz.hwz()) {
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
          AppMethodBeat.o(267050);
          return;
          switch (paramString.hashCode())
          {
          default: 
            AppMethodBeat.o(267050);
            return;
          }
        } while (!paramString.equals("PAUSE_FOR_RESUME"));
        aqt("PAUSE_FOR_RESUME");
        AppMethodBeat.o(267050);
        return;
        locald.invoke();
        AppMethodBeat.o(267050);
        return;
        HW(0L);
      } while (sSe.sSo == null);
      paramz = sSe.sSo;
    } while ((paramz != null) && (paramz.field_type == 637534257));
    aqt("PAUSE_FOR_RESUME");
    AppMethodBeat.o(267050);
  }
  
  public static void aqt(String paramString)
  {
    AppMethodBeat.i(267038);
    if (!sRX)
    {
      AppMethodBeat.o(267038);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267038);
      return;
    }
    sSe.aqA(paramString);
    AppMethodBeat.o(267038);
  }
  
  public static void aqu(String paramString)
  {
    AppMethodBeat.i(267039);
    if (!sRX)
    {
      AppMethodBeat.o(267039);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267039);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", "triggerEvent status = " + sSe.sSq + ", event = " + paramString);
    Object localObject = sSe.sSq;
    if (localObject == null) {}
    while (paramString == null)
    {
      AppMethodBeat.o(267039);
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
            AppMethodBeat.o(267039);
            return;
          }
          switch (paramString.hashCode())
          {
          default: 
          case -592677033: 
            do
            {
              AppMethodBeat.o(267039);
              return;
            } while ((!paramString.equals("ONPAUSE")) || (Util.isNullOrNil(sSg)));
            paramString = sSa;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.pause();
              }
            }
            paramString = sSe;
            localObject = sSa;
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
            paramString.sSv = l;
            sSe.rE(4);
            AppMethodBeat.o(267039);
            return;
            if ((!paramString.equals("ONRESUME")) || (Util.isNullOrNil(sSg))) {
              break;
            }
            paramString = sSa;
            if (paramString != null)
            {
              paramString = (AppBrandVideoView)paramString.get();
              if (paramString != null) {
                paramString.start();
              }
            }
            sSe.sSw = System.currentTimeMillis();
            sSe.sSx = System.currentTimeMillis();
            sSe.sSr = String.valueOf(System.currentTimeMillis());
            aqt("PLAY");
            sSe.rE(2);
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
        AppMethodBeat.o(267039);
        return;
        if ((paramString.equals("ONPAUSE")) && (!Util.isNullOrNil(sSg))) {
          MMHandlerThread.postToMainThreadDelayed((Runnable)e.sSE, 500L);
        }
      }
    } while (!paramString.equals("ONRESUME"));
    AppMethodBeat.o(267039);
  }
  
  public static void aqv(String paramString)
  {
    AppMethodBeat.i(267041);
    if (!sRX)
    {
      AppMethodBeat.o(267041);
      return;
    }
    if (Util.isNullOrNil(sSg))
    {
      AppMethodBeat.o(267041);
      return;
    }
    Object localObject1;
    if (p.h(sSg, paramString))
    {
      localObject1 = sSb;
      if (localObject1 != null)
      {
        localObject1 = (AppBrandVideoWrapper)((WeakReference)localObject1).get();
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(267041);
        return;
      }
      p.j(localObject1, "weakVideoWrapper?.get() ?: return");
      Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
      localObject2 = sSg;
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
          sSk.add(paramString);
        }
      }
    }
    else
    {
      paramString = sSe;
      localObject1 = sSa;
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
      paramString.sSv = l;
      sSe.rE(4);
      sSe.rE(3);
      sSe.sSo = null;
      sSe.d(null);
      aqt("IDLE");
      AppMethodBeat.o(267041);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private static String aqw(String paramString)
  {
    AppMethodBeat.i(267043);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid null");
      AppMethodBeat.o(267043);
      return "";
    }
    String str = MMKVSlotManager.decodeString$default(sSj, "MicroMsg.MPVideoPreviewMgr_" + paramString + "_url", null, 2, null);
    if (!Util.isNullOrNil(str))
    {
      long l = MMKVSlotManager.decodeLong$default(sSj, "MicroMsg.MPVideoPreviewMgr_" + paramString + "_time", 0L, 2, null);
      if (System.currentTimeMillis() - l > 14400000L)
      {
        Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl expire");
        str = "";
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + paramString + ", url = " + str);
      AppMethodBeat.o(267043);
      return str;
    }
  }
  
  public static int aqx(String paramString)
  {
    AppMethodBeat.i(267044);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)sSe.sSt.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267044);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static int aqy(String paramString)
  {
    AppMethodBeat.i(267045);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (Integer)sSe.sSu.get(paramString);
      if (paramString != null) {
        i = paramString.intValue();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267045);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static String aqz(String paramString)
  {
    AppMethodBeat.i(267046);
    if (!sRX)
    {
      AppMethodBeat.o(267046);
      return "";
    }
    String str = "";
    if (p.h(sSg, paramString)) {
      str = sSe.sSr;
    }
    AppMethodBeat.o(267046);
    return str;
  }
  
  public static void cEa()
  {
    AppMethodBeat.i(267034);
    Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewVideo");
    Object localObject1 = sSe;
    Object localObject2 = sSa;
    long l;
    if (localObject2 != null)
    {
      localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        l = ((AppBrandVideoView)localObject2).getCurrPosMs();
        ((a)localObject1).sSv = l;
        sSe.rE(4);
        sSe.sSo = null;
        sSe.d(null);
        sSe.aqA("IDLE");
        localObject1 = sSa;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).setAutoPlay(false);
          }
        }
        localObject1 = sSa;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).pause();
          }
        }
        localObject1 = sSa;
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
        localObject1 = sSa;
        if (localObject1 != null)
        {
          localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((AppBrandVideoView)localObject1).bUG();
          }
        }
      }
      localObject1 = sRZ;
      if (localObject1 != null)
      {
        localObject1 = (View)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((View)localObject1).setAlpha(0.0F);
        }
      }
      sSg = "";
      stopTimer();
      AppMethodBeat.o(267034);
      return;
      l = 0L;
      break;
    }
  }
  
  public static void q(z arg0)
  {
    v localv = null;
    AppMethodBeat.i(267042);
    p.k(???, "info");
    if (!sRX)
    {
      AppMethodBeat.o(267042);
      return;
    }
    kotlin.g.a.m localm = (kotlin.g.a.m)MPVideoPreviewMgr.b.sSA;
    Object localObject3;
    switch (???.field_type)
    {
    default: 
      if (!???.hwz()) {
        break label718;
      }
      ??? = ???.Ven;
      if (??? == null) {
        break label718;
      }
      ??? = ???.UaA;
      if (??? == null) {
        break label718;
      }
      ??? = (dur)???.get(0);
      if (??? == null) {
        break label718;
      }
      localObject3 = ???.UaX;
      if (localObject3 == null) {
        break label718;
      }
      ??? = ((cmo)localObject3).Tua;
      if (??? == null) {
        break;
      }
    }
    boolean bool;
    for (??? = ???.RTv; (Util.isNullOrNil(???)) || (Util.isNullOrNil(((cmo)localObject3).RTk)); ??? = null)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
      AppMethodBeat.o(267042);
      return;
      ??? = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(???.field_msgId, ???.field_content);
      if (??? != null)
      {
        if (??? != null)
        {
          ??? = ???.lpz;
          if (??? != null)
          {
            localv = (v)???.get(0);
            if (localv != null)
            {
              if (localv.type == 5) {}
              synchronized (sSn)
              {
                bool = sSm.contains(localv.vid);
                if (bool)
                {
                  AppMethodBeat.o(267042);
                  return;
                }
                localObject3 = x.aazN;
                if (Util.isNullOrNil(aqw(localv.vid)))
                {
                  sSm.add(localv.vid);
                  localm.invoke(localv.vid, localv.url);
                }
                AppMethodBeat.o(267042);
                return;
              }
            }
          }
        }
        AppMethodBeat.o(267042);
        return;
      }
      AppMethodBeat.o(267042);
      return;
      ??? = ???.hwL();
      if (??? != null)
      {
        ??? = ???.UsF;
        if (??? != null)
        {
          ??? = ???.RVd;
          if (??? != null)
          {
            ??? = (pf)???.get(0);
            if (??? != null)
            {
              ??? = ???.RXM;
              if (??? != null)
              {
                pe localpe = (pe)???.get(0);
                if (localpe != null)
                {
                  if ((Util.isNullOrNil(localpe.RTv)) || (Util.isNullOrNil(localpe.RTk)))
                  {
                    Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl videoId or contentUrl null");
                    AppMethodBeat.o(267042);
                    return;
                  }
                  synchronized (sSn)
                  {
                    bool = sSm.contains(localpe.RTv);
                    if (bool)
                    {
                      AppMethodBeat.o(267042);
                      return;
                    }
                    localObject3 = x.aazN;
                    if (Util.isNullOrNil(aqw(localpe.RTv)))
                    {
                      sSm.add(localpe.RTv);
                      localm.invoke(localpe.RTv, localpe.RTk);
                    }
                    AppMethodBeat.o(267042);
                    return;
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(267042);
      return;
    }
    for (;;)
    {
      synchronized (sSn)
      {
        Iterable localIterable = (Iterable)sSm;
        ??? = ((cmo)localObject3).Tua;
        if (??? != null)
        {
          ??? = ???.RTv;
          bool = j.a(localIterable, ???);
          if (bool) {
            AppMethodBeat.o(267042);
          }
        }
        else
        {
          ??? = null;
          continue;
        }
        ??? = x.aazN;
        ??? = ((cmo)localObject3).Tua;
        if (??? != null)
        {
          ??? = ???.RTv;
          if (Util.isNullOrNil(aqw(???)))
          {
            ??? = sSm;
            ??? = ((cmo)localObject3).Tua;
            if (??? == null) {
              break label713;
            }
            ??? = ???.RTv;
            if (??? == null) {
              p.iCn();
            }
            ((HashSet)???).add(???);
            ??? = ((cmo)localObject3).Tua;
            ??? = localObject2;
            if (??? != null) {
              ??? = ((fbh)???).RTv;
            }
            localm.invoke(???, ((cmo)localObject3).RTk);
          }
          AppMethodBeat.o(267042);
          return;
        }
      }
      ??? = null;
      continue;
      label713:
      ??? = null;
    }
    label718:
    AppMethodBeat.o(267042);
  }
  
  private static String r(z paramz)
  {
    AppMethodBeat.i(267047);
    String str = "";
    Object localObject;
    if (paramz.hwz())
    {
      paramz = paramz.Ven;
      if (paramz != null)
      {
        paramz = paramz.UaA;
        if (paramz != null)
        {
          paramz = (dur)paramz.get(0);
          if (paramz != null)
          {
            paramz = paramz.UaX;
            if (paramz != null)
            {
              paramz = paramz.Tua;
              if (paramz != null)
              {
                localObject = paramz.RTv;
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
      AppMethodBeat.o(267047);
      return paramz;
    }
    switch (paramz.field_type)
    {
    default: 
      localObject = str;
      if (paramz.hwz())
      {
        paramz = paramz.Ven;
        if (paramz != null)
        {
          paramz = paramz.UaA;
          if (paramz != null)
          {
            paramz = (dur)paramz.get(0);
            if (paramz != null)
            {
              paramz = paramz.UaX;
              if (paramz != null)
              {
                paramz = paramz.Tua;
                if (paramz != null)
                {
                  paramz = paramz.RTv;
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
      AppMethodBeat.o(267047);
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
        if (paramz.hwL() != null) {
          switch (paramz.hwL().style)
          {
          default: 
            localObject = str;
            break;
          case 101: 
          case 102: 
            localObject = ((pe)((pf)paramz.hwL().UsF.RVd.get(0)).RXM.get(0)).RTv;
            p.j(localObject, "this.tlRecCardWrapper.ex…Info[0].AppMsg[0].VideoId");
            continue;
            paramz = paramz.hwO();
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
    AppMethodBeat.i(267048);
    paramz = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramz.field_msgId, paramz.field_content);
    if ((paramz != null) && (paramz != null))
    {
      paramz = paramz.lpz;
      if (paramz != null)
      {
        paramz = (v)paramz.get(0);
        if ((paramz != null) && (paramz.type == 5))
        {
          AppMethodBeat.o(267048);
          return paramz;
        }
      }
    }
    AppMethodBeat.o(267048);
    return null;
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(267035);
    if (sSd == null) {
      sSd = new MTimerHandler((MTimerHandler.CallBack)h.sSI, true);
    }
    MTimerHandler localMTimerHandler = sSd;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    localMTimerHandler = sSd;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.startTimer(1000L);
      AppMethodBeat.o(267035);
      return;
    }
    AppMethodBeat.o(267035);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(267036);
    MTimerHandler localMTimerHandler = sSd;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.stopTimer();
      AppMethodBeat.o(267036);
      return;
    }
    AppMethodBeat.o(267036);
  }
  
  public final void a(String paramString, StoryListView paramStoryListView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(267030);
    p.k(paramString, "reason");
    p.k(paramStoryListView, "list");
    p.k(paramb, "adapter");
    if (!sRX)
    {
      AppMethodBeat.o(267030);
      return;
    }
    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reason = ".concat(String.valueOf(paramString)));
    if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!com.tencent.mm.plugin.topstory.a.h.isFreeSimCard()))
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition not wifi");
      AppMethodBeat.o(267030);
      return;
    }
    if (sSh != null)
    {
      paramString = sSh;
      if ((paramString == null) || (paramString[1] != 0)) {}
    }
    else
    {
      paramString = new int[2];
      paramStoryListView.getLocationInWindow(paramString);
      localObject = new int[2];
      sSh = (int[])localObject;
      localObject[0] = paramString[1];
      localObject = sSh;
      if (localObject == null) {
        p.iCn();
      }
      paramString[1] += paramStoryListView.getHeight() * 2 / 3;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = paramStoryListView.getFirstVisiblePosition();
    int k = paramStoryListView.getLastVisiblePosition();
    Object localObject = new StringBuilder("checkPosition x = ");
    paramString = sSh;
    label237:
    int i;
    label297:
    z localz;
    if (paramString != null)
    {
      paramString = Integer.valueOf(paramString[0]);
      localObject = ((StringBuilder)localObject).append(paramString).append(", y = ");
      paramString = sSh;
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
        localz = paramb.GK(i - 1);
        if (localz != null) {
          switch (localz.field_type)
          {
          default: 
            if (localz.hwz())
            {
              paramString = (WeakReference)sSl.get(Long.valueOf(localz.field_msgId));
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
    for (paramString = (ae)paramString.get();; paramString = null)
    {
      if ((paramString != null) && (paramString.cAC() == true) && (paramString.getVideoView() != null))
      {
        localObject = localz.Ven;
        if (localObject != null)
        {
          localObject = ((dug)localObject).UaA;
          if (localObject != null)
          {
            localObject = (dur)((LinkedList)localObject).get(0);
            if (localObject != null)
            {
              localObject = ((dur)localObject).UaX;
              if ((localObject != null) && (((cmo)localObject).lpx == 5))
              {
                paramString = paramString.getVideoView();
                if (paramString == null) {
                  p.iCn();
                }
                localLinkedList.add(new o(localz, paramString));
                ((Map)sSe.sSs).put(r(localz), Integer.valueOf(i));
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
        paramString = (WeakReference)sSl.get(Long.valueOf(localz.field_msgId));
        if (paramString != null) {}
        for (paramString = (ae)paramString.get();; paramString = null)
        {
          if ((paramString == null) || (!paramString.cAC()) || (paramString.getVideoView() == null) || (Util.isNullOrNil(localz.hwO()))) {
            break label675;
          }
          localObject = r(localz);
          paramString = paramString.getVideoView();
          if (paramString == null) {
            p.iCn();
          }
          localLinkedList.add(new o(localz, paramString));
          ((Map)sSe.sSs).put(localObject, Integer.valueOf(i));
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
            if (!(paramString instanceof am)) {
              localObject = null;
            }
            paramString = (am)localObject;
            if (paramString == null) {
              break;
            }
            paramString = paramString.sHp;
            if (paramString == null) {
              break;
            }
            paramString = paramString.sDd;
            if (paramString == null) {
              break;
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition has TopVideo, index = " + (i - j));
            localLinkedList.add(new o(localz, paramString));
            paramString = (Map)sSe.sSs;
            localObject = localv.vid;
            p.j(localObject, "top.vid");
            paramString.put(localObject, Integer.valueOf(i));
            break;
          }
          paramString = (WeakReference)sSl.get(Long.valueOf(localz.field_msgId));
          if (paramString != null) {}
          for (paramString = (ae)paramString.get();; paramString = null)
          {
            if ((paramString == null) || (!paramString.cAC()) || (paramString.getVideoView() == null) || (localz.hwL() == null)) {
              break label1021;
            }
            switch (localz.hwL().style)
            {
            default: 
              break;
            case 101: 
            case 102: 
              if (((pe)((pf)localz.hwL().UsF.RVd.get(0)).RXM.get(0)).lpx != 5) {
                break;
              }
              paramString = paramString.getVideoView();
              if (paramString == null) {
                p.iCn();
              }
              localLinkedList.add(new o(localz, paramString));
              ((Map)sSe.sSs).put(r(localz), Integer.valueOf(i));
              break;
            }
          }
        }
      }
    }
    label675:
    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition videoInfoList size = " + localLinkedList.size());
    label1028:
    K(localLinkedList);
    if (Util.isNullOrNil((List)localLinkedList))
    {
      cEa();
      cDZ();
      AppMethodBeat.o(267030);
      return;
    }
    J(localLinkedList);
    AppMethodBeat.o(267030);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "", "()V", "autoPlayId", "", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "autoPlayTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAutoPlayTime", "()Ljava/util/HashMap;", "setAutoPlayTime", "(Ljava/util/HashMap;)V", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getBizInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setBizInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "bufferEnd", "", "getBufferEnd", "()J", "setBufferEnd", "(J)V", "bufferStart", "getBufferStart", "setBufferStart", "curPosMs", "getCurPosMs", "setCurPosMs", "hasAutoPlay", "getHasAutoPlay", "setHasAutoPlay", "value", "Lcom/tencent/mm/message/BizReaderItem;", "item", "getItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "prepareEnd", "getPrepareEnd", "setPrepareEnd", "prepareStart", "getPrepareStart", "setPrepareStart", "recAppMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "getRecAppMsg", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "setRecAppMsg", "(Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;)V", "status", "getStatus", "setStatus", "vidToPos", "getVidToPos", "setVidToPos", "videoDuration", "getVideoDuration", "setVideoDuration", "destroy", "", "report", "event", "Status", "plugin-brandservice_release"})
  public static final class a
  {
    public int afI;
    private v lpE;
    public z sSo;
    pe sSp;
    String sSq;
    public String sSr;
    public HashMap<String, Integer> sSs;
    HashMap<String, Integer> sSt;
    HashMap<String, Integer> sSu;
    public long sSv;
    public long sSw;
    public long sSx;
    public long sSy;
    public long sSz;
    private int videoDuration;
    
    public a()
    {
      AppMethodBeat.i(265362);
      this.sSq = "IDLE";
      this.sSr = "";
      this.sSs = new HashMap();
      this.sSt = new HashMap();
      this.sSu = new HashMap();
      AppMethodBeat.o(265362);
    }
    
    public final void aqA(String paramString)
    {
      AppMethodBeat.i(265360);
      this.sSq = paramString;
      Log.i("MicroMsg.MPVideoPreviewMgr", "PreviewInfo status = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(265360);
    }
    
    public final void d(v paramv)
    {
      AppMethodBeat.i(265359);
      this.lpE = paramv;
      if (paramv != null)
      {
        ((Map)this.sSt).put(paramv.vid, Integer.valueOf(1));
        AppMethodBeat.o(265359);
        return;
      }
      this.afI = 0;
      AppMethodBeat.o(265359);
    }
    
    public final void rE(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(265361);
      Object localObject1 = e.sTi;
      localObject1 = this.sSo;
      int i;
      if (localObject1 != null)
      {
        Object localObject3 = MPVideoPreviewMgr.sSn;
        localObject1 = MPVideoPreviewMgr.t((z)localObject1);
        localObject3 = this.sSo;
        if (localObject3 != null)
        {
          localObject2 = MPVideoPreviewMgr.sSn;
          localObject2 = MPVideoPreviewMgr.u((z)localObject3);
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          e.Hu(paramInt);
          e.setVid((String)localObject1);
          e.aqE((String)localObject2);
          e.aqD(this.sSr);
          localObject2 = (Integer)((Map)this.sSs).get(localObject1);
          if (localObject2 == null) {
            break label186;
          }
          i = ((Integer)localObject2).intValue();
          label118:
          e.Hs(i);
          e.HY(this.videoDuration);
          e.HZ(0L);
          e.HX(0L);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        e.report();
        AppMethodBeat.o(265361);
        return;
        localObject1 = null;
        break;
        label186:
        i = 0;
        break label118;
        e.HZ(this.sSx - this.sSw);
        continue;
        e.HZ(this.sSz - this.sSy);
        if (this.sSx != 0L)
        {
          e.HX(System.currentTimeMillis() - this.sSx);
          continue;
          if (this.sSx != 0L)
          {
            e.HX(System.currentTimeMillis() - this.sSx);
            ((Map)this.sSu).put(localObject1, Integer.valueOf((int)e.cEl()));
            continue;
            if (this.sSx != 0L) {
              e.HX(System.currentTimeMillis() - this.sSx);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "view", "Landroid/view/View;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, Float>
  {
    public static final c sSC;
    
    static
    {
      AppMethodBeat.i(265354);
      sSC = new c();
      AppMethodBeat.o(265354);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e sSE;
    
    static
    {
      AppMethodBeat.i(265596);
      sSE = new e();
      AppMethodBeat.o(265596);
    }
    
    public final void run()
    {
      AppMethodBeat.i(265595);
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEj();
      AppMethodBeat.o(265595);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements MTimerHandler.CallBack
  {
    public static final h sSI;
    
    static
    {
      AppMethodBeat.i(263168);
      sSI = new h();
      AppMethodBeat.o(263168);
    }
    
    public final boolean onTimerExpired()
    {
      int k = 0;
      AppMethodBeat.i(263167);
      Object localObject = MPVideoPreviewMgr.sSn;
      localObject = MPVideoPreviewMgr.cEh();
      TextView localTextView;
      int i;
      if (localObject != null)
      {
        localTextView = (TextView)((WeakReference)localObject).get();
        if (localTextView != null)
        {
          localObject = MPVideoPreviewMgr.sSn;
          localObject = MPVideoPreviewMgr.cEi();
          if (localObject == null) {
            break label162;
          }
          localObject = (AppBrandVideoView)((WeakReference)localObject).get();
          if (localObject == null) {
            break label162;
          }
          i = ((AppBrandVideoView)localObject).getDuration();
          localObject = MPVideoPreviewMgr.sSn;
          localObject = MPVideoPreviewMgr.cEi();
          int j = k;
          if (localObject != null)
          {
            localObject = (AppBrandVideoView)((WeakReference)localObject).get();
            j = k;
            if (localObject != null) {
              j = ((AppBrandVideoView)localObject).getCurrPosMs();
            }
          }
          p.j(localTextView, "it");
          localObject = com.tencent.mm.aj.m.uD((i * 1000 - j) / 1000);
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
        AppMethodBeat.o(263167);
        return true;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr
 * JD-Core Version:    0.7.0.1
 */