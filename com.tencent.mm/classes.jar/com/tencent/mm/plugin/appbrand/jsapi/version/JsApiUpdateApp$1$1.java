package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.l;

final class JsApiUpdateApp$1$1
  implements Runnable
{
  JsApiUpdateApp$1$1(JsApiUpdateApp.1 param1, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
  
  public final void run()
  {
    AppMethodBeat.i(131488);
    b localb = new b(this.ibw.hxC.getContext());
    localb.setCanceledOnTouchOutside(false);
    localb.setCancelable(false);
    Object localObject = this.ibw.hxC.getContext();
    int i;
    if (this.ibw.hxC.getRuntime().vY())
    {
      i = 2131296707;
      localb.setMessage(((Context)localObject).getString(i, new Object[] { this.ibw.hxC.getRuntime().atS().cqQ }));
      localObject = new JsApiUpdateApp.1.1.1(this);
      if (this.ibw.hxC.getRuntime().atR().hiX.gXe == 0) {
        break label175;
      }
      localb.a(2131296706, (DialogInterface.OnClickListener)localObject);
      localb.b(2131296704, new JsApiUpdateApp.1.1.2(this));
    }
    for (;;)
    {
      this.ibw.hxC.asX().b(localb);
      AppMethodBeat.o(131488);
      return;
      i = 2131296708;
      break;
      label175:
      localb.a(2131296705, (DialogInterface.OnClickListener)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1.1
 * JD-Core Version:    0.7.0.1
 */