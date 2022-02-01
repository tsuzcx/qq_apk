package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
public final class j$b
  implements c
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    int j = 1;
    AppMethodBeat.i(220962);
    if ((p.j(paramString2, "onFetchDone")) && (p.j(paramString3, "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V")) && (paramArrayOfObject != null))
    {
      int i;
      if (paramArrayOfObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label103;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramString1 = this.sFP.sFN.p(paramArrayOfObject);
          if ((paramString1 == null) || (paramString1.pullType != m.c.sGl.value))
          {
            k.sFY.a(paramString1);
            AppMethodBeat.o(220962);
            return;
            i = 0;
            break;
            label103:
            i = 0;
            continue;
          }
          k.sFY.cOF();
        }
      }
    }
    AppMethodBeat.o(220962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j.b
 * JD-Core Version:    0.7.0.1
 */