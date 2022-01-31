package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a.a;

final class o
{
  private static final int[] mc = { a.a.colorPrimary };
  
  static void G(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(mc);
    if (!paramContext.hasValue(0)) {
      i = 1;
    }
    paramContext.recycle();
    if (i != 0) {
      throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */