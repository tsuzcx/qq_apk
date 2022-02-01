package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "plugin-appbrand-integration_release"})
public final class i
  extends h
{
  public i(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup, true);
    AppMethodBeat.i(180713);
    AppMethodBeat.o(180713);
  }
  
  protected final List<a> a(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180710);
    p.h(paramFragmentActivity, "context");
    p.h(paramViewGroup, "childrenContainer");
    ArrayList localArrayList = new ArrayList(2);
    a((List)localArrayList, super.b(paramFragmentActivity, paramViewGroup));
    a((List)localArrayList, super.c(paramFragmentActivity, paramViewGroup));
    paramFragmentActivity = (List)localArrayList;
    AppMethodBeat.o(180710);
    return paramFragmentActivity;
  }
  
  protected final a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(224377);
    paramFragmentActivity = super.b(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.o(224377);
    return paramFragmentActivity;
  }
  
  protected final a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(224378);
    paramFragmentActivity = super.c(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.o(224378);
    return paramFragmentActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i
 * JD-Core Version:    0.7.0.1
 */