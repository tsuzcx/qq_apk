package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
final class MPVideoView$l
  implements e.f
{
  MPVideoView$l(MPVideoView paramMPVideoView) {}
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(7495);
    MPVideoView.A(this.noy);
    Object localObject1 = MPVideoView.k(this.noy);
    if (localObject1 != null) {
      ((MPVideoView.c)localObject1).iC(paramBoolean);
    }
    localObject1 = MPVideoView.h(this.noy);
    if (localObject1 != null)
    {
      Object localObject2;
      if (paramBoolean)
      {
        ((MPExoVideoWrapper)localObject1).nnF = true;
        localObject2 = ((MPExoVideoWrapper)localObject1).nnm;
        if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
        {
          localObject2 = ((MPExoVideoWrapper)localObject1).nnn;
          if (localObject2 != null) {
            if (((TextView)localObject2).getVisibility() != 0) {
              break label265;
            }
          }
        }
        else
        {
          ad.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
          if (((MPExoVideoWrapper)localObject1).nnE)
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).nnm;
            if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
              ((MPExoVideoWrapper)localObject1).nnD = true;
            }
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).nnm;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          localObject1 = ((MPExoVideoWrapper)localObject1).nnn;
          if (localObject1 == null) {
            break label165;
          }
          ((TextView)localObject1).setVisibility(8);
          AppMethodBeat.o(7495);
          return;
        }
        AppMethodBeat.o(7495);
        return;
        label165:
        AppMethodBeat.o(7495);
      }
      else
      {
        ((MPExoVideoWrapper)localObject1).nnF = false;
        if (((MPExoVideoWrapper)localObject1).nnD)
        {
          ad.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).nnE);
          ((MPExoVideoWrapper)localObject1).nnD = false;
          if (((MPExoVideoWrapper)localObject1).nnE)
          {
            ((MPExoVideoWrapper)localObject1).bGC();
            AppMethodBeat.o(7495);
            return;
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).nnm;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).nnn;
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(0);
          }
          ((MPExoVideoWrapper)localObject1).bGD();
        }
      }
      label265:
      AppMethodBeat.o(7495);
      return;
    }
    AppMethodBeat.o(7495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.l
 * JD-Core Version:    0.7.0.1
 */