package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "VideoLinkBottomBar", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "bringToFront", "", "userId", "", "streamType", "dp2px", "dpVal", "", "enterRoom", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "getPreview", "Landroid/view/View;", "getPreviewLayout", "notifyNormalMode", "notifyVideoLinkMicOthersMode", "anchorUserId", "topMargin", "notifyVideoLinkMicSelfMode", "onBackPress", "orientationChanged", "orientation", "pause", "refreshCameraView", "refreshPreviewView", "requestStopMic", "restoreFromHalfMode", "resume", "setVisible", "visible", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "updateCore", "updateOutputSurface", "updatePreview", "Companion", "plugin-finder_release"})
public final class bz
  extends d
{
  public static final a uvS;
  private Context context;
  public final LivePreviewView hAs;
  public final com.tencent.mm.live.c.b hOp;
  private com.tencent.mm.live.core.b.l hTC;
  private int hTD;
  public com.tencent.mm.live.core.core.d.b liveCore;
  
  static
  {
    AppMethodBeat.i(247222);
    uvS = new a((byte)0);
    AppMethodBeat.o(247222);
  }
  
  public bz(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247221);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303506);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.hAs = ((LivePreviewView)paramb);
    this.hTD = getCurrentOrientation();
    paramb = com.tencent.mm.live.core.core.d.b.hCo;
    paramViewGroup.getContext();
    this.liveCore = b.a.aEf();
    AppMethodBeat.o(247221);
  }
  
  public final void a(f paramf, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(247214);
    p.h(paramf, "liveRoomModel");
    p.h(paramb, "action");
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    if (localb != null) {
      localb.a(paramf);
    }
    paramf = this.liveCore;
    if (paramf != null)
    {
      paramf.a(this.hAs, (c)new b(this, paramb));
      AppMethodBeat.o(247214);
      return;
    }
    AppMethodBeat.o(247214);
  }
  
  public final void atO(String paramString)
  {
    AppMethodBeat.i(247218);
    paramString = this.hAs.hER.GG(paramString);
    if (paramString != null)
    {
      paramString.bringToFront();
      AppMethodBeat.o(247218);
      return;
    }
    AppMethodBeat.o(247218);
  }
  
  public final void dgY()
  {
    AppMethodBeat.i(247216);
    Object localObject = this.hwr.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(247216);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this));
    b.b.a(this.hOp, b.c.hNR);
    AppMethodBeat.o(247216);
  }
  
  public final void dhZ()
  {
    AppMethodBeat.i(247213);
    Object localObject = this.liveCore;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.live.core.core.d.b)localObject).aDZ());; localObject = null)
    {
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", "requestLinkMic ret:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(247213);
      return;
    }
  }
  
  public final void dia()
  {
    AppMethodBeat.i(247217);
    Object localObject = this.liveCore;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.d.b)localObject).a(this.hAs);
    }
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    if (localb != null)
    {
      localObject = this.liveCore;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).hAz;
        if (localObject == null) {}
      }
      for (localObject = ((g)localObject).hzG;; localObject = null)
      {
        localb.Gp((String)localObject);
        AppMethodBeat.o(247217);
        return;
      }
    }
    AppMethodBeat.o(247217);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(247212);
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    if (localb != null)
    {
      localb.b((c)new c());
      AppMethodBeat.o(247212);
      return;
    }
    AppMethodBeat.o(247212);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(247219);
    super.rg(paramInt);
    Log.printInfoStack("Finder.FinderLiveVisitorPreviewPlugin", "setVisible ".concat(String.valueOf(paramInt)), new Object[0]);
    AppMethodBeat.o(247219);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(247215);
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    Object localObject1;
    if (localb != null)
    {
      localObject1 = o.ujN;
      localb.qs(o.dgk());
    }
    localb = this.liveCore;
    if (localb != null)
    {
      localObject1 = this.hAs;
      Object localObject2 = o.ujN;
      localObject2 = o.aGk();
      o localo = o.ujN;
      localb.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, o.aGl());
      AppMethodBeat.o(247215);
      return;
    }
    AppMethodBeat.o(247215);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247220);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ca.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(247220);
      return;
      exitRoom();
      rg(8);
      AppMethodBeat.o(247220);
      return;
      if (paramBundle != null) {
        paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      paramc = com.tencent.mm.live.core.core.d.b.hCo;
      this.hwr.getContext();
      b.a.aEf().aEd();
      dhZ();
      this.hAs.hER.aEY();
      AppMethodBeat.o(247220);
      return;
      paramc = this.hTC;
      if (paramc != null)
      {
        paramBundle = this.liveCore;
        if (paramBundle != null)
        {
          paramBundle.a(paramc);
          AppMethodBeat.o(247220);
          return;
        }
        AppMethodBeat.o(247220);
        return;
      }
      AppMethodBeat.o(247220);
      return;
      rg(0);
      paramc = this.hAs.getParent();
      if ((paramc != null) && ((paramc instanceof ViewGroup)))
      {
        ((ViewGroup)paramc).removeView((View)this.hAs);
        ((ViewGroup)paramc).addView((View)this.hAs);
      }
      paramc = this.hAs;
      paramBundle = this.hwr.getContext();
      p.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "root.context.resources");
      paramc.qO(paramBundle.getConfiguration().orientation);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.aDD();
      p.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramc.eA(bool);
        paramc = com.tencent.mm.live.core.core.d.b.hCo;
        this.hwr.getContext();
        b.a.aEf().b(this.hAs);
        AppMethodBeat.o(247220);
        return;
      }
      this.hAs.hER.aEY();
      paramc = com.tencent.mm.live.core.core.d.b.hCo;
      this.hwr.getContext();
      b.a.aEf().aEd();
      AppMethodBeat.o(247220);
      return;
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", "switchCamera");
      paramc = this.liveCore;
    } while (paramc == null);
    paramc.switchCamera();
    AppMethodBeat.o(247220);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class b
    implements c
  {
    b(kotlin.g.a.b paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(247209);
      if (paramInt >= 0)
      {
        bz.dib();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(247209);
        return;
      }
      bz.dic();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(247209);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class c
    implements c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(247210);
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", "on exit room finish");
      AppMethodBeat.o(247210);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(bz parambz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bz
 * JD-Core Version:    0.7.0.1
 */