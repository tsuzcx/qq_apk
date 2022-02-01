package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.b.b;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class a
  implements e<Bitmap, byte[]>
{
  private final Bitmap.CompressFormat aMf;
  private final int quality;
  
  public a()
  {
    this(Bitmap.CompressFormat.JPEG);
  }
  
  private a(Bitmap.CompressFormat paramCompressFormat)
  {
    this.aMf = paramCompressFormat;
    this.quality = 100;
  }
  
  public final v<byte[]> a(v<Bitmap> paramv, i parami)
  {
    AppMethodBeat.i(77529);
    parami = new ByteArrayOutputStream();
    ((Bitmap)paramv.get()).compress(this.aMf, this.quality, parami);
    paramv.recycle();
    paramv = new b(parami.toByteArray());
    AppMethodBeat.o(77529);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.f.a
 * JD-Core Version:    0.7.0.1
 */