package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.p;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.t;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "doGetLiveStateByRoom", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class h
  implements com.tencent.mm.al.g
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean aWl;
  private static final Runnable wJp;
  private static final Runnable wXm;
  static final Runnable xcd;
  public static final h xfu;
  
  static
  {
    AppMethodBeat.i(202678);
    xfu = new h();
    TAG = "MicroMsg.LiveRoomOperation";
    aWl = true;
    wJp = (Runnable)b.yZY;
    wXm = (Runnable)a.yIg;
    xcd = (Runnable)c.zaJ;
    AppMethodBeat.o(202678);
  }
  
  private static void Bg(long paramLong)
  {
    AppMethodBeat.i(202656);
    com.tencent.mm.ad.c.aW(wXm);
    com.tencent.mm.ad.c.c(paramLong, wXm);
    AppMethodBeat.o(202656);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202674);
    k.h(paramLiveConfig, "config");
    if (paramLiveConfig.ckz() == LiveConfig.qsH) {}
    for (boolean bool = true;; bool = false)
    {
      aWl = bool;
      AppMethodBeat.o(202674);
      return;
    }
  }
  
  public static void aUp(String paramString)
  {
    AppMethodBeat.i(202664);
    k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.c(f.eNG().LwA, paramString));
    AppMethodBeat.o(202664);
  }
  
  public static void aUq(String paramString)
  {
    AppMethodBeat.i(202665);
    k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.d(f.eNG().LwA, paramString));
    AppMethodBeat.o(202665);
  }
  
  public static void aUr(String paramString)
  {
    AppMethodBeat.i(202668);
    k.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new t(f.eNG().LwA, paramString));
    AppMethodBeat.o(202668);
  }
  
  public static void aUs(String paramString)
  {
    AppMethodBeat.i(202670);
    k.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new o(l, f.eNB(), paramString));
    AppMethodBeat.o(202670);
  }
  
  public static void agI(int paramInt)
  {
    AppMethodBeat.i(202660);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new p(l, f.eNB(), paramInt));
    AppMethodBeat.o(202660);
  }
  
  public static void agJ(int paramInt)
  {
    AppMethodBeat.i(202672);
    eaq localeaq = new eaq();
    localeaq.LyY = paramInt;
    localeaq.LyX = ce.asR();
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.f(f.eNG().LwA, localeaq));
    AppMethodBeat.o(202672);
  }
  
  public static void bG(List<String> paramList)
  {
    AppMethodBeat.i(202673);
    k.h(paramList, "userList");
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new m(f.eNG().LwA, paramList));
    AppMethodBeat.o(202673);
  }
  
  public static void fOF()
  {
    AppMethodBeat.i(202658);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.l(l, f.eNB(), true));
    AppMethodBeat.o(202658);
  }
  
  public static void fOG()
  {
    AppMethodBeat.i(202661);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.a(l, f.eNB()));
    AppMethodBeat.o(202661);
  }
  
  public static void fOH()
  {
    AppMethodBeat.i(202666);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.b(l, f.eNB()));
    AppMethodBeat.o(202666);
  }
  
  public static void gQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(202659);
    k.h(paramString, "content");
    Object localObject1 = u.aqG();
    k.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, ce.asT());
    Object localObject2 = f.rGw;
    f.eNE().add(localObject1);
    localObject1 = c.qYi;
    c.dRj();
    localObject1 = com.tencent.mm.kernel.g.afA();
    k.g(localObject1, "MMKernel.network()");
    com.tencent.mm.al.q localq = ((com.tencent.mm.kernel.b)localObject1).aeS();
    localObject1 = f.rGw;
    long l = f.eNG().LwA;
    localObject1 = f.rGw;
    localObject2 = f.eNF();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = f.rGw;
    localq.b((com.tencent.mm.al.n)new r(paramString, paramInt, l, (byte[])localObject1, f.eNB()));
    AppMethodBeat.o(202659);
  }
  
  public static void ng(boolean paramBoolean)
  {
    AppMethodBeat.i(202667);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.h(l, f.eNB(), paramBoolean));
    AppMethodBeat.o(202667);
  }
  
  public static void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(202669);
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
    f localf = f.rGw;
    long l = f.eNG().LwA;
    localf = f.rGw;
    ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.q(l, f.eNB(), paramBoolean));
    AppMethodBeat.o(202669);
  }
  
  public final void Bh(long paramLong)
  {
    AppMethodBeat.i(202662);
    ad.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3797, (com.tencent.mm.al.g)this);
    com.tencent.mm.ad.c.aW(wJp);
    com.tencent.mm.ad.c.c(paramLong, wJp);
    AppMethodBeat.o(202662);
  }
  
  public final void Bi(long paramLong)
  {
    AppMethodBeat.i(202671);
    ad.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(760, (com.tencent.mm.al.g)this);
    com.tencent.mm.ad.c.aW(xcd);
    com.tencent.mm.ad.c.c(paramLong, xcd);
    AppMethodBeat.o(202671);
  }
  
  public final void fOI()
  {
    AppMethodBeat.i(202675);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3767, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202675);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(202677);
    long l;
    if ((paramn instanceof com.tencent.mm.live.b.a.l))
    {
      l = ((com.tencent.mm.live.b.a.l)paramn).duration;
      paramString = e.h.rFD;
      if (l > e.h.eNw()) {}
      for (l = 0L;; l = e.h.eNw())
      {
        ad.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((com.tencent.mm.live.b.a.l)paramn).duration + ", delay:" + l);
        Bg(l);
        AppMethodBeat.o(202677);
        return;
        paramString = e.h.rFD;
      }
    }
    String str;
    if ((paramn instanceof com.tencent.mm.live.b.a.n))
    {
      paramString = com.tencent.mm.kernel.g.afA();
      k.g(paramString, "MMKernel.network()");
      paramString.aeS().b(3797, (com.tencent.mm.al.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.b.a.n)paramn).zcc;
        if (paramString != null)
        {
          paramString = paramString.LyW;
          if (paramString == null) {
            break label580;
          }
          paramn = f.rGw;
          f.a(paramString);
          ad.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (!aWl) {
            break label329;
          }
          paramn = com.tencent.mm.live.core.core.a.b.qym;
          paramn = aj.getContext();
          k.g(paramn, "MMApplicationContext.getContext()");
          paramn = com.tencent.mm.live.core.core.a.b.a.eG(paramn);
          str = paramString.Lzu.eBA();
          k.g(str, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramn.aTV(str);
          label240:
          paramn = f.rGw;
          paramn = f.eNK();
          if (paramn != null)
          {
            paramn = paramn.qzq;
            if (paramn != null) {
              paramn.privateMapKey = paramString.Lzu.eBA();
            }
          }
          paramString = f.rGw;
          paramString = f.eNH();
          if (paramString == null) {
            break label381;
          }
        }
        label329:
        label381:
        for (l = paramString.Lzy;; l = 0L)
        {
          Bh(d.k.h.aH((l - 60L) * 1000L, 60000L));
          AppMethodBeat.o(202677);
          return;
          paramString = null;
          break;
          paramn = com.tencent.mm.live.core.core.c.b.qOk;
          paramn = aj.getContext();
          k.g(paramn, "MMApplicationContext.getContext()");
          paramn = com.tencent.mm.live.core.core.c.b.a.eH(paramn);
          str = paramString.Lzu.eBA();
          k.g(str, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramn.aTV(str);
          break label240;
        }
      }
    }
    else if ((paramn instanceof s))
    {
      paramString = com.tencent.mm.kernel.g.afA();
      k.g(paramString, "MMKernel.network()");
      paramString.aeS().b(760, (com.tencent.mm.al.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((s)paramn).Agy;
        if (paramString == null) {
          break label587;
        }
      }
    }
    label580:
    label587:
    for (paramString = paramString.LyW;; paramString = null)
    {
      if (paramString != null)
      {
        paramn = f.rGw;
        f.a(paramString);
        ad.i(TAG, "doMicKeepAlive updatePrivateMapKey");
        paramn = com.tencent.mm.live.core.core.c.b.qOk;
        paramn = aj.getContext();
        k.g(paramn, "MMApplicationContext.getContext()");
        paramn = com.tencent.mm.live.core.core.c.b.a.eH(paramn);
        str = paramString.Lzu.eBA();
        k.g(str, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
        paramn.aTV(str);
        paramn = f.rGw;
        paramn = f.eNK();
        if (paramn != null)
        {
          paramn = paramn.qzq;
          if (paramn != null) {
            paramn.privateMapKey = paramString.Lzu.eBA();
          }
        }
        paramString = f.rGw;
        Bi(d.k.h.aH((f.eNL() - 60L) * 1000L, 60000L));
      }
      AppMethodBeat.o(202677);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(202676);
    com.tencent.mm.ad.c.aW(wJp);
    com.tencent.mm.ad.c.aW(wXm);
    com.tencent.mm.ad.c.aW(xcd);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3767, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3797, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(760, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202676);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a yIg;
    
    static
    {
      AppMethodBeat.i(202651);
      yIg = new a();
      AppMethodBeat.o(202651);
    }
    
    public final void run()
    {
      AppMethodBeat.i(202650);
      Object localObject = com.tencent.mm.kernel.g.afA();
      k.g(localObject, "MMKernel.network()");
      localObject = ((com.tencent.mm.kernel.b)localObject).aeS();
      f localf = f.rGw;
      long l = f.eNG().LwA;
      localf = f.rGw;
      ((com.tencent.mm.al.q)localObject).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.l(l, f.eNB()));
      AppMethodBeat.o(202650);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b yZY;
    
    static
    {
      AppMethodBeat.i(202653);
      yZY = new b();
      AppMethodBeat.o(202653);
    }
    
    public final void run()
    {
      AppMethodBeat.i(202652);
      Object localObject1 = com.tencent.mm.kernel.g.afA();
      k.g(localObject1, "MMKernel.network()");
      localObject1 = ((com.tencent.mm.kernel.b)localObject1).aeS();
      Object localObject2 = f.rGw;
      long l = f.eNG().LwA;
      localObject2 = f.rGw;
      localObject2 = f.eNB();
      f localf = f.rGw;
      ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new com.tencent.mm.live.b.a.n(l, (String)localObject2, f.eNF()));
      AppMethodBeat.o(202652);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c zaJ;
    
    static
    {
      AppMethodBeat.i(202655);
      zaJ = new c();
      AppMethodBeat.o(202655);
    }
    
    public final void run()
    {
      AppMethodBeat.i(202654);
      Object localObject = com.tencent.mm.kernel.g.afA();
      k.g(localObject, "MMKernel.network()");
      com.tencent.mm.al.q localq = ((com.tencent.mm.kernel.b)localObject).aeS();
      localObject = f.rGw;
      long l = f.eNG().LwA;
      localObject = f.rGw;
      String str2 = f.eNB();
      localObject = f.rGw;
      localObject = f.fOz().BMx;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).BQP;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localq.b((com.tencent.mm.al.n)new s(l, str2, (String)localObject));
      AppMethodBeat.o(202654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */