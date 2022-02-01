package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String AYj = "selected_media_items";
  public static final FinderGridGalleryView.a AYk;
  private final int[] AXW;
  private final int[] AXX;
  private TextView AXY;
  private GridView AXZ;
  private MMSwitchBtn AYa;
  private com.tencent.mm.plugin.gallery.ui.a AYb;
  private o AYc;
  private com.tencent.mm.ui.widget.b.a AYd;
  private FinderGridGalleryView.b AYe;
  private int AYf;
  private int AYg;
  private long AYh;
  private int AYi;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(168364);
    AYk = new FinderGridGalleryView.a((byte)0);
    AYj = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.AXW = new int[] { b.j.finder_gallery_mediaType_image, b.j.finder_gallery_mediaType_video, b.j.finder_gallery_mediaType_image_and_video };
    this.AXX = new int[] { 1, 2, 3 };
    this.AYf = 4;
    this.AYg = 1;
    this.AYi = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.AXW = new int[] { b.j.finder_gallery_mediaType_image, b.j.finder_gallery_mediaType_video, b.j.finder_gallery_mediaType_image_and_video };
    this.AXX = new int[] { 1, 2, 3 };
    this.AYf = 4;
    this.AYg = 1;
    this.AYi = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), b.g.finder_grid_gallery_view, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(b.f.media_type_tv);
    p.j(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.AXY = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.f.multi_select_switch);
    p.j(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.AYa = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(b.f.media_grid_view);
    p.j(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.AXZ = ((GridView)localObject1);
    localObject1 = this.AXZ;
    if (localObject1 == null) {
      p.bGy("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.AYf);
    localObject1 = this.AXY;
    if (localObject1 == null) {
      p.bGy("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.AXW[0]);
    this.AYc = new o();
    localObject1 = this.AYc;
    if (localObject1 == null) {
      p.bGy("queryService");
    }
    ((o)localObject1).setQueryType(this.AXX[0]);
    localObject1 = this.AYc;
    if (localObject1 == null) {
      p.bGy("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.AYh = System.currentTimeMillis();
    localObject1 = this.AYc;
    if (localObject1 == null) {
      p.bGy("queryService");
    }
    ((o)localObject1).ax("", this.AYh);
    this.AYb = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.AYb;
    if (localObject1 == null) {
      p.bGy("albumAdapter");
    }
    localObject2 = this.AYc;
    if (localObject2 == null) {
      p.bGy("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).etS());
    localObject1 = this.AYb;
    if (localObject1 == null) {
      p.bGy("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.AYg);
    localObject1 = this.AYa;
    if (localObject1 == null) {
      p.bGy("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.AXY;
    if (localObject2 == null) {
      p.bGy("mediaTypeTv");
    }
    this.AYd = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.AYd;
    if (localObject1 == null) {
      p.bGy("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.AYd;
    if (localObject1 == null) {
      p.bGy("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((q.g)new e(this));
    localObject1 = this.AXY;
    if (localObject1 == null) {
      p.bGy("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.AXZ;
    if (localObject1 == null) {
      p.bGy("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    Log.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.AYe != null)
    {
      Bundle localBundle = new Bundle();
      String str = AYj;
      com.tencent.mm.plugin.gallery.ui.a locala = this.AYb;
      if (locala == null) {
        p.bGy("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.euo());
    }
    AppMethodBeat.o(168360);
  }
  
  public final void b(final LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168361);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("ticket ").append(paramLong).append(" query finished  ");
    if (paramLinkedList != null) {}
    for (Integer localInteger = Integer.valueOf(paramLinkedList.size());; localInteger = null)
    {
      Log.i(str, localInteger + " medias");
      if ((this.AYh == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.AYf = paramInt;
    GridView localGridView = this.AXZ;
    if (localGridView == null) {
      p.bGy("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.AYi = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    p.k(paramb, "onItemSelectedListener");
    this.AYe = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.AYl;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.AYl);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.AYl).euq() > FinderGridGalleryView.a(this.AYl))
        {
          FinderGridGalleryView.c(this.AYl).euo().clear();
          FinderGridGalleryView.c(this.AYl).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.AYl).setSelectLimitCount(FinderGridGalleryView.a(this.AYl));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.AYl);
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramContextMenu.add(paramView[i]);
        i += 1;
      }
      AppMethodBeat.o(168352);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.AYl).setText(FinderGridGalleryView.d(this.AYl)[paramInt]);
      FinderGridGalleryView.f(this.AYl).setQueryType(FinderGridGalleryView.g(this.AYl)[paramInt]);
      FinderGridGalleryView.c(this.AYl).clear();
      FinderGridGalleryView.c(this.AYl).setQueryType(FinderGridGalleryView.f(this.AYl).etS());
      FinderGridGalleryView.a(this.AYl, System.currentTimeMillis());
      FinderGridGalleryView.f(this.AYl).ax("", FinderGridGalleryView.h(this.AYl));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderGridGalleryView.i(this.AYl).hTd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168354);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements AdapterView.OnItemClickListener
  {
    g(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168355);
      b localb = new b();
      localb.bn(paramAdapterView);
      localb.bn(paramView);
      localb.sg(paramInt);
      localb.Fs(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
      if (FinderGridGalleryView.j(this.AYl) != null) {
        p.j(FinderGridGalleryView.c(this.AYl).eup().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(168355);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.AYl).clear();
      FinderGridGalleryView.c(this.AYl).bf(paramLinkedList);
      FinderGridGalleryView.c(this.AYl).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */