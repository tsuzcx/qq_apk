package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ImageCropUI$n
  implements View.OnClickListener
{
  ImageCropUI$n(ImageCropUI paramImageCropUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(257797);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ImageCropUI.e(this.xlY).getLayout().hba();
    a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(257797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.n
 * JD-Core Version:    0.7.0.1
 */