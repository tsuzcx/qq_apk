package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "currentOffset", "", "getCurrentOffset", "()I", "setCurrentOffset", "(I)V", "onMMOverScrollOffset", "", "offset", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
public final class BizVideoDetailUI$w
  implements LogoWebViewWrapper.b
{
  private int kgp;
  
  public final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152836);
    this.kgp = paramInt;
    Object localObject1 = this.kgi.aYg();
    Object localObject2 = this.kgi.aYg().getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(152836);
      throw ((Throwable)localObject1);
    }
    localObject2 = (FrameLayout.LayoutParams)localObject2;
    ((FrameLayout.LayoutParams)localObject2).topMargin = (-this.kgp);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = BizVideoDetailUI.b(this.kgi);
    j.p(localObject1, "animationLayout");
    if (((View)localObject1).getVisibility() == 0)
    {
      localObject1 = BizVideoDetailUI.b(this.kgi);
      j.p(localObject1, "animationLayout");
      localObject2 = BizVideoDetailUI.b(this.kgi);
      j.p(localObject2, "animationLayout");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(152836);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (-this.kgp);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(152836);
  }
  
  public final boolean aZH()
  {
    AppMethodBeat.i(152837);
    int i = Math.min((this.kgi.iiX - BizVideoDetailUI.e(this.kgi).getHeight()) / 6, a.fromDPToPix((Context)this.kgi.getContext(), 60));
    if (Math.abs(this.kgp) > i)
    {
      this.kgi.finish();
      AppMethodBeat.o(152837);
      return true;
    }
    AppMethodBeat.o(152837);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.w
 * JD-Core Version:    0.7.0.1
 */