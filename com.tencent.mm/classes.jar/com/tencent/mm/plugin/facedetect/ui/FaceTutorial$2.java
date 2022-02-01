package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceTutorial$2
  implements ViewPager.OnPageChangeListener
{
  FaceTutorial$2(FaceTutorial paramFaceTutorial) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(104036);
    if (this.rlL.Qd.getParent() != null) {
      this.rlL.Qd.getParent().requestDisallowInterceptTouchEvent(true);
    }
    AppMethodBeat.o(104036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.2
 * JD-Core Version:    0.7.0.1
 */