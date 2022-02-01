package com.tencent.mm.plugin.appbrand.ui.privacy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/AppBrandPrivacyABTests;", "", "()V", "TAG", "", "showEntryPoint", "", "getShowEntryPoint", "()Z", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a uiz;
  
  static
  {
    AppMethodBeat.i(322759);
    uiz = new a();
    AppMethodBeat.o(322759);
  }
  
  public static boolean cMr()
  {
    AppMethodBeat.i(322750);
    Object localObject = t.raH;
    boolean bool = t.bnM();
    localObject = (c)h.ax(c.class);
    if (localObject != null) {
      bool = ((c)localObject).a(c.a.yQA, bool);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandPrivacyABTests", s.X("showEntryPoint#get, ", Boolean.valueOf(bool)));
      AppMethodBeat.o(322750);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.a
 * JD-Core Version:    0.7.0.1
 */