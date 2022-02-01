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
import com.tencent.mm.sdk.platformtools.ac;

public abstract class b<T extends f>
{
  public static final b cOY = new b()
  {
    public final a LZ()
    {
      return a.cOM;
    }
    
    public final void Ma() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  public com.tencent.mm.bt.b cOU;
  private Matrix cOV;
  Rect cOW;
  private Bitmap cOX;
  private Canvas cOZ = new Canvas();
  private Runnable cPa;
  PointF cPb = new PointF();
  private PointF cPc = new PointF();
  protected a cPd;
  public boolean czD;
  private boolean czg;
  float[] values = new float[9];
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected static int o(MotionEvent paramMotionEvent)
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
  
  protected static int[] p(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfInt[0] = ((int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1)));
      arrayOfInt[1] = ((int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
    }
    return arrayOfInt;
  }
  
  public abstract a LZ();
  
  public abstract void Ma();
  
  public T Mb()
  {
    return this.cOU.a(LZ());
  }
  
  public void Mc()
  {
    ac.i("MicroMsg.BaseArtist" + LZ(), "[onSelected] ");
  }
  
  public final void Md()
  {
    if ((this.cOX != null) && (!this.cOX.isRecycled())) {
      this.cOX.recycle();
    }
  }
  
  public boolean Me()
  {
    try
    {
      int i = Mb().aj(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap Mf()
  {
    Rect localRect;
    int i;
    if ((this.cOX == null) || (this.cOX.isRecycled()))
    {
      localRect = this.cOU.eQN().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.cOU.eQN().getBaseBoardView().fzb())) {
        break label121;
      }
      i = this.cOU.eQN().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.cOU.eQN().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.cOX = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.cOX;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean Mg()
  {
    return this.cOU.eQO().LZ() == LZ();
  }
  
  public final void Mh()
  {
    if (Mb().pop() != null) {
      Mb().Mh();
    }
    this.cOU.eQN().removeCallbacks(this.cPa);
    com.tencent.mm.view.a locala = this.cOU.eQN();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.Ma();
        b.this.Mi();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.cPa = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void Mi()
  {
    this.cOU.eQN().getBaseBoardView().postInvalidate();
  }
  
  public final void Mj()
  {
    this.cOU.eQN().getBaseFooterView().postInvalidate();
  }
  
  public void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    ac.i("MicroMsg.BaseArtist" + LZ(), "[onCreate]");
    this.czD = true;
    this.cOU = paramb;
    this.cOV = paramMatrix;
    this.cOW = paramRect;
  }
  
  public final void a(a parama)
  {
    this.cPd = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void ck(boolean paramBoolean)
  {
    this.cOZ.setBitmap(Mf());
    f localf = Mb();
    if (localf != null)
    {
      localf.a(this.cOZ, paramBoolean);
      return;
    }
    ac.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.cOX != null) && (!this.cOX.isRecycled())) {
      paramCanvas.drawBitmap(this.cOX, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.cOU.eQN().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cOU.eQN().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.bt.b getPresenter()
  {
    return this.cOU;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.cOV, 1), a(this.cOV, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.cOV, 3);
    float f2 = a(this.cOV, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.czD) && (this.czg);
  }
  
  public boolean n(MotionEvent paramMotionEvent)
  {
    if (r(paramMotionEvent)) {
      q(paramMotionEvent);
    }
    return false;
  }
  
  public void onAlive()
  {
    ac.i("MicroMsg.BaseArtist" + LZ(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.czg) });
    if (this.czg) {
      return;
    }
    this.czg = true;
    f localf = Mb();
    if (localf != null)
    {
      localf.Vo();
      localf.cA(false);
    }
    for (;;)
    {
      this.cOX = Mf();
      return;
      ac.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { LZ() });
    }
  }
  
  public void onDestroy()
  {
    this.czD = false;
    this.czg = false;
    ac.i("MicroMsg.BaseArtist" + LZ(), "[onDestroy]");
    Md();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    ac.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { LZ() });
    this.czg = false;
    this.czD = false;
    f localf = Mb();
    if (localf != null) {
      localf.cA(true);
    }
    for (;;)
    {
      Md();
      return;
      ac.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { LZ() });
    }
  }
  
  protected final void q(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.cPc.x = paramMotionEvent.getX(1);
      this.cPc.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.cPb.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.cPb.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.cPb.x = paramMotionEvent.getX(0);
        this.cPb.y = paramMotionEvent.getY(0);
      }
    }
    this.cPb.x = paramMotionEvent.getX(0);
    this.cPb.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean r(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.cPb.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.cPb.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.cPc.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.cPc.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.cPb.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.cPb.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  protected final void s(Bitmap paramBitmap)
  {
    if ((Mf() != null) && (!Mf().isRecycled())) {
      Mf().recycle();
    }
    this.cOX = paramBitmap;
  }
  
  protected final float[] s(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.cOV);
    this.cOV.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.cOU.eQN().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final float[] t(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.cOV.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface a
  {
    public abstract boolean n(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */