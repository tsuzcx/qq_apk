package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "refresh", "select", "index", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGalleryTabView
  extends FrameLayout
{
  WxRecyclerView AZd;
  c Bve;
  final String TAG;
  
  public FinderGalleryTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(334175);
    this.TAG = "Finder.FinderAlbumFilterView";
    AppMethodBeat.o(334175);
  }
  
  public FinderGalleryTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334180);
    this.TAG = "Finder.FinderAlbumFilterView";
    AppMethodBeat.o(334180);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(334226);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(334226);
    return localh;
  }
  
  public final c getPresenter()
  {
    return this.Bve;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.AZd;
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(334223);
    Object localObject1 = this.Bve;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((c)localObject1).Buy;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > paramInt) && (paramInt >= 0))
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((k)((Iterator)localObject2).next()).Bvd = false;
        }
        localObject2 = (k)p.ae((List)localObject1, paramInt);
        if (localObject2 != null) {
          ((k)localObject2).Bvd = true;
        }
        localObject2 = this.TAG;
        localStringBuilder = new StringBuilder("select ").append(paramInt).append(", title:");
        localObject1 = (k)p.ae((List)localObject1, paramInt);
        if (localObject1 != null) {
          break label178;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = getRecyclerView();
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).getAdapter();
        if (localObject1 != null) {
          ((RecyclerView.a)localObject1).bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(334223);
      return;
      label178:
      localObject1 = ((k)localObject1).Bvc;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((j)localObject1).Bvb;
      }
    }
  }
  
  public final void setPresenter(c paramc)
  {
    this.Bve = paramc;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.AZd = paramWxRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTabView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(FinderGalleryTabView paramFinderGalleryTabView) {}
    
    public final f<?> yF(int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(334245);
      if (paramInt == 1)
      {
        localObject = this.Bvf.getPresenter();
        if (localObject == null) {}
        for (;;)
        {
          localObject = (f)new i(bool);
          AppMethodBeat.o(334245);
          return localObject;
          bool = ((c)localObject).Bux.egw();
        }
      }
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
      {
        localObject = new RuntimeException("type invalid");
        AppMethodBeat.o(334245);
        throw ((Throwable)localObject);
      }
      Log.printInfoStack(FinderGalleryTabView.a(this.Bvf), "type invalid", new Object[0]);
      Object localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(334245);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTabView$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(334247);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_5_A);
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(334247);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTabView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    c(WxRecyclerAdapter<k> paramWxRecyclerAdapter, FinderGalleryTabView paramFinderGalleryTabView, ArrayList<k> paramArrayList, c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.FinderGalleryTabView
 * JD-Core Version:    0.7.0.1
 */