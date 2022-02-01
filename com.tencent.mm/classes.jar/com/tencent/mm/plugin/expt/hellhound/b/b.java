package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"})
public final class b
  extends n
  implements k
{
  public static final a raa;
  private f gzH;
  private final String qZY;
  private final String qZZ;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(210993);
    raa = new a((byte)0);
    AppMethodBeat.o(210993);
  }
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210992);
    this.scene = paramInt;
    this.qZY = paramString1;
    this.qZZ = paramString2;
    AppMethodBeat.o(210992);
  }
  
  private static void Du(int paramInt)
  {
    AppMethodBeat.i(210991);
    int i = (int)bt.aQJ();
    if (i > paramInt)
    {
      ad.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
      locale = g.ajC();
      p.g(locale, "MMKernel.storage()");
      locale.ajl().set(al.a.IJz, Integer.valueOf(i));
      AppMethodBeat.o(210991);
      return;
    }
    ad.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IJz, Integer.valueOf(paramInt));
    AppMethodBeat.o(210991);
  }
  
  private final void b(bch parambch)
  {
    bru localbru = null;
    AppMethodBeat.i(210990);
    if (parambch == null)
    {
      AppMethodBeat.o(210990);
      return;
    }
    if (parambch.getBaseResponse() == null)
    {
      ad.i("HABBYGE-MALI.NetSceneGetHell", "updateHell: baseResponse is NULL!!");
      parambch = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
      l.a.vc(121L);
      AppMethodBeat.o(210990);
      return;
    }
    Object localObject1 = parambch.getBaseResponse();
    if ((localObject1 == null) || (((BaseResponse)localObject1).Ret != 0))
    {
      Object localObject2 = new StringBuilder("updateHell, baseResp: [");
      localObject1 = parambch.getBaseResponse();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((BaseResponse)localObject1).Ret);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append("] [");
        localObject2 = parambch.getBaseResponse();
        parambch = localbru;
        if (localObject2 != null) {
          parambch = ((BaseResponse)localObject2).ErrMsg;
        }
        ad.w("HABBYGE-MALI.NetSceneGetHell", parambch + ']');
        parambch = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
        l.a.vc(120L);
        AppMethodBeat.o(210990);
        return;
      }
    }
    ad.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp:\nreq.rversion=" + this.qZY + '\n' + "req.buildTag=" + this.qZZ + '\n' + "currSvrSecond=" + parambch.GyU + '\n' + "intervalSecond=" + parambch.GyV + '\n' + "jsonPackages=" + parambch.GyW.size());
    localObject1 = parambch.GyW.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localbru = (bru)((Iterator)localObject1).next();
      ad.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp: jsonPackage=" + localbru.GMK.id);
    }
    int i = parambch.GyU;
    int j = parambch.GyV;
    ad.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime");
    Du(i);
    localObject1 = g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IJy, Integer.valueOf(j));
    c.cnO().l(801, parambch);
    AppMethodBeat.o(210990);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(210988);
    this.gzH = paramf;
    paramf = new com.tencent.mm.al.b.a();
    paramf.c((com.tencent.mm.bx.a)new bcg());
    paramf.d((com.tencent.mm.bx.a)new bch());
    paramf.Dl("/cgi-bin/mmfddataappsvr/getsessionconfig");
    paramf.oP(1021);
    paramf.oR(0);
    paramf.oS(0);
    com.tencent.mm.al.b localb = paramf.aDC();
    p.g(localb, "rr");
    paramf = localb.aEE();
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellRequest");
      AppMethodBeat.o(210988);
      throw parame;
    }
    bcg localbcg = (bcg)paramf;
    localbcg.scene = this.scene;
    paramf = g.ajC();
    p.g(paramf, "MMKernel.storage()");
    paramf = paramf.ajl().get(al.a.IJz, Integer.valueOf(0));
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(210988);
      throw parame;
    }
    localbcg.GyS = ((Integer)paramf).intValue();
    localbcg.version = com.tencent.mm.loader.j.a.hgG;
    localbcg.qZY = this.qZY;
    localbcg.qZZ = this.qZZ;
    LinkedList localLinkedList = localbcg.GyT;
    p.g(localLinkedList, "req.localIdInfos");
    paramf = com.tencent.mm.plugin.expt.hellhound.b.a.b.rac;
    paramf = com.tencent.mm.plugin.expt.hellhound.b.a.b.a.cqT();
    if (paramf == null) {}
    for (paramf = null;; paramf = null)
    {
      if (paramf != null) {
        localLinkedList.addAll((Collection)paramf);
      }
      ad.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: scene=" + localbcg.scene + '\n' + "lastGetSvrSecond=" + localbcg.GyS + '\n' + "version=" + localbcg.version + '\n' + "rversion=" + localbcg.qZY + '\n' + "buildTag=" + localbcg.qZZ + '\n' + "localIds=" + localbcg.GyT.size());
      paramf = localbcg.GyT.iterator();
      while (paramf.hasNext())
      {
        localObject = (aaw)paramf.next();
        ad.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: localId=" + ((aaw)localObject).id + ", " + ((aaw)localObject).timestamp);
      }
      if (!paramf.GyW.isEmpty()) {
        break;
      }
    }
    Object localObject = (List)new ArrayList();
    Iterator localIterator = paramf.GyW.iterator();
    for (;;)
    {
      paramf = (f)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramf = ((bru)localIterator.next()).GMK;
      p.g(paramf, "jsonPackage.idInfo");
      ((List)localObject).add(paramf);
    }
    paramf = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
    l.a.vc(119L);
    int i = dispatch(parame, (q)localb, (k)this);
    AppMethodBeat.o(210988);
    return i;
  }
  
  public final int getType()
  {
    return 1021;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210989);
    ad.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + paramInt2 + "] erroCode[" + paramInt3 + "] errMsg[" + paramString + ']');
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(210989);
        throw paramString;
      }
      paramq = ((com.tencent.mm.al.b)paramq).aEF();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
        AppMethodBeat.o(210989);
        throw paramString;
      }
      b((bch)paramq);
    }
    for (;;)
    {
      paramq = this.gzH;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(210989);
      return;
      paramq = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
      l.a.vc(120L);
      ad.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
      Du((int)bt.aQJ());
    }
    AppMethodBeat.o(210989);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.b
 * JD-Core Version:    0.7.0.1
 */