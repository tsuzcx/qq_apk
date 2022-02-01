package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
{
  public static void a(View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140677);
    if ((paramView != null) && (paramJSONObject != null) && (paramJSONObject.has("accessibility")) && (paramJSONObject.optBoolean("accessibility", false))) {
      paramView.setAccessibilityDelegate(new View.AccessibilityDelegate()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          AppMethodBeat.i(140676);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
          if (!Util.isNullOrNil(this.pEq)) {
            paramAnonymousAccessibilityNodeInfo.setContentDescription(this.pEq);
          }
          if ((!Util.isNullOrNil(this.pEr)) && (this.pEr.equalsIgnoreCase("button")))
          {
            paramAnonymousAccessibilityNodeInfo.setClickable(true);
            paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
            AppMethodBeat.o(140676);
            return;
          }
          paramAnonymousAccessibilityNodeInfo.setClickable(false);
          paramAnonymousAccessibilityNodeInfo.setClassName(TextView.class.getName());
          AppMethodBeat.o(140676);
        }
      });
    }
    AppMethodBeat.o(140677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.b
 * JD-Core Version:    0.7.0.1
 */