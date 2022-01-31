package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.ui.base.l;

public final class k
  extends a
{
  public k()
  {
    super(r.iqX.ordinal());
    AppMethodBeat.i(132214);
    AppMethodBeat.o(132214);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132215);
    if ((paramv.getRuntime() instanceof o))
    {
      paramContext = (o)paramv.getRuntime();
      if ((paramContext.vY()) && (paramContext.wV()))
      {
        if (t.azo())
        {
          paraml.e(this.irp, "Disable Preload");
          AppMethodBeat.o(132215);
          return;
        }
        paraml.e(this.irp, "Enable Preload");
      }
    }
    AppMethodBeat.o(132215);
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132216);
    if (t.azo())
    {
      t.dT(false);
      Toast.makeText(paramContext, "Disable success, please restart WeChat to take effect.", 1).show();
      AppMethodBeat.o(132216);
      return;
    }
    t.dT(true);
    Toast.makeText(paramContext, "Enable success, please restart WeChat to take effect.", 1).show();
    AppMethodBeat.o(132216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.k
 * JD-Core Version:    0.7.0.1
 */