package com.tencent.mm.plugin.gallery.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class ImagePreviewUI$14
  implements ViewPager.OnPageChangeListener
{
  ImagePreviewUI$14(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(150890);
    if (ImagePreviewUI.h(this.ngC) != null) {
      ImagePreviewUI.h(this.ngC).nfA.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(150890);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(150889);
    com.tencent.mm.plugin.gallery.model.e.wG(paramInt);
    String str = ImagePreviewUI.h(this.ngC).getItem(paramInt);
    ImagePreviewUI.a(this.ngC, paramInt, str);
    boolean bool = ImagePreviewUI.d(this.ngC).contains(str);
    ImagePreviewUI.a(this.ngC, Integer.valueOf(paramInt));
    Object localObject = ImagePreviewUI.e(this.ngC);
    int i;
    if (bool)
    {
      i = ImagePreviewUI.bEF();
      ((ImageButton)localObject).setImageResource(i);
      if (!ImagePreviewUI.b(this.ngC)) {
        break label189;
      }
      ImagePreviewUI.c(this.ngC).setImageResource(2131231906);
      label102:
      this.ngC.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(ImagePreviewUI.h(this.ngC).getCount()) }));
      localObject = ImagePreviewUI.h(this.ngC).nfz;
      if (((e)localObject).Vy != -1) {
        break label267;
      }
      i = 0;
      label166:
      if (i != 0) {
        break label204;
      }
      ((e)localObject).wX(paramInt);
    }
    for (;;)
    {
      i += 1;
      break label166;
      i = 2131231142;
      break;
      label189:
      ImagePreviewUI.c(this.ngC).setImageResource(2131231905);
      break label102;
      label204:
      if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
        break label288;
      }
      if (paramInt + i <= paramInt + 3) {
        ((e)localObject).wX(paramInt + i);
      }
      if (paramInt - i >= Math.max(paramInt - 3, 0)) {
        ((e)localObject).wX(paramInt - i);
      }
    }
    label267:
    if (((e)localObject).Vy > paramInt) {
      ((e)localObject).wX(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label288:
      ((e)localObject).Vy = paramInt;
      ab.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramInt)));
      localObject = com.tencent.mm.plugin.gallery.model.e.PB(str);
      if ((ImagePreviewUI.u(this.ngC).getVisibility() == 0) || (ImagePreviewUI.v(this.ngC).getVisibility() == 0))
      {
        ImagePreviewUI.a(this.ngC, str, (GalleryItem.MediaItem)localObject);
        ImagePreviewUI.a(this.ngC, (GalleryItem.MediaItem)localObject);
      }
      AppMethodBeat.o(150889);
      return;
      if (((e)localObject).Vy < paramInt) {
        ((e)localObject).wX(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.14
 * JD-Core Version:    0.7.0.1
 */