package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.byp.c.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "print", "Companion", "plugin-byp_release"})
public final class e
  extends com.tencent.mm.al.a<rr>
{
  public static final a ovu;
  private final rq ovs;
  private final c.b ovt;
  
  static
  {
    AppMethodBeat.i(219233);
    ovu = new a((byte)0);
    AppMethodBeat.o(219233);
  }
  
  public e(List<Integer> paramList, c.b paramb)
  {
    AppMethodBeat.i(219232);
    this.ovt = paramb;
    this.ovs = new rq();
    paramb = new b.a();
    this.ovs.FND = new LinkedList((Collection)paramList);
    paramList = com.tencent.mm.kernel.g.ajC();
    p.g(paramList, "MMKernel.storage()");
    paramList.ajl().get(al.a.IHu, "");
    paramList = com.tencent.mm.kernel.g.ajC();
    p.g(paramList, "MMKernel.storage()");
    paramList = paramList.ajl().get(al.a.IHu, "");
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(219232);
      throw paramList;
    }
    paramList = bt.aRa((String)paramList);
    Object localObject = this.ovs;
    ro localro = new ro();
    localro.parseFrom(paramList);
    ((rq)localObject).FNL = localro;
    this.ovs.scene = this.ovt.value;
    paramb.c((com.tencent.mm.bx.a)this.ovs);
    localObject = new rr();
    ((rr)localObject).setBaseResponse(new BaseResponse());
    ((rr)localObject).getBaseResponse().ErrMsg = new cwt();
    paramb.d((com.tencent.mm.bx.a)localObject);
    paramb.Dl("/cgi-bin/micromsg-bin/bypsync");
    paramb.oP(3673);
    c(paramb.aDC());
    ad.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.ovs.FND + " scene=" + this.ovt.value + " size=" + paramList.length);
    AppMethodBeat.o(219232);
  }
  
  private static String a(ro paramro)
  {
    AppMethodBeat.i(219231);
    p.h(paramro, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder();
    paramro = paramro.FNI;
    p.g(paramro, "sync_key_pair_list");
    paramro = ((Iterable)paramro).iterator();
    while (paramro.hasNext())
    {
      rp localrp = (rp)paramro.next();
      localStringBuilder.append(localrp.FNJ).append("=").append(localrp.FNK).append(", ");
    }
    paramro = localStringBuilder.toString();
    p.g(paramro, "ss.toString()");
    AppMethodBeat.o(219231);
    return paramro;
  }
  
  private static boolean a(ro paramro1, ro paramro2)
  {
    AppMethodBeat.i(219230);
    Object localObject2 = new StringBuilder("[mergeSyncKey] req: ").append(a(paramro1)).append(" resp: ");
    Object localObject1;
    int i;
    boolean bool1;
    if (paramro2 != null)
    {
      localObject1 = a(paramro2);
      ad.i("Byp.CgiBypSync", (String)localObject1);
      if (paramro2 != null)
      {
        paramro2 = paramro2.FNI;
        if (paramro2 != null)
        {
          localObject1 = ((Iterable)paramro2).iterator();
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
        localObject2 = (rp)((Iterator)localObject1).next();
        paramro2 = paramro1.FNI;
        p.g(paramro2, "req.sync_key_pair_list");
        Iterator localIterator = ((Iterable)paramro2).iterator();
        label136:
        if (localIterator.hasNext())
        {
          paramro2 = localIterator.next();
          if (((rp)paramro2).FNJ == ((rp)localObject2).FNJ)
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
          paramro2 = (rp)paramro2;
          if (paramro2 == null) {
            break label314;
          }
          if (paramro2.FNK >= ((rp)localObject2).FNK) {
            break label267;
          }
          paramro2.FNK = ((rp)localObject2).FNK;
          ad.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + ((rp)localObject2).FNJ + '=' + ((rp)localObject2).FNK);
          bool1 = true;
          break label85;
          localObject1 = null;
          break;
          j = 0;
          break label171;
          label260:
          break label136;
          paramro2 = null;
        }
        label267:
        ad.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + ((rp)localObject2).FNK + ") is invalid, client value=" + paramro2.FNK + ' ');
        continue;
        label314:
        ad.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + ((rp)localObject2).FNJ + '=' + ((rp)localObject2).FNK);
        paramro1.FNI.add(localObject2);
        i = 1;
      }
    }
    int j = 0;
    boolean bool2 = false;
    label373:
    if ((bool2) || (j != 0))
    {
      paramro2 = com.tencent.mm.kernel.g.ajC();
      p.g(paramro2, "MMKernel.storage()");
      paramro2.ajl().set(al.a.IHu, bt.cE(paramro1.toByteArray()));
    }
    AppMethodBeat.o(219230);
    return bool2;
  }
  
  public final f<a.a<rr>> aED()
  {
    AppMethodBeat.i(219228);
    com.tencent.mm.plugin.report.service.g.yhR.n(1465L, this.ovt.value, 1L);
    f localf = super.aED();
    p.g(localf, "super.run()");
    AppMethodBeat.o(219228);
    return localf;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.e
 * JD-Core Version:    0.7.0.1
 */