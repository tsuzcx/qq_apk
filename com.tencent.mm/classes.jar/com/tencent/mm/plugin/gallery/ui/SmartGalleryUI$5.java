package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SmartGalleryUI$5
  implements View.OnClickListener
{
  SmartGalleryUI$5(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111675);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.HQw.setResult(SmartGalleryUI.HQv);
    this.HQw.finish();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */