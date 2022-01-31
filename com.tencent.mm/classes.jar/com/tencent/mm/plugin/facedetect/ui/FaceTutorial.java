package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class FaceTutorial
{
  ViewPager Gr;
  q lA;
  View ldP;
  Button mkS;
  Animation mkW;
  FaceTutorial.a mmD;
  
  public FaceTutorial()
  {
    AppMethodBeat.i(526);
    this.ldP = null;
    this.mkW = null;
    ab.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.mkW = AnimationUtils.loadAnimation(ah.getContext(), 2131034126);
    this.mkW.setDuration(500L);
    AppMethodBeat.o(526);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(527);
    ab.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.ldP.getVisibility() == 0) {
      al.d(new FaceTutorial.3(this));
    }
    AppMethodBeat.o(527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial
 * JD-Core Version:    0.7.0.1
 */