package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static ColorStateList a(ImageView paramImageView)
  {
    AppMethodBeat.i(252515);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView = paramImageView.getImageTintList();
      AppMethodBeat.o(252515);
      return paramImageView;
    }
    if ((paramImageView instanceof k))
    {
      paramImageView = ((k)paramImageView).getSupportImageTintList();
      AppMethodBeat.o(252515);
      return paramImageView;
    }
    AppMethodBeat.o(252515);
    return null;
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(252519);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramColorStateList != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
        AppMethodBeat.o(252519);
      }
    }
    else if ((paramImageView instanceof k))
    {
      ((k)paramImageView).setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(252519);
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(252526);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramMode != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
        AppMethodBeat.o(252526);
      }
    }
    else if ((paramImageView instanceof k))
    {
      ((k)paramImageView).setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(252526);
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView)
  {
    AppMethodBeat.i(252523);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView = paramImageView.getImageTintMode();
      AppMethodBeat.o(252523);
      return paramImageView;
    }
    if ((paramImageView instanceof k))
    {
      paramImageView = ((k)paramImageView).getSupportImageTintMode();
      AppMethodBeat.o(252523);
      return paramImageView;
    }
    AppMethodBeat.o(252523);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.e
 * JD-Core Version:    0.7.0.1
 */