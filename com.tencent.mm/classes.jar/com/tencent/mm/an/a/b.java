package com.tencent.mm.an.a;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.t;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.b.e;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/flow/FlowNetScene;", "", "()V", "Companion", "mmkernel_release"})
public final class b
{
  public static final a lDL;
  
  static
  {
    AppMethodBeat.i(202729);
    lDL = new a((byte)0);
    AppMethodBeat.o(202729);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/flow/FlowNetScene$Companion;", "", "()V", "TAG", "", "doScene", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/modelbase/flow/FlowEvent;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "mmkernel_release"})
  public static final class a
  {
    public static <T extends dyy> kotlinx.coroutines.b.b<a<T>> f(d paramd)
    {
      AppMethodBeat.i(193801);
      p.k(paramd, "reqResp");
      Log.i("MicroMsg.Mvvm.FlowNetScene", "doScene, " + paramd.getType() + ' ' + paramd.getUri());
      final n localn = new n();
      com.tencent.e.h.ZvG.be((Runnable)new a(paramd, localn));
      paramd = e.a((f)localn);
      AppMethodBeat.o(193801);
      return paramd;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/modelbase/flow/FlowNetScene$Companion$doScene$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "mmkernel_release"})
    public static final class a
      implements com.tencent.e.i.h
    {
      a(d paramd, n paramn) {}
      
      public final String getKey()
      {
        AppMethodBeat.i(199471);
        String str = "FlowNetScene:" + this.iVL.getType();
        AppMethodBeat.o(199471);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(199469);
        c localc = new c(this.iVL, localn);
        t localt = com.tencent.mm.kernel.h.aGY();
        p.j(localt, "MMKernel.getNetSceneQueue()");
        localc.doScene(localt.aHc(), null);
        AppMethodBeat.o(199469);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.an.a.b
 * JD-Core Version:    0.7.0.1
 */