package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"})
public final class b
  extends n
  implements k
{
  public static final a rig;
  private f gCo;
  private final String rie;
  private final String rif;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(196664);
    rig = new a((byte)0);
    AppMethodBeat.o(196664);
  }
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196663);
    this.scene = paramInt;
    this.rie = paramString1;
    this.rif = paramString2;
    AppMethodBeat.o(196663);
  }
  
  private static void DH(int paramInt)
  {
    AppMethodBeat.i(196662);
    int i = (int)bu.aRi();
    if (i > paramInt)
    {
      ae.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
      locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.Jef, Integer.valueOf(i));
      AppMethodBeat.o(196662);
      return;
    }
    ae.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jef, Integer.valueOf(paramInt));
    AppMethodBeat.o(196662);
  }
  
  private final void b(bcx parambcx)
  {
    bso localbso = null;
    AppMethodBeat.i(196661);
    if (parambcx == null)
    {
      AppMethodBeat.o(196661);
      return;
    }
    if (parambcx.getBaseResponse() == null)
    {
      ae.i("HABBYGE-MALI.NetSceneGetHell", "updateHell: baseResponse is NULL!!");
      parambcx = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
      l.a.tn(121L);
      AppMethodBeat.o(196661);
      return;
    }
    Object localObject1 = parambcx.getBaseResponse();
    if ((localObject1 == null) || (((BaseResponse)localObject1).Ret != 0))
    {
      Object localObject2 = new StringBuilder("updateHell, baseResp: [");
      localObject1 = parambcx.getBaseResponse();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((BaseResponse)localObject1).Ret);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append("] [");
        localObject2 = parambcx.getBaseResponse();
        parambcx = localbso;
        if (localObject2 != null) {
          parambcx = ((BaseResponse)localObject2).ErrMsg;
        }
        ae.w("HABBYGE-MALI.NetSceneGetHell", parambcx + ']');
        parambcx = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
        l.a.tn(120L);
        AppMethodBeat.o(196661);
        return;
      }
    }
    ae.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp:\nreq.rversion=" + this.rie + '\n' + "req.buildTag=" + this.rif + '\n' + "currSvrSecond=" + parambcx.GSu + '\n' + "intervalSecond=" + parambcx.GSv + '\n' + "jsonPackages=" + parambcx.GSw.size());
    localObject1 = parambcx.GSw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localbso = (bso)((Iterator)localObject1).next();
      ae.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp: jsonPackage=" + localbso.Hgl.id);
    }
    int i = parambcx.GSu;
    int j = parambcx.GSv;
    ae.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime");
    DH(i);
    localObject1 = g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.Jee, Integer.valueOf(j));
    c.cpq().l(801, parambcx);
    AppMethodBeat.o(196661);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(196659);
    this.gCo = paramf;
    paramf = new com.tencent.mm.ak.b.a();
    paramf.c((com.tencent.mm.bw.a)new bcw());
    paramf.d((com.tencent.mm.bw.a)new bcx());
    paramf.DN("/cgi-bin/mmfddataappsvr/getsessionconfig");
    paramf.oS(1021);
    paramf.oU(0);
    paramf.oV(0);
    com.tencent.mm.ak.b localb = paramf.aDS();
    p.g(localb, "rr");
    paramf = localb.aEU();
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellRequest");
      AppMethodBeat.o(196659);
      throw parame;
    }
    bcw localbcw = (bcw)paramf;
    localbcw.scene = this.scene;
    paramf = g.ajR();
    p.g(paramf, "MMKernel.storage()");
    paramf = paramf.ajA().get(am.a.Jef, Integer.valueOf(0));
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(196659);
      throw parame;
    }
    localbcw.GSs = ((Integer)paramf).intValue();
    localbcw.version = com.tencent.mm.loader.j.a.hju;
    localbcw.rie = this.rie;
    localbcw.rif = this.rif;
    LinkedList localLinkedList = localbcw.GSt;
    p.g(localLinkedList, "req.localIdInfos");
    paramf = com.tencent.mm.plugin.expt.hellhound.b.a.b.rii;
    paramf = com.tencent.mm.plugin.expt.hellhound.b.a.b.a.csv();
    if (paramf == null) {}
    for (paramf = null;; paramf = null)
    {
      if (paramf != null) {
        localLinkedList.addAll((Collection)paramf);
      }
      ae.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: scene=" + localbcw.scene + '\n' + "lastGetSvrSecond=" + localbcw.GSs + '\n' + "version=" + localbcw.version + '\n' + "rversion=" + localbcw.rie + '\n' + "buildTag=" + localbcw.rif + '\n' + "localIds=" + localbcw.GSt.size());
      paramf = localbcw.GSt.iterator();
      while (paramf.hasNext())
      {
        localObject = (abf)paramf.next();
        ae.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: localId=" + ((abf)localObject).id + ", " + ((abf)localObject).timestamp);
      }
      if (!paramf.GSw.isEmpty()) {
        break;
      }
    }
    Object localObject = (List)new ArrayList();
    Iterator localIterator = paramf.GSw.iterator();
    for (;;)
    {
      paramf = (f)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramf = ((bso)localIterator.next()).Hgl;
      p.g(paramf, "jsonPackage.idInfo");
      ((List)localObject).add(paramf);
    }
    paramf = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
    l.a.tn(119L);
    int i = dispatch(parame, (q)localb, (k)this);
    AppMethodBeat.o(196659);
    return i;
  }
  
  public final int getType()
  {
    return 1021;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196660);
    ae.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + paramInt2 + "] erroCode[" + paramInt3 + "] errMsg[" + paramString + ']');
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(196660);
        throw paramString;
      }
      paramq = ((com.tencent.mm.ak.b)paramq).aEV();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
        AppMethodBeat.o(196660);
        throw paramString;
      }
      b((bcx)paramq);
    }
    for (;;)
    {
      paramq = this.gCo;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(196660);
      return;
      paramq = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
      l.a.tn(120L);
      ae.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
      DH((int)bu.aRi());
    }
    AppMethodBeat.o(196660);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.b
 * JD-Core Version:    0.7.0.1
 */