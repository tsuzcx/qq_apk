package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class w
{
  public static int b(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramViewGroup.getLayoutMode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.view.w
 * JD-Core Version:    0.7.0.1
 */