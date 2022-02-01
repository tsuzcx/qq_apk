package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-appbrand-integration_release"})
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
    p.k(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(au.h.icons_filled_myminiprogram);
    FragmentActivity localFragmentActivity = getActivity();
    p.j(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(au.c.Yellow));
    AppMethodBeat.o(180693);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(51291);
    String str = getActivity().getString(au.i.app_brand_recents_list_collection_entrance);
    p.j(str, "activity.getString(R.str…list_collection_entrance)");
    AppMethodBeat.o(51291);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51292);
    paramView = getActivity();
    p.j(paramView, "activity");
    paramView = paramView.getIntent();
    if ((paramView != null) && (paramView.getIntExtra("extra_get_usage_reason", 3) == 9)) {}
    for (int i = 2;; i = 0)
    {
      paramView = AppBrandLauncherFolderUI.qVg;
      paramView = getActivity();
      p.j(paramView, "activity");
      paramView = (Context)paramView;
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_get_usage_reason", 8);
      localIntent.putExtra("extra_get_usage_prescene", i);
      localIntent.putExtra("extra_enter_scene", 1);
      AppBrandLauncherFolderUI.a.m(paramView, localIntent);
      paramView = com.tencent.mm.plugin.appbrand.report.f.qJg;
      paramView = getActivity();
      p.j(paramView, "activity");
      paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
      h.IzE.a(19468, new Object[] { Integer.valueOf(5), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
      AppMethodBeat.o(51292);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.b
 * JD-Core Version:    0.7.0.1
 */