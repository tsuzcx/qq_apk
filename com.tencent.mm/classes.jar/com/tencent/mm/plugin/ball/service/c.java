package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f gkk;
  public static final a mDO;
  private volatile c mDM;
  private Boolean mDN;
  
  static
  {
    AppMethodBeat.i(190692);
    mDO = new a((byte)0);
    gkk = d.g.a(d.k.JfI, (a)b.mDP);
    AppMethodBeat.o(190692);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190689);
    ad.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.mDM = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(190689);
  }
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(190691);
    ad.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.mDM = null;
    }
    AppMethodBeat.o(190691);
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(190690);
    int i;
    if (this.mDN == null)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psI, 0);
      if ((i != 1) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.mDN = Boolean.valueOf(bool);
      ad.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", new Object[] { Integer.valueOf(i), this.mDN });
      if (!d.g.b.k.g(this.mDN, Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(190690);
      return;
    }
    if (this.mDM == null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(190690);
      return;
    }
    try
    {
      Object localObject = this.mDM;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.mDM;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (((c)localObject).mDQ) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.mDM;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        ad.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        c localc = this.mDM;
        if (localc == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.mDM = null;
        AppMethodBeat.o(190690);
        return;
        localObject = this.mDM;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        bool = ((c)localObject).mDR;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.mDM = null;
      AppMethodBeat.o(190690);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(190687);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;")) };
      AppMethodBeat.o(190687);
    }
    
    public static c bzF()
    {
      AppMethodBeat.i(190688);
      Object localObject = c.ahu();
      a locala = c.mDO;
      localObject = (c)((f)localObject).getValue();
      AppMethodBeat.o(190688);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<c>
  {
    public static final b mDP;
    
    static
    {
      AppMethodBeat.i(190686);
      mDP = new b();
      AppMethodBeat.o(190686);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final boolean mDQ;
    final boolean mDR;
    final int pageType;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.mDQ = paramBoolean1;
      this.mDR = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */