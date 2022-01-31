package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

public final class b$a
{
  public final List<b.c> RK;
  public final List<c> RL = new ArrayList();
  public int RQ = 16;
  public int RR = 12544;
  public int RS = -1;
  public Rect RT;
  public final Bitmap mBitmap;
  public final List<b.b> mFilters = new ArrayList();
  
  public b$a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("Bitmap is not valid");
    }
    this.mFilters.add(b.RP);
    this.mBitmap = paramBitmap;
    this.RK = null;
    this.RL.add(c.Sc);
    this.RL.add(c.Sd);
    this.RL.add(c.Se);
    this.RL.add(c.Sf);
    this.RL.add(c.Sg);
    this.RL.add(c.Sh);
  }
  
  public final int[] e(Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    if (this.RT == null) {
      return arrayOfInt;
    }
    k = this.RT.width();
    int m = this.RT.height();
    paramBitmap = new int[k * m];
    while (i < m)
    {
      System.arraycopy(arrayOfInt, (this.RT.top + i) * j + this.RT.left, paramBitmap, i * k, k);
      i += 1;
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.d.b.a
 * JD-Core Version:    0.7.0.1
 */