package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a.j;
import androidx.appcompat.a.a.a;
import androidx.core.widget.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private final ImageView qQ;
  private aa qR;
  private aa qS;
  private aa qs;
  
  public h(ImageView paramImageView)
  {
    this.qQ = paramImageView;
  }
  
  private boolean dn()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.qR == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean f(Drawable paramDrawable)
  {
    AppMethodBeat.i(240869);
    if (this.qs == null) {
      this.qs = new aa();
    }
    aa localaa = this.qs;
    localaa.clear();
    Object localObject = e.a(this.qQ);
    if (localObject != null)
    {
      localaa.jG = true;
      localaa.jE = ((ColorStateList)localObject);
    }
    localObject = e.b(this.qQ);
    if (localObject != null)
    {
      localaa.jH = true;
      localaa.jF = ((PorterDuff.Mode)localObject);
    }
    if ((localaa.jG) || (localaa.jH))
    {
      f.a(paramDrawable, localaa, this.qQ.getDrawableState());
      AppMethodBeat.o(240869);
      return true;
    }
    AppMethodBeat.o(240869);
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(240862);
    ac localac = ac.a(this.qQ.getContext(), paramAttributeSet, a.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.qQ.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localac.r(a.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.m(this.qQ.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.qQ.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        o.h(paramAttributeSet);
      }
      if (localac.aC(a.j.AppCompatImageView_tint)) {
        e.a(this.qQ, localac.getColorStateList(a.j.AppCompatImageView_tint));
      }
      if (localac.aC(a.j.AppCompatImageView_tintMode)) {
        e.a(this.qQ, o.c(localac.getInt(a.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localac.wA.recycle();
      AppMethodBeat.o(240862);
    }
  }
  
  final void dr()
  {
    AppMethodBeat.i(240868);
    Drawable localDrawable = this.qQ.getDrawable();
    if (localDrawable != null) {
      o.h(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((dn()) && (f(localDrawable)))
      {
        AppMethodBeat.o(240868);
        return;
      }
      if (this.qS != null)
      {
        f.a(localDrawable, this.qS, this.qQ.getDrawableState());
        AppMethodBeat.o(240868);
        return;
      }
      if (this.qR != null) {
        f.a(localDrawable, this.qR, this.qQ.getDrawableState());
      }
    }
    AppMethodBeat.o(240868);
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.qS != null) {
      return this.qS.jE;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.qS != null) {
      return this.qS.jF;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(240865);
    Drawable localDrawable = this.qQ.getBackground();
    if ((Build.VERSION.SDK_INT >= 21) && ((localDrawable instanceof RippleDrawable)))
    {
      AppMethodBeat.o(240865);
      return false;
    }
    AppMethodBeat.o(240865);
    return true;
  }
  
  public final void setImageResource(int paramInt)
  {
    AppMethodBeat.i(240864);
    if (paramInt != 0)
    {
      Drawable localDrawable = a.m(this.qQ.getContext(), paramInt);
      if (localDrawable != null) {
        o.h(localDrawable);
      }
      this.qQ.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      dr();
      AppMethodBeat.o(240864);
      return;
      this.qQ.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240866);
    if (this.qS == null) {
      this.qS = new aa();
    }
    this.qS.jE = paramColorStateList;
    this.qS.jG = true;
    dr();
    AppMethodBeat.o(240866);
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240867);
    if (this.qS == null) {
      this.qS = new aa();
    }
    this.qS.jF = paramMode;
    this.qS.jH = true;
    dr();
    AppMethodBeat.o(240867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.h
 * JD-Core Version:    0.7.0.1
 */