package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;

final class SmartGalleryUI$1
  implements View.OnClickListener
{
  SmartGalleryUI$1(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111671);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (Util.isNullOrNil(SmartGalleryUI.a(this.HQw).getText()))
    {
      this.HQw.setResult(-2, this.HQw.getIntent().putExtra("send_raw_img", SmartGalleryUI.b(this.HQw)));
      this.HQw.finish();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111671);
      return;
      SmartGalleryUI.a(this.HQw).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */