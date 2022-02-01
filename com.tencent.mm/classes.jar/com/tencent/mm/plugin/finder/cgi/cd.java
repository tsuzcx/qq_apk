package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cd
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d tvD;
  public boolean twh;
  
  public cd(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    d.a locala = new d.a();
    bec localbec = new bec();
    localbec.scene = paramInt;
    am localam = am.tuw;
    localbec.uli = am.cXY();
    locala.c((a)localbec);
    locala.d((a)new bed());
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/finderuserprepare");
    this.tvD = locala.aXF();
    AppMethodBeat.o(165263);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242499);
    Object localObject1;
    Object localObject2;
    label101:
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("userFlag=").append(cZc().LNK).append(" username=");
      params = cZc().LAJ;
      if (params == null) {
        break label1218;
      }
      params = params.username;
      localObject2 = ((StringBuilder)localObject2).append(params).append(" nickname=");
      params = cZc().LAJ;
      if (params == null) {
        break label1224;
      }
      params = params.nickname;
      Log.i((String)localObject1, params);
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      params.azQ().set(ar.a.Okh, Integer.valueOf(cZc().LNK));
      localObject1 = cZc().LAJ;
      if (localObject1 != null)
      {
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjG, ((FinderContact)localObject1).username);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjH, ((FinderContact)localObject1).nickname);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjI, ((FinderContact)localObject1).signature);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjJ, ((FinderContact)localObject1).headUrl);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjL, ((FinderContact)localObject1).coverImgUrl);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Okw, Integer.valueOf(((FinderContact)localObject1).extFlag));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjP, Integer.valueOf(((FinderContact)localObject1).originalFlag));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjU, Integer.valueOf(((FinderContact)localObject1).originalEntranceFlag));
        params = ((FinderContact)localObject1).originalInfo;
        if (params != null)
        {
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjQ, Integer.valueOf(params.LJQ));
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjR, Integer.valueOf(params.LJR));
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjS, Integer.valueOf(params.LJS));
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjT, Integer.valueOf(params.LJT));
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjW, Integer.valueOf(params.LJU));
        }
        params = c.tsp;
        p.g(localObject1, "it");
        c.a.a((FinderContact)localObject1);
        if (((FinderContact)localObject1).authInfo != null) {
          break label1230;
        }
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.OjK, "");
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Okk, ((FinderContact)localObject1).liveCoverImgUrl);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        localObject2 = params.azQ();
        localObject3 = ar.a.Okl;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label1294;
        }
        params = Long.valueOf(params.LBA);
        label690:
        ((ao)localObject2).set((ar.a)localObject3, params);
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        localObject2 = params.azQ();
        localObject3 = ar.a.Okm;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label1303;
        }
        params = Long.valueOf(params.LBB);
        label746:
        ((ao)localObject2).set((ar.a)localObject3, params);
      }
      params = cZc().LNM;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.OjX, params);
      }
      params = cZc().LNN;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.OjY, params);
      }
      params = cZc().LNT;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.OjZ, params.appId);
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.Oka, params.LOg);
      }
      params = cZc().wxaShopInfo;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.Okb, params.appId);
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.Okc, params.LOg);
      }
      paramInt1 = cZc().LNW;
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      params.azQ().set(ar.a.Okd, Integer.valueOf(paramInt1));
      paramInt1 = cZc().vIE;
      if (paramInt1 > 0)
      {
        Log.i(this.TAG, "nicknameMaxLength ： ".concat(String.valueOf(paramInt1)));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Okg, Integer.valueOf(paramInt1));
      }
      if (cZc().LNZ != null) {
        break label1312;
      }
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      params.azQ().set(ar.a.Oni, "");
      params = r.vWn;
      r.a(cZc().LNV);
      params = (CharSequence)cZc().LNY;
      if ((params != null) && (params.length() != 0)) {
        break label1378;
      }
      paramInt1 = 1;
      label1144:
      if (paramInt1 == 0) {
        break label1383;
      }
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      localObject1 = params.azQ();
      localObject2 = ar.a.Ong;
      params = "";
    }
    for (;;)
    {
      ((ao)localObject1).set((ar.a)localObject2, params);
      params = this.callback;
      if (params == null) {
        break label1449;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242499);
      return;
      label1218:
      params = null;
      break;
      label1224:
      params = null;
      break label101;
      label1230:
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      localObject2 = params.azQ();
      localObject3 = ar.a.OjK;
      params = ((FinderContact)localObject1).authInfo;
      if (params != null) {}
      for (params = params.toByteArray();; params = null)
      {
        ((ao)localObject2).set((ar.a)localObject3, Util.encodeHexString(params));
        break;
      }
      label1294:
      params = Long.valueOf(0L);
      break label690;
      label1303:
      params = Long.valueOf(0L);
      break label746;
      label1312:
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      localObject1 = params.azQ();
      localObject2 = ar.a.Oni;
      params = cZc().LNZ;
      if (params != null) {}
      for (params = params.toByteArray();; params = null)
      {
        ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(params));
        break;
      }
      label1378:
      paramInt1 = 0;
      break label1144;
      label1383:
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      localObject3 = params.azQ();
      ar.a locala = ar.a.Ong;
      String str = cZc().LNY;
      params = str;
      localObject2 = locala;
      localObject1 = localObject3;
      if (str == null)
      {
        params = "";
        localObject2 = locala;
        localObject1 = localObject3;
      }
    }
    label1449:
    AppMethodBeat.o(242499);
  }
  
  public final bed cZc()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.tvD;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (bed)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165260);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.tvD, (m)this);
    AppMethodBeat.o(165260);
    return i;
  }
  
  public final int getType()
  {
    return 3761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cd
 * JD-Core Version:    0.7.0.1
 */