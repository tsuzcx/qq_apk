package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a.b;
import com.tencent.mm.ui.z;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "getLayoutId", "onCovert", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "isSelected", "", "plugin-gallery_release"})
public final class FolderItemView
  extends FrameLayout
{
  public b sMR;
  
  public FolderItemView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164917);
    paramContext = z.jD(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    k.g(paramContext, "view");
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164917);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164918);
    paramContext = z.jD(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    k.g(paramContext, "view");
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164918);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164919);
    paramContext = z.jD(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    k.g(paramContext, "view");
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164919);
  }
  
  public final b getHolder()
  {
    AppMethodBeat.i(164915);
    b localb = this.sMR;
    if (localb == null) {
      k.aVY("holder");
    }
    AppMethodBeat.o(164915);
    return localb;
  }
  
  public final int getLayoutId()
  {
    return 2131495311;
  }
  
  public final void setHolder(b paramb)
  {
    AppMethodBeat.i(164916);
    k.h(paramb, "<set-?>");
    this.sMR = paramb;
    AppMethodBeat.o(164916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.FolderItemView
 * JD-Core Version:    0.7.0.1
 */