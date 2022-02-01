package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/CheckServerTrustedIssueFixerABTest;", "", "()V", "DEFAULT_IS_CHECK_SERVER_TRUSTED_ISSUE_FIXER_ENABLE", "", "isEnable", "()Z", "plugin-appbrand-integration_release"})
public final class m
{
  public static final m riE;
  
  static
  {
    AppMethodBeat.i(258244);
    riE = new m();
    AppMethodBeat.o(258244);
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(258242);
    b localb = (b)h.ae(b.class);
    if (localb != null) {}
    for (boolean bool = localb.a(b.a.vCk, true);; bool = true)
    {
      AppMethodBeat.o(258242);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.m
 * JD-Core Version:    0.7.0.1
 */