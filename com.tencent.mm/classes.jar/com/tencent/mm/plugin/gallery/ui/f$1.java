package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;

final class f$1
  extends a.a
{
  int cbV = -1;
  
  f$1(f paramf) {}
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    if (paramv != null)
    {
      super.a(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(f.b(this.kKu), R.a.move_scale_in);
      paramRecyclerView.setAnimationListener(new f.1.2(this));
      ((f.a)paramv).kKz.startAnimation(paramRecyclerView);
    }
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    int i = paramv1.id();
    int j = paramv2.id();
    this.kKu.ai(i, j);
    if (f.a(this.kKu) != null) {
      f.a(this.kKu).cW(i, j);
    }
    f.a(this.kKu, j);
    return false;
  }
  
  public final void f(RecyclerView.v paramv, int paramInt)
  {
    super.f(paramv, paramInt);
    if (paramv != null)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(f.b(this.kKu), R.a.move_scale_out);
      localAnimation.setAnimationListener(new f.1.1(this, paramInt, paramv));
      ((f.a)paramv).kKz.startAnimation(localAnimation);
    }
  }
  
  public final int jj()
  {
    return 3342387;
  }
  
  public final boolean jl()
  {
    return true;
  }
  
  public final boolean jm()
  {
    return false;
  }
  
  public final float jp()
  {
    return 0.295858F;
  }
  
  public final void jq() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1
 * JD-Core Version:    0.7.0.1
 */