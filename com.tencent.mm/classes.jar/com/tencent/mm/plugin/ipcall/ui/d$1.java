package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.ref.WeakReference;

final class d$1
  implements av.a
{
  private boolean dNw = false;
  
  d$1(d paramd, String paramString1, String paramString2, ImageView paramImageView, String paramString3) {}
  
  public final boolean JS()
  {
    Bitmap localBitmap = a.ay(this.lue.context, this.lud);
    if (localBitmap != null)
    {
      this.lue.luc.put(this.doz, new WeakReference(localBitmap));
      this.dNw = true;
      d.a(this.lue, this.bid, this.doz, localBitmap);
    }
    return true;
  }
  
  public final boolean JT()
  {
    if (!this.dNw)
    {
      d locald = this.lue;
      String str2 = this.lud;
      String str1 = this.dol;
      ImageView localImageView = this.bid;
      str2 = d.dC(str2, str1);
      locald.lub.c(new d.2(locald, str1, localImageView, str2));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.1
 * JD-Core Version:    0.7.0.1
 */