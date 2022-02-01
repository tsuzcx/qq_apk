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
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.view.FolderItemView;
import com.tencent.mm.ui.base.a.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/loader/Loader;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;)V", "selectedFolder", "getSelectedFolder", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "setSelectedFolder", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class b
  extends a<GalleryItem.AlbumItem, FolderItemView>
{
  private d<GalleryItem.MediaItem> fOT;
  public b sLW;
  c sLX;
  GalleryItem.AlbumItem sLY;
  
  public b(d<GalleryItem.MediaItem> paramd)
  {
    AppMethodBeat.i(164868);
    this.fOT = paramd;
    AppMethodBeat.o(164868);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(164866);
    k.h(paramb, "viewHolder");
    Object localObject3 = (FolderItemView)paramb.getView();
    ((FolderItemView)localObject3).setOnClickListener((View.OnClickListener)new a(paramb));
    Object localObject1 = this.bYM.get(paramInt);
    k.g(localObject1, "mItems[position]");
    Object localObject2 = (GalleryItem.AlbumItem)localObject1;
    localObject1 = this.fOT;
    boolean bool = k.g(this.sLY, (GalleryItem.AlbumItem)this.bYM.get(paramInt));
    k.h(paramb, "holder");
    k.h(localObject2, "media");
    k.h(localObject1, "loader");
    ((FolderItemView)localObject3).sMR = paramb;
    localObject3 = paramb.adJ(2131300188);
    Context localContext = paramb.getContext();
    k.g(localContext, "holder.context");
    ((View)localObject3).setBackgroundColor(localContext.getResources().getColor(2131100695));
    paramb.d(2131300182, (CharSequence)((GalleryItem.AlbumItem)localObject2).sJZ);
    paramb.d(2131300178, (CharSequence)String.valueOf(((GalleryItem.AlbumItem)localObject2).dfy));
    paramb.kl(2131300178, 0);
    localObject3 = (ImageView)paramb.adJ(2131300187);
    k.g(localObject3, "thumbView");
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject2 = ((GalleryItem.AlbumItem)localObject2).cWr();
    k.g(localObject2, "media.mediaItem");
    ((d)localObject1).bF(localObject2).c((ImageView)localObject3);
    if (!bool) {}
    for (paramInt = 8;; paramInt = 0)
    {
      paramb.kl(2131300186, paramInt);
      AppMethodBeat.o(164866);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "plugin-gallery_release"})
  public final class a
    implements View.OnClickListener, View.OnLongClickListener
  {
    private final com.tencent.mm.ui.base.a.b sLZ;
    
    public a()
    {
      AppMethodBeat.i(164864);
      this.sLZ = localObject;
      AppMethodBeat.o(164864);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164863);
      k.h(paramView, "v");
      b.this.sLY = ((GalleryItem.AlbumItem)b.a(b.this).get(this.sLZ.lv()));
      paramView = b.this.sLW;
      if (paramView != null)
      {
        GalleryItem.AlbumItem localAlbumItem = b.this.sLY;
        if (localAlbumItem == null) {
          k.fOy();
        }
        paramView.a(localAlbumItem);
        AppMethodBeat.o(164863);
        return;
      }
      AppMethodBeat.o(164863);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164862);
      k.h(paramView, "v");
      paramView = b.this.sLX;
      if (paramView != null)
      {
        k.g(b.a(b.this).get(this.sLZ.lv()), "mItems[viewHolder.adapterPosition]");
        boolean bool = paramView.cNl();
        AppMethodBeat.o(164862);
        return bool;
      }
      AppMethodBeat.o(164862);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface b
  {
    public abstract void a(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract boolean cNl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.b
 * JD-Core Version:    0.7.0.1
 */