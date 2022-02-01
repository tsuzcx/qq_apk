package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ImagePreviewUI$23
  implements View.OnClickListener
{
  ImagePreviewUI$23(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111586);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ImagePreviewUI.c(this.xrb).performClick();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.23
 * JD-Core Version:    0.7.0.1
 */