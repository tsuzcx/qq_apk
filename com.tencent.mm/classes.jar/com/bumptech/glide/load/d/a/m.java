package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements r, v<BitmapDrawable>
{
  private final Resources aKy;
  private final v<Bitmap> aLs;
  
  private m(Resources paramResources, v<Bitmap> paramv)
  {
    AppMethodBeat.i(77412);
    this.aKy = ((Resources)j.checkNotNull(paramResources, "Argument must not be null"));
    this.aLs = ((v)j.checkNotNull(paramv, "Argument must not be null"));
    AppMethodBeat.o(77412);
  }
  
  public static v<BitmapDrawable> a(Resources paramResources, v<Bitmap> paramv)
  {
    AppMethodBeat.i(77411);
    if (paramv == null)
    {
      AppMethodBeat.o(77411);
      return null;
    }
    paramResources = new m(paramResources, paramv);
    AppMethodBeat.o(77411);
    return paramResources;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77413);
    int i = this.aLs.getSize();
    AppMethodBeat.o(77413);
    return i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77415);
    if ((this.aLs instanceof r)) {
      ((r)this.aLs).initialize();
    }
    AppMethodBeat.o(77415);
  }
  
  public final Class<BitmapDrawable> oV()
  {
    return BitmapDrawable.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77414);
    this.aLs.recycle();
    AppMethodBeat.o(77414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.m
 * JD-Core Version:    0.7.0.1
 */