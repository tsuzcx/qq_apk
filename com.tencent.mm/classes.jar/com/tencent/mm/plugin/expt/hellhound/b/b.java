package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.jh;
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
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"})
public final class b
  extends q
  implements m
{
  public static final a wpI;
  private i jQg;
  private final int scene;
  private final String wpG;
  private final String wpH;
  
  static
  {
    AppMethodBeat.i(255859);
    wpI = new a((byte)0);
    AppMethodBeat.o(255859);
  }
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(255858);
    this.scene = paramInt;
    this.wpG = paramString1;
    this.wpH = paramString2;
    AppMethodBeat.o(255858);
  }
  
  private static void Le(int paramInt)
  {
    AppMethodBeat.i(255855);
    int i = (int)Util.nowSecond();
    if (i > paramInt)
    {
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
      localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VCZ, Integer.valueOf(i));
      AppMethodBeat.o(255855);
      return;
    }
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VCZ, Integer.valueOf(paramInt));
    AppMethodBeat.o(255855);
  }
  
  private final void b(bvy parambvy)
  {
    cof localcof = null;
    AppMethodBeat.i(255852);
    if (parambvy == null)
    {
      AppMethodBeat.o(255852);
      return;
    }
    if (parambvy.getBaseResponse() == null)
    {
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell: baseResponse is NULL!!");
      parambvy = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
      l.a.HG(121L);
      AppMethodBeat.o(255852);
      return;
    }
    Object localObject1 = parambvy.getBaseResponse();
    if ((localObject1 == null) || (((jh)localObject1).CqV != 0))
    {
      Object localObject2 = new StringBuilder("updateHell, baseResp: [");
      localObject1 = parambvy.getBaseResponse();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((jh)localObject1).CqV);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append("] [");
        localObject2 = parambvy.getBaseResponse();
        parambvy = localcof;
        if (localObject2 != null) {
          parambvy = ((jh)localObject2).Tef;
        }
        Log.w("HABBYGE-MALI.NetSceneGetHell", parambvy + ']');
        parambvy = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
        l.a.HG(120L);
        AppMethodBeat.o(255852);
        return;
      }
    }
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp:\nreq.rversion=" + this.wpG + '\n' + "req.buildTag=" + this.wpH + '\n' + "currSvrSecond=" + parambvy.TfG + '\n' + "intervalSecond=" + parambvy.TfH + '\n' + "jsonPackages=" + parambvy.TfI.size());
    localObject1 = parambvy.TfI.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localcof = (cof)((Iterator)localObject1).next();
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp: jsonPackage=" + localcof.Twn.id);
    }
    int i = parambvy.TfG;
    int j = parambvy.TfH;
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime");
    Le(i);
    localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    ((f)localObject1).aHp().set(ar.a.VCY, Integer.valueOf(j));
    c.dcB().p(801, parambvy);
    AppMethodBeat.o(255852);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(255847);
    this.jQg = parami;
    parami = new d.a();
    parami.c((com.tencent.mm.cd.a)new bvx());
    parami.d((com.tencent.mm.cd.a)new bvy());
    parami.TW("/cgi-bin/mmfddataappsvr/getsessionconfig");
    parami.vD(1021);
    parami.vF(0);
    parami.vG(0);
    d locald = parami.bgN();
    p.j(locald, "rr");
    parami = locald.bhX();
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellRequest");
      AppMethodBeat.o(255847);
      throw paramg;
    }
    bvx localbvx = (bvx)parami;
    localbvx.scene = this.scene;
    parami = h.aHG();
    p.j(parami, "MMKernel.storage()");
    parami = parami.aHp().get(ar.a.VCZ, Integer.valueOf(0));
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(255847);
      throw paramg;
    }
    localbvx.TfE = ((Integer)parami).intValue();
    localbvx.version = com.tencent.mm.loader.j.a.CLIENT_VERSION;
    localbvx.wpG = this.wpG;
    localbvx.wpH = this.wpH;
    LinkedList localLinkedList = localbvx.TfF;
    p.j(localLinkedList, "req.localIdInfos");
    parami = com.tencent.mm.plugin.expt.hellhound.b.a.b.wpK;
    parami = com.tencent.mm.plugin.expt.hellhound.b.a.b.a.dfZ();
    if (parami == null) {}
    for (parami = null;; parami = null)
    {
      if (parami != null) {
        localLinkedList.addAll((Collection)parami);
      }
      Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: scene=" + localbvx.scene + '\n' + "lastGetSvrSecond=" + localbvx.TfE + '\n' + "version=" + localbvx.version + '\n' + "rversion=" + localbvx.wpG + '\n' + "buildTag=" + localbvx.wpH + '\n' + "localIds=" + localbvx.TfF.size());
      parami = localbvx.TfF.iterator();
      while (parami.hasNext())
      {
        localObject = (adl)parami.next();
        Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: localId=" + ((adl)localObject).id + ", " + ((adl)localObject).timestamp);
      }
      if (!parami.TfI.isEmpty()) {
        break;
      }
    }
    Object localObject = (List)new ArrayList();
    Iterator localIterator = parami.TfI.iterator();
    for (;;)
    {
      parami = (i)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      parami = ((cof)localIterator.next()).Twn;
      p.j(parami, "jsonPackage.idInfo");
      ((List)localObject).add(parami);
    }
    parami = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
    l.a.HG(119L);
    int i = dispatch(paramg, (s)locald, (m)this);
    AppMethodBeat.o(255847);
    return i;
  }
  
  public final int getType()
  {
    return 1021;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(255849);
    Log.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + paramInt2 + "] erroCode[" + paramInt3 + "] errMsg[" + paramString + ']');
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(255849);
        throw paramString;
      }
      params = ((d)params).bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
        AppMethodBeat.o(255849);
        throw paramString;
      }
      b((bvy)params);
    }
    for (;;)
    {
      params = this.jQg;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(255849);
      return;
      params = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
      l.a.HG(120L);
      Log.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
      Le((int)Util.nowSecond());
    }
    AppMethodBeat.o(255849);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.b
 * JD-Core Version:    0.7.0.1
 */