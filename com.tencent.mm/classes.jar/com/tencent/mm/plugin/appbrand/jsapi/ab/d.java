package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 851;
  private static final String NAME = "checkIsOpenAccessibility";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(205805);
    paramJSONObject = (AccessibilityManager)parame.getContext().getSystemService("accessibility");
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
      paramJSONObject = null;
    }
    while (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(205805);
      return;
      paramJSONObject = paramJSONObject.getEnabledAccessibilityServiceList(1);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label104;
        }
        Log.i("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
        paramJSONObject = Boolean.FALSE;
        break;
      }
      label104:
      paramJSONObject = Boolean.TRUE;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("open", paramJSONObject);
    parame.j(paramInt, m("ok", localHashMap));
    AppMethodBeat.o(205805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.d
 * JD-Core Version:    0.7.0.1
 */