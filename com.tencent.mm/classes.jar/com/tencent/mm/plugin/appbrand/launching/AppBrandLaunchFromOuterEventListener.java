package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.event.IListener;

public final class AppBrandLaunchFromOuterEventListener
  extends IListener<zp>
{
  public AppBrandLaunchFromOuterEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160600);
    this.__eventId = zp.class.getName().hashCode();
    AppMethodBeat.o(160600);
  }
  
  private static void X(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(320770);
    String str;
    if (paramInt == 1) {
      str = l.getMMString(ba.i.app_brand_debug_app_from_share_card_can_not_open, new Object[0]);
    }
    for (;;)
    {
      a.a(paramContext, str, l.getMMString(ba.i.app_tip, new Object[0]), l.getMMString(ba.i.app_ok, new Object[0]), "", null, null, null);
      AppMethodBeat.o(320770);
      return;
      if (paramInt == 2) {
        str = l.getMMString(ba.i.app_brand_not_beta_pkg, new Object[0]);
      } else {
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchFromOuterEventListener
 * JD-Core Version:    0.7.0.1
 */