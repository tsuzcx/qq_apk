package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  implements q, u<BitmapDrawable>
{
  private final Resources aIP;
  private final u<Bitmap> aJJ;
  
  private l(Resources paramResources, u<Bitmap> paramu)
  {
    AppMethodBeat.i(77412);
    this.aIP = ((Resources)i.checkNotNull(paramResources, "Argument must not be null"));
    this.aJJ = ((u)i.checkNotNull(paramu, "Argument must not be null"));
    AppMethodBeat.o(77412);
  }
  
  public static u<BitmapDrawable> a(Resources paramResources, u<Bitmap> paramu)
  {
    AppMethodBeat.i(77411);
    if (paramu == null)
    {
      AppMethodBeat.o(77411);
      return null;
    }
    paramResources = new l(paramResources, paramu);
    AppMethodBeat.o(77411);
    return paramResources;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77413);
    int i = this.aJJ.getSize();
    AppMethodBeat.o(77413);
    return i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77415);
    if ((this.aJJ instanceof q)) {
      ((q)this.aJJ).initialize();
    }
    AppMethodBeat.o(77415);
  }
  
  public final Class<BitmapDrawable> oy()
  {
    return BitmapDrawable.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77414);
    this.aJJ.recycle();
    AppMethodBeat.o(77414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.l
 * JD-Core Version:    0.7.0.1
 */