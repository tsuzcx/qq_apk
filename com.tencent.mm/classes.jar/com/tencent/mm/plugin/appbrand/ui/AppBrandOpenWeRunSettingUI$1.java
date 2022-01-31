package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class AppBrandOpenWeRunSettingUI$1
  implements View.OnClickListener
{
  AppBrandOpenWeRunSettingUI$1(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(132994);
    d.kS(13);
    paramView = this.iNa;
    paramView.getString(2131297087);
    paramView.iMZ = h.b(paramView, paramView.getString(2131303380), true, null);
    paramView.iMZ.show();
    g.RK().eHt.a(30, paramView);
    paramView = new LinkedList();
    paramView.add("gh_43f2581f6fd6");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(1));
    paramView = new m(paramView, localLinkedList, "", "");
    g.RK().eHt.a(paramView, 0);
    AppMethodBeat.o(132994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.1
 * JD-Core Version:    0.7.0.1
 */