package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.a.e;
import com.tencent.mm.live.model.a.g;
import com.tencent.mm.live.model.a.i;
import com.tencent.mm.live.model.a.m;
import com.tencent.mm.live.model.a.n;
import com.tencent.mm.live.model.a.q;
import com.tencent.mm.live.model.a.r;
import com.tencent.mm.live.model.a.t;
import com.tencent.mm.live.model.b.a.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.eop;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "cutLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", "username", "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements com.tencent.mm.am.h
{
  private static final String TAG;
  private static boolean hKC;
  public static final o mZb;
  private static final Runnable mZc;
  private static final Runnable mZd;
  public static final Runnable mZe;
  
  static
  {
    AppMethodBeat.i(246705);
    mZb = new o();
    TAG = "MicroMsg.LiveRoomOperation";
    hKC = true;
    mZc = o..ExternalSyntheticLambda1.INSTANCE;
    mZd = o..ExternalSyntheticLambda2.INSTANCE;
    mZe = o..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(246705);
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246574);
    kotlin.g.b.s.u(paramString, "wechatRoomId");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.c(u.bie().mMJ, paramString, paramBoolean), 0);
    AppMethodBeat.o(246574);
  }
  
  public static void Gl(String paramString)
  {
    AppMethodBeat.i(246587);
    kotlin.g.b.s.u(paramString, "wechatRoomId");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.d(u.bie().mMJ, paramString), 0);
    AppMethodBeat.o(246587);
  }
  
  public static void Gm(String paramString)
  {
    AppMethodBeat.i(246614);
    kotlin.g.b.s.u(paramString, "wechatRoomId");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.u(u.bie().mMJ, paramString), 0);
    AppMethodBeat.o(246614);
  }
  
  public static void Gn(String paramString)
  {
    AppMethodBeat.i(246623);
    kotlin.g.b.s.u(paramString, "username");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.p(l, u.bhZ(), paramString), 0);
    AppMethodBeat.o(246623);
  }
  
  public static void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246669);
    kotlin.g.b.s.u(paramLiveConfig, "config");
    if (paramLiveConfig.mIy == LiveConfig.mIs) {}
    for (boolean bool = true;; bool = false)
    {
      hKC = bool;
      AppMethodBeat.o(246669);
      return;
    }
  }
  
  public static void aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(246544);
    kotlin.g.b.s.u(paramString, "content");
    Object localObject1 = z.bAM();
    kotlin.g.b.s.s(localObject1, "getUsernameFromUserInfo()");
    localObject1 = new com.tencent.mm.live.view.a.a((String)localObject1, "", (CharSequence)paramString, paramInt, cn.getSyncServerTimeSecond());
    Object localObject2 = u.mZl;
    u.bic().add(localObject1);
    localObject1 = j.mXT;
    j.bhf();
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    localObject1 = u.mZl;
    long l = u.bie().mMJ;
    localObject1 = u.mZl;
    localObject2 = u.bid();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.s(paramString, paramInt, l, (byte[])localObject1, u.bhZ()), 0);
    AppMethodBeat.o(246544);
  }
  
  public static void aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246656);
    kotlin.g.b.s.u(paramString1, "micId");
    kotlin.g.b.s.u(paramString2, "sdkUid");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.k(l, u.bhZ(), String.valueOf(System.currentTimeMillis()), paramString1, paramString2), 0);
    AppMethodBeat.o(246656);
  }
  
  public static void bF(List<String> paramList)
  {
    AppMethodBeat.i(246648);
    kotlin.g.b.s.u(paramList, "userList");
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new n(u.bie().mMJ, paramList), 0);
    AppMethodBeat.o(246648);
  }
  
  public static void bhK()
  {
    AppMethodBeat.i(246536);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new m(l, u.bhZ(), true), 0);
    AppMethodBeat.o(246536);
  }
  
  public static void bhM()
  {
    AppMethodBeat.i(246597);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.b(l, u.bhZ()), 0);
    AppMethodBeat.o(246597);
  }
  
  public static void bhN()
  {
    AppMethodBeat.i(246662);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new e(l, u.bhZ()), 0);
    AppMethodBeat.o(246662);
  }
  
  private static final void bhP()
  {
    AppMethodBeat.i(246676);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    Object localObject = u.mZl;
    long l = u.bie().mMJ;
    localObject = u.mZl;
    localObject = u.bhZ();
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.o(l, (String)localObject, u.bid()), 0);
    AppMethodBeat.o(246676);
  }
  
  private static final void bhQ()
  {
    AppMethodBeat.i(246683);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new m(l, u.bhZ()), 0);
    AppMethodBeat.o(246683);
  }
  
  private static final void bhR()
  {
    AppMethodBeat.i(246695);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    Object localObject = u.mZl;
    long l = u.bie().mMJ;
    localObject = u.mZl;
    String str2 = u.bhZ();
    localObject = u.mZl;
    localObject = u.biN().nbN;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      locals.a((com.tencent.mm.am.p)new t(l, str2, (String)localObject), 0);
      AppMethodBeat.o(246695);
      return;
      String str1 = ((a.a)localObject).mXx;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
    }
  }
  
  public static void fR(boolean paramBoolean)
  {
    AppMethodBeat.i(246552);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new com.tencent.mm.live.model.a.a(l, u.bhZ(), paramBoolean), 0);
    AppMethodBeat.o(246552);
  }
  
  public static void fS(boolean paramBoolean)
  {
    AppMethodBeat.i(246608);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new i(l, u.bhZ(), paramBoolean), 0);
    AppMethodBeat.o(246608);
  }
  
  public static void fT(boolean paramBoolean)
  {
    AppMethodBeat.i(246619);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new r(l, u.bhZ(), paramBoolean), 0);
    AppMethodBeat.o(246619);
  }
  
  private static void hL(long paramLong)
  {
    AppMethodBeat.i(246520);
    com.tencent.mm.ae.d.H(mZd);
    com.tencent.mm.ae.d.a(paramLong, mZd);
    AppMethodBeat.o(246520);
  }
  
  public static void tA(int paramInt)
  {
    AppMethodBeat.i(246549);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    long l = u.bie().mMJ;
    localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new q(l, u.bhZ(), paramInt), 0);
    AppMethodBeat.o(246549);
  }
  
  public static void tB(int paramInt)
  {
    AppMethodBeat.i(246627);
    dih localdih = new dih();
    localdih.aaNh = paramInt;
    localdih.aaNg = cn.bDv();
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    u localu = u.mZl;
    locals.a((com.tencent.mm.am.p)new g(u.bie().mMJ, localdih), 0);
    AppMethodBeat.o(246627);
  }
  
  public final void bhO()
  {
    AppMethodBeat.i(246739);
    com.tencent.mm.kernel.h.baD().mCm.a(3767, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(589, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(246739);
  }
  
  public final void hM(long paramLong)
  {
    AppMethodBeat.i(246727);
    Log.i(TAG, kotlin.g.b.s.X("doKeepAlive delay:", Long.valueOf(paramLong)));
    com.tencent.mm.kernel.h.baD().mCm.a(3797, (com.tencent.mm.am.h)this);
    com.tencent.mm.ae.d.H(mZc);
    com.tencent.mm.ae.d.a(paramLong, mZc);
    AppMethodBeat.o(246727);
  }
  
  public final void hN(long paramLong)
  {
    AppMethodBeat.i(246734);
    Log.i(TAG, kotlin.g.b.s.X("doMicKeepLive delay:", Long.valueOf(paramLong)));
    com.tencent.mm.kernel.h.baD().mCm.a(760, (com.tencent.mm.am.h)this);
    com.tencent.mm.ae.d.H(mZe);
    com.tencent.mm.ae.d.a(paramLong, mZe);
    AppMethodBeat.o(246734);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    long l = 0L;
    String str1 = null;
    Object localObject = null;
    AppMethodBeat.i(246764);
    if ((paramp instanceof m))
    {
      l = ((m)paramp).duration;
      paramString = l.h.mYE;
      if (l > l.h.bhB()) {}
      for (l = 0L;; l = l.h.bhB())
      {
        Log.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m)paramp).duration + ", delay:" + l);
        hL(l);
        paramString = u.mZl;
        paramString = u.mZl;
        u.tD(u.bie().ZWw);
        AppMethodBeat.o(246764);
        return;
        paramString = l.h.mYE;
      }
    }
    if ((paramp instanceof com.tencent.mm.live.model.a.o))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(3797, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.model.a.o)paramp).nbi;
        if (paramString == null)
        {
          paramString = null;
          if (paramString == null) {
            break label790;
          }
          paramp = u.mZl;
          u.a(paramString);
          Log.i(TAG, "doKeepAlive updatePrivateMapKey");
          if (!hKC) {
            break label323;
          }
          paramp = com.tencent.mm.live.core.core.a.b.mMo;
          paramp = b.a.bej();
          str1 = paramString.aaOu.ZV();
          kotlin.g.b.s.s(str1, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramp.FO(str1);
          label240:
          paramp = u.mZl;
          paramp = u.bii();
          if (paramp != null) {
            break label360;
          }
          paramp = (com.tencent.mm.am.p)localObject;
          label259:
          if (paramp != null) {
            paramp.privateMapKey = paramString.aaOu.ZV();
          }
          paramString = u.mZl;
          paramString = u.bif();
          if (paramString != null) {
            break label370;
          }
        }
        for (;;)
        {
          hM(kotlin.k.k.bR((l - 60L) * 1000L, 60000L));
          AppMethodBeat.o(246764);
          return;
          paramString = paramString.ZOg;
          break;
          label323:
          paramp = com.tencent.mm.live.core.core.f.d.mUj;
          paramp = d.a.bfM();
          str1 = paramString.aaOu.ZV();
          kotlin.g.b.s.s(str1, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramp.FO(str1);
          break label240;
          label360:
          paramp = paramp.mNz;
          break label259;
          label370:
          l = paramString.aaOy;
        }
      }
    }
    else if ((paramp instanceof t))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(760, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramp).nbx;
        if (paramString == null)
        {
          paramString = null;
          if (paramString == null) {
            break label790;
          }
          paramp = u.mZl;
          u.a(paramString);
          Log.i(TAG, "doMicKeepAlive updatePrivateMapKey");
          paramp = com.tencent.mm.live.core.core.f.d.mUj;
          paramp = d.a.bfM();
          localObject = paramString.aaOu.ZV();
          kotlin.g.b.s.s(localObject, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramp.FO((String)localObject);
          paramp = u.mZl;
          paramp = u.bii();
          if (paramp != null) {
            break label558;
          }
        }
        label558:
        for (paramp = str1;; paramp = paramp.mNz)
        {
          if (paramp != null) {
            paramp.privateMapKey = paramString.aaOu.ZV();
          }
          paramString = u.mZl;
          hN(kotlin.k.k.bR((u.bij() - 60L) * 1000L, 60000L));
          AppMethodBeat.o(246764);
          return;
          paramString = paramString.ZOg;
          break;
        }
      }
    }
    else if ((paramp instanceof e))
    {
      paramString = ((e)paramp).naE;
      if (paramString != null) {
        break label797;
      }
      paramString = null;
      paramString = (List)paramString;
      if (paramString == null) {
        break label810;
      }
      if (((Collection)paramString).isEmpty()) {
        break label805;
      }
      paramInt1 = 1;
      label614:
      if (paramInt1 != 1) {
        break label810;
      }
    }
    label790:
    label797:
    label805:
    label810:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramString = (dis)paramString.get(0);
        if (paramString != null)
        {
          Log.i(TAG, "update live mic audienceInfo:[" + paramString.aaNt + ' ' + paramString.nickname + ']');
          paramp = u.mZl;
          paramp = u.biN();
          localObject = u.mZl;
          l = u.bie().mMJ;
          localObject = paramString.YBM;
          kotlin.g.b.s.s(localObject, "it.live_mic_id");
          str1 = paramString.aaNt;
          kotlin.g.b.s.s(str1, "it.identity_id");
          String str2 = paramString.xkY;
          kotlin.g.b.s.s(str2, "it.head_img_url");
          String str3 = paramString.nickname;
          kotlin.g.b.s.s(str3, "it.nickname");
          paramString = paramString.aaNn;
          kotlin.g.b.s.s(paramString, "it.sdk_user_id");
          paramp.a(l, (String)localObject, str1, str2, str3, paramString);
        }
      }
      AppMethodBeat.o(246764);
      return;
      paramString = paramString.aauq;
      break;
      paramInt1 = 0;
      break label614;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(246748);
    com.tencent.mm.ae.d.H(mZc);
    com.tencent.mm.ae.d.H(mZd);
    com.tencent.mm.ae.d.H(mZe);
    com.tencent.mm.kernel.h.baD().mCm.b(3767, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3797, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(760, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(589, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(246748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.o
 * JD-Core Version:    0.7.0.1
 */