package com.bumptech.glide.load.d;

import android.content.Context;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b<T>
  implements l<T>
{
  private static final l<?> aKI;
  
  static
  {
    AppMethodBeat.i(77347);
    aKI = new b();
    AppMethodBeat.o(77347);
  }
  
  public static <T> b<T> px()
  {
    return (b)aKI;
  }
  
  public final v<T> a(Context paramContext, v<T> paramv, int paramInt1, int paramInt2)
  {
    return paramv;
  }
  
  public final void a(MessageDigest paramMessageDigest) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.b
 * JD-Core Version:    0.7.0.1
 */