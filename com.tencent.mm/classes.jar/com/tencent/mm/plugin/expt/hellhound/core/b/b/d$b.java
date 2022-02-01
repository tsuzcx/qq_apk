package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$MethodListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;)V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
final class d$b
  implements c
{
  public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    int j = 1;
    AppMethodBeat.i(184272);
    if (paramArrayOfObject != null)
    {
      int i;
      if (paramArrayOfObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label73;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramString1 = this.qjL;
          paramString2 = paramArrayOfObject[0];
          if (paramString2 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(184272);
            throw paramString1;
            i = 0;
            break;
            label73:
            i = 0;
            continue;
          }
          d.a(paramString1, ((Integer)paramString2).intValue());
        }
      }
    }
    AppMethodBeat.o(184272);
  }
  
  public final void f(String paramString, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d.b
 * JD-Core Version:    0.7.0.1
 */