package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class c$3
  implements c.c
{
  c$3(c paramc, ImageView paramImageView, Context paramContext) {}
  
  public final void aC(String paramString, boolean paramBoolean)
  {
    y.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    c.b(this.ktI).remove(paramString);
    if (!paramBoolean) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = c.a(this.ktI, paramString);
    } while (!paramString.equals(this.bid.getTag()));
    c.c(this.ktI).post(new c.3.1(this, paramString, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.3
 * JD-Core Version:    0.7.0.1
 */