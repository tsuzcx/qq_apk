package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class f
{
  private static Field NQ;
  private static boolean NR;
  
  private static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!NR) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      NQ = localField;
      localField.setAccessible(true);
      NR = true;
      if (NQ == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          NQ.set(paramLayoutInflater, paramFactory2);
          return;
        }
        catch (IllegalAccessException paramFactory2)
        {
          new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(paramLayoutInflater).append("; inflation may have unexpected results.");
        }
        localNoSuchFieldException = localNoSuchFieldException;
        new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
      }
    }
  }
  
  public static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2)) {
        a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      }
    }
    else
    {
      return;
    }
    a(paramLayoutInflater, paramFactory2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.f
 * JD-Core Version:    0.7.0.1
 */