package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.i.h;

final class c$3
  implements h
{
  c$3(c paramc) {}
  
  public final void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10662);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "js error msg %s, stackTrace %s", new Object[] { paramString1, paramString2 });
    paramString1 = new Bundle();
    paramString1.putString("widgetId", this.hno.equ);
    paramString1.putString("action", "onWidgetJsError");
    paramString1.putString("data", paramString2);
    paramString2 = i.azB().AY(this.hno.equ);
    if (paramString2 == null)
    {
      ToolsProcessIPCService.b(paramString1, c.b.class);
      AppMethodBeat.o(10662);
      return;
    }
    f.a(paramString2, paramString1, c.b.class, null);
    AppMethodBeat.o(10662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.3
 * JD-Core Version:    0.7.0.1
 */