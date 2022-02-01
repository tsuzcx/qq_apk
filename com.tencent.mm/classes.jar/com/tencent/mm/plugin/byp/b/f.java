package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.byp.c.b;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "print", "Companion", "plugin-byp_release"})
public final class f
  extends c<sp>
{
  public static final a sWJ;
  private final so sWH;
  private final c.b sWI;
  
  static
  {
    AppMethodBeat.i(213442);
    sWJ = new a((byte)0);
    AppMethodBeat.o(213442);
  }
  
  public f(List<Integer> paramList, c.b paramb)
  {
    AppMethodBeat.i(213441);
    this.sWI = paramb;
    this.sWH = new so();
    paramb = new d.a();
    Object localObject1 = this.sWH;
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      int i = ((Number)localObject3).intValue();
      a.a locala = a.a.sVT;
      if (a.a.cEY().contains(Integer.valueOf(i))) {
        paramList.add(localObject3);
      }
    }
    ((so)localObject1).SbO = new LinkedList((Collection)paramList);
    paramList = com.tencent.mm.kernel.h.aHG();
    p.j(paramList, "MMKernel.storage()");
    paramList.aHp().get(ar.a.VzT, "");
    paramList = com.tencent.mm.kernel.h.aHG();
    p.j(paramList, "MMKernel.storage()");
    paramList = paramList.aHp().get(ar.a.VzT, "");
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(213441);
      throw paramList;
    }
    paramList = Util.decodeHexString((String)paramList);
    localObject1 = this.sWH;
    localObject2 = new sm();
    ((sm)localObject2).parseFrom(paramList);
    ((so)localObject1).SbX = ((sm)localObject2);
    this.sWH.scene = this.sWI.value;
    paramb.c((a)this.sWH);
    localObject1 = new sp();
    ((sp)localObject1).setBaseResponse(new jh());
    ((sp)localObject1).getBaseResponse().Tef = new eaf();
    paramb.d((a)localObject1);
    paramb.TW("/cgi-bin/micromsg-bin/bypsync");
    paramb.vD(3673);
    c(paramb.bgN());
    Log.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.sWH.SbO + " scene=" + this.sWI.value + " size=" + paramList.length);
    AppMethodBeat.o(213441);
  }
  
  private static String a(sm paramsm)
  {
    AppMethodBeat.i(213439);
    p.k(paramsm, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder();
    paramsm = paramsm.SbU;
    p.j(paramsm, "sync_key_pair_list");
    paramsm = ((Iterable)paramsm).iterator();
    while (paramsm.hasNext())
    {
      sn localsn = (sn)paramsm.next();
      localStringBuilder.append(localsn.SbV).append("=").append(localsn.SbW).append(", ");
    }
    paramsm = localStringBuilder.toString();
    p.j(paramsm, "ss.toString()");
    AppMethodBeat.o(213439);
    return paramsm;
  }
  
  private static boolean a(sm paramsm1, sm paramsm2)
  {
    AppMethodBeat.i(213438);
    Object localObject2 = new StringBuilder("[mergeSyncKey] req: ").append(a(paramsm1)).append(" resp: ");
    Object localObject1;
    int i;
    boolean bool1;
    if (paramsm2 != null)
    {
      localObject1 = a(paramsm2);
      Log.i("Byp.CgiBypSync", (String)localObject1);
      if (paramsm2 != null)
      {
        paramsm2 = paramsm2.SbU;
        if (paramsm2 != null)
        {
          localObject1 = ((Iterable)paramsm2).iterator();
          i = 0;
          bool1 = false;
        }
      }
    }
    else
    {
      for (;;)
      {
        label86:
        j = i;
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break label377;
        }
        localObject2 = (sn)((Iterator)localObject1).next();
        paramsm2 = paramsm1.SbU;
        p.j(paramsm2, "req.sync_key_pair_list");
        Iterator localIterator = ((Iterable)paramsm2).iterator();
        label137:
        if (localIterator.hasNext())
        {
          paramsm2 = localIterator.next();
          if (((sn)paramsm2).SbV == ((sn)localObject2).SbV)
          {
            j = 1;
            label172:
            if (j == 0) {
              break label262;
            }
          }
        }
        for (;;)
        {
          paramsm2 = (sn)paramsm2;
          if (paramsm2 == null) {
            break label317;
          }
          if (paramsm2.SbW >= ((sn)localObject2).SbW) {
            break label269;
          }
          paramsm2.SbW = ((sn)localObject2).SbW;
          Log.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + ((sn)localObject2).SbV + '=' + ((sn)localObject2).SbW);
          bool1 = true;
          break label86;
          localObject1 = null;
          break;
          j = 0;
          break label172;
          label262:
          break label137;
          paramsm2 = null;
        }
        label269:
        Log.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + ((sn)localObject2).SbW + ") is invalid, client value=" + paramsm2.SbW + ' ');
        continue;
        label317:
        Log.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + ((sn)localObject2).SbV + '=' + ((sn)localObject2).SbW);
        paramsm1.SbU.add(localObject2);
        i = 1;
      }
    }
    int j = 0;
    boolean bool2 = false;
    label377:
    if ((bool2) || (j != 0))
    {
      paramsm2 = com.tencent.mm.kernel.h.aHG();
      p.j(paramsm2, "MMKernel.storage()");
      paramsm2.aHp().set(ar.a.VzT, Util.encodeHexString(paramsm1.toByteArray()));
    }
    AppMethodBeat.o(213438);
    return bool2;
  }
  
  public final com.tencent.mm.cw.f<c.a<sp>> bhW()
  {
    AppMethodBeat.i(213436);
    com.tencent.mm.plugin.report.service.h.IzE.p(1465L, this.sWI.value, 1L);
    com.tencent.mm.cw.f localf = super.bhW();
    p.j(localf, "super.run()");
    AppMethodBeat.o(213436);
    return localf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.f
 * JD-Core Version:    0.7.0.1
 */