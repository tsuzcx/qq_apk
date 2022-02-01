package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c
  implements com.tencent.mm.plugin.ball.c.a
{
  private static final f iax;
  public static final a oWM;
  private volatile c oWK;
  private Boolean oWL;
  
  static
  {
    AppMethodBeat.i(217159);
    oWM = new a((byte)0);
    iax = kotlin.g.a(k.SWP, (kotlin.g.a.a)b.oWN);
    AppMethodBeat.o(217159);
  }
  
  public final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217156);
    Log.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.oWK = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(217156);
  }
  
  public final void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(217158);
    Log.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.oWK = null;
    }
    AppMethodBeat.o(217158);
  }
  
  public final void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(217157);
    int i;
    if (this.oWL == null)
    {
      i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.seP, 0);
      if ((i != 1) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.oWL = Boolean.valueOf(bool);
      Log.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", new Object[] { Integer.valueOf(i), this.oWL });
      if (!p.j(this.oWL, Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(217157);
      return;
    }
    if (this.oWK == null)
    {
      h.CyF.a(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(217157);
      return;
    }
    try
    {
      Object localObject = this.oWK;
      if (localObject == null) {
        p.hyc();
      }
      paramLong -= ((c)localObject).timestamp;
      localObject = this.oWK;
      if (localObject == null) {
        p.hyc();
      }
      if (((c)localObject).oWO) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.oWK;
        if (localObject == null) {
          p.hyc();
        }
        Log.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = h.CyF;
        c localc = this.oWK;
        if (localc == null) {
          p.hyc();
        }
        ((h)localObject).a(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.oWK = null;
        AppMethodBeat.o(217157);
        return;
        localObject = this.oWK;
        if (localObject == null) {
          p.hyc();
        }
        bool = ((c)localObject).oWP;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.oWK = null;
      AppMethodBeat.o(217157);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    public static c ciA()
    {
      AppMethodBeat.i(217155);
      Object localObject = c.aJW();
      a locala = c.oWM;
      localObject = (c)((f)localObject).getValue();
      AppMethodBeat.o(217155);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<c>
  {
    public static final b oWN;
    
    static
    {
      AppMethodBeat.i(217154);
      oWN = new b();
      AppMethodBeat.o(217154);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
  static final class c
  {
    final boolean oWO;
    final boolean oWP;
    final int pageType;
    final long timestamp;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.oWO = paramBoolean1;
      this.oWP = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */