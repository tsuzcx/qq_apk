package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.a.a.a;
import android.view.ViewGroup;

public final class s
{
  static final c Gq = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Gq = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Gq = new a();
      return;
    }
  }
  
  public static boolean f(ViewGroup paramViewGroup)
  {
    return Gq.f(paramViewGroup);
  }
  
  static class a
    extends s.c
  {}
  
  static final class b
    extends s.a
  {
    public final boolean f(ViewGroup paramViewGroup)
    {
      return paramViewGroup.isTransitionGroup();
    }
  }
  
  static class c
  {
    public boolean f(ViewGroup paramViewGroup)
    {
      Boolean localBoolean = (Boolean)paramViewGroup.getTag(a.a.tag_transition_group);
      return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (q.ab(paramViewGroup) != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.s
 * JD-Core Version:    0.7.0.1
 */