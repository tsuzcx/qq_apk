package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.mm.plugin.gallery.stub.a;

final class ImagePreviewUI$10
  implements Runnable
{
  ImagePreviewUI$10(ImagePreviewUI paramImagePreviewUI, String paramString) {}
  
  public final void run()
  {
    boolean bool1 = true;
    try
    {
      a locala = ImagePreviewUI.s(this.kKb);
      String str1 = this.dlh;
      String str2 = this.kKb.getIntent().getStringExtra("GalleryUI_ToUser");
      if (ImagePreviewUI.l(this.kKb)) {}
      for (;;)
      {
        locala.a(str1, str2, bool1, 0, true);
        return;
        boolean bool2 = ImagePreviewUI.b(this.kKb);
        if (bool2) {
          bool1 = false;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.10
 * JD-Core Version:    0.7.0.1
 */