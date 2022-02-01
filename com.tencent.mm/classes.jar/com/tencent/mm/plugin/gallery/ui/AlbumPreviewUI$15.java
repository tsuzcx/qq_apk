package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AlbumPreviewUI$15
  implements View.OnClickListener
{
  AlbumPreviewUI$15(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111434);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    AlbumPreviewUI.c(this.tXx).performClick();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */