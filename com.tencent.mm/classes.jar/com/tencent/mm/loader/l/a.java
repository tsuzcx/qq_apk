package com.tencent.mm.loader.l;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.a.b;
import com.tencent.mm.sdk.platformtools.h;
import java.io.InputStream;

public final class a
{
  public static Bitmap a(g<?> paramg, InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if ((paramg != null) && (paramg.width > 0) && (paramg.width > 0)) {
        return h.b(paramInputStream, paramg.width, paramg.height);
      }
      return h.R(paramInputStream);
    }
    return h.a(paramInputStream, 0.0F, paramInt2, paramInt1);
  }
  
  public static boolean d(com.tencent.mm.loader.h.a.a parama)
  {
    return (parama == null) || (parama.arS() == b.hjk) || (parama.arS() == b.hjj) || (parama.arS() == b.hjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.l.a
 * JD-Core Version:    0.7.0.1
 */