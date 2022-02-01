package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends g
{
  public h(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup, true);
    AppMethodBeat.i(323071);
    AppMethodBeat.o(323071);
  }
  
  protected final List<a> a(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(323079);
    s.u(paramFragmentActivity, "context");
    s.u(paramViewGroup, "childrenContainer");
    ArrayList localArrayList = new ArrayList(2);
    a((List)localArrayList, super.b(paramFragmentActivity, paramViewGroup));
    a((List)localArrayList, super.c(paramFragmentActivity, paramViewGroup));
    paramFragmentActivity = (List)localArrayList;
    AppMethodBeat.o(323079);
    return paramFragmentActivity;
  }
  
  protected final a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(370018);
    paramFragmentActivity = super.b(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.o(370018);
    return paramFragmentActivity;
  }
  
  protected final a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(370019);
    paramFragmentActivity = super.c(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.o(370019);
    return paramFragmentActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */