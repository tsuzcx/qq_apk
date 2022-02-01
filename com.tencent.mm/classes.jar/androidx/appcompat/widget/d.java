package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a.j;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

class d
{
  private final View mView;
  private final f rk;
  private int rl;
  private aa rm;
  private aa rn;
  private aa ro;
  
  d(View paramView)
  {
    AppMethodBeat.i(200005);
    this.rl = -1;
    this.mView = paramView;
    this.rk = f.ep();
    AppMethodBeat.o(200005);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200013);
    if (paramColorStateList != null)
    {
      if (this.rm == null) {
        this.rm = new aa();
      }
      this.rm.kz = paramColorStateList;
      this.rm.kB = true;
    }
    for (;;)
    {
      el();
      AppMethodBeat.o(200013);
      return;
      this.rm = null;
    }
  }
  
  private boolean em()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.rm == null) {}
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
    AppMethodBeat.i(200032);
    if (this.ro == null) {
      this.ro = new aa();
    }
    aa localaa = this.ro;
    localaa.clear();
    Object localObject = z.ap(this.mView);
    if (localObject != null)
    {
      localaa.kB = true;
      localaa.kz = ((ColorStateList)localObject);
    }
    localObject = z.aq(this.mView);
    if (localObject != null)
    {
      localaa.kC = true;
      localaa.kA = ((PorterDuff.Mode)localObject);
    }
    if ((localaa.kB) || (localaa.kC))
    {
      f.a(paramDrawable, localaa, this.mView.getDrawableState());
      AppMethodBeat.o(200032);
      return true;
    }
    AppMethodBeat.o(200032);
    return false;
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(200043);
    paramAttributeSet = ac.a(this.mView.getContext(), paramAttributeSet, a.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.az(a.j.ViewBackgroundHelper_android_background))
      {
        this.rl = paramAttributeSet.w(a.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.rk.q(this.mView.getContext(), this.rl);
        if (localColorStateList != null) {
          a(localColorStateList);
        }
      }
      if (paramAttributeSet.az(a.j.ViewBackgroundHelper_backgroundTint)) {
        z.a(this.mView, paramAttributeSet.getColorStateList(a.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.az(a.j.ViewBackgroundHelper_backgroundTintMode)) {
        z.a(this.mView, o.c(paramAttributeSet.getInt(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.xv.recycle();
      AppMethodBeat.o(200043);
    }
  }
  
  final void ap(int paramInt)
  {
    AppMethodBeat.i(200054);
    this.rl = paramInt;
    if (this.rk != null) {}
    for (ColorStateList localColorStateList = this.rk.q(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      a(localColorStateList);
      el();
      AppMethodBeat.o(200054);
      return;
    }
  }
  
  final void ek()
  {
    AppMethodBeat.i(200061);
    this.rl = -1;
    a(null);
    el();
    AppMethodBeat.o(200061);
  }
  
  final void el()
  {
    AppMethodBeat.i(200108);
    Drawable localDrawable = this.mView.getBackground();
    if (localDrawable != null)
    {
      if ((em()) && (g(localDrawable)))
      {
        AppMethodBeat.o(200108);
        return;
      }
      if (this.rn != null)
      {
        f.a(localDrawable, this.rn, this.mView.getDrawableState());
        AppMethodBeat.o(200108);
        return;
      }
      if (this.rm != null) {
        f.a(localDrawable, this.rm, this.mView.getDrawableState());
      }
    }
    AppMethodBeat.o(200108);
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.rn != null) {
      return this.rn.kz;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.rn != null) {
      return this.rn.kA;
    }
    return null;
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200071);
    if (this.rn == null) {
      this.rn = new aa();
    }
    this.rn.kz = paramColorStateList;
    this.rn.kB = true;
    el();
    AppMethodBeat.o(200071);
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200089);
    if (this.rn == null) {
      this.rn = new aa();
    }
    this.rn.kA = paramMode;
    this.rn.kC = true;
    el();
    AppMethodBeat.o(200089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.d
 * JD-Core Version:    0.7.0.1
 */