package com.tencent.mm.plugin.gallery.picker.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/loader/Loader;Ljava/util/HashSet;Ljava/util/ArrayList;)V", "isMultiSelectedMode", "", "()Z", "setMultiSelectedMode", "(Z)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class a
  extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, MediaItemView<GalleryItem.MediaItem>>
{
  public static final a xkF;
  private d<GalleryItem.MediaItem> gVG;
  public ArrayList<GalleryItem.MediaItem> hXI;
  public c xkB;
  public d xkC;
  public MediaItemView.b<GalleryItem.MediaItem> xkD;
  public HashSet<GalleryItem.MediaItem> xkE;
  public boolean xkm;
  
  static
  {
    AppMethodBeat.i(164861);
    xkF = new a((byte)0);
    AppMethodBeat.o(164861);
  }
  
  private a(d<GalleryItem.MediaItem> paramd, HashSet<GalleryItem.MediaItem> paramHashSet, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(164859);
    this.gVG = paramd;
    this.xkE = paramHashSet;
    this.hXI = paramArrayList;
    this.xkm = true;
    au(true);
    AppMethodBeat.o(164859);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(257768);
    p.h(paramb, "holder");
    p.h(paramList, "payloads");
    MediaItemView localMediaItemView = (MediaItemView)paramb.getView();
    if (paramList.size() > 0)
    {
      Object localObject = this.cvc.get(paramInt);
      p.g(localObject, "mItems[position]");
      localObject = (GalleryItem.MediaItem)localObject;
      d locald = this.gVG;
      paramList = j.ks(paramList);
      if (paramList == null)
      {
        paramb = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(257768);
        throw paramb;
      }
      localMediaItemView.a(paramb, (GalleryItem.MediaItem)localObject, locald, ((Integer)paramList).intValue());
      AppMethodBeat.o(257768);
      return;
    }
    paramList = this.cvc.get(paramInt);
    p.g(paramList, "mItems[position]");
    localMediaItemView.a(paramb, (GalleryItem.MediaItem)paramList, this.gVG, 0);
    AppMethodBeat.o(257768);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(164856);
    long l = ((GalleryItem.MediaItem)this.cvc.get(paramInt)).xiZ;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$Companion;", "", "()V", "NOTIFY_CHANGE_MASK", "", "NOTIFY_CHANGE_NORMAL", "NOTIFY_CHANGE_NUM", "plugin-gallery_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "onMediaUnSelected", "plugin-gallery_release"})
  public final class b
    implements View.OnClickListener, View.OnLongClickListener, MediaItemView.b<GalleryItem.MediaItem>
  {
    private final RecyclerView hak;
    
    public b()
    {
      AppMethodBeat.i(164854);
      this.hak = localObject;
      AppMethodBeat.o(164854);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164853);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramView, "v");
      localObject = this.hak.bu(paramView);
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.xkB;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.v)localObject).lR());
        p.g(localObject, "mItems[holder.adapterPosition]");
        paramView.e((GalleryItem.MediaItem)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164853);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164852);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramView, "v");
      localObject = this.hak.bu(paramView);
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.xkC;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.v)localObject).lR());
        p.g(localObject, "mItems[holder.adapterPosition]");
      }
      for (boolean bool = paramView.d((GalleryItem.MediaItem)localObject);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164852);
        return bool;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void e(GalleryItem.MediaItem paramMediaItem);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface d
  {
    public abstract boolean d(GalleryItem.MediaItem paramMediaItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.a
 * JD-Core Version:    0.7.0.1
 */