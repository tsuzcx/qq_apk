package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  private static final int CTRL_INDEX = 851;
  private static final String NAME = "checkIsOpenAccessibility";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(197255);
    paramJSONObject = (AccessibilityManager)paramc.getContext().getSystemService("accessibility");
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
      paramJSONObject = null;
    }
    while (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(197255);
      return;
      paramJSONObject = paramJSONObject.getEnabledAccessibilityServiceList(1);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label104;
        }
        ae.i("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
        paramJSONObject = Boolean.FALSE;
        break;
      }
      label104:
      paramJSONObject = Boolean.TRUE;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("open", paramJSONObject);
    paramc.h(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(197255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c
 * JD-Core Version:    0.7.0.1
 */