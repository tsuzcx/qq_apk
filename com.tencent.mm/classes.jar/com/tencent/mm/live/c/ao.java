package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "floatMode", "", "mount", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final ao.a gWF;
  private final Context context;
  public final LivePreviewView gIn;
  private final b gSM;
  private com.tencent.mm.live.core.core.a.a gWE;
  
  static
  {
    AppMethodBeat.i(212553);
    gWF = new ao.a((byte)0);
    AppMethodBeat.o(212553);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212552);
    this.gSM = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.gIn = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.gHl;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.gWE = ((com.tencent.mm.live.core.core.a.a)b.a.cq(paramb));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(212552);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(212551);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ap.cpQ[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(212551);
      return;
      nI(0);
      AppMethodBeat.o(212551);
      return;
      ad.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.gWE;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = g.gOr;
      paramc = g.anm();
      paramBundle = g.gOr;
      long l = g.ans().Fsa;
      paramBundle = g.gOr;
      paramBundle = g.anu();
      com.tencent.mm.live.core.core.trtc.a.a locala = com.tencent.mm.live.core.core.trtc.a.a.alJ();
      p.g(locala, "ConfigHelper.getInstance()");
      if (locala.alN().gJh == 0) {
        i = 1;
      }
      e.a(paramc, l, paramBundle, 1, i);
      com.tencent.mm.live.d.a.apn();
      AppMethodBeat.o(212551);
      return;
      nI(8);
      paramc = this.gWE;
    } while (paramc == null);
    paramc.alc();
    AppMethodBeat.o(212551);
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212550);
    ad.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(212550);
  }
  
  public final void aoz() {}
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(212549);
    com.tencent.mm.live.core.core.a.a locala = this.gWE;
    if (locala != null)
    {
      locala.a(this.gIn);
      AppMethodBeat.o(212549);
      return;
    }
    AppMethodBeat.o(212549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */