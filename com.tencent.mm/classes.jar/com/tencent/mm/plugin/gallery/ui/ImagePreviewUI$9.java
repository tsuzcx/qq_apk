package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.Queue;

final class ImagePreviewUI$9
  implements f.b
{
  ImagePreviewUI$9(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ImagePreviewUI.g(this.kKb) });
    if (!ImagePreviewUI.p(this.kKb))
    {
      a.swap(ImagePreviewUI.r(this.kKb), paramInt1, paramInt2);
      c localc = ImagePreviewUI.h(this.kKb);
      int i = ImagePreviewUI.g(this.kKb).intValue();
      y.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3) });
      if (!localc.kIW)
      {
        a.swap(localc.kIV, paramInt1, paramInt2);
        localc.kIY = paramInt3;
        localc.kIZ = ((View)localc.uZw.get(i));
        localc.uZu.remove(localc.kIZ);
        localc.uZv.clear();
        localc.uZw.clear();
        localc.kJa = true;
        localc.notifyDataSetChanged();
      }
      ImagePreviewUI.q(this.kKb).m(paramInt3, false);
      ((f)ImagePreviewUI.o(this.kKb).getAdapter()).cX(paramInt3, paramInt3);
      com.tencent.mm.plugin.gallery.model.c.kGE = true;
      return;
    }
    a.swap(ImagePreviewUI.d(this.kKb), paramInt1, paramInt2);
    com.tencent.mm.plugin.gallery.model.c.kGC = true;
  }
  
  public final void cW(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ImagePreviewUI.g(this.kKb) });
  }
  
  public final void sc(int paramInt)
  {
    y.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ImagePreviewUI.p(this.kKb)) });
    ((f)ImagePreviewUI.o(this.kKb).getAdapter()).cX(paramInt, paramInt);
    ImagePreviewUI.q(this.kKb).m(paramInt, false);
    if (!ImagePreviewUI.p(this.kKb))
    {
      com.tencent.mm.plugin.gallery.model.c.kGF = true;
      return;
    }
    com.tencent.mm.plugin.gallery.model.c.kGD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.9
 * JD-Core Version:    0.7.0.1
 */