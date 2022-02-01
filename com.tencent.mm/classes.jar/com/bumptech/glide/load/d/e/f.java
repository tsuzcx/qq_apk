package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.d;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class f
  implements l<c>
{
  private final l<Bitmap> aLm;
  
  public f(l<Bitmap> paraml)
  {
    AppMethodBeat.i(77506);
    this.aLm = ((l)j.checkNotNull(paraml, "Argument must not be null"));
    AppMethodBeat.o(77506);
  }
  
  public final v<c> a(Context paramContext, v<c> paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77507);
    c localc = (c)paramv.get();
    Object localObject = com.bumptech.glide.c.af(paramContext).aCj;
    localObject = new d(localc.pJ(), (e)localObject);
    paramContext = this.aLm.a(paramContext, (v)localObject, paramInt1, paramInt2);
    if (!localObject.equals(paramContext)) {
      ((v)localObject).recycle();
    }
    paramContext = (Bitmap)paramContext.get();
    localObject = this.aLm;
    localc.aLL.aLQ.a((l)localObject, paramContext);
    AppMethodBeat.o(77507);
    return paramv;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77510);
    this.aLm.a(paramMessageDigest);
    AppMethodBeat.o(77510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77508);
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      boolean bool = this.aLm.equals(paramObject.aLm);
      AppMethodBeat.o(77508);
      return bool;
    }
    AppMethodBeat.o(77508);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77509);
    int i = this.aLm.hashCode();
    AppMethodBeat.o(77509);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.f
 * JD-Core Version:    0.7.0.1
 */