package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class e
{
  private static Field Jj;
  private static boolean Jk;
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!Jk) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      Jj = localField;
      localField.setAccessible(true);
      label36:
      Jk = true;
      if (Jj != null) {
        try
        {
          paramCompoundButton = (Drawable)Jj.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Jj = null;
        }
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label36;
    }
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    while (!(paramCompoundButton instanceof r)) {
      return;
    }
    ((r)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintMode(paramMode);
    }
    while (!(paramCompoundButton instanceof r)) {
      return;
    }
    ((r)paramCompoundButton).setSupportButtonTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.e
 * JD-Core Version:    0.7.0.1
 */