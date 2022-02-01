package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.ball.c.a
{
  private static final j<b> nqI;
  public static final a vkc;
  private volatile c vkd;
  private Boolean vke;
  
  static
  {
    AppMethodBeat.i(288406);
    vkc = new a((byte)0);
    nqI = k.a(o.aiuF, (kotlin.g.a.a)b.vkf);
    AppMethodBeat.o(288406);
  }
  
  public final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(288411);
    Log.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.vkd = new c(paramInt, paramBoolean1, paramBoolean2, System.currentTimeMillis());
    AppMethodBeat.o(288411);
  }
  
  public final void mh(boolean paramBoolean)
  {
    AppMethodBeat.i(288415);
    Log.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.vkd = null;
    }
    AppMethodBeat.o(288415);
  }
  
  public final void x(long paramLong, int paramInt)
  {
    AppMethodBeat.i(288414);
    if (this.vke == null) {
      this.vke = Boolean.TRUE;
    }
    if (s.p(this.vke, Boolean.FALSE))
    {
      AppMethodBeat.o(288414);
      return;
    }
    if (this.vkd == null)
    {
      h.OAn.b(20041, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(288414);
      return;
    }
    try
    {
      Object localObject = this.vkd;
      s.checkNotNull(localObject);
      paramLong -= ((c)localObject).timestamp;
      localObject = this.vkd;
      s.checkNotNull(localObject);
      if (((c)localObject).vkg) {
        paramInt = 4;
      }
      for (;;)
      {
        localObject = this.vkd;
        s.checkNotNull(localObject);
        Log.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", new Object[] { Integer.valueOf(((c)localObject).pageType), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        localObject = h.OAn;
        c localc = this.vkd;
        s.checkNotNull(localc);
        ((h)localObject).b(20041, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(localc.pageType) });
        this.vkd = null;
        AppMethodBeat.o(288414);
        return;
        localObject = this.vkd;
        s.checkNotNull(localObject);
        boolean bool = ((c)localObject).vkh;
        if (!bool) {
          paramInt = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallReportService", (Throwable)localException, "onEnterChattingFromNotification exception", new Object[0]);
      this.vkd = null;
      AppMethodBeat.o(288414);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b cYB()
    {
      AppMethodBeat.i(288401);
      b localb = (b)b.blL().getValue();
      AppMethodBeat.o(288401);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<b>
  {
    public static final b vkf;
    
    static
    {
      AppMethodBeat.i(288404);
      vkf = new b();
      AppMethodBeat.o(288404);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "timestamp", "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    final int pageType;
    final long timestamp;
    final boolean vkg;
    final boolean vkh;
    
    public c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    {
      this.pageType = paramInt;
      this.vkg = paramBoolean1;
      this.vkh = paramBoolean2;
      this.timestamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */