package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.f;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class b<T extends f>
{
  public static final b cRD = new b()
  {
    public final a Mb()
    {
      return a.cRr;
    }
    
    public final void Mc() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  private boolean cBX;
  public boolean cCu;
  private Matrix cRA;
  Rect cRB;
  private Bitmap cRC;
  private Canvas cRE = new Canvas();
  private Runnable cRF;
  PointF cRG = new PointF();
  private PointF cRH = new PointF();
  protected a cRI;
  public com.tencent.mm.bu.b cRz;
  float[] values = new float[9];
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected static int q(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      i = (int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
      int j = (int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
      i = (int)Math.sqrt(j * j + i * i);
    }
    return i;
  }
  
  protected static int[] r(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfInt[0] = ((int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1)));
      arrayOfInt[1] = ((int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
    }
    return arrayOfInt;
  }
  
  public abstract a Mb();
  
  public abstract void Mc();
  
  public T Md()
  {
    return this.cRz.a(Mb());
  }
  
  public void Me()
  {
    ad.i("MicroMsg.BaseArtist" + Mb(), "[onSelected] ");
  }
  
  public final void Mf()
  {
    if ((this.cRC != null) && (!this.cRC.isRecycled())) {
      this.cRC.recycle();
    }
  }
  
  public boolean Mg()
  {
    try
    {
      int i = Md().aj(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap Mh()
  {
    Rect localRect;
    int i;
    if ((this.cRC == null) || (this.cRC.isRecycled()))
    {
      localRect = this.cRz.eBt().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.cRz.eBt().getBaseBoardView().fiN())) {
        break label121;
      }
      i = this.cRz.eBt().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.cRz.eBt().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.cRC = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.cRC;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean Mi()
  {
    return this.cRz.eBu().Mb() == Mb();
  }
  
  public final void Mj()
  {
    if (Md().pop() != null) {
      Md().Mj();
    }
    this.cRz.eBt().removeCallbacks(this.cRF);
    com.tencent.mm.view.a locala = this.cRz.eBt();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.Mc();
        b.this.Mk();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.cRF = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void Mk()
  {
    this.cRz.eBt().getBaseBoardView().postInvalidate();
  }
  
  public final void Ml()
  {
    this.cRz.eBt().getBaseFooterView().postInvalidate();
  }
  
  public void a(com.tencent.mm.bu.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    ad.i("MicroMsg.BaseArtist" + Mb(), "[onCreate]");
    this.cCu = true;
    this.cRz = paramb;
    this.cRA = paramMatrix;
    this.cRB = paramRect;
  }
  
  public final void a(a parama)
  {
    this.cRI = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void ci(boolean paramBoolean)
  {
    this.cRE.setBitmap(Mh());
    f localf = Md();
    if (localf != null)
    {
      localf.a(this.cRE, paramBoolean);
      return;
    }
    ad.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.cRC != null) && (!this.cRC.isRecycled())) {
      paramCanvas.drawBitmap(this.cRC, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.cRz.eBt().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cRz.eBt().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.bu.b getPresenter()
  {
    return this.cRz;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.cRA, 1), a(this.cRA, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.cRA, 3);
    float f2 = a(this.cRA, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.cCu) && (this.cBX);
  }
  
  public void onAlive()
  {
    ad.i("MicroMsg.BaseArtist" + Mb(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.cBX) });
    if (this.cBX) {
      return;
    }
    this.cBX = true;
    f localf = Md();
    if (localf != null)
    {
      localf.Ut();
      localf.cA(false);
    }
    for (;;)
    {
      this.cRC = Mh();
      return;
      ad.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { Mb() });
    }
  }
  
  public void onDestroy()
  {
    this.cCu = false;
    this.cBX = false;
    ad.i("MicroMsg.BaseArtist" + Mb(), "[onDestroy]");
    Mf();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    ad.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { Mb() });
    this.cBX = false;
    this.cCu = false;
    f localf = Md();
    if (localf != null) {
      localf.cA(true);
    }
    for (;;)
    {
      Mf();
      return;
      ad.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { Mb() });
    }
  }
  
  public boolean p(MotionEvent paramMotionEvent)
  {
    if (t(paramMotionEvent)) {
      s(paramMotionEvent);
    }
    return false;
  }
  
  protected final void s(Bitmap paramBitmap)
  {
    if ((Mh() != null) && (!Mh().isRecycled())) {
      Mh().recycle();
    }
    this.cRC = paramBitmap;
  }
  
  protected final void s(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.cRH.x = paramMotionEvent.getX(1);
      this.cRH.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.cRG.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.cRG.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.cRG.x = paramMotionEvent.getX(0);
        this.cRG.y = paramMotionEvent.getY(0);
      }
    }
    this.cRG.x = paramMotionEvent.getX(0);
    this.cRG.y = paramMotionEvent.getY(0);
  }
  
  protected final float[] s(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.cRA);
    this.cRA.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.cRz.eBt().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final boolean t(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.cRG.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.cRG.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.cRH.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.cRH.y - paramMotionEvent.getY(1)) <= 3.0F) {}
      }
      else
      {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMotionEvent.getPointerCount() != 1);
      if (Math.abs(this.cRG.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.cRG.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  protected final float[] t(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.cRA.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface a
  {
    public abstract boolean p(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */