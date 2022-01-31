package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class h$b
  implements Runnable
{
  final WeakReference<h> kKN;
  
  h$b(h paramh)
  {
    this.kKN = new WeakReference(paramh);
  }
  
  public final void run()
  {
    h localh = (h)this.kKN.get();
    if (localh == null)
    {
      y.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this task.");
      return;
    }
    y.v("MicroMsg.ThumbDrawable", "invalidateSelf");
    a locala = c.aXa();
    String str1 = localh.mFilePath;
    String str2 = localh.kGp;
    long l = localh.kGq;
    h.a(localh, locala.En(str1));
    if ((localh.kKJ != null) && (h.a(localh) != null) && (!h.a(localh).isRecycled())) {
      localh.kKJ.aXK();
    }
    localh.kKK = SystemClock.uptimeMillis();
    localh.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h.b
 * JD-Core Version:    0.7.0.1
 */