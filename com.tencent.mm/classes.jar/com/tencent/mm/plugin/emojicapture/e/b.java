package com.tencent.mm.plugin.emojicapture.e;

import a.d.b.g;
import a.k;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.d;
import java.util.ArrayList;

public final class b
  implements c.a
{
  public static final b.a jmx = new b.a((byte)0);
  private float apq;
  private float apr;
  private final Paint gaZ;
  private final Path jkG;
  private final f jml;
  private final RectF jmm;
  private final Rect jmn;
  private boolean jmo;
  private boolean jmp;
  private float jmq;
  private final float jmr;
  private final float jms;
  private final float jmt;
  private final Paint jmu;
  private final Path jmv;
  private final c.b jmw;
  
  public b(c.b paramb)
  {
    this.jmw = paramb;
    this.jml = new f();
    this.jmm = new RectF();
    this.jkG = new Path();
    this.jmn = new Rect();
    this.gaZ = new Paint();
    this.jmq = 1.0F;
    this.apq = 2.0F;
    this.apr = 0.25F;
    this.jmu = new Paint();
    this.jmv = new Path();
    paramb = this.jmw;
    if (paramb == null) {
      throw new k("null cannot be cast to non-null type android.view.View");
    }
    paramb = ((View)paramb).getContext();
    g.j(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.jml.apq = this.apq;
    this.jml.apr = this.apr;
    this.gaZ.setColor(-1);
    this.gaZ.setAntiAlias(true);
    this.gaZ.setStrokeWidth(paramb.getDimension(a.b.editor_item_frame_stroke));
    this.gaZ.setStyle(Paint.Style.FILL);
    this.jmr = paramb.getDimension(a.b.editor_item_frame_stroke);
    this.jms = paramb.getDimension(a.b.editor_item_frame_padding);
    this.jmt = paramb.getDimension(a.b.editor_item_frame_rect);
    this.jmu.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.jmu.setAntiAlias(true);
    this.jmu.setAlpha(127);
    this.jmv.setFillType(Path.FillType.INVERSE_EVEN_ODD);
  }
  
  public final boolean A(MotionEvent paramMotionEvent)
  {
    g.k(paramMotionEvent, "event");
    Object localObject1 = this.jmw.getItemContainer();
    Object localObject2 = this.jml;
    g.k(paramMotionEvent, "event");
    int i;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      i = 1;
      if (i != 0)
      {
        if (localObject1 != null)
        {
          localObject2 = (com.tencent.mm.plugin.emojicapture.ui.editor.a)this.jmw;
          g.k(localObject2, "itemView");
          g.k(paramMotionEvent, "event");
        }
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          switch (paramMotionEvent.getActionMasked())
          {
          }
          break;
        }
      }
      break;
    case 0: 
    case 5: 
    case 2: 
    case 6: 
    case 1: 
    case 3: 
      for (;;)
      {
        label79:
        paramMotionEvent = this.jmw;
        label144:
        if (paramMotionEvent != null) {
          break label1860;
        }
        throw new k("null cannot be cast to non-null type android.view.View");
        Object localObject3 = new float[2];
        Object localObject4 = new Matrix();
        ((f)localObject2).aqv.invert((Matrix)localObject4);
        ((Matrix)localObject4).mapPoints((float[])localObject3, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        if ((localObject3[0] < 0.0F) || (localObject3[0] > ((f)localObject2).width) || (localObject3[1] < 0.0F) || (localObject3[1] > ((f)localObject2).height))
        {
          i = 0;
          break label79;
        }
        ((f)localObject2).jng.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        ((f)localObject2).jnh.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        ((f)localObject2).B(paramMotionEvent);
        break;
        ((f)localObject2).jng.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        ((f)localObject2).jnh.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        ((f)localObject2).B(paramMotionEvent);
        break;
        ((f)localObject2).C(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 1) {
          ((f)localObject2).jnl = f.b.jnr;
        }
        localObject3 = ((f)localObject2).jnl;
        float f1;
        float f2;
        switch (g.fHS[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          localObject3 = ((f)localObject2).jnh.get(0);
          g.j(localObject3, "pIndices[0]");
          f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
          localObject3 = ((f)localObject2).jnh.get(0);
          g.j(localObject3, "pIndices[0]");
          f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
          ((f)localObject2).aqv.postTranslate(f1 - localObject2.jni[0], f2 - localObject2.jni[1]);
          ((f)localObject2).jni[0] = f1;
          ((f)localObject2).jni[1] = f2;
          break;
        case 2: 
          localObject3 = ((f)localObject2).aqv;
          localObject4 = ((f)localObject2).jnj;
          Object localObject5 = ((f)localObject2).jnh.get(0);
          g.j(localObject5, "pIndices[0]");
          f1 = paramMotionEvent.getX(((Number)localObject5).intValue());
          localObject5 = ((f)localObject2).jnh.get(0);
          g.j(localObject5, "pIndices[0]");
          f2 = paramMotionEvent.getY(((Number)localObject5).intValue());
          localObject5 = ((f)localObject2).jnh.get(1);
          g.j(localObject5, "pIndices[1]");
          float f3 = paramMotionEvent.getX(((Number)localObject5).intValue());
          localObject5 = ((f)localObject2).jnh.get(1);
          g.j(localObject5, "pIndices[1]");
          ((Matrix)localObject3).setPolyToPoly((float[])localObject4, 0, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject5).intValue()) }, 0, 2);
          if (g.e(((f)localObject2).jnm, f.a.jno))
          {
            localObject3 = new float[2];
            ((f)localObject2).aqv.mapPoints((float[])localObject3, new float[] { ((f)localObject2).width / 2.0F, ((f)localObject2).height / 2.0F });
            ((f)localObject2).aqv.postTranslate(localObject2.jnk[0] - localObject3[0], localObject2.jnk[1] - localObject3[1]);
          }
          localObject3 = new float[2];
          localObject4 = ((f)localObject2).jnh.get(0);
          g.j(localObject4, "pIndices[0]");
          f1 = paramMotionEvent.getX(((Number)localObject4).intValue());
          localObject4 = ((f)localObject2).jnh.get(1);
          g.j(localObject4, "pIndices[1]");
          localObject3[0] = ((paramMotionEvent.getX(((Number)localObject4).intValue()) + f1) / 2.0F);
          localObject4 = ((f)localObject2).jnh.get(0);
          g.j(localObject4, "pIndices[0]");
          f1 = paramMotionEvent.getY(((Number)localObject4).intValue());
          localObject4 = ((f)localObject2).jnh.get(1);
          g.j(localObject4, "pIndices[1]");
          localObject3[1] = ((paramMotionEvent.getY(((Number)localObject4).intValue()) + f1) / 2.0F);
          localObject4 = e.jnf;
          localObject4 = ((f)localObject2).aqv;
          f1 = ((f)localObject2).apr;
          f2 = ((f)localObject2).apq;
          g.k(localObject4, "matrix");
          g.k(localObject3, "pivotSrc");
          g.k(localObject4, "matrix");
          localObject2 = new float[9];
          ((Matrix)localObject4).getValues((float[])localObject2);
          double d1 = localObject2[0];
          double d2 = localObject2[3];
          f3 = (float)Math.sqrt(d2 * d2 + d1 * d1);
          if (f3 < f1) {}
          for (;;)
          {
            localObject5 = new Matrix();
            ((Matrix)localObject4).invert((Matrix)localObject5);
            localObject2 = new float[2];
            ((Matrix)localObject5).mapPoints((float[])localObject2, (float[])localObject3);
            localObject5 = new float[9];
            ((Matrix)localObject4).getValues((float[])localObject5);
            d1 = localObject5[0];
            d2 = localObject5[3];
            d3 = localObject5[4];
            Math.sqrt(d1 * d1 + d2 * d2);
            f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
            ((Matrix)localObject4).setTranslate(-localObject2[0], -localObject2[1]);
            ((Matrix)localObject4).postScale(f1, f1);
            ((Matrix)localObject4).postRotate(f2);
            ((Matrix)localObject4).postTranslate(localObject3[0], localObject3[1]);
            break;
            if (f3 <= f2) {
              break;
            }
            f1 = f2;
          }
          ((f)localObject2).C(paramMotionEvent);
          i = ((f)localObject2).jnh.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
          ((f)localObject2).jnh.remove(i);
          ((f)localObject2).jng.remove(i);
          ((f)localObject2).B(paramMotionEvent);
          break;
          ((f)localObject2).jnl = f.b.jnq;
          ((f)localObject2).jng.clear();
          ((f)localObject2).jnh.clear();
          break;
          ((EditorItemContainer)localObject1).removeCallbacks(((EditorItemContainer)localObject1).jpX);
          ((EditorItemContainer)localObject1).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)localObject2, true);
          break label144;
          ((EditorItemContainer)localObject1).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)localObject2, paramMotionEvent);
          ((EditorItemContainer)localObject1).fy(true);
          break label144;
          ((EditorItemContainer)localObject1).bringChildToFront((View)((EditorItemContainer)localObject1).getTextItem());
          if (((EditorItemContainer)localObject1).jpY != null) {
            ((EditorItemContainer)localObject1).post((Runnable)new EditorItemContainer.d((EditorItemContainer)localObject1));
          }
          for (;;)
          {
            ((EditorItemContainer)localObject1).fy(false);
            break;
            if (((EditorItemContainer)localObject1).jpW != null) {
              ((EditorItemContainer)localObject1).postDelayed(((EditorItemContainer)localObject1).jpX, 1500L);
            }
          }
          this.jmp = true;
          paramMotionEvent = this.jmw;
          if (paramMotionEvent == null) {
            throw new k("null cannot be cast to non-null type android.view.View");
          }
          ((View)paramMotionEvent).bringToFront();
          continue;
          this.jmp = false;
          continue;
          this.jmp = true;
          paramMotionEvent = new d();
          paramMotionEvent.apr = this.apr;
          paramMotionEvent.apq = this.apq;
          localObject1 = new float[2];
          localObject1[0] = (this.jmn.width() / 2.0F);
          localObject1[1] = (this.jmn.height() / 2.0F);
          g.k(localObject1, "<set-?>");
          paramMotionEvent.jmW = ((float[])localObject1);
          localObject1 = new RectF(this.jmm.left, this.jmm.top, this.jmm.right, this.jmm.bottom);
          g.k(localObject1, "<set-?>");
          paramMotionEvent.jmV = ((RectF)localObject1);
          localObject1 = this.jml.aqv;
          localObject2 = (a.d.a.a)new b.b(this);
          g.k(localObject1, "matrix");
          localObject3 = new float[2];
          ((Matrix)localObject1).mapPoints((float[])localObject3, paramMotionEvent.jmW);
          f1 = d.i(localObject3[0], paramMotionEvent.jmV.left, paramMotionEvent.jmV.right);
          f2 = d.i(localObject3[1], paramMotionEvent.jmV.top, paramMotionEvent.jmV.bottom);
          localObject4 = new float[9];
          ((Matrix)localObject1).getValues((float[])localObject4);
          d1 = localObject4[0];
          d2 = localObject4[3];
          double d3 = localObject4[4];
          f3 = (float)Math.sqrt(d1 * d1 + d2 * d2);
          float f4 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
          float f5 = d.i(f3, paramMotionEvent.apr, paramMotionEvent.apq);
          localObject4 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          g.j(localObject4, "animator");
          ((ValueAnimator)localObject4).setDuration(100L);
          ((ValueAnimator)localObject4).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d.a(paramMotionEvent, (Matrix)localObject1, f3, f5, f4, (float[])localObject3, new float[] { f1, f2 }, (a.d.a.a)localObject2));
          ((ValueAnimator)localObject4).start();
        }
      }
      label1860:
      ((View)paramMotionEvent).invalidate();
      return true;
    }
    return false;
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    g.k(paramRectF, "bounds");
    this.jmm.set(paramRectF);
    this.jkG.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.jmv.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    int i = Math.max(this.jmn.width(), this.jmn.height());
    this.jmq = (paramRectF.width() / i);
    paramFloat = this.jmq * 0.5F;
    this.apq = (this.jmq * 2.0F);
    this.apr = (this.jmq * 0.25F);
    this.jml.apq = this.apq;
    this.jml.apr = this.apr;
    this.jml.aqv.postTranslate(-this.jmn.width() / 2.0F, -this.jmn.height() / 2.0F);
    this.jml.aqv.postScale(paramFloat, paramFloat);
    this.jml.aqv.postTranslate((paramRectF.left + paramRectF.right) / 2.0F, (paramRectF.top + paramRectF.bottom) / 2.0F);
  }
  
  public final f aJW()
  {
    return this.jml;
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.jml.width = paramInt1;
    this.jml.height = paramInt2;
    this.jmn.right = paramInt1;
    this.jmn.bottom = paramInt2;
  }
  
  public final void h(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    if (this.jmp) {
      paramCanvas.clipPath(this.jkG);
    }
    paramCanvas.setMatrix(this.jml.aqv);
    if (this.jmo)
    {
      float f1 = this.jmn.left - this.jms / this.jmq;
      float f2 = this.jmn.top - this.jms / this.jmq;
      float f3 = this.jmn.right + this.jms / this.jmq;
      float f4 = this.jmn.bottom + this.jms / this.jmq;
      float f5 = this.jmt / 2.0F / this.jmq;
      this.gaZ.setStrokeWidth(this.jmr / this.jmq);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.gaZ);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.gaZ);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.gaZ);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.gaZ);
      Paint localPaint = this.gaZ;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
  }
  
  public final void i(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    paramCanvas.drawPath(this.jmv, this.jmu);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    this.jmo = paramBoolean;
    c.b localb = this.jmw;
    if (localb == null) {
      throw new k("null cannot be cast to non-null type android.view.View");
    }
    ((View)localb).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */