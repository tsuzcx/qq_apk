package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList
  extends AppBrandLauncherUI.Fragment
{
  public static final a iRH;
  private DragSortListView iRF;
  private c iRG;
  
  static
  {
    AppMethodBeat.i(135049);
    iRH = new a((byte)0);
    AppMethodBeat.o(135049);
  }
  
  public final int getLayoutId()
  {
    return 2130968669;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(135047);
    this.iRF = ((DragSortListView)aMe());
    Object localObject1 = this.iRF;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener((DragSortListView.h)new AppBrandCollectionVerticalSortList.b(this));
    }
    localObject1 = this.iRF;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener((DragSortListView.l)new AppBrandCollectionVerticalSortList.c(this));
    }
    localObject1 = getActivity();
    if (localObject1 == null) {
      j.ebi();
    }
    j.p(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    if (localObject2 == null) {
      j.ebi();
    }
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    if (localObject2 == null) {
      j.ebi();
    }
    this.iRG = new c((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.iRG;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject2 = this.iRF;
    if (localObject2 == null) {
      j.ebi();
    }
    j.q(localObject2, "list");
    ((c)localObject1).iRF = ((DragSortListView)localObject2);
    localObject2 = ((c)localObject1).iRF;
    if (localObject2 == null) {
      j.ebi();
    }
    ((DragSortListView)localObject2).setAdapter((ListAdapter)localObject1);
    AppMethodBeat.o(135047);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(135048);
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null) {
      paramBundle.addTextOptionMenu(0, getString(2131296868), (MenuItem.OnMenuItemClickListener)new AppBrandCollectionVerticalSortList.d(this), null, q.b.zbA);
    }
    localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null)
    {
      paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandCollectionVerticalSortList.e(this), 2131230739);
      AppMethodBeat.o(135048);
      return;
    }
    AppMethodBeat.o(135048);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList
 * JD-Core Version:    0.7.0.1
 */