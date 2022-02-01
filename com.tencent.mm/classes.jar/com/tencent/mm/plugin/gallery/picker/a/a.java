package com.tencent.mm.plugin.gallery.picker.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b;
import com.tencent.mm.ui.base.a.b;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/loader/Loader;Ljava/util/HashSet;Ljava/util/ArrayList;)V", "isMultiSelectedMode", "", "()Z", "setMultiSelectedMode", "(Z)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class a
  extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, MediaItemView<GalleryItem.MediaItem>>
{
  public static final a.a sLU;
  private d<GalleryItem.MediaItem> fOT;
  public ArrayList<GalleryItem.MediaItem> gIv;
  public boolean sLB;
  public c sLQ;
  public d sLR;
  public MediaItemView.b<GalleryItem.MediaItem> sLS;
  public HashSet<GalleryItem.MediaItem> sLT;
  
  static
  {
    AppMethodBeat.i(164861);
    sLU = new a.a((byte)0);
    AppMethodBeat.o(164861);
  }
  
  private a(d<GalleryItem.MediaItem> paramd, HashSet<GalleryItem.MediaItem> paramHashSet, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(164859);
    this.fOT = paramd;
    this.sLT = paramHashSet;
    this.gIv = paramArrayList;
    this.sLB = true;
    av(true);
    AppMethodBeat.o(164859);
  }
  
  public final void a(b paramb, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(198432);
    k.h(paramb, "holder");
    k.h(paramList, "payloads");
    MediaItemView localMediaItemView = (MediaItemView)paramb.getView();
    if (paramList.size() > 0)
    {
      Object localObject = this.bYM.get(paramInt);
      k.g(localObject, "mItems[position]");
      localObject = (GalleryItem.MediaItem)localObject;
      d locald = this.fOT;
      paramList = j.iO(paramList);
      if (paramList == null)
      {
        paramb = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(198432);
        throw paramb;
      }
      localMediaItemView.a(paramb, (GalleryItem.MediaItem)localObject, locald, ((Integer)paramList).intValue());
      AppMethodBeat.o(198432);
      return;
    }
    paramList = this.bYM.get(paramInt);
    k.g(paramList, "mItems[position]");
    localMediaItemView.a(paramb, (GalleryItem.MediaItem)paramList, this.fOT, 0);
    AppMethodBeat.o(198432);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(164856);
    long l = ((GalleryItem.MediaItem)this.bYM.get(paramInt)).sKk;
    AppMethodBeat.o(164856);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(164857);
    Object localObject = getItemAtPosition(paramInt);
    k.g(localObject, "getItemAtPosition(position)");
    paramInt = ((GalleryItem.MediaItem)localObject).getType();
    AppMethodBeat.o(164857);
    return paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "onMediaUnSelected", "plugin-gallery_release"})
  public final class b
    implements View.OnClickListener, View.OnLongClickListener, MediaItemView.b<GalleryItem.MediaItem>
  {
    private final RecyclerView fTr;
    
    public b()
    {
      AppMethodBeat.i(164854);
      this.fTr = localObject;
      AppMethodBeat.o(164854);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164853);
      k.h(paramView, "v");
      Object localObject = this.fTr.bu(paramView);
      if (localObject == null) {
        k.fOy();
      }
      k.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.sLQ;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.w)localObject).lv());
        k.g(localObject, "mItems[holder.adapterPosition]");
        paramView.d((GalleryItem.MediaItem)localObject);
        AppMethodBeat.o(164853);
        return;
      }
      AppMethodBeat.o(164853);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164852);
      k.h(paramView, "v");
      Object localObject = this.fTr.bu(paramView);
      if (localObject == null) {
        k.fOy();
      }
      k.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.sLR;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.w)localObject).lv());
        k.g(localObject, "mItems[holder.adapterPosition]");
        boolean bool = paramView.c((GalleryItem.MediaItem)localObject);
        AppMethodBeat.o(164852);
        return bool;
      }
      AppMethodBeat.o(164852);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void d(GalleryItem.MediaItem paramMediaItem);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface d
  {
    public abstract boolean c(GalleryItem.MediaItem paramMediaItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.a
 * JD-Core Version:    0.7.0.1
 */