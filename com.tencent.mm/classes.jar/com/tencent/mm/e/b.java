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
  public static final b fkI = new b()
  {
    public final a acy()
    {
      return a.fkw;
    }
    
    public final void acz() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  public boolean dfI;
  private boolean dfl;
  public com.tencent.mm.ca.b fkE;
  private Matrix fkF;
  private Rect fkG;
  public Bitmap fkH;
  private Canvas fkJ = new Canvas();
  private Runnable fkK;
  private PointF fkL = new PointF();
  private PointF fkM = new PointF();
  float[] fkN = new float[9];
  protected a fkO;
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.fkN);
    return this.fkN[paramInt];
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
  
  public void a(com.tencent.mm.ca.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    Log.i("MicroMsg.BaseArtist" + acy(), "[onCreate]");
    this.dfI = true;
    this.fkE = paramb;
    this.fkF = paramMatrix;
    this.fkG = paramRect;
  }
  
  public final void a(a parama)
  {
    this.fkO = parama;
  }
  
  public T acA()
  {
    return this.fkE.a(acy());
  }
  
  public void acB()
  {
    Log.i("MicroMsg.BaseArtist" + acy(), "[onSelected] ");
  }
  
  public final void acC()
  {
    if ((this.fkH != null) && (!this.fkH.isRecycled())) {
      this.fkH.recycle();
    }
  }
  
  public boolean acD()
  {
    try
    {
      int i = acA().ai(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap acE()
  {
    Rect localRect;
    int i;
    if ((this.fkH == null) || (this.fkH.isRecycled()))
    {
      localRect = this.fkE.hou().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.fkE.hou().getBaseBoardView().ihB())) {
        break label121;
      }
      i = this.fkE.hou().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.fkE.hou().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.fkH = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.fkH;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean acF()
  {
    return this.fkE.hov().acy() == acy();
  }
  
  public final void acG()
  {
    if (acA().pop() != null) {
      acA().acG();
    }
    this.fkE.hou().removeCallbacks(this.fkK);
    com.tencent.mm.view.a locala = this.fkE.hou();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.acz();
        b.this.acH();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.fkK = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void acH()
  {
    this.fkE.hou().getBaseBoardView().postInvalidate();
  }
  
  public final void acI()
  {
    this.fkE.hou().getBaseFooterView().postInvalidate();
  }
  
  public abstract a acy();
  
  public abstract void acz();
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void dq(boolean paramBoolean)
  {
    this.fkJ.setBitmap(acE());
    f localf = acA();
    if (localf != null)
    {
      localf.a(this.fkJ, paramBoolean);
      return;
    }
    Log.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void e(Canvas paramCanvas)
  {
    if ((this.fkH != null) && (!this.fkH.isRecycled())) {
      paramCanvas.drawBitmap(this.fkH, 0.0F, 0.0F, null);
    }
  }
  
  public final Rect getAliveRect()
  {
    return this.fkG;
  }
  
  protected final Rect getBoardRect()
  {
    return this.fkE.hou().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.fkE.hou().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.ca.b getPresenter()
  {
    return this.fkE;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.fkF, 1), a(this.fkF, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.fkF, 3);
    float f2 = a(this.fkF, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.dfI) && (this.dfl);
  }
  
  protected final void o(Bitmap paramBitmap)
  {
    if ((acE() != null) && (!acE().isRecycled())) {
      acE().recycle();
    }
    this.fkH = paramBitmap;
  }
  
  public void onAlive()
  {
    Log.i("MicroMsg.BaseArtist" + acy(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.dfl) });
    if (this.dfl) {
      return;
    }
    this.dfl = true;
    f localf = acA();
    if (localf != null)
    {
      localf.arB();
      localf.dL(false);
    }
    for (;;)
    {
      this.fkH = acE();
      return;
      Log.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { acy() });
    }
  }
  
  public void onDestroy()
  {
    this.dfI = false;
    this.dfl = false;
    Log.i("MicroMsg.BaseArtist" + acy(), "[onDestroy]");
    acC();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    Log.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { acy() });
    this.dfl = false;
    this.dfI = false;
    f localf = acA();
    if (localf != null) {
      localf.dL(true);
    }
    for (;;)
    {
      acC();
      return;
      Log.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { acy() });
    }
  }
  
  public boolean q(MotionEvent paramMotionEvent)
  {
    if (v(paramMotionEvent)) {
      u(paramMotionEvent);
    }
    return false;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.fkE.hou().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final int[] t(MotionEvent paramMotionEvent)
  {
    return new int[] { (int)(paramMotionEvent.getX(0) - this.fkL.x), (int)(paramMotionEvent.getY(0) - this.fkL.y) };
  }
  
  protected final void u(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.fkM.x = paramMotionEvent.getX(1);
      this.fkM.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.fkL.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.fkL.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.fkL.x = paramMotionEvent.getX(0);
        this.fkL.y = paramMotionEvent.getY(0);
      }
    }
    this.fkL.x = paramMotionEvent.getX(0);
    this.fkL.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean v(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.fkL.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.fkL.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.fkM.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.fkM.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.fkL.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.fkL.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  protected final float[] x(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.fkF);
    this.fkF.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] y(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.fkF.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface a
  {
    public abstract boolean q(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */