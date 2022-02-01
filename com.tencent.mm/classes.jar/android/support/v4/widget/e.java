package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class e
{
  private static Field Tf;
  private static boolean Tg;
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!Tg) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      Tf = localField;
      localField.setAccessible(true);
      label36:
      Tg = true;
      if (Tf != null) {
        try
        {
          paramCompoundButton = (Drawable)Tf.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Tf = null;
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