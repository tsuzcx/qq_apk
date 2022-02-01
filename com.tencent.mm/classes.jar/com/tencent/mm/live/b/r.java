package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.c;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.a.n;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "cutLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class r
  implements com.tencent.mm.ak.i
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean dMz;
  private static final Runnable hId;
  private static final Runnable hIe;
  public static final Runnable hIf;
  public static final r hIg;
  
  static
  {
    AppMethodBeat.i(207688);
    hIg = new r();
    TAG = "MicroMsg.LiveRoomOperation";
    dMz = true;
    hId = (Runnable)b.hIi;
    hIe = (Runnable)r.a.hIh;
    hIf = (Runnable)c.hIj;
    AppMethodBeat.o(207688);
  }
  
  public static void GN(String paramString)
  {
    AppMethodBeat.i(207673);
    kotlin.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.d(x.aGr().hyH, paramString));
    AppMethodBeat.o(207673);
  }
  
  public static void GO(String paramString)
  {
    AppMethodBeat.i(207676);
    kotlin.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new u(x.aGr().hyH, paramString));
    AppMethodBeat.o(207676);
  }
  
  public static void GP(String paramString)
  {
    AppMethodBeat.i(207678);
    kotlin.g.b.p.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.p(l, x.aGm(), paramString));
    AppMethodBeat.o(207678);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207684);
    kotlin.g.b.p.h(paramLiveConfig, "config");
    if (paramLiveConfig.aBC() == LiveConfig.hvT) {}
    for (boolean bool = true;; bool = false)
    {
      dMz = bool;
      AppMethodBeat.o(207684);
      return;
    }
  }
  
  public static void aFZ()
  {
    AppMethodBeat.i(207664);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.m(l, x.aGm(), true));
    AppMethodBeat.o(207664);
  }
  
  public static void aGb()
  {
    AppMethodBeat.i(207674);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.b(l, x.aGm()));
    AppMethodBeat.o(207674);
  }
  
  public static void aGc()
  {
    AppMethodBeat.i(207683);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new e(l, x.aGm()));
    AppMethodBeat.o(207683);
  }
  
  public static void aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(207665);
    kotlin.g.b.p.h(paramString, "content");
    Object localObject1 = z.aTY();
    kotlin.g.b.p.g(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, cl.aWB());
    Object localObject2 = x.hJf;
    x.aGp().add(localObject1);
    localObject1 = m.hGg;
    m.aFe();
    localObject1 = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject1, "MMKernel.network()");
    com.tencent.mm.ak.t localt = ((com.tencent.mm.kernel.b)localObject1).azz();
    localObject1 = x.hJf;
    long l = x.aGr().hyH;
    localObject1 = x.hJf;
    localObject2 = x.aGq();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = x.hJf;
    localt.b((com.tencent.mm.ak.q)new s(paramString, paramInt, l, (byte[])localObject1, x.aGm()));
    AppMethodBeat.o(207665);
  }
  
  public static void ag(List<String> paramList)
  {
    AppMethodBeat.i(207681);
    kotlin.g.b.p.h(paramList, "userList");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new n(x.aGr().hyH, paramList));
    AppMethodBeat.o(207681);
  }
  
  public static void aw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207682);
    kotlin.g.b.p.h(paramString1, "micId");
    kotlin.g.b.p.h(paramString2, "sdkUid");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new k(l, x.aGm(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2));
    AppMethodBeat.o(207682);
  }
  
  public static void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(207667);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.a(l, x.aGm(), paramBoolean));
    AppMethodBeat.o(207667);
  }
  
  public static void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(207675);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.i(l, x.aGm(), paramBoolean));
    AppMethodBeat.o(207675);
  }
  
  public static void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(207677);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.r(l, x.aGm(), paramBoolean));
    AppMethodBeat.o(207677);
  }
  
  public static void qR(int paramInt)
  {
    AppMethodBeat.i(207666);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    long l = x.aGr().hyH;
    localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.q(l, x.aGm(), paramInt));
    AppMethodBeat.o(207666);
  }
  
  public static void qS(int paramInt)
  {
    AppMethodBeat.i(207680);
    ciq localciq = new ciq();
    localciq.MnE = paramInt;
    localciq.MnD = cl.aWz();
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.g(x.aGr().hyH, localciq));
    AppMethodBeat.o(207680);
  }
  
  public static void z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207671);
    kotlin.g.b.p.h(paramString, "wechatRoomId");
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.b)localObject).azz();
    x localx = x.hJf;
    ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)new c(x.aGr().hyH, paramString, paramBoolean));
    AppMethodBeat.o(207671);
  }
  
  private static void zy(long paramLong)
  {
    AppMethodBeat.i(207662);
    com.tencent.mm.ac.d.C(hIe);
    com.tencent.mm.ac.d.a(paramLong, hIe);
    AppMethodBeat.o(207662);
  }
  
  public final void aGd()
  {
    AppMethodBeat.i(207685);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(3767, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(589, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(207685);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    long l = 0L;
    Object localObject = null;
    paramString = null;
    AppMethodBeat.i(207687);
    if ((paramq instanceof com.tencent.mm.live.b.a.m))
    {
      l = ((com.tencent.mm.live.b.a.m)paramq).duration;
      paramString = o.i.hHg;
      if (l > o.i.aFJ()) {}
      for (l = 0L;; l = o.i.aFJ())
      {
        Log.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((com.tencent.mm.live.b.a.m)paramq).duration + ", delay:" + l);
        zy(l);
        paramString = x.hJf;
        paramString = x.hJf;
        x.qU(x.aGr().LIa);
        AppMethodBeat.o(207687);
        return;
        paramString = o.i.hHg;
      }
    }
    if ((paramq instanceof o))
    {
      localObject = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).azz().b(3797, (com.tencent.mm.ak.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((o)paramq).hKo;
        if (paramq != null) {
          paramString = paramq.LFH;
        }
        if (paramString != null)
        {
          paramq = x.hJf;
          x.a(paramString);
          Log.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (dMz)
          {
            paramq = com.tencent.mm.live.core.core.a.b.hyv;
            MMApplicationContext.getContext();
            paramq = com.tencent.mm.live.core.core.a.b.a.aDo();
            localObject = paramString.Mon.yO();
            kotlin.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramq.Go((String)localObject);
          }
          for (;;)
          {
            paramq = x.hJf;
            paramq = x.aGv();
            if (paramq != null)
            {
              paramq = paramq.hzu;
              if (paramq != null) {
                paramq.privateMapKey = paramString.Mon.yO();
              }
            }
            paramString = x.hJf;
            paramString = x.aGs();
            if (paramString != null) {
              l = paramString.Mor;
            }
            zz(j.aM((l - 60L) * 1000L, 60000L));
            AppMethodBeat.o(207687);
            return;
            paramq = com.tencent.mm.live.core.core.d.b.hCo;
            MMApplicationContext.getContext();
            paramq = com.tencent.mm.live.core.core.d.b.a.aEf();
            localObject = paramString.Mon.yO();
            kotlin.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramq.Go((String)localObject);
          }
        }
      }
    }
    else if ((paramq instanceof com.tencent.mm.live.b.a.t))
    {
      paramString = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(paramString, "MMKernel.network()");
      paramString.azz().b(760, (com.tencent.mm.ak.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((com.tencent.mm.live.b.a.t)paramq).hKD;
        paramString = (String)localObject;
        if (paramq != null) {
          paramString = paramq.LFH;
        }
        if (paramString != null)
        {
          paramq = x.hJf;
          x.a(paramString);
          Log.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramq = com.tencent.mm.live.core.core.d.b.hCo;
          MMApplicationContext.getContext();
          paramq = com.tencent.mm.live.core.core.d.b.a.aEf();
          localObject = paramString.Mon.yO();
          kotlin.g.b.p.g(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramq.Go((String)localObject);
          paramq = x.hJf;
          paramq = x.aGv();
          if (paramq != null)
          {
            paramq = paramq.hzu;
            if (paramq != null) {
              paramq.privateMapKey = paramString.Mon.yO();
            }
          }
          paramString = x.hJf;
          zA(j.aM((x.aGw() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(207687);
        }
      }
    }
    else if ((paramq instanceof e))
    {
      paramString = ((e)paramq).hJK;
      if (paramString != null)
      {
        paramString = paramString.LXJ;
        paramString = (List)paramString;
        if (paramString == null) {
          break label816;
        }
        if (((Collection)paramString).isEmpty()) {
          break label811;
        }
      }
      label811:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 1) {
          break label823;
        }
        paramString = (ciy)paramString.get(0);
        if (paramString == null) {
          break label823;
        }
        Log.i(TAG, "update live mic audienceInfo:[" + paramString.MnR + ' ' + paramString.nickname + ']');
        paramq = x.hJf;
        paramq = x.aHa();
        localObject = x.hJf;
        l = x.aGr().hyH;
        localObject = paramString.KDS;
        kotlin.g.b.p.g(localObject, "it.live_mic_id");
        String str1 = paramString.MnR;
        kotlin.g.b.p.g(str1, "it.identity_id");
        String str2 = paramString.qFV;
        kotlin.g.b.p.g(str2, "it.head_img_url");
        String str3 = paramString.nickname;
        kotlin.g.b.p.g(str3, "it.nickname");
        paramString = paramString.MnL;
        kotlin.g.b.p.g(paramString, "it.sdk_user_id");
        paramq.a(l, (String)localObject, str1, str2, str3, paramString);
        AppMethodBeat.o(207687);
        return;
        paramString = null;
        break;
      }
      label816:
      AppMethodBeat.o(207687);
      return;
    }
    label823:
    AppMethodBeat.o(207687);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207686);
    com.tencent.mm.ac.d.C(hId);
    com.tencent.mm.ac.d.C(hIe);
    com.tencent.mm.ac.d.C(hIf);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(3767, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(3797, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(760, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(589, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(207686);
  }
  
  public final void zA(long paramLong)
  {
    AppMethodBeat.i(207679);
    Log.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(760, (com.tencent.mm.ak.i)this);
    com.tencent.mm.ac.d.C(hIf);
    com.tencent.mm.ac.d.a(paramLong, hIf);
    AppMethodBeat.o(207679);
  }
  
  public final void zz(long paramLong)
  {
    AppMethodBeat.i(207669);
    Log.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(3797, (com.tencent.mm.ak.i)this);
    com.tencent.mm.ac.d.C(hId);
    com.tencent.mm.ac.d.a(paramLong, hId);
    AppMethodBeat.o(207669);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b hIi;
    
    static
    {
      AppMethodBeat.i(207659);
      hIi = new b();
      AppMethodBeat.o(207659);
    }
    
    public final void run()
    {
      AppMethodBeat.i(207658);
      Object localObject1 = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(localObject1, "MMKernel.network()");
      localObject1 = ((com.tencent.mm.kernel.b)localObject1).azz();
      Object localObject2 = x.hJf;
      long l = x.aGr().hyH;
      localObject2 = x.hJf;
      localObject2 = x.aGm();
      x localx = x.hJf;
      ((com.tencent.mm.ak.t)localObject1).b((com.tencent.mm.ak.q)new o(l, (String)localObject2, x.aGq()));
      AppMethodBeat.o(207658);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c hIj;
    
    static
    {
      AppMethodBeat.i(207661);
      hIj = new c();
      AppMethodBeat.o(207661);
    }
    
    public final void run()
    {
      AppMethodBeat.i(207660);
      Object localObject = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(localObject, "MMKernel.network()");
      com.tencent.mm.ak.t localt = ((com.tencent.mm.kernel.b)localObject).azz();
      localObject = x.hJf;
      long l = x.aGr().hyH;
      localObject = x.hJf;
      String str2 = x.aGm();
      localObject = x.hJf;
      localObject = x.aHa().hKU;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).hFz;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localt.b((com.tencent.mm.ak.q)new com.tencent.mm.live.b.a.t(l, str2, (String)localObject));
      AppMethodBeat.o(207660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.r
 * JD-Core Version:    0.7.0.1
 */