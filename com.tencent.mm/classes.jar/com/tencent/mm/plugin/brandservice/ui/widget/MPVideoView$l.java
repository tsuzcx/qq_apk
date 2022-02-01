package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
final class MPVideoView$l
  implements d.f
{
  MPVideoView$l(MPVideoView paramMPVideoView) {}
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(7495);
    MPVideoView.A(this.sVn);
    MPVideoView.k(this.sVn);
    Object localObject1 = MPVideoView.h(this.sVn);
    if (localObject1 != null)
    {
      Object localObject2;
      if (paramBoolean)
      {
        ((MPExoVideoWrapper)localObject1).sUu = true;
        localObject2 = ((MPExoVideoWrapper)localObject1).sUb;
        if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
        {
          localObject2 = ((MPExoVideoWrapper)localObject1).sUc;
          if (localObject2 != null) {
            if (((TextView)localObject2).getVisibility() != 0) {
              break label254;
            }
          }
        }
        else
        {
          Log.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
          if (((MPExoVideoWrapper)localObject1).sUt)
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).sUb;
            if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
              ((MPExoVideoWrapper)localObject1).sUs = true;
            }
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).sUb;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          localObject1 = ((MPExoVideoWrapper)localObject1).sUc;
          if (localObject1 == null) {
            break label154;
          }
          ((TextView)localObject1).setVisibility(8);
          AppMethodBeat.o(7495);
          return;
        }
        AppMethodBeat.o(7495);
        return;
        label154:
        AppMethodBeat.o(7495);
      }
      else
      {
        ((MPExoVideoWrapper)localObject1).sUu = false;
        if (((MPExoVideoWrapper)localObject1).sUs)
        {
          Log.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).sUt);
          ((MPExoVideoWrapper)localObject1).sUs = false;
          if (((MPExoVideoWrapper)localObject1).sUt)
          {
            ((MPExoVideoWrapper)localObject1).cEy();
            AppMethodBeat.o(7495);
            return;
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).sUb;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          localObject2 = ((MPExoVideoWrapper)localObject1).sUc;
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(0);
          }
          ((MPExoVideoWrapper)localObject1).cEz();
        }
      }
      label254:
      AppMethodBeat.o(7495);
      return;
    }
    AppMethodBeat.o(7495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.l
 * JD-Core Version:    0.7.0.1
 */