package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a.j;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

class d
{
  private final View mView;
  private final f qn;
  private int qo;
  private aa qp;
  private aa qr;
  private aa qs;
  
  d(View paramView)
  {
    AppMethodBeat.i(240666);
    this.qo = -1;
    this.mView = paramView;
    this.qn = f.dq();
    AppMethodBeat.o(240666);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240675);
    if (paramColorStateList != null)
    {
      if (this.qp == null) {
        this.qp = new aa();
      }
      this.qp.jE = paramColorStateList;
      this.qp.jG = true;
    }
    for (;;)
    {
      dm();
      AppMethodBeat.o(240675);
      return;
      this.qp = null;
    }
  }
  
  private boolean dn()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.qp == null) {}
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
    AppMethodBeat.i(240676);
    if (this.qs == null) {
      this.qs = new aa();
    }
    aa localaa = this.qs;
    localaa.clear();
    Object localObject = w.ac(this.mView);
    if (localObject != null)
    {
      localaa.jG = true;
      localaa.jE = ((ColorStateList)localObject);
    }
    localObject = w.ad(this.mView);
    if (localObject != null)
    {
      localaa.jH = true;
      localaa.jF = ((PorterDuff.Mode)localObject);
    }
    if ((localaa.jG) || (localaa.jH))
    {
      f.a(paramDrawable, localaa, this.mView.getDrawableState());
      AppMethodBeat.o(240676);
      return true;
    }
    AppMethodBeat.o(240676);
    return false;
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(240667);
    paramAttributeSet = ac.a(this.mView.getContext(), paramAttributeSet, a.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.aC(a.j.ViewBackgroundHelper_android_background))
      {
        this.qo = paramAttributeSet.r(a.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.qn.q(this.mView.getContext(), this.qo);
        if (localColorStateList != null) {
          a(localColorStateList);
        }
      }
      if (paramAttributeSet.aC(a.j.ViewBackgroundHelper_backgroundTint)) {
        w.a(this.mView, paramAttributeSet.getColorStateList(a.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.aC(a.j.ViewBackgroundHelper_backgroundTintMode)) {
        w.a(this.mView, o.c(paramAttributeSet.getInt(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.wA.recycle();
      AppMethodBeat.o(240667);
    }
  }
  
  final void ar(int paramInt)
  {
    AppMethodBeat.i(240669);
    this.qo = paramInt;
    if (this.qn != null) {}
    for (ColorStateList localColorStateList = this.qn.q(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      a(localColorStateList);
      dm();
      AppMethodBeat.o(240669);
      return;
    }
  }
  
  final void dl()
  {
    AppMethodBeat.i(240670);
    this.qo = -1;
    a(null);
    dm();
    AppMethodBeat.o(240670);
  }
  
  final void dm()
  {
    AppMethodBeat.i(240674);
    Drawable localDrawable = this.mView.getBackground();
    if (localDrawable != null)
    {
      if ((dn()) && (f(localDrawable)))
      {
        AppMethodBeat.o(240674);
        return;
      }
      if (this.qr != null)
      {
        f.a(localDrawable, this.qr, this.mView.getDrawableState());
        AppMethodBeat.o(240674);
        return;
      }
      if (this.qp != null) {
        f.a(localDrawable, this.qp, this.mView.getDrawableState());
      }
    }
    AppMethodBeat.o(240674);
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.qr != null) {
      return this.qr.jE;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.qr != null) {
      return this.qr.jF;
    }
    return null;
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240671);
    if (this.qr == null) {
      this.qr = new aa();
    }
    this.qr.jE = paramColorStateList;
    this.qr.jG = true;
    dm();
    AppMethodBeat.o(240671);
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240672);
    if (this.qr == null) {
      this.qr = new aa();
    }
    this.qr.jF = paramMode;
    this.qr.jH = true;
    dm();
    AppMethodBeat.o(240672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.d
 * JD-Core Version:    0.7.0.1
 */