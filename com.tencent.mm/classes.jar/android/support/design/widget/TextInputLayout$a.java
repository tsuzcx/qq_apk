package android.support.design.widget;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.util.List;

final class TextInputLayout$a
  extends android.support.v4.view.a
{
  TextInputLayout$a(TextInputLayout paramTextInputLayout) {}
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setClassName(TextInputLayout.class.getSimpleName());
    paramView = this.lY.hd.mText;
    if (!TextUtils.isEmpty(paramView)) {
      parama.setText(paramView);
    }
    if (this.lY.ln != null)
    {
      paramView = this.lY.ln;
      if (Build.VERSION.SDK_INT >= 17) {
        parama.HJ.setLabelFor(paramView);
      }
    }
    if (this.lY.lw != null) {}
    for (paramView = this.lY.lw.getText();; paramView = null)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        if (Build.VERSION.SDK_INT >= 19) {
          parama.HJ.setContentInvalid(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
          parama.HJ.setError(paramView);
        }
      }
      return;
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
  }
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = this.lY.hd.mText;
    if (!TextUtils.isEmpty(paramView)) {
      paramAccessibilityEvent.getText().add(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.a
 * JD-Core Version:    0.7.0.1
 */