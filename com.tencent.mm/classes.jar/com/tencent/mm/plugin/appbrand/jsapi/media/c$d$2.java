package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.a.j;
import a.l;
import android.content.Intent;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.vending.g.b;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
final class c$d$2
  implements e.a
{
  c$d$2(b paramb) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(143791);
    if ((paramIntent == null) || (paramInt == 0))
    {
      this.hEh.C(new Object[] { b.a.hQk });
      AppMethodBeat.o(143791);
      return;
    }
    paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (paramIntent == null)
    {
      this.hEh.C(new Object[] { new b.c("get null sight capture result") });
      AppMethodBeat.o(143791);
      return;
    }
    b localb = this.hEh;
    if (paramIntent.oFG) {}
    for (paramIntent = paramIntent.oFO;; paramIntent = paramIntent.oFI)
    {
      localb.C(new Object[] { new b.d(j.listOf(new File(paramIntent)), 2) });
      AppMethodBeat.o(143791);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.d.2
 * JD-Core Version:    0.7.0.1
 */