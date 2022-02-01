package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ch
  extends com.tencent.mm.plugin.findersdk.b.g
  implements aq
{
  private final String TAG;
  private com.tencent.mm.an.i callback;
  public boolean xdV;
  private com.tencent.mm.an.d xdl;
  
  public ch(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    bld localbld = new bld();
    localbld.scene = paramInt;
    ao localao = ao.xcj;
    localbld.yjp = ao.dnO();
    locala.c((com.tencent.mm.cd.a)localbld);
    locala.d((com.tencent.mm.cd.a)new ble());
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/finderuserprepare");
    this.xdl = locala.bgN();
    AppMethodBeat.o(165263);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(269055);
    Object localObject1;
    Object localObject2;
    label101:
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("userFlag=").append(dnR().zqt).append(" username=");
      params = dnR().SDj;
      if (params == null) {
        break label2551;
      }
      params = params.username;
      localObject2 = ((StringBuilder)localObject2).append(params).append(" nickname=");
      params = dnR().SDj;
      if (params == null) {
        break label2557;
      }
      params = params.nickname;
      Log.i((String)localObject1, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VyF, Integer.valueOf(dnR().zqt));
      localObject1 = dnR().SDj;
      if (localObject1 != null)
      {
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VxX, ((FinderContact)localObject1).username);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VxY, ((FinderContact)localObject1).nickname);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VxZ, ((FinderContact)localObject1).signature);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vya, ((FinderContact)localObject1).headUrl);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vyc, ((FinderContact)localObject1).coverImgUrl);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vzn, Integer.valueOf(((FinderContact)localObject1).extFlag));
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vyl, Integer.valueOf(((FinderContact)localObject1).originalFlag));
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vyq, Integer.valueOf(((FinderContact)localObject1).originalEntranceFlag));
        params = ((FinderContact)localObject1).originalInfo;
        if (params != null)
        {
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vym, Integer.valueOf(params.SRe));
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vyn, Integer.valueOf(params.SRf));
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vyo, Integer.valueOf(params.SRg));
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vyp, Integer.valueOf(params.SRh));
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vys, Integer.valueOf(params.SRi));
        }
        params = com.tencent.mm.plugin.finder.api.d.wZQ;
        p.j(localObject1, "it");
        com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject1);
        if (((FinderContact)localObject1).authInfo != null) {
          break label2563;
        }
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.Vyb, "");
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VyI, ((FinderContact)localObject1).liveCoverImgUrl);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        localObject2 = params.aHp();
        localObject3 = ar.a.VyJ;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label2627;
        }
        params = Long.valueOf(params.SEj);
        label690:
        ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        localObject2 = params.aHp();
        localObject3 = ar.a.VyK;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label2636;
        }
        params = Long.valueOf(params.SEk);
        label746:
        ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        localObject2 = params.aHp();
        localObject3 = ar.a.VyQ;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label2645;
        }
        params = params.SEm;
        if (params == null) {
          break label2645;
        }
        params = Long.valueOf(params.TFP);
        label813:
        ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        localObject2 = params.aHp();
        localObject3 = ar.a.VyL;
        params = ((FinderContact)localObject1).live_info;
        if (params == null) {
          break label2654;
        }
        params = params.SEm;
        if (params == null) {
          break label2654;
        }
        params = Long.valueOf(params.TFQ);
        label880:
        ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
        com.tencent.e.h.ZvG.bg((Runnable)a.xdW);
        params = ((FinderContact)localObject1).authInfo;
        if (params == null) {
          break label2663;
        }
        Log.d(this.TAG, "auth_verify_identity : " + params.auth_verify_identity);
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VCq, Integer.valueOf(params.auth_verify_identity));
        params = x.aazN;
        label980:
        if (params != null) {}
      }
      else
      {
        params = (ch)this;
        Log.i(params.TAG, "svr return selfContact is null, user_no_finder = " + params.dnR().SWo);
        if (params.dnR().SWo == 1)
        {
          params = aj.AGc;
          aj.aFS("user_no_finder");
        }
        params = x.aazN;
      }
      params = dnR().SWa;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vyt, params);
      }
      params = dnR().SWb;
      if (params != null)
      {
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vyu, params);
      }
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.VyO;
      params = dnR().SWs;
      if (params != null)
      {
        params = params.RJj;
        if (params != null)
        {
          localObject1 = params.RJk;
          params = (s)localObject1;
          if (localObject1 != null) {
            break label1200;
          }
        }
      }
      params = "";
      label1200:
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.VyP;
      params = dnR().SWs;
      if (params != null)
      {
        params = params.RJj;
        if (params != null)
        {
          localObject1 = params.jump_url;
          params = (s)localObject1;
          if (localObject1 != null) {
            break label1280;
          }
        }
      }
      params = "";
      label1280:
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.VyM;
      params = dnR().SWq;
      if (params != null)
      {
        localObject1 = params.SNP;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.VyN;
      params = dnR().SWq;
      if (params != null)
      {
        localObject1 = params.jDP;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.Vyv;
      params = dnR().SWh;
      if (params != null)
      {
        localObject1 = params.appId;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.Vyw;
      params = dnR().SWh;
      if (params != null)
      {
        localObject1 = params.SWz;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.Vyx;
      params = dnR().wxaShopInfo;
      if (params != null)
      {
        localObject1 = params.appId;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.Vyy;
      params = dnR().wxaShopInfo;
      if (params != null)
      {
        localObject1 = params.SWz;
        params = (s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, params);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.Vyz, Integer.valueOf(dnR().SWk));
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VyD, Integer.valueOf(dnR().SWf));
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VyE, Integer.valueOf(dnR().SWg));
      paramInt1 = dnR().Apz;
      if (paramInt1 > 0)
      {
        Log.i(this.TAG, "nicknameMaxLength ： ".concat(String.valueOf(paramInt1)));
        params = com.tencent.mm.kernel.h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VyC, Integer.valueOf(paramInt1));
      }
      if (dnR().SWn != null) {
        break label2669;
      }
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VCu, "");
      params = ab.AEA;
      ab.a(dnR().SWj);
      params = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.aq(dnR().SID);
      paramInt1 = dnR().SIE;
      Log.i(this.TAG, "current_alias_role_type：".concat(String.valueOf(paramInt1)));
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VyS, Integer.valueOf(paramInt1));
      long l = dnR().SIF;
      Log.i(this.TAG, "next_alias_mod_available_time：".concat(String.valueOf(l)));
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VyW, Long.valueOf(l));
      params = dnR().SID;
      p.j(params, "getResponse().alias_info");
      localObject1 = ((Iterable)params).iterator();
      label2054:
      if (!((Iterator)localObject1).hasNext()) {
        break label2740;
      }
      params = ((Iterator)localObject1).next();
      if (((axc)params).SJy != 2) {
        break label2735;
      }
      paramInt1 = 1;
      label2087:
      if (paramInt1 == 0) {
        break label2738;
      }
      label2091:
      params = (axc)params;
      if (params == null) {
        break label2746;
      }
      localObject1 = aj.AGc;
      aj.a(params, Boolean.TRUE, "NetSceneFinderPrepareUser");
      label2119:
      params = (CharSequence)dnR().SWm;
      if ((params != null) && (params.length() != 0)) {
        break label2802;
      }
      paramInt1 = 1;
      label2148:
      if (paramInt1 == 0) {
        break label2807;
      }
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject1 = params.aHp();
      localObject2 = ar.a.VCn;
      params = "";
      label2181:
      ((com.tencent.mm.storage.ao)localObject1).set((ar.a)localObject2, params);
      Log.d(this.TAG, "foreign_user_flag : " + dnR().foreign_user_flag);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp();
      localObject1 = ar.a.VCp;
      if (dnR().foreign_user_flag == 0) {
        break label2873;
      }
      bool = true;
      label2257:
      params.set((ar.a)localObject1, Boolean.valueOf(bool));
      Log.i(this.TAG, "logout_lock：" + dnR().logout_lock);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp();
      localObject1 = ar.a.VCr;
      if (dnR().logout_lock != 1) {
        break label2879;
      }
      bool = true;
      label2337:
      params.set((ar.a)localObject1, Boolean.valueOf(bool));
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params.aHp().set(ar.a.VCs, dnR().logout_url);
      params = com.tencent.mm.plugin.finder.api.d.wZQ;
      params = z.bdh();
      p.j(params, "ConfigStorageLogic.getMyFinderUsername()");
      com.tencent.mm.plugin.finder.api.d.a.L(params, dnR().logout_lock, dnR().logout_url);
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp();
      localObject1 = ar.a.Vzs;
      localObject2 = aj.AGc;
      localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      bool = com.tencent.mm.ae.d.dr(((com.tencent.mm.kernel.f)localObject2).aHp().getInt(ar.a.VyF, 0), 8);
      if (aj.eej()) {
        Log.i(aj.TAG, "[checkAgreeGetPhone] ".concat(String.valueOf(bool)));
      }
      if (bool) {
        break label2885;
      }
    }
    label2563:
    label2627:
    label2885:
    for (boolean bool = true;; bool = false)
    {
      params.set((ar.a)localObject1, Boolean.valueOf(bool));
      params = this.callback;
      if (params == null) {
        break label2891;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(269055);
      return;
      label2551:
      params = null;
      break;
      label2557:
      params = null;
      break label101;
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject2 = params.aHp();
      localObject3 = ar.a.Vyb;
      params = ((FinderContact)localObject1).authInfo;
      if (params != null) {}
      for (params = params.toByteArray();; params = null)
      {
        ((com.tencent.mm.storage.ao)localObject2).set((ar.a)localObject3, Util.encodeHexString(params));
        break;
      }
      params = Long.valueOf(0L);
      break label690;
      label2636:
      params = Long.valueOf(0L);
      break label746;
      label2645:
      params = Long.valueOf(0L);
      break label813;
      label2654:
      params = Long.valueOf(0L);
      break label880;
      label2663:
      params = null;
      break label980;
      label2669:
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject1 = params.aHp();
      localObject2 = ar.a.VCu;
      params = dnR().SWn;
      if (params != null) {}
      for (params = params.toByteArray();; params = null)
      {
        ((com.tencent.mm.storage.ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(params));
        break;
      }
      paramInt1 = 0;
      break label2087;
      break label2054;
      params = null;
      break label2091;
      params = ((ch)this).dnR().SID;
      if (params == null) {
        break label2119;
      }
      if (!((Collection)params).isEmpty()) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 1) {
          break label2800;
        }
        params = aj.AGc;
        aj.aFT("NetSceneFinderPrepareUser");
        break;
      }
      label2800:
      break label2119;
      label2802:
      paramInt1 = 0;
      break label2148;
      label2807:
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      localObject3 = params.aHp();
      ar.a locala = ar.a.VCn;
      String str = dnR().SWm;
      params = str;
      localObject2 = locala;
      localObject1 = localObject3;
      if (str != null) {
        break label2181;
      }
      params = "";
      localObject2 = locala;
      localObject1 = localObject3;
      break label2181;
      bool = false;
      break label2257;
      bool = false;
      break label2337;
    }
    label2735:
    label2738:
    label2740:
    label2746:
    label2879:
    label2891:
    AppMethodBeat.o(269055);
    label2873:
  }
  
  public final ble dnR()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.xdl;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((com.tencent.mm.an.d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (ble)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(165260);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.xdl, (m)this);
    AppMethodBeat.o(165260);
    return i;
  }
  
  public final int getType()
  {
    return 3761;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a xdW;
    
    static
    {
      AppMethodBeat.i(275276);
      xdW = new a();
      AppMethodBeat.o(275276);
    }
    
    public final void run()
    {
      AppMethodBeat.i(275275);
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager();
      com.tencent.mm.plugin.finder.extension.reddot.f.dqL();
      AppMethodBeat.o(275275);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ch
 * JD-Core Version:    0.7.0.1
 */