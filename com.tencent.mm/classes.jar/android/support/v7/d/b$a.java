package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

public final class b$a
{
  public Rect RA;
  public final List<b.c> Rr;
  public final List<c> Rs = new ArrayList();
  public int Rx = 16;
  public int Ry = 12544;
  public int Rz = -1;
  public final Bitmap mBitmap;
  public final List<b.b> mFilters = new ArrayList();
  
  public b$a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("Bitmap is not valid");
    }
    this.mFilters.add(b.Rw);
    this.mBitmap = paramBitmap;
    this.Rr = null;
    this.Rs.add(c.RJ);
    this.Rs.add(c.RK);
    this.Rs.add(c.RL);
    this.Rs.add(c.RM);
    this.Rs.add(c.RN);
    this.Rs.add(c.RO);
  }
  
  public final int[] f(Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    if (this.RA == null) {
      return arrayOfInt;
    }
    k = this.RA.width();
    int m = this.RA.height();
    paramBitmap = new int[k * m];
    while (i < m)
    {
      System.arraycopy(arrayOfInt, (this.RA.top + i) * j + this.RA.left, paramBitmap, i * k, k);
      i += 1;
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.d.b.a
 * JD-Core Version:    0.7.0.1
 */