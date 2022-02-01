package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ImageCropUI$m
  implements View.OnClickListener
{
  ImageCropUI$m(ImageCropUI paramImageCropUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186230);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ImageCropUI.d(this.tUM);
    a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.m
 * JD-Core Version:    0.7.0.1
 */