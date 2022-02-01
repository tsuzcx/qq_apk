package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.b.b;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class a
  implements e<Bitmap, byte[]>
{
  private final Bitmap.CompressFormat aKw;
  private final int quality;
  
  public a()
  {
    this(Bitmap.CompressFormat.JPEG);
  }
  
  private a(Bitmap.CompressFormat paramCompressFormat)
  {
    this.aKw = paramCompressFormat;
    this.quality = 100;
  }
  
  public final u<byte[]> a(u<Bitmap> paramu, j paramj)
  {
    AppMethodBeat.i(77529);
    paramj = new ByteArrayOutputStream();
    ((Bitmap)paramu.get()).compress(this.aKw, this.quality, paramj);
    paramu.recycle();
    paramu = new b(paramj.toByteArray());
    AppMethodBeat.o(77529);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.f.a
 * JD-Core Version:    0.7.0.1
 */