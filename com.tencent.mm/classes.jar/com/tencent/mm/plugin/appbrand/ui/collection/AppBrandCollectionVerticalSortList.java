package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.aa.b;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList
  extends AppBrandLauncherUI.Fragment
{
  public static final AppBrandCollectionVerticalSortList.a rcy;
  private HashMap _$_findViewCache;
  private DragSortListView rcw;
  private b rcx;
  
  static
  {
    AppMethodBeat.i(51213);
    rcy = new AppBrandCollectionVerticalSortList.a((byte)0);
    AppMethodBeat.o(51213);
  }
  
  public final int getLayoutId()
  {
    return au.g.app_brand_collection_sort_list;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(51211);
    this.rcw = ((DragSortListView)cjG());
    Object localObject1 = this.rcw;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener((DragSortListView.h)new b(this));
    }
    localObject1 = this.rcw;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener((DragSortListView.l)new c(this));
    }
    localObject1 = getActivity();
    if (localObject1 == null) {
      p.iCn();
    }
    p.j(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    if (localObject2 == null) {
      p.iCn();
    }
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    if (localObject2 == null) {
      p.iCn();
    }
    this.rcx = new b((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.rcx;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject2 = this.rcw;
    if (localObject2 == null) {
      p.iCn();
    }
    p.k(localObject2, "list");
    ((b)localObject1).rcw = ((DragSortListView)localObject2);
    localObject2 = ((b)localObject1).rcw;
    if (localObject2 == null) {
      p.iCn();
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
      paramBundle.addTextOptionMenu(0, getString(au.i.app_brand_star_sort_finish), (MenuItem.OnMenuItemClickListener)new d(this), null, w.b.Waq);
    }
    localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null)
    {
      paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new e(this), au.h.actionbar_icon_dark_close);
      AppMethodBeat.o(51212);
      return;
    }
    AppMethodBeat.o(51212);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "from", "", "to", "drop"})
  static final class b
    implements DragSortListView.h
  {
    b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void eX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51204);
      Object localObject = AppBrandCollectionVerticalSortList.a(this.rcz);
      if (localObject != null)
      {
        localObject = ((b)localObject).CW(paramInt1);
        if (localObject != null)
        {
          b localb = AppBrandCollectionVerticalSortList.a(this.rcz);
          if (localb != null)
          {
            localb.insert(localObject, paramInt2);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "which", "", "remove"})
  static final class c
    implements DragSortListView.l
  {
    c(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void remove(int paramInt)
    {
      AppMethodBeat.i(51205);
      b localb = AppBrandCollectionVerticalSortList.a(this.rcz);
      if (localb != null)
      {
        localb.CW(paramInt);
        AppMethodBeat.o(51205);
        return;
      }
      AppMethodBeat.o(51205);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51209);
      paramMenuItem = f.nOA;
      paramMenuItem = f.bIX();
      if (paramMenuItem == null) {
        p.iCn();
      }
      b localb = AppBrandCollectionVerticalSortList.a(this.rcz);
      if (localb == null) {
        p.iCn();
      }
      paramMenuItem.a((List)localb.mXB, (f.b)new f.b()
      {
        public final void b(LocalUsageInfo paramAnonymousLocalUsageInfo)
        {
          AppMethodBeat.i(51206);
          p.k(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.rcA.rcz.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.rcA.rcz.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            m.a(paramAnonymousLocalUsageInfo, 6, i, (String)localObject);
            AppMethodBeat.o(51206);
            return;
            i = 0;
            break;
          }
        }
        
        public final void bIY()
        {
          AppMethodBeat.i(51208);
          Log.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
          ((c)h.ae(c.class)).a(aa.b.nPZ);
          FragmentActivity localFragmentActivity = this.rcA.rcz.getActivity();
          if (localFragmentActivity != null)
          {
            localFragmentActivity.finish();
            AppMethodBeat.o(51208);
            return;
          }
          AppMethodBeat.o(51208);
        }
        
        public final void d(LocalUsageInfo paramAnonymousLocalUsageInfo)
        {
          AppMethodBeat.i(51207);
          p.k(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.rcA.rcz.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.rcA.rcz.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            m.a(paramAnonymousLocalUsageInfo, 7, i, (String)localObject);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51210);
      paramMenuItem = this.rcz.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(51210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList
 * JD-Core Version:    0.7.0.1
 */