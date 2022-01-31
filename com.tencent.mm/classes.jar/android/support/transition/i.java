package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

final class i
  implements j
{
  static Class<?> rR;
  private static boolean rS;
  static Method rT;
  static boolean rU;
  static Method rV;
  static boolean rW;
  private final View rX;
  
  private i(View paramView)
  {
    this.rX = paramView;
  }
  
  static void ck()
  {
    if (!rS) {}
    try
    {
      rR = Class.forName("android.view.GhostView");
      label14:
      rS = true;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label14;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView) {}
  
  public final void setVisibility(int paramInt)
  {
    this.rX.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.i
 * JD-Core Version:    0.7.0.1
 */