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
  public static final b dao = new b()
  {
    public final a NI()
    {
      return a.dac;
    }
    
    public final void NJ() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  private boolean cKc;
  public boolean cKz;
  public com.tencent.mm.bu.b dak;
  private Matrix dal;
  Rect dam;
  private Bitmap dan;
  private Canvas dap = new Canvas();
  private Runnable daq;
  PointF dar = new PointF();
  private PointF das = new PointF();
  protected a dat;
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
  
  public abstract a NI();
  
  public abstract void NJ();
  
  public T NK()
  {
    return this.dak.a(NI());
  }
  
  public void NL()
  {
    ad.i("MicroMsg.BaseArtist" + NI(), "[onSelected] ");
  }
  
  public final void NM()
  {
    if ((this.dan != null) && (!this.dan.isRecycled())) {
      this.dan.recycle();
    }
  }
  
  public boolean NN()
  {
    try
    {
      int i = NK().aj(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap NO()
  {
    Rect localRect;
    int i;
    if ((this.dan == null) || (this.dan.isRecycled()))
    {
      localRect = this.dak.ffR().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.dak.ffR().getBaseBoardView().fQk())) {
        break label121;
      }
      i = this.dak.ffR().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.dak.ffR().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.dan = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.dan;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean NP()
  {
    return this.dak.ffS().NI() == NI();
  }
  
  public final void NQ()
  {
    if (NK().pop() != null) {
      NK().NQ();
    }
    this.dak.ffR().removeCallbacks(this.daq);
    com.tencent.mm.view.a locala = this.dak.ffR();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.NJ();
        b.this.NR();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.daq = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void NR()
  {
    this.dak.ffR().getBaseBoardView().postInvalidate();
  }
  
  public final void NS()
  {
    this.dak.ffR().getBaseFooterView().postInvalidate();
  }
  
  public void a(com.tencent.mm.bu.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    ad.i("MicroMsg.BaseArtist" + NI(), "[onCreate]");
    this.cKz = true;
    this.dak = paramb;
    this.dal = paramMatrix;
    this.dam = paramRect;
  }
  
  public final void a(a parama)
  {
    this.dat = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void cl(boolean paramBoolean)
  {
    this.dap.setBitmap(NO());
    f localf = NK();
    if (localf != null)
    {
      localf.a(this.dap, paramBoolean);
      return;
    }
    ad.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.dan != null) && (!this.dan.isRecycled())) {
      paramCanvas.drawBitmap(this.dan, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.dak.ffR().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.dak.ffR().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.bu.b getPresenter()
  {
    return this.dak;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.dal, 1), a(this.dal, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.dal, 3);
    float f2 = a(this.dal, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.cKz) && (this.cKc);
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
    ad.i("MicroMsg.BaseArtist" + NI(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.cKc) });
    if (this.cKc) {
      return;
    }
    this.cKc = true;
    f localf = NK();
    if (localf != null)
    {
      localf.XF();
      localf.cC(false);
    }
    for (;;)
    {
      this.dan = NO();
      return;
      ad.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { NI() });
    }
  }
  
  public void onDestroy()
  {
    this.cKz = false;
    this.cKc = false;
    ad.i("MicroMsg.BaseArtist" + NI(), "[onDestroy]");
    NM();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    ad.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { NI() });
    this.cKc = false;
    this.cKz = false;
    f localf = NK();
    if (localf != null) {
      localf.cC(true);
    }
    for (;;)
    {
      NM();
      return;
      ad.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { NI() });
    }
  }
  
  protected final void q(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.das.x = paramMotionEvent.getX(1);
      this.das.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.dar.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.dar.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.dar.x = paramMotionEvent.getX(0);
        this.dar.y = paramMotionEvent.getY(0);
      }
    }
    this.dar.x = paramMotionEvent.getX(0);
    this.dar.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean r(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.dar.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.dar.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.das.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.das.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.dar.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.dar.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  protected final void s(Bitmap paramBitmap)
  {
    if ((NO() != null) && (!NO().isRecycled())) {
      NO().recycle();
    }
    this.dan = paramBitmap;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.dak.ffR().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final float[] u(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.dal);
    this.dal.invert(localMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected final float[] v(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    this.dal.mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public static abstract interface a
  {
    public abstract boolean n(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.b
 * JD-Core Version:    0.7.0.1
 */