package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

final class ab
{
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      ad.c(paramViewGroup, paramBoolean);
      return;
    }
    ac.c(paramViewGroup, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ab
 * JD-Core Version:    0.7.0.1
 */