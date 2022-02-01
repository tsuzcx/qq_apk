package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.j.a;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  boolean KgQ;
  private View KgR;
  private int KgS;
  private int KgT;
  public MMHandler KgU;
  private float KgV;
  private float KgW;
  private float KgX;
  private float KgY;
  private int KgZ;
  private int Kha;
  private float Khb;
  private float Khc;
  private int Khd;
  private float Khe;
  private float Khf;
  private float Khg;
  private float Khh;
  public Runnable Khi;
  private Context mContext;
  boolean oCI;
  private Paint paint;
  private float radius;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.oCI = false;
    this.KgQ = false;
    this.KgS = -1;
    this.KgT = -1;
    this.KgU = null;
    this.KgZ = -6751336;
    this.Kha = 70;
    this.Khb = 0.5F;
    this.Khc = 0.001F;
    this.Khd = 20;
    this.radius = 0.0F;
    this.Khg = 40.0F;
    this.Khh = 30.0F;
    this.Khi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55982);
        VolumeMeter.a(VolumeMeter.this);
        VolumeMeter.b(VolumeMeter.this);
        if (VolumeMeter.c(VolumeMeter.this) != null)
        {
          VolumeMeter.c(VolumeMeter.this).getSerial().quit();
          VolumeMeter.a(VolumeMeter.this, null);
        }
        AppMethodBeat.o(55982);
      }
    };
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55987);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55986);
    this.oCI = false;
    this.KgQ = false;
    this.KgS = -1;
    this.KgT = -1;
    this.KgU = null;
    this.KgZ = -6751336;
    this.Kha = 70;
    this.Khb = 0.5F;
    this.Khc = 0.001F;
    this.Khd = 20;
    this.radius = 0.0F;
    this.Khg = 40.0F;
    this.Khh = 30.0F;
    this.Khi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55982);
        VolumeMeter.a(VolumeMeter.this);
        VolumeMeter.b(VolumeMeter.this);
        if (VolumeMeter.c(VolumeMeter.this) != null)
        {
          VolumeMeter.c(VolumeMeter.this).getSerial().quit();
          VolumeMeter.a(VolumeMeter.this, null);
        }
        AppMethodBeat.o(55982);
      }
    };
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55986);
  }
  
  private void init()
  {
    AppMethodBeat.i(55988);
    this.paint = new Paint();
    AppMethodBeat.o(55988);
  }
  
  public final void fVo()
  {
    AppMethodBeat.i(55984);
    if (this.KgU == null)
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new MMHandler());
          VolumeMeter.this.fVo();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.KgU.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.KgR != null)
    {
      arrayOfInt = new int[2];
      this.KgR.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.KgS < 0) || (this.KgT < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.KgR.getWidth();
      int j = this.KgR.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
        this.KgS = (arrayOfInt[0] + i / 2);
        this.KgT = (arrayOfInt[1] + j / 2 - k / 2);
        this.Khf = (i / 2);
        this.Khe = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.KgZ);
    this.paint.setAlpha(this.Kha);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.Khe) {
      f1 = this.Khe;
    }
    f2 = f1;
    if (f1 < this.Khf) {
      f2 = this.Khf;
    }
    paramCanvas.drawCircle(this.KgS, this.KgT, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.KgV = 0.0F;
    this.KgW = 0.0F;
    this.KgX = 0.0F;
    this.KgY = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.oCI)
    {
      f2 = this.KgX;
      if (this.KgW <= this.KgV) {
        break label147;
      }
      f3 = (this.KgW - this.KgV) / this.Khh;
      if (f3 <= this.Khb) {
        break label128;
      }
      f1 = this.Khb;
      f1 += f2;
    }
    for (;;)
    {
      this.KgX = f1;
      this.KgY = this.KgX;
      this.radius = ((float)(260.0D * Math.sqrt(this.KgX) - 130.0F * this.KgX) / 1.5F);
      postInvalidate();
      this.KgU.postDelayed(this, this.Khd);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.Khc) {
        break;
      }
      f1 = this.Khc;
      break;
      label147:
      if (this.KgW <= this.KgV)
      {
        f3 = (this.KgV - this.KgW) / this.Khg;
        if (f3 > this.Khb) {
          f1 = this.Khb;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.Khc) {
            f1 = this.Khc;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.KgR = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.KgV = this.KgW;
    this.KgW = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */