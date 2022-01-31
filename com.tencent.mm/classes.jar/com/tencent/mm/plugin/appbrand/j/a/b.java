package com.tencent.mm.plugin.appbrand.j.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.c;
import junit.framework.Assert;

public final class b
  implements b.f
{
  private int gMN;
  private int gMO;
  private int mHeight;
  private int mWidth;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 == 0)
    {
      bool1 = true;
      Assert.assertFalse(bool1);
      if (paramInt4 != 0) {
        break label61;
      }
    }
    label61:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertFalse(bool1);
      this.gMN = paramInt1;
      this.gMO = paramInt2;
      this.mWidth = paramInt3;
      this.mHeight = paramInt4;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final String pU()
  {
    return String.format("Transformation_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.gMN), Integer.valueOf(this.gMO), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
  }
  
  public final Bitmap q(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return paramBitmap;
    }
    int n = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i = this.gMN;
    int j = this.gMO;
    label53:
    int i1;
    int k;
    if (this.gMN < 0)
    {
      i = 0;
      if (this.gMO >= 0) {
        break label147;
      }
      j = 0;
      int i2 = this.mWidth + this.gMN - i;
      i1 = this.mHeight + this.gMO - j;
      k = i2;
      if (i + i2 > n) {
        k = n - i;
      }
      if (j + i1 <= m) {
        break label221;
      }
      m -= j;
    }
    for (;;)
    {
      if ((k <= 0) || (m <= 0))
      {
        return c.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (this.gMN <= n) {
          break;
        }
        i = n;
        break;
        label147:
        if (this.gMO <= m) {
          break label53;
        }
        j = m;
        break label53;
      }
      Bitmap localBitmap = c.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(i, j, i + k, j + m), new Rect(0, 0, k, m), null);
      return localBitmap;
      label221:
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.b
 * JD-Core Version:    0.7.0.1
 */