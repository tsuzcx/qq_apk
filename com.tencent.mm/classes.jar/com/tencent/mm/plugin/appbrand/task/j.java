package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.vfs.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/task/IsolateProcessBootStepConfig;", "", "()V", "HARDCODE_OPEN", "", "beforePreload", "", "beforeStartApp", "touchConfigFileIfNeed", "plugin-appbrand-integration_release"})
public final class j
{
  private static final boolean lxa;
  public static final j lxb;
  
  static
  {
    AppMethodBeat.i(51071);
    lxb = new j();
    if (!d.CpL) {}
    for (boolean bool = true;; bool = false)
    {
      lxa = bool;
      AppMethodBeat.o(51071);
      return;
    }
  }
  
  public static final void bnM()
  {
    AppMethodBeat.i(51068);
    bnO();
    AppMethodBeat.o(51068);
  }
  
  public static final void bnN()
  {
    AppMethodBeat.i(51069);
    bnO();
    AppMethodBeat.o(51069);
  }
  
  private static void bnO()
  {
    AppMethodBeat.i(51070);
    int i;
    if ((lxa) || (((b)g.ab(b.class)).a(b.a.pnf, false)))
    {
      CharSequence localCharSequence = (CharSequence)a.iIZ;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      i.aMR(a.iIZ);
      AppMethodBeat.o(51070);
      return;
      i = 0;
      continue;
      i.deleteFile(a.iIZ);
    }
    AppMethodBeat.o(51070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.j
 * JD-Core Version:    0.7.0.1
 */