package com.tencent.mm.plugin.gallery.picker.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.view.FolderItemView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/loader/Loader;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;)V", "selectedFolder", "getSelectedFolder", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "setSelectedFolder", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class b
  extends com.tencent.mm.ui.base.a.a<GalleryItem.AlbumItem, FolderItemView>
{
  public b BXb;
  c BXc;
  GalleryItem.AlbumItem BXd;
  private d<GalleryItem.MediaItem> jGC;
  
  public b(d<GalleryItem.MediaItem> paramd)
  {
    AppMethodBeat.i(164868);
    this.jGC = paramd;
    AppMethodBeat.o(164868);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(164866);
    p.k(paramb, "viewHolder");
    Object localObject3 = (FolderItemView)paramb.getView();
    ((FolderItemView)localObject3).setOnClickListener((View.OnClickListener)new a(paramb));
    Object localObject1 = this.ctq.get(paramInt);
    p.j(localObject1, "mItems[position]");
    Object localObject2 = (GalleryItem.AlbumItem)localObject1;
    localObject1 = this.jGC;
    boolean bool = p.h(this.BXd, (GalleryItem.AlbumItem)this.ctq.get(paramInt));
    p.k(paramb, "holder");
    p.k(localObject2, "media");
    p.k(localObject1, "loader");
    ((FolderItemView)localObject3).BXW = paramb;
    localObject3 = paramb.RD(b.e.folder_title);
    Context localContext = paramb.getContext();
    p.j(localContext, "holder.context");
    ((View)localObject3).setBackgroundColor(localContext.getResources().getColor(com.tencent.mm.plugin.gallery.b.b.navpage));
    paramb.e(b.e.folder_name, (CharSequence)((GalleryItem.AlbumItem)localObject2).albumName);
    paramb.e(b.e.folder_count, (CharSequence)String.valueOf(((GalleryItem.AlbumItem)localObject2).fCa));
    paramb.nx(b.e.folder_count, 0);
    localObject3 = (ImageView)paramb.RD(b.e.folder_thumb);
    p.j(localObject3, "thumbView");
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject2 = ((GalleryItem.AlbumItem)localObject2).evX();
    p.j(localObject2, "media.mediaItem");
    ((d)localObject1).bP(localObject2).c((ImageView)localObject3);
    int i = b.e.folder_selected_iv;
    if (!bool) {}
    for (paramInt = 8;; paramInt = 0)
    {
      paramb.nx(i, paramInt);
      AppMethodBeat.o(164866);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "plugin-gallery_release"})
  public final class a
    implements View.OnClickListener, View.OnLongClickListener
  {
    private final com.tencent.mm.ui.base.a.b BXe;
    
    public a()
    {
      AppMethodBeat.i(164864);
      this.BXe = localObject;
      AppMethodBeat.o(164864);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164863);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramView, "v");
      b.this.BXd = ((GalleryItem.AlbumItem)b.a(b.this).get(this.BXe.md()));
      paramView = b.this.BXb;
      if (paramView != null)
      {
        localObject = b.this.BXd;
        if (localObject == null) {
          p.iCn();
        }
        paramView.a((GalleryItem.AlbumItem)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164863);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164862);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      p.k(paramView, "v");
      paramView = b.this.BXc;
      if (paramView != null) {
        p.j(b.a(b.this).get(this.BXe.md()), "mItems[viewHolder.adapterPosition]");
      }
      for (boolean bool = paramView.eud();; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164862);
        return bool;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface b
  {
    public abstract void a(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract boolean eud();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.b
 * JD-Core Version:    0.7.0.1
 */