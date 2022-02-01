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
import com.tencent.mm.plugin.appbrand.appusage.aa.b;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList
  extends AppBrandLauncherUI.Fragment
{
  public static final a oaT;
  private HashMap _$_findViewCache;
  private DragSortListView oaR;
  private b oaS;
  
  static
  {
    AppMethodBeat.i(51213);
    oaT = new a((byte)0);
    AppMethodBeat.o(51213);
  }
  
  public final int getLayoutId()
  {
    return 2131493019;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(51211);
    this.oaR = ((DragSortListView)bXc());
    Object localObject1 = this.oaR;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener((DragSortListView.h)new b(this));
    }
    localObject1 = this.oaR;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener((DragSortListView.l)new c(this));
    }
    localObject1 = getActivity();
    if (localObject1 == null) {
      p.hyc();
    }
    p.g(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    if (localObject2 == null) {
      p.hyc();
    }
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    if (localObject2 == null) {
      p.hyc();
    }
    this.oaS = new b((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.oaS;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject2 = this.oaR;
    if (localObject2 == null) {
      p.hyc();
    }
    p.h(localObject2, "list");
    ((b)localObject1).oaR = ((DragSortListView)localObject2);
    localObject2 = ((b)localObject1).oaR;
    if (localObject2 == null) {
      p.hyc();
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
      paramBundle.addTextOptionMenu(0, getString(2131755718), (MenuItem.OnMenuItemClickListener)new d(this), null, t.b.OGW);
    }
    localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null)
    {
      paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new e(this), 2131689494);
      AppMethodBeat.o(51212);
      return;
    }
    AppMethodBeat.o(51212);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "from", "", "to", "drop"})
  static final class b
    implements DragSortListView.h
  {
    b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void ey(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(51204);
      Object localObject = AppBrandCollectionVerticalSortList.a(this.oaU);
      if (localObject != null)
      {
        localObject = ((b)localObject).zt(paramInt1);
        if (localObject != null)
        {
          b localb = AppBrandCollectionVerticalSortList.a(this.oaU);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "which", "", "remove"})
  static final class c
    implements DragSortListView.l
  {
    c(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final void remove(int paramInt)
    {
      AppMethodBeat.i(51205);
      b localb = AppBrandCollectionVerticalSortList.a(this.oaU);
      if (localb != null)
      {
        localb.zt(paramInt);
        AppMethodBeat.o(51205);
        return;
      }
      AppMethodBeat.o(51205);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51209);
      paramMenuItem = f.kUn;
      paramMenuItem = f.bxI();
      if (paramMenuItem == null) {
        p.hyc();
      }
      b localb = AppBrandCollectionVerticalSortList.a(this.oaU);
      if (localb == null) {
        p.hyc();
      }
      paramMenuItem.a((List)localb.kgc, (f.b)new f.b()
      {
        public final void b(LocalUsageInfo paramAnonymousLocalUsageInfo)
        {
          AppMethodBeat.i(51206);
          p.h(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.oaV.oaU.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.oaV.oaU.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            com.tencent.mm.plugin.appbrand.report.l.a(paramAnonymousLocalUsageInfo, 6, i, (String)localObject);
            AppMethodBeat.o(51206);
            return;
            i = 0;
            break;
          }
        }
        
        public final void bxJ()
        {
          AppMethodBeat.i(51208);
          Log.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
          ((c)g.af(c.class)).a(aa.b.kVM);
          FragmentActivity localFragmentActivity = this.oaV.oaU.getActivity();
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
          p.h(paramAnonymousLocalUsageInfo, "info");
          Object localObject = this.oaV.oaU.getArguments();
          int i;
          if (localObject != null)
          {
            i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
            localObject = this.oaV.oaU.getArguments();
            if (localObject == null) {
              break label74;
            }
          }
          label74:
          for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
          {
            com.tencent.mm.plugin.appbrand.report.l.a(paramAnonymousLocalUsageInfo, 7, i, (String)localObject);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51210);
      paramMenuItem = this.oaU.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(51210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList
 * JD-Core Version:    0.7.0.1
 */