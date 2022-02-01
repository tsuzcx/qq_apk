package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c
{
  private static Field bwq;
  private static boolean bwr;
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    AppMethodBeat.i(195344);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramCompoundButton = paramCompoundButton.getButtonDrawable();
      AppMethodBeat.o(195344);
      return paramCompoundButton;
    }
    if (!bwr) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      bwq = localField;
      localField.setAccessible(true);
      label48:
      bwr = true;
      if (bwq != null) {
        try
        {
          paramCompoundButton = (Drawable)bwq.get(paramCompoundButton);
          AppMethodBeat.o(195344);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          bwq = null;
        }
      }
      AppMethodBeat.o(195344);
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label48;
    }
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(195326);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
      AppMethodBeat.o(195326);
      return;
    }
    if ((paramCompoundButton instanceof k)) {
      ((k)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(195326);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(195336);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
      AppMethodBeat.o(195336);
      return;
    }
    if ((paramCompoundButton instanceof k)) {
      ((k)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(195336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.c
 * JD-Core Version:    0.7.0.1
 */