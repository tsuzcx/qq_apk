package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j
  implements l<Drawable>
{
  private final l<Bitmap> aLm;
  private final boolean aLn;
  
  public j(l<Bitmap> paraml, boolean paramBoolean)
  {
    this.aLm = paraml;
    this.aLn = true;
  }
  
  public final v<Drawable> a(Context paramContext, v<Drawable> paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77404);
    Object localObject2 = c.af(paramContext).aCj;
    Object localObject1 = (Drawable)paramv.get();
    localObject2 = i.a((e)localObject2, (Drawable)localObject1, paramInt1, paramInt2);
    if (localObject2 == null)
    {
      if (this.aLn)
      {
        paramContext = new IllegalArgumentException("Unable to convert " + localObject1 + " to a Bitmap");
        AppMethodBeat.o(77404);
        throw paramContext;
      }
      AppMethodBeat.o(77404);
      return paramv;
    }
    localObject1 = this.aLm.a(paramContext, (v)localObject2, paramInt1, paramInt2);
    if (localObject1.equals(localObject2))
    {
      ((v)localObject1).recycle();
      AppMethodBeat.o(77404);
      return paramv;
    }
    paramContext = m.a(paramContext.getResources(), (v)localObject1);
    AppMethodBeat.o(77404);
    return paramContext;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77407);
    this.aLm.a(paramMessageDigest);
    AppMethodBeat.o(77407);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77405);
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      boolean bool = this.aLm.equals(paramObject.aLm);
      AppMethodBeat.o(77405);
      return bool;
    }
    AppMethodBeat.o(77405);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77406);
    int i = this.aLm.hashCode();
    AppMethodBeat.o(77406);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.j
 * JD-Core Version:    0.7.0.1
 */