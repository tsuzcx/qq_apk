package com.tencent.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class b
  extends Drawable.ConstantState
{
  static final Paint a = new Paint();
  static final Paint b = new Paint();
  int c = 0;
  j d;
  boolean e;
  int[] f;
  
  static
  {
    a.setColor(-65536);
    a.setStrokeWidth(4.0F);
    b.setColor(1358888960);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.b
 * JD-Core Version:    0.7.0.1
 */