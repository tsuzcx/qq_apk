package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class b
  implements com.tencent.mm.plugin.ball.c.a
{
  private static final f kPd;
  public static final a rYN;
  private volatile c rYL;
  private Boolean rYM;
  
  static
  {
    AppMethodBeat.i(188185);
    rYN = new a((byte)0);
    kPd = g.a(k.aazB, (kotlin.g.a.a)b.rYO);
    AppMethodBeat.o(188185);
  }
  
  public final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188177);
    Log.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.rYL = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(188177);
  }
  
  public final void kU(boolean paramBoolean)
  {
    AppMethodBeat.i(188182);
    Log.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.rYL = null;
    }
    AppMethodBeat.o(188182);
  }
  
  public final void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(188180);
    if (this.rYM == null) {
      this.rYM = Boolean.TRUE;
    }
    if (p.h(this.rYM, Boolean.FALSE))
    {
      AppMethodBeat.o(188180);
      return;
    }
    if (this.rYL == null)
    {
      h.IzE.a(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(188180);
      return;
    }
    try
    {
      Object localObject = this.rYL;
      if (localObject == null) {
        p.iCn();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.rYL;
      if (localObject == null) {
        p.iCn();
      }
      if (((c)localObject).rYP) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.rYL;
        if (localObject == null) {
          p.iCn();
        }
        Log.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = h.IzE;
        c localc = this.rYL;
        if (localc == null) {
          p.iCn();
        }
        ((h)localObject).a(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.rYL = null;
        AppMethodBeat.o(188180);
        return;
        localObject = this.rYL;
        if (localObject == null) {
          p.iCn();
        }
        boolean bool = ((c)localObject).rYQ;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.rYL = null;
      AppMethodBeat.o(188180);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    public static b cvS()
    {
      AppMethodBeat.i(187885);
      Object localObject = b.aRW();
      a locala = b.rYN;
      localObject = (b)((f)localObject).getValue();
      AppMethodBeat.o(187885);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<b>
  {
    public static final b rYO;
    
    static
    {
      AppMethodBeat.i(186468);
      rYO = new b();
      AppMethodBeat.o(186468);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final int pageType;
    final boolean rYP;
    final boolean rYQ;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.rYP = paramBoolean1;
      this.rYQ = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */