package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class SmartGalleryUI$1
  implements View.OnClickListener
{
  SmartGalleryUI$1(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111671);
    if (bs.aj(SmartGalleryUI.a(this.sTo).getText()))
    {
      this.sTo.setResult(-2, this.sTo.getIntent().putExtra("send_raw_img", SmartGalleryUI.b(this.sTo)));
      this.sTo.finish();
      AppMethodBeat.o(111671);
      return;
    }
    SmartGalleryUI.a(this.sTo).setText("");
    AppMethodBeat.o(111671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */