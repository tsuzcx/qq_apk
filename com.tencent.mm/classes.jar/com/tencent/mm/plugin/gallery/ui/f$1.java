package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  extends a.a
{
  int cKB = -1;
  
  f$1(f paramf) {}
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(21575);
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
    AppMethodBeat.o(21575);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(21574);
    if (paramv != null)
    {
      super.a(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(f.b(this.ngU), 2131034203);
      paramRecyclerView.setAnimationListener(new f.1.2(this));
      ((f.a)paramv).ngZ.startAnimation(paramRecyclerView);
    }
    AppMethodBeat.o(21574);
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(21572);
    int i = paramv1.jN();
    int j = paramv2.jN();
    this.ngU.ao(i, j);
    if (f.a(this.ngU) != null) {
      f.a(this.ngU).et(i, j);
    }
    f.a(this.ngU, j);
    AppMethodBeat.o(21572);
    return false;
  }
  
  public final void f(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(21573);
    super.f(paramv, paramInt);
    if (paramv != null)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(f.b(this.ngU), 2131034204);
      localAnimation.setAnimationListener(new f.1.1(this, paramInt, paramv));
      ((f.a)paramv).ngZ.startAnimation(localAnimation);
    }
    AppMethodBeat.o(21573);
  }
  
  public final boolean le()
  {
    return false;
  }
  
  public final float lf()
  {
    return 0.295858F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1
 * JD-Core Version:    0.7.0.1
 */