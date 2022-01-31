package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

final class ao
{
  private static final ar tb = new ap();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      tb = new aq();
      return;
    }
  }
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    tb.c(paramViewGroup, paramBoolean);
  }
  
  static an d(ViewGroup paramViewGroup)
  {
    return tb.d(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ao
 * JD-Core Version:    0.7.0.1
 */