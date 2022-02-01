package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.menu.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.c;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/SupportRecentForwardController;", "", "context", "Landroid/content/Context;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "actionSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "actionSheetController", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageActionSheetWC;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageActionSheetWC;)V", "myTag", "", "performRecentlyForwardClick", "", "toUser", "trySupportIfNeed", "Companion", "ReportLogic", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cj
{
  private static final u.c tBA;
  public static final cj.a tBz;
  private final String djQ;
  
  static
  {
    AppMethodBeat.i(325123);
    tBz = new cj.a((byte)0);
    tBA = cj..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(325123);
  }
  
  public cj(Context paramContext, ah paramah, f paramf, w paramw)
  {
    AppMethodBeat.i(325057);
    this.djQ = kotlin.g.b.s.X("MicroMsg.AppBrand.SupportRecentForwardController#", Integer.valueOf(hashCode()));
    Object localObject = paramah.getRuntime();
    if ((localObject != null) && (1158 == ((d)localObject).asA().epn.scene)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.djQ, "trySupportIfNeed, not need 1");
      AppMethodBeat.o(325057);
      return;
    }
    if (y.tkS == com.tencent.mm.plugin.appbrand.menu.q.a(paramContext, paramah)) {}
    for (i = j; i == 0; i = 0)
    {
      Log.i(this.djQ, "trySupportIfNeed, not need 2");
      AppMethodBeat.o(325057);
      return;
    }
    if (paramf.bottomSheetStyle != 0)
    {
      Log.i(this.djQ, "trySupportIfNeed, not need 3");
      AppMethodBeat.o(325057);
      return;
    }
    localObject = (com.tencent.mm.pluginsdk.q)h.ax(com.tencent.mm.pluginsdk.q.class);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((com.tencent.mm.pluginsdk.q)localObject).iGI())
    {
      Log.w(this.djQ, "trySupportIfNeed, recentForwardMenuHelper is null");
      AppMethodBeat.o(325057);
      return;
    }
    cj.b localb = new cj.b(paramContext, paramah, paramw);
    paramf.GAx = new cj..ExternalSyntheticLambda1((com.tencent.mm.pluginsdk.q)localObject, paramContext, paramf, paramw);
    paramf.agen = new cj..ExternalSyntheticLambda3((com.tencent.mm.pluginsdk.q)localObject, this, paramContext, paramah, localb);
    paramf.ageo = new cj..ExternalSyntheticLambda2((com.tencent.mm.pluginsdk.q)localObject, paramf);
    AppMethodBeat.o(325057);
  }
  
  private static final void a(ImageView paramImageView, t paramt)
  {
    AppMethodBeat.i(325100);
    try
    {
      Object localObject = c.uqm;
      kotlin.g.b.s.s(paramImageView, "iconIv");
      localObject = paramt.rDm;
      kotlin.g.b.s.s(localObject, "menuItem.webUrl");
      c.b(paramImageView, (String)localObject);
      AppMethodBeat.o(325100);
      return;
    }
    catch (Exception paramImageView)
    {
      Log.e("MicroMsg.AppBrand.SupportRecentForwardController", "attachAvatar for username:" + paramt.rDm + ", get exception:" + paramImageView);
      AppMethodBeat.o(325100);
    }
  }
  
  private static final void a(com.tencent.mm.pluginsdk.q paramq, Context paramContext, final f paramf, w paramw, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(325066);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramf, "$actionSheet");
    kotlin.g.b.s.u(paramw, "$actionSheetController");
    kotlin.g.b.s.s(params, "menu");
    paramq.a(paramContext, params, paramf, tBA, 3, (b)new c(paramw, paramf));
    AppMethodBeat.o(325066);
  }
  
  private static final void a(com.tencent.mm.pluginsdk.q paramq, cj paramcj, Context paramContext, ah paramah, cj.b paramb, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(325074);
    kotlin.g.b.s.u(paramcj, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramah, "$pageView");
    kotlin.g.b.s.u(paramb, "$reportLogic");
    if (!(paramMenuItem instanceof t))
    {
      AppMethodBeat.o(325074);
      return;
    }
    paramq.a((t)paramMenuItem, (b)new cj.d(paramcj, paramContext, paramah, paramb));
    AppMethodBeat.o(325074);
  }
  
  private static final void a(com.tencent.mm.pluginsdk.q paramq, f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(325083);
    kotlin.g.b.s.u(paramf, "$actionSheet");
    if (!(paramMenuItem instanceof t))
    {
      AppMethodBeat.o(325083);
      return;
    }
    paramq.a(paramf, (t)paramMenuItem, 3);
    AppMethodBeat.o(325083);
  }
  
  private static final void c(com.tencent.mm.plugin.appbrand.menu.w paramw, String paramString)
  {
    AppMethodBeat.i(325087);
    kotlin.g.b.s.u(paramString, "$toUser");
    if (paramw != null)
    {
      paramw.rDC.aY("share_to_user", paramString);
      AppMethodBeat.o(325087);
      return;
    }
    Log.w("MicroMsg.AppBrand.WxaMenuHelper", "safeSetString, menuInfo is null, key: ".concat(String.valueOf("share_to_user")));
    AppMethodBeat.o(325087);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "show", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Boolean, kotlin.ah>
  {
    c(w paramw, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cj
 * JD-Core Version:    0.7.0.1
 */