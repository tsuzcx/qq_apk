package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.av.a;

final class d$4
  implements av.a
{
  d$4(d paramd, String paramString1, ImageView paramImageView, String paramString2) {}
  
  public final boolean JS()
  {
    Bitmap localBitmap2 = b.a(this.dol, false, -1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      o.JQ();
      localBitmap1 = com.tencent.mm.ag.d.kg(this.dol);
    }
    d.a(this.lue, this.bid, this.doz, localBitmap1);
    return true;
  }
  
  public final boolean JT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.4
 * JD-Core Version:    0.7.0.1
 */