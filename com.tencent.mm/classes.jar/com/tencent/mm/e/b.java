package com.tencent.mm.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.y;

public abstract class b<T extends d>
{
  public static final b bAa = new b()
  {
    public final void onDraw(Canvas paramAnonymousCanvas) {}
    
    public final a tG()
    {
      return a.bzO;
    }
    
    public final void tH() {}
  };
  private Canvas bAb = new Canvas();
  private Runnable bAc;
  PointF bAd = new PointF();
  private PointF bAe = new PointF();
  public com.tencent.mm.bt.b bzV;
  private Matrix bzW;
  Rect bzX;
  private boolean bzY;
  private Bitmap bzZ;
  public boolean isCreated;
  private Context mContext;
  float[] values = new float[9];
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected static int n(MotionEvent paramMotionEvent)
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
  
  protected static int[] o(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfInt[0] = ((int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1)));
      arrayOfInt[1] = ((int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
    }
    return arrayOfInt;
  }
  
  protected final float[] A(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.bzW);
    this.bzW.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] B(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.bzW.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    y.i("MicroMsg.BaseArtist" + tG(), "[onCreate]");
    this.isCreated = true;
    this.mContext = paramb.getContext();
    this.bzV = paramb;
    this.bzW = paramMatrix;
    this.bzX = paramRect;
  }
  
  public void aS(boolean paramBoolean)
  {
    this.bAb.setBitmap(tN());
    tI().a(this.bAb, paramBoolean);
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public final void b(Canvas paramCanvas)
  {
    if ((this.bzZ != null) && (!this.bzZ.isRecycled())) {
      paramCanvas.drawBitmap(this.bzZ, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.bzV.coH().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.bzV.coH().getBaseBoardView().getMainMatrix();
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.bzW, 1), a(this.bzW, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.bzW, 3);
    float f2 = a(this.bzW, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.isCreated) && (this.bzY);
  }
  
  protected final void j(Bitmap paramBitmap)
  {
    if ((tN() != null) && (!tN().isRecycled())) {
      tN().recycle();
    }
    this.bzZ = paramBitmap;
  }
  
  public boolean m(MotionEvent paramMotionEvent)
  {
    if (q(paramMotionEvent)) {
      p(paramMotionEvent);
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.isCreated = false;
    this.bzY = false;
    y.i("MicroMsg.BaseArtist" + tG(), "[onDestroy]");
    tL();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    y.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { tG() });
    this.bzY = false;
    this.isCreated = false;
    d locald = tI();
    if (locald != null) {
      locald.bf(true);
    }
    for (;;)
    {
      tL();
      return;
      y.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { tG() });
    }
  }
  
  protected final void p(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.bAe.x = paramMotionEvent.getX(1);
      this.bAe.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.bAd.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.bAd.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.bAd.x = paramMotionEvent.getX(0);
        this.bAd.y = paramMotionEvent.getY(0);
      }
    }
    this.bAd.x = paramMotionEvent.getX(0);
    this.bAd.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean q(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.bAd.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.bAd.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.bAe.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.bAe.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.bAd.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.bAd.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.bzV.coH().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  public abstract a tG();
  
  public abstract void tH();
  
  public final T tI()
  {
    return this.bzV.a(tG());
  }
  
  public void tJ()
  {
    y.i("MicroMsg.BaseArtist" + tG(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.bzY) });
    if (this.bzY) {
      return;
    }
    this.bzY = true;
    d locald = tI();
    if (locald != null)
    {
      locald.wN();
      locald.bf(false);
    }
    for (;;)
    {
      this.bzZ = tN();
      return;
      y.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { tG() });
    }
  }
  
  public void tK()
  {
    y.i("MicroMsg.BaseArtist" + tG(), "[onSelected] ");
  }
  
  public final void tL()
  {
    if ((this.bzZ != null) && (!this.bzZ.isRecycled())) {
      this.bzZ.recycle();
    }
  }
  
  public boolean tM()
  {
    try
    {
      int i = tI().bg(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap tN()
  {
    Rect localRect;
    int i;
    if ((this.bzZ == null) || (this.bzZ.isRecycled()))
    {
      localRect = this.bzV.coH().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.bzV.coH().getBaseBoardView().cLB())) {
        break label113;
      }
      i = this.bzV.coH().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.bzV.coH().getBaseBoardView().getBoardRect().height();; j = localRect.height())
    {
      this.bzZ = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.bzZ;
      label113:
      i = localRect.width();
    }
  }
  
  protected final boolean tO()
  {
    return this.bzV.coI().tG() == tG();
  }
  
  public final void tP()
  {
    if (tI().pop() != null) {
      tI().tP();
    }
    this.bzV.coH().removeCallbacks(this.bAc);
    com.tencent.mm.view.a locala = this.bzV.coH();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        b.this.tH();
        b.this.tQ();
        b.a(b.this);
      }
    };
    this.bAc = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void tQ()
  {
    this.bzV.coH().getBaseBoardView().postInvalidate();
  }
  
  public final void tR()
  {
    this.bzV.coH().getBaseFooterView().postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */