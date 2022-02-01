package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.d;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class f
  implements m<c>
{
  private final m<Bitmap> aLu;
  
  public f(m<Bitmap> paramm)
  {
    AppMethodBeat.i(77506);
    this.aLu = ((m)i.checkNotNull(paramm, "Argument must not be null"));
    AppMethodBeat.o(77506);
  }
  
  public final u<c> a(Context paramContext, u<c> paramu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77507);
    c localc = (c)paramu.get();
    Object localObject = com.bumptech.glide.c.ad(paramContext).aCk;
    localObject = new d(localc.pE(), (e)localObject);
    paramContext = this.aLu.a(paramContext, (u)localObject, paramInt1, paramInt2);
    if (!localObject.equals(paramContext)) {
      ((u)localObject).recycle();
    }
    paramContext = (Bitmap)paramContext.get();
    localObject = this.aLu;
    localc.aLT.aLY.a((m)localObject, paramContext);
    AppMethodBeat.o(77507);
    return paramu;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77510);
    this.aLu.a(paramMessageDigest);
    AppMethodBeat.o(77510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77508);
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      boolean bool = this.aLu.equals(paramObject.aLu);
      AppMethodBeat.o(77508);
      return bool;
    }
    AppMethodBeat.o(77508);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77509);
    int i = this.aLu.hashCode();
    AppMethodBeat.o(77509);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.f
 * JD-Core Version:    0.7.0.1
 */