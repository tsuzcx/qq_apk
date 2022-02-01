package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<DataType>
  implements k<DataType, BitmapDrawable>
{
  private final Resources aKG;
  private final k<DataType, Bitmap> aKR;
  
  public a(Resources paramResources, k<DataType, Bitmap> paramk)
  {
    AppMethodBeat.i(77348);
    this.aKG = ((Resources)i.checkNotNull(paramResources, "Argument must not be null"));
    this.aKR = ((k)i.checkNotNull(paramk, "Argument must not be null"));
    AppMethodBeat.o(77348);
  }
  
  public final u<BitmapDrawable> a(DataType paramDataType, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77350);
    paramDataType = this.aKR.a(paramDataType, paramInt1, paramInt2, paramj);
    paramDataType = l.a(this.aKG, paramDataType);
    AppMethodBeat.o(77350);
    return paramDataType;
  }
  
  public final boolean a(DataType paramDataType, j paramj)
  {
    AppMethodBeat.i(77349);
    boolean bool = this.aKR.a(paramDataType, paramj);
    AppMethodBeat.o(77349);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.a
 * JD-Core Version:    0.7.0.1
 */