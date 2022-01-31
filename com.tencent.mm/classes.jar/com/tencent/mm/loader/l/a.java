package com.tencent.mm.loader.l;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.a.b;
import com.tencent.mm.sdk.platformtools.d;
import java.io.InputStream;

public final class a
{
  public static Bitmap a(g<?> paramg, InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      if ((paramg != null) && (paramg.width > 0) && (paramg.width > 0)) {
        paramg = d.a(paramInputStream, 0.0F, paramg.width, paramg.height);
      }
    }
    for (;;)
    {
      paramInputStream = paramg;
      if (paramBoolean1) {
        paramInputStream = d.a(paramg, paramInt1, paramInt2, false, true);
      }
      paramg = paramInputStream;
      if (paramFloat > 0.0F) {
        paramg = d.c(paramInputStream, paramFloat);
      }
      paramInputStream = paramg;
      if (paramBoolean2) {
        paramInputStream = d.ak(paramg);
      }
      return paramInputStream;
      paramg = d.decodeStream(paramInputStream);
      continue;
      paramg = d.a(paramInputStream, 0.0F, paramInt1, paramInt2);
    }
  }
  
  public static boolean d(com.tencent.mm.loader.h.a.a parama)
  {
    return (parama == null) || (parama.Ud() == b.eQj) || (parama.Ud() == b.eQi) || (parama.Ud() == b.eQk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.l.a
 * JD-Core Version:    0.7.0.1
 */