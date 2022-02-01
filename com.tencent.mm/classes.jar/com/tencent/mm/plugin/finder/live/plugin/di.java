package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "VideoLinkBottomBar", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "bringToFront", "", "userId", "", "streamType", "dp2px", "dpVal", "", "enterRoom", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "getPreview", "Landroid/view/View;", "getPreviewLayout", "micUserWaitingState", "type", "notifyLinkMicMode", "micUserMap", "Ljava/util/HashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/HashMap;", "notifyNormalMode", "onBackPress", "onMicUserChanged", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "orientationChanged", "orientation", "pause", "refreshCameraView", "refreshPreviewView", "resume", "setVisible", "visible", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "updateOutputSurface", "updatePreview", "Companion", "plugin-finder_release"})
public final class di
  extends d
{
  public static final a yzL;
  private Context context;
  private final com.tencent.mm.live.c.b kCL;
  private n kHZ;
  private int kIa;
  public final LivePreviewView knt;
  
  static
  {
    AppMethodBeat.i(243096);
    yzL = new a((byte)0);
    AppMethodBeat.o(243096);
  }
  
  public di(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(243095);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(b.f.live_preview_view);
    p.j(paramViewGroup, "root.findViewById(R.id.live_preview_view)");
    this.knt = ((LivePreviewView)paramViewGroup);
    this.kIa = getCurrentOrientation();
    AppMethodBeat.o(243095);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(243094);
    p.k(paramLinkedHashMap, "micUserMap");
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
    Object localObject1 = e.b.kjz;
    Object localObject3;
    if (i != e.b.aJJ())
    {
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
      localObject1 = e.b.kjz;
      if (i == e.b.aJK())
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
        p.j(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      }
    }
    else
    {
      synchronized ((Iterable)localObject1)
      {
        localObject3 = ((Iterable)???).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          paramBoolean = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).ktR, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU());
          if (paramBoolean)
          {
            if (localObject1 == null) {
              break label499;
            }
            if (paramLinkedHashMap.size() <= 1) {
              break label343;
            }
            paramLinkedHashMap = (HashMap)paramLinkedHashMap;
            ??? = new ArrayList();
            ((ArrayList)???).addAll((Collection)paramLinkedHashMap.keySet());
            if (this.kiF.getLayoutParams() != null) {
              break label236;
            }
            paramLinkedHashMap = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(243094);
            throw paramLinkedHashMap;
          }
        }
        localObject1 = null;
      }
      label236:
      localObject3 = this.knt;
      paramLinkedHashMap = getLiveCore();
      if (paramLinkedHashMap != null)
      {
        paramLinkedHashMap = paramLinkedHashMap.knA;
        if (paramLinkedHashMap != null)
        {
          paramLinkedHashMap = paramLinkedHashMap.kmC;
          if (paramLinkedHashMap != null) {
            break label514;
          }
        }
      }
      paramLinkedHashMap = "";
    }
    label514:
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU();
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        ((LivePreviewView)localObject3).a(paramLinkedHashMap, (String)localObject1, (List)???);
        b.b.a(this.kCL, b.c.kBb);
        Log.i("Finder.FinderLiveVisitorPreviewPlugin", "notifyLinkMicMode userIdList:".concat(String.valueOf(???)));
        AppMethodBeat.o(243094);
        return;
        label343:
        paramLinkedHashMap = (HashMap)paramLinkedHashMap;
        ??? = new ArrayList();
        ((ArrayList)???).addAll((Collection)paramLinkedHashMap.keySet());
        if (this.kiF.getLayoutParams() == null)
        {
          paramLinkedHashMap = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(243094);
          throw paramLinkedHashMap;
        }
        localObject3 = this.knt;
        paramLinkedHashMap = getLiveCore();
        if (paramLinkedHashMap != null)
        {
          paramLinkedHashMap = paramLinkedHashMap.knA;
          if (paramLinkedHashMap != null)
          {
            paramLinkedHashMap = paramLinkedHashMap.kmC;
            if (paramLinkedHashMap != null) {
              break label508;
            }
          }
        }
        paramLinkedHashMap = "";
        label499:
        label508:
        for (;;)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU();
          if (localObject1 == null) {
            localObject1 = "";
          }
          for (;;)
          {
            ((LivePreviewView)localObject3).a(paramLinkedHashMap, (String)localObject1, (List)???);
            b.b.a(this.kCL, b.c.kBc);
            Log.i("Finder.FinderLiveVisitorPreviewPlugin", "notifyNormalMode userIdList:".concat(String.valueOf(???)));
            AppMethodBeat.o(243094);
            return;
          }
        }
      }
    }
  }
  
  public final void aCm(final String paramString)
  {
    AppMethodBeat.i(243086);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramString));
    AppMethodBeat.o(243086);
  }
  
  public final void aCy(String paramString)
  {
    AppMethodBeat.i(243083);
    paramString = this.knt.ksW.NU(paramString);
    if (paramString != null)
    {
      paramString.bringToFront();
      AppMethodBeat.o(243083);
      return;
    }
    AppMethodBeat.o(243083);
  }
  
  public final void aNs()
  {
    AppMethodBeat.i(243085);
    this.knt.ksW.aNs();
    AppMethodBeat.o(243085);
  }
  
  public final void ave()
  {
    AppMethodBeat.i(243078);
    com.tencent.mm.live.core.core.c.c localc = getLiveCore();
    Object localObject1;
    if (localc != null)
    {
      localObject1 = ah.yhC;
      localc.sY(ah.aMQ());
    }
    localc = getLiveCore();
    if (localc != null)
    {
      localObject1 = this.knt;
      Object localObject2 = ah.yhC;
      localObject2 = ah.aOk();
      ah localah = ah.yhC;
      localc.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, ah.aOl());
      AppMethodBeat.o(243078);
      return;
    }
    AppMethodBeat.o(243078);
  }
  
  public final void dCV()
  {
    AppMethodBeat.i(243077);
    com.tencent.mm.live.core.core.c.c localc = getLiveCore();
    if (localc != null)
    {
      localc.knt = this.knt;
      AppMethodBeat.o(243077);
      return;
    }
    AppMethodBeat.o(243077);
  }
  
  public final void dCW()
  {
    AppMethodBeat.i(243081);
    Object localObject = getLiveCore();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject).knt = this.knt;
    }
    com.tencent.mm.live.core.core.c.c localc = getLiveCore();
    if (localc != null)
    {
      localObject = getLiveCore();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
        if (localObject == null) {}
      }
      for (localObject = ((com.tencent.mm.live.core.core.model.h)localObject).kmC;; localObject = null)
      {
        localc.Nx((String)localObject);
        AppMethodBeat.o(243081);
        return;
      }
    }
    AppMethodBeat.o(243081);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(243074);
    com.tencent.mm.live.core.core.c.c localc = getLiveCore();
    if (localc != null)
    {
      localc.b((com.tencent.mm.live.core.core.c)new c());
      AppMethodBeat.o(243074);
      return;
    }
    AppMethodBeat.o(243074);
  }
  
  public final com.tencent.mm.live.core.core.c.c getLiveCore()
  {
    AppMethodBeat.i(243071);
    Object localObject = com.tencent.mm.live.core.core.c.a.kqk;
    localObject = (com.tencent.mm.live.core.core.c.c)a.a.FC(getData().zey.getLiveId());
    AppMethodBeat.o(243071);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(243090);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (dj.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(243090);
      return;
      exitRoom();
      tU(8);
      AppMethodBeat.o(243090);
      return;
      if (paramBundle != null) {
        paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      paramc = getLiveCore();
      if (paramc != null) {
        paramc.aMk();
      }
      paramc = ah.yhC;
      ah.bvY();
      this.knt.ksW.aNq();
      AppMethodBeat.o(243090);
      return;
      paramc = this.kHZ;
      if (paramc != null)
      {
        paramBundle = getLiveCore();
        if (paramBundle != null)
        {
          paramBundle.a(paramc);
          AppMethodBeat.o(243090);
          return;
        }
        AppMethodBeat.o(243090);
        return;
      }
      AppMethodBeat.o(243090);
      return;
      tU(0);
      paramc = this.knt.getParent();
      if ((paramc != null) && ((paramc instanceof ViewGroup)))
      {
        ((ViewGroup)paramc).removeView((View)this.knt);
        ((ViewGroup)paramc).addView((View)this.knt);
      }
      paramc = this.knt;
      paramBundle = this.kiF.getContext();
      p.j(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.j(paramBundle, "root.context.resources");
      paramc.tD(paramBundle.getConfiguration().orientation);
      paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.aLJ();
      p.j(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.j(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramc.fd(bool);
        paramc = getLiveCore();
        if (paramc == null) {
          break;
        }
        paramc.b(this.knt);
        AppMethodBeat.o(243090);
        return;
      }
      AppMethodBeat.o(243090);
      return;
      this.knt.ksW.aNq();
      paramc = getLiveCore();
      if (paramc != null)
      {
        paramc.aMk();
        AppMethodBeat.o(243090);
        return;
      }
      AppMethodBeat.o(243090);
      return;
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", "switchCamera");
      paramc = getLiveCore();
    } while (paramc == null);
    paramc.switchCamera();
    AppMethodBeat.o(243090);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(243088);
    super.tU(paramInt);
    Log.printInfoStack("Finder.FinderLiveVisitorPreviewPlugin", "setVisible ".concat(String.valueOf(paramInt)), new Object[0]);
    AppMethodBeat.o(243088);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.c
  {
    public b(kotlin.g.a.b paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(271667);
      if (paramInt >= 0)
      {
        di.dCX();
        this.kHb.invoke(Boolean.TRUE);
        AppMethodBeat.o(271667);
        return;
      }
      di.dCY();
      this.kHb.invoke(Boolean.FALSE);
      AppMethodBeat.o(271667);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(272162);
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", "on exit room finish");
      AppMethodBeat.o(272162);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(di paramdi, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.di
 * JD-Core Version:    0.7.0.1
 */