package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.n;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "cutLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class o
  implements com.tencent.mm.an.i
{
  private static final String TAG = "MicroMsg.LiveRoomOperation";
  private static boolean fFE;
  public static final o kvA;
  private static final Runnable kvx;
  private static final Runnable kvy;
  public static final Runnable kvz;
  
  static
  {
    AppMethodBeat.i(201082);
    kvA = new o();
    TAG = "MicroMsg.LiveRoomOperation";
    fFE = true;
    kvx = (Runnable)o.b.kvC;
    kvy = (Runnable)o.a.kvB;
    kvz = (Runnable)c.kvD;
    AppMethodBeat.o(201082);
  }
  
  public static void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(201034);
    kotlin.g.b.p.k(paramString, "wechatRoomId");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.c(u.aOr().klE, paramString, paramBoolean));
    AppMethodBeat.o(201034);
  }
  
  private static void FF(long paramLong)
  {
    AppMethodBeat.i(201009);
    com.tencent.mm.ae.d.C(kvy);
    com.tencent.mm.ae.d.a(paramLong, kvy);
    AppMethodBeat.o(201009);
  }
  
  public static void NY(String paramString)
  {
    AppMethodBeat.i(201037);
    kotlin.g.b.p.k(paramString, "wechatRoomId");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.d(u.aOr().klE, paramString));
    AppMethodBeat.o(201037);
  }
  
  public static void NZ(String paramString)
  {
    AppMethodBeat.i(201043);
    kotlin.g.b.p.k(paramString, "wechatRoomId");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.u(u.aOr().klE, paramString));
    AppMethodBeat.o(201043);
  }
  
  public static void Oa(String paramString)
  {
    AppMethodBeat.i(201047);
    kotlin.g.b.p.k(paramString, "username");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.p(l, u.aOm(), paramString));
    AppMethodBeat.o(201047);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(201059);
    kotlin.g.b.p.k(paramLiveConfig, "config");
    if (paramLiveConfig.aJf() == LiveConfig.khW) {}
    for (boolean bool = true;; bool = false)
    {
      fFE = bool;
      AppMethodBeat.o(201059);
      return;
    }
  }
  
  public static void aNZ()
  {
    AppMethodBeat.i(201014);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new m(l, u.aOm(), true));
    AppMethodBeat.o(201014);
  }
  
  public static void aOb()
  {
    AppMethodBeat.i(201039);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.b(l, u.aOm()));
    AppMethodBeat.o(201039);
  }
  
  public static void aOc()
  {
    AppMethodBeat.i(201056);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new e(l, u.aOm()));
    AppMethodBeat.o(201056);
  }
  
  public static void ae(List<String> paramList)
  {
    AppMethodBeat.i(201053);
    kotlin.g.b.p.k(paramList, "userList");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new n(u.aOr().klE, paramList));
    AppMethodBeat.o(201053);
  }
  
  public static void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(201018);
    kotlin.g.b.p.k(paramString, "content");
    Object localObject1 = z.bcZ();
    kotlin.g.b.p.j(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, cm.bfF());
    Object localObject2 = u.kwz;
    u.aOp().add(localObject1);
    localObject1 = j.kue;
    j.aNv();
    localObject1 = h.aHF();
    kotlin.g.b.p.j(localObject1, "MMKernel.network()");
    com.tencent.mm.an.t localt = ((com.tencent.mm.kernel.c)localObject1).aGY();
    localObject1 = u.kwz;
    long l = u.aOr().klE;
    localObject1 = u.kwz;
    localObject2 = u.aOq();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = u.kwz;
    localt.b((com.tencent.mm.an.q)new s(paramString, paramInt, l, (byte[])localObject1, u.aOm()));
    AppMethodBeat.o(201018);
  }
  
  public static void az(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201055);
    kotlin.g.b.p.k(paramString1, "micId");
    kotlin.g.b.p.k(paramString2, "sdkUid");
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new k(l, u.aOm(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2));
    AppMethodBeat.o(201055);
  }
  
  public static void fk(boolean paramBoolean)
  {
    AppMethodBeat.i(201027);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.a(l, u.aOm(), paramBoolean));
    AppMethodBeat.o(201027);
  }
  
  public static void fl(boolean paramBoolean)
  {
    AppMethodBeat.i(201041);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.i(l, u.aOm(), paramBoolean));
    AppMethodBeat.o(201041);
  }
  
  public static void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(201044);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new r(l, u.aOm(), paramBoolean));
    AppMethodBeat.o(201044);
  }
  
  public static void tG(int paramInt)
  {
    AppMethodBeat.i(201024);
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    long l = u.aOr().klE;
    localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.q(l, u.aOm(), paramInt));
    AppMethodBeat.o(201024);
  }
  
  public static void tH(int paramInt)
  {
    AppMethodBeat.i(201051);
    crm localcrm = new crm();
    localcrm.Tyz = paramInt;
    localcrm.Tyy = cm.bfD();
    Object localObject = h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
    u localu = u.kwz;
    ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.g(u.aOr().klE, localcrm));
    AppMethodBeat.o(201051);
  }
  
  public final void FG(long paramLong)
  {
    AppMethodBeat.i(201030);
    Log.i(TAG, "doKeepAlive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.c localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(3797, (com.tencent.mm.an.i)this);
    com.tencent.mm.ae.d.C(kvx);
    com.tencent.mm.ae.d.a(paramLong, kvx);
    AppMethodBeat.o(201030);
  }
  
  public final void FH(long paramLong)
  {
    AppMethodBeat.i(201050);
    Log.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.c localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(760, (com.tencent.mm.an.i)this);
    com.tencent.mm.ae.d.C(kvz);
    com.tencent.mm.ae.d.a(paramLong, kvz);
    AppMethodBeat.o(201050);
  }
  
  public final void aOd()
  {
    AppMethodBeat.i(201063);
    com.tencent.mm.kernel.c localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(3767, (com.tencent.mm.an.i)this);
    localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(589, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(201063);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    long l = 0L;
    Object localObject = null;
    paramString = null;
    AppMethodBeat.i(201080);
    if ((paramq instanceof m))
    {
      l = ((m)paramq).duration;
      paramString = l.h.kuL;
      if (l > l.h.aNQ()) {}
      for (l = 0L;; l = l.h.aNQ())
      {
        Log.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m)paramq).duration + ", delay:" + l);
        FF(l);
        paramString = u.kwz;
        paramString = u.kwz;
        u.tJ(u.aOr().SOs);
        AppMethodBeat.o(201080);
        return;
        paramString = l.h.kuL;
      }
    }
    if ((paramq instanceof com.tencent.mm.live.b.a.o))
    {
      localObject = h.aHF();
      kotlin.g.b.p.j(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject).aGY().b(3797, (com.tencent.mm.an.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((com.tencent.mm.live.b.a.o)paramq).kxI;
        if (paramq != null) {
          paramString = paramq.SJL;
        }
        if (paramString != null)
        {
          paramq = u.kwz;
          u.a(paramString);
          Log.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (fFE)
          {
            paramq = com.tencent.mm.live.core.core.a.b.klq;
            paramq = b.b.aLh();
            localObject = paramString.Tzn.Ap();
            kotlin.g.b.p.j(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramq.Nv((String)localObject);
          }
          for (;;)
          {
            paramq = u.kwz;
            paramq = u.aOv();
            if (paramq != null)
            {
              paramq = paramq.kmq;
              if (paramq != null) {
                paramq.privateMapKey = paramString.Tzn.Ap();
              }
            }
            paramString = u.kwz;
            paramString = u.aOs();
            if (paramString != null) {
              l = paramString.Tzr;
            }
            FG(kotlin.k.i.be((l - 60L) * 1000L, 60000L));
            AppMethodBeat.o(201080);
            return;
            paramq = com.tencent.mm.live.core.core.c.c.kqq;
            paramq = c.a.aMm();
            localObject = paramString.Tzn.Ap();
            kotlin.g.b.p.j(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramq.Nv((String)localObject);
          }
        }
      }
    }
    else if ((paramq instanceof com.tencent.mm.live.b.a.t))
    {
      paramString = h.aHF();
      kotlin.g.b.p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(760, (com.tencent.mm.an.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((com.tencent.mm.live.b.a.t)paramq).kxX;
        paramString = (String)localObject;
        if (paramq != null) {
          paramString = paramq.SJL;
        }
        if (paramString != null)
        {
          paramq = u.kwz;
          u.a(paramString);
          Log.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramq = com.tencent.mm.live.core.core.c.c.kqq;
          paramq = c.a.aMm();
          localObject = paramString.Tzn.Ap();
          kotlin.g.b.p.j(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramq.Nv((String)localObject);
          paramq = u.kwz;
          paramq = u.aOv();
          if (paramq != null)
          {
            paramq = paramq.kmq;
            if (paramq != null) {
              paramq.privateMapKey = paramString.Tzn.Ap();
            }
          }
          paramString = u.kwz;
          FH(kotlin.k.i.be((u.aOw() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(201080);
        }
      }
    }
    else if ((paramq instanceof e))
    {
      paramString = ((e)paramq).kxe;
      if (paramString != null)
      {
        paramString = paramString.Tha;
        paramString = (List)paramString;
        if (paramString == null) {
          break label804;
        }
        if (((Collection)paramString).isEmpty()) {
          break label799;
        }
      }
      label799:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 1) {
          break label811;
        }
        paramString = (crt)paramString.get(0);
        if (paramString == null) {
          break label811;
        }
        Log.i(TAG, "update live mic audienceInfo:[" + paramString.TyL + ' ' + paramString.nickname + ']');
        paramq = u.kwz;
        paramq = u.aPa();
        localObject = u.kwz;
        l = u.aOr().klE;
        localObject = paramString.RFk;
        kotlin.g.b.p.j(localObject, "it.live_mic_id");
        String str1 = paramString.TyL;
        kotlin.g.b.p.j(str1, "it.identity_id");
        String str2 = paramString.ueX;
        kotlin.g.b.p.j(str2, "it.head_img_url");
        String str3 = paramString.nickname;
        kotlin.g.b.p.j(str3, "it.nickname");
        paramString = paramString.TyF;
        kotlin.g.b.p.j(paramString, "it.sdk_user_id");
        paramq.a(l, (String)localObject, str1, str2, str3, paramString);
        AppMethodBeat.o(201080);
        return;
        paramString = null;
        break;
      }
      label804:
      AppMethodBeat.o(201080);
      return;
    }
    label811:
    AppMethodBeat.o(201080);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201066);
    com.tencent.mm.ae.d.C(kvx);
    com.tencent.mm.ae.d.C(kvy);
    com.tencent.mm.ae.d.C(kvz);
    com.tencent.mm.kernel.c localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(3767, (com.tencent.mm.an.i)this);
    localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(3797, (com.tencent.mm.an.i)this);
    localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(760, (com.tencent.mm.an.i)this);
    localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(589, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(201066);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c kvD;
    
    static
    {
      AppMethodBeat.i(194443);
      kvD = new c();
      AppMethodBeat.o(194443);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194442);
      Object localObject = h.aHF();
      kotlin.g.b.p.j(localObject, "MMKernel.network()");
      com.tencent.mm.an.t localt = ((com.tencent.mm.kernel.c)localObject).aGY();
      localObject = u.kwz;
      long l = u.aOr().klE;
      localObject = u.kwz;
      String str2 = u.aOm();
      localObject = u.kwz;
      localObject = u.aPa().kyo;
      if (localObject != null)
      {
        String str1 = ((a.a)localObject).ktE;
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      localt.b((com.tencent.mm.an.q)new com.tencent.mm.live.b.a.t(l, str2, (String)localObject));
      AppMethodBeat.o(194442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.o
 * JD-Core Version:    0.7.0.1
 */