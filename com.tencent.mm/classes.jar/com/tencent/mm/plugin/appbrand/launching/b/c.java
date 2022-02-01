package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchPkgDownloadURLBatchRun;", "", "()V", "batchRun", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "requestList", "plugin-appbrand-integration_release"})
final class c
{
  public static final c lMn;
  
  static
  {
    AppMethodBeat.i(50790);
    lMn = new c();
    AppMethodBeat.o(50790);
  }
  
  public static e<List<Pair<blp, blq>>> bz(List<? extends blp> paramList)
  {
    AppMethodBeat.i(50789);
    p.h(paramList, "requestList");
    paramList = g.fSm().h((a)new a(paramList));
    p.g(paramList, "pipelineExt().`$logic` {…           null\n        }");
    paramList = (e)paramList;
    AppMethodBeat.o(50789);
    return paramList;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(List paramList) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b paramb, LinkedList paramLinkedList) {}
      
      public final void run()
      {
        AppMethodBeat.i(50787);
        this.kxS.G(new Object[] { this.lMp });
        AppMethodBeat.o(50787);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.c
 * JD-Core Version:    0.7.0.1
 */