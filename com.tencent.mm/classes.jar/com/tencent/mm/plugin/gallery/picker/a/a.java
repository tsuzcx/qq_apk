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
import com.tencent.mm.ui.base.a.b;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/loader/Loader;Ljava/util/HashSet;Ljava/util/ArrayList;)V", "isMultiSelectedMode", "", "()Z", "setMultiSelectedMode", "(Z)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class a
  extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, MediaItemView<GalleryItem.MediaItem>>
{
  public static final a rDb;
  private d<GalleryItem.MediaItem> fLh;
  public boolean rCH;
  public c rCW;
  public d rCX;
  public MediaItemView.b<GalleryItem.MediaItem> rCY;
  public HashSet<GalleryItem.MediaItem> rCZ;
  public ArrayList<GalleryItem.MediaItem> rDa;
  
  static
  {
    AppMethodBeat.i(164861);
    rDb = new a((byte)0);
    AppMethodBeat.o(164861);
  }
  
  private a(d<GalleryItem.MediaItem> paramd, HashSet<GalleryItem.MediaItem> paramHashSet, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(164859);
    this.fLh = paramd;
    this.rCZ = paramHashSet;
    this.rDa = paramArrayList;
    this.rCH = true;
    av(true);
    AppMethodBeat.o(164859);
  }
  
  public final void a(b paramb, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(200781);
    k.h(paramb, "holder");
    k.h(paramList, "payloads");
    MediaItemView localMediaItemView = (MediaItemView)paramb.getView();
    if (paramList.size() > 0)
    {
      Object localObject = this.cbP.get(paramInt);
      k.g(localObject, "mItems[position]");
      localObject = (GalleryItem.MediaItem)localObject;
      d locald = this.fLh;
      paramList = j.iy(paramList);
      if (paramList == null)
      {
        paramb = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200781);
        throw paramb;
      }
      localMediaItemView.a(paramb, (GalleryItem.MediaItem)localObject, locald, ((Integer)paramList).intValue());
      AppMethodBeat.o(200781);
      return;
    }
    paramList = this.cbP.get(paramInt);
    k.g(paramList, "mItems[position]");
    localMediaItemView.a(paramb, (GalleryItem.MediaItem)paramList, this.fLh, 0);
    AppMethodBeat.o(200781);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(164856);
    long l = ((GalleryItem.MediaItem)this.cbP.get(paramInt)).rBs;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$Companion;", "", "()V", "NOTIFY_CHANGE_MASK", "", "NOTIFY_CHANGE_NORMAL", "NOTIFY_CHANGE_NUM", "plugin-gallery_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "onMediaUnSelected", "plugin-gallery_release"})
  public final class b
    implements View.OnClickListener, View.OnLongClickListener, MediaItemView.b<GalleryItem.MediaItem>
  {
    private final RecyclerView fPw;
    
    public b()
    {
      AppMethodBeat.i(164854);
      this.fPw = localObject;
      AppMethodBeat.o(164854);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164853);
      k.h(paramView, "v");
      Object localObject = this.fPw.bu(paramView);
      if (localObject == null) {
        k.fvU();
      }
      k.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.rCW;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.v)localObject).ln());
        k.g(localObject, "mItems[holder.adapterPosition]");
        paramView.c((GalleryItem.MediaItem)localObject);
        AppMethodBeat.o(164853);
        return;
      }
      AppMethodBeat.o(164853);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164852);
      k.h(paramView, "v");
      Object localObject = this.fPw.bu(paramView);
      if (localObject == null) {
        k.fvU();
      }
      k.g(localObject, "recyclerView.findContainingViewHolder(v)!!");
      paramView = a.this.rCX;
      if (paramView != null)
      {
        localObject = a.a(a.this).get(((RecyclerView.v)localObject).ln());
        k.g(localObject, "mItems[holder.adapterPosition]");
        boolean bool = paramView.b((GalleryItem.MediaItem)localObject);
        AppMethodBeat.o(164852);
        return bool;
      }
      AppMethodBeat.o(164852);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void c(GalleryItem.MediaItem paramMediaItem);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
  public static abstract interface d
  {
    public abstract boolean b(GalleryItem.MediaItem paramMediaItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.a
 * JD-Core Version:    0.7.0.1
 */