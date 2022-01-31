package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int akq;
  private int akr;
  private float bVQ;
  private int count;
  private int iiW;
  private int iiX;
  private RectF nhA;
  private a nhB;
  private float nhC;
  private boolean nhD;
  private boolean nhE;
  private boolean nhF;
  private boolean nhG;
  private MultiGestureImageView.j nhH;
  private MultiGestureImageView.j nhI;
  private MultiGestureImageView.j nhJ;
  private d nhK;
  private MultiGestureImageView.b nhL;
  private MultiTouchImageView nhr;
  private long nhs;
  private long nht;
  private float nhu;
  private float nhv;
  private long nhw;
  private boolean nhx;
  private OverScroller nhy;
  private GestureDetector nhz;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(21640);
    this.count = 0;
    this.nhs = 0L;
    this.nht = 0L;
    this.nhu = 0.0F;
    this.nhv = 0.0F;
    this.nhw = 0L;
    this.nhx = false;
    this.nhA = new RectF();
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(21640);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(21641);
    this.count = 0;
    this.nhs = 0L;
    this.nht = 0L;
    this.nhu = 0.0F;
    this.nhv = 0.0F;
    this.nhw = 0L;
    this.nhx = false;
    this.nhA = new RectF();
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(21641);
  }
  
  private void bEJ()
  {
    AppMethodBeat.i(21646);
    this.nhH.removeMessages(1);
    AppMethodBeat.o(21646);
  }
  
  private void bEK()
  {
    AppMethodBeat.i(21647);
    bEJ();
    this.nhH.j(1, 15L, 15L);
    AppMethodBeat.o(21647);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(21642);
    this.nhr = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.nhz = new GestureDetector(paramContext, new c((byte)0));
    this.nhy = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.nhr.setLayoutParams(paramContext);
    addView(this.nhr);
    this.nhH = new MultiGestureImageView.j(this, new WeakReference(this));
    this.nhI = new MultiGestureImageView.j(this, new WeakReference(this));
    this.nhJ = new MultiGestureImageView.j(this, new WeakReference(this));
    AppMethodBeat.o(21642);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(21645);
    if (this.nhr == null)
    {
      AppMethodBeat.o(21645);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.nhy.computeScrollOffset())
    {
      i = this.nhy.getCurrX() - this.akq;
      int n = this.nhy.getCurrY() - this.akr;
      this.akq = this.nhy.getCurrX();
      this.akr = this.nhy.getCurrY();
      float f3 = this.nhr.getScale();
      f4 = this.nhr.getImageWidth();
      float f1 = f3 * this.nhr.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.nhr.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.nhA.right - Math.round(f3)) {
          j = (int)(this.nhA.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.nhA.left - Math.round(f2)) {
          i = (int)(this.nhA.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.nhA.bottom - Math.round(f5)) {
          k = (int)(this.nhA.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.nhA.top - Math.round(f4)) {
          j = (int)(this.nhA.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.nhA.left) && (Math.round(f3) > this.nhA.right)) {
        break label427;
      }
      k = 0;
      if (f1 >= this.iiX) {
        break label475;
      }
    }
    label427:
    label475:
    for (int i = m;; i = j)
    {
      this.nhr.ap(k, i);
      postInvalidate();
      AppMethodBeat.o(21645);
      return;
      if (Math.round(f4) < this.nhA.top)
      {
        k = i;
        if (Math.round(f5) > this.nhA.bottom) {
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
    AppMethodBeat.i(21651);
    int i = this.nhr.getImageHeight();
    AppMethodBeat.o(21651);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(21649);
    int i = this.nhr.getImageWidth();
    AppMethodBeat.o(21649);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21643);
    super.onMeasure(paramInt1, paramInt2);
    this.iiW = View.MeasureSpec.getSize(paramInt1);
    this.iiX = View.MeasureSpec.getSize(paramInt2);
    this.nhA.set(0.0F, 0.0F, this.iiW, this.iiX);
    ab.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.iiW + " height:" + this.iiX);
    AppMethodBeat.o(21643);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(21644);
    this.nhz.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.nhy.forceFinished(true);
      this.nhJ.removeMessages(2);
      this.nhJ.j(2, 500L, 0L);
      this.nhr.dDK();
      this.count += 1;
      if (this.count == 1)
      {
        this.nhs = System.currentTimeMillis();
        this.nhu = f.c(paramMotionEvent, 0);
        this.nhv = f.d(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.nhJ.removeMessages(2);
        this.bVQ = 0.0F;
        this.nhC = this.nhr.getScale();
        this.nhx = true;
        float f4;
        if (this.nhC < this.nhr.getScaleRate())
        {
          f1 = f.c(paramMotionEvent, 0);
          f2 = f.c(paramMotionEvent, 1);
          f3 = f.d(paramMotionEvent, 0);
          f4 = f.d(paramMotionEvent, 1);
          this.nhr.an(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
        }
        if (this.nhC > this.nhr.getDoubleTabScale())
        {
          f1 = f.c(paramMotionEvent, 0);
          f2 = f.c(paramMotionEvent, 1);
          f3 = f.d(paramMotionEvent, 0);
          f4 = f.d(paramMotionEvent, 1);
          this.nhr.ao(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.nhJ.removeMessages(2);
        if (((!this.nhF) && (!this.nhG)) || ((!this.nhD) && (!this.nhE))) {
          break label777;
        }
        this.nhB = new MultiGestureImageView.f(this, this.nhr);
        bEK();
        this.nhF = false;
        this.nhG = false;
        this.nhD = false;
        this.nhE = false;
        label368:
        this.bVQ = 0.0F;
        this.nhC = this.nhr.getScale();
        if (this.count == 1)
        {
          this.nht = System.currentTimeMillis();
          if (this.nht - this.nhs >= 350L) {
            break label908;
          }
          if ((Math.abs(this.nhu - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.nhv - f.d(paramMotionEvent, 0)) < 10.0F))
          {
            MultiGestureImageView.j localj = this.nhI;
            localj.cJJ = false;
            localj.j(0, 350L, 0L);
          }
        }
      }
      label477:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.bVQ = 0.0F;
        this.nhC = this.nhr.getScale();
        this.nhx = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.T(paramMotionEvent) != 2) {
          break label972;
        }
        this.nhJ.removeMessages(2);
        this.nhx = true;
        this.count = 0;
        f1 = f.c(paramMotionEvent, 0) - f.c(paramMotionEvent, 1);
        f2 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.bVQ != 0.0F) {
          break label925;
        }
        this.bVQ = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21644);
      return true;
      if (this.count != 2) {
        break;
      }
      this.nhw = System.currentTimeMillis();
      if (this.nhw - this.nht < 350L)
      {
        if ((Math.abs(this.nhu - f.c(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.nhv - f.d(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          ab.d("MicroMsg.MuitlGestureImageView", "double click!");
          if (this.nhr.getScale() <= this.nhr.getScaleRate())
          {
            this.nhr.ao(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
            break;
          }
          this.nhr.an(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
          this.nhr.dEA();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label777:
      if (this.nhF)
      {
        this.nhF = false;
        this.nhB = new MultiGestureImageView.g(this, this.nhr);
        bEK();
      }
      if (this.nhG)
      {
        this.nhG = false;
        this.nhB = new MultiGestureImageView.h(this, this.nhr);
        bEK();
      }
      if (this.nhD)
      {
        this.nhD = false;
        this.nhB = new MultiGestureImageView.i(this, this.nhr);
        bEK();
      }
      if (!this.nhE) {
        break label368;
      }
      this.nhE = false;
      this.nhB = new MultiGestureImageView.e(this, this.nhr);
      bEK();
      break label368;
      label908:
      this.count = 0;
      ab.d("MicroMsg.MuitlGestureImageView", "single long click over!");
      break label477;
      label925:
      f3 /= this.bVQ;
      if (this.nhx)
      {
        this.nhr.k(f3 * this.nhC, f1 + f.c(paramMotionEvent, 1), f2 + f.d(paramMotionEvent, 1));
        continue;
        label972:
        if ((Math.abs(this.nhu - f.c(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.nhv - f.d(paramMotionEvent, 0)) > 10.0F))
        {
          this.nhJ.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(21648);
    this.nhr.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(21648);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(21653);
    this.nhr.setImageBitmap(paramBitmap);
    this.nhr.dDJ();
    AppMethodBeat.o(21653);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(21652);
    this.nhr.setImageHeight(paramInt);
    AppMethodBeat.o(21652);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(21650);
    this.nhr.setImageWidth(paramInt);
    AppMethodBeat.o(21650);
  }
  
  public void setLongClickOverListener(MultiGestureImageView.b paramb)
  {
    this.nhL = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.nhK = paramd;
  }
  
  abstract class a
  {
    protected boolean bVC = false;
    
    public a() {}
    
    public final boolean bEL()
    {
      return this.bVC;
    }
    
    public abstract void play();
  }
  
  final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */