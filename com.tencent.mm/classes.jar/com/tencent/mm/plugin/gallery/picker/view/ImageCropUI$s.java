package com.tencent.mm.plugin.gallery.picker.view;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.p;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
final class ImageCropUI$s
  implements Runnable
{
  ImageCropUI$s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(186765);
    Object localObject;
    if ((this.rEK.getWidth() == 0) || (this.rEK.getHeight() == 0))
    {
      localObject = ae.eRJ();
      ImageCropUI.a(this.rEv, ((ae.a)localObject).width, ((ae.a)localObject).height);
    }
    for (;;)
    {
      this.rEK.setVisibility(0);
      ImageCropUI.b(this.rEv);
      localObject = ImageCropUI.c(this.rEv);
      if (localObject == null) {
        break;
      }
      ((p)localObject).dismiss();
      AppMethodBeat.o(186765);
      return;
      ImageCropUI.a(this.rEv, this.rEK.getWidth(), this.rEK.getHeight());
    }
    AppMethodBeat.o(186765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.s
 * JD-Core Version:    0.7.0.1
 */