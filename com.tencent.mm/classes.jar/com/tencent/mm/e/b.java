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
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b<T extends f>
{
  public static final b hoV = new b()
  {
    public final a aEy()
    {
      return a.hoJ;
    }
    
    public final void aEz() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  public boolean feX;
  private boolean fez;
  public com.tencent.mm.bt.b hoR;
  private Matrix hoS;
  private Rect hoT;
  public Bitmap hoU;
  private Canvas hoW = new Canvas();
  private Runnable hoX;
  private PointF hoY = new PointF();
  private PointF hoZ = new PointF();
  float[] hpa = new float[9];
  protected a hpb;
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.hpa);
    return this.hpa[paramInt];
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
  
  protected final void A(Bitmap paramBitmap)
  {
    if ((aEE() != null) && (!aEE().isRecycled())) {
      aEE().recycle();
    }
    this.hoU = paramBitmap;
  }
  
  public void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    Log.i("MicroMsg.BaseArtist" + aEy(), "[onCreate]");
    this.feX = true;
    this.hoR = paramb;
    this.hoS = paramMatrix;
    this.hoT = paramRect;
  }
  
  public final void a(a parama)
  {
    this.hpb = parama;
  }
  
  public T aEA()
  {
    return this.hoR.a(aEy());
  }
  
  public void aEB()
  {
    Log.i("MicroMsg.BaseArtist" + aEy(), "[onSelected] ");
  }
  
  public final void aEC()
  {
    if ((this.hoU != null) && (!this.hoU.isRecycled())) {
      this.hoU.recycle();
    }
  }
  
  public boolean aED()
  {
    try
    {
      int i = aEA().aR(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap aEE()
  {
    Rect localRect;
    int i;
    if ((this.hoU == null) || (this.hoU.isRecycled()))
    {
      localRect = this.hoR.iPo().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.hoR.iPo().getBaseBoardView().jMO())) {
        break label121;
      }
      i = this.hoR.iPo().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.hoR.iPo().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.hoU = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.hoU;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean aEF()
  {
    return this.hoR.iPp().aEy() == aEy();
  }
  
  public final void aEG()
  {
    if (aEA().pop() != null) {
      aEA().aEG();
    }
    this.hoR.iPo().removeCallbacks(this.hoX);
    com.tencent.mm.view.a locala = this.hoR.iPo();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.aEz();
        b.this.aEH();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.hoX = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void aEH()
  {
    this.hoR.iPo().getBaseBoardView().postInvalidate();
  }
  
  public final void aEI()
  {
    this.hoR.iPo().getBaseFooterView().postInvalidate();
  }
  
  public abstract a aEy();
  
  public abstract void aEz();
  
  protected final float[] ad(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.hoS);
    this.hoS.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] ae(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.hoS.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public final float d(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void ec(boolean paramBoolean)
  {
    this.hoW.setBitmap(aEE());
    f localf = aEA();
    if (localf != null)
    {
      localf.b(this.hoW, paramBoolean);
      return;
    }
    Log.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public final Rect getAliveRect()
  {
    return this.hoT;
  }
  
  protected final Rect getBoardRect()
  {
    return this.hoR.iPo().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.hoR.iPo().getBaseBoardView().getMainMatrix();
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.hoS, 1), a(this.hoS, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.hoS, 3);
    float f2 = a(this.hoS, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public void h(Canvas paramCanvas)
  {
    if ((this.hoU != null) && (!this.hoU.isRecycled())) {
      paramCanvas.drawBitmap(this.hoU, 0.0F, 0.0F, null);
    }
  }
  
  public final boolean isAlive()
  {
    return (this.feX) && (this.fez);
  }
  
  public void onAlive()
  {
    Log.i("MicroMsg.BaseArtist" + aEy(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.fez) });
    if (this.fez) {
      return;
    }
    this.fez = true;
    f localf = aEA();
    if (localf != null)
    {
      localf.aLx();
      localf.ex(false);
    }
    for (;;)
    {
      this.hoU = aEE();
      return;
      Log.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { aEy() });
    }
  }
  
  public void onDestroy()
  {
    this.feX = false;
    this.fez = false;
    Log.i("MicroMsg.BaseArtist" + aEy(), "[onDestroy]");
    aEC();
  }
  
  public boolean onDispatchTouch(MotionEvent paramMotionEvent)
  {
    if (u(paramMotionEvent)) {
      t(paramMotionEvent);
    }
    return false;
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    Log.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { aEy() });
    this.fez = false;
    this.feX = false;
    f localf = aEA();
    if (localf != null) {
      localf.ex(true);
    }
    for (;;)
    {
      aEC();
      return;
      Log.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { aEy() });
    }
  }
  
  protected final int[] s(MotionEvent paramMotionEvent)
  {
    return new int[] { (int)(paramMotionEvent.getX(0) - this.hoY.x), (int)(paramMotionEvent.getY(0) - this.hoY.y) };
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.hoR.iPo().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final void t(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.hoZ.x = paramMotionEvent.getX(1);
      this.hoZ.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.hoY.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.hoY.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.hoY.x = paramMotionEvent.getX(0);
        this.hoY.y = paramMotionEvent.getY(0);
      }
    }
    this.hoY.x = paramMotionEvent.getX(0);
    this.hoY.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean u(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.hoY.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.hoY.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.hoZ.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.hoZ.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.hoY.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.hoY.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean onDispatchTouch(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */