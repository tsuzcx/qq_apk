package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "floatMode", "", "mount", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final ao.a gCV;
  private final Context context;
  private com.tencent.mm.live.core.core.a.a gCU;
  public final LivePreviewView goF;
  private final b gzb;
  
  static
  {
    AppMethodBeat.i(190263);
    gCV = new ao.a((byte)0);
    AppMethodBeat.o(190263);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190262);
    this.gzb = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    k.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.goF = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.gnC;
    paramb = paramViewGroup.getContext();
    k.g(paramb, "root.context");
    this.gCU = ((com.tencent.mm.live.core.core.a.a)b.a.ct(paramb));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(190262);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(190261);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ap.cfA[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(190261);
      return;
      nj(0);
      AppMethodBeat.o(190261);
      return;
      ac.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.gCU;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = g.guG;
      paramc = g.akA();
      paramBundle = g.guG;
      long l = g.akF().DMV;
      paramBundle = g.guG;
      paramBundle = g.akH();
      com.tencent.mm.live.core.core.trtc.a.a locala = com.tencent.mm.live.core.core.trtc.a.a.aiX();
      k.g(locala, "ConfigHelper.getInstance()");
      if (locala.ajb().gpy == 0) {
        i = 1;
      }
      e.a(paramc, l, paramBundle, 1, i);
      com.tencent.mm.live.d.a.amA();
      AppMethodBeat.o(190261);
      return;
      nj(8);
      paramc = this.gCU;
    } while (paramc == null);
    paramc.aiq();
    AppMethodBeat.o(190261);
  }
  
  public final void alM() {}
  
  public final void alN()
  {
    AppMethodBeat.i(190260);
    ac.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(190260);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(190259);
    com.tencent.mm.live.core.core.a.a locala = this.gCU;
    if (locala != null)
    {
      locala.a(this.goF);
      AppMethodBeat.o(190259);
      return;
    }
    AppMethodBeat.o(190259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */