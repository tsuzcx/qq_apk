package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class d$6$1
  implements i.d
{
  d$6$1(d.6 param6) {}
  
  public final void a(int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(156382);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156382);
      return;
      d.a(this.iBF.iBv, this.iBF.iBx, 1);
      d.aKs().put(d.a(this.iBF.iBv), d.b(this.iBF.iBv));
      ab.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", new Object[] { d.a(this.iBF.iBv), d.b(this.iBF.iBv) });
      d.c(this.iBF.iBv).aID();
      AppMethodBeat.o(156382);
      return;
      d.a(this.iBF.iBv, this.iBF.iBx, 2);
      d.aKs().N(d.a(this.iBF.iBv), d.b(this.iBF.iBv));
      ab.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", new Object[] { d.a(this.iBF.iBv), d.b(this.iBF.iBv) });
      d.c(this.iBF.iBv).Ec(null);
      AppMethodBeat.o(156382);
      return;
      d.aKs().N(d.a(this.iBF.iBv), d.b(this.iBF.iBv));
      ab.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", new Object[] { d.a(this.iBF.iBv), d.b(this.iBF.iBv) });
      d.c(this.iBF.iBv).onCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.6.1
 * JD-Core Version:    0.7.0.1
 */