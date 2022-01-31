package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;

final class n
{
  private static final int[] mZ = { 2130772206 };
  
  static void F(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(mZ);
    if (!paramContext.hasValue(0)) {
      i = 1;
    }
    paramContext.recycle();
    if (i != 0) {
      throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.n
 * JD-Core Version:    0.7.0.1
 */