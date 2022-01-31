package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.av.a;

final class d$3
  implements av.a
{
  d$3(d paramd, String paramString1, ImageView paramImageView, String paramString2) {}
  
  public final boolean JS()
  {
    Bitmap localBitmap = a.ay(this.lue.context, this.lud);
    d.a(this.lue, this.bid, this.doz, localBitmap);
    return true;
  }
  
  public final boolean JT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.3
 * JD-Core Version:    0.7.0.1
 */