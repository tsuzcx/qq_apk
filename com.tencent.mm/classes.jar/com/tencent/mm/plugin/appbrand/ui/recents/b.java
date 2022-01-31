package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a;
import com.tencent.mm.plugin.appbrand.y.j;
import java.util.List;

public final class b
  extends d<s>
{
  public b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    super(s.class, paramActivity, paramViewGroup);
  }
  
  protected final List<LocalUsageInfo> apM()
  {
    return ((af)com.tencent.mm.kernel.g.r(af.class)).a(this.hgQ, af.a.fJT);
  }
  
  protected final String getTitle()
  {
    String str = getActivity().getString(y.j.app_brand_recents_list_collection_entrance);
    a.d.b.g.j(str, "activity.getString(com.t…list_collection_entrance)");
    return str;
  }
  
  public final void onClick(View paramView)
  {
    paramView = getActivity();
    a.d.b.g.j(paramView, "activity");
    paramView = paramView.getIntent();
    if ((paramView != null) && (paramView.getIntExtra("extra_get_usage_reason", 3) == 9)) {}
    for (int i = 2;; i = 0)
    {
      paramView = AppBrandLauncherFolderUI.hcQ;
      paramView = getActivity();
      a.d.b.g.j(paramView, "activity");
      paramView = (Context)paramView;
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_get_usage_reason", 8);
      localIntent.putExtra("extra_get_usage_prescene", i);
      AppBrandLauncherFolderUI.a.l(paramView, localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.b
 * JD-Core Version:    0.7.0.1
 */