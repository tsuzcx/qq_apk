package com.bumptech.glide.c.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j
  implements m<Drawable>
{
  private final m<Bitmap> aJD;
  private final boolean aJE;
  
  public j(m<Bitmap> paramm)
  {
    this.aJD = paramm;
    this.aJE = true;
  }
  
  public final u<Drawable> a(Context paramContext, u<Drawable> paramu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77404);
    Object localObject2 = c.ad(paramContext).aAt;
    Object localObject1 = (Drawable)paramu.get();
    localObject2 = i.a((e)localObject2, (Drawable)localObject1, paramInt1, paramInt2);
    if (localObject2 == null)
    {
      if (this.aJE)
      {
        paramContext = new IllegalArgumentException("Unable to convert " + localObject1 + " to a Bitmap");
        AppMethodBeat.o(77404);
        throw paramContext;
      }
      AppMethodBeat.o(77404);
      return paramu;
    }
    localObject1 = this.aJD.a(paramContext, (u)localObject2, paramInt1, paramInt2);
    if (localObject1.equals(localObject2))
    {
      ((u)localObject1).recycle();
      AppMethodBeat.o(77404);
      return paramu;
    }
    paramContext = l.a(paramContext.getResources(), (u)localObject1);
    AppMethodBeat.o(77404);
    return paramContext;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77407);
    this.aJD.a(paramMessageDigest);
    AppMethodBeat.o(77407);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77405);
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      boolean bool = this.aJD.equals(paramObject.aJD);
      AppMethodBeat.o(77405);
      return bool;
    }
    AppMethodBeat.o(77405);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77406);
    int i = this.aJD.hashCode();
    AppMethodBeat.o(77406);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.j
 * JD-Core Version:    0.7.0.1
 */