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
import com.tencent.mm.sdk.platformtools.ae;

public abstract class b<T extends f>
{
  public static final b dbq = new b()
  {
    public final a NG()
    {
      return a.dbe;
    }
    
    public final void NH() {}
    
    public final void onDraw(Canvas paramAnonymousCanvas) {}
  };
  private boolean cKL;
  public boolean cLi;
  public com.tencent.mm.bt.b dbm;
  private Matrix dbn;
  Rect dbo;
  private Bitmap dbp;
  private Canvas dbr = new Canvas();
  private Runnable dbs;
  PointF dbt = new PointF();
  private PointF dbu = new PointF();
  protected a dbv;
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
  
  public abstract a NG();
  
  public abstract void NH();
  
  public T NI()
  {
    return this.dbm.a(NG());
  }
  
  public void NJ()
  {
    ae.i("MicroMsg.BaseArtist" + NG(), "[onSelected] ");
  }
  
  public final void NK()
  {
    if ((this.dbp != null) && (!this.dbp.isRecycled())) {
      this.dbp.recycle();
    }
  }
  
  public boolean NL()
  {
    try
    {
      int i = NI().aj(true);
      return i > 0;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected final Bitmap NM()
  {
    Rect localRect;
    int i;
    if ((this.dbp == null) || (this.dbp.isRecycled()))
    {
      localRect = this.dbm.fjH().getBaseBoardView().getImageBitmapRect();
      if ((!localRect.isEmpty()) && (this.dbm.fjH().getBaseBoardView().fUG())) {
        break label121;
      }
      i = this.dbm.fjH().getBaseBoardView().getBoardRect().width();
    }
    for (int j = this.dbm.fjH().getBaseBoardView().getBoardRect().height(); (i > 0) && (j > 0); j = localRect.height())
    {
      this.dbp = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      return this.dbp;
      label121:
      i = localRect.width();
    }
    return null;
  }
  
  protected final boolean NN()
  {
    return this.dbm.fjI().NG() == NG();
  }
  
  public final void NO()
  {
    if (NI().pop() != null) {
      NI().NO();
    }
    this.dbm.fjH().removeCallbacks(this.dbs);
    com.tencent.mm.view.a locala = this.dbm.fjH();
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9118);
        b.this.NH();
        b.this.NP();
        b.a(b.this);
        AppMethodBeat.o(9118);
      }
    };
    this.dbs = local2;
    locala.postDelayed(local2, 66L);
  }
  
  public final void NP()
  {
    this.dbm.fjH().getBaseBoardView().postInvalidate();
  }
  
  public final void NQ()
  {
    this.dbm.fjH().getBaseFooterView().postInvalidate();
  }
  
  public void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    ae.i("MicroMsg.BaseArtist" + NG(), "[onCreate]");
    this.cLi = true;
    this.dbm = paramb;
    this.dbn = paramMatrix;
    this.dbo = paramRect;
  }
  
  public final void a(a parama)
  {
    this.dbv = parama;
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public void cl(boolean paramBoolean)
  {
    this.dbr.setBitmap(NM());
    f localf = NI();
    if (localf != null)
    {
      localf.a(this.dbr, paramBoolean);
      return;
    }
    ae.i("MicroMsg.BaseArtist", "updateCache: cache is null");
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.dbp != null) && (!this.dbp.isRecycled())) {
      paramCanvas.drawBitmap(this.dbp, 0.0F, 0.0F, null);
    }
  }
  
  protected final Rect getBoardRect()
  {
    return this.dbm.fjH().getBaseBoardView().getBoardRect();
  }
  
  public final Matrix getMainMatrix()
  {
    return this.dbm.fjH().getBaseBoardView().getMainMatrix();
  }
  
  public final com.tencent.mm.bt.b getPresenter()
  {
    return this.dbm;
  }
  
  public final float getRotation()
  {
    return (float)Math.round(Math.atan2(a(this.dbn, 1), a(this.dbn, 0)) * 57.295779513082323D);
  }
  
  public final float getScale()
  {
    float f1 = a(this.dbn, 3);
    float f2 = a(this.dbn, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final boolean isAlive()
  {
    return (this.cLi) && (this.cKL);
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
    ae.i("MicroMsg.BaseArtist" + NG(), "[onAlive] isAlive:%s", new Object[] { Boolean.valueOf(this.cKL) });
    if (this.cKL) {
      return;
    }
    this.cKL = true;
    f localf = NI();
    if (localf != null)
    {
      localf.XP();
      localf.cC(false);
    }
    for (;;)
    {
      this.dbp = NM();
      return;
      ae.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[] { NG() });
    }
  }
  
  public void onDestroy()
  {
    this.cLi = false;
    this.cKL = false;
    ae.i("MicroMsg.BaseArtist" + NG(), "[onDestroy]");
    NK();
  }
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public final void onFinish()
  {
    ae.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[] { NG() });
    this.cKL = false;
    this.cLi = false;
    f localf = NI();
    if (localf != null) {
      localf.cC(true);
    }
    for (;;)
    {
      NK();
      return;
      ae.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[] { NG() });
    }
  }
  
  protected final void q(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.dbu.x = paramMotionEvent.getX(1);
      this.dbu.y = paramMotionEvent.getY(1);
    }
    for (;;)
    {
      if (paramMotionEvent.getActionMasked() == 6)
      {
        if ((paramMotionEvent.getPointerCount() <= 1) || (1 - paramMotionEvent.getActionIndex() < 0) || (1 - paramMotionEvent.getActionIndex() >= paramMotionEvent.getPointerCount())) {
          break;
        }
        this.dbt.x = paramMotionEvent.getX(1 - paramMotionEvent.getActionIndex());
        this.dbt.y = paramMotionEvent.getY(1 - paramMotionEvent.getActionIndex());
      }
      return;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        this.dbt.x = paramMotionEvent.getX(0);
        this.dbt.y = paramMotionEvent.getY(0);
      }
    }
    this.dbt.x = paramMotionEvent.getX(0);
    this.dbt.y = paramMotionEvent.getY(0);
  }
  
  protected final boolean r(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMotionEvent.getPointerCount() > 1) {
      if ((Math.abs(this.dbt.x - paramMotionEvent.getX(0)) <= 3.0F) && (Math.abs(this.dbt.y - paramMotionEvent.getY(0)) <= 3.0F) && (Math.abs(this.dbu.x - paramMotionEvent.getX(1)) <= 3.0F))
      {
        bool1 = bool2;
        if (Math.abs(this.dbu.y - paramMotionEvent.getY(1)) <= 3.0F) {}
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
      if (Math.abs(this.dbt.x - paramMotionEvent.getX(0)) > 3.0F) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(this.dbt.y - paramMotionEvent.getY(0)) <= 3.0F);
    return true;
  }
  
  public final void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.dbm.fjH().getBaseBoardView().setOneFingerMoveEnable(paramBoolean);
  }
  
  protected final void t(Bitmap paramBitmap)
  {
    if ((NM() != null) && (!NM().isRecycled())) {
      NM().recycle();
    }
    this.dbp = paramBitmap;
  }
  
  protected final float[] u(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix(this.dbn);
    this.dbn.invert(localMatrix);
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
    this.dbn.mapPoints(arrayOfFloat);
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