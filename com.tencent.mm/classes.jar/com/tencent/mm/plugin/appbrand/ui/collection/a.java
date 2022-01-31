package com.tencent.mm.plugin.appbrand.ui.collection;

import a.a.m;
import a.b;
import a.c;
import a.k;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  extends AppBrandLauncherUI.a
{
  private RecyclerView hfZ;
  private h hga;
  private boolean hgb;
  private ai hgc;
  private final b hgd = c.f((a.d.a.a)new a.h(this));
  private final b hge = c.f((a.d.a.a)new a.i(this));
  private final j.a hgf = (j.a)new b(this);
  private final j.a hgg = (j.a)new a.c(this);
  
  private final void a(boolean paramBoolean, a.d.a.a<? extends Runnable> parama)
  {
    parama = (Runnable)new a.g(this, paramBoolean, parama);
    ai localai = this.hgc;
    if (localai == null) {
      a.d.b.g.cUk();
    }
    if (localai.crg())
    {
      parama.run();
      return;
    }
    localai = this.hgc;
    if (localai == null) {
      a.d.b.g.cUk();
    }
    localai.O(parama);
  }
  
  private static List<LocalUsageInfo> apB()
  {
    Object localObject2 = ((af)com.tencent.mm.kernel.g.r(af.class)).a(2147483647, af.a.fJT);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)m.xol;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label98:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((LocalUsageInfo)localObject3 != null) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label98;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    return (List)localObject1;
  }
  
  public final void aoV()
  {
    RecyclerView localRecyclerView = this.hfZ;
    if (localRecyclerView != null) {
      localRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    Object localObject1 = new RecyclerView((Context)getActivity());
    getActivity();
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new a(this));
    Object localObject2 = new h(new ArrayList());
    this.hga = ((h)localObject2);
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setBackgroundColor(-1);
    ((RecyclerView)localObject1).a((RecyclerView.h)new i());
    ((RecyclerView)localObject1).setItemAnimator(null);
    this.hfZ = ((RecyclerView)localObject1);
    localObject1 = getContentView();
    if (localObject1 == null) {
      throw new k("null cannot be cast to non-null type android.widget.FrameLayout");
    }
    localObject1 = (FrameLayout)localObject1;
    localObject2 = this.hfZ;
    if (localObject2 == null) {
      a.d.b.g.cUk();
    }
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
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
      paramBundle.a(0, getString(y.j.app_brand_star_sort_start), (MenuItem.OnMenuItemClickListener)new a.d(this), s.b.uNz);
    }
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    ((s)e.G(s.class)).d(this.hgf);
    e.aaT().d(this.hgg);
    ai localai = this.hgc;
    if (localai != null) {
      localai.quit();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if (this.hgb)
    {
      a(this);
      this.hgb = false;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    a.d.b.g.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    this.hgc = new ai("AppBrandLauncherCollectionList");
    a(false, (a.d.a.a)new a.e(this));
  }
  
  public static final class a
    extends LinearLayoutManager
  {
    a(a parama)
    {
      super();
    }
    
    public final boolean gM()
    {
      return false;
    }
  }
  
  static final class b
    implements j.a
  {
    b(a parama) {}
    
    public final void a(String paramString, l paraml)
    {
      if ((a.d.b.g.e("batch", paramString)) && (3 == paraml.gbI) && ((paraml.obj instanceof Long))) {}
      for (int i = 1; i != 0; i = 0)
      {
        a.a(this.hgh);
        return;
      }
      a.g(this.hgh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a
 * JD-Core Version:    0.7.0.1
 */