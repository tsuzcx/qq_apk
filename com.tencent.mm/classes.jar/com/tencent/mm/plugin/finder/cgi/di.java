package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.x;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class di
  extends com.tencent.mm.plugin.findersdk.b.h
  implements bl
{
  private c ACJ;
  public boolean ADf;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  
  public di(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    c.a locala = new c.a();
    byr localbyr = new byr();
    localbyr.scene = paramInt;
    bi localbi = bi.ABn;
    localbyr.CJv = bi.dVu();
    locala.otE = ((a)localbyr);
    locala.otF = ((a)new bys());
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/finderuserprepare";
    this.ACJ = locala.bEF();
    AppMethodBeat.o(165263);
  }
  
  private static final void dWt()
  {
    AppMethodBeat.i(336572);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    com.tencent.mm.plugin.finder.extension.reddot.i.dZw();
    AppMethodBeat.o(336572);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336620);
    Object localObject1;
    Object localObject2;
    label93:
    Object localObject3;
    label147:
    label317:
    label358:
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("userFlag=").append(dVy().EsV).append(" username=");
      params = dVy().ZEd;
      if (params != null) {
        break label1458;
      }
      params = null;
      localObject2 = ((StringBuilder)localObject2).append(params).append(" nickname=");
      params = dVy().ZEd;
      if (params != null) {
        break label1468;
      }
      params = null;
      Log.i((String)localObject1, params);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaB, Integer.valueOf(dVy().EsV));
      localObject1 = dVy().ZEd;
      if (localObject1 != null) {
        break label1478;
      }
      params = null;
      if (params == null)
      {
        params = (di)this;
        Log.i(params.TAG, kotlin.g.b.s.X("svr return selfContact is null, user_no_finder = ", Integer.valueOf(params.dVy().aahG)));
        if (params.dVy().aahG == 1)
        {
          params = av.GiL;
          av.aBR("user_no_finder");
        }
        params = ah.aiuX;
      }
      params = dVy().aahs;
      if (params != null)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adao, params);
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = dVy().aaht;
      if (params != null)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adap, params);
        params = ah.aiuX;
        params = ah.aiuX;
      }
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adaK;
      params = dVy().aahK;
      if (params != null) {
        break label2285;
      }
      params = "";
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adaL;
      params = dVy().aahK;
      if (params != null) {
        break label2329;
      }
      params = "";
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adaI;
      params = dVy().aahI;
      if (params != null) {
        break label2373;
      }
      params = "";
      label399:
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adaJ;
      params = dVy().aahI;
      if (params != null) {
        break label2397;
      }
      params = "";
      label440:
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adaq;
      params = dVy().aahz;
      if (params != null) {
        break label2421;
      }
      params = "";
      label481:
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adar;
      params = dVy().aahz;
      if (params != null) {
        break label2445;
      }
      params = "";
      label522:
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adas;
      params = dVy().wxaShopInfo;
      if (params != null) {
        break label2469;
      }
      params = "";
      label563:
      ((aq)localObject2).set((at.a)localObject3, params);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adat;
      params = dVy().wxaShopInfo;
      if (params != null) {
        break label2493;
      }
      params = "";
      label604:
      ((aq)localObject2).set((at.a)localObject3, params);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adav, Integer.valueOf(dVy().aahC));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaz, Integer.valueOf(dVy().aahx));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaA, Integer.valueOf(dVy().aahy));
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      localObject3 = at.a.adau;
      params = dVy().aahM;
      if (params != null) {
        break label2517;
      }
      params = "";
      label711:
      ((aq)localObject2).set((at.a)localObject3, params);
      paramInt1 = dVy().FPD;
      if (paramInt1 > 0)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("nicknameMaxLength ： ", Integer.valueOf(paramInt1)));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.aday, Integer.valueOf(paramInt1));
      }
      params = ah.aiuX;
      params = ah.aiuX;
      if (dVy().aahF != null) {
        break label2541;
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfl, "");
      if (dVy().aahO != null) {
        break label2596;
      }
      Log.i(this.TAG, "GameRankSwitch set empty");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfm, "");
      params = am.GhD;
      am.a(dVy().aahB);
      ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).u(dVy().ZMv);
      paramInt1 = dVy().ZMw;
      Log.i(this.TAG, kotlin.g.b.s.X("current_alias_role_type：", Integer.valueOf(paramInt1)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaO, Integer.valueOf(paramInt1));
      l = dVy().ZMx;
      Log.i(this.TAG, kotlin.g.b.s.X("next_alias_mod_available_time：", Long.valueOf(l)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaS, Long.valueOf(l));
      params = dVy().ZMv;
      kotlin.g.b.s.s(params, "getResponse().alias_info");
      localObject1 = ((Iterable)params).iterator();
      label985:
      if (!((Iterator)localObject1).hasNext()) {
        break label2695;
      }
      params = ((Iterator)localObject1).next();
      if (((bcz)params).ZNI != 2) {
        break label2690;
      }
      paramInt1 = 1;
      label1018:
      if (paramInt1 == 0) {
        break label2693;
      }
      label1022:
      params = (bcz)params;
      if (params != null) {
        break label2701;
      }
      params = null;
      label1037:
      if (params == null)
      {
        params = ((di)this).dVy().ZMv;
        if (params == null) {
          break label2735;
        }
        if (((Collection)params).isEmpty()) {
          break label2730;
        }
        paramInt1 = 1;
        label1074:
        if (paramInt1 != 1) {
          break label2735;
        }
        paramInt1 = 1;
        label1081:
        if (paramInt1 != 0)
        {
          params = av.GiL;
          av.aBS("NetSceneFinderPrepareUser");
        }
        params = ah.aiuX;
      }
      params = (CharSequence)dVy().aahE;
      if ((params != null) && (params.length() != 0)) {
        break label2740;
      }
      paramInt1 = 1;
      label1130:
      if (paramInt1 == 0) {
        break label2745;
      }
      localObject1 = com.tencent.mm.kernel.h.baE().ban();
      localObject2 = at.a.adfc;
      params = "";
      label1152:
      ((aq)localObject1).set((at.a)localObject2, params);
      Log.d(this.TAG, kotlin.g.b.s.X("foreign_user_flag : ", Integer.valueOf(dVy().foreign_user_flag)));
      params = com.tencent.mm.kernel.h.baE().ban();
      localObject1 = at.a.adff;
      if (dVy().foreign_user_flag == 0) {
        break label2800;
      }
      bool = true;
      label1210:
      params.set((at.a)localObject1, Boolean.valueOf(bool));
      Log.i(this.TAG, kotlin.g.b.s.X("logout_lock：", Integer.valueOf(dVy().logout_lock)));
      params = com.tencent.mm.kernel.h.baE().ban();
      localObject1 = at.a.adfh;
      if (dVy().logout_lock != 1) {
        break label2806;
      }
      bool = true;
      label1272:
      params.set((at.a)localObject1, Boolean.valueOf(bool));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfi, dVy().logout_url);
      params = com.tencent.mm.plugin.finder.api.d.AwY;
      params = z.bAW();
      kotlin.g.b.s.s(params, "getMyFinderUsername()");
      d.a.N(params, dVy().logout_lock, dVy().logout_url);
      params = com.tencent.mm.kernel.h.baE().ban();
      localObject1 = at.a.adbx;
      localObject2 = av.GiL;
      bool = com.tencent.mm.ae.d.ee(com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0), 8);
      if (av.bgV()) {
        Log.i(av.TAG, kotlin.g.b.s.X("[checkAgreeGetPhone] ", Boolean.valueOf(bool)));
      }
      if (bool) {
        break label2812;
      }
    }
    label1458:
    label1468:
    label1478:
    label1864:
    label1904:
    label2164:
    label2421:
    label2806:
    label2812:
    for (boolean bool = true;; bool = false)
    {
      params.set((at.a)localObject1, Boolean.valueOf(bool));
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
        paramString = ah.aiuX;
      }
      AppMethodBeat.o(336620);
      return;
      params = params.username;
      break;
      params = params.nickname;
      break label93;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, ((FinderContact)localObject1).username);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZS, ((FinderContact)localObject1).nickname);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZT, ((FinderContact)localObject1).signature);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZU, ((FinderContact)localObject1).headUrl);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZW, ((FinderContact)localObject1).coverImgUrl);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(((FinderContact)localObject1).extFlag));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adag, Integer.valueOf(((FinderContact)localObject1).originalFlag));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adal, Integer.valueOf(((FinderContact)localObject1).originalEntranceFlag));
      params = ((FinderContact)localObject1).originalInfo;
      if (params != null)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adah, Integer.valueOf(params.ZZW));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adai, Integer.valueOf(params.ZZX));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adaj, Integer.valueOf(params.ZZY));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adak, Integer.valueOf(params.ZZZ));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adan, Integer.valueOf(params.aaaa));
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = com.tencent.mm.plugin.finder.api.d.AwY;
      d.a.d((FinderContact)localObject1);
      if (((FinderContact)localObject1).authInfo == null)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZV, "");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adaE, ((FinderContact)localObject1).liveCoverImgUrl);
        params = com.tencent.mm.kernel.h.baE().ban();
        localObject2 = at.a.adaF;
        localObject3 = ((FinderContact)localObject1).live_info;
        if (localObject3 != null) {
          break label2154;
        }
        l = 0L;
        params.set((at.a)localObject2, Long.valueOf(l));
        params = com.tencent.mm.kernel.h.baE().ban();
        localObject2 = at.a.adaG;
        localObject3 = ((FinderContact)localObject1).live_info;
        if (localObject3 != null) {
          break label2164;
        }
        l = 0L;
        params.set((at.a)localObject2, Long.valueOf(l));
        params = com.tencent.mm.kernel.h.baE().ban();
        localObject2 = at.a.adaM;
        localObject3 = ((FinderContact)localObject1).live_info;
        if (localObject3 != null) {
          break label2175;
        }
        l = 0L;
        params.set((at.a)localObject2, Long.valueOf(l));
        params = com.tencent.mm.kernel.h.baE().ban();
        localObject2 = at.a.adaH;
        localObject3 = ((FinderContact)localObject1).live_info;
        if (localObject3 != null) {
          break label2203;
        }
        l = 0L;
      }
      for (;;)
      {
        params.set((at.a)localObject2, Long.valueOf(l));
        params = ((FinderContact)localObject1).live_info;
        if (params != null)
        {
          params = params.ZFL;
          if (params != null)
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adeL, Long.valueOf(params.CJK));
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adeM, Integer.valueOf(params.BBE));
            Log.i(this.TAG, "lottery_setting:" + params.CJK + ',' + params.BBE);
            params = ah.aiuX;
            params = ah.aiuX;
          }
        }
        com.tencent.threadpool.h.ahAA.bo(di..ExternalSyntheticLambda0.INSTANCE);
        params = ((FinderContact)localObject1).authInfo;
        if (params != null) {
          break label2231;
        }
        params = null;
        break;
        localObject2 = com.tencent.mm.kernel.h.baE().ban();
        localObject3 = at.a.acZV;
        params = ((FinderContact)localObject1).authInfo;
        if (params == null) {}
        for (params = null;; params = params.toByteArray())
        {
          ((aq)localObject2).set((at.a)localObject3, Util.encodeHexString(params));
          break;
        }
        l = ((avn)localObject3).ZFH;
        break label1824;
        l = ((avn)localObject3).ZFI;
        break label1864;
        label2175:
        localObject3 = ((avn)localObject3).ZFK;
        if (localObject3 == null)
        {
          l = 0L;
          break label1904;
        }
        l = ((dom)localObject3).CJK;
        break label1904;
        localObject3 = ((avn)localObject3).ZFK;
        if (localObject3 == null) {
          l = 0L;
        } else {
          l = ((dom)localObject3).aaVw;
        }
      }
      Log.d(this.TAG, kotlin.g.b.s.X("auth_verify_identity : ", Integer.valueOf(params.auth_verify_identity)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfg, Integer.valueOf(params.auth_verify_identity));
      params = ah.aiuX;
      params = ah.aiuX;
      break label147;
      params = params.YGw;
      if (params == null)
      {
        params = "";
        break label317;
      }
      localObject1 = params.YGx;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label317;
      }
      params = "";
      break label317;
      params = params.YGw;
      if (params == null)
      {
        params = "";
        break label358;
      }
      localObject1 = params.jump_url;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label358;
      }
      params = "";
      break label358;
      localObject1 = params.ZVg;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label399;
      }
      params = "";
      break label399;
      localObject1 = params.mdK;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label440;
      }
      params = "";
      break label440;
      localObject1 = params.appId;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label481;
      }
      params = "";
      break label481;
      localObject1 = params.aail;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label522;
      }
      params = "";
      break label522;
      localObject1 = params.appId;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label563;
      }
      params = "";
      break label563;
      localObject1 = params.aail;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label604;
      }
      params = "";
      break label604;
      localObject1 = params.ablc;
      params = (com.tencent.mm.network.s)localObject1;
      if (localObject1 != null) {
        break label711;
      }
      params = "";
      break label711;
      localObject1 = com.tencent.mm.kernel.h.baE().ban();
      localObject2 = at.a.adfl;
      params = dVy().aahF;
      if (params == null) {}
      for (params = null;; params = params.toByteArray())
      {
        ((aq)localObject1).set((at.a)localObject2, Util.encodeHexString(params));
        break;
      }
      params = dVy().aahO;
      if (params != null)
      {
        localObject1 = x.GgW;
        x.a(params, kotlin.g.b.s.X(this.TAG, "_set"));
        params = ah.aiuX;
      }
      localObject1 = com.tencent.mm.kernel.h.baE().ban();
      localObject2 = at.a.adfm;
      params = dVy().aahO;
      if (params == null) {}
      for (params = null;; params = params.toByteArray())
      {
        ((aq)localObject1).set((at.a)localObject2, Util.encodeHexString(params));
        break;
      }
      paramInt1 = 0;
      break label1018;
      break label985;
      params = null;
      break label1022;
      localObject1 = av.GiL;
      av.a(params, Boolean.TRUE, "NetSceneFinderPrepareUser");
      params = ah.aiuX;
      params = ah.aiuX;
      break label1037;
      paramInt1 = 0;
      break label1074;
      paramInt1 = 0;
      break label1081;
      paramInt1 = 0;
      break label1130;
      localObject3 = com.tencent.mm.kernel.h.baE().ban();
      at.a locala = at.a.adfc;
      String str = dVy().aahE;
      params = str;
      localObject2 = locala;
      localObject1 = localObject3;
      if (str != null) {
        break label1152;
      }
      params = "";
      localObject2 = locala;
      localObject1 = localObject3;
      break label1152;
      bool = false;
      break label1210;
      bool = false;
      break label1272;
    }
  }
  
  public final bys dVy()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.ACJ;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (bys)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165260);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.ACJ, (m)this);
    AppMethodBeat.o(165260);
    return i;
  }
  
  public final int getType()
  {
    return 3761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.di
 * JD-Core Version:    0.7.0.1
 */