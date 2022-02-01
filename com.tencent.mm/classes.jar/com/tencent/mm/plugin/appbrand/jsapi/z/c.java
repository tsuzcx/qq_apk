package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends d
{
  private static final int CTRL_INDEX = 851;
  private static final String NAME = "checkIsOpenAccessibility";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(193704);
    paramJSONObject = (AccessibilityManager)paramf.getContext().getSystemService("accessibility");
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
      paramJSONObject = null;
    }
    while (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(193704);
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
    paramf.i(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(193704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c
 * JD-Core Version:    0.7.0.1
 */