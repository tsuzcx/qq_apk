package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

final class ImagePreviewUI$27
  implements MenuItem.OnMenuItemClickListener
{
  ImagePreviewUI$27(ImagePreviewUI paramImagePreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int j = 0;
    if (ImagePreviewUI.j(this.kKb) == 6)
    {
      this.kKb.setResult(1);
      this.kKb.finish();
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("isPreviewPhoto", this.kKb.getIntent().getBooleanExtra("isPreviewPhoto", false));
    Object localObject = ImagePreviewUI.k(this.kKb);
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() == 0))
    {
      localObject = ImagePreviewUI.h(this.kKb).rZ(ImagePreviewUI.g(this.kKb).intValue());
      if ((ImagePreviewUI.l(this.kKb)) && (ImagePreviewUI.h(this.kKb) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
      {
        ImagePreviewUI.a(this.kKb, ((GalleryItem.MediaItem)localObject).eAu);
        i = 0;
      }
    }
    for (;;)
    {
      if (!ImagePreviewUI.b(this.kKb)) {}
      boolean bool2;
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = ImagePreviewUI.l(this.kKb);
        if (i != 0) {
          break label213;
        }
        ImagePreviewUI.a(this.kKb, paramMenuItem, bool2, bool1);
        return true;
        ImagePreviewUI.e(this.kKb).performClick();
        i = 300;
        break;
      }
      label213:
      localObject = com.tencent.mm.plugin.gallery.model.c.aXc();
      paramMenuItem = new ImagePreviewUI.27.1(this, paramMenuItem, bool2, bool1);
      if (i < 0) {
        i = j;
      }
      for (;;)
      {
        ((e)localObject).aXq().postDelayed(paramMenuItem, i);
        return true;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.27
 * JD-Core Version:    0.7.0.1
 */