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
    AppMethodBeat.i(195362);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView = paramImageView.getImageTintList();
      AppMethodBeat.o(195362);
      return paramImageView;
    }
    if ((paramImageView instanceof l))
    {
      paramImageView = ((l)paramImageView).getSupportImageTintList();
      AppMethodBeat.o(195362);
      return paramImageView;
    }
    AppMethodBeat.o(195362);
    return null;
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(195370);
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
        AppMethodBeat.o(195370);
      }
    }
    else if ((paramImageView instanceof l))
    {
      ((l)paramImageView).setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(195370);
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(195385);
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
        AppMethodBeat.o(195385);
      }
    }
    else if ((paramImageView instanceof l))
    {
      ((l)paramImageView).setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(195385);
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView)
  {
    AppMethodBeat.i(195375);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView = paramImageView.getImageTintMode();
      AppMethodBeat.o(195375);
      return paramImageView;
    }
    if ((paramImageView instanceof l))
    {
      paramImageView = ((l)paramImageView).getSupportImageTintMode();
      AppMethodBeat.o(195375);
      return paramImageView;
    }
    AppMethodBeat.o(195375);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.e
 * JD-Core Version:    0.7.0.1
 */