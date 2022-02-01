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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView
  extends LinearLayout
  implements i.c, a.e
{
  private static final String tfY = "selected_media_items";
  public static final FinderGridGalleryView.a tfZ;
  private final String TAG;
  private long pFU;
  private final int[] tfM;
  private final int[] tfN;
  private TextView tfO;
  private GridView tfP;
  private MMSwitchBtn tfQ;
  private com.tencent.mm.plugin.gallery.ui.a tfR;
  private o tfS;
  private com.tencent.mm.ui.widget.b.a tfT;
  private FinderGridGalleryView.b tfU;
  private int tfV;
  private int tfW;
  private int tfX;
  
  static
  {
    AppMethodBeat.i(168364);
    tfZ = new FinderGridGalleryView.a((byte)0);
    tfY = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.tfM = new int[] { 2131759231, 2131759233, 2131759232 };
    this.tfN = new int[] { 1, 2, 3 };
    this.tfV = 4;
    this.tfW = 1;
    this.tfX = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.tfM = new int[] { 2131759231, 2131759233, 2131759232 };
    this.tfN = new int[] { 1, 2, 3 };
    this.tfV = 4;
    this.tfW = 1;
    this.tfX = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), 2131494056, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131302223);
    p.g(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.tfO = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131302565);
    p.g(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.tfQ = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(2131302208);
    p.g(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.tfP = ((GridView)localObject1);
    localObject1 = this.tfP;
    if (localObject1 == null) {
      p.bdF("gridView");
    }
    ((GridView)localObject1).setNumColumns(this.tfV);
    localObject1 = this.tfO;
    if (localObject1 == null) {
      p.bdF("mediaTypeTv");
    }
    ((TextView)localObject1).setText(this.tfM[0]);
    this.tfS = new o();
    localObject1 = this.tfS;
    if (localObject1 == null) {
      p.bdF("queryService");
    }
    ((o)localObject1).setQueryType(this.tfN[0]);
    localObject1 = this.tfS;
    if (localObject1 == null) {
      p.bdF("queryService");
    }
    ((o)localObject1).a((i.c)this);
    this.pFU = System.currentTimeMillis();
    localObject1 = this.tfS;
    if (localObject1 == null) {
      p.bdF("queryService");
    }
    ((o)localObject1).ax("", this.pFU);
    this.tfR = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
    localObject1 = this.tfR;
    if (localObject1 == null) {
      p.bdF("albumAdapter");
    }
    localObject2 = this.tfS;
    if (localObject2 == null) {
      p.bdF("queryService");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setQueryType(((o)localObject2).cXX());
    localObject1 = this.tfR;
    if (localObject1 == null) {
      p.bdF("albumAdapter");
    }
    ((com.tencent.mm.plugin.gallery.ui.a)localObject1).setSelectLimitCount(this.tfW);
    localObject1 = this.tfQ;
    if (localObject1 == null) {
      p.bdF("multiSelect");
    }
    ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new c(this));
    localObject1 = getContext();
    localObject2 = this.tfO;
    if (localObject2 == null) {
      p.bdF("mediaTypeTv");
    }
    this.tfT = new com.tencent.mm.ui.widget.b.a((Context)localObject1, (View)localObject2);
    localObject1 = this.tfT;
    if (localObject1 == null) {
      p.bdF("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((View.OnCreateContextMenuListener)new d(this));
    localObject1 = this.tfT;
    if (localObject1 == null) {
      p.bdF("mediaTypePopupMenu");
    }
    ((com.tencent.mm.ui.widget.b.a)localObject1).a((n.e)new e(this));
    localObject1 = this.tfO;
    if (localObject1 == null) {
      p.bdF("mediaTypeTv");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
    localObject1 = this.tfP;
    if (localObject1 == null) {
      p.bdF("gridView");
    }
    ((GridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)new g(this));
    AppMethodBeat.o(168357);
  }
  
  public final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    ae.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.tfU != null)
    {
      Bundle localBundle = new Bundle();
      String str = tfY;
      com.tencent.mm.plugin.gallery.ui.a locala = this.tfR;
      if (locala == null) {
        p.bdF("albumAdapter");
      }
      localBundle.putParcelableArrayList(str, locala.cYt());
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
      ae.i(str, localInteger + " medias");
      if ((this.pFU == paramLong) && (paramLinkedList != null)) {
        post((Runnable)new h(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.tfV = paramInt;
    GridView localGridView = this.tfP;
    if (localGridView == null) {
      p.bdF("gridView");
    }
    localGridView.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.tfX = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    p.h(paramb, "onItemSelectedListener");
    this.tfU = paramb;
    AppMethodBeat.o(168359);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "checked", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(168351);
      FinderGridGalleryView localFinderGridGalleryView = this.tga;
      if (paramBoolean) {}
      for (int i = FinderGridGalleryView.b(this.tga);; i = 1)
      {
        FinderGridGalleryView.a(localFinderGridGalleryView, i);
        if (FinderGridGalleryView.c(this.tga).cYv() > FinderGridGalleryView.a(this.tga))
        {
          FinderGridGalleryView.c(this.tga).cYt().clear();
          FinderGridGalleryView.c(this.tga).notifyDataSetChanged();
        }
        FinderGridGalleryView.c(this.tga).setSelectLimitCount(FinderGridGalleryView.a(this.tga));
        AppMethodBeat.o(168351);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class d
    implements View.OnCreateContextMenuListener
  {
    d(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(168352);
      paramContextMenu.clear();
      paramView = FinderGridGalleryView.d(this.tga);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.e
  {
    e(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168353);
      FinderGridGalleryView.e(this.tga).setText(FinderGridGalleryView.d(this.tga)[paramInt]);
      FinderGridGalleryView.f(this.tga).setQueryType(FinderGridGalleryView.g(this.tga)[paramInt]);
      FinderGridGalleryView.c(this.tga).clear();
      FinderGridGalleryView.c(this.tga).setQueryType(FinderGridGalleryView.f(this.tga).cXX());
      FinderGridGalleryView.a(this.tga, System.currentTimeMillis());
      FinderGridGalleryView.f(this.tga).ax("", FinderGridGalleryView.h(this.tga));
      AppMethodBeat.o(168353);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGridGalleryView paramFinderGridGalleryView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168354);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderGridGalleryView.i(this.tga).fLf();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168354);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
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
      localb.mu(paramInt);
      localb.rl(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
      if (FinderGridGalleryView.j(this.tga) != null) {
        p.g(FinderGridGalleryView.c(this.tga).cYu().get(paramInt), "albumAdapter.allMediaItems[position]");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(168355);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
  static final class h
    implements Runnable
  {
    h(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168356);
      FinderGridGalleryView.c(this.tga).clear();
      FinderGridGalleryView.c(this.tga).ar(paramLinkedList);
      FinderGridGalleryView.c(this.tga).notifyDataSetChanged();
      AppMethodBeat.o(168356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */