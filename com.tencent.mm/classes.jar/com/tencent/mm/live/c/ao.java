package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "floatMode", "", "mount", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final ao.a gZs;
  private final Context context;
  public final LivePreviewView gKW;
  private final b gVv;
  private com.tencent.mm.live.core.core.a.a gZr;
  
  static
  {
    AppMethodBeat.i(216179);
    gZs = new ao.a((byte)0);
    AppMethodBeat.o(216179);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216178);
    this.gVv = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.gKW = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.gJU;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.gZr = ((com.tencent.mm.live.core.core.a.a)b.a.cs(paramb));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(216178);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(216177);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ap.cqt[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(216177);
      return;
      nL(0);
      AppMethodBeat.o(216177);
      return;
      ae.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.gZr;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = g.gQZ;
      paramc = g.anC();
      paramBundle = g.gQZ;
      long l = g.anH().FKy;
      paramBundle = g.gQZ;
      paramBundle = g.anJ();
      Object localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
      p.g(localObject, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).amc().gLQ == 0) {
        i = 1;
      }
      localObject = g.gQZ;
      e.a(paramc, l, paramBundle, 1, i, g.anH().GTv);
      com.tencent.mm.live.d.a.apB();
      AppMethodBeat.o(216177);
      return;
      nL(8);
      paramc = this.gZr;
    } while (paramc == null);
    paramc.alr();
    AppMethodBeat.o(216177);
  }
  
  public final void aoO() {}
  
  public final void aoP()
  {
    AppMethodBeat.i(216176);
    ae.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(216176);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(216175);
    com.tencent.mm.live.core.core.a.a locala = this.gZr;
    if (locala != null)
    {
      locala.a(this.gKW);
      AppMethodBeat.o(216175);
      return;
    }
    AppMethodBeat.o(216175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */