package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f gKX;
  public static final a nfU;
  private volatile c nfS;
  private Boolean nfT;
  
  static
  {
    AppMethodBeat.i(208094);
    nfU = new a((byte)0);
    gKX = d.g.a(d.k.KTc, (a)b.nfV);
    AppMethodBeat.o(208094);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208091);
    ac.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.nfS = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(208091);
  }
  
  public final void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(208093);
    ac.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.nfS = null;
    }
    AppMethodBeat.o(208093);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(208092);
    int i;
    if (this.nfT == null)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWR, 0);
      if ((i != 1) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.nfT = Boolean.valueOf(bool);
      ac.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", new Object[] { Integer.valueOf(i), this.nfT });
      if (!d.g.b.k.g(this.nfT, Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(208092);
      return;
    }
    if (this.nfS == null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(208092);
      return;
    }
    try
    {
      Object localObject = this.nfS;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.nfS;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((c)localObject).nfW) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.nfS;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        ac.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        c localc = this.nfS;
        if (localc == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.nfS = null;
        AppMethodBeat.o(208092);
        return;
        localObject = this.nfS;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        bool = ((c)localObject).nfX;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.nfS = null;
      AppMethodBeat.o(208092);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(208089);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;")) };
      AppMethodBeat.o(208089);
    }
    
    public static c bGB()
    {
      AppMethodBeat.i(208090);
      Object localObject = c.aow();
      a locala = c.nfU;
      localObject = (c)((f)localObject).getValue();
      AppMethodBeat.o(208090);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<c>
  {
    public static final b nfV;
    
    static
    {
      AppMethodBeat.i(208088);
      nfV = new b();
      AppMethodBeat.o(208088);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final boolean nfW;
    final boolean nfX;
    final int pageType;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.nfW = paramBoolean1;
      this.nfX = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */