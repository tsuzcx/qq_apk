package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import java.util.List;

final class AppBrandOpenWeRunSettingUI$1
  implements View.OnClickListener
{
  AppBrandOpenWeRunSettingUI$1(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48665);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    c.pl(13);
    paramView = this.nUr;
    paramView.getString(2131755998);
    paramView.nUq = h.a(paramView, paramView.getString(2131765544), true, null);
    paramView.nUq.show();
    g.aAg().hqi.a(30, paramView);
    paramView = new LinkedList();
    paramView.add("gh_43f2581f6fd6");
    localObject = new LinkedList();
    ((LinkedList)localObject).add(Integer.valueOf(1));
    paramView = new p(paramView, (List)localObject, "", "");
    g.aAg().hqi.a(paramView, 0);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.1
 * JD-Core Version:    0.7.0.1
 */