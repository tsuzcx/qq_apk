package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.b;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, z> gQH;
  public d.g.a.a<z> gQI;
  public b<? super Long, z> gQJ;
  public b<? super Boolean, z> gQK;
  public r<? super Long, ? super String, ? super String, ? super String, z> gQL;
  public d.g.a.a<z> gQM;
  public b<? super Boolean, z> gQN;
  public final ArrayList<a> gQO;
  public a gQP;
  public String gQQ;
  public String gQR;
  
  public a()
  {
    AppMethodBeat.i(212269);
    this.gQO = new ArrayList();
    this.gQQ = "";
    this.gQR = "";
    AppMethodBeat.o(212269);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(212266);
    p.h(paramString1, "audience");
    p.h(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.gKp;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.gQP;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.gQS;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", p.i(paramString1, paramString2));
      paramString1 = g.gOr;
      if (paramLong == g.ans().Fsa) {
        break;
      }
      AppMethodBeat.o(212266);
      return;
    }
    paramString1 = this.gQO.iterator();
    p.g(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      p.g(localObject2, "mIterator.next()");
      if (p.i(((a)localObject2).gQS, paramString2)) {
        paramString1.remove();
      }
    }
    aq.f((Runnable)new e(this));
    localObject2 = this.gQP;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a)localObject2).gQS;
    }
    if (p.i(paramString2, paramString1)) {
      aq.f((Runnable)new f(this));
    }
    AppMethodBeat.o(212266);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(212267);
    p.h(paramString1, "micId");
    p.h(paramString2, "audience");
    p.h(paramString3, "headImg");
    p.h(paramString4, "nickName");
    p.h(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = g.gOr;
    if (paramLong == g.ans().Fsa)
    {
      this.gQP = new a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.gQL;
      if (paramString1 != null) {
        paramString1.a(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!aov())
      {
        paramString1 = this.gQM;
        if (paramString1 != null)
        {
          paramString1.invoke();
          AppMethodBeat.o(212267);
          return;
        }
      }
    }
    AppMethodBeat.o(212267);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(212264);
    p.h(parama, "user");
    aq.f((Runnable)new b(this, parama));
    AppMethodBeat.o(212264);
  }
  
  public final void aou()
  {
    this.gQP = null;
    this.gQQ = "";
  }
  
  public final boolean aov()
  {
    AppMethodBeat.i(212268);
    Object localObject = this.gQP;
    if (localObject != null) {}
    for (localObject = ((a)localObject).gQU;; localObject = null)
    {
      g localg = g.gOr;
      boolean bool = p.i(localObject, g.ans().GOI);
      AppMethodBeat.o(212268);
      return bool;
    }
  }
  
  public final void h(b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(212265);
    p.h(paramb, "micCloseObserver");
    this.gQN = paramb;
    AppMethodBeat.o(212265);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
  public static final class a
  {
    public static final a gQV;
    public long gGy;
    public String gQS;
    public String gQT;
    public String gQU;
    public String roomId;
    
    static
    {
      AppMethodBeat.i(212255);
      gQV = new a((byte)0);
      AppMethodBeat.o(212255);
    }
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(212254);
      this.gGy = paramLong;
      this.gQS = paramString1;
      this.gQT = paramString2;
      this.roomId = paramString3;
      this.gQU = paramString4;
      AppMethodBeat.o(212254);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(212253);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(212253);
        return false;
      }
      if (p.i(((a)paramObject).gQT, this.gQT))
      {
        AppMethodBeat.o(212253);
        return true;
      }
      AppMethodBeat.o(212253);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(212257);
      long l = this.gGy;
      int n = (int)(l ^ l >>> 32);
      String str = this.gQS;
      int i;
      int j;
      if (str != null)
      {
        i = str.hashCode();
        str = this.gQT;
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
        str = this.gQU;
        if (str != null) {
          m = str.hashCode();
        }
        AppMethodBeat.o(212257);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212256);
      String str = "LiveMicUser(liveId=" + this.gGy + ", micId=" + this.gQS + ", audience=" + this.gQT + ", roomId=" + this.roomId + ", sdkUid=" + this.gQU + ")";
      AppMethodBeat.o(212256);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(212258);
      this.gQW.gQP = parama;
      Object localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + parama);
      localObject = this.gQW.gQI;
      if (localObject != null)
      {
        ((d.g.a.a)localObject).invoke();
        AppMethodBeat.o(212258);
        return;
      }
      AppMethodBeat.o(212258);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(212259);
      b localb = this.gQW.gQJ;
      if (localb != null)
      {
        localb.invoke(Long.valueOf(this.gGk));
        AppMethodBeat.o(212259);
        return;
      }
      AppMethodBeat.o(212259);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(212260);
      b localb = this.gQW.gQK;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.gQY));
        AppMethodBeat.o(212260);
        return;
      }
      AppMethodBeat.o(212260);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(212261);
      b localb = this.gQW.gQH;
      if (localb != null)
      {
        localb.invoke(Boolean.FALSE);
        AppMethodBeat.o(212261);
        return;
      }
      AppMethodBeat.o(212261);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(212262);
      b localb = this.gQW.gQN;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.gQW.aov()));
        AppMethodBeat.o(212262);
        return;
      }
      AppMethodBeat.o(212262);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(212263);
      b localb = this.gQW.gQH;
      if (localb != null)
      {
        localb.invoke(Boolean.TRUE);
        AppMethodBeat.o(212263);
        return;
      }
      AppMethodBeat.o(212263);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */