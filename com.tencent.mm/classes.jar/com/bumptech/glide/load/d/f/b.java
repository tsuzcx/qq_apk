package com.bumptech.glide.load.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.m;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements e<Bitmap, BitmapDrawable>
{
  private final Resources aKy;
  
  public b(Resources paramResources)
  {
    AppMethodBeat.i(77530);
    this.aKy = ((Resources)j.checkNotNull(paramResources, "Argument must not be null"));
    AppMethodBeat.o(77530);
  }
  
  public final v<BitmapDrawable> a(v<Bitmap> paramv, i parami)
  {
    AppMethodBeat.i(77531);
    paramv = m.a(this.aKy, paramv);
    AppMethodBeat.o(77531);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.f.b
 * JD-Core Version:    0.7.0.1
 */