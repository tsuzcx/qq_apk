package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.byp.c.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "print", "Companion", "plugin-byp_release"})
public final class e
  extends com.tencent.mm.ak.a<rt>
{
  public static final a oBV;
  private final rs oBT;
  private final c.b oBU;
  
  static
  {
    AppMethodBeat.i(218349);
    oBV = new a((byte)0);
    AppMethodBeat.o(218349);
  }
  
  public e(List<Integer> paramList, c.b paramb)
  {
    AppMethodBeat.i(218348);
    this.oBU = paramb;
    this.oBT = new rs();
    paramb = new b.a();
    this.oBT.Ggc = new LinkedList((Collection)paramList);
    paramList = com.tencent.mm.kernel.g.ajR();
    p.g(paramList, "MMKernel.storage()");
    paramList.ajA().get(am.a.JbX, "");
    paramList = com.tencent.mm.kernel.g.ajR();
    p.g(paramList, "MMKernel.storage()");
    paramList = paramList.ajA().get(am.a.JbX, "");
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(218348);
      throw paramList;
    }
    paramList = bu.aSx((String)paramList);
    Object localObject = this.oBT;
    rq localrq = new rq();
    localrq.parseFrom(paramList);
    ((rs)localObject).Ggk = localrq;
    this.oBT.scene = this.oBU.value;
    paramb.c((com.tencent.mm.bw.a)this.oBT);
    localObject = new rt();
    ((rt)localObject).setBaseResponse(new BaseResponse());
    ((rt)localObject).getBaseResponse().ErrMsg = new cxn();
    paramb.d((com.tencent.mm.bw.a)localObject);
    paramb.DN("/cgi-bin/micromsg-bin/bypsync");
    paramb.oS(3673);
    c(paramb.aDS());
    ae.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.oBT.Ggc + " scene=" + this.oBU.value + " size=" + paramList.length);
    AppMethodBeat.o(218348);
  }
  
  private static String a(rq paramrq)
  {
    AppMethodBeat.i(218347);
    p.h(paramrq, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder();
    paramrq = paramrq.Ggh;
    p.g(paramrq, "sync_key_pair_list");
    paramrq = ((Iterable)paramrq).iterator();
    while (paramrq.hasNext())
    {
      rr localrr = (rr)paramrq.next();
      localStringBuilder.append(localrr.Ggi).append("=").append(localrr.Ggj).append(", ");
    }
    paramrq = localStringBuilder.toString();
    p.g(paramrq, "ss.toString()");
    AppMethodBeat.o(218347);
    return paramrq;
  }
  
  private static boolean a(rq paramrq1, rq paramrq2)
  {
    AppMethodBeat.i(218346);
    Object localObject2 = new StringBuilder("[mergeSyncKey] req: ").append(a(paramrq1)).append(" resp: ");
    Object localObject1;
    int i;
    boolean bool1;
    if (paramrq2 != null)
    {
      localObject1 = a(paramrq2);
      ae.i("Byp.CgiBypSync", (String)localObject1);
      if (paramrq2 != null)
      {
        paramrq2 = paramrq2.Ggh;
        if (paramrq2 != null)
        {
          localObject1 = ((Iterable)paramrq2).iterator();
          i = 0;
          bool1 = false;
        }
      }
    }
    else
    {
      for (;;)
      {
        label85:
        j = i;
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break label373;
        }
        localObject2 = (rr)((Iterator)localObject1).next();
        paramrq2 = paramrq1.Ggh;
        p.g(paramrq2, "req.sync_key_pair_list");
        Iterator localIterator = ((Iterable)paramrq2).iterator();
        label136:
        if (localIterator.hasNext())
        {
          paramrq2 = localIterator.next();
          if (((rr)paramrq2).Ggi == ((rr)localObject2).Ggi)
          {
            j = 1;
            label171:
            if (j == 0) {
              break label260;
            }
          }
        }
        for (;;)
        {
          paramrq2 = (rr)paramrq2;
          if (paramrq2 == null) {
            break label314;
          }
          if (paramrq2.Ggj >= ((rr)localObject2).Ggj) {
            break label267;
          }
          paramrq2.Ggj = ((rr)localObject2).Ggj;
          ae.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + ((rr)localObject2).Ggi + '=' + ((rr)localObject2).Ggj);
          bool1 = true;
          break label85;
          localObject1 = null;
          break;
          j = 0;
          break label171;
          label260:
          break label136;
          paramrq2 = null;
        }
        label267:
        ae.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + ((rr)localObject2).Ggj + ") is invalid, client value=" + paramrq2.Ggj + ' ');
        continue;
        label314:
        ae.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + ((rr)localObject2).Ggi + '=' + ((rr)localObject2).Ggj);
        paramrq1.Ggh.add(localObject2);
        i = 1;
      }
    }
    int j = 0;
    boolean bool2 = false;
    label373:
    if ((bool2) || (j != 0))
    {
      paramrq2 = com.tencent.mm.kernel.g.ajR();
      p.g(paramrq2, "MMKernel.storage()");
      paramrq2.ajA().set(am.a.JbX, bu.cH(paramrq1.toByteArray()));
    }
    AppMethodBeat.o(218346);
    return bool2;
  }
  
  public final f<a.a<rt>> aET()
  {
    AppMethodBeat.i(218344);
    com.tencent.mm.plugin.report.service.g.yxI.n(1465L, this.oBU.value, 1L);
    f localf = super.aET();
    p.g(localf, "super.run()");
    AppMethodBeat.o(218344);
    return localf;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.e
 * JD-Core Version:    0.7.0.1
 */