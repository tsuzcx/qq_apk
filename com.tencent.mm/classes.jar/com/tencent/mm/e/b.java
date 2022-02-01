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
  public static final b drW = new b()
  {
    public final a XS()
    {
      return a.drK;
    }
    
    public final void XT() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  public boolean dbG;
  private boolean dbi;
  public com.tencent.mm.bt.b drS;
  private Matrix drT;
  Rect drU;
  public Bitmap drV;
  private Canvas drX = new Canvas();
  private Runnable drY;
  PointF drZ = new PointF();
  private PointF dsa = new PointF();
  protected a dsb;
  float[] values = new float[9];
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected static int r(MotionEvent paramMotionEvent)
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
  
  protected static int[] s(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfInt[0] = ((int)(paramMotionEvent.getX(0) - paramMotionEvent.getX(1)));
      arrayOfInt[1] = ((int)(paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
    }
    return arrayOfInt;
  }
  
  public abstract a XS();
  
  public abstract void XT();
  
  public T XU()
  {
    return this.drS.a(XS());
  }
  
  public void XV()
  {
    Log.i("MicroMsg.BaseArtist" + XS(), "[onSelected] ");
  }
  
  public final void XW()
  {
    if ((this.drV != null) && (!this.drV.isRecycled())) {
      this.drV.recycle();
    }
  }
  
  public boolean XX()
  {
    try
    {
      int i = XU().ai(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap XY()
  {
    Rect localRect;
    int i;
    if ((this.drV == null) || (this.drV.isRecycled()))
    {
      localRect = this.drS.gth().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.drS.gth().getBaseBoardView().hgb())) {
        break label121;
      }
      i = this.drS.gth().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.drS.gth().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.drV = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.drV;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean XZ()
  {
    return this.drS.gti().XS() == XS();
  }
  
  public final void Ya()
  {
    if (XU().pop() != null) {
      XU().Ya();
    }
    this.drS.gth().removeCallbacks(this.drY);
    com.tencent.mm.view.a locala = this.drS.gth();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.XT();
        b.this.Yb();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.drY = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void Yb()
  {
    this.drS.gth().getBaseBoardView().postInvalidate();
  }
  
  public final void Yc()
  {
    this.drS.gth().getBaseFooterView().postInvalidate();
  }
  
  public void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    Log.i("MicroMsg.BaseArtist" + XS(), "[onCreate]");
    this.dbG = true;
    this.drS = paramb;
    this.drT = paramMatrix;
    this.drU = paramRect;
  }
  
  public final void a(a parama)
  {
    this.dsb = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void cT(boolean paramBoolean)
  {
    this.drX.setBitmap(XY());
    f localf = XU();
    if (localf != null)
    {
      localf.a(this.drX, paramBoolean);
      return;
    }
    Log.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.drV != null) && (!this.drV.isRecycled())) {
      paramCanvas.drawBitmap(this.drV, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.drS.gth().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.drS.gth().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.bt.b getPresenter()
  {
    return this.drS;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.drT, 1), a(this.drT, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.drT, 3);
    float f2 = a(this.drT, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.dbG) && (this.dbi);
  }
  
  public void onAlive()
  {
    Log.i("MicroMsg.BaseArtist" + XS(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.dbi) });
    if (this.dbi) {
      return;
    }
    this.dbi = true;
    f localf = XU();
    if (localf != null)
    {
      localf.alC();
      localf.dl(false);
    }
    for (;;)
    {
      this.drV = XY();
      return;
      Log.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { XS() });
    }
  }
  
  public void onDestroy()
  {
    this.dbG = false;
    this.dbi = false;
    Log.i("MicroMsg.BaseArtist" + XS(), "[onDestroy]");
    XW();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    Log.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { XS() });
    this.dbi = false;
    this.dbG = false;
    f localf = XU();
    if (localf != null) {
      localf.dl(true);
    }
    for (;;)
    {
      XW();
      return;
      Log.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { XS() });
    }
  }
  
  public boolean q(MotionEvent paramMotionEvent)
  {
    if (u(paramMotionEvent)) {
      t(paramMotionEvent);
    }
    return false;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.drS.gth().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final void t(Bitmap paramBitmap)
  {
    if ((XY() != null) && (!XY().isRecycled())) {
      XY().recycle();
    }
    this.drV = paramBitmap;
  }
  
  protected final void t(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.dsa.x = paramMotionEvent.getX(1);
      this.dsa.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.drZ.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.drZ.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.drZ.x = paramMotionEvent.getX(0);
        this.drZ.y = paramMotionEvent.getY(0);
      }
    }
    this.drZ.x = paramMotionEvent.getX(0);
    this.drZ.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean u(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.drZ.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.drZ.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.dsa.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.dsa.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.drZ.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.drZ.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  protected final float[] v(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.drT);
    this.drT.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] w(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.drT.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface a
  {
    public abstract boolean q(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */