package com.tencent.mm.loader.l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.io.InputStream;

public final class a
{
  public static Bitmap a(g<?> paramg, InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if ((paramg != null) && (paramg.width > 0) && (paramg.width > 0)) {
        return BitmapUtil.getBitmapNative(paramInputStream, paramg.width, paramg.height);
      }
      return BitmapUtil.getBitmapNative(paramInputStream);
    }
    return BitmapUtil.decodeStream(paramInputStream, 0.0F, paramInt2, paramInt1);
  }
  
  @TargetApi(12)
  public static long bR(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bitmap)))
    {
      paramObject = (Bitmap)paramObject;
      if (Build.VERSION.SDK_INT >= 12) {
        return paramObject.getByteCount();
      }
      return paramObject.getRowBytes() * paramObject.getHeight();
    }
    return 0L;
  }
  
  public static boolean e(com.tencent.mm.loader.h.a.a parama)
  {
    return (parama == null) || (parama.aSt() == b.kQO) || (parama.aSt() == b.kQN) || (parama.aSt() == b.kQP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.l.a
 * JD-Core Version:    0.7.0.1
 */