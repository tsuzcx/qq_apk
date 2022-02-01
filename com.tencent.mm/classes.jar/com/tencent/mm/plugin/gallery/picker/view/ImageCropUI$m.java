package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ImageCropUI$m
  implements View.OnClickListener
{
  ImageCropUI$m(ImageCropUI paramImageCropUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(257796);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ImageCropUI.d(this.xlY);
    a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(257796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.m
 * JD-Core Version:    0.7.0.1
 */