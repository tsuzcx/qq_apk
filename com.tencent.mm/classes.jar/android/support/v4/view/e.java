package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class e
{
  private static Field Fi;
  private static boolean Fj;
  static final b Fk = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Fk = new a();
      return;
    }
  }
  
  static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!Fj) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      Fi = localField;
      localField.setAccessible(true);
      Fj = true;
      if (Fi == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          Fi.set(paramLayoutInflater, paramFactory2);
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
    Fk.b(paramLayoutInflater, paramFactory2);
  }
  
  static final class a
    extends e.b
  {
    public final void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
    {
      paramLayoutInflater.setFactory2(paramFactory2);
    }
  }
  
  static class b
  {
    public void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
    {
      paramLayoutInflater.setFactory2(paramFactory2);
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        e.a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      e.a(paramLayoutInflater, paramFactory2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.e
 * JD-Core Version:    0.7.0.1
 */