package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;

final class l$6
  implements Runnable
{
  l$6(String paramString, int paramInt1, int paramInt2, com.tencent.mm.plugin.fav.a.g paramg, xv paramxv, boolean paramBoolean, ImageView paramImageView) {}
  
  public final void run()
  {
    Bitmap localBitmap = l.c(this.dlh, this.kdS, this.kdT, false);
    if (localBitmap == null) {
      l.c(this.jYr, this.kdj, this.kdR);
    }
    String str;
    do
    {
      return;
      str = (String)this.jxK.getTag();
    } while ((str == null) || (!str.equals(this.dlh)));
    com.tencent.mm.kernel.g.DS();
    ai.d(new l.6.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.6
 * JD-Core Version:    0.7.0.1
 */