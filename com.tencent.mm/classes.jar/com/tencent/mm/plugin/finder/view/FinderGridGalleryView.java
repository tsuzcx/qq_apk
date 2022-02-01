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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String qXo = "selected_media_items";
  public static final FinderGridGalleryView.a qXp;
  private final String TAG;
  private long osg;
  private final int[] qXc;
  private final int[] qXd;
  private TextView qXe;
  private GridView qXf;
  private MMSwitchBtn qXg;
  private com.tencent.mm.plugin.gallery.ui.a qXh;
  private o qXi;
  private com.tencent.mm.ui.widget.b.a qXj;
  private FinderGridGalleryView.b qXk;
  private int qXl;
  private int qXm;
  private int qXn;
  
  static
  {
    AppMethodBeat.i(168364);
    qXp = new FinderGridGalleryView.a((byte)0);
    qXo = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.qXc = new int[] { 2131759231, 2131759233, 2131759232 };
    this.qXd = new int[] { 1, 2, 3 };
    this.qXl = 4;
    this.qXm = 1;
    this.qXn = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.qXc = new int[] { 2131759231, 2131759233, 2131759232 };
    this.qXd = new int[] { 1, 2, 3 };
    this.qXl = 4;
    this.qXm = 1;
    this.qXn = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), 2131494056, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131302223);
    k.g(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.qXe = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302565);
    k.g(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.qXg = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131302208);
    k.g(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.qXf = ((GridView)localObject1);
    localObject1 = this.qXf;
    if (localObject1 == null) {
      k.aPZ("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.qXl);
    localObject1 = this.qXe;
    if (localObject1 == null) {
      k.aPZ("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.qXc[0]);
    this.qXi = new o();
    localObject1 = this.qXi;
    if (localObject1 == null) {
      k.aPZ("queryService");
    }
    ((o)localObject1).setQueryType(this.qXd[0]);
    localObject1 = this.qXi;
    if (localObject1 == null) {
      k.aPZ("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.osg = System.currentTimeMillis();
    localObject1 = this.qXi;
    if (localObject1 == null) {
      k.aPZ("queryService");
    }
    ((o)localObject1).as("", this.osg);
    this.qXh = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.qXh;
    if (localObject1 == null) {
      k.aPZ("albumAdapter");
    }
    localObject2 = this.qXi;
    if (localObject2 == null) {
      k.aPZ("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).czO());
    localObject1 = this.qXh;
    if (localObject1 == null) {
      k.aPZ("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.qXm);
    localObject1 = this.qXg;
    if (localObject1 == null) {
      k.aPZ("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.qXe;
    if (localObject2 == null) {
      k.aPZ("mediaTypeTv");
    }
    this.qXj = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.qXj;
    if (localObject1 == null) {
      k.aPZ("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.qXj;
    if (localObject1 == null) {
      k.aPZ("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((n.d)new e(this));
    localObject1 = this.qXe;
    if (localObject1 == null) {
      k.aPZ("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.qXf;
    if (localObject1 == null) {
      k.aPZ("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    ad.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.qXk != null)
    {
      Bundle localBundle = new Bundle();
      String str = qXo;
      com.tencent.mm.plugin.gallery.ui.a locala = this.qXh;
      if (locala == null) {
        k.aPZ("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.cAn());
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
      if ((this.osg == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.qXl = paramInt;
    GridView localGridView = this.qXf;
    if (localGridView == null) {
      k.aPZ("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.qXn = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    k.h(paramb, "onItemSelectedListener");
    this.qXk = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.qXq;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.qXq);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.qXq).cAp() > FinderGridGalleryView.a(this.qXq))
        {
          FinderGridGalleryView.c(this.qXq).cAn().clear();
          FinderGridGalleryView.c(this.qXq).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.qXq).setSelectLimitCount(FinderGridGalleryView.a(this.qXq));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.qXq);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.d
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.qXq).setText(FinderGridGalleryView.d(this.qXq)[paramInt]);
      FinderGridGalleryView.f(this.qXq).setQueryType(FinderGridGalleryView.g(this.qXq)[paramInt]);
      FinderGridGalleryView.c(this.qXq).clear();
      FinderGridGalleryView.c(this.qXq).setQueryType(FinderGridGalleryView.f(this.qXq).czO());
      FinderGridGalleryView.a(this.qXq, System.currentTimeMillis());
      FinderGridGalleryView.f(this.qXq).as("", FinderGridGalleryView.h(this.qXq));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      FinderGridGalleryView.i(this.qXq).ffU();
      AppMethodBeat.o(168354);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements AdapterView.OnItemClickListener
  {
    g(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168355);
      if (FinderGridGalleryView.j(this.qXq) != null) {
        k.g(FinderGridGalleryView.c(this.qXq).cAo().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      AppMethodBeat.o(168355);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.qXq).clear();
      FinderGridGalleryView.c(this.qXq).ai(paramLinkedList);
      FinderGridGalleryView.c(this.qXq).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */