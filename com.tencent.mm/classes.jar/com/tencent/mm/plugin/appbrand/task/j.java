package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/IsolateProcessBootStepConfig;", "", "()V", "HARDCODE_OPEN", "", "beforePreload", "", "beforeStartApp", "touchConfigFileIfNeed", "plugin-appbrand-integration_release"})
public final class j
{
  private static final boolean mDJ;
  public static final j mDK;
  
  static
  {
    AppMethodBeat.i(51071);
    mDK = new j();
    if (!d.FFI) {}
    for (boolean bool = true;; bool = false)
    {
      mDJ = bool;
      AppMethodBeat.o(51071);
      return;
    }
  }
  
  public static final void bzH()
  {
    AppMethodBeat.i(51068);
    bzJ();
    AppMethodBeat.o(51068);
  }
  
  public static final void bzI()
  {
    AppMethodBeat.i(51069);
    bzJ();
    AppMethodBeat.o(51069);
  }
  
  private static void bzJ()
  {
    AppMethodBeat.i(51070);
    int i;
    if ((mDJ) || (((b)g.ab(b.class)).a(b.a.qBU, false)))
    {
      CharSequence localCharSequence = (CharSequence)a.jFJ;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      o.aZV(a.jFJ);
      AppMethodBeat.o(51070);
      return;
      i = 0;
      continue;
      o.deleteFile(a.jFJ);
    }
    AppMethodBeat.o(51070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.j
 * JD-Core Version:    0.7.0.1
 */