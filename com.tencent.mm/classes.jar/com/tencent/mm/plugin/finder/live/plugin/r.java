package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "pkAvatarGroup", "Landroid/widget/RelativeLayout;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "getPreviewLayout", "mount", "", "notifyLinkMicMode", "userId", "", "topMargin", "bottomMargin", "notifyNormalMode", "orientationChanged", "orientation", "streamType", "pause", "refreshCameraView", "refreshPreviewView", "restoreFromHalfMode", "resume", "setPkUserId", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "setSelfUserId", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-finder_release"})
public final class r
  extends d
{
  public static final a unV;
  private final Context context;
  public final LivePreviewView hAs;
  public final com.tencent.mm.live.c.b hOp;
  private com.tencent.mm.live.core.core.trtc.a hSS;
  
  static
  {
    AppMethodBeat.i(246521);
    unV = new a((byte)0);
    AppMethodBeat.o(246521);
  }
  
  public r(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246520);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303506);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.hAs = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.hyv;
    paramViewGroup.getContext();
    this.hSS = ((com.tencent.mm.live.core.core.trtc.a)b.a.aDo());
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(246520);
  }
  
  public final void dgY()
  {
    AppMethodBeat.i(246519);
    Object localObject = this.hwr.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(246519);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this));
    b.b.a(this.hOp, b.c.hNR);
    AppMethodBeat.o(246519);
  }
  
  public final void mount() {}
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(246516);
    com.tencent.mm.live.core.core.trtc.a locala = this.hSS;
    Object localObject1;
    if (locala != null)
    {
      localObject1 = o.ujN;
      locala.qs(o.dgk());
    }
    locala = this.hSS;
    if (locala != null)
    {
      localObject1 = this.hAs;
      Object localObject2 = o.ujN;
      localObject2 = o.aGk();
      o localo = o.ujN;
      locala.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, o.aGl());
    }
    this.hwr.post((Runnable)new c(this));
    AppMethodBeat.o(246516);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(246518);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (s.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(246518);
      return;
      rg(0);
      AppMethodBeat.o(246518);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.hSS;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = this.hSS;
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(246518);
        throw paramc;
      }
      paramc = (com.tencent.mm.live.core.core.a.b)paramc;
      paramBundle = o.ujN;
      paramc.ew(o.dgl());
      paramc = com.tencent.mm.live.b.x.hJf;
      paramc = com.tencent.mm.live.b.x.aGm();
      paramBundle = com.tencent.mm.live.b.x.hJf;
      long l = com.tencent.mm.live.b.x.aGr().hyH;
      paramBundle = com.tencent.mm.live.b.x.hJf;
      paramBundle = com.tencent.mm.live.b.x.aGt();
      Object localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDG().hBp == 0) {
        i = 1;
      }
      localObject = z.aTY();
      p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      e.a(paramc, l, paramBundle, 1, i, (String)localObject, com.tencent.mm.live.b.x.aGr().LIa);
      com.tencent.mm.live.d.a.aIa();
      AppMethodBeat.o(246518);
      return;
      paramc = this.hSS;
    } while (paramc == null);
    paramc.aBS();
    AppMethodBeat.o(246518);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246517);
    super.unMount();
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(246517);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(246515);
      if ((r.a(this.unW) instanceof com.tencent.mm.live.core.core.a.b))
      {
        Object localObject = r.a(this.unW);
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(246515);
          throw ((Throwable)localObject);
        }
        localObject = (com.tencent.mm.live.core.core.a.b)localObject;
        o localo = o.ujN;
        ((com.tencent.mm.live.core.core.a.b)localObject).ew(o.dgl());
      }
      AppMethodBeat.o(246515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.r
 * JD-Core Version:    0.7.0.1
 */