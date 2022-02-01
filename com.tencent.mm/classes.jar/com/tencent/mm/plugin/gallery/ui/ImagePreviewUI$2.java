package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ImagePreviewUI$2
  implements View.OnClickListener
{
  ImagePreviewUI$2(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111560);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ImagePreviewUI.e(this.tZM).performClick();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.2
 * JD-Core Version:    0.7.0.1
 */