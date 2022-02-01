package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.ui.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", "init", "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGridGalleryView
  extends LinearLayout
  implements l.c, a.e
{
  private static final String GzK;
  public static final FinderGridGalleryView.a Gzw;
  private GridView GzA;
  private MMSwitchBtn GzB;
  private com.tencent.mm.plugin.gallery.ui.a GzC;
  private q GzD;
  private com.tencent.mm.ui.widget.b.a GzE;
  private FinderGridGalleryView.b GzF;
  private int GzG;
  private int GzH;
  private long GzI;
  private int GzJ;
  private final int[] Gzx;
  private final int[] Gzy;
  private TextView Gzz;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(168364);
    Gzw = new FinderGridGalleryView.a((byte)0);
    GzK = "selected_media_items";
    AppMethodBeat.o(168364);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168362);
    this.TAG = "Finder.FinderGridGalleryView";
    this.Gzx = new int[] { e.h.finder_gallery_mediaType_image, e.h.finder_gallery_mediaType_video, e.h.finder_gallery_mediaType_image_and_video };
    this.Gzy = new int[] { 1, 2, 3 };
    this.GzG = 4;
    this.GzH = 1;
    this.GzJ = 9;
    init();
    AppMethodBeat.o(168362);
  }
  
  public FinderGridGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168363);
    this.TAG = "Finder.FinderGridGalleryView";
    this.Gzx = new int[] { e.h.finder_gallery_mediaType_image, e.h.finder_gallery_mediaType_video, e.h.finder_gallery_mediaType_image_and_video };
    this.Gzy = new int[] { 1, 2, 3 };
    this.GzG = 4;
    this.GzH = 1;
    this.GzJ = 9;
    init();
    AppMethodBeat.o(168363);
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(344209);
    s.u(paramFinderGridGalleryView, "this$0");
    paramContextMenu.clear();
    paramFinderGridGalleryView = paramFinderGridGalleryView.Gzx;
    int j = paramFinderGridGalleryView.length;
    int i = 0;
    while (i < j)
    {
      paramContextMenu.add(paramFinderGridGalleryView[i]);
      i += 1;
    }
    AppMethodBeat.o(344209);
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(344220);
    s.u(paramFinderGridGalleryView, "this$0");
    Object localObject1 = paramFinderGridGalleryView.Gzz;
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mediaTypeTv");
      paramMenuItem = null;
    }
    paramMenuItem.setText(paramFinderGridGalleryView.Gzx[paramInt]);
    localObject1 = paramFinderGridGalleryView.GzD;
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null)
    {
      s.bIx("queryService");
      paramMenuItem = null;
    }
    paramMenuItem.setQueryType(paramFinderGridGalleryView.Gzy[paramInt]);
    localObject1 = paramFinderGridGalleryView.GzC;
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null)
    {
      s.bIx("albumAdapter");
      paramMenuItem = null;
    }
    paramMenuItem.HLA.clear();
    localObject1 = paramFinderGridGalleryView.GzC;
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null)
    {
      s.bIx("albumAdapter");
      paramMenuItem = null;
    }
    q localq = paramFinderGridGalleryView.GzD;
    localObject1 = localq;
    if (localq == null)
    {
      s.bIx("queryService");
      localObject1 = null;
    }
    paramMenuItem.HIa = ((q)localObject1).HIa;
    paramFinderGridGalleryView.GzI = System.currentTimeMillis();
    paramMenuItem = paramFinderGridGalleryView.GzD;
    if (paramMenuItem == null)
    {
      s.bIx("queryService");
      paramMenuItem = localObject2;
    }
    for (;;)
    {
      paramMenuItem.aI("", paramFinderGridGalleryView.GzI);
      AppMethodBeat.o(344220);
      return;
    }
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, View paramView)
  {
    AppMethodBeat.i(344238);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderGridGalleryView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderGridGalleryView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderGridGalleryView, "this$0");
    paramView = paramFinderGridGalleryView.GzE;
    paramFinderGridGalleryView = paramView;
    if (paramView == null)
    {
      s.bIx("mediaTypePopupMenu");
      paramFinderGridGalleryView = null;
    }
    paramFinderGridGalleryView.cMz();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderGridGalleryView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344238);
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(344250);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderGridGalleryView);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderGridGalleryView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramFinderGridGalleryView, "this$0");
    if (paramFinderGridGalleryView.GzF != null)
    {
      paramAdapterView = paramFinderGridGalleryView.GzC;
      paramFinderGridGalleryView = paramAdapterView;
      if (paramAdapterView == null)
      {
        s.bIx("albumAdapter");
        paramFinderGridGalleryView = null;
      }
      s.s(paramFinderGridGalleryView.HLA.get(paramInt), "albumAdapter.allMediaItems[position]");
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderGridGalleryView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(344250);
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, LinkedList paramLinkedList)
  {
    Object localObject = null;
    AppMethodBeat.i(344261);
    s.u(paramFinderGridGalleryView, "this$0");
    com.tencent.mm.plugin.gallery.ui.a locala2 = paramFinderGridGalleryView.GzC;
    com.tencent.mm.plugin.gallery.ui.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("albumAdapter");
      locala1 = null;
    }
    locala1.HLA.clear();
    locala2 = paramFinderGridGalleryView.GzC;
    locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("albumAdapter");
      locala1 = null;
    }
    locala1.bn(paramLinkedList);
    paramFinderGridGalleryView = paramFinderGridGalleryView.GzC;
    if (paramFinderGridGalleryView == null)
    {
      s.bIx("albumAdapter");
      paramFinderGridGalleryView = localObject;
    }
    for (;;)
    {
      paramFinderGridGalleryView.bZE.notifyChanged();
      AppMethodBeat.o(344261);
      return;
    }
  }
  
  private static final void a(FinderGridGalleryView paramFinderGridGalleryView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(344198);
    s.u(paramFinderGridGalleryView, "this$0");
    int i;
    Object localObject1;
    if (paramBoolean)
    {
      i = paramFinderGridGalleryView.GzJ;
      paramFinderGridGalleryView.GzH = i;
      com.tencent.mm.plugin.gallery.ui.a locala = paramFinderGridGalleryView.GzC;
      localObject1 = locala;
      if (locala == null)
      {
        s.bIx("albumAdapter");
        localObject1 = null;
      }
      if (((com.tencent.mm.plugin.gallery.ui.a)localObject1).HLB.size() > paramFinderGridGalleryView.GzH)
      {
        locala = paramFinderGridGalleryView.GzC;
        localObject1 = locala;
        if (locala == null)
        {
          s.bIx("albumAdapter");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.gallery.ui.a)localObject1).HLB.clear();
        locala = paramFinderGridGalleryView.GzC;
        localObject1 = locala;
        if (locala == null)
        {
          s.bIx("albumAdapter");
          localObject1 = null;
        }
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
      }
      localObject1 = paramFinderGridGalleryView.GzC;
      if (localObject1 != null) {
        break label157;
      }
      s.bIx("albumAdapter");
      localObject1 = localObject2;
    }
    label157:
    for (;;)
    {
      ((com.tencent.mm.plugin.gallery.ui.a)localObject1).HLz = paramFinderGridGalleryView.GzH;
      AppMethodBeat.o(344198);
      return;
      i = 1;
      break;
    }
  }
  
  private final void init()
  {
    Object localObject3 = null;
    AppMethodBeat.i(168357);
    Object localObject1 = View.inflate(getContext(), e.f.finder_grid_gallery_view, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(e.e.media_type_tv);
    s.s(localObject2, "contentView.findViewById(R.id.media_type_tv)");
    this.Gzz = ((TextView)localObject2);
    localObject2 = ((View)localObject1).findViewById(e.e.multi_select_switch);
    s.s(localObject2, "contentView.findViewById(R.id.multi_select_switch)");
    this.GzB = ((MMSwitchBtn)localObject2);
    localObject1 = ((View)localObject1).findViewById(e.e.media_grid_view);
    s.s(localObject1, "contentView.findViewById(R.id.media_grid_view)");
    this.GzA = ((GridView)localObject1);
    localObject2 = this.GzA;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("gridView");
      localObject1 = null;
    }
    ((GridView)localObject1).setNumColumns(this.GzG);
    localObject2 = this.Gzz;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mediaTypeTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setText(this.Gzx[0]);
    this.GzD = new q();
    localObject2 = this.GzD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("queryService");
      localObject1 = null;
    }
    ((q)localObject1).setQueryType(this.Gzy[0]);
    localObject1 = this.GzD;
    if (localObject1 == null)
    {
      s.bIx("queryService");
      localObject1 = null;
      ((q)localObject1).a((l.c)this);
      this.GzI = System.currentTimeMillis();
      localObject2 = this.GzD;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("queryService");
        localObject1 = null;
      }
      ((q)localObject1).aI("", this.GzI);
      this.GzC = new com.tencent.mm.plugin.gallery.ui.a(getContext(), (a.e)this);
      localObject2 = this.GzC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("albumAdapter");
        localObject1 = null;
      }
      Object localObject4 = this.GzD;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("queryService");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.gallery.ui.a)localObject1).HIa = ((q)localObject2).HIa;
      localObject2 = this.GzC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("albumAdapter");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.gallery.ui.a)localObject1).HLz = this.GzH;
      localObject2 = this.GzB;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("multiSelect");
        localObject1 = null;
      }
      ((MMSwitchBtn)localObject1).setSwitchListener(new FinderGridGalleryView..ExternalSyntheticLambda4(this));
      localObject4 = getContext();
      localObject2 = this.Gzz;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mediaTypeTv");
        localObject1 = null;
      }
      this.GzE = new com.tencent.mm.ui.widget.b.a((Context)localObject4, (View)localObject1);
      localObject2 = this.GzE;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mediaTypePopupMenu");
        localObject1 = null;
      }
      ((com.tencent.mm.ui.widget.b.a)localObject1).agjt = new FinderGridGalleryView..ExternalSyntheticLambda1(this);
      localObject2 = this.GzE;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mediaTypePopupMenu");
        localObject1 = null;
      }
      ((com.tencent.mm.ui.widget.b.a)localObject1).GAC = new FinderGridGalleryView..ExternalSyntheticLambda3(this);
      localObject2 = this.Gzz;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mediaTypeTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new FinderGridGalleryView..ExternalSyntheticLambda0(this));
      localObject1 = this.GzA;
      if (localObject1 != null) {
        break label540;
      }
      s.bIx("gridView");
      localObject1 = localObject3;
    }
    label540:
    for (;;)
    {
      ((GridView)localObject1).setOnItemClickListener(new FinderGridGalleryView..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(168357);
      return;
      break;
    }
  }
  
  public final void aG(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(168360);
    Log.i(this.TAG, "selected  " + paramInt1 + " items");
    if (this.GzF != null)
    {
      Bundle localBundle = new Bundle();
      String str = GzK;
      com.tencent.mm.plugin.gallery.ui.a locala2 = this.GzC;
      com.tencent.mm.plugin.gallery.ui.a locala1 = locala2;
      if (locala2 == null)
      {
        s.bIx("albumAdapter");
        locala1 = null;
      }
      localBundle.putParcelableArrayList(str, locala1.HLB);
    }
    AppMethodBeat.o(168360);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168361);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("ticket ").append(paramLong).append(" query finished  ");
    if (paramLinkedList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramLinkedList.size()))
    {
      Log.i(str, localObject + " medias");
      if ((this.GzI == paramLong) && (paramLinkedList != null)) {
        post(new FinderGridGalleryView..ExternalSyntheticLambda5(this, paramLinkedList));
      }
      AppMethodBeat.o(168361);
      return;
    }
  }
  
  public final void setColumnNum(int paramInt)
  {
    AppMethodBeat.i(168358);
    this.GzG = paramInt;
    GridView localGridView2 = this.GzA;
    GridView localGridView1 = localGridView2;
    if (localGridView2 == null)
    {
      s.bIx("gridView");
      localGridView1 = null;
    }
    localGridView1.setNumColumns(paramInt);
    AppMethodBeat.o(168358);
  }
  
  public final void setMaxSelectLimit(int paramInt)
  {
    this.GzJ = paramInt;
  }
  
  public final void setOnItemSelectListener(FinderGridGalleryView.b paramb)
  {
    AppMethodBeat.i(168359);
    s.u(paramb, "onItemSelectedListener");
    this.GzF = paramb;
    AppMethodBeat.o(168359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderGridGalleryView
 * JD-Core Version:    0.7.0.1
 */