package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-appbrand-integration_release"})
public final class b
  extends f
{
  public b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180693);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690623);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099845));
    AppMethodBeat.o(180693);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(51291);
    String str = getActivity().getString(2131755661);
    p.g(str, "activity.getString(R.str…list_collection_entrance)");
    AppMethodBeat.o(51291);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51292);
    paramView = getActivity();
    p.g(paramView, "activity");
    paramView = paramView.getIntent();
    if ((paramView != null) && (paramView.getIntExtra("extra_get_usage_reason", 3) == 9)) {}
    for (int i = 2;; i = 0)
    {
      paramView = AppBrandLauncherFolderUI.nTH;
      paramView = getActivity();
      p.g(paramView, "activity");
      paramView = (Context)paramView;
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_get_usage_reason", 8);
      localIntent.putExtra("extra_get_usage_prescene", i);
      localIntent.putExtra("extra_enter_scene", 1);
      AppBrandLauncherFolderUI.a.n(paramView, localIntent);
      paramView = com.tencent.mm.plugin.appbrand.report.f.nGV;
      paramView = getActivity();
      p.g(paramView, "activity");
      paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
      h.CyF.a(19468, new Object[] { Integer.valueOf(5), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
      AppMethodBeat.o(51292);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.b
 * JD-Core Version:    0.7.0.1
 */