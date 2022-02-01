package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "floatMode", "", "mount", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "Lkotlin/Function0;", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final a KwG;
  private final b IIs;
  private com.tencent.mm.live.core.core.a.a KwF;
  private final Context context;
  public final LivePreviewView qDY;
  
  static
  {
    AppMethodBeat.i(203029);
    KwG = new a((byte)0);
    AppMethodBeat.o(203029);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203028);
    this.IIs = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307637);
    k.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.qDY = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.qym;
    paramb = paramViewGroup.getContext();
    k.g(paramb, "root.context");
    this.KwF = ((com.tencent.mm.live.core.core.a.a)b.a.eG(paramb));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(203028);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(203027);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ap.ciE[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(203027);
      return;
      agK(0);
      AppMethodBeat.o(203027);
      return;
      ad.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.KwF;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = f.rGw;
      paramc = f.eNB();
      paramBundle = f.rGw;
      long l = f.eNG().LwA;
      paramBundle = f.rGw;
      paramBundle = f.eNI();
      com.tencent.mm.live.core.core.trtc.a.a locala = com.tencent.mm.live.core.core.trtc.a.a.cpE();
      k.g(locala, "ConfigHelper.getInstance()");
      if (locala.cpV().qGm == 0) {
        i = 1;
      }
      e.a(paramc, l, paramBundle, 1, i);
      com.tencent.mm.live.d.a.fPo();
      AppMethodBeat.o(203027);
      return;
      agK(8);
      paramc = this.KwF;
    } while (paramc == null);
    paramc.clf();
    AppMethodBeat.o(203027);
  }
  
  public final void fOM() {}
  
  public final void fON()
  {
    AppMethodBeat.i(203026);
    ad.i("MicroMsg.LiveCoreAnchor", "unMount");
    Object localObject = com.tencent.mm.live.core.core.a.b.qym;
    b.a.releaseInstance();
    localObject = f.rGw;
    f.VP();
    AppMethodBeat.o(203026);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(203025);
    com.tencent.mm.live.core.core.a.a locala = this.KwF;
    if (locala != null)
    {
      locala.a(this.qDY);
      AppMethodBeat.o(203025);
      return;
    }
    AppMethodBeat.o(203025);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */