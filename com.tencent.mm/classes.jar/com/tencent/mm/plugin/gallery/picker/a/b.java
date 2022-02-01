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
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/loader/Loader;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;)V", "selectedFolder", "getSelectedFolder", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "setSelectedFolder", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class b
  extends com.tencent.mm.ui.base.a.a<GalleryItem.AlbumItem, FolderItemView>
{
  private d<GalleryItem.MediaItem> gVG;
  public b xkH;
  c xkI;
  GalleryItem.AlbumItem xkJ;
  
  public b(d<GalleryItem.MediaItem> paramd)
  {
    AppMethodBeat.i(164868);
    this.gVG = paramd;
    AppMethodBeat.o(164868);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(164866);
    p.h(paramb, "viewHolder");
    Object localObject3 = (FolderItemView)paramb.getView();
    ((FolderItemView)localObject3).setOnClickListener((View.OnClickListener)new a(paramb));
    Object localObject1 = this.cvc.get(paramInt);
    p.g(localObject1, "mItems[position]");
    Object localObject2 = (GalleryItem.AlbumItem)localObject1;
    localObject1 = this.gVG;
    boolean bool = p.j(this.xkJ, (GalleryItem.AlbumItem)this.cvc.get(paramInt));
    p.h(paramb, "holder");
    p.h(localObject2, "media");
    p.h(localObject1, "loader");
    ((FolderItemView)localObject3).xlC = paramb;
    localObject3 = paramb.Mn(2131301644);
    Context localContext = paramb.getContext();
    p.g(localContext, "holder.context");
    ((View)localObject3).setBackgroundColor(localContext.getResources().getColor(2131100888));
    paramb.e(2131301638, (CharSequence)((GalleryItem.AlbumItem)localObject2).albumName);
    paramb.e(2131301634, (CharSequence)String.valueOf(((GalleryItem.AlbumItem)localObject2).dJl));
    paramb.mf(2131301634, 0);
    localObject3 = (ImageView)paramb.Mn(2131301643);
    p.g(localObject3, "thumbView");
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject2 = ((GalleryItem.AlbumItem)localObject2).gEB();
    p.g(localObject2, "media.mediaItem");
    ((d)localObject1).bP(localObject2).c((ImageView)localObject3);
    if (!bool) {}
    for (paramInt = 8;; paramInt = 0)
    {
      paramb.mf(2131301642, paramInt);
      AppMethodBeat.o(164866);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "plugin-gallery_release"})
  public final class a
    implements View.OnClickListener, View.OnLongClickListener
  {
    private final com.tencent.mm.ui.base.a.b xkK;
    
    public a()
    {
      AppMethodBeat.i(164864);
      this.xkK = localObject;
      AppMethodBeat.o(164864);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164863);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramView, "v");
      b.this.xkJ = ((GalleryItem.AlbumItem)b.a(b.this).get(this.xkK.lR()));
      paramView = b.this.xkH;
      if (paramView != null)
      {
        localObject = b.this.xkJ;
        if (localObject == null) {
          p.hyc();
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
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      p.h(paramView, "v");
      paramView = b.this.xkI;
      if (paramView != null) {
        p.g(b.a(b.this).get(this.xkK.lR()), "mItems[viewHolder.adapterPosition]");
      }
      for (boolean bool = paramView.dRB();; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164862);
        return bool;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface b
  {
    public abstract void a(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract boolean dRB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.b
 * JD-Core Version:    0.7.0.1
 */