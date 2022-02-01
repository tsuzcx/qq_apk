package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f heM;
  public static final a nGq;
  private volatile c nGo;
  private Boolean nGp;
  
  static
  {
    AppMethodBeat.i(217390);
    nGq = new a((byte)0);
    heM = d.g.a(k.MKa, (a)b.nGr);
    AppMethodBeat.o(217390);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217387);
    ad.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.nGo = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(217387);
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(217389);
    ad.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.nGo = null;
    }
    AppMethodBeat.o(217389);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(217388);
    int i;
    if (this.nGp == null)
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBT, 0);
      if ((i != 1) && (!i.IS_FLAVOR_RED) && (!i.DEBUG)) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.nGp = Boolean.valueOf(bool);
      ad.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", new Object[] { Integer.valueOf(i), this.nGp });
      if (!p.i(this.nGp, Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(217388);
      return;
    }
    if (this.nGo == null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(217388);
      return;
    }
    try
    {
      Object localObject = this.nGo;
      if (localObject == null) {
        p.gfZ();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.nGo;
      if (localObject == null) {
        p.gfZ();
      }
      if (((c)localObject).nGs) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.nGo;
        if (localObject == null) {
          p.gfZ();
        }
        ad.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        c localc = this.nGo;
        if (localc == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.nGo = null;
        AppMethodBeat.o(217388);
        return;
        localObject = this.nGo;
        if (localObject == null) {
          p.gfZ();
        }
        bool = ((c)localObject).nGt;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.nGo = null;
      AppMethodBeat.o(217388);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    public static c bKM()
    {
      AppMethodBeat.i(217386);
      Object localObject = c.ari();
      a locala = c.nGq;
      localObject = (c)((f)localObject).getValue();
      AppMethodBeat.o(217386);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends q
    implements a<c>
  {
    public static final b nGr;
    
    static
    {
      AppMethodBeat.i(217385);
      nGr = new b();
      AppMethodBeat.o(217385);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final boolean nGs;
    final boolean nGt;
    final int pageType;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.nGs = paramBoolean1;
      this.nGt = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */