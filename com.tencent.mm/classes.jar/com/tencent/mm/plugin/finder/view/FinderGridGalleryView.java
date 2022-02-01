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
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String rXQ = "selected_media_items";
  public static final FinderGridGalleryView.a rXR;
  private final String TAG;
  private long oVG;
  private final int[] rXE;
  private final int[] rXF;
  private TextView rXG;
  private GridView rXH;
  private MMSwitchBtn rXI;
  private com.tencent.mm.plugin.gallery.ui.a rXJ;
  private o rXK;
  private com.tencent.mm.ui.widget.b.a rXL;
  private FinderGridGalleryView.b rXM;
  private int rXN;
  private int rXO;
  private int rXP;
  
  static
  {
    AppMethodBeat.i(168364);
    rXR = new FinderGridGalleryView.a((byte)0);
    rXQ = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.rXE = new int[] { 2131759231, 2131759233, 2131759232 };
    this.rXF = new int[] { 1, 2, 3 };
    this.rXN = 4;
    this.rXO = 1;
    this.rXP = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.rXE = new int[] { 2131759231, 2131759233, 2131759232 };
    this.rXF = new int[] { 1, 2, 3 };
    this.rXN = 4;
    this.rXO = 1;
    this.rXP = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), 2131494056, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131302223);
    k.g(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.rXG = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302565);
    k.g(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.rXI = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131302208);
    k.g(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.rXH = ((GridView)localObject1);
    localObject1 = this.rXH;
    if (localObject1 == null) {
      k.aVY("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.rXN);
    localObject1 = this.rXG;
    if (localObject1 == null) {
      k.aVY("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.rXE[0]);
    this.rXK = new o();
    localObject1 = this.rXK;
    if (localObject1 == null) {
      k.aVY("queryService");
    }
    ((o)localObject1).setQueryType(this.rXF[0]);
    localObject1 = this.rXK;
    if (localObject1 == null) {
      k.aVY("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.oVG = System.currentTimeMillis();
    localObject1 = this.rXK;
    if (localObject1 == null) {
      k.aVY("queryService");
    }
    ((o)localObject1).au("", this.oVG);
    this.rXJ = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.rXJ;
    if (localObject1 == null) {
      k.aVY("albumAdapter");
    }
    localObject2 = this.rXK;
    if (localObject2 == null) {
      k.aVY("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).cNa());
    localObject1 = this.rXJ;
    if (localObject1 == null) {
      k.aVY("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.rXO);
    localObject1 = this.rXI;
    if (localObject1 == null) {
      k.aVY("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.rXG;
    if (localObject2 == null) {
      k.aVY("mediaTypeTv");
    }
    this.rXL = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.rXL;
    if (localObject1 == null) {
      k.aVY("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.rXL;
    if (localObject1 == null) {
      k.aVY("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((n.d)new e(this));
    localObject1 = this.rXG;
    if (localObject1 == null) {
      k.aVY("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.rXH;
    if (localObject1 == null) {
      k.aVY("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    ac.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.rXM != null)
    {
      Bundle localBundle = new Bundle();
      String str = rXQ;
      com.tencent.mm.plugin.gallery.ui.a locala = this.rXJ;
      if (locala == null) {
        k.aVY("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.cNw());
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
      ac.i(str, localInteger + " medias");
      if ((this.oVG == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.rXN = paramInt;
    GridView localGridView = this.rXH;
    if (localGridView == null) {
      k.aVY("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.rXP = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    k.h(paramb, "onItemSelectedListener");
    this.rXM = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.rXS;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.rXS);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.rXS).cNy() > FinderGridGalleryView.a(this.rXS))
        {
          FinderGridGalleryView.c(this.rXS).cNw().clear();
          FinderGridGalleryView.c(this.rXS).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.rXS).setSelectLimitCount(FinderGridGalleryView.a(this.rXS));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.rXS);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.d
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.rXS).setText(FinderGridGalleryView.d(this.rXS)[paramInt]);
      FinderGridGalleryView.f(this.rXS).setQueryType(FinderGridGalleryView.g(this.rXS)[paramInt]);
      FinderGridGalleryView.c(this.rXS).clear();
      FinderGridGalleryView.c(this.rXS).setQueryType(FinderGridGalleryView.f(this.rXS).cNa());
      FinderGridGalleryView.a(this.rXS, System.currentTimeMillis());
      FinderGridGalleryView.f(this.rXS).au("", FinderGridGalleryView.h(this.rXS));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      FinderGridGalleryView.i(this.rXS).fvT();
      AppMethodBeat.o(168354);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements AdapterView.OnItemClickListener
  {
    g(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168355);
      if (FinderGridGalleryView.j(this.rXS) != null) {
        k.g(FinderGridGalleryView.c(this.rXS).cNx().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      AppMethodBeat.o(168355);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.rXS).clear();
      FinderGridGalleryView.c(this.rXS).ap(paramLinkedList);
      FinderGridGalleryView.c(this.rXS).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */