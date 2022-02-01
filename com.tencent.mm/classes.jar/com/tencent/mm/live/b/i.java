package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.p;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.t;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.k.h;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class i
  implements com.tencent.mm.ak.g
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean dmG;
  private static final Runnable gvt;
  private static final Runnable gvu;
  static final Runnable gvv;
  public static final i gvw;
  
  static
  {
    AppMethodBeat.i(189869);
    gvw = new i();
    TAG = "MicroMsg.LiveRoomOperation";
    dmG = true;
    gvt = (Runnable)b.gvy;
    gvu = (Runnable)a.gvx;
    gvv = (Runnable)c.gvz;
    AppMethodBeat.o(189869);
  }
  
  public static void T(String paramString, int paramInt)
  {
    AppMethodBeat.i(189847);
    d.g.b.k.h(paramString, "content");
    Object localObject1 = com.tencent.mm.model.u.axw();
    d.g.b.k.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, ce.azK());
    Object localObject2 = g.guG;
    g.akD().add(localObject1);
    localObject1 = c.gtd;
    c.akc();
    localObject1 = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject1, "MMKernel.network()");
    com.tencent.mm.ak.q localq = ((com.tencent.mm.kernel.b)localObject1).agi();
    localObject1 = g.guG;
    long l = g.akF().DMV;
    localObject1 = g.guG;
    localObject2 = g.akE();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = g.guG;
    localq.b((com.tencent.mm.ak.n)new s(paramString, paramInt, l, (byte[])localObject1, g.akA()));
    AppMethodBeat.o(189847);
  }
  
  public static void X(List<String> paramList)
  {
    AppMethodBeat.i(189862);
    d.g.b.k.h(paramList, "userList");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.n(g.akF().DMV, paramList));
    AppMethodBeat.o(189862);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189865);
    d.g.b.k.h(paramLiveConfig, "config");
    if (paramLiveConfig.aii() == LiveConfig.gmI) {}
    for (boolean bool = true;; bool = false)
    {
      dmG = bool;
      AppMethodBeat.o(189865);
      return;
    }
  }
  
  public static void alB()
  {
    AppMethodBeat.i(189846);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new m(l, g.akA(), true));
    AppMethodBeat.o(189846);
  }
  
  public static void alC()
  {
    AppMethodBeat.i(189849);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.a(l, g.akA()));
    AppMethodBeat.o(189849);
  }
  
  public static void alD()
  {
    AppMethodBeat.i(189855);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.b(l, g.akA()));
    AppMethodBeat.o(189855);
  }
  
  public static void alE()
  {
    AppMethodBeat.i(189864);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new e(l, g.akA()));
    AppMethodBeat.o(189864);
  }
  
  public static void ar(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189863);
    d.g.b.k.h(paramString1, "micId");
    d.g.b.k.h(paramString2, "sdkUid");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.k(l, g.akA(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2));
    AppMethodBeat.o(189863);
  }
  
  public static void dP(boolean paramBoolean)
  {
    AppMethodBeat.i(189856);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.i(l, g.akA(), paramBoolean));
    AppMethodBeat.o(189856);
  }
  
  public static void dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(189858);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new r(l, g.akA(), paramBoolean));
    AppMethodBeat.o(189858);
  }
  
  public static void nh(int paramInt)
  {
    AppMethodBeat.i(189848);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.q(l, g.akA(), paramInt));
    AppMethodBeat.o(189848);
  }
  
  public static void ni(int paramInt)
  {
    AppMethodBeat.i(189861);
    bqb localbqb = new bqb();
    localbqb.FeY = paramInt;
    localbqb.FeX = ce.azI();
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.g(g.akF().DMV, localbqb));
    AppMethodBeat.o(189861);
  }
  
  private static void pi(long paramLong)
  {
    AppMethodBeat.i(189844);
    com.tencent.mm.ac.c.C(gvu);
    com.tencent.mm.ac.c.a(paramLong, gvu);
    AppMethodBeat.o(189844);
  }
  
  public static void uW(String paramString)
  {
    AppMethodBeat.i(189854);
    d.g.b.k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.d(g.akF().DMV, paramString));
    AppMethodBeat.o(189854);
  }
  
  public static void uX(String paramString)
  {
    AppMethodBeat.i(189857);
    d.g.b.k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.u(g.akF().DMV, paramString));
    AppMethodBeat.o(189857);
  }
  
  public static void uY(String paramString)
  {
    AppMethodBeat.i(189859);
    d.g.b.k.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    long l = g.akF().DMV;
    localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new p(l, g.akA(), paramString));
    AppMethodBeat.o(189859);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189852);
    d.g.b.k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).agi();
    g localg = g.guG;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.c(g.akF().DMV, paramString, paramBoolean));
    AppMethodBeat.o(189852);
  }
  
  public final void alF()
  {
    AppMethodBeat.i(189866);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3767, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(589, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(189866);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    long l = 0L;
    Object localObject = null;
    paramString = null;
    AppMethodBeat.i(189868);
    if ((paramn instanceof m))
    {
      l = ((m)paramn).duration;
      paramString = f.h.gtJ;
      if (l > f.h.akv()) {}
      for (l = 0L;; l = f.h.akv())
      {
        ac.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m)paramn).duration + ", delay:" + l);
        pi(l);
        paramString = g.guG;
        paramString = g.guG;
        g.mW(g.akF().EQE);
        AppMethodBeat.o(189868);
        return;
        paramString = f.h.gtJ;
      }
    }
    if ((paramn instanceof o))
    {
      localObject = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).agi().b(3797, (com.tencent.mm.ak.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((o)paramn).gwy;
        if (paramn != null) {
          paramString = paramn.Fdh;
        }
        if (paramString != null)
        {
          paramn = g.guG;
          g.a(paramString);
          ac.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (dmG)
          {
            paramn = com.tencent.mm.live.core.core.a.b.gnC;
            paramn = ai.getContext();
            d.g.b.k.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.a.b.a.ct(paramn);
            localObject = paramString.Ffu.eQU();
            d.g.b.k.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.uw((String)localObject);
          }
          for (;;)
          {
            paramn = g.guG;
            paramn = g.akJ();
            if (paramn != null)
            {
              paramn = paramn.gnT;
              if (paramn != null) {
                paramn.privateMapKey = paramString.Ffu.eQU();
              }
            }
            paramString = g.guG;
            paramString = g.akG();
            if (paramString != null) {
              l = paramString.Ffy;
            }
            pj(h.aC((l - 60L) * 1000L, 60000L));
            AppMethodBeat.o(189868);
            return;
            paramn = com.tencent.mm.live.core.core.c.b.gqt;
            paramn = ai.getContext();
            d.g.b.k.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.c.b.a.cu(paramn);
            localObject = paramString.Ffu.eQU();
            d.g.b.k.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.uw((String)localObject);
          }
        }
      }
    }
    else if ((paramn instanceof t))
    {
      paramString = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(paramString, "MMKernel.network()");
      paramString.agi().b(760, (com.tencent.mm.ak.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((t)paramn).gwN;
        paramString = (String)localObject;
        if (paramn != null) {
          paramString = paramn.Fdh;
        }
        if (paramString != null)
        {
          paramn = g.guG;
          g.a(paramString);
          ac.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramn = com.tencent.mm.live.core.core.c.b.gqt;
          paramn = ai.getContext();
          d.g.b.k.g(paramn, "MMApplicationContext.getContext()");
          paramn = com.tencent.mm.live.core.core.c.b.a.cu(paramn);
          localObject = paramString.Ffu.eQU();
          d.g.b.k.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramn.uw((String)localObject);
          paramn = g.guG;
          paramn = g.akJ();
          if (paramn != null)
          {
            paramn = paramn.gnT;
            if (paramn != null) {
              paramn.privateMapKey = paramString.Ffu.eQU();
            }
          }
          paramString = g.guG;
          pk(h.aC((g.akK() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(189868);
        }
      }
    }
    else if ((paramn instanceof e))
    {
      paramString = ((e)paramn).gvU;
      if (paramString != null)
      {
        paramString = paramString.EQJ;
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
        paramString = (bqg)paramString.get(0);
        if (paramString == null) {
          break label856;
        }
        ac.i(TAG, "update live mic audienceInfo:[" + paramString.Ffi + ' ' + paramString.nickname + ']');
        paramn = g.guG;
        paramn = g.alq();
        localObject = g.guG;
        l = g.akF().DMV;
        localObject = paramString.DMY;
        d.g.b.k.g(localObject, "it.live_mic_id");
        String str1 = paramString.Ffi;
        d.g.b.k.g(str1, "it.identity_id");
        String str2 = paramString.oGh;
        d.g.b.k.g(str2, "it.head_img_url");
        String str3 = paramString.nickname;
        d.g.b.k.g(str3, "it.nickname");
        paramString = paramString.Ffe;
        d.g.b.k.g(paramString, "it.sdk_user_id");
        paramn.a(l, (String)localObject, str1, str2, str3, paramString);
        AppMethodBeat.o(189868);
        return;
        paramString = null;
        break;
      }
      label849:
      AppMethodBeat.o(189868);
      return;
    }
    label856:
    AppMethodBeat.o(189868);
  }
  
  public final void pj(long paramLong)
  {
    AppMethodBeat.i(189850);
    ac.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3797, (com.tencent.mm.ak.g)this);
    com.tencent.mm.ac.c.C(gvt);
    com.tencent.mm.ac.c.a(paramLong, gvt);
    AppMethodBeat.o(189850);
  }
  
  public final void pk(long paramLong)
  {
    AppMethodBeat.i(189860);
    ac.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(760, (com.tencent.mm.ak.g)this);
    com.tencent.mm.ac.c.C(gvv);
    com.tencent.mm.ac.c.a(paramLong, gvv);
    AppMethodBeat.o(189860);
  }
  
  public final void release()
  {
    AppMethodBeat.i(189867);
    com.tencent.mm.ac.c.C(gvt);
    com.tencent.mm.ac.c.C(gvu);
    com.tencent.mm.ac.c.C(gvv);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(3767, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(3797, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(760, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(589, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(189867);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a gvx;
    
    static
    {
      AppMethodBeat.i(189839);
      gvx = new a();
      AppMethodBeat.o(189839);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189838);
      Object localObject = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject, "MMKernel.network()");
      localObject = ((com.tencent.mm.kernel.b)localObject).agi();
      g localg = g.guG;
      long l = g.akF().DMV;
      localg = g.guG;
      ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new m(l, g.akA()));
      AppMethodBeat.o(189838);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b gvy;
    
    static
    {
      AppMethodBeat.i(189841);
      gvy = new b();
      AppMethodBeat.o(189841);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189840);
      Object localObject1 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject1, "MMKernel.network()");
      localObject1 = ((com.tencent.mm.kernel.b)localObject1).agi();
      Object localObject2 = g.guG;
      long l = g.akF().DMV;
      localObject2 = g.guG;
      localObject2 = g.akA();
      g localg = g.guG;
      ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new o(l, (String)localObject2, g.akE()));
      AppMethodBeat.o(189840);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c gvz;
    
    static
    {
      AppMethodBeat.i(189843);
      gvz = new c();
      AppMethodBeat.o(189843);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189842);
      Object localObject = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject, "MMKernel.network()");
      com.tencent.mm.ak.q localq = ((com.tencent.mm.kernel.b)localObject).agi();
      localObject = g.guG;
      long l = g.akF().DMV;
      localObject = g.guG;
      String str2 = g.akA();
      localObject = g.guG;
      localObject = g.alq().gxe;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).gxh;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localq.b((com.tencent.mm.ak.n)new t(l, str2, (String)localObject));
      AppMethodBeat.o(189842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */