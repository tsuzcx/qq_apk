package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int aia;
  private int aib;
  private float buF;
  private int count = 0;
  private int gHR;
  private int gHS;
  private MultiTouchImageView kKO;
  private long kKP = 0L;
  private long kKQ = 0L;
  private float kKR = 0.0F;
  private float kKS = 0.0F;
  private long kKT = 0L;
  private boolean kKU = false;
  private OverScroller kKV;
  private GestureDetector kKW;
  private RectF kKX = new RectF();
  private MultiGestureImageView.a kKY;
  private float kKZ;
  private boolean kLa = false;
  private boolean kLb = false;
  private boolean kLc = false;
  private boolean kLd = false;
  private MultiGestureImageView.j kLe;
  private MultiGestureImageView.j kLf;
  private MultiGestureImageView.j kLg;
  private MultiGestureImageView.d kLh;
  private MultiGestureImageView.b kLi;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void aXW()
  {
    this.kLe.removeMessages(1);
  }
  
  private void aXX()
  {
    aXW();
    this.kLe.h(1, 15L, 15L);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.kKO = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.kKW = new GestureDetector(paramContext, new MultiGestureImageView.c(this, (byte)0));
    this.kKV = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.kKO.setLayoutParams(paramContext);
    addView(this.kKO);
    this.kLe = new MultiGestureImageView.j(this, new WeakReference(this));
    this.kLf = new MultiGestureImageView.j(this, new WeakReference(this));
    this.kLg = new MultiGestureImageView.j(this, new WeakReference(this));
  }
  
  public void computeScroll()
  {
    int m = 0;
    if (this.kKO == null) {}
    while (!this.kKV.computeScrollOffset()) {
      return;
    }
    int i = this.kKV.getCurrX() - this.aia;
    int n = this.kKV.getCurrY() - this.aib;
    this.aia = this.kKV.getCurrX();
    this.aib = this.kKV.getCurrY();
    float f3 = this.kKO.getScale();
    float f4 = this.kKO.getImageWidth();
    float f1 = f3 * this.kKO.getImageHeight();
    float[] arrayOfFloat = new float[9];
    this.kKO.getImageMatrix().getValues(arrayOfFloat);
    float f2 = arrayOfFloat[2];
    f3 = f4 * f3 + f2;
    f4 = arrayOfFloat[5];
    float f5 = f4 + f1;
    int j = i;
    if (i < 0)
    {
      j = i;
      if (i < this.kKX.right - Math.round(f3)) {
        j = (int)(this.kKX.right - Math.round(f3));
      }
    }
    i = j;
    if (j > 0)
    {
      i = j;
      if (j > this.kKX.left - Math.round(f2)) {
        i = (int)(this.kKX.left - Math.round(f2));
      }
    }
    int k = n;
    if (n < 0)
    {
      k = n;
      if (n < this.kKX.bottom - Math.round(f5)) {
        k = (int)(this.kKX.bottom - Math.round(f5));
      }
    }
    j = k;
    if (k > 0)
    {
      j = k;
      if (k > this.kKX.top - Math.round(f4)) {
        j = (int)(this.kKX.top - Math.round(f4));
      }
    }
    if ((Math.round(f2) >= this.kKX.left) || (Math.round(f3) <= this.kKX.right))
    {
      k = 0;
      if (f1 >= this.gHS) {
        break label457;
      }
    }
    label457:
    for (i = m;; i = j)
    {
      this.kKO.ae(k, i);
      postInvalidate();
      return;
      if (Math.round(f4) < this.kKX.top)
      {
        k = i;
        if (Math.round(f5) > this.kKX.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public int getImageHeight()
  {
    return this.kKO.getImageHeight();
  }
  
  public int getImageWidth()
  {
    return this.kKO.getImageWidth();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.gHR = View.MeasureSpec.getSize(paramInt1);
    this.gHS = View.MeasureSpec.getSize(paramInt2);
    this.kKX.set(0.0F, 0.0F, this.gHR, this.gHS);
    y.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.gHR + " height:" + this.gHS);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.kKW.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.kKV.forceFinished(true);
      this.kLg.removeMessages(2);
      this.kLg.h(2, 500L, 0L);
      this.kKO.cAz();
      this.count += 1;
      if (this.count == 1)
      {
        this.kKP = System.currentTimeMillis();
        this.kKR = f.c(paramMotionEvent, 0);
        this.kKS = f.d(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.kLg.removeMessages(2);
        this.buF = 0.0F;
        this.kKZ = this.kKO.getScale();
        this.kKU = true;
        float f4;
        if (this.kKZ < this.kKO.getScaleRate())
        {
          f1 = f.c(paramMotionEvent, 0);
          f2 = f.c(paramMotionEvent, 1);
          f3 = f.d(paramMotionEvent, 0);
          f4 = f.d(paramMotionEvent, 1);
          this.kKO.ac(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
        }
        if (this.kKZ > this.kKO.getDoubleTabScale())
        {
          f1 = f.c(paramMotionEvent, 0);
          f2 = f.c(paramMotionEvent, 1);
          f3 = f.d(paramMotionEvent, 0);
          f4 = f.d(paramMotionEvent, 1);
          this.kKO.ad(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.kLg.removeMessages(2);
        if (((!this.kLc) && (!this.kLd)) || ((!this.kLa) && (!this.kLb))) {
          break label765;
        }
        this.kKY = new MultiGestureImageView.f(this, this.kKO);
        aXX();
        this.kLc = false;
        this.kLd = false;
        this.kLa = false;
        this.kLb = false;
        label362:
        this.buF = 0.0F;
        this.kKZ = this.kKO.getScale();
        if (this.count == 1)
        {
          this.kKQ = System.currentTimeMillis();
          if (this.kKQ - this.kKP >= 350L) {
            break label896;
          }
          if ((Math.abs(this.kKR - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.kKS - f.d(paramMotionEvent, 0)) < 10.0F))
          {
            MultiGestureImageView.j localj = this.kLf;
            localj.cbg = false;
            localj.h(0, 350L, 0L);
          }
        }
      }
      label471:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.buF = 0.0F;
        this.kKZ = this.kKO.getScale();
        this.kKU = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.J(paramMotionEvent) != 2) {
          break label959;
        }
        this.kLg.removeMessages(2);
        this.kKU = true;
        this.count = 0;
        f1 = f.c(paramMotionEvent, 0) - f.c(paramMotionEvent, 1);
        f2 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.buF != 0.0F) {
          break label913;
        }
        this.buF = f3;
      }
    }
    label765:
    while ((Math.abs(this.kKR - f.c(paramMotionEvent, 0)) <= 10.0F) && (Math.abs(this.kKS - f.d(paramMotionEvent, 0)) <= 10.0F))
    {
      do
      {
        return true;
        if (this.count != 2) {
          break;
        }
        this.kKT = System.currentTimeMillis();
        if (this.kKT - this.kKQ < 350L)
        {
          if ((Math.abs(this.kKR - f.c(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.kKS - f.d(paramMotionEvent, 0)) < 35.0F))
          {
            this.count = 0;
            y.d("MicroMsg.MuitlGestureImageView", "double click!");
            if (this.kKO.getScale() <= this.kKO.getScaleRate())
            {
              this.kKO.ad(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
              break;
            }
            this.kKO.ac(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
            this.kKO.cBl();
            break;
          }
          this.count = 1;
          break;
        }
        this.count = 1;
        break;
        if (this.kLc)
        {
          this.kLc = false;
          this.kKY = new MultiGestureImageView.g(this, this.kKO);
          aXX();
        }
        if (this.kLd)
        {
          this.kLd = false;
          this.kKY = new MultiGestureImageView.h(this, this.kKO);
          aXX();
        }
        if (this.kLa)
        {
          this.kLa = false;
          this.kKY = new MultiGestureImageView.i(this, this.kKO);
          aXX();
        }
        if (!this.kLb) {
          break label362;
        }
        this.kLb = false;
        this.kKY = new MultiGestureImageView.e(this, this.kKO);
        aXX();
        break label362;
        this.count = 0;
        y.d("MicroMsg.MuitlGestureImageView", "single long click over!");
        break label471;
        f3 /= this.buF;
      } while (!this.kKU);
      this.kKO.k(f3 * this.kKZ, f1 + f.c(paramMotionEvent, 1), f2 + f.d(paramMotionEvent, 1));
      return true;
    }
    label896:
    label913:
    label959:
    this.kLg.removeMessages(2);
    this.count = 0;
    computeScroll();
    return true;
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.kKO.setEnableHorLongBmpMode(paramBoolean);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.kKO.setImageBitmap(paramBitmap);
    this.kKO.cAy();
  }
  
  public void setImageHeight(int paramInt)
  {
    this.kKO.setImageHeight(paramInt);
  }
  
  public void setImageWidth(int paramInt)
  {
    this.kKO.setImageWidth(paramInt);
  }
  
  public void setLongClickOverListener(MultiGestureImageView.b paramb)
  {
    this.kLi = paramb;
  }
  
  public void setSingleClickOverListener(MultiGestureImageView.d paramd)
  {
    this.kLh = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */