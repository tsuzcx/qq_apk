package android.support.v7.widget;

import android.support.v4.view.b;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public final void onGlobalLayout()
  {
    if (this.ZI.gU())
    {
      if (this.ZI.isShown()) {
        break label31;
      }
      this.ZI.getListPopupWindow().dismiss();
    }
    label31:
    do
    {
      return;
      this.ZI.getListPopupWindow().show();
    } while (this.ZI.ZB == null);
    this.ZI.ZB.E(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0.1
 */