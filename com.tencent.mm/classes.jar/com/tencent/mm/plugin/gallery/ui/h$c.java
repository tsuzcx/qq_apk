package com.tencent.mm.plugin.gallery.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class h$c
  implements b.b
{
  final WeakReference<h> kKN;
  
  h$c(h paramh)
  {
    this.kKN = new WeakReference(paramh);
  }
  
  public final void Eo(String paramString)
  {
    h localh = (h)this.kKN.get();
    if (localh == null)
    {
      y.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this event.");
      return;
    }
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
      return;
    }
    if (!localh.mFilePath.equals(paramString))
    {
      y.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", new Object[] { paramString });
      return;
    }
    y.d("MicroMsg.ThumbDrawable", "notify thumb get " + paramString);
    localh.jjn.post(new h.b(localh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h.c
 * JD-Core Version:    0.7.0.1
 */