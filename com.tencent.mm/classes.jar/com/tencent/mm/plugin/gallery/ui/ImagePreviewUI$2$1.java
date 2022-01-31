package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImagePreviewUI$2$1
  implements Runnable
{
  ImagePreviewUI$2$1(ImagePreviewUI.2 param2, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(150876);
    ImagePreviewUI.a(this.ngF.ngC, this.val$intent, this.ngD, this.ngE);
    AppMethodBeat.o(150876);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150877);
    String str = super.toString() + "|addTextOptionMenu";
    AppMethodBeat.o(150877);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.2.1
 * JD-Core Version:    0.7.0.1
 */