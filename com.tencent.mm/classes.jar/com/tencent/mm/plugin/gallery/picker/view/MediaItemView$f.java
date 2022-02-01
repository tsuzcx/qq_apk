package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class MediaItemView$f
  implements View.OnClickListener
{
  public MediaItemView$f(CheckBox paramCheckBox) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164952);
    paramView = this.rFp;
    k.g(paramView, "mediaSelectBox");
    CheckBox localCheckBox = this.rFp;
    k.g(localCheckBox, "mediaSelectBox");
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(164952);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView.f
 * JD-Core Version:    0.7.0.1
 */