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
    AppMethodBeat.i(517);
    if (this.mmE.Gr.getParent() != null) {
      this.mmE.Gr.getParent().requestDisallowInterceptTouchEvent(true);
    }
    AppMethodBeat.o(517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.2
 * JD-Core Version:    0.7.0.1
 */