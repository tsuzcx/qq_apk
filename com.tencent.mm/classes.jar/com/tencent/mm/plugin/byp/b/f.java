package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.byp.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "print", "Companion", "plugin-byp_release"})
public final class f
  extends c<sw>
{
  public static final a pPI;
  private final sv pPG;
  private final c.b pPH;
  
  static
  {
    AppMethodBeat.i(199129);
    pPI = new a((byte)0);
    AppMethodBeat.o(199129);
  }
  
  public f(List<Integer> paramList, c.b paramb)
  {
    AppMethodBeat.i(199128);
    this.pPH = paramb;
    this.pPG = new sv();
    paramb = new d.a();
    this.pPG.LaF = new LinkedList((Collection)paramList);
    paramList = g.aAh();
    p.g(paramList, "MMKernel.storage()");
    paramList.azQ().get(ar.a.OkY, "");
    paramList = g.aAh();
    p.g(paramList, "MMKernel.storage()");
    paramList = paramList.azQ().get(ar.a.OkY, "");
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199128);
      throw paramList;
    }
    paramList = Util.decodeHexString((String)paramList);
    Object localObject = this.pPG;
    st localst = new st();
    localst.parseFrom(paramList);
    ((sv)localObject).LaN = localst;
    this.pPG.scene = this.pPH.value;
    paramb.c((a)this.pPG);
    localObject = new sw();
    ((sw)localObject).setBaseResponse(new BaseResponse());
    ((sw)localObject).getBaseResponse().ErrMsg = new dqi();
    paramb.d((a)localObject);
    paramb.MB("/cgi-bin/micromsg-bin/bypsync");
    paramb.sG(3673);
    c(paramb.aXF());
    Log.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.pPG.LaF + " scene=" + this.pPH.value + " size=" + paramList.length);
    AppMethodBeat.o(199128);
  }
  
  private static String a(st paramst)
  {
    AppMethodBeat.i(199127);
    p.h(paramst, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder();
    paramst = paramst.LaK;
    p.g(paramst, "sync_key_pair_list");
    paramst = ((Iterable)paramst).iterator();
    while (paramst.hasNext())
    {
      su localsu = (su)paramst.next();
      localStringBuilder.append(localsu.LaL).append("=").append(localsu.LaM).append(", ");
    }
    paramst = localStringBuilder.toString();
    p.g(paramst, "ss.toString()");
    AppMethodBeat.o(199127);
    return paramst;
  }
  
  private static boolean a(st paramst1, st paramst2)
  {
    AppMethodBeat.i(199126);
    Object localObject2 = new StringBuilder("[mergeSyncKey] req: ").append(a(paramst1)).append(" resp: ");
    Object localObject1;
    int i;
    boolean bool1;
    if (paramst2 != null)
    {
      localObject1 = a(paramst2);
      Log.i("Byp.CgiBypSync", (String)localObject1);
      if (paramst2 != null)
      {
        paramst2 = paramst2.LaK;
        if (paramst2 != null)
        {
          localObject1 = ((Iterable)paramst2).iterator();
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
        localObject2 = (su)((Iterator)localObject1).next();
        paramst2 = paramst1.LaK;
        p.g(paramst2, "req.sync_key_pair_list");
        Iterator localIterator = ((Iterable)paramst2).iterator();
        label136:
        if (localIterator.hasNext())
        {
          paramst2 = localIterator.next();
          if (((su)paramst2).LaL == ((su)localObject2).LaL)
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
          paramst2 = (su)paramst2;
          if (paramst2 == null) {
            break label314;
          }
          if (paramst2.LaM >= ((su)localObject2).LaM) {
            break label267;
          }
          paramst2.LaM = ((su)localObject2).LaM;
          Log.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + ((su)localObject2).LaL + '=' + ((su)localObject2).LaM);
          bool1 = true;
          break label85;
          localObject1 = null;
          break;
          j = 0;
          break label171;
          label260:
          break label136;
          paramst2 = null;
        }
        label267:
        Log.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + ((su)localObject2).LaM + ") is invalid, client value=" + paramst2.LaM + ' ');
        continue;
        label314:
        Log.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + ((su)localObject2).LaL + '=' + ((su)localObject2).LaM);
        paramst1.LaK.add(localObject2);
        i = 1;
      }
    }
    int j = 0;
    boolean bool2 = false;
    label373:
    if ((bool2) || (j != 0))
    {
      paramst2 = g.aAh();
      p.g(paramst2, "MMKernel.storage()");
      paramst2.azQ().set(ar.a.OkY, Util.encodeHexString(paramst1.toByteArray()));
    }
    AppMethodBeat.o(199126);
    return bool2;
  }
  
  public final com.tencent.mm.co.f<c.a<sw>> aYI()
  {
    AppMethodBeat.i(199124);
    h.CyF.n(1465L, this.pPH.value, 1L);
    com.tencent.mm.co.f localf = super.aYI();
    p.g(localf, "super.run()");
    AppMethodBeat.o(199124);
    return localf;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.f
 * JD-Core Version:    0.7.0.1
 */