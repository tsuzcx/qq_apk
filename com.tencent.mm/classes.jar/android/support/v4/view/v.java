package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class v
{
  public static int d(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramViewGroup.getLayoutMode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.view.v
 * JD-Core Version:    0.7.0.1
 */