package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class e
{
  private static final c JC = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      JC = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      JC = new a();
      return;
    }
  }
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    return JC.a(paramCompoundButton);
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    JC.a(paramCompoundButton, paramColorStateList);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    JC.a(paramCompoundButton, paramMode);
  }
  
  static class a
    extends e.c
  {
    public final void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    
    public final void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
    }
  }
  
  static final class b
    extends e.a
  {
    public final Drawable a(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonDrawable();
    }
  }
  
  static class c
  {
    private static Field JD;
    private static boolean JE;
    
    public Drawable a(CompoundButton paramCompoundButton)
    {
      if (!JE) {}
      try
      {
        Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
        JD = localField;
        localField.setAccessible(true);
        label23:
        JE = true;
        if (JD != null) {
          try
          {
            paramCompoundButton = (Drawable)JD.get(paramCompoundButton);
            return paramCompoundButton;
          }
          catch (IllegalAccessException paramCompoundButton)
          {
            JD = null;
          }
        }
        return null;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      if ((paramCompoundButton instanceof p)) {
        ((p)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
      }
    }
    
    public void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      if ((paramCompoundButton instanceof p)) {
        ((p)paramCompoundButton).setSupportButtonTintMode(paramMode);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.e
 * JD-Core Version:    0.7.0.1
 */