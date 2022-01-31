package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ImagePreviewUI$12
  implements Runnable
{
  ImagePreviewUI$12(ImagePreviewUI paramImagePreviewUI, long paramLong) {}
  
  public final void run()
  {
    ImagePreviewUI.a(this.kKb, true);
    c.aXc().rN(-8);
    y.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bk.cp(this.kKd)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.12
 * JD-Core Version:    0.7.0.1
 */