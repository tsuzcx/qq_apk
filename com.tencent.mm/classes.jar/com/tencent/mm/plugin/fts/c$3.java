package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Set;

final class c$3
  implements c.c
{
  c$3(c paramc, ImageView paramImageView, Context paramContext) {}
  
  public final void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(136524);
    ab.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    c.b(this.mPv).remove(paramString);
    if (!paramBoolean)
    {
      AppMethodBeat.o(136524);
      return;
    }
    Bitmap localBitmap = c.a(this.mPv, paramString);
    if (paramString.equals(this.mPw.getTag())) {
      c.c(this.mPv).post(new c.3.1(this, paramString, localBitmap));
    }
    AppMethodBeat.o(136524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.3
 * JD-Core Version:    0.7.0.1
 */