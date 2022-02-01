package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.t;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.k.h;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class i
  implements f
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean dyu;
  private static final Runnable gPe;
  private static final Runnable gPf;
  static final Runnable gPg;
  public static final i gPh;
  
  static
  {
    AppMethodBeat.i(212155);
    gPh = new i();
    TAG = "MicroMsg.LiveRoomOperation";
    dyu = true;
    gPe = (Runnable)b.gPj;
    gPf = (Runnable)i.a.gPi;
    gPg = (Runnable)c.gPk;
    AppMethodBeat.o(212155);
  }
  
  public static void X(String paramString, int paramInt)
  {
    AppMethodBeat.i(212133);
    d.g.b.p.h(paramString, "content");
    Object localObject1 = com.tencent.mm.model.u.aAm();
    d.g.b.p.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, cf.aCN());
    Object localObject2 = g.gOr;
    g.anp().add(localObject1);
    localObject1 = c.gMO;
    c.amO();
    localObject1 = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject1, "MMKernel.network()");
    com.tencent.mm.al.q localq = ((com.tencent.mm.kernel.b)localObject1).aiU();
    localObject1 = g.gOr;
    long l = g.ans().Fsa;
    localObject1 = g.gOr;
    localObject2 = g.anq();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = g.gOr;
    localq.b((com.tencent.mm.al.n)new s(paramString, paramInt, l, (byte[])localObject1, g.anm()));
    AppMethodBeat.o(212133);
  }
  
  public static void Y(List<String> paramList)
  {
    AppMethodBeat.i(212148);
    d.g.b.p.h(paramList, "userList");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.n(g.ans().Fsa, paramList));
    AppMethodBeat.o(212148);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212151);
    d.g.b.p.h(paramLiveConfig, "config");
    if (paramLiveConfig.akU() == LiveConfig.gGr) {}
    for (boolean bool = true;; bool = false)
    {
      dyu = bool;
      AppMethodBeat.o(212151);
      return;
    }
  }
  
  public static void aoo()
  {
    AppMethodBeat.i(212132);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new m(l, g.anm(), true));
    AppMethodBeat.o(212132);
  }
  
  public static void aop()
  {
    AppMethodBeat.i(212135);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.a(l, g.anm()));
    AppMethodBeat.o(212135);
  }
  
  public static void aoq()
  {
    AppMethodBeat.i(212141);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.b(l, g.anm()));
    AppMethodBeat.o(212141);
  }
  
  public static void aor()
  {
    AppMethodBeat.i(212150);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new e(l, g.anm()));
    AppMethodBeat.o(212150);
  }
  
  public static void as(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212149);
    d.g.b.p.h(paramString1, "micId");
    d.g.b.p.h(paramString2, "sdkUid");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new k(l, g.anm(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2));
    AppMethodBeat.o(212149);
  }
  
  public static void dR(boolean paramBoolean)
  {
    AppMethodBeat.i(212142);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.i(l, g.anm(), paramBoolean));
    AppMethodBeat.o(212142);
  }
  
  public static void dS(boolean paramBoolean)
  {
    AppMethodBeat.i(212144);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new r(l, g.anm(), paramBoolean));
    AppMethodBeat.o(212144);
  }
  
  public static void nG(int paramInt)
  {
    AppMethodBeat.i(212134);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.q(l, g.anm(), paramInt));
    AppMethodBeat.o(212134);
  }
  
  public static void nH(int paramInt)
  {
    AppMethodBeat.i(212147);
    buo localbuo = new buo();
    localbuo.GOC = paramInt;
    localbuo.GOB = cf.aCL();
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.g(g.ans().Fsa, localbuo));
    AppMethodBeat.o(212147);
  }
  
  private static void rj(long paramLong)
  {
    AppMethodBeat.i(212130);
    com.tencent.mm.ad.c.B(gPf);
    com.tencent.mm.ad.c.a(paramLong, gPf);
    AppMethodBeat.o(212130);
  }
  
  public static void xM(String paramString)
  {
    AppMethodBeat.i(212140);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.d(g.ans().Fsa, paramString));
    AppMethodBeat.o(212140);
  }
  
  public static void xN(String paramString)
  {
    AppMethodBeat.i(212143);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.u(g.ans().Fsa, paramString));
    AppMethodBeat.o(212143);
  }
  
  public static void xO(String paramString)
  {
    AppMethodBeat.i(212145);
    d.g.b.p.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    long l = g.ans().Fsa;
    localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.p(l, g.anm(), paramString));
    AppMethodBeat.o(212145);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212138);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aiU();
    g localg = g.gOr;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.c(g.ans().Fsa, paramString, paramBoolean));
    AppMethodBeat.o(212138);
  }
  
  public final void aos()
  {
    AppMethodBeat.i(212152);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(3767, (f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(589, (f)this);
    AppMethodBeat.o(212152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    long l = 0L;
    Object localObject = null;
    paramString = null;
    AppMethodBeat.i(212154);
    if ((paramn instanceof m))
    {
      l = ((m)paramn).duration;
      paramString = f.h.gNu;
      if (l > f.h.anh()) {}
      for (l = 0L;; l = f.h.anh())
      {
        ad.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m)paramn).duration + ", delay:" + l);
        rj(l);
        paramString = g.gOr;
        paramString = g.gOr;
        g.nv(g.ans().GzV);
        AppMethodBeat.o(212154);
        return;
        paramString = f.h.gNu;
      }
    }
    if ((paramn instanceof o))
    {
      localObject = com.tencent.mm.kernel.g.ajB();
      d.g.b.p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).aiU().b(3797, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((o)paramn).gQj;
        if (paramn != null) {
          paramString = paramn.GMH;
        }
        if (paramString != null)
        {
          paramn = g.gOr;
          g.a(paramString);
          ad.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (dyu)
          {
            paramn = com.tencent.mm.live.core.core.a.b.gHl;
            paramn = aj.getContext();
            d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.a.b.a.cq(paramn);
            localObject = paramString.GOY.ffY();
            d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.xm((String)localObject);
          }
          for (;;)
          {
            paramn = g.gOr;
            paramn = g.anw();
            if (paramn != null)
            {
              paramn = paramn.gHC;
              if (paramn != null) {
                paramn.privateMapKey = paramString.GOY.ffY();
              }
            }
            paramString = g.gOr;
            paramString = g.ant();
            if (paramString != null) {
              l = paramString.GPc;
            }
            rk(h.aH((l - 60L) * 1000L, 60000L));
            AppMethodBeat.o(212154);
            return;
            paramn = com.tencent.mm.live.core.core.c.b.gKd;
            paramn = aj.getContext();
            d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.c.b.a.cr(paramn);
            localObject = paramString.GOY.ffY();
            d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.xm((String)localObject);
          }
        }
      }
    }
    else if ((paramn instanceof t))
    {
      paramString = com.tencent.mm.kernel.g.ajB();
      d.g.b.p.g(paramString, "MMKernel.network()");
      paramString.aiU().b(760, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((t)paramn).gQy;
        paramString = (String)localObject;
        if (paramn != null) {
          paramString = paramn.GMH;
        }
        if (paramString != null)
        {
          paramn = g.gOr;
          g.a(paramString);
          ad.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramn = com.tencent.mm.live.core.core.c.b.gKd;
          paramn = aj.getContext();
          d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
          paramn = com.tencent.mm.live.core.core.c.b.a.cr(paramn);
          localObject = paramString.GOY.ffY();
          d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramn.xm((String)localObject);
          paramn = g.gOr;
          paramn = g.anw();
          if (paramn != null)
          {
            paramn = paramn.gHC;
            if (paramn != null) {
              paramn.privateMapKey = paramString.GOY.ffY();
            }
          }
          paramString = g.gOr;
          rl(h.aH((g.anx() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(212154);
        }
      }
    }
    else if ((paramn instanceof e))
    {
      paramString = ((e)paramn).gPF;
      if (paramString != null)
      {
        paramString = paramString.GAa;
        paramString = (List)paramString;
        if (paramString == null) {
          break label849;
        }
        if (((Collection)paramString).isEmpty()) {
          break label844;
        }
      }
      label844:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 1) {
          break label856;
        }
        paramString = (but)paramString.get(0);
        if (paramString == null) {
          break label856;
        }
        ad.i(TAG, "update live mic audienceInfo:[" + paramString.GOM + ' ' + paramString.nickname + ']');
        paramn = g.gOr;
        paramn = g.aod();
        localObject = g.gOr;
        l = g.ans().Fsa;
        localObject = paramString.Fsd;
        d.g.b.p.g(localObject, "it.live_mic_id");
        String str1 = paramString.GOM;
        d.g.b.p.g(str1, "it.identity_id");
        String str2 = paramString.pjL;
        d.g.b.p.g(str2, "it.head_img_url");
        String str3 = paramString.nickname;
        d.g.b.p.g(str3, "it.nickname");
        paramString = paramString.GOI;
        d.g.b.p.g(paramString, "it.sdk_user_id");
        paramn.a(l, (String)localObject, str1, str2, str3, paramString);
        AppMethodBeat.o(212154);
        return;
        paramString = null;
        break;
      }
      label849:
      AppMethodBeat.o(212154);
      return;
    }
    label856:
    AppMethodBeat.o(212154);
  }
  
  public final void release()
  {
    AppMethodBeat.i(212153);
    com.tencent.mm.ad.c.B(gPe);
    com.tencent.mm.ad.c.B(gPf);
    com.tencent.mm.ad.c.B(gPg);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().b(3767, (f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().b(3797, (f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().b(760, (f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().b(589, (f)this);
    AppMethodBeat.o(212153);
  }
  
  public final void rk(long paramLong)
  {
    AppMethodBeat.i(212136);
    ad.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(3797, (f)this);
    com.tencent.mm.ad.c.B(gPe);
    com.tencent.mm.ad.c.a(paramLong, gPe);
    AppMethodBeat.o(212136);
  }
  
  public final void rl(long paramLong)
  {
    AppMethodBeat.i(212146);
    ad.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(760, (f)this);
    com.tencent.mm.ad.c.B(gPg);
    com.tencent.mm.ad.c.a(paramLong, gPg);
    AppMethodBeat.o(212146);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b gPj;
    
    static
    {
      AppMethodBeat.i(212127);
      gPj = new b();
      AppMethodBeat.o(212127);
    }
    
    public final void run()
    {
      AppMethodBeat.i(212126);
      Object localObject1 = com.tencent.mm.kernel.g.ajB();
      d.g.b.p.g(localObject1, "MMKernel.network()");
      localObject1 = ((com.tencent.mm.kernel.b)localObject1).aiU();
      Object localObject2 = g.gOr;
      long l = g.ans().Fsa;
      localObject2 = g.gOr;
      localObject2 = g.anm();
      g localg = g.gOr;
      ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new o(l, (String)localObject2, g.anq()));
      AppMethodBeat.o(212126);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c gPk;
    
    static
    {
      AppMethodBeat.i(212129);
      gPk = new c();
      AppMethodBeat.o(212129);
    }
    
    public final void run()
    {
      AppMethodBeat.i(212128);
      Object localObject = com.tencent.mm.kernel.g.ajB();
      d.g.b.p.g(localObject, "MMKernel.network()");
      com.tencent.mm.al.q localq = ((com.tencent.mm.kernel.b)localObject).aiU();
      localObject = g.gOr;
      long l = g.ans().Fsa;
      localObject = g.gOr;
      String str2 = g.anm();
      localObject = g.gOr;
      localObject = g.aod().gQP;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).gQS;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localq.b((com.tencent.mm.al.n)new t(l, str2, (String)localObject));
      AppMethodBeat.o(212128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */