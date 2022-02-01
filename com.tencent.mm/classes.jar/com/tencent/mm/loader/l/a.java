package com.tencent.mm.loader.l;

import android.graphics.Bitmap;
import com.tencent.mm.loader.h.a.b;
import java.io.InputStream;

public final class a
{
  public static Bitmap a(com.tencent.mm.loader.e.b.g<?> paramg, InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if ((paramg != null) && (paramg.width > 0) && (paramg.width > 0)) {
        return com.tencent.mm.sdk.platformtools.g.b(paramInputStream, paramg.width, paramg.height);
      }
      return com.tencent.mm.sdk.platformtools.g.R(paramInputStream);
    }
    return com.tencent.mm.sdk.platformtools.g.a(paramInputStream, 0.0F, paramInt2, paramInt1);
  }
  
  public static boolean d(com.tencent.mm.loader.h.a.a parama)
  {
    return (parama == null) || (parama.arD() == b.hgw) || (parama.arD() == b.hgv) || (parama.arD() == b.hgx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.l.a
 * JD-Core Version:    0.7.0.1
 */