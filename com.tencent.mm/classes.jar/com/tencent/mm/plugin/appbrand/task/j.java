package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.vfs.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/task/IsolateProcessBootStepConfig;", "", "()V", "HARDCODE_OPEN", "", "beforePreload", "", "beforeStartApp", "touchConfigFileIfNeed", "plugin-appbrand-integration_release"})
public final class j
{
  private static final boolean myK;
  public static final j myL;
  
  static
  {
    AppMethodBeat.i(51071);
    myL = new j();
    if (!d.Fnk) {}
    for (boolean bool = true;; bool = false)
    {
      myK = bool;
      AppMethodBeat.o(51071);
      return;
    }
  }
  
  public static final void byM()
  {
    AppMethodBeat.i(51068);
    byO();
    AppMethodBeat.o(51068);
  }
  
  public static final void byN()
  {
    AppMethodBeat.i(51069);
    byO();
    AppMethodBeat.o(51069);
  }
  
  private static void byO()
  {
    AppMethodBeat.i(51070);
    int i;
    if ((myK) || (((b)g.ab(b.class)).a(b.a.quW, false)))
    {
      CharSequence localCharSequence = (CharSequence)a.jCL;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      i.aYs(a.jCL);
      AppMethodBeat.o(51070);
      return;
      i = 0;
      continue;
      i.deleteFile(a.jCL);
    }
    AppMethodBeat.o(51070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.j
 * JD-Core Version:    0.7.0.1
 */