package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.cr;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "refresh", "plugin-finder_release"})
public final class FinderTopicFilterView
  extends FrameLayout
{
  private final String TAG;
  WxRecyclerView xUj;
  b zPK;
  
  public FinderTopicFilterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(262458);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(262458);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(262459);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(262459);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(262460);
    this.TAG = "Finder.FinderTopicFilterView";
    AppMethodBeat.o(262460);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(262456);
    Log.i(this.TAG, "refresh");
    Object localObject = this.xUj;
    if (localObject != null)
    {
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
        AppMethodBeat.o(262456);
        return;
      }
    }
    AppMethodBeat.o(262456);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(262457);
    RecyclerView.h localh = (RecyclerView.h)new FinderTopicFilterView.b();
    AppMethodBeat.o(262457);
    return localh;
  }
  
  public final b getPresenter()
  {
    return this.zPK;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.xUj;
  }
  
  public final void setPresenter(b paramb)
  {
    this.zPK = paramb;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.xUj = paramWxRecyclerView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(277289);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(277289);
          throw ((Throwable)localObject);
        }
        break;
      case 1: 
        localObject = (e)new cr();
        AppMethodBeat.o(277289);
        return localObject;
      case 2: 
        localObject = (e)new g();
        AppMethodBeat.o(277289);
        return localObject;
      }
      Log.printInfoStack(FinderTopicFilterView.a(this.zPL), "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(277289);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements h.c<i>
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, FinderTopicFilterView paramFinderTopicFilterView, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderTopicFilterView
 * JD-Core Version:    0.7.0.1
 */