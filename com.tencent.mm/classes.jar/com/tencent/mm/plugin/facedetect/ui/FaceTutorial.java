package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class FaceTutorial
{
  ViewPager Qd;
  q gJR;
  View jCI;
  Button rka;
  Animation rke;
  FaceTutorial.a rlK;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(104045);
    this.jCI = null;
    this.rke = null;
    ad.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.rke = AnimationUtils.loadAnimation(aj.getContext(), 2130771982);
    this.rke.setDuration(500L);
    AppMethodBeat.o(104045);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104046);
    ad.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.jCI.getVisibility() == 0) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104038);
          FaceTutorial.this.rke.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(104037);
              FaceTutorial.this.jCI.setVisibility(8);
              AppMethodBeat.o(104037);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          FaceTutorial.this.jCI.startAnimation(FaceTutorial.this.rke);
          AppMethodBeat.o(104038);
        }
      });
    }
    AppMethodBeat.o(104046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */