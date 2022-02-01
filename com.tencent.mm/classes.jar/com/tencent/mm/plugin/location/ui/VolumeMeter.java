package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  boolean hcP;
  private Context mContext;
  private Paint paint;
  private float radius;
  private float sTA;
  private float sTB;
  private float sTC;
  private float sTD;
  private int sTE;
  private int sTF;
  private float sTG;
  private float sTH;
  private int sTI;
  private float sTJ;
  private float sTK;
  private float sTL;
  private float sTM;
  public Runnable sTN;
  boolean sTv;
  private View sTw;
  private int sTx;
  private int sTy;
  public ap sTz;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.hcP = false;
    this.sTv = false;
    this.sTx = -1;
    this.sTy = -1;
    this.sTz = null;
    this.sTE = -6751336;
    this.sTF = 70;
    this.sTG = 0.5F;
    this.sTH = 0.001F;
    this.sTI = 20;
    this.radius = 0.0F;
    this.sTL = 40.0F;
    this.sTM = 30.0F;
    this.sTN = new Runnable()
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
    this.hcP = false;
    this.sTv = false;
    this.sTx = -1;
    this.sTy = -1;
    this.sTz = null;
    this.sTE = -6751336;
    this.sTF = 70;
    this.sTG = 0.5F;
    this.sTH = 0.001F;
    this.sTI = 20;
    this.radius = 0.0F;
    this.sTL = 40.0F;
    this.sTM = 30.0F;
    this.sTN = new Runnable()
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
  
  public final void cKa()
  {
    AppMethodBeat.i(55984);
    if (this.sTz == null)
    {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new ap());
          VolumeMeter.this.cKa();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.sTz.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.sTw != null)
    {
      arrayOfInt = new int[2];
      this.sTw.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.sTx < 0) || (this.sTy < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.sTw.getWidth();
      int j = this.sTw.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.b.g(this.mContext, 50.0F);
        this.sTx = (arrayOfInt[0] + i / 2);
        this.sTy = (arrayOfInt[1] + j / 2 - k / 2);
        this.sTK = (i / 2);
        this.sTJ = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.sTE);
    this.paint.setAlpha(this.sTF);
    float f2 = BackwardSupportUtil.b.g(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.sTJ) {
      f1 = this.sTJ;
    }
    f2 = f1;
    if (f1 < this.sTK) {
      f2 = this.sTK;
    }
    paramCanvas.drawCircle(this.sTx, this.sTy, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.sTA = 0.0F;
    this.sTB = 0.0F;
    this.sTC = 0.0F;
    this.sTD = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.hcP)
    {
      f2 = this.sTC;
      if (this.sTB <= this.sTA) {
        break label147;
      }
      f3 = (this.sTB - this.sTA) / this.sTM;
      if (f3 <= this.sTG) {
        break label128;
      }
      f1 = this.sTG;
      f1 += f2;
    }
    for (;;)
    {
      this.sTC = f1;
      this.sTD = this.sTC;
      this.radius = ((float)(260.0D * Math.sqrt(this.sTC) - 130.0F * this.sTC) / 1.5F);
      postInvalidate();
      this.sTz.postDelayed(this, this.sTI);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.sTH) {
        break;
      }
      f1 = this.sTH;
      break;
      label147:
      if (this.sTB <= this.sTA)
      {
        f3 = (this.sTA - this.sTB) / this.sTL;
        if (f3 > this.sTG) {
          f1 = this.sTG;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.sTH) {
            f1 = this.sTH;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.sTw = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.sTA = this.sTB;
    this.sTB = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */