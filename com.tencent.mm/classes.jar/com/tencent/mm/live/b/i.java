package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.t;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.k.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "cutLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class i
  implements f
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean dzz;
  private static final Runnable gRM;
  private static final Runnable gRN;
  static final Runnable gRO;
  public static final i gRP;
  
  static
  {
    AppMethodBeat.i(215775);
    gRP = new i();
    TAG = "MicroMsg.LiveRoomOperation";
    dzz = true;
    gRM = (Runnable)b.gRR;
    gRN = (Runnable)i.a.gRQ;
    gRO = (Runnable)c.gRS;
    AppMethodBeat.o(215775);
  }
  
  public static void Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(215752);
    d.g.b.p.h(paramString, "content");
    Object localObject1 = v.aAC();
    d.g.b.p.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, ch.aDd());
    Object localObject2 = g.gQZ;
    g.anF().add(localObject1);
    localObject1 = c.gPx;
    c.and();
    localObject1 = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject1, "MMKernel.network()");
    com.tencent.mm.ak.q localq = ((com.tencent.mm.kernel.b)localObject1).ajj();
    localObject1 = g.gQZ;
    long l = g.anH().FKy;
    localObject1 = g.gQZ;
    localObject2 = g.anG();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = g.gQZ;
    localq.b((com.tencent.mm.ak.n)new s(paramString, paramInt, l, (byte[])localObject1, g.anC()));
    AppMethodBeat.o(215752);
  }
  
  public static void Y(List<String> paramList)
  {
    AppMethodBeat.i(215768);
    d.g.b.p.h(paramList, "userList");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.n(g.anH().FKy, paramList));
    AppMethodBeat.o(215768);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215771);
    d.g.b.p.h(paramLiveConfig, "config");
    if (paramLiveConfig.alj() == LiveConfig.gJa) {}
    for (boolean bool = true;; bool = false)
    {
      dzz = bool;
      AppMethodBeat.o(215771);
      return;
    }
  }
  
  public static void aoD()
  {
    AppMethodBeat.i(215751);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new m(l, g.anC(), true));
    AppMethodBeat.o(215751);
  }
  
  public static void aoF()
  {
    AppMethodBeat.i(215761);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.b(l, g.anC()));
    AppMethodBeat.o(215761);
  }
  
  public static void aoG()
  {
    AppMethodBeat.i(215770);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new e(l, g.anC()));
    AppMethodBeat.o(215770);
  }
  
  public static void at(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215769);
    d.g.b.p.h(paramString1, "micId");
    d.g.b.p.h(paramString2, "sdkUid");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new k(l, g.anC(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2));
    AppMethodBeat.o(215769);
  }
  
  public static void dS(boolean paramBoolean)
  {
    AppMethodBeat.i(215754);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.a(l, g.anC(), paramBoolean));
    AppMethodBeat.o(215754);
  }
  
  public static void dT(boolean paramBoolean)
  {
    AppMethodBeat.i(215762);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.i(l, g.anC(), paramBoolean));
    AppMethodBeat.o(215762);
  }
  
  public static void dU(boolean paramBoolean)
  {
    AppMethodBeat.i(215764);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new r(l, g.anC(), paramBoolean));
    AppMethodBeat.o(215764);
  }
  
  public static void nJ(int paramInt)
  {
    AppMethodBeat.i(215753);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.q(l, g.anC(), paramInt));
    AppMethodBeat.o(215753);
  }
  
  public static void nK(int paramInt)
  {
    AppMethodBeat.i(215767);
    bvi localbvi = new bvi();
    localbvi.Hic = paramInt;
    localbvi.Hib = ch.aDb();
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.g(g.anH().FKy, localbvi));
    AppMethodBeat.o(215767);
  }
  
  private static void rw(long paramLong)
  {
    AppMethodBeat.i(215749);
    com.tencent.mm.ac.c.z(gRN);
    com.tencent.mm.ac.c.a(paramLong, gRN);
    AppMethodBeat.o(215749);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215758);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.c(g.anH().FKy, paramString, paramBoolean));
    AppMethodBeat.o(215758);
  }
  
  public static void yv(String paramString)
  {
    AppMethodBeat.i(215760);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.d(g.anH().FKy, paramString));
    AppMethodBeat.o(215760);
  }
  
  public static void yw(String paramString)
  {
    AppMethodBeat.i(215763);
    d.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new u(g.anH().FKy, paramString));
    AppMethodBeat.o(215763);
  }
  
  public static void yx(String paramString)
  {
    AppMethodBeat.i(215765);
    d.g.b.p.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).ajj();
    g localg = g.gQZ;
    long l = g.anH().FKy;
    localg = g.gQZ;
    ((com.tencent.mm.ak.q)localObject).b((com.tencent.mm.ak.n)new com.tencent.mm.live.b.a.p(l, g.anC(), paramString));
    AppMethodBeat.o(215765);
  }
  
  public final void aoH()
  {
    AppMethodBeat.i(215772);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(3767, (f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(589, (f)this);
    AppMethodBeat.o(215772);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    long l = 0L;
    Object localObject = null;
    paramString = null;
    AppMethodBeat.i(215774);
    if ((paramn instanceof m))
    {
      l = ((m)paramn).duration;
      paramString = f.h.gQd;
      if (l > f.h.anx()) {}
      for (l = 0L;; l = f.h.anx())
      {
        ae.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m)paramn).duration + ", delay:" + l);
        rw(l);
        paramString = g.gQZ;
        paramString = g.gQZ;
        g.ny(g.anH().GTv);
        AppMethodBeat.o(215774);
        return;
        paramString = f.h.gQd;
      }
    }
    if ((paramn instanceof o))
    {
      localObject = com.tencent.mm.kernel.g.ajQ();
      d.g.b.p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).ajj().b(3797, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((o)paramn).gSR;
        if (paramn != null) {
          paramString = paramn.Hgi;
        }
        if (paramString != null)
        {
          paramn = g.gQZ;
          g.a(paramString);
          ae.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (dzz)
          {
            paramn = com.tencent.mm.live.core.core.a.b.gJU;
            paramn = ak.getContext();
            d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.a.b.a.cs(paramn);
            localObject = paramString.HiA.fjO();
            d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.xV((String)localObject);
          }
          for (;;)
          {
            paramn = g.gQZ;
            paramn = g.anL();
            if (paramn != null)
            {
              paramn = paramn.gKl;
              if (paramn != null) {
                paramn.privateMapKey = paramString.HiA.fjO();
              }
            }
            paramString = g.gQZ;
            paramString = g.anI();
            if (paramString != null) {
              l = paramString.HiE;
            }
            rx(j.aG((l - 60L) * 1000L, 60000L));
            AppMethodBeat.o(215774);
            return;
            paramn = com.tencent.mm.live.core.core.c.b.gMM;
            paramn = ak.getContext();
            d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
            paramn = com.tencent.mm.live.core.core.c.b.a.ct(paramn);
            localObject = paramString.HiA.fjO();
            d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramn.xV((String)localObject);
          }
        }
      }
    }
    else if ((paramn instanceof t))
    {
      paramString = com.tencent.mm.kernel.g.ajQ();
      d.g.b.p.g(paramString, "MMKernel.network()");
      paramString.ajj().b(760, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((t)paramn).gTg;
        paramString = (String)localObject;
        if (paramn != null) {
          paramString = paramn.Hgi;
        }
        if (paramString != null)
        {
          paramn = g.gQZ;
          g.a(paramString);
          ae.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramn = com.tencent.mm.live.core.core.c.b.gMM;
          paramn = ak.getContext();
          d.g.b.p.g(paramn, "MMApplicationContext.getContext()");
          paramn = com.tencent.mm.live.core.core.c.b.a.ct(paramn);
          localObject = paramString.HiA.fjO();
          d.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramn.xV((String)localObject);
          paramn = g.gQZ;
          paramn = g.anL();
          if (paramn != null)
          {
            paramn = paramn.gKl;
            if (paramn != null) {
              paramn.privateMapKey = paramString.HiA.fjO();
            }
          }
          paramString = g.gQZ;
          ry(j.aG((g.anM() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(215774);
        }
      }
    }
    else if ((paramn instanceof e))
    {
      paramString = ((e)paramn).gSn;
      if (paramString != null)
      {
        paramString = paramString.GTA;
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
        paramString = (bvn)paramString.get(0);
        if (paramString == null) {
          break label856;
        }
        ae.i(TAG, "update live mic audienceInfo:[" + paramString.Hio + ' ' + paramString.nickname + ']');
        paramn = g.gQZ;
        paramn = g.aos();
        localObject = g.gQZ;
        l = g.anH().FKy;
        localObject = paramString.FKB;
        d.g.b.p.g(localObject, "it.live_mic_id");
        String str1 = paramString.Hio;
        d.g.b.p.g(str1, "it.identity_id");
        String str2 = paramString.pqq;
        d.g.b.p.g(str2, "it.head_img_url");
        String str3 = paramString.nickname;
        d.g.b.p.g(str3, "it.nickname");
        paramString = paramString.Hii;
        d.g.b.p.g(paramString, "it.sdk_user_id");
        paramn.a(l, (String)localObject, str1, str2, str3, paramString);
        AppMethodBeat.o(215774);
        return;
        paramString = null;
        break;
      }
      label849:
      AppMethodBeat.o(215774);
      return;
    }
    label856:
    AppMethodBeat.o(215774);
  }
  
  public final void release()
  {
    AppMethodBeat.i(215773);
    com.tencent.mm.ac.c.z(gRM);
    com.tencent.mm.ac.c.z(gRN);
    com.tencent.mm.ac.c.z(gRO);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b(3767, (f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b(3797, (f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b(760, (f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b(589, (f)this);
    AppMethodBeat.o(215773);
  }
  
  public final void rx(long paramLong)
  {
    AppMethodBeat.i(215756);
    ae.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(3797, (f)this);
    com.tencent.mm.ac.c.z(gRM);
    com.tencent.mm.ac.c.a(paramLong, gRM);
    AppMethodBeat.o(215756);
  }
  
  public final void ry(long paramLong)
  {
    AppMethodBeat.i(215766);
    ae.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(760, (f)this);
    com.tencent.mm.ac.c.z(gRO);
    com.tencent.mm.ac.c.a(paramLong, gRO);
    AppMethodBeat.o(215766);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b gRR;
    
    static
    {
      AppMethodBeat.i(215746);
      gRR = new b();
      AppMethodBeat.o(215746);
    }
    
    public final void run()
    {
      AppMethodBeat.i(215745);
      Object localObject1 = com.tencent.mm.kernel.g.ajQ();
      d.g.b.p.g(localObject1, "MMKernel.network()");
      localObject1 = ((com.tencent.mm.kernel.b)localObject1).ajj();
      Object localObject2 = g.gQZ;
      long l = g.anH().FKy;
      localObject2 = g.gQZ;
      localObject2 = g.anC();
      g localg = g.gQZ;
      ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new o(l, (String)localObject2, g.anG()));
      AppMethodBeat.o(215745);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c gRS;
    
    static
    {
      AppMethodBeat.i(215748);
      gRS = new c();
      AppMethodBeat.o(215748);
    }
    
    public final void run()
    {
      AppMethodBeat.i(215747);
      Object localObject = com.tencent.mm.kernel.g.ajQ();
      d.g.b.p.g(localObject, "MMKernel.network()");
      com.tencent.mm.ak.q localq = ((com.tencent.mm.kernel.b)localObject).ajj();
      localObject = g.gQZ;
      long l = g.anH().FKy;
      localObject = g.gQZ;
      String str2 = g.anC();
      localObject = g.gQZ;
      localObject = g.aos().gTx;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).gTA;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localq.b((com.tencent.mm.ak.n)new t(l, str2, (String)localObject));
      AppMethodBeat.o(215747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */