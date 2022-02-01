package com.tencent.mm.plugin.datapreloader.b;

import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/cgi/FutureCgi;", "_key", "_resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "()V", "cancelTask", "", "hitPreloadCache", "value", "runTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<_key, _resp extends esc>
  extends com.tencent.mm.am.b<_resp>
  implements com.tencent.mm.plugin.datapreloader.b<_key, com.tencent.mm.am.b.a<_resp>>
{
  public final Object Z(d<? super com.tencent.mm.am.b.a<_resp>> paramd)
  {
    Object localObject = new h(kotlin.d.a.b.au(paramd));
    d locald = (d)localObject;
    bFJ().g((com.tencent.mm.vending.c.a)new a(locald));
    localObject = ((h)localObject).kli();
    if (localObject == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "_key", "_resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    a(d<? super com.tencent.mm.am.b.a<_resp>> paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.b.b
 * JD-Core Version:    0.7.0.1
 */