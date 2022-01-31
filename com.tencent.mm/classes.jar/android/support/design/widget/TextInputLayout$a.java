package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.util.List;

final class TextInputLayout$a
  extends a
{
  TextInputLayout$a(TextInputLayout paramTextInputLayout) {}
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    paramb.setClassName(TextInputLayout.class.getSimpleName());
    paramView = this.mT.hW.mText;
    if (!TextUtils.isEmpty(paramView)) {
      paramb.setText(paramView);
    }
    if (this.mT.mEditText != null)
    {
      paramView = this.mT.mEditText;
      if (Build.VERSION.SDK_INT >= 17) {
        paramb.Hq.setLabelFor(paramView);
      }
    }
    if (this.mT.mr != null) {}
    for (paramView = this.mT.mr.getText();; paramView = null)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        if (Build.VERSION.SDK_INT >= 19) {
          paramb.Hq.setContentInvalid(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramb.Hq.setError(paramView);
        }
      }
      return;
    }
  }
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = this.mT.hW.mText;
    if (!TextUtils.isEmpty(paramView)) {
      paramAccessibilityEvent.getText().add(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.a
 * JD-Core Version:    0.7.0.1
 */