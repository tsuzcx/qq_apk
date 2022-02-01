package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.x;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/SupportRecentForwardController$ReportLogic;", "", "context", "Landroid/content/Context;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "actionSheetController", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageActionSheetWC;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageActionSheetWC;)V", "exitType", "", "isMenuClickedCauseActionSheetHide", "", "myTag", "", "toUser", "doSomethingOnMenuClick", "", "isForwardClicked", "getLocalAppMsgType", "onRecentForwardClick", "username", "reportOnActionSheetHideIfNeed", "reset", "tryReport", "getRecentForwardReportInfo", "Lcom/tencent/mm/protocal/protobuf/RecentForwardReportInfo;", "toShowString", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class cj$b
{
  public static final cj.b.a tBB;
  final String djQ;
  private int lsO;
  private final ah sue;
  private boolean tBC;
  String toUser;
  
  static
  {
    AppMethodBeat.i(324822);
    tBB = new cj.b.a((byte)0);
    AppMethodBeat.o(324822);
  }
  
  public cj$b(Context paramContext, ah paramah, w paramw)
  {
    AppMethodBeat.i(324817);
    this.sue = paramah;
    this.djQ = s.X("MicroMsg.AppBrand.SupportRecentForwardController.ReportLogic#", Integer.valueOf(hashCode()));
    this.toUser = "";
    this.lsO = 1;
    paramw.tvi = new cj.b..ExternalSyntheticLambda0(this);
    paramw.ar(new cj.b..ExternalSyntheticLambda1(this, paramContext));
    AppMethodBeat.o(324817);
  }
  
  private static final void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(324819);
    s.u(paramb, "this$0");
    s.u(paramContext, "$context");
    Log.i(paramb.djQ, "onDismiss#reportOnActionSheetHideIfNeed");
    if (!(paramContext instanceof UIComponentActivity)) {
      Log.w(paramb.djQ, s.X("getRecentForwardReportInfo, context: ", paramContext));
    }
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (emx)a.a.c(paramContext, 14, emx.class);
    if (localObject == null) {
      Log.w(paramb.djQ, "tryReport, recentForwardReportInfo is null");
    }
    for (;;)
    {
      paramb.tBC = false;
      paramb.toUser = "";
      paramb.lsO = 1;
      AppMethodBeat.o(324819);
      return;
      ((emx)localObject).scene = 9;
      if ((2 == paramb.lsO) || (3 == paramb.lsO))
      {
        ((emx)localObject).MFq = "49";
        ((emx)localObject).abrg = "33";
      }
      ((emx)localObject).toUser = paramb.toUser;
      ((emx)localObject).lsO = paramb.lsO;
      ((emx)localObject).Qmp = ((int)(SystemClock.elapsedRealtime() - ((emx)localObject).startTime));
      localObject = com.tencent.mm.pluginsdk.j.a.XUW;
      com.tencent.mm.pluginsdk.j.a.ly(paramContext);
    }
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.appbrand.menu.w paramw)
  {
    AppMethodBeat.i(324818);
    s.u(paramb, "this$0");
    s.u(paramw, "menuInfo");
    Log.i(paramb.djQ, "beforeMenuClick#reportOnActionSheetHideIfNeed");
    if (x.tkk.ordinal() == paramw.id) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.ky(bool);
      AppMethodBeat.o(324818);
      return;
    }
  }
  
  final void ky(boolean paramBoolean)
  {
    AppMethodBeat.i(324835);
    this.tBC = true;
    int i;
    if (paramBoolean) {
      if (((CharSequence)this.toUser).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label92;
        }
        i = 3;
      }
    }
    for (;;)
    {
      this.lsO = i;
      Log.i(this.djQ, "doSomethingOnMenuClick, toUser: " + this.toUser + ", exitType: " + this.lsO);
      AppMethodBeat.o(324835);
      return;
      i = 0;
      break;
      label92:
      i = 2;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cj.b
 * JD-Core Version:    0.7.0.1
 */