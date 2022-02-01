package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ck;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "refresh", "plugin-finder_release"})
public final class FinderTopicFilterView
  extends FrameLayout
{
  private final String TAG;
  public b uZq;
  public WxRecyclerView ufR;
  
  public FinderTopicFilterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(249998);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(249998);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(249999);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(249999);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(250000);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(250000);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(249997);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(249997);
    return localh;
  }
  
  public final b getPresenter()
  {
    return this.uZq;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.ufR;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(249996);
    Log.i(this.TAG, "refresh");
    Object localObject = this.ufR;
    if (localObject != null)
    {
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
        AppMethodBeat.o(249996);
        return;
      }
    }
    AppMethodBeat.o(249996);
  }
  
  public final void setPresenter(b paramb)
  {
    this.uZq = paramb;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.ufR = paramWxRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(249993);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(249993);
          throw ((Throwable)localObject);
        }
        break;
      case 1: 
        localObject = (e)new ck();
        AppMethodBeat.o(249993);
        return localObject;
      }
      Log.printInfoStack(FinderTopicFilterView.a(this.uZr), "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(249993);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249994);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      int i = (int)paramView.getResources().getDimension(2131165277);
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(249994);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements g.c<h>
  {
    public c(WxRecyclerAdapter paramWxRecyclerAdapter, FinderTopicFilterView paramFinderTopicFilterView, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderTopicFilterView
 * JD-Core Version:    0.7.0.1
 */