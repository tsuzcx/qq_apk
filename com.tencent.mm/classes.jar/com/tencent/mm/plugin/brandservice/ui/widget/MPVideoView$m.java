package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
final class MPVideoView$m
  implements d.e
{
  MPVideoView$m(MPVideoView paramMPVideoView) {}
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7496);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(7496);
      return;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 > paramInt2) {
        i = paramInt2;
      }
      Object localObject = MPVideoView.C(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
      localObject = MPVideoView.D(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7496);
        throw ((Throwable)localObject);
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).width = paramInt1;
      ImageView localImageView = MPVideoView.D(this.sVn);
      if (localImageView == null) {
        p.iCn();
      }
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoView.D(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((ImageView)localObject).requestLayout();
      MPVideoView.k(this.sVn);
      AppMethodBeat.o(7496);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.m
 * JD-Core Version:    0.7.0.1
 */