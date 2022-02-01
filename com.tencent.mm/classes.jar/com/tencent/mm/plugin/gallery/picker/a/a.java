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
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/loader/Loader;Ljava/util/HashSet;Ljava/util/ArrayList;)V", "isMultiSelectedMode", "", "()Z", "setMultiSelectedMode", "(Z)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class a
  extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, MediaItemView<GalleryItem.MediaItem>>
{
  public static final a.a tTs;
  private d<GalleryItem.MediaItem> gkL;
  public ArrayList<GalleryItem.MediaItem> heT;
  public boolean tSZ;
  public c tTo;
  public d tTp;
  public MediaItemView.b<GalleryItem.MediaItem> tTq;
  public HashSet<GalleryItem.MediaItem> tTr;
  
  static
  {
    AppMethodBeat.i(164861);
    tTs = new a.a((byte)0);
    AppMethodBeat.o(164861);
  }
  
  private a(d<GalleryItem.MediaItem> paramd, HashSet<GalleryItem.MediaItem> paramHashSet, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(164859);
    this.gkL = paramd;
    this.tTr = paramHashSet;
    this.heT = paramArrayList;
    this.tSZ = true;
    av(true);
    AppMethodBeat.o(164859);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(186204);
    p.h(paramb, "holder");
    p.h(paramList, "payloads");
    MediaItemView localMediaItemView = (MediaItemView)paramb.getView();
    if (paramList.size() > 0)
    {
      Object localObject = this.cjg.get(paramInt);
      p.g(localObject, "mItems[position]");
      localObject = (GalleryItem.MediaItem)localObject;
      d locald = this.gkL;
      paramList = j.jl(paramList);
      if (paramList == null)
      {
        paramb = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(186204);
        throw paramb;
      }
      localMediaItemView.a(paramb, (GalleryItem.MediaItem)localObject, locald, ((Integer)paramList).intValue());
      AppMethodBeat.o(186204);
      return;
    }
    paramList = this.cjg.get(paramInt);
    p.g(paramList, "mItems[position]");
    localMediaItemView.a(paramb, (GalleryItem.MediaItem)paramList, this.gkL, 0);
    AppMethodBeat.o(186204);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(164856);
    long l = ((GalleryItem.MediaItem)this.cjg.get(paramInt)).tRM;
    AppMethodBeat.o(164856);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(164857);
    Object localObject = getItemAtPosition(paramInt);
    p.g(localObject, "getItemAtPosition(position)");
    paramInt = ((GalleryItem.MediaItem)localObject).getType();
    AppMethodBeat.o(164857);
    return paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "onMediaUnSelected", "plugin-gallery_release"})
  public final class b
    implements View.OnClickListener, View.OnLongClickListener, MediaItemView.b<GalleryItem.MediaItem>
  {
    private final RecyclerView gpr;
    
    public b()
    {
      AppMethodBeat.i(164854);
      this.gpr = localObject;
      AppMethodBeat.o(164854);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164853);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramView, "v");
      localObject = this.gpr.bu(paramView);
      if (localObject == null) {
        p.gkB();
      }
      p.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.tTo;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.w)localObject).lN());
        p.g(localObject, "mItems[holder.adapterPosition]");
        paramView.d((GalleryItem.MediaItem)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164853);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164852);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramView, "v");
      localObject = this.gpr.bu(paramView);
      if (localObject == null) {
        p.gkB();
      }
      p.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.tTp;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.w)localObject).lN());
        p.g(localObject, "mItems[holder.adapterPosition]");
      }
      for (boolean bool = paramView.c((GalleryItem.MediaItem)localObject);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164852);
        return bool;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void d(GalleryItem.MediaItem paramMediaItem);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface d
  {
    public abstract boolean c(GalleryItem.MediaItem paramMediaItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.a
 * JD-Core Version:    0.7.0.1
 */