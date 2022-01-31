package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.stub.a;

final class ImagePreviewUI$11
  implements Runnable
{
  ImagePreviewUI$11(ImagePreviewUI paramImagePreviewUI, String paramString) {}
  
  public final void run()
  {
    boolean bool1 = true;
    AppMethodBeat.i(150886);
    try
    {
      a locala = ImagePreviewUI.t(this.ngC);
      String str1 = this.val$path;
      String str2 = this.ngC.getIntent().getStringExtra("GalleryUI_ToUser");
      if (ImagePreviewUI.m(this.ngC)) {}
      for (;;)
      {
        locala.a(str1, str2, bool1, 0, true);
        AppMethodBeat.o(150886);
        return;
        boolean bool2 = ImagePreviewUI.b(this.ngC);
        if (bool2) {
          bool1 = false;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.11
 * JD-Core Version:    0.7.0.1
 */