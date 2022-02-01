package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "mount", "", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final a kGK;
  private final Context context;
  private final b kCL;
  private com.tencent.mm.live.core.core.a.a kGJ;
  public final LivePreviewView knt;
  
  static
  {
    AppMethodBeat.i(200205);
    kGK = new a((byte)0);
    AppMethodBeat.o(200205);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(200204);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_preview_view);
    p.j(paramb, "root.findViewById(R.id.live_preview_view)");
    this.knt = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.klq;
    this.kGJ = ((com.tencent.mm.live.core.core.a.a)b.b.aLh());
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(200204);
  }
  
  public final void ave()
  {
    AppMethodBeat.i(200194);
    com.tencent.mm.live.core.core.a.a locala = this.kGJ;
    if (locala != null)
    {
      LivePreviewView localLivePreviewView = this.knt;
      Object localObject = u.kwz;
      localObject = u.aOk();
      u localu = u.kwz;
      locala.a(localLivePreviewView, (com.tencent.mm.live.core.b.a)localObject, u.aOl());
      AppMethodBeat.o(200194);
      return;
    }
    AppMethodBeat.o(200194);
  }
  
  public final void mount() {}
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(200203);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ap.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(200203);
      return;
      tU(0);
      AppMethodBeat.o(200203);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.kGJ;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = u.kwz;
      paramc = u.aOm();
      paramBundle = u.kwz;
      long l = u.aOr().klE;
      paramBundle = u.kwz;
      paramBundle = u.aOt();
      Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(localObject, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLM().kpc == 0) {
        i = 1;
      }
      localObject = u.kwz;
      e.a(paramc, l, paramBundle, 1, i, u.aOr().SOs);
      com.tencent.mm.live.d.a.aPY();
      AppMethodBeat.o(200203);
      return;
      tU(8);
      paramc = this.kGJ;
    } while (paramc == null);
    paramc.aJx();
    AppMethodBeat.o(200203);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(200199);
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(200199);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */