package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.b;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, y> BMq;
  public d.g.a.a<y> BMr;
  public b<? super Long, y> BMs;
  public b<? super Boolean, y> BMt;
  public r<? super Long, ? super String, ? super String, ? super String, y> BMu;
  public d.g.a.a<y> BMv;
  public b<? super Boolean, y> BMw;
  public a BMx;
  public String BMy;
  public String BMz;
  public final ArrayList<a> ytb;
  
  public a()
  {
    AppMethodBeat.i(202788);
    this.ytb = new ArrayList();
    this.BMy = "";
    this.BMz = "";
    AppMethodBeat.o(202788);
  }
  
  public final void F(b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(202785);
    k.h(paramb, "micCloseObserver");
    this.BMw = paramb;
    AppMethodBeat.o(202785);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(202784);
    k.h(parama, "user");
    this.BMx = parama;
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic ".concat(String.valueOf(parama)));
    aq.f((Runnable)new b(this));
    AppMethodBeat.o(202784);
  }
  
  public final void fOJ()
  {
    this.BMx = null;
    this.BMy = "";
  }
  
  public final boolean fOK()
  {
    AppMethodBeat.i(202787);
    Object localObject = this.BMx;
    if (localObject != null) {}
    for (localObject = ((a)localObject).Csx;; localObject = null)
    {
      f localf = f.rGw;
      boolean bool = k.g(localObject, f.eNG().Lze);
      AppMethodBeat.o(202787);
      return bool;
    }
  }
  
  public final void g(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(202786);
    k.h(paramString1, "audience");
    k.h(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.qOL;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.BMx;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.BQP;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", k.g(paramString1, paramString2));
      paramString1 = f.rGw;
      if (paramLong == f.eNG().LwA) {
        break;
      }
      AppMethodBeat.o(202786);
      return;
    }
    paramString1 = this.ytb.iterator();
    k.g(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      k.g(localObject2, "mIterator.next()");
      if (k.g(((a)localObject2).BQP, paramString2)) {
        paramString1.remove();
      }
    }
    aq.f((Runnable)new e(this));
    localObject2 = this.BMx;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a)localObject2).BQP;
    }
    if (k.g(paramString2, paramString1)) {
      aq.f((Runnable)new f(this));
    }
    AppMethodBeat.o(202786);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
  public static final class a
  {
    public static final a DkT;
    public String BQP;
    public String CaG;
    public String Csx;
    public long DlB;
    public String roomId;
    
    static
    {
      AppMethodBeat.i(202775);
      DkT = new a((byte)0);
      AppMethodBeat.o(202775);
    }
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(202774);
      this.DlB = paramLong;
      this.BQP = paramString1;
      this.CaG = paramString2;
      this.roomId = paramString3;
      this.Csx = paramString4;
      AppMethodBeat.o(202774);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202773);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(202773);
        return false;
      }
      if (k.g(((a)paramObject).CaG, this.CaG))
      {
        AppMethodBeat.o(202773);
        return true;
      }
      AppMethodBeat.o(202773);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(202777);
      long l = this.DlB;
      int n = (int)(l ^ l >>> 32);
      String str = this.BQP;
      int i;
      int j;
      if (str != null)
      {
        i = str.hashCode();
        str = this.CaG;
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
        str = this.Csx;
        if (str != null) {
          m = str.hashCode();
        }
        AppMethodBeat.o(202777);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202776);
      String str = "LiveMicUser(liveId=" + this.DlB + ", micId=" + this.BQP + ", audience=" + this.CaG + ", roomId=" + this.roomId + ", sdkUid=" + this.Csx + ")";
      AppMethodBeat.o(202776);
      return str;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
    public static final class a
    {
      public static a.a fOL()
      {
        AppMethodBeat.i(202772);
        a.a locala = new a.a(0L, "", "", "", "");
        AppMethodBeat.o(202772);
        return locala;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202778);
      d.g.a.a locala = this.DlD.BMr;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(202778);
        return;
      }
      AppMethodBeat.o(202778);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(202779);
      b localb = this.DlD.BMs;
      if (localb != null)
      {
        localb.aA(Long.valueOf(this.qsg));
        AppMethodBeat.o(202779);
        return;
      }
      AppMethodBeat.o(202779);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(202780);
      b localb = this.DlD.BMt;
      if (localb != null)
      {
        localb.aA(Boolean.valueOf(this.keB));
        AppMethodBeat.o(202780);
        return;
      }
      AppMethodBeat.o(202780);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202781);
      b localb = this.DlD.BMq;
      if (localb != null)
      {
        localb.aA(Boolean.FALSE);
        AppMethodBeat.o(202781);
        return;
      }
      AppMethodBeat.o(202781);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202782);
      b localb = this.DlD.BMw;
      if (localb != null)
      {
        localb.aA(Boolean.valueOf(this.DlD.fOK()));
        AppMethodBeat.o(202782);
        return;
      }
      AppMethodBeat.o(202782);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202783);
      b localb = this.DlD.BMq;
      if (localb != null)
      {
        localb.aA(Boolean.TRUE);
        AppMethodBeat.o(202783);
        return;
      }
      AppMethodBeat.o(202783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */