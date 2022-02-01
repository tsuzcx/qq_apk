package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a
{
  public b<? super Boolean, y> gwW;
  public d.g.a.a<y> gwX;
  public b<? super Long, y> gwY;
  public b<? super Boolean, y> gwZ;
  public r<? super Long, ? super String, ? super String, ? super String, y> gxa;
  public d.g.a.a<y> gxb;
  public b<? super Boolean, y> gxc;
  public final ArrayList<a.a> gxd;
  public a.a gxe;
  public String gxf;
  public String gxg;
  
  public a()
  {
    AppMethodBeat.i(189983);
    this.gxd = new ArrayList();
    this.gxf = "";
    this.gxg = "";
    AppMethodBeat.o(189983);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(189980);
    k.h(paramString1, "audience");
    k.h(paramString2, "micId");
    Object localObject2 = com.tencent.mm.live.core.debug.a.gqF;
    localObject2 = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(paramLong).append(" audience:").append(paramString1).append(" micId:").append(paramString2).append(" isSelf:");
    paramString1 = this.gxe;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.gxh;; paramString1 = null)
    {
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", k.g(paramString1, paramString2));
      paramString1 = g.guG;
      if (paramLong == g.akF().DMV) {
        break;
      }
      AppMethodBeat.o(189980);
      return;
    }
    paramString1 = this.gxd.iterator();
    k.g(paramString1, "userList.iterator()");
    while (paramString1.hasNext())
    {
      localObject2 = paramString1.next();
      k.g(localObject2, "mIterator.next()");
      if (k.g(((a.a)localObject2).gxh, paramString2)) {
        paramString1.remove();
      }
    }
    ap.f((Runnable)new e(this));
    localObject2 = this.gxe;
    paramString1 = localObject1;
    if (localObject2 != null) {
      paramString1 = ((a.a)localObject2).gxh;
    }
    if (k.g(paramString2, paramString1)) {
      ap.f((Runnable)new f(this));
    }
    AppMethodBeat.o(189980);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(189981);
    k.h(paramString1, "micId");
    k.h(paramString2, "audience");
    k.h(paramString3, "headImg");
    k.h(paramString4, "nickName");
    k.h(paramString5, "sdkUid");
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + paramString1 + " audience:" + paramString2 + " nick:" + paramString4 + " liveId:" + paramLong + " sdkUid:" + paramString5);
    localObject = g.guG;
    if (paramLong == g.akF().DMV)
    {
      this.gxe = new a.a(paramLong, paramString1, paramString2, "", paramString5);
      paramString1 = this.gxa;
      if (paramString1 != null) {
        paramString1.a(Long.valueOf(paramLong), paramString2, paramString3, paramString4);
      }
      if (!alI())
      {
        paramString1 = this.gxb;
        if (paramString1 != null)
        {
          paramString1.invoke();
          AppMethodBeat.o(189981);
          return;
        }
      }
    }
    AppMethodBeat.o(189981);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(189978);
    k.h(parama, "user");
    ap.f((Runnable)new b(this, parama));
    AppMethodBeat.o(189978);
  }
  
  public final void alH()
  {
    this.gxe = null;
    this.gxf = "";
  }
  
  public final boolean alI()
  {
    AppMethodBeat.i(189982);
    Object localObject = this.gxe;
    if (localObject != null) {}
    for (localObject = ((a.a)localObject).gxj;; localObject = null)
    {
      g localg = g.guG;
      boolean bool = k.g(localObject, g.akF().Ffe);
      AppMethodBeat.o(189982);
      return bool;
    }
  }
  
  public final void g(b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(189979);
    k.h(paramb, "micCloseObserver");
    this.gxc = paramb;
    AppMethodBeat.o(189979);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(189972);
      this.gxl.gxe = parama;
      Object localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + parama);
      localObject = this.gxl.gwX;
      if (localObject != null)
      {
        ((d.g.a.a)localObject).invoke();
        AppMethodBeat.o(189972);
        return;
      }
      AppMethodBeat.o(189972);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(189973);
      b localb = this.gxl.gwY;
      if (localb != null)
      {
        localb.ay(Long.valueOf(this.gmB));
        AppMethodBeat.o(189973);
        return;
      }
      AppMethodBeat.o(189973);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(189974);
      b localb = this.gxl.gwZ;
      if (localb != null)
      {
        localb.ay(Boolean.valueOf(this.gxn));
        AppMethodBeat.o(189974);
        return;
      }
      AppMethodBeat.o(189974);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189975);
      b localb = this.gxl.gwW;
      if (localb != null)
      {
        localb.ay(Boolean.FALSE);
        AppMethodBeat.o(189975);
        return;
      }
      AppMethodBeat.o(189975);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189976);
      b localb = this.gxl.gxc;
      if (localb != null)
      {
        localb.ay(Boolean.valueOf(this.gxl.alI()));
        AppMethodBeat.o(189976);
        return;
      }
      AppMethodBeat.o(189976);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189977);
      b localb = this.gxl.gwW;
      if (localb != null)
      {
        localb.ay(Boolean.TRUE);
        AppMethodBeat.o(189977);
        return;
      }
      AppMethodBeat.o(189977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */