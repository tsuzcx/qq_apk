package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import junit.framework.Assert;

public final class b
  implements b.h
{
  private int CD;
  private int CE;
  private int mHeight;
  private int mWidth;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134893);
    if (paramInt3 == 0)
    {
      bool1 = true;
      Assert.assertFalse(bool1);
      if (paramInt4 != 0) {
        break label71;
      }
    }
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertFalse(bool1);
      this.CD = paramInt1;
      this.CE = paramInt2;
      this.mWidth = paramInt3;
      this.mHeight = paramInt4;
      AppMethodBeat.o(134893);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final Bitmap H(Bitmap paramBitmap)
  {
    AppMethodBeat.i(134894);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(134894);
      return paramBitmap;
    }
    int n = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i = this.CD;
    int j = this.CE;
    label63:
    int i1;
    int k;
    if (this.CD < 0)
    {
      i = 0;
      if (this.CE >= 0) {
        break label164;
      }
      j = 0;
      int i2 = this.mWidth + this.CD - i;
      i1 = this.mHeight + this.CE - j;
      k = i2;
      if (i + i2 > n) {
        k = n - i;
      }
      if (j + i1 <= m) {
        break label243;
      }
      m -= j;
    }
    for (;;)
    {
      if ((k <= 0) || (m <= 0))
      {
        paramBitmap = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        AppMethodBeat.o(134894);
        return paramBitmap;
        if (this.CD <= n) {
          break;
        }
        i = n;
        break;
        label164:
        if (this.CE <= m) {
          break label63;
        }
        j = m;
        break label63;
      }
      Bitmap localBitmap = BitmapUtil.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(i, j, i + k, j + m), new Rect(0, 0, k, m), null);
      AppMethodBeat.o(134894);
      return localBitmap;
      label243:
      m = i1;
    }
  }
  
  public final String key()
  {
    AppMethodBeat.i(134895);
    String str = String.format("Transformation_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.CD), Integer.valueOf(this.CE), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(134895);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.b
 * JD-Core Version:    0.7.0.1
 */