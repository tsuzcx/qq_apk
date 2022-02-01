package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchPkgDownloadURLBatchRun;", "", "()V", "batchRun", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "requestList", "plugin-appbrand-integration_release"})
final class c
{
  public static final c loV;
  
  static
  {
    AppMethodBeat.i(50790);
    loV = new c();
    AppMethodBeat.o(50790);
  }
  
  public static e<List<Pair<bhh, bhi>>> bx(List<? extends bhh> paramList)
  {
    AppMethodBeat.i(50789);
    k.h(paramList, "requestList");
    paramList = g.fBc().h((a)new a(paramList));
    k.g(paramList, "pipelineExt().`$logic` {…           null\n        }");
    paramList = (e)paramList;
    AppMethodBeat.o(50789);
    return paramList;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(List paramList) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b paramb, LinkedList paramLinkedList) {}
      
      public final void run()
      {
        AppMethodBeat.i(50787);
        this.kdr.F(new Object[] { this.loX });
        AppMethodBeat.o(50787);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.c
 * JD-Core Version:    0.7.0.1
 */