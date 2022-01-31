package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

final class an
{
  private static final aq ud = new ao();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      ud = new ap();
      return;
    }
  }
  
  static am c(ViewGroup paramViewGroup)
  {
    return ud.c(paramViewGroup);
  }
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    ud.c(paramViewGroup, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.an
 * JD-Core Version:    0.7.0.1
 */