package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.profile.FlowLayoutManager;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.upload.r;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "config", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "Lkotlin/collections/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "lastPosition", "", "getLastPosition", "()I", "setLastPosition", "(I)V", "myPostIndex", "getMyPostIndex", "setMyPostIndex", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "getRoot", "()Landroid/view/ViewGroup;", "tabDataList", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabFeed;", "getTabDataList", "tabView", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabView;", "getTabView", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabView;", "viewPager", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "forceDark", "", "getActiveFragment", "getActiveIndex", "getLayoutId", "getTabList", "onDestroy", "", "onSelectTab", "galleryTabData", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final FinderViewPager BsX;
  public int BuA;
  final FinderGalleryTabView BuB;
  public r BuC;
  int BuD;
  final b Bux;
  public final ArrayList<k> Buy;
  private final com.tencent.mm.plugin.finder.view.adapter.c Buz;
  private final String TAG;
  private final MMActivity activity;
  private final Context context;
  final ArrayList<MMFinderFragment> fragments;
  private final ViewGroup mJe;
  
  public c(MMActivity paramMMActivity, ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(334365);
    this.activity = paramMMActivity;
    this.mJe = paramViewGroup;
    this.Bux = paramb;
    this.TAG = "Finder.FinderGalleryCore";
    this.Buy = new ArrayList();
    this.fragments = new ArrayList();
    this.BuA = -1;
    this.BuD = -1;
    paramMMActivity = this.mJe.getContext();
    s.s(paramMMActivity, "root.context");
    this.context = paramMMActivity;
    boolean bool = true;
    paramMMActivity = ((Iterable)this.Bux.But.BsZ).iterator();
    int j;
    int i;
    if (paramMMActivity.hasNext())
    {
      int k = ((Number)paramMMActivity.next()).intValue();
      j = 1;
      i = j;
      if (k == 5)
      {
        paramViewGroup = av.GiL;
        i = j;
        if (av.fgg() == 4) {
          i = 0;
        }
      }
      if (i == 0) {
        break label1010;
      }
      this.Buy.add(new k(new j(k, this.Bux.ap(this.context, k))));
      this.fragments.add(this.Bux.c(this.context, k, bool));
      bool = false;
    }
    label857:
    label995:
    label1010:
    for (;;)
    {
      break;
      paramMMActivity = LayoutInflater.from(this.context).inflate(e.f.finder_gallery_default_view, this.mJe, true);
      paramViewGroup = paramMMActivity.findViewById(e.e.tab_view);
      s.s(paramViewGroup, "albumView.findViewById<F…ryTabView>(R.id.tab_view)");
      this.BuB = ((FinderGalleryTabView)paramViewGroup);
      paramViewGroup = this.BuB;
      s.u(this, "presenter");
      paramViewGroup.Bve = this;
      paramb = this.Buy;
      LayoutInflater.from(paramViewGroup.getContext()).inflate(e.f.finder_profile_gallery_filter_view, (ViewGroup)paramViewGroup, true);
      paramViewGroup.AZd = ((WxRecyclerView)paramViewGroup.findViewById(e.e.filter_recycler_view));
      Object localObject = paramViewGroup.AZd;
      if (localObject != null) {
        ((RecyclerView)localObject).a(paramViewGroup.getItemDecoration());
      }
      localObject = new FlowLayoutManager();
      WxRecyclerView localWxRecyclerView = paramViewGroup.AZd;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      }
      localObject = new WxRecyclerAdapter((g)new FinderGalleryTabView.a(paramViewGroup), paramb, false);
      ((i)localObject).agOe = ((i.c)new FinderGalleryTabView.c((WxRecyclerAdapter)localObject, paramViewGroup, paramb, this));
      paramb = paramViewGroup.AZd;
      if (paramb != null) {
        paramb.setAdapter((RecyclerView.a)localObject);
      }
      if (this.Bux.egw())
      {
        paramb = paramViewGroup.AZd;
        if (paramb != null) {
          paramb.setBackgroundColor(paramViewGroup.getResources().getColor(e.b.Dark_5));
        }
      }
      paramViewGroup = this.BuB;
      Log.i(paramViewGroup.TAG, "refresh");
      paramViewGroup = paramViewGroup.AZd;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.getAdapter();
        if (paramViewGroup != null) {
          paramViewGroup.bZE.notifyChanged();
        }
      }
      paramMMActivity = paramMMActivity.findViewById(e.e.viewPager);
      s.s(paramMMActivity, "albumView.findViewById(R.id.viewPager)");
      this.BsX = ((FinderViewPager)paramMMActivity);
      this.BsX.setEnableViewPagerScroll(true);
      paramMMActivity = new a(this);
      paramViewGroup = this.BsX;
      paramb = this.activity.getSupportFragmentManager();
      s.s(paramb, "activity.supportFragmentManager");
      this.Buz = new com.tencent.mm.plugin.finder.view.adapter.c(paramb, (List)this.fragments);
      paramViewGroup.setAdapter((androidx.viewpager.widget.a)this.Buz);
      paramViewGroup.setOffscreenPageLimit(this.Buy.size() + 1);
      paramViewGroup.addOnPageChangeListener((ViewPager.OnPageChangeListener)paramMMActivity);
      this.BuB.select(0);
      this.BsX.setCurrentItem(0, false);
      this.BsX.post(new c..ExternalSyntheticLambda0(paramMMActivity));
      paramMMActivity = f.BuT;
      j = this.activity.getIntent().getIntExtra("BIZ_SCENE", 0);
      paramMMActivity = (Integer)p.ae((List)this.Bux.But.BsZ, 0);
      long l;
      if (paramMMActivity == null)
      {
        i = 0;
        f.BuV = f.Ou(i);
        switch (j)
        {
        default: 
          l = 0L;
          label759:
          f.nO(l);
          paramMMActivity = new fh();
          paramMMActivity.pO(f.sessionId);
          paramMMActivity.iGT = l;
          paramMMActivity.iFe = 1L;
          paramMMActivity.pP(f.Ov(i));
          paramMMActivity.iGV = f.BuV;
          paramMMActivity.pQ("");
          paramMMActivity.pR(String.valueOf(cn.bDw()));
          paramMMActivity.bMH();
          f.a((com.tencent.mm.plugin.report.a)paramMMActivity);
          paramMMActivity = (List)this.Buy;
          i = 0;
          paramMMActivity = paramMMActivity.iterator();
          if (paramMMActivity.hasNext()) {
            if (((k)paramMMActivity.next()).Bvc.idY == 5)
            {
              j = 1;
              label888:
              if (j == 0) {
                break label995;
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        this.BuA = i;
        if (this.BuA >= 0)
        {
          this.BuC = ((r)new r()
          {
            public final void onPostEnd(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
            
            public final void onPostNotify(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
            
            public final void onPostOk(long paramAnonymousLong1, long paramAnonymousLong2) {}
            
            public final void onPostStart(long paramAnonymousLong)
            {
              AppMethodBeat.i(334194);
              this.BuE.BuB.select(this.BuE.BuA);
              this.BuE.BsX.setCurrentItem(this.BuE.BuA, false);
              AppMethodBeat.o(334194);
            }
          });
          ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().a(this.BuC);
        }
        AppMethodBeat.o(334365);
        return;
        i = paramMMActivity.intValue();
        break;
        l = 1L;
        break label759;
        l = 2L;
        break label759;
        l = 3L;
        break label759;
        l = 4L;
        break label759;
        j = 0;
        break label888;
        i += 1;
        break label857;
        i = -1;
      }
    }
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(334375);
    s.u(parama, "$pageListener");
    parama.onPageSelected(0);
    AppMethodBeat.o(334375);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(334415);
    s.u(paramj, "galleryTabData");
    Iterator localIterator = ((List)this.Buy).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((k)localIterator.next()).Bvc.idY == paramj.idY)
      {
        j = 1;
        label64:
        if (j == 0) {
          break label137;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "onSelectTab title:" + paramj.Bvb + ", index:" + i);
      if (this.BsX.getCurrentItem() != i) {
        this.BsX.setCurrentItem(i, false);
      }
      AppMethodBeat.o(334415);
      return;
      j = 0;
      break label64;
      label137:
      i += 1;
      break;
      i = -1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryCore$pageListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewPager.OnPageChangeListener
  {
    a(c paramc) {}
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(334182);
      this.BuE.BuB.select(paramInt);
      Object localObject = (MMFinderFragment)p.ae((List)this.BuE.fragments, paramInt);
      if (localObject != null) {
        ((MMFinderFragment)localObject).onUserVisibleFocused();
      }
      if (localObject == null) {
        Log.e(c.a(this.BuE), "onPageSelected position:" + paramInt + ", size:" + this.BuE.fragments.size());
      }
      if (this.BuE.BuD != -1)
      {
        localObject = f.BuT;
        localObject = (k)p.ae((List)this.BuE.Buy, paramInt);
        if (localObject != null) {
          break label226;
        }
      }
      for (;;)
      {
        f.BuV = f.Ou(i);
        localObject = new fh();
        ((fh)localObject).pO(f.sessionId);
        ((fh)localObject).iGT = f.BuU;
        ((fh)localObject).iFe = 2L;
        ((fh)localObject).pP(f.Ov(i));
        ((fh)localObject).iGV = f.BuV;
        ((fh)localObject).pQ("");
        ((fh)localObject).pR(String.valueOf(cn.bDw()));
        ((fh)localObject).bMH();
        f.a((com.tencent.mm.plugin.report.a)localObject);
        this.BuE.BuD = paramInt;
        AppMethodBeat.o(334182);
        return;
        label226:
        localObject = ((k)localObject).Bvc;
        if (localObject != null) {
          i = ((j)localObject).idY;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.c
 * JD-Core Version:    0.7.0.1
 */