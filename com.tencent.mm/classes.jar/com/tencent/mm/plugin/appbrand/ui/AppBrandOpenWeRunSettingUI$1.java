package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class AppBrandOpenWeRunSettingUI$1
  implements View.OnClickListener
{
  AppBrandOpenWeRunSettingUI$1(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void onClick(View paramView)
  {
    d.jdMethod_if(13);
    paramView = this.hdj;
    paramView.getString(y.j.app_tip);
    paramView.hdi = h.b(paramView, paramView.getString(y.j.settings_plugins_installing), true, null);
    paramView.hdi.show();
    g.DO().dJT.a(30, paramView);
    paramView = new LinkedList();
    paramView.add("gh_43f2581f6fd6");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(1));
    paramView = new m(1, paramView, localLinkedList, "", "");
    g.DO().dJT.a(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.1
 * JD-Core Version:    0.7.0.1
 */