package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ImagePreviewUI$5
  implements View.OnClickListener
{
  ImagePreviewUI$5(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111563);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ImagePreviewUI.t(this.HPA);
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.5
 * JD-Core Version:    0.7.0.1
 */