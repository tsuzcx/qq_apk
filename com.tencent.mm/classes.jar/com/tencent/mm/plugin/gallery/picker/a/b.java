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
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/loader/Loader;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;)V", "selectedFolder", "getSelectedFolder", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "setSelectedFolder", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class b
  extends com.tencent.mm.ui.base.a.a<GalleryItem.AlbumItem, FolderItemView>
{
  private d<GalleryItem.MediaItem> gkL;
  public b tTu;
  c tTv;
  GalleryItem.AlbumItem tTw;
  
  public b(d<GalleryItem.MediaItem> paramd)
  {
    AppMethodBeat.i(164868);
    this.gkL = paramd;
    AppMethodBeat.o(164868);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(164866);
    p.h(paramb, "viewHolder");
    Object localObject3 = (FolderItemView)paramb.getView();
    ((FolderItemView)localObject3).setOnClickListener((View.OnClickListener)new a(paramb));
    Object localObject1 = this.cjg.get(paramInt);
    p.g(localObject1, "mItems[position]");
    Object localObject2 = (GalleryItem.AlbumItem)localObject1;
    localObject1 = this.gkL;
    boolean bool = p.i(this.tTw, (GalleryItem.AlbumItem)this.cjg.get(paramInt));
    p.h(paramb, "holder");
    p.h(localObject2, "media");
    p.h(localObject1, "loader");
    ((FolderItemView)localObject3).tUq = paramb;
    localObject3 = paramb.GD(2131300188);
    Context localContext = paramb.getContext();
    p.g(localContext, "holder.context");
    ((View)localObject3).setBackgroundColor(localContext.getResources().getColor(2131100695));
    paramb.e(2131300182, (CharSequence)((GalleryItem.AlbumItem)localObject2).tRB);
    paramb.e(2131300178, (CharSequence)String.valueOf(((GalleryItem.AlbumItem)localObject2).drZ));
    paramb.kH(2131300178, 0);
    localObject3 = (ImageView)paramb.GD(2131300187);
    p.g(localObject3, "thumbView");
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject2 = ((GalleryItem.AlbumItem)localObject2).dnF();
    p.g(localObject2, "media.mediaItem");
    ((d)localObject1).bH(localObject2).c((ImageView)localObject3);
    if (!bool) {}
    for (paramInt = 8;; paramInt = 0)
    {
      paramb.kH(2131300186, paramInt);
      AppMethodBeat.o(164866);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "plugin-gallery_release"})
  public final class a
    implements View.OnClickListener, View.OnLongClickListener
  {
    private final com.tencent.mm.ui.base.a.b tTx;
    
    public a()
    {
      AppMethodBeat.i(164864);
      this.tTx = localObject;
      AppMethodBeat.o(164864);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164863);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramView, "v");
      b.this.tTw = ((GalleryItem.AlbumItem)b.a(b.this).get(this.tTx.lN()));
      paramView = b.this.tTu;
      if (paramView != null)
      {
        localObject = b.this.tTw;
        if (localObject == null) {
          p.gkB();
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
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      p.h(paramView, "v");
      paramView = b.this.tTv;
      if (paramView != null) {
        p.g(b.a(b.this).get(this.tTx.lN()), "mItems[viewHolder.adapterPosition]");
      }
      for (boolean bool = paramView.cYi();; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164862);
        return bool;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface b
  {
    public abstract void a(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract boolean cYi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.b
 * JD-Core Version:    0.7.0.1
 */