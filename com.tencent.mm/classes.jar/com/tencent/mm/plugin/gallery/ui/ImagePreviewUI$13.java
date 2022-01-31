package com.tencent.mm.plugin.gallery.ui;

import android.support.v4.view.ViewPager.e;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class ImagePreviewUI$13
  implements ViewPager.e
{
  ImagePreviewUI$13(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void Q(int paramInt)
  {
    if (ImagePreviewUI.h(this.kKb) != null) {
      ImagePreviewUI.h(this.kKb).kJd.Q(paramInt);
    }
  }
  
  public final void R(int paramInt)
  {
    com.tencent.mm.plugin.gallery.model.c.rI(paramInt);
    String str = ImagePreviewUI.h(this.kKb).ke(paramInt);
    ImagePreviewUI.a(this.kKb, paramInt, str);
    boolean bool = ImagePreviewUI.d(this.kKb).contains(str);
    ImagePreviewUI.a(this.kKb, Integer.valueOf(paramInt));
    Object localObject = ImagePreviewUI.e(this.kKb);
    int i;
    if (bool)
    {
      i = R.k.checkbox_selected;
      ((ImageButton)localObject).setImageResource(i);
      if (!ImagePreviewUI.b(this.kKb)) {
        break label186;
      }
      ImagePreviewUI.c(this.kKb).setImageResource(R.k.radio_on);
      label98:
      this.kKb.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(ImagePreviewUI.h(this.kKb).getCount()) }));
      localObject = ImagePreviewUI.h(this.kKb).kJc;
      if (((e)localObject).UL != -1) {
        break label265;
      }
      i = 0;
      label162:
      if (i != 0) {
        break label202;
      }
      ((e)localObject).sb(paramInt);
    }
    for (;;)
    {
      i += 1;
      break label162;
      i = R.k.checkbox_unselected;
      break;
      label186:
      ImagePreviewUI.c(this.kKb).setImageResource(R.k.radio_off);
      break label98;
      label202:
      if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
        break label286;
      }
      if (paramInt + i <= paramInt + 3) {
        ((e)localObject).sb(paramInt + i);
      }
      if (paramInt - i >= Math.max(paramInt - 3, 0)) {
        ((e)localObject).sb(paramInt - i);
      }
    }
    label265:
    if (((e)localObject).UL > paramInt) {
      ((e)localObject).sb(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label286:
      ((e)localObject).UL = paramInt;
      y.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = " + paramInt);
      localObject = com.tencent.mm.plugin.gallery.model.c.Ep(str);
      if ((ImagePreviewUI.t(this.kKb).getVisibility() == 0) || (ImagePreviewUI.u(this.kKb).getVisibility() == 0))
      {
        ImagePreviewUI.a(this.kKb, str, (GalleryItem.MediaItem)localObject);
        ImagePreviewUI.a(this.kKb, (GalleryItem.MediaItem)localObject);
      }
      return;
      if (((e)localObject).UL < paramInt) {
        ((e)localObject).sb(paramInt + 3);
      }
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.13
 * JD-Core Version:    0.7.0.1
 */