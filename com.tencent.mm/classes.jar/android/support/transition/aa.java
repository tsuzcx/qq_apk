package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

final class aa
{
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      ac.c(paramViewGroup, paramBoolean);
      return;
    }
    ab.c(paramViewGroup, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.aa
 * JD-Core Version:    0.7.0.1
 */