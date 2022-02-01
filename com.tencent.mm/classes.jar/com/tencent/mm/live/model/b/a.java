package com.tencent.mm.live.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.u;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public b<? super Boolean, ah> nbF;
  public kotlin.g.a.a<ah> nbG;
  public b<? super Long, ah> nbH;
  public b<? super Boolean, ah> nbI;
  public r<? super Long, ? super String, ? super String, ? super String, ah> nbJ;
  public kotlin.g.a.a<ah> nbK;
  public b<? super Boolean, ah> nbL;
  public final ArrayList<a.a> nbM;
  public a.a nbN;
  public String nbO;
  public String nbP;
  
  public a()
  {
    AppMethodBeat.i(246725);
    this.nbM = new ArrayList();
    this.nbO = "";
    this.nbP = "";
    AppMethodBeat.o(246725);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(246731);
    s.u(parama, "this$0");
    parama = parama.nbF;
    if (parama != null) {
      parama.invoke(Boolean.TRUE);
    }
    AppMethodBeat.o(246731);
  }
  
  private static final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(246745);
    s.u(parama, "this$0");
    parama = parama.nbH;
    if (parama != null) {
      parama.invoke(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(246745);
  }
  
  private static final void a(a parama, a.a parama1)
  {
    AppMethodBeat.i(246752);
    s.u(parama, "this$0");
    s.u(parama1, "$user");
    parama.nbN = parama1;
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", s.X("[sysmsg]anchor accept mic ", parama1));
    parama = parama.nbG;
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(246752);
  }
  
  private static final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(246738);
    s.u(parama, "this$0");
    parama = parama.nbI;
    if (parama != null) {
      parama.invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(246738);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(246754);
    s.u(parama, "this$0");
    parama = parama.nbF;
    if (parama != null) {
      parama.invoke(Boolean.FALSE);
    }
    AppMethodBeat.o(246754);
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(246759);
    s.u(parama, "this$0");
    b localb = parama.nbL;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(parama.biY()));
    }
    AppMethodBeat.o(246759);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(246831);
    s.u(paramString1, "audience");
    s.u(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.mUy;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.nbN;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.mXx)
    {
      com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", s.p(paramString1, paramString2));
      paramString1 = u.mZl;
      if (paramLong == u.bie().mMJ) {
        break;
      }
      AppMethodBeat.o(246831);
      return;
    }
    paramString1 = this.nbM.iterator();
    s.s(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      s.s(localObject2, "mIterator.next()");
      if (s.p(((a.a)localObject2).mXx, paramString2)) {
        paramString1.remove();
      }
    }
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda1(this));
    paramString1 = this.nbN;
    if (paramString1 == null) {}
    for (paramString1 = localObject1;; paramString1 = paramString1.mXx)
    {
      if (s.p(paramString2, paramString1)) {
        MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(246831);
      return;
    }
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(246848);
    s.u(paramString1, "micId");
    s.u(paramString2, "audience");
    s.u(paramString3, "headImg");
    s.u(paramString4, "nickName");
    s.u(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = u.mZl;
    if (paramLong == u.bie().mMJ)
    {
      this.nbN = new a.a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.nbJ;
      if (paramString1 != null) {
        paramString1.a(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!biY())
      {
        paramString1 = this.nbK;
        if (paramString1 != null) {
          paramString1.invoke();
        }
      }
    }
    AppMethodBeat.o(246848);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(246805);
    s.u(parama, "liveMicUser");
    Object localObject1 = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", s.X("[sysmsg]anchor receive mic ", parama));
    localObject1 = u.mZl;
    if (u.bie().mMJ == parama.liveId)
    {
      Object localObject2 = ((Iterable)this.nbM).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (a.a)((Iterator)localObject2).next();
        if (s.p(((a.a)localObject1).mXH, parama.mXH))
        {
          localObject2 = parama.mXx;
          s.u(localObject2, "<set-?>");
          ((a.a)localObject1).mXx = ((String)localObject2);
          parama = parama.roomId;
          s.u(parama, "<set-?>");
          ((a.a)localObject1).roomId = parama;
          AppMethodBeat.o(246805);
          return;
        }
      }
      this.nbM.add(0, parama);
      MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(246805);
      return;
    }
    parama = u.mZl;
    Log.e("MicroMsg.LiveCoreMic", s.X("anchor receive mic ,but error live_id for ", Long.valueOf(u.bie().mMJ)));
    AppMethodBeat.o(246805);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(246817);
    s.u(parama, "user");
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda4(this, parama));
    AppMethodBeat.o(246817);
  }
  
  public final void biX()
  {
    this.nbN = null;
    this.nbO = "";
  }
  
  public final boolean biY()
  {
    AppMethodBeat.i(246855);
    Object localObject = this.nbN;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((a.a)localObject).mXH)
    {
      u localu = u.mZl;
      boolean bool = s.p(localObject, u.bie().aaNn);
      AppMethodBeat.o(246855);
      return bool;
    }
  }
  
  public final void hR(long paramLong)
  {
    AppMethodBeat.i(246813);
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga(s.X("[sysmsg]anchor close live ", Long.valueOf(paramLong)));
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda3(this, paramLong));
    AppMethodBeat.o(246813);
  }
  
  public final void o(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(246809);
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + paramBoolean + " liveId:" + paramLong);
    localObject = u.mZl;
    if (paramLong == u.bie().mMJ) {
      MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda5(this, paramBoolean));
    }
    AppMethodBeat.o(246809);
  }
  
  public final void x(b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(246822);
    s.u(paramb, "micCloseObserver");
    this.nbL = paramb;
    AppMethodBeat.o(246822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.b.a
 * JD-Core Version:    0.7.0.1
 */