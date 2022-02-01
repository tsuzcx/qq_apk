package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180693);
    s.u(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(ba.h.icons_filled_myminiprogram);
    paramWeImageView.setIconColor(getActivity().getResources().getColor(ba.c.Yellow));
    AppMethodBeat.o(180693);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(51291);
    String str = getActivity().getString(ba.i.app_brand_recents_list_collection_entrance);
    s.s(str, "activity.getString(R.str…list_collection_entrance)");
    AppMethodBeat.o(51291);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51292);
    paramView = getActivity().getIntent();
    if ((paramView != null) && (paramView.getIntExtra("extra_get_usage_reason", 3) == 9))
    {
      i = 1;
      if (i == 0) {
        break label189;
      }
    }
    label189:
    for (int i = 2;; i = 0)
    {
      paramView = AppBrandLauncherFolderUI.uaM;
      paramView = getActivity();
      s.s(paramView, "activity");
      paramView = (Context)paramView;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("extra_get_usage_reason", 8);
      ((Intent)localObject).putExtra("extra_get_usage_prescene", i);
      ((Intent)localObject).putExtra("extra_enter_scene", 1);
      ah localah = ah.aiuX;
      AppBrandLauncherFolderUI.a.E(paramView, (Intent)localObject);
      paramView = f.tNH;
      localObject = getActivity();
      s.s(localObject, "activity");
      paramView = paramView.a((FragmentActivity)localObject);
      h.OAn.b(19468, new Object[] { Integer.valueOf(5), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
      AppMethodBeat.o(51292);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.b
 * JD-Core Version:    0.7.0.1
 */