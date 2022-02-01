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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String wnf = "selected_media_items";
  public static final FinderGridGalleryView.a wng;
  private final String TAG;
  private long qVk;
  private final int[] wmT;
  private final int[] wmU;
  private TextView wmV;
  private GridView wmW;
  private MMSwitchBtn wmX;
  private com.tencent.mm.plugin.gallery.ui.a wmY;
  private o wmZ;
  private com.tencent.mm.ui.widget.b.a wna;
  private FinderGridGalleryView.b wnb;
  private int wnc;
  private int wnd;
  private int wne;
  
  static
  {
    AppMethodBeat.i(168364);
    wng = new FinderGridGalleryView.a((byte)0);
    wnf = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.wmT = new int[] { 2131759799, 2131759801, 2131759800 };
    this.wmU = new int[] { 1, 2, 3 };
    this.wnc = 4;
    this.wnd = 1;
    this.wne = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.wmT = new int[] { 2131759799, 2131759801, 2131759800 };
    this.wmU = new int[] { 1, 2, 3 };
    this.wnc = 4;
    this.wnd = 1;
    this.wne = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), 2131494338, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131304575);
    p.g(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.wmV = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131304997);
    p.g(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.wmX = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131304557);
    p.g(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.wmW = ((GridView)localObject1);
    localObject1 = this.wmW;
    if (localObject1 == null) {
      p.btv("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.wnc);
    localObject1 = this.wmV;
    if (localObject1 == null) {
      p.btv("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.wmT[0]);
    this.wmZ = new o();
    localObject1 = this.wmZ;
    if (localObject1 == null) {
      p.btv("queryService");
    }
    ((o)localObject1).setQueryType(this.wmU[0]);
    localObject1 = this.wmZ;
    if (localObject1 == null) {
      p.btv("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.qVk = System.currentTimeMillis();
    localObject1 = this.wmZ;
    if (localObject1 == null) {
      p.btv("queryService");
    }
    ((o)localObject1).ax("", this.qVk);
    this.wmY = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.wmY;
    if (localObject1 == null) {
      p.btv("albumAdapter");
    }
    localObject2 = this.wmZ;
    if (localObject2 == null) {
      p.btv("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).dRq());
    localObject1 = this.wmY;
    if (localObject1 == null) {
      p.btv("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.wnd);
    localObject1 = this.wmX;
    if (localObject1 == null) {
      p.btv("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.wmV;
    if (localObject2 == null) {
      p.btv("mediaTypeTv");
    }
    this.wna = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.wna;
    if (localObject1 == null) {
      p.btv("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.wna;
    if (localObject1 == null) {
      p.btv("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((o.g)new e(this));
    localObject1 = this.wmV;
    if (localObject1 == null) {
      p.btv("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.wmW;
    if (localObject1 == null) {
      p.btv("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ah(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    Log.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.wnb != null)
    {
      Bundle localBundle = new Bundle();
      String str = wnf;
      com.tencent.mm.plugin.gallery.ui.a locala = this.wmY;
      if (locala == null) {
        p.btv("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.dRM());
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
      if ((this.qVk == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.wnc = paramInt;
    GridView localGridView = this.wmW;
    if (localGridView == null) {
      p.btv("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.wne = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    p.h(paramb, "onItemSelectedListener");
    this.wnb = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.wnh;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.wnh);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.wnh).dRO() > FinderGridGalleryView.a(this.wnh))
        {
          FinderGridGalleryView.c(this.wnh).dRM().clear();
          FinderGridGalleryView.c(this.wnh).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.wnh).setSelectLimitCount(FinderGridGalleryView.a(this.wnh));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.wnh);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements o.g
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.wnh).setText(FinderGridGalleryView.d(this.wnh)[paramInt]);
      FinderGridGalleryView.f(this.wnh).setQueryType(FinderGridGalleryView.g(this.wnh)[paramInt]);
      FinderGridGalleryView.c(this.wnh).clear();
      FinderGridGalleryView.c(this.wnh).setQueryType(FinderGridGalleryView.f(this.wnh).dRq());
      FinderGridGalleryView.a(this.wnh, System.currentTimeMillis());
      FinderGridGalleryView.f(this.wnh).ax("", FinderGridGalleryView.h(this.wnh));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderGridGalleryView.i(this.wnh).gTx();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168354);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements AdapterView.OnItemClickListener
  {
    g(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168355);
      b localb = new b();
      localb.bm(paramAdapterView);
      localb.bm(paramView);
      localb.pH(paramInt);
      localb.zo(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
      if (FinderGridGalleryView.j(this.wnh) != null) {
        p.g(FinderGridGalleryView.c(this.wnh).dRN().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(168355);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.wnh).clear();
      FinderGridGalleryView.c(this.wnh).aM(paramLinkedList);
      FinderGridGalleryView.c(this.wnh).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */