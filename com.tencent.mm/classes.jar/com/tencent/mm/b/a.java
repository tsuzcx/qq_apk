package com.tencent.mm.b;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends b
{
  private int bVq;
  c bVr;
  public float bVs;
  public float bVt;
  public float bVu;
  public Rect bVv;
  public RectF bVw;
  Matrix bVx;
  public long bVy;
  private ValueAnimator kO;
  public Animator.AnimatorListener nx;
  
  public a(c paramc)
  {
    AppMethodBeat.i(116138);
    this.bVq = 200;
    this.bVy = 0L;
    this.bVr = paramc;
    this.bVx = new Matrix();
    this.bVw = new RectF();
    AppMethodBeat.o(116138);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(116140);
    ab.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.bVD = false;
    this.bVC = true;
    if (this.kO != null) {
      this.kO.cancel();
    }
    AppMethodBeat.o(116140);
  }
  
  public final void play()
  {
    AppMethodBeat.i(116139);
    ab.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.bVC)
    {
      AppMethodBeat.o(116139);
      return;
    }
    this.bVD = false;
    this.bVC = false;
    this.kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.bVs }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.bVt }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.bVu }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.kO.addUpdateListener(new a.1(this));
    this.kO.addListener(new a.2(this));
    this.kO.setInterpolator(new LinearInterpolator());
    this.kO.setDuration(this.bVq);
    this.kO.setStartDelay(this.bVy);
    this.kO.start();
    AppMethodBeat.o(116139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.b.a
 * JD-Core Version:    0.7.0.1
 */