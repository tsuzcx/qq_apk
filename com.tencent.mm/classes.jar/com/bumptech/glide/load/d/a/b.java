package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements k<BitmapDrawable>
{
  private final e aCj;
  private final k<Bitmap> aGF;
  
  public b(e parame, k<Bitmap> paramk)
  {
    this.aCj = parame;
    this.aGF = paramk;
  }
  
  public final c b(i parami)
  {
    AppMethodBeat.i(77351);
    parami = this.aGF.b(parami);
    AppMethodBeat.o(77351);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.b
 * JD-Core Version:    0.7.0.1
 */