package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cfi;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"})
public final class b
  extends q
  implements m
{
  public static final a sJK;
  private i heq;
  private final String sJI;
  private final String sJJ;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(221163);
    sJK = new a((byte)0);
    AppMethodBeat.o(221163);
  }
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(221162);
    this.scene = paramInt;
    this.sJI = paramString1;
    this.sJJ = paramString2;
    AppMethodBeat.o(221162);
  }
  
  private static void Hu(int paramInt)
  {
    AppMethodBeat.i(221161);
    int i = (int)Util.nowSecond();
    if (i > paramInt)
    {
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
      locale = com.tencent.mm.kernel.g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OnL, Integer.valueOf(i));
      AppMethodBeat.o(221161);
      return;
    }
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OnL, Integer.valueOf(paramInt));
    AppMethodBeat.o(221161);
  }
  
  private final void b(boj paramboj)
  {
    cfi localcfi = null;
    AppMethodBeat.i(221160);
    if (paramboj == null)
    {
      AppMethodBeat.o(221160);
      return;
    }
    if (paramboj.getBaseResponse() == null)
    {
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell: baseResponse is NULL!!");
      paramboj = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
      l.a.Bt(121L);
      AppMethodBeat.o(221160);
      return;
    }
    Object localObject1 = paramboj.getBaseResponse();
    if ((localObject1 == null) || (((BaseResponse)localObject1).Ret != 0))
    {
      Object localObject2 = new StringBuilder("updateHell, baseResp: [");
      localObject1 = paramboj.getBaseResponse();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((BaseResponse)localObject1).Ret);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append("] [");
        localObject2 = paramboj.getBaseResponse();
        paramboj = localcfi;
        if (localObject2 != null) {
          paramboj = ((BaseResponse)localObject2).ErrMsg;
        }
        Log.w("HABBYGE-MALI.NetSceneGetHell", paramboj + ']');
        paramboj = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
        l.a.Bt(120L);
        AppMethodBeat.o(221160);
        return;
      }
    }
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp:\nreq.rversion=" + this.sJI + '\n' + "req.buildTag=" + this.sJJ + '\n' + "currSvrSecond=" + paramboj.LWz + '\n' + "intervalSecond=" + paramboj.LWA + '\n' + "jsonPackages=" + paramboj.LWB.size());
    localObject1 = paramboj.LWB.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localcfi = (cfi)((Iterator)localObject1).next();
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp: jsonPackage=" + localcfi.Mlu.id);
    }
    int i = paramboj.LWz;
    int j = paramboj.LWA;
    Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime");
    Hu(i);
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    ((e)localObject1).azQ().set(ar.a.OnK, Integer.valueOf(j));
    c.cNJ().m(801, paramboj);
    AppMethodBeat.o(221160);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(221158);
    this.heq = parami;
    parami = new d.a();
    parami.c((com.tencent.mm.bw.a)new boi());
    parami.d((com.tencent.mm.bw.a)new boj());
    parami.MB("/cgi-bin/mmfddataappsvr/getsessionconfig");
    parami.sG(1021);
    parami.sI(0);
    parami.sJ(0);
    d locald = parami.aXF();
    p.g(locald, "rr");
    parami = locald.aYJ();
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellRequest");
      AppMethodBeat.o(221158);
      throw paramg;
    }
    boi localboi = (boi)parami;
    localboi.scene = this.scene;
    parami = com.tencent.mm.kernel.g.aAh();
    p.g(parami, "MMKernel.storage()");
    parami = parami.azQ().get(ar.a.OnL, Integer.valueOf(0));
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(221158);
      throw paramg;
    }
    localboi.LWx = ((Integer)parami).intValue();
    localboi.version = com.tencent.mm.loader.j.a.CLIENT_VERSION;
    localboi.sJI = this.sJI;
    localboi.sJJ = this.sJJ;
    LinkedList localLinkedList = localboi.LWy;
    p.g(localLinkedList, "req.localIdInfos");
    parami = com.tencent.mm.plugin.expt.hellhound.b.a.b.sJM;
    parami = com.tencent.mm.plugin.expt.hellhound.b.a.b.a.cRe();
    if (parami == null) {}
    for (parami = null;; parami = null)
    {
      if (parami != null) {
        localLinkedList.addAll((Collection)parami);
      }
      Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: scene=" + localboi.scene + '\n' + "lastGetSvrSecond=" + localboi.LWx + '\n' + "version=" + localboi.version + '\n' + "rversion=" + localboi.sJI + '\n' + "buildTag=" + localboi.sJJ + '\n' + "localIds=" + localboi.LWy.size());
      parami = localboi.LWy.iterator();
      while (parami.hasNext())
      {
        localObject = (ade)parami.next();
        Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: localId=" + ((ade)localObject).id + ", " + ((ade)localObject).timestamp);
      }
      if (!parami.LWB.isEmpty()) {
        break;
      }
    }
    Object localObject = (List)new ArrayList();
    Iterator localIterator = parami.LWB.iterator();
    for (;;)
    {
      parami = (i)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      parami = ((cfi)localIterator.next()).Mlu;
      p.g(parami, "jsonPackage.idInfo");
      ((List)localObject).add(parami);
    }
    parami = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
    l.a.Bt(119L);
    int i = dispatch(paramg, (s)locald, (m)this);
    AppMethodBeat.o(221158);
    return i;
  }
  
  public final int getType()
  {
    return 1021;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221159);
    Log.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + paramInt2 + "] erroCode[" + paramInt3 + "] errMsg[" + paramString + ']');
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(221159);
        throw paramString;
      }
      params = ((d)params).aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
        AppMethodBeat.o(221159);
        throw paramString;
      }
      b((boj)params);
    }
    for (;;)
    {
      params = this.heq;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(221159);
      return;
      params = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
      l.a.Bt(120L);
      Log.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
      Hu((int)Util.nowSecond());
    }
    AppMethodBeat.o(221159);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.b
 * JD-Core Version:    0.7.0.1
 */