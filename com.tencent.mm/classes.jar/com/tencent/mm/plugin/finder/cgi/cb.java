package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cb
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  public static final a xdM;
  private i callback;
  private d rr;
  private final String username;
  private final boolean xdK;
  private final boolean xdL;
  
  static
  {
    AppMethodBeat.i(280328);
    xdM = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(280328);
  }
  
  private cb(String paramString)
  {
    AppMethodBeat.i(280327);
    this.username = paramString;
    this.xdK = true;
    this.xdL = false;
    paramString = new d.a();
    paramString.vD(getType());
    Object localObject = new apu();
    ((apu)localObject).finderUsername = this.username;
    ao localao = ao.xcj;
    ((apu)localObject).SDi = ao.dnO();
    if (this.xdL) {
      i = 3;
    }
    for (;;)
    {
      ((apu)localObject).fSo = i;
      paramString.c((a)localObject);
      localObject = new apv();
      ((apv)localObject).setBaseResponse(new jh());
      paramString.d((a)localObject);
      paramString.TW("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.bgN();
      p.j(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, "NetSceneFinderOriginal init " + this.xdK);
      AppMethodBeat.o(280327);
      return;
      if (!this.xdK) {
        i = 2;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    Object localObject1 = null;
    AppMethodBeat.i(280325);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject2;
    com.tencent.mm.storage.ao localao;
    ar.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(280325);
        throw paramString;
      }
      params = (apv)params;
      if (!this.xdL)
      {
        localObject2 = params.SDj;
        if ((localObject2 != null) && (Util.isEqual(((FinderContact)localObject2).username, z.bdh())))
        {
          params = h.aHG();
          p.j(params, "MMKernel.storage()");
          params.aHp().set(ar.a.Vyl, Integer.valueOf(((FinderContact)localObject2).originalFlag));
          params = h.aHG();
          p.j(params, "MMKernel.storage()");
          params.aHp().set(ar.a.Vyq, Integer.valueOf(((FinderContact)localObject2).originalEntranceFlag));
          if (((FinderContact)localObject2).originalInfo != null)
          {
            params = h.aHG();
            p.j(params, "MMKernel.storage()");
            localao = params.aHp();
            locala = ar.a.Vym;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label521;
            }
            params = Integer.valueOf(params.SRe);
            localao.set(locala, params);
            params = h.aHG();
            p.j(params, "MMKernel.storage()");
            localao = params.aHp();
            locala = ar.a.Vyn;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label527;
            }
            params = Integer.valueOf(params.SRf);
            label301:
            localao.set(locala, params);
            params = h.aHG();
            p.j(params, "MMKernel.storage()");
            localao = params.aHp();
            locala = ar.a.Vyo;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label533;
            }
            params = Integer.valueOf(params.SRg);
            label356:
            localao.set(locala, params);
            params = h.aHG();
            p.j(params, "MMKernel.storage()");
            localao = params.aHp();
            locala = ar.a.Vyp;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label539;
            }
          }
        }
      }
    }
    label521:
    label527:
    label533:
    label539:
    for (params = Integer.valueOf(params.SRh);; params = null)
    {
      localao.set(locala, params);
      params = h.aHG();
      p.j(params, "MMKernel.storage()");
      localao = params.aHp();
      locala = ar.a.Vys;
      localObject2 = ((FinderContact)localObject2).originalInfo;
      params = localObject1;
      if (localObject2 != null) {
        params = Integer.valueOf(((bgi)localObject2).SRi);
      }
      localao.set(locala, params);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(280325);
      return;
      params = null;
      break;
      params = null;
      break label301;
      params = null;
      break label356;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(280323);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(280323);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cb
 * JD-Core Version:    0.7.0.1
 */