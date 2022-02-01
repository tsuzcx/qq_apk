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
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String sUK = "selected_media_items";
  public static final FinderGridGalleryView.a sUL;
  private final String TAG;
  private long pzq;
  private TextView sUA;
  private GridView sUB;
  private MMSwitchBtn sUC;
  private com.tencent.mm.plugin.gallery.ui.a sUD;
  private o sUE;
  private com.tencent.mm.ui.widget.b.a sUF;
  private FinderGridGalleryView.b sUG;
  private int sUH;
  private int sUI;
  private int sUJ;
  private final int[] sUy;
  private final int[] sUz;
  
  static
  {
    AppMethodBeat.i(168364);
    sUL = new FinderGridGalleryView.a((byte)0);
    sUK = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.sUy = new int[] { 2131759231, 2131759233, 2131759232 };
    this.sUz = new int[] { 1, 2, 3 };
    this.sUH = 4;
    this.sUI = 1;
    this.sUJ = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.sUy = new int[] { 2131759231, 2131759233, 2131759232 };
    this.sUz = new int[] { 1, 2, 3 };
    this.sUH = 4;
    this.sUI = 1;
    this.sUJ = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), 2131494056, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131302223);
    p.g(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.sUA = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302565);
    p.g(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.sUC = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131302208);
    p.g(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.sUB = ((GridView)localObject1);
    localObject1 = this.sUB;
    if (localObject1 == null) {
      p.bcb("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.sUH);
    localObject1 = this.sUA;
    if (localObject1 == null) {
      p.bcb("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.sUy[0]);
    this.sUE = new o();
    localObject1 = this.sUE;
    if (localObject1 == null) {
      p.bcb("queryService");
    }
    ((o)localObject1).setQueryType(this.sUz[0]);
    localObject1 = this.sUE;
    if (localObject1 == null) {
      p.bcb("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.pzq = System.currentTimeMillis();
    localObject1 = this.sUE;
    if (localObject1 == null) {
      p.bcb("queryService");
    }
    ((o)localObject1).ax("", this.pzq);
    this.sUD = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.sUD;
    if (localObject1 == null) {
      p.bcb("albumAdapter");
    }
    localObject2 = this.sUE;
    if (localObject2 == null) {
      p.bcb("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).cVs());
    localObject1 = this.sUD;
    if (localObject1 == null) {
      p.bcb("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.sUI);
    localObject1 = this.sUC;
    if (localObject1 == null) {
      p.bcb("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.sUA;
    if (localObject2 == null) {
      p.bcb("mediaTypeTv");
    }
    this.sUF = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.sUF;
    if (localObject1 == null) {
      p.bcb("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.sUF;
    if (localObject1 == null) {
      p.bcb("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((n.e)new e(this));
    localObject1 = this.sUA;
    if (localObject1 == null) {
      p.bcb("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.sUB;
    if (localObject1 == null) {
      p.bcb("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    ad.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.sUG != null)
    {
      Bundle localBundle = new Bundle();
      String str = sUK;
      com.tencent.mm.plugin.gallery.ui.a locala = this.sUD;
      if (locala == null) {
        p.bcb("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.cVO());
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
      ad.i(str, localInteger + " medias");
      if ((this.pzq == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.sUH = paramInt;
    GridView localGridView = this.sUB;
    if (localGridView == null) {
      p.bcb("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.sUJ = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    p.h(paramb, "onItemSelectedListener");
    this.sUG = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.sUM;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.sUM);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.sUM).cVQ() > FinderGridGalleryView.a(this.sUM))
        {
          FinderGridGalleryView.c(this.sUM).cVO().clear();
          FinderGridGalleryView.c(this.sUM).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.sUM).setSelectLimitCount(FinderGridGalleryView.a(this.sUM));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.sUM);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.e
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.sUM).setText(FinderGridGalleryView.d(this.sUM)[paramInt]);
      FinderGridGalleryView.f(this.sUM).setQueryType(FinderGridGalleryView.g(this.sUM)[paramInt]);
      FinderGridGalleryView.c(this.sUM).clear();
      FinderGridGalleryView.c(this.sUM).setQueryType(FinderGridGalleryView.f(this.sUM).cVs());
      FinderGridGalleryView.a(this.sUM, System.currentTimeMillis());
      FinderGridGalleryView.f(this.sUM).ax("", FinderGridGalleryView.h(this.sUM));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderGridGalleryView.i(this.sUM).fGP();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168354);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements AdapterView.OnItemClickListener
  {
    g(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168355);
      b localb = new b();
      localb.bd(paramAdapterView);
      localb.bd(paramView);
      localb.mr(paramInt);
      localb.qY(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
      if (FinderGridGalleryView.j(this.sUM) != null) {
        p.g(FinderGridGalleryView.c(this.sUM).cVP().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(168355);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.sUM).clear();
      FinderGridGalleryView.c(this.sUM).ar(paramLinkedList);
      FinderGridGalleryView.c(this.sUM).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */