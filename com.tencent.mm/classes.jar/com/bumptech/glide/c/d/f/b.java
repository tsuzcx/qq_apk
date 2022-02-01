package com.bumptech.glide.c.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.l;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements e<Bitmap, BitmapDrawable>
{
  private final Resources aIP;
  
  public b(Resources paramResources)
  {
    AppMethodBeat.i(77530);
    this.aIP = ((Resources)i.checkNotNull(paramResources, "Argument must not be null"));
    AppMethodBeat.o(77530);
  }
  
  public final u<BitmapDrawable> a(u<Bitmap> paramu, j paramj)
  {
    AppMethodBeat.i(77531);
    paramu = l.a(this.aIP, paramu);
    AppMethodBeat.o(77531);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.f.b
 * JD-Core Version:    0.7.0.1
 */