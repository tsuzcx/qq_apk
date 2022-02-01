package com.tencent.mm.live.b;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager.b;
import com.tencent.mm.live.model.u;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "mount", "", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends a
{
  public static final w.a njE;
  private final Context context;
  public final LivePreviewView mRt;
  private final b nfT;
  private com.tencent.mm.live.core.core.a.a njF;
  
  static
  {
    AppMethodBeat.i(247217);
    njE = new w.a((byte)0);
    AppMethodBeat.o(247217);
  }
  
  public w(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247205);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_preview_view);
    s.s(paramb, "root.findViewById(R.id.live_preview_view)");
    this.mRt = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.a.b.mMo;
    this.njF = ((com.tencent.mm.live.core.core.a.a)b.a.bej());
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(247205);
  }
  
  public final void aPz()
  {
    AppMethodBeat.i(247238);
    com.tencent.mm.live.core.core.a.a locala = this.njF;
    if (locala != null)
    {
      LivePreviewView localLivePreviewView = this.mRt;
      Object localObject = u.mZl;
      localObject = u.bhX();
      u localu = u.mZl;
      locala.a(localLivePreviewView, (com.tencent.mm.live.core.b.a)localObject, u.bhY());
    }
    this.mRt.bha();
    AppMethodBeat.o(247238);
  }
  
  public final void bjr()
  {
    AppMethodBeat.i(247226);
    Iterator localIterator = this.mRt.mWP.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if ((localb.mXw.mVideoView != null) && (localb.mXw.getParent() != null) && ((localb.mXw.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.mXw.getParent();
        localViewGroup.removeView(localb.mXw);
        localViewGroup.addView(localb.mXw);
      }
    }
    AppMethodBeat.o(247226);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(247247);
    s.u(paramString, "userId");
    this.mRt.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(247247);
  }
  
  public final void mount() {}
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(247282);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (w.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247282);
      return;
      tO(0);
      AppMethodBeat.o(247282);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = this.njF;
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = u.mZl;
      paramc = u.bhZ();
      paramBundle = u.mZl;
      long l = u.bie().mMJ;
      paramBundle = u.mZl;
      paramBundle = u.big();
      if (a.a.bfr().bfq().cameraId == 0) {
        i = 1;
      }
      u localu = u.mZl;
      e.a(paramc, l, paramBundle, 1, i, u.bie().ZWw);
      com.tencent.mm.live.c.a.bjL();
      AppMethodBeat.o(247282);
      return;
      tO(8);
      paramc = this.njF;
      if (paramc != null) {
        paramc.bce();
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247271);
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(247271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.w
 * JD-Core Version:    0.7.0.1
 */