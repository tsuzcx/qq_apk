package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.profile.FlowLayoutManager;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "config", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "Lkotlin/collections/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "getRoot", "()Landroid/view/ViewGroup;", "tabDataList", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabFeed;", "getTabDataList", "viewPager", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "forceDark", "", "getActiveFragment", "getActiveIndex", "", "getLayoutId", "getTabList", "onDestroy", "", "onSelectTab", "galleryTabData", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  private final MMActivity activity;
  private final Context context;
  final ArrayList<MMFinderFragment> fragments;
  private final ViewGroup kiF;
  public final ArrayList<k> xTC;
  public final FinderViewPager xTD;
  private final com.tencent.mm.plugin.finder.view.adapter.c xTE;
  final b xTF;
  
  public c(final MMActivity paramMMActivity, ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(273371);
    this.activity = paramMMActivity;
    this.kiF = paramViewGroup;
    this.xTF = paramb;
    this.TAG = "Finder.FinderGalleryCore";
    this.xTC = new ArrayList();
    this.fragments = new ArrayList();
    paramMMActivity = this.kiF.getContext();
    p.j(paramMMActivity, "root.context");
    this.context = paramMMActivity;
    boolean bool = true;
    paramMMActivity = ((Iterable)this.xTF.xTx.xTu).iterator();
    int j;
    final int i;
    if (paramMMActivity.hasNext())
    {
      int k = ((Number)paramMMActivity.next()).intValue();
      j = 1;
      i = j;
      if (k == 5)
      {
        paramViewGroup = aj.AGc;
        i = j;
        if (aj.eei() == 4) {
          i = 0;
        }
      }
      if (i == 0) {
        break label936;
      }
      this.xTC.add(new k(new j(k, this.xTF.ag(this.context, k))));
      this.fragments.add(this.xTF.c(this.context, k, bool));
      bool = false;
    }
    label921:
    label936:
    for (;;)
    {
      break;
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.finder_gallery_default_view, this.kiF, true);
      paramMMActivity = (FinderGalleryTabView)paramViewGroup.findViewById(b.f.tab_view);
      p.k(this, "presenter");
      paramMMActivity.xUi = this;
      paramb = this.xTC;
      LayoutInflater.from(paramMMActivity.getContext()).inflate(b.g.finder_profile_gallery_filter_view, (ViewGroup)paramMMActivity, true);
      paramMMActivity.xUj = ((WxRecyclerView)paramMMActivity.findViewById(b.f.filter_recycler_view));
      Object localObject = paramMMActivity.xUj;
      if (localObject != null) {
        ((WxRecyclerView)localObject).b(paramMMActivity.getItemDecoration());
      }
      localObject = new FlowLayoutManager();
      WxRecyclerView localWxRecyclerView = paramMMActivity.xUj;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      }
      localObject = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderGalleryTabView.a(paramMMActivity), paramb, false);
      ((h)localObject).YSn = ((h.c)new FinderGalleryTabView.c((WxRecyclerAdapter)localObject, paramMMActivity, paramb, this));
      paramb = paramMMActivity.xUj;
      if (paramb != null) {
        paramb.setAdapter((RecyclerView.a)localObject);
      }
      if (this.xTF.dwb())
      {
        paramb = paramMMActivity.xUj;
        if (paramb != null) {
          paramb.setBackgroundColor(paramMMActivity.getResources().getColor(b.c.Dark_5));
        }
      }
      Log.i(paramMMActivity.TAG, "refresh");
      paramb = paramMMActivity.xUj;
      if (paramb != null)
      {
        paramb = paramb.getAdapter();
        if (paramb != null) {
          paramb.notifyDataSetChanged();
        }
      }
      paramViewGroup = paramViewGroup.findViewById(b.f.viewPager);
      p.j(paramViewGroup, "albumView.findViewById(R.id.viewPager)");
      this.xTD = ((FinderViewPager)paramViewGroup);
      this.xTD.setEnableViewPagerScroll(false);
      paramViewGroup = new a(this);
      paramb = this.xTD;
      localObject = this.activity.getSupportFragmentManager();
      p.j(localObject, "activity.supportFragmentManager");
      this.xTE = new com.tencent.mm.plugin.finder.view.adapter.c((e)localObject, (List)this.fragments);
      paramb.setAdapter((androidx.viewpager.widget.a)this.xTE);
      paramb.setOffscreenPageLimit(this.xTC.size() + 1);
      paramb.addOnPageChangeListener((ViewPager.OnPageChangeListener)paramViewGroup);
      paramMMActivity.select(0);
      this.xTD.setCurrentItem(0, false);
      this.xTD.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287382);
          this.xTG.onPageSelected(0);
          AppMethodBeat.o(287382);
        }
      });
      paramViewGroup = f.xUa;
      j = this.activity.getIntent().getIntExtra("BIZ_SCENE", 0);
      paramViewGroup = (Integer)kotlin.a.j.M((List)this.xTF.xTx.xTu, 0);
      long l;
      if (paramViewGroup != null)
      {
        i = paramViewGroup.intValue();
        f.xTZ = f.MR(i);
        switch (j)
        {
        default: 
          l = 0L;
          label723:
          f.Lb(l);
          paramViewGroup = new dx();
          paramViewGroup.qZ(f.sessionId);
          paramViewGroup.kd(l);
          paramViewGroup.ke(1L);
          paramViewGroup.ra(f.MS(i));
          paramViewGroup.kf(f.xTZ);
          paramViewGroup.rb("");
          paramViewGroup.rc(String.valueOf(cm.bfE()));
          paramViewGroup.bpa();
          f.a((com.tencent.mm.plugin.report.a)paramViewGroup);
          paramViewGroup = (List)this.xTC;
          i = 0;
          paramViewGroup = paramViewGroup.iterator();
          label824:
          if (paramViewGroup.hasNext()) {
            if (((k)paramViewGroup.next()).xUh.fXY == 5)
            {
              j = 1;
              label855:
              if (j == 0) {
                break label921;
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        if (i >= 0)
        {
          paramViewGroup = g.AAk;
          g.ecj().a((q)new q()
          {
            public final void onPostEnd(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
            
            public final void onPostNotify(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
            
            public final void onPostOk(long paramAnonymousLong1, long paramAnonymousLong2) {}
            
            public final void onPostStart(long paramAnonymousLong)
            {
              AppMethodBeat.i(289919);
              paramMMActivity.select(i);
              this.xTH.xTD.setCurrentItem(i, false);
              AppMethodBeat.o(289919);
            }
          });
        }
        AppMethodBeat.o(273371);
        return;
        i = 0;
        break;
        l = 1L;
        break label723;
        l = 2L;
        break label723;
        j = 0;
        break label855;
        i += 1;
        break label824;
        i = -1;
      }
    }
  }
  
  public final void a(j paramj)
  {
    int k = 0;
    AppMethodBeat.i(273370);
    p.k(paramj, "galleryTabData");
    Iterator localIterator = ((List)this.xTC).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((k)localIterator.next()).xUh.fXY == paramj.fXY)
      {
        j = 1;
        label67:
        if (j == 0) {
          break label270;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "onSelectTab title:" + paramj.xUf + ", index:" + i);
      if (this.xTD.getCurrentItem() != i)
      {
        this.xTD.setCurrentItem(i, false);
        paramj = f.xUa;
        paramj = (k)kotlin.a.j.M((List)this.xTC, i);
        i = k;
        if (paramj != null)
        {
          paramj = paramj.xUh;
          i = k;
          if (paramj != null) {
            i = paramj.fXY;
          }
        }
        f.xTZ = f.MR(i);
        paramj = new dx();
        paramj.qZ(f.sessionId);
        paramj.kd(f.xTY);
        paramj.ke(2L);
        paramj.ra(f.MS(i));
        paramj.kf(f.xTZ);
        paramj.rb("");
        paramj.rc(String.valueOf(cm.bfE()));
        paramj.bpa();
        f.a((com.tencent.mm.plugin.report.a)paramj);
      }
      AppMethodBeat.o(273370);
      return;
      j = 0;
      break label67;
      label270:
      i += 1;
      break;
      i = -1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryCore$pageListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder_release"})
  public static final class a
    implements ViewPager.OnPageChangeListener
  {
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(220756);
      MMFinderFragment localMMFinderFragment = (MMFinderFragment)kotlin.a.j.M((List)this.xTH.fragments, paramInt);
      if (localMMFinderFragment != null) {
        localMMFinderFragment.onUserVisibleFocused();
      }
      if (localMMFinderFragment == null) {
        Log.e(c.a(this.xTH), "onPageSelected position:" + paramInt + ", size:" + this.xTH.fragments.size());
      }
      AppMethodBeat.o(220756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.c
 * JD-Core Version:    0.7.0.1
 */