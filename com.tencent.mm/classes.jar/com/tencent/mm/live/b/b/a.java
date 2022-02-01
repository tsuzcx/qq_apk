package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, kotlin.x> hKM;
  public kotlin.g.a.a<kotlin.x> hKN;
  public b<? super Long, kotlin.x> hKO;
  public b<? super Boolean, kotlin.x> hKP;
  public r<? super Long, ? super String, ? super String, ? super String, kotlin.x> hKQ;
  public kotlin.g.a.a<kotlin.x> hKR;
  public b<? super Boolean, kotlin.x> hKS;
  public final ArrayList<a> hKT;
  public a hKU;
  public String hKV;
  public String hKW;
  
  public a()
  {
    AppMethodBeat.i(207842);
    this.hKT = new ArrayList();
    this.hKV = "";
    this.hKW = "";
    AppMethodBeat.o(207842);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(207839);
    p.h(paramString1, "audience");
    p.h(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.hCA;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.hKU;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.hFz;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", p.j(paramString1, paramString2));
      paramString1 = com.tencent.mm.live.b.x.hJf;
      if (paramLong == com.tencent.mm.live.b.x.aGr().hyH) {
        break;
      }
      AppMethodBeat.o(207839);
      return;
    }
    paramString1 = this.hKT.iterator();
    p.g(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      p.g(localObject2, "mIterator.next()");
      if (p.j(((a)localObject2).hFz, paramString2)) {
        paramString1.remove();
      }
    }
    MMHandlerThread.postToMainThread((Runnable)new e(this));
    localObject2 = this.hKU;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a)localObject2).hFz;
    }
    if (p.j(paramString2, paramString1)) {
      MMHandlerThread.postToMainThread((Runnable)new f(this));
    }
    AppMethodBeat.o(207839);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(207840);
    p.h(paramString1, "micId");
    p.h(paramString2, "audience");
    p.h(paramString3, "headImg");
    p.h(paramString4, "nickName");
    p.h(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = com.tencent.mm.live.b.x.hJf;
    if (paramLong == com.tencent.mm.live.b.x.aGr().hyH)
    {
      this.hKU = new a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.hKQ;
      if (paramString1 != null) {
        paramString1.invoke(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!aHl())
      {
        paramString1 = this.hKR;
        if (paramString1 != null)
        {
          paramString1.invoke();
          AppMethodBeat.o(207840);
          return;
        }
      }
    }
    AppMethodBeat.o(207840);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(207837);
    p.h(parama, "user");
    MMHandlerThread.postToMainThread((Runnable)new b(this, parama));
    AppMethodBeat.o(207837);
  }
  
  public final void aHk()
  {
    this.hKU = null;
    this.hKV = "";
  }
  
  public final boolean aHl()
  {
    AppMethodBeat.i(207841);
    Object localObject = this.hKU;
    if (localObject != null) {}
    for (localObject = ((a)localObject).hFG;; localObject = null)
    {
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      boolean bool = p.j(localObject, com.tencent.mm.live.b.x.aGr().MnL);
      AppMethodBeat.o(207841);
      return bool;
    }
  }
  
  public final void h(b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(207838);
    p.h(paramb, "micCloseObserver");
    this.hKS = paramb;
    AppMethodBeat.o(207838);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
  public static final class a
  {
    public static final a hKX;
    public String hFG;
    public String hFJ;
    public String hFz;
    public long liveId;
    public String roomId;
    
    static
    {
      AppMethodBeat.i(207828);
      hKX = new a((byte)0);
      AppMethodBeat.o(207828);
    }
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(207827);
      this.liveId = paramLong;
      this.hFz = paramString1;
      this.hFJ = paramString2;
      this.roomId = paramString3;
      this.hFG = paramString4;
      AppMethodBeat.o(207827);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(207826);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(207826);
        return false;
      }
      if (p.j(((a)paramObject).hFJ, this.hFJ))
      {
        AppMethodBeat.o(207826);
        return true;
      }
      AppMethodBeat.o(207826);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(207830);
      long l = this.liveId;
      int n = (int)(l ^ l >>> 32);
      String str = this.hFz;
      int i;
      int j;
      if (str != null)
      {
        i = str.hashCode();
        str = this.hFJ;
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
        str = this.hFG;
        if (str != null) {
          m = str.hashCode();
        }
        AppMethodBeat.o(207830);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207829);
      String str = "LiveMicUser(liveId=" + this.liveId + ", micId=" + this.hFz + ", audience=" + this.hFJ + ", roomId=" + this.roomId + ", sdkUid=" + this.hFG + ")";
      AppMethodBeat.o(207829);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(207831);
      this.hKY.hKU = parama;
      Object localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + parama);
      localObject = this.hKY.hKN;
      if (localObject != null)
      {
        ((kotlin.g.a.a)localObject).invoke();
        AppMethodBeat.o(207831);
        return;
      }
      AppMethodBeat.o(207831);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(207832);
      b localb = this.hKY.hKO;
      if (localb != null)
      {
        localb.invoke(Long.valueOf(this.hvK));
        AppMethodBeat.o(207832);
        return;
      }
      AppMethodBeat.o(207832);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(207833);
      b localb = this.hKY.hKP;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.hLa));
        AppMethodBeat.o(207833);
        return;
      }
      AppMethodBeat.o(207833);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207834);
      b localb = this.hKY.hKM;
      if (localb != null)
      {
        localb.invoke(Boolean.FALSE);
        AppMethodBeat.o(207834);
        return;
      }
      AppMethodBeat.o(207834);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207835);
      b localb = this.hKY.hKS;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.hKY.aHl()));
        AppMethodBeat.o(207835);
        return;
      }
      AppMethodBeat.o(207835);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207836);
      b localb = this.hKY.hKM;
      if (localb != null)
      {
        localb.invoke(Boolean.TRUE);
        AppMethodBeat.o(207836);
        return;
      }
      AppMethodBeat.o(207836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */