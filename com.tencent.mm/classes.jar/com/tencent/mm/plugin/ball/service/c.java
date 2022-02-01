package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f hhA;
  public static final a nLS;
  private volatile c nLQ;
  private Boolean nLR;
  
  static
  {
    AppMethodBeat.i(209587);
    nLS = new a((byte)0);
    hhA = d.g.a(k.Nhd, (a)b.nLT);
    AppMethodBeat.o(209587);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209584);
    ae.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.nLQ = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(209584);
  }
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(209586);
    ae.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.nLQ = null;
    }
    AppMethodBeat.o(209586);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(209585);
    int i;
    if (this.nLR == null)
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJo, 0);
      if ((i != 1) && (!j.IS_FLAVOR_RED) && (!j.DEBUG)) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.nLR = Boolean.valueOf(bool);
      ae.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", new Object[] { Integer.valueOf(i), this.nLR });
      if (!p.i(this.nLR, Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(209585);
      return;
    }
    if (this.nLQ == null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(209585);
      return;
    }
    try
    {
      Object localObject = this.nLQ;
      if (localObject == null) {
        p.gkB();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.nLQ;
      if (localObject == null) {
        p.gkB();
      }
      if (((c)localObject).nLU) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.nLQ;
        if (localObject == null) {
          p.gkB();
        }
        ae.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        c localc = this.nLQ;
        if (localc == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.nLQ = null;
        AppMethodBeat.o(209585);
        return;
        localObject = this.nLQ;
        if (localObject == null) {
          p.gkB();
        }
        bool = ((c)localObject).nLV;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.nLQ = null;
      AppMethodBeat.o(209585);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    public static c bLJ()
    {
      AppMethodBeat.i(209583);
      Object localObject = c.arx();
      a locala = c.nLS;
      localObject = (c)((f)localObject).getValue();
      AppMethodBeat.o(209583);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends q
    implements a<c>
  {
    public static final b nLT;
    
    static
    {
      AppMethodBeat.i(209582);
      nLT = new b();
      AppMethodBeat.o(209582);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final boolean nLU;
    final boolean nLV;
    final int pageType;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.nLU = paramBoolean1;
      this.nLV = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */