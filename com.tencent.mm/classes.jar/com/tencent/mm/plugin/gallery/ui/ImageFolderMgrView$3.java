package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ImageFolderMgrView$3
  implements View.OnClickListener
{
  ImageFolderMgrView$3(ImageFolderMgrView paramImageFolderMgrView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111532);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.HOz.HOy != null) {
      this.HOz.HOy.fBy();
    }
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.3
 * JD-Core Version:    0.7.0.1
 */