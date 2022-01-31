package com.tencent.mm.plugin.appbrand.ui.recents;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "inflateRecents", "inflateWagame", "plugin-appbrand-integration_release"})
public final class g
  extends f
{
  public g(Activity paramActivity, ViewGroup paramViewGroup)
  {
    super(paramActivity, paramViewGroup, true, true);
    AppMethodBeat.i(135138);
    AppMethodBeat.o(135138);
  }
  
  protected final a a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(135136);
    paramActivity = super.a(paramActivity, paramViewGroup);
    if (paramActivity != null) {
      paramActivity.eS(false);
    }
    AppMethodBeat.o(135136);
    return paramActivity;
  }
  
  protected final List<a> a(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(135133);
    j.q(paramActivity, "context");
    j.q(paramViewGroup, "childrenContainer");
    ArrayList localArrayList = new ArrayList(2);
    a((List)localArrayList, b(paramActivity, paramViewGroup, paramBoolean));
    a((List)localArrayList, b(paramActivity, paramViewGroup));
    a((List)localArrayList, c(paramActivity, paramViewGroup));
    a((List)localArrayList, a(paramActivity, paramViewGroup));
    paramActivity = (List)localArrayList;
    AppMethodBeat.o(135133);
    return paramActivity;
  }
  
  protected final a b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(135134);
    paramActivity = super.b(paramActivity, paramViewGroup);
    if (paramActivity != null) {
      paramActivity.eS(false);
    }
    AppMethodBeat.o(135134);
    return paramActivity;
  }
  
  protected final a b(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(135137);
    paramActivity = super.b(paramActivity, paramViewGroup, paramBoolean);
    if (paramActivity != null) {
      paramActivity.eS(false);
    }
    AppMethodBeat.o(135137);
    return paramActivity;
  }
  
  protected final a c(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(135135);
    paramActivity = super.c(paramActivity, paramViewGroup);
    if (paramActivity != null) {
      paramActivity.eS(true);
    }
    AppMethodBeat.o(135135);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */