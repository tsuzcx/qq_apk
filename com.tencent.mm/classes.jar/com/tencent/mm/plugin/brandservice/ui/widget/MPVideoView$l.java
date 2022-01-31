package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
import a.v;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
final class MPVideoView$l
  implements d.d
{
  MPVideoView$l(MPVideoView paramMPVideoView) {}
  
  public final void dj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153019);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(153019);
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
      Object localObject = MPVideoView.F(this.kjR);
      if (localObject == null) {
        j.ebi();
      }
      paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
      localObject = MPVideoView.G(this.kjR);
      if (localObject == null) {
        j.ebi();
      }
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(153019);
        throw ((Throwable)localObject);
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).width = paramInt1;
      ImageView localImageView = MPVideoView.G(this.kjR);
      if (localImageView == null) {
        j.ebi();
      }
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoView.G(this.kjR);
      if (localObject == null) {
        j.ebi();
      }
      ((ImageView)localObject).requestLayout();
      localObject = MPVideoView.m(this.kjR);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).aZG();
        AppMethodBeat.o(153019);
        return;
      }
      AppMethodBeat.o(153019);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.l
 * JD-Core Version:    0.7.0.1
 */