package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ab.b;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList
  extends AppBrandLauncherUI.Fragment
{
  public static final a mic;
  private HashMap _$_findViewCache;
  private DragSortListView mia;
  private d mib;
  
  static
  {
    AppMethodBeat.i(51213);
    mic = new a((byte)0);
    AppMethodBeat.o(51213);
  }
  
  public final int getLayoutId()
  {
    return 2131492979;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(51211);
    this.mia = ((DragSortListView)bvd());
    Object localObject1 = this.mia;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener((DragSortListView.h)new b(this));
    }
    localObject1 = this.mia;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener((DragSortListView.l)new c(this));
    }
    localObject1 = getActivity();
    if (localObject1 == null) {
      k.fOy();
    }
    k.g(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    if (localObject2 == null) {
      k.fOy();
    }
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    if (localObject2 == null) {
      k.fOy();
    }
    this.mib = new d((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.mib;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject2 = this.mia;
    if (localObject2 == null) {
      k.fOy();
    }
    k.h(localObject2, "list");
    ((d)localObject1).mia = ((DragSortListView)localObject2);
    localObject2 = ((d)localObject1).mia;
    if (localObject2 == null) {
      k.fOy();
    }
    ((DragSortListView)localObject2).setAdapter((ListAdapter)localObject1);
    AppMethodBeat.o(51211);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(51212);
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null) {
      paramBundle.addTextOptionMenu(0, getString(2131755668), (MenuItem.OnMenuItemClickListener)new d(this), null, s.b.Hoo);
    }
    localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null)
    {
      paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new e(this), 2131689492);
      AppMethodBeat.o(51212);
      return;
    }
    AppMethodBeat.o(51212);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "from", "", "to", "drop"})
  static final class b
    implements DragSortListView.h
  {
    b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void ei(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51204);
      Object localObject = AppBrandCollectionVerticalSortList.a(this.mid);
      if (localObject != null)
      {
        localObject = ((d)localObject).uU(paramInt1);
        if (localObject != null)
        {
          d locald = AppBrandCollectionVerticalSortList.a(this.mid);
          if (locald != null)
          {
            locald.insert(localObject, paramInt2);
            AppMethodBeat.o(51204);
            return;
          }
          AppMethodBeat.o(51204);
          return;
        }
      }
      AppMethodBeat.o(51204);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "which", "", "remove"})
  static final class c
    implements DragSortListView.l
  {
    c(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void remove(int paramInt)
    {
      AppMethodBeat.i(51205);
      d locald = AppBrandCollectionVerticalSortList.a(this.mid);
      if (locald != null)
      {
        locald.uU(paramInt);
        AppMethodBeat.o(51205);
        return;
      }
      AppMethodBeat.o(51205);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51209);
      paramMenuItem = f.jus;
      paramMenuItem = f.aYr();
      if (paramMenuItem == null) {
        k.fOy();
      }
      d locald = AppBrandCollectionVerticalSortList.a(this.mid);
      if (locald == null) {
        k.fOy();
      }
      paramMenuItem.a((List)locald.dataList, (f.b)new f.b()
      {
        public final void aYs()
        {
          AppMethodBeat.i(51208);
          ac.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
          ((c)g.ab(c.class)).a(ab.b.jvS);
          FragmentActivity localFragmentActivity = this.mie.mid.getActivity();
          if (localFragmentActivity != null)
          {
            localFragmentActivity.finish();
            AppMethodBeat.o(51208);
            return;
          }
          AppMethodBeat.o(51208);
        }
        
        public final void b(LocalUsageInfo paramAnonymousLocalUsageInfo)
        {
          AppMethodBeat.i(51206);
          k.h(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.mie.mid.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.mie.mid.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            j.a(paramAnonymousLocalUsageInfo, 6, i, (String)localObject);
            AppMethodBeat.o(51206);
            return;
            i = 0;
            break;
          }
        }
        
        public final void d(LocalUsageInfo paramAnonymousLocalUsageInfo)
        {
          AppMethodBeat.i(51207);
          k.h(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.mie.mid.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.mie.mid.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            j.a(paramAnonymousLocalUsageInfo, 7, i, (String)localObject);
            AppMethodBeat.o(51207);
            return;
            i = 0;
            break;
          }
        }
      });
      AppMethodBeat.o(51209);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51210);
      paramMenuItem = this.mid.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(51210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList
 * JD-Core Version:    0.7.0.1
 */