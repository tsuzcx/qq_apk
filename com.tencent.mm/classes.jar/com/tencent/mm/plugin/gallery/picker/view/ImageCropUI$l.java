package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ImageCropUI$l
  implements View.OnClickListener
{
  ImageCropUI$l(ImageCropUI paramImageCropUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186229);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = a.tUr;
    a.HG(9);
    this.tUM.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.l
 * JD-Core Version:    0.7.0.1
 */