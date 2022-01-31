package com.tencent.mm.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.e;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b<T extends e>
{
  public static final b ccW = new b.1();
  public boolean bRJ;
  private boolean bRn;
  public com.tencent.mm.bs.b ccS;
  private Matrix ccT;
  Rect ccU;
  private Bitmap ccV;
  private Canvas ccX = new Canvas();
  private Runnable ccY;
  PointF ccZ = new PointF();
  private PointF cda = new PointF();
  protected b.a cdb;
  private Context mContext;
  float[] values = new float[9];
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected static int p(MotionEvent paramMotionEvent)
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
  
  protected static int[] q(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfInt[0] = ((int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1)));
      arrayOfInt[1] = ((int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
    }
    return arrayOfInt;
  }
  
  protected final float[] B(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.ccT);
    this.ccT.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] C(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.ccT.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public abstract void CA();
  
  public T CB()
  {
    return this.ccS.a(Cz());
  }
  
  public void CC()
  {
    ab.i("MicroMsg.BaseArtist" + Cz(), "[onSelected] ");
  }
  
  public final void CD()
  {
    if ((this.ccV != null) && (!this.ccV.isRecycled())) {
      this.ccV.recycle();
    }
  }
  
  public boolean CE()
  {
    try
    {
      int i = CB().ad(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap CF()
  {
    Rect localRect;
    int i;
    if ((this.ccV == null) || (this.ccV.isRecycled()))
    {
      localRect = this.ccS.dqc().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.ccS.dqc().getBaseBoardView().dQS())) {
        break label121;
      }
      i = this.ccS.dqc().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.ccS.dqc().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.ccV = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.ccV;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean CG()
  {
    return this.ccS.dqd().Cz() == Cz();
  }
  
  public final void CH()
  {
    if (CB().pop() != null) {
      CB().CH();
    }
    this.ccS.dqc().removeCallbacks(this.ccY);
    com.tencent.mm.view.a locala = this.ccS.dqc();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116148);
        b.this.CA();
        b.this.CI();
        b.a(b.this);
        AppMethodBeat.o(116148);
      }
    };
    this.ccY = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void CI()
  {
    this.ccS.dqc().getBaseBoardView().postInvalidate();
  }
  
  public final void CJ()
  {
    this.ccS.dqc().getBaseFooterView().postInvalidate();
  }
  
  public abstract a Cz();
  
  public void a(com.tencent.mm.bs.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    ab.i("MicroMsg.BaseArtist" + Cz(), "[onCreate]");
    this.bRJ = true;
    this.mContext = paramb.getContext();
    this.ccS = paramb;
    this.ccT = paramMatrix;
    this.ccU = paramRect;
  }
  
  public final void a(b.a parama)
  {
    this.cdb = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public final void b(Canvas paramCanvas)
  {
    if ((this.ccV != null) && (!this.ccV.isRecycled())) {
      paramCanvas.drawBitmap(this.ccV, 0.0F, 0.0F, null);
    }
  }
  
  public void bt(boolean paramBoolean)
  {
    this.ccX.setBitmap(CF());
    e locale = CB();
    if (locale != null)
    {
      locale.a(this.ccX, paramBoolean);
      return;
    }
    ab.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  protected final Rect getBoardRect()
  {
    return this.ccS.dqc().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.ccS.dqc().getBaseBoardView().getMainMatrix();
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.ccT, 1), a(this.ccT, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.ccT, 3);
    float f2 = a(this.ccT, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.bRJ) && (this.bRn);
  }
  
  protected final void l(Bitmap paramBitmap)
  {
    if ((CF() != null) && (!CF().isRecycled())) {
      CF().recycle();
    }
    this.ccV = paramBitmap;
  }
  
  public boolean o(MotionEvent paramMotionEvent)
  {
    if (s(paramMotionEvent)) {
      r(paramMotionEvent);
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.bRJ = false;
    this.bRn = false;
    ab.i("MicroMsg.BaseArtist" + Cz(), "[onDestroy]");
    CD();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    ab.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { Cz() });
    this.bRn = false;
    this.bRJ = false;
    e locale = CB();
    if (locale != null) {
      locale.bH(true);
    }
    for (;;)
    {
      CD();
      return;
      ab.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { Cz() });
    }
  }
  
  protected final void r(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.cda.x = paramMotionEvent.getX(1);
      this.cda.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.ccZ.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.ccZ.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.ccZ.x = paramMotionEvent.getX(0);
        this.ccZ.y = paramMotionEvent.getY(0);
      }
    }
    this.ccZ.x = paramMotionEvent.getX(0);
    this.ccZ.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean s(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.ccZ.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.ccZ.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.cda.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.cda.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.ccZ.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.ccZ.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.ccS.dqc().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  public void zy()
  {
    ab.i("MicroMsg.BaseArtist" + Cz(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.bRn) });
    if (this.bRn) {
      return;
    }
    this.bRn = true;
    e locale = CB();
    if (locale != null)
    {
      locale.Jd();
      locale.bH(false);
    }
    for (;;)
    {
      this.ccV = CF();
      return;
      ab.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { Cz() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */