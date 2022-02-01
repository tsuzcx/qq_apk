package com.tencent.mm.plugin.gallery.picker.view;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class ImageCropUI$q
  implements MenuItem.OnMenuItemClickListener
{
  ImageCropUI$q(ImageCropUI paramImageCropUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(186234);
    paramMenuItem = a.tUr;
    a.HG(9);
    this.tUM.finish();
    AppMethodBeat.o(186234);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.q
 * JD-Core Version:    0.7.0.1
 */