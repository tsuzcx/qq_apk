package android.support.transition;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class h$1
  implements ViewTreeObserver.OnPreDrawListener
{
  h$1(h paramh) {}
  
  public final boolean onPreDraw()
  {
    this.qT.qR = this.qT.mView.getMatrix();
    q.O(this.qT);
    if ((this.qT.qM != null) && (this.qT.qN != null))
    {
      this.qT.qM.endViewTransition(this.qT.qN);
      q.O(this.qT.qM);
      this.qT.qM = null;
      this.qT.qN = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.h.1
 * JD-Core Version:    0.7.0.1
 */