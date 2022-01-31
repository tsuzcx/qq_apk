package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.i.e;

final class c$3
  implements e
{
  c$3(c paramc) {}
  
  public final void x(String paramString1, String paramString2)
  {
    u.i("MicroMsg.DynamicPageViewIPCProxy", "js error msg %s, stackTrace %s", new Object[] { paramString1, paramString2 });
    paramString1 = new Bundle();
    paramString1.putString("widgetId", this.fTM.dIX);
    paramString1.putString("action", "onWidgetJsError");
    paramString1.putString("data", paramString2);
    paramString2 = i.aeX().sX(this.fTM.dIX);
    if (paramString2 == null)
    {
      ToolsProcessIPCService.a(paramString1, c.b.class);
      return;
    }
    f.a(paramString2, paramString1, c.b.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.3
 * JD-Core Version:    0.7.0.1
 */