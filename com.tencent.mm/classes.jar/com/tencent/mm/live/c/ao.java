package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "mount", "", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao
  extends a
{
  public static final a hSn;
  private final Context context;
  public final LivePreviewView hAs;
  private final b hOp;
  private com.tencent.mm.live.core.core.a.a hSm;
  
  static
  {
    AppMethodBeat.i(208141);
    hSn = new a((byte)0);
    AppMethodBeat.o(208141);
  }
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208140);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303506);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.hAs = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.hyv;
    paramViewGroup.getContext();
    this.hSm = ((com.tencent.mm.live.core.core.a.a)b.a.aDo());
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(208140);
  }
  
  public final void mount() {}
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void startPreview()
  {
    AppMethodBeat.i(208137);
    com.tencent.mm.live.core.core.a.a locala = this.hSm;
    if (locala != null)
    {
      LivePreviewView localLivePreviewView = this.hAs;
      Object localObject = x.hJf;
      localObject = x.aGk();
      x localx = x.hJf;
      locala.a(localLivePreviewView, (com.tencent.mm.live.core.b.a)localObject, x.aGl());
      AppMethodBeat.o(208137);
      return;
    }
    AppMethodBeat.o(208137);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(208139);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ap.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(208139);
      return;
      rg(0);
      AppMethodBeat.o(208139);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.hSm;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = x.hJf;
      paramc = x.aGm();
      paramBundle = x.hJf;
      long l = x.aGr().hyH;
      paramBundle = x.hJf;
      paramBundle = x.aGt();
      Object localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDG().hBp == 0) {
        i = 1;
      }
      localObject = x.hJf;
      e.a(paramc, l, paramBundle, 1, i, x.aGr().LIa);
      com.tencent.mm.live.d.a.aIa();
      AppMethodBeat.o(208139);
      return;
      rg(8);
      paramc = this.hSm;
    } while (paramc == null);
    paramc.aBS();
    AppMethodBeat.o(208139);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208138);
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(208138);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ao
 * JD-Core Version:    0.7.0.1
 */