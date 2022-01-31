package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.os.a;
import android.widget.TextView;
import java.lang.reflect.Field;

public final class o
{
  static final g MD = new g();
  
  static
  {
    if (a.cS())
    {
      MD = new o.f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      MD = new o.e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      MD = new o.d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      MD = new o.c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      MD = new o.b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      MD = new a();
      return;
    }
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    MD.a(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static int b(TextView paramTextView)
  {
    return MD.b(paramTextView);
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    MD.b(paramTextView, paramInt);
  }
  
  public static Drawable[] c(TextView paramTextView)
  {
    return MD.c(paramTextView);
  }
  
  static class a
    extends o.g
  {
    public final int b(TextView paramTextView)
    {
      return paramTextView.getMaxLines();
    }
  }
  
  static class g
  {
    private static Field ME;
    private static boolean MF;
    private static Field MG;
    private static boolean MH;
    
    private static Field M(String paramString)
    {
      Object localObject = null;
      try
      {
        Field localField = TextView.class.getDeclaredField(paramString);
        localObject = localField;
        localField.setAccessible(true);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        new StringBuilder("Could not retrieve ").append(paramString).append(" field.");
      }
      return localObject;
    }
    
    private static int a(Field paramField, TextView paramTextView)
    {
      try
      {
        int i = paramField.getInt(paramTextView);
        return i;
      }
      catch (IllegalAccessException paramTextView)
      {
        new StringBuilder("Could not retrieve value of ").append(paramField.getName()).append(" field.");
      }
      return -1;
    }
    
    public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
    
    public int b(TextView paramTextView)
    {
      if (!MH)
      {
        MG = M("mMaxMode");
        MH = true;
      }
      if ((MG != null) && (a(MG, paramTextView) == 1))
      {
        if (!MF)
        {
          ME = M("mMaximum");
          MF = true;
        }
        if (ME != null) {
          return a(ME, paramTextView);
        }
      }
      return -1;
    }
    
    public void b(TextView paramTextView, int paramInt)
    {
      paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    }
    
    public Drawable[] c(TextView paramTextView)
    {
      return paramTextView.getCompoundDrawables();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.o
 * JD-Core Version:    0.7.0.1
 */