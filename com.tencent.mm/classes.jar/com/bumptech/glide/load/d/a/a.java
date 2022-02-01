package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<DataType>
  implements com.bumptech.glide.load.j<DataType, BitmapDrawable>
{
  private final com.bumptech.glide.load.j<DataType, Bitmap> aKJ;
  private final Resources aKy;
  
  public a(Resources paramResources, com.bumptech.glide.load.j<DataType, Bitmap> paramj)
  {
    AppMethodBeat.i(77348);
    this.aKy = ((Resources)com.bumptech.glide.g.j.checkNotNull(paramResources, "Argument must not be null"));
    this.aKJ = ((com.bumptech.glide.load.j)com.bumptech.glide.g.j.checkNotNull(paramj, "Argument must not be null"));
    AppMethodBeat.o(77348);
  }
  
  public final v<BitmapDrawable> a(DataType paramDataType, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77350);
    paramDataType = this.aKJ.a(paramDataType, paramInt1, paramInt2, parami);
    paramDataType = m.a(this.aKy, paramDataType);
    AppMethodBeat.o(77350);
    return paramDataType;
  }
  
  public final boolean a(DataType paramDataType, i parami)
  {
    AppMethodBeat.i(77349);
    boolean bool = this.aKJ.a(paramDataType, parami);
    AppMethodBeat.o(77349);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.a
 * JD-Core Version:    0.7.0.1
 */