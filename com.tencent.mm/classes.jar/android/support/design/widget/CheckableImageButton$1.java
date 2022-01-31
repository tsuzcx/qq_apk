package android.support.design.widget;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class CheckableImageButton$1
  extends android.support.v4.view.a
{
  CheckableImageButton$1(CheckableImageButton paramCheckableImageButton) {}
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setCheckable(true);
    boolean bool = this.fR.isChecked();
    parama.HJ.setChecked(bool);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setChecked(this.fR.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.CheckableImageButton.1
 * JD-Core Version:    0.7.0.1
 */