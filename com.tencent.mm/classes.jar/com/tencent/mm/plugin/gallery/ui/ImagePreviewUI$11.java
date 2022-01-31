package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.plugin.gallery.model.b;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Vector;

final class ImagePreviewUI$11
  implements b.b
{
  ImagePreviewUI$11(ImagePreviewUI paramImagePreviewUI, Intent paramIntent) {}
  
  public final void Eo(String paramString)
  {
    new ah(this.kKb.getMainLooper()).post(new ImagePreviewUI.11.1(this, paramString));
    paramString = c.aXa().kGi;
    if ((paramString.ebv != null) && (paramString.ebv.contains(this))) {
      paramString.ebv.remove(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.11
 * JD-Core Version:    0.7.0.1
 */