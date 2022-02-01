package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.b;

final class AppBrandLauncherUI$4
  implements View.OnLongClickListener
{
  AppBrandLauncherUI$4(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(48628);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if (WeChatEnvironment.hasDebugger())
    {
      paramView = this.uaV;
      k.a(paramView, paramView.getResources().getString(ba.i.appbrand_debugger_search_by_appid_title), "", "", 2147483647, new k.b()
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(48627);
          if (!TextUtils.isEmpty(paramAnonymousCharSequence))
          {
            paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1001;
            f.teH.a(paramView, "", paramAnonymousCharSequence, null, 0, 0, localAppBrandStatObject, null, null);
            AppMethodBeat.o(48627);
            return true;
          }
          AppMethodBeat.o(48627);
          return false;
        }
      });
      a.a(true, this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(48628);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(48628);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.4
 * JD-Core Version:    0.7.0.1
 */