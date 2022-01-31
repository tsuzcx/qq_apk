package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1
  extends View.AccessibilityDelegate
{
  a$1(String paramString1, String paramString2) {}
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(91065);
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (!bo.isNullOrNil(this.ieQ)) {
      paramAccessibilityNodeInfo.setContentDescription(this.ieQ);
    }
    if ((!bo.isNullOrNil(this.ieR)) && (this.ieR.equalsIgnoreCase("button")))
    {
      paramAccessibilityNodeInfo.setClickable(true);
      paramAccessibilityNodeInfo.setClassName(Button.class.getName());
      AppMethodBeat.o(91065);
      return;
    }
    paramAccessibilityNodeInfo.setClickable(false);
    paramAccessibilityNodeInfo.setClassName(TextView.class.getName());
    AppMethodBeat.o(91065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a.1
 * JD-Core Version:    0.7.0.1
 */