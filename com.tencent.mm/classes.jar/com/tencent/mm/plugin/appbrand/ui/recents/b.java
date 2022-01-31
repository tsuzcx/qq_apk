package com.tencent.mm.plugin.appbrand.ui.recents;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandStarAppStorage;", "activity", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "queryList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "shouldShowcaseEnableSwitch", "show", "", "plugin-appbrand-integration_release"})
public final class b
  extends d<s>
{
  public b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    super(s.class, paramActivity, paramViewGroup);
  }
  
  protected final List<LocalUsageInfo> aNg()
  {
    AppMethodBeat.i(135125);
    List localList = ((af)g.E(af.class)).a(this.iSr, af.a.hcJ);
    AppMethodBeat.o(135125);
    return localList;
  }
  
  public final void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(135124);
    this.iSt.post((Runnable)new b.a(this, paramBoolean));
    AppMethodBeat.o(135124);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(135126);
    String str = getActivity().getString(2131296817);
    j.p(str, "activity.getString(com.t…list_collection_entrance)");
    AppMethodBeat.o(135126);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135127);
    paramView = getActivity();
    j.p(paramView, "activity");
    paramView = paramView.getIntent();
    if ((paramView != null) && (paramView.getIntExtra("extra_get_usage_reason", 3) == 9)) {}
    for (int i = 2;; i = 0)
    {
      paramView = AppBrandLauncherFolderUI.iMD;
      paramView = getActivity();
      j.p(paramView, "activity");
      paramView = (Context)paramView;
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_get_usage_reason", 8);
      localIntent.putExtra("extra_get_usage_prescene", i);
      localIntent.putExtra("extra_enter_scene", 1);
      AppBrandLauncherFolderUI.a.o(paramView, localIntent);
      AppMethodBeat.o(135127);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.b
 * JD-Core Version:    0.7.0.1
 */