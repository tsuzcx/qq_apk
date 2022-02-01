package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchPkgDownloadURLBatchRun;", "", "()V", "batchRun", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "requestList", "plugin-appbrand-integration_release"})
final class c
{
  public static final c kNw;
  
  static
  {
    AppMethodBeat.i(50790);
    kNw = new c();
    AppMethodBeat.o(50790);
  }
  
  public static e<List<Pair<bdp, bdq>>> bx(List<? extends bdp> paramList)
  {
    AppMethodBeat.i(50789);
    k.h(paramList, "requestList");
    paramList = g.fkM().h((a)new a(paramList));
    k.g(paramList, "pipelineExt().`$logic` {…           null\n        }");
    paramList = (e)paramList;
    AppMethodBeat.o(50789);
    return paramList;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(List paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.c
 * JD-Core Version:    0.7.0.1
 */