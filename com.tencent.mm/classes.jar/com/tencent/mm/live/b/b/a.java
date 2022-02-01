package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.a.b;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, z> gTp;
  public d.g.a.a<z> gTq;
  public b<? super Long, z> gTr;
  public b<? super Boolean, z> gTs;
  public r<? super Long, ? super String, ? super String, ? super String, z> gTt;
  public d.g.a.a<z> gTu;
  public b<? super Boolean, z> gTv;
  public final ArrayList<a> gTw;
  public a gTx;
  public String gTy;
  public String gTz;
  
  public a()
  {
    AppMethodBeat.i(215889);
    this.gTw = new ArrayList();
    this.gTy = "";
    this.gTz = "";
    AppMethodBeat.o(215889);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(215886);
    p.h(paramString1, "audience");
    p.h(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.gMY;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.gTx;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.gTA;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", p.i(paramString1, paramString2));
      paramString1 = g.gQZ;
      if (paramLong == g.anH().FKy) {
        break;
      }
      AppMethodBeat.o(215886);
      return;
    }
    paramString1 = this.gTw.iterator();
    p.g(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      p.g(localObject2, "mIterator.next()");
      if (p.i(((a)localObject2).gTA, paramString2)) {
        paramString1.remove();
      }
    }
    ar.f((Runnable)new e(this));
    localObject2 = this.gTx;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a)localObject2).gTA;
    }
    if (p.i(paramString2, paramString1)) {
      ar.f((Runnable)new f(this));
    }
    AppMethodBeat.o(215886);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(215887);
    p.h(paramString1, "micId");
    p.h(paramString2, "audience");
    p.h(paramString3, "headImg");
    p.h(paramString4, "nickName");
    p.h(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = g.gQZ;
    if (paramLong == g.anH().FKy)
    {
      this.gTx = new a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.gTt;
      if (paramString1 != null) {
        paramString1.a(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!aoK())
      {
        paramString1 = this.gTu;
        if (paramString1 != null)
        {
          paramString1.invoke();
          AppMethodBeat.o(215887);
          return;
        }
      }
    }
    AppMethodBeat.o(215887);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(215884);
    p.h(parama, "user");
    ar.f((Runnable)new b(this, parama));
    AppMethodBeat.o(215884);
  }
  
  public final void aoJ()
  {
    this.gTx = null;
    this.gTy = "";
  }
  
  public final boolean aoK()
  {
    AppMethodBeat.i(215888);
    Object localObject = this.gTx;
    if (localObject != null) {}
    for (localObject = ((a)localObject).gTC;; localObject = null)
    {
      g localg = g.gQZ;
      boolean bool = p.i(localObject, g.anH().Hii);
      AppMethodBeat.o(215888);
      return bool;
    }
  }
  
  public final void h(b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(215885);
    p.h(paramb, "micCloseObserver");
    this.gTv = paramb;
    AppMethodBeat.o(215885);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
  public static final class a
  {
    public static final a gTD;
    public long gJh;
    public String gTA;
    public String gTB;
    public String gTC;
    public String roomId;
    
    static
    {
      AppMethodBeat.i(215875);
      gTD = new a((byte)0);
      AppMethodBeat.o(215875);
    }
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(215874);
      this.gJh = paramLong;
      this.gTA = paramString1;
      this.gTB = paramString2;
      this.roomId = paramString3;
      this.gTC = paramString4;
      AppMethodBeat.o(215874);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(215873);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(215873);
        return false;
      }
      if (p.i(((a)paramObject).gTB, this.gTB))
      {
        AppMethodBeat.o(215873);
        return true;
      }
      AppMethodBeat.o(215873);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(215877);
      long l = this.gJh;
      int n = (int)(l ^ l >>> 32);
      String str = this.gTA;
      int i;
      int j;
      if (str != null)
      {
        i = str.hashCode();
        str = this.gTB;
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
        str = this.gTC;
        if (str != null) {
          m = str.hashCode();
        }
        AppMethodBeat.o(215877);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215876);
      String str = "LiveMicUser(liveId=" + this.gJh + ", micId=" + this.gTA + ", audience=" + this.gTB + ", roomId=" + this.roomId + ", sdkUid=" + this.gTC + ")";
      AppMethodBeat.o(215876);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(215878);
      this.gTE.gTx = parama;
      Object localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + parama);
      localObject = this.gTE.gTq;
      if (localObject != null)
      {
        ((d.g.a.a)localObject).invoke();
        AppMethodBeat.o(215878);
        return;
      }
      AppMethodBeat.o(215878);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(215879);
      b localb = this.gTE.gTr;
      if (localb != null)
      {
        localb.invoke(Long.valueOf(this.gIR));
        AppMethodBeat.o(215879);
        return;
      }
      AppMethodBeat.o(215879);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(215880);
      b localb = this.gTE.gTs;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.gTG));
        AppMethodBeat.o(215880);
        return;
      }
      AppMethodBeat.o(215880);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(215881);
      b localb = this.gTE.gTp;
      if (localb != null)
      {
        localb.invoke(Boolean.FALSE);
        AppMethodBeat.o(215881);
        return;
      }
      AppMethodBeat.o(215881);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(215882);
      b localb = this.gTE.gTv;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.gTE.aoK()));
        AppMethodBeat.o(215882);
        return;
      }
      AppMethodBeat.o(215882);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(215883);
      b localb = this.gTE.gTp;
      if (localb != null)
      {
        localb.invoke(Boolean.TRUE);
        AppMethodBeat.o(215883);
        return;
      }
      AppMethodBeat.o(215883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */