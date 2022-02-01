package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.u;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, x> kyg;
  public kotlin.g.a.a<x> kyh;
  public b<? super Long, x> kyi;
  public b<? super Boolean, x> kyj;
  public r<? super Long, ? super String, ? super String, ? super String, x> kyk;
  public kotlin.g.a.a<x> kyl;
  public b<? super Boolean, x> kym;
  public final ArrayList<a> kyn;
  public a kyo;
  public String kyp;
  public String kyq;
  
  public a()
  {
    AppMethodBeat.i(188481);
    this.kyn = new ArrayList();
    this.kyp = "";
    this.kyq = "";
    AppMethodBeat.o(188481);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(188476);
    p.k(paramString1, "audience");
    p.k(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.kqB;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.kyo;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.ktE;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", p.h(paramString1, paramString2));
      paramString1 = u.kwz;
      if (paramLong == u.aOr().klE) {
        break;
      }
      AppMethodBeat.o(188476);
      return;
    }
    paramString1 = this.kyn.iterator();
    p.j(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      p.j(localObject2, "mIterator.next()");
      if (p.h(((a)localObject2).ktE, paramString2)) {
        paramString1.remove();
      }
    }
    MMHandlerThread.postToMainThread((Runnable)new e(this));
    localObject2 = this.kyo;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a)localObject2).ktE;
    }
    if (p.h(paramString2, paramString1)) {
      MMHandlerThread.postToMainThread((Runnable)new f(this));
    }
    AppMethodBeat.o(188476);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(188477);
    p.k(paramString1, "micId");
    p.k(paramString2, "audience");
    p.k(paramString3, "headImg");
    p.k(paramString4, "nickName");
    p.k(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = u.kwz;
    if (paramLong == u.aOr().klE)
    {
      this.kyo = new a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.kyk;
      if (paramString1 != null) {
        paramString1.a(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!aPl())
      {
        paramString1 = this.kyl;
        if (paramString1 != null)
        {
          paramString1.invoke();
          AppMethodBeat.o(188477);
          return;
        }
      }
    }
    AppMethodBeat.o(188477);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(188474);
    p.k(parama, "user");
    MMHandlerThread.postToMainThread((Runnable)new b(this, parama));
    AppMethodBeat.o(188474);
  }
  
  public final void aPk()
  {
    this.kyo = null;
    this.kyp = "";
  }
  
  public final boolean aPl()
  {
    AppMethodBeat.i(188479);
    Object localObject = this.kyo;
    if (localObject != null) {}
    for (localObject = ((a)localObject).ktN;; localObject = null)
    {
      u localu = u.kwz;
      boolean bool = p.h(localObject, u.aOr().TyF);
      AppMethodBeat.o(188479);
      return bool;
    }
  }
  
  public final void h(b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(188475);
    p.k(paramb, "micCloseObserver");
    this.kym = paramb;
    AppMethodBeat.o(188475);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
  public static final class a
  {
    public static final a kyr;
    public String ktE;
    public String ktN;
    public String ktQ;
    public long liveId;
    public String roomId;
    
    static
    {
      AppMethodBeat.i(196734);
      kyr = new a((byte)0);
      AppMethodBeat.o(196734);
    }
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(196733);
      this.liveId = paramLong;
      this.ktE = paramString1;
      this.ktQ = paramString2;
      this.roomId = paramString3;
      this.ktN = paramString4;
      AppMethodBeat.o(196733);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196731);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(196731);
        return false;
      }
      if (p.h(((a)paramObject).ktQ, this.ktQ))
      {
        AppMethodBeat.o(196731);
        return true;
      }
      AppMethodBeat.o(196731);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(196742);
      long l = this.liveId;
      int n = (int)(l ^ l >>> 32);
      String str = this.ktE;
      int i;
      int j;
      if (str != null)
      {
        i = str.hashCode();
        str = this.ktQ;
        if (str == null) {
          break label128;
        }
        j = str.hashCode();
        label59:
        str = this.roomId;
        if (str == null) {
          break label133;
        }
      }
      label128:
      label133:
      for (int k = str.hashCode();; k = 0)
      {
        str = this.ktN;
        if (str != null) {
          m = str.hashCode();
        }
        AppMethodBeat.o(196742);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196738);
      String str = "LiveMicUser(liveId=" + this.liveId + ", micId=" + this.ktE + ", audience=" + this.ktQ + ", roomId=" + this.roomId + ", sdkUid=" + this.ktN + ")";
      AppMethodBeat.o(196738);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(196051);
      this.kys.kyo = parama;
      Object localObject = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + parama);
      localObject = this.kys.kyh;
      if (localObject != null)
      {
        ((kotlin.g.a.a)localObject).invoke();
        AppMethodBeat.o(196051);
        return;
      }
      AppMethodBeat.o(196051);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(201328);
      b localb = this.kys.kyi;
      if (localb != null)
      {
        localb.invoke(Long.valueOf(this.khN));
        AppMethodBeat.o(201328);
        return;
      }
      AppMethodBeat.o(201328);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(195078);
      b localb = this.kys.kyj;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.kyu));
        AppMethodBeat.o(195078);
        return;
      }
      AppMethodBeat.o(195078);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(190512);
      b localb = this.kys.kyg;
      if (localb != null)
      {
        localb.invoke(Boolean.FALSE);
        AppMethodBeat.o(190512);
        return;
      }
      AppMethodBeat.o(190512);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(197759);
      b localb = this.kys.kym;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.kys.aPl()));
        AppMethodBeat.o(197759);
        return;
      }
      AppMethodBeat.o(197759);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(196708);
      b localb = this.kys.kyg;
      if (localb != null)
      {
        localb.invoke(Boolean.TRUE);
        AppMethodBeat.o(196708);
        return;
      }
      AppMethodBeat.o(196708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */