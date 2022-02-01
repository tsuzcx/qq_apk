package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "refresh", "select", "index", "plugin-finder_release"})
public final class FinderGalleryTabView
  extends FrameLayout
{
  final String TAG;
  c xUi;
  WxRecyclerView xUj;
  
  public FinderGalleryTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(268763);
    this.TAG = "Finder.FinderAlbumFilterView";
    AppMethodBeat.o(268763);
  }
  
  public FinderGalleryTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(268764);
    this.TAG = "Finder.FinderAlbumFilterView";
    AppMethodBeat.o(268764);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(268762);
    RecyclerView.h localh = (RecyclerView.h)new FinderGalleryTabView.b();
    AppMethodBeat.o(268762);
    return localh;
  }
  
  public final c getPresenter()
  {
    return this.xUi;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.xUj;
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(268761);
    Object localObject1 = this.xUi;
    if (localObject1 != null)
    {
      localObject1 = ((c)localObject1).xTC;
      if (localObject1 != null)
      {
        if ((((ArrayList)localObject1).size() > paramInt) && (paramInt >= 0))
        {
          Object localObject2 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((k)((Iterator)localObject2).next()).xUg = false;
          }
          localObject2 = (k)kotlin.a.j.M((List)localObject1, paramInt);
          if (localObject2 != null) {
            ((k)localObject2).xUg = true;
          }
          localObject2 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("select ").append(paramInt).append(", title:");
          localObject1 = (k)kotlin.a.j.M((List)localObject1, paramInt);
          if (localObject1 != null)
          {
            localObject1 = ((k)localObject1).xUh;
            if (localObject1 == null) {}
          }
          for (localObject1 = ((j)localObject1).xUf;; localObject1 = null)
          {
            Log.i((String)localObject2, (String)localObject1);
            localObject1 = this.xUj;
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((WxRecyclerView)localObject1).getAdapter();
            if (localObject1 == null) {
              break;
            }
            ((RecyclerView.a)localObject1).notifyDataSetChanged();
            AppMethodBeat.o(268761);
            return;
          }
        }
        AppMethodBeat.o(268761);
        return;
      }
    }
    AppMethodBeat.o(268761);
  }
  
  public final void setPresenter(c paramc)
  {
    this.xUi = paramc;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.xUj = paramWxRecyclerView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTabView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(221953);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(221953);
          throw ((Throwable)localObject);
        }
        break;
      case 1: 
        localObject = this.xUk.getPresenter();
        if (localObject != null) {
          bool = ((c)localObject).xTF.dwb();
        }
        localObject = (e)new i(bool);
        AppMethodBeat.o(221953);
        return localObject;
      }
      Log.printInfoStack(FinderGalleryTabView.a(this.xUk), "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(221953);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTabView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, FinderGalleryTabView paramFinderGalleryTabView, ArrayList paramArrayList, c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.FinderGalleryTabView
 * JD-Core Version:    0.7.0.1
 */