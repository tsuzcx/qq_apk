package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/flow/FlowNetScene;", "", "()V", "Companion", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a ovw;
  
  static
  {
    AppMethodBeat.i(236804);
    ovw = new a((byte)0);
    AppMethodBeat.o(236804);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/flow/FlowNetScene$Companion;", "", "()V", "TAG", "", "doScene", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/modelbase/flow/FlowEvent;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T extends esc> g<a<T>> e(com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(236805);
      kotlin.g.b.s.u(paramc, "reqResp");
      Log.i("MicroMsg.Mvvm.FlowNetScene", "doScene, " + paramc.getType() + ' ' + paramc.getUri());
      final q localq = new q();
      com.tencent.threadpool.h.ahAA.g((Runnable)new a(paramc, localq), kotlin.g.b.s.X("FlowNetScene:", Integer.valueOf(paramc.getType())));
      paramc = k.a((f)localq);
      AppMethodBeat.o(236805);
      return paramc;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/modelbase/flow/FlowNetScene$Companion$doScene$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.threadpool.i.h
    {
      a(com.tencent.mm.am.c paramc, q<a<T>> paramq) {}
      
      public final String getKey()
      {
        AppMethodBeat.i(236812);
        String str = kotlin.g.b.s.X("FlowNetScene:", Integer.valueOf(this.lxN.getType()));
        AppMethodBeat.o(236812);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(236807);
        new c(this.lxN, localq).doScene(com.tencent.mm.kernel.h.aZW().oun, null);
        AppMethodBeat.o(236807);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.b
 * JD-Core Version:    0.7.0.1
 */