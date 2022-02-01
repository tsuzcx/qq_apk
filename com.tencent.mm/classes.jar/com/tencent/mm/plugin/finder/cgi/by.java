package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class by
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  public static final a tvZ;
  private i callback;
  private d rr;
  private final boolean tvX;
  private final boolean tvY;
  private final String username;
  
  static
  {
    AppMethodBeat.i(242486);
    tvZ = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(242486);
  }
  
  private by(String paramString)
  {
    AppMethodBeat.i(242485);
    this.username = paramString;
    this.tvX = true;
    this.tvY = false;
    paramString = new d.a();
    paramString.sG(getType());
    Object localObject = new aon();
    ((aon)localObject).finderUsername = this.username;
    am localam = am.tuw;
    ((aon)localObject).LAI = am.cXY();
    if (this.tvY) {
      i = 3;
    }
    for (;;)
    {
      ((aon)localObject).dYx = i;
      paramString.c((a)localObject);
      localObject = new aoo();
      ((aoo)localObject).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject);
      paramString.MB("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.aXF();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, "NetSceneFinderOriginal init " + this.tvX);
      AppMethodBeat.o(242485);
      return;
      if (!this.tvX) {
        i = 2;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    Object localObject1 = null;
    AppMethodBeat.i(242484);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject2;
    ao localao;
    ar.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(242484);
        throw paramString;
      }
      params = (aoo)params;
      if (!this.tvY)
      {
        localObject2 = params.LAJ;
        if ((localObject2 != null) && (Util.isEqual(((FinderContact)localObject2).username, z.aUg())))
        {
          params = com.tencent.mm.kernel.g.aAh();
          p.g(params, "MMKernel.storage()");
          params.azQ().set(ar.a.OjP, Integer.valueOf(((FinderContact)localObject2).originalFlag));
          params = com.tencent.mm.kernel.g.aAh();
          p.g(params, "MMKernel.storage()");
          params.azQ().set(ar.a.OjU, Integer.valueOf(((FinderContact)localObject2).originalEntranceFlag));
          if (((FinderContact)localObject2).originalInfo != null)
          {
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            localao = params.azQ();
            locala = ar.a.OjQ;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label521;
            }
            params = Integer.valueOf(params.LJQ);
            localao.set(locala, params);
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            localao = params.azQ();
            locala = ar.a.OjR;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label527;
            }
            params = Integer.valueOf(params.LJR);
            label301:
            localao.set(locala, params);
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            localao = params.azQ();
            locala = ar.a.OjS;
            params = ((FinderContact)localObject2).originalInfo;
            if (params == null) {
              break label533;
            }
            params = Integer.valueOf(params.LJS);
            label356:
            localao.set(locala, params);
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            localao = params.azQ();
            locala = ar.a.OjT;
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
    for (params = Integer.valueOf(params.LJT);; params = null)
    {
      localao.set(locala, params);
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      localao = params.azQ();
      locala = ar.a.OjW;
      localObject2 = ((FinderContact)localObject2).originalInfo;
      params = localObject1;
      if (localObject2 != null) {
        params = Integer.valueOf(((bac)localObject2).LJU);
      }
      localao.set(locala, params);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242484);
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
    AppMethodBeat.i(242483);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242483);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.by
 * JD-Core Version:    0.7.0.1
 */