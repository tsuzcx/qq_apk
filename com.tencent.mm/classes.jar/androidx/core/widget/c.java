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
  private static Field PY;
  private static boolean PZ;
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    AppMethodBeat.i(252357);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramCompoundButton = paramCompoundButton.getButtonDrawable();
      AppMethodBeat.o(252357);
      return paramCompoundButton;
    }
    if (!PZ) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      PY = localField;
      localField.setAccessible(true);
      label48:
      PZ = true;
      if (PY != null) {
        try
        {
          paramCompoundButton = (Drawable)PY.get(paramCompoundButton);
          AppMethodBeat.o(252357);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          PY = null;
        }
      }
      AppMethodBeat.o(252357);
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label48;
    }
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(252355);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
      AppMethodBeat.o(252355);
      return;
    }
    if ((paramCompoundButton instanceof j)) {
      ((j)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(252355);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(252356);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
      AppMethodBeat.o(252356);
      return;
    }
    if ((paramCompoundButton instanceof j)) {
      ((j)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(252356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.c
 * JD-Core Version:    0.7.0.1
 */