package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class d
{
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
      return;
    }
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2);
  }
  
  public static int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
    }
    return 0xFF7FFFFF & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.d
 * JD-Core Version:    0.7.0.1
 */