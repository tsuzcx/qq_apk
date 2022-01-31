package android.support.transition;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class h$1
  implements ViewTreeObserver.OnPreDrawListener
{
  h$1(h paramh) {}
  
  public final boolean onPreDraw()
  {
    this.rQ.rO = this.rQ.mView.getMatrix();
    t.R(this.rQ);
    if ((this.rQ.rJ != null) && (this.rQ.rK != null))
    {
      this.rQ.rJ.endViewTransition(this.rQ.rK);
      t.R(this.rQ.rJ);
      this.rQ.rJ = null;
      this.rQ.rK = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.h.1
 * JD-Core Version:    0.7.0.1
 */