package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.e.b;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCollectionVerticalSortList
  extends AppBrandLauncherUI.Fragment
{
  public static final AppBrandCollectionVerticalSortList.a uih;
  private DragSortListView uii;
  private b uij;
  
  static
  {
    AppMethodBeat.i(51213);
    uih = new AppBrandCollectionVerticalSortList.a((byte)0);
    AppMethodBeat.o(51213);
  }
  
  private static final void a(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList, int paramInt)
  {
    AppMethodBeat.i(322648);
    s.u(paramAppBrandCollectionVerticalSortList, "this$0");
    paramAppBrandCollectionVerticalSortList = paramAppBrandCollectionVerticalSortList.uij;
    if (paramAppBrandCollectionVerticalSortList != null) {
      paramAppBrandCollectionVerticalSortList.Dq(paramInt);
    }
    AppMethodBeat.o(322648);
  }
  
  private static final void a(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(322646);
    s.u(paramAppBrandCollectionVerticalSortList, "this$0");
    Object localObject = paramAppBrandCollectionVerticalSortList.uij;
    if (localObject != null)
    {
      localObject = ((b)localObject).Dq(paramInt1);
      if (localObject != null)
      {
        paramAppBrandCollectionVerticalSortList = paramAppBrandCollectionVerticalSortList.uij;
        if (paramAppBrandCollectionVerticalSortList != null) {
          paramAppBrandCollectionVerticalSortList.insert(localObject, paramInt2);
        }
      }
    }
    AppMethodBeat.o(322646);
  }
  
  private static final boolean a(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322652);
    s.u(paramAppBrandCollectionVerticalSortList, "this$0");
    paramMenuItem = e.qOs;
    paramMenuItem = e.ciB();
    s.checkNotNull(paramMenuItem);
    b localb = paramAppBrandCollectionVerticalSortList.uij;
    s.checkNotNull(localb);
    paramMenuItem.a((List)localb.pUj, (e.b)new AppBrandCollectionVerticalSortList.b(paramAppBrandCollectionVerticalSortList));
    AppMethodBeat.o(322652);
    return true;
  }
  
  private static final boolean b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322654);
    s.u(paramAppBrandCollectionVerticalSortList, "this$0");
    paramAppBrandCollectionVerticalSortList = paramAppBrandCollectionVerticalSortList.getActivity();
    if (paramAppBrandCollectionVerticalSortList != null) {
      paramAppBrandCollectionVerticalSortList.finish();
    }
    AppMethodBeat.o(322654);
    return true;
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_collection_sort_list;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(51211);
    this.uii = ((DragSortListView)this.mContentView.findViewById(16908298));
    Object localObject1 = this.uii;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener(new AppBrandCollectionVerticalSortList..ExternalSyntheticLambda2(this));
    }
    localObject1 = this.uii;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener(new AppBrandCollectionVerticalSortList..ExternalSyntheticLambda3(this));
    }
    localObject1 = getActivity();
    s.checkNotNull(localObject1);
    s.s(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    s.checkNotNull(localObject2);
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    s.checkNotNull(localObject2);
    s.s(localObject2, "arguments!!.getParcelabl…rrayList(KEY_DATA_LIST)!!");
    this.uij = new b((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.uij;
    s.checkNotNull(localObject1);
    localObject2 = this.uii;
    s.checkNotNull(localObject2);
    s.u(localObject2, "list");
    ((b)localObject1).uii = ((DragSortListView)localObject2);
    localObject2 = ((b)localObject1).uii;
    s.checkNotNull(localObject2);
    ((DragSortListView)localObject2).setAdapter((ListAdapter)localObject1);
    AppMethodBeat.o(51211);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(51212);
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if ((paramBundle instanceof MMActivity))
    {
      paramBundle = (MMActivity)paramBundle;
      if (paramBundle != null) {
        paramBundle.addTextOptionMenu(0, getString(ba.i.app_brand_star_sort_finish), new AppBrandCollectionVerticalSortList..ExternalSyntheticLambda0(this), null, y.b.adEL);
      }
      paramBundle = getActivity();
      if (!(paramBundle instanceof MMActivity)) {
        break label102;
      }
    }
    label102:
    for (paramBundle = (MMActivity)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null) {
        paramBundle.setBackBtn(new AppBrandCollectionVerticalSortList..ExternalSyntheticLambda1(this), ba.h.actionbar_icon_dark_close);
      }
      AppMethodBeat.o(51212);
      return;
      paramBundle = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList
 * JD-Core Version:    0.7.0.1
 */