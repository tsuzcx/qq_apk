package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.content.Context;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
          if (!Util.isNullOrNil(b.this)) {
            paramAnonymousAccessibilityNodeInfo.setContentDescription(b.this);
          }
          if ((!Util.isNullOrNil(this.sJC)) && (this.sJC.equalsIgnoreCase("button")))
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
  
  public static Boolean eT(Context paramContext)
  {
    AppMethodBeat.i(325941);
    paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
    if (paramContext == null)
    {
      Log.w("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
      AppMethodBeat.o(325941);
      return null;
    }
    if (!paramContext.isTouchExplorationEnabled())
    {
      Log.i("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
      paramContext = Boolean.FALSE;
      AppMethodBeat.o(325941);
      return paramContext;
    }
    paramContext = Boolean.TRUE;
    AppMethodBeat.o(325941);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.b
 * JD-Core Version:    0.7.0.1
 */