package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;

public final class b
  extends AppBrandLauncherUI.a
{
  public static final b.a hgs = new b.a((byte)0);
  private DragSortListView hgq;
  private c hgr;
  
  public final int getLayoutId()
  {
    return y.h.app_brand_collection_sort_list;
  }
  
  public final void initView()
  {
    this.hgq = ((DragSortListView)aoW());
    Object localObject1 = this.hgq;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setDropListener((DragSortListView.h)new b.b(this));
    }
    localObject1 = this.hgq;
    if (localObject1 != null) {
      ((DragSortListView)localObject1).setRemoveListener((DragSortListView.l)new c(this));
    }
    localObject1 = getActivity();
    if (localObject1 == null) {
      g.cUk();
    }
    g.j(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    Object localObject2 = getArguments();
    if (localObject2 == null) {
      g.cUk();
    }
    localObject2 = ((Bundle)localObject2).getParcelableArrayList("KEY_SORT_DATA_LIST");
    if (localObject2 == null) {
      g.cUk();
    }
    this.hgr = new c((Context)localObject1, (ArrayList)localObject2);
    localObject1 = this.hgr;
    if (localObject1 == null) {
      g.cUk();
    }
    localObject2 = this.hgq;
    if (localObject2 == null) {
      g.cUk();
    }
    g.k(localObject2, "list");
    ((c)localObject1).hgq = ((DragSortListView)localObject2);
    localObject2 = ((c)localObject1).hgq;
    if (localObject2 == null) {
      g.cUk();
    }
    ((DragSortListView)localObject2).setAdapter((ListAdapter)localObject1);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null) {
      paramBundle.a(0, getString(y.j.app_brand_star_sort_finish), (MenuItem.OnMenuItemClickListener)new b.d(this), s.b.uNz);
    }
    localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null) {
      paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new b.e(this), y.i.actionbar_icon_dark_close);
    }
  }
  
  static final class c
    implements DragSortListView.l
  {
    c(b paramb) {}
    
    public final void remove(int paramInt)
    {
      c localc = b.a(this.hgt);
      if (localc != null) {
        localc.mq(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b
 * JD-Core Version:    0.7.0.1
 */