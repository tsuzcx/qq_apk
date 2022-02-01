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
  private final ImageView rN;
  private aa rO;
  private aa rP;
  private aa ro;
  
  public h(ImageView paramImageView)
  {
    this.rN = paramImageView;
  }
  
  private boolean em()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.rO == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean g(Drawable paramDrawable)
  {
    AppMethodBeat.i(200079);
    if (this.ro == null) {
      this.ro = new aa();
    }
    aa localaa = this.ro;
    localaa.clear();
    Object localObject = e.a(this.rN);
    if (localObject != null)
    {
      localaa.kB = true;
      localaa.kz = ((ColorStateList)localObject);
    }
    localObject = e.b(this.rN);
    if (localObject != null)
    {
      localaa.kC = true;
      localaa.kA = ((PorterDuff.Mode)localObject);
    }
    if ((localaa.kB) || (localaa.kC))
    {
      f.a(paramDrawable, localaa, this.rN.getDrawableState());
      AppMethodBeat.o(200079);
      return true;
    }
    AppMethodBeat.o(200079);
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(200093);
    ac localac = ac.a(this.rN.getContext(), paramAttributeSet, a.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.rN.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localac.w(a.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.m(this.rN.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.rN.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        o.i(paramAttributeSet);
      }
      if (localac.az(a.j.AppCompatImageView_tint)) {
        e.a(this.rN, localac.getColorStateList(a.j.AppCompatImageView_tint));
      }
      if (localac.az(a.j.AppCompatImageView_tintMode)) {
        e.a(this.rN, o.c(localac.getInt(a.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localac.xv.recycle();
      AppMethodBeat.o(200093);
    }
  }
  
  final void eq()
  {
    AppMethodBeat.i(200152);
    Drawable localDrawable = this.rN.getDrawable();
    if (localDrawable != null) {
      o.i(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((em()) && (g(localDrawable)))
      {
        AppMethodBeat.o(200152);
        return;
      }
      if (this.rP != null)
      {
        f.a(localDrawable, this.rP, this.rN.getDrawableState());
        AppMethodBeat.o(200152);
        return;
      }
      if (this.rO != null) {
        f.a(localDrawable, this.rO, this.rN.getDrawableState());
      }
    }
    AppMethodBeat.o(200152);
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.rP != null) {
      return this.rP.kz;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.rP != null) {
      return this.rP.kA;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(200110);
    Drawable localDrawable = this.rN.getBackground();
    if ((Build.VERSION.SDK_INT >= 21) && ((localDrawable instanceof RippleDrawable)))
    {
      AppMethodBeat.o(200110);
      return false;
    }
    AppMethodBeat.o(200110);
    return true;
  }
  
  public final void setImageResource(int paramInt)
  {
    AppMethodBeat.i(200103);
    if (paramInt != 0)
    {
      Drawable localDrawable = a.m(this.rN.getContext(), paramInt);
      if (localDrawable != null) {
        o.i(localDrawable);
      }
      this.rN.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      eq();
      AppMethodBeat.o(200103);
      return;
      this.rN.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200118);
    if (this.rP == null) {
      this.rP = new aa();
    }
    this.rP.kz = paramColorStateList;
    this.rP.kB = true;
    eq();
    AppMethodBeat.o(200118);
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200134);
    if (this.rP == null) {
      this.rP = new aa();
    }
    this.rP.kA = paramMode;
    this.rP.kC = true;
    eq();
    AppMethodBeat.o(200134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.h
 * JD-Core Version:    0.7.0.1
 */