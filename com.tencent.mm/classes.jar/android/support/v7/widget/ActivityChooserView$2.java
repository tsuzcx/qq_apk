package android.support.v7.widget;

import android.support.v4.view.b;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public final void onGlobalLayout()
  {
    if (this.YX.fX())
    {
      if (this.YX.isShown()) {
        break label31;
      }
      this.YX.getListPopupWindow().dismiss();
    }
    label31:
    do
    {
      return;
      this.YX.getListPopupWindow().show();
    } while (this.YX.YQ == null);
    this.YX.YQ.E(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0.1
 */