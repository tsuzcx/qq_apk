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
  boolean hVX;
  private Context mContext;
  private Paint paint;
  private float radius;
  private int veA;
  private int veB;
  private float veC;
  private float veD;
  private int veE;
  private float veF;
  private float veG;
  private float veH;
  private float veI;
  public Runnable veJ;
  boolean veq;
  private View ves;
  private int vet;
  private int veu;
  public ap vev;
  private float vew;
  private float vex;
  private float vey;
  private float vez;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.hVX = false;
    this.veq = false;
    this.vet = -1;
    this.veu = -1;
    this.vev = null;
    this.veA = -6751336;
    this.veB = 70;
    this.veC = 0.5F;
    this.veD = 0.001F;
    this.veE = 20;
    this.radius = 0.0F;
    this.veH = 40.0F;
    this.veI = 30.0F;
    this.veJ = new Runnable()
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
    this.hVX = false;
    this.veq = false;
    this.vet = -1;
    this.veu = -1;
    this.vev = null;
    this.veA = -6751336;
    this.veB = 70;
    this.veC = 0.5F;
    this.veD = 0.001F;
    this.veE = 20;
    this.radius = 0.0F;
    this.veH = 40.0F;
    this.veI = 30.0F;
    this.veJ = new Runnable()
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
  
  public final void dgR()
  {
    AppMethodBeat.i(55984);
    if (this.vev == null)
    {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new ap());
          VolumeMeter.this.dgR();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.vev.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.ves != null)
    {
      arrayOfInt = new int[2];
      this.ves.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.vet < 0) || (this.veu < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.ves.getWidth();
      int j = this.ves.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.b.g(this.mContext, 50.0F);
        this.vet = (arrayOfInt[0] + i / 2);
        this.veu = (arrayOfInt[1] + j / 2 - k / 2);
        this.veG = (i / 2);
        this.veF = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.veA);
    this.paint.setAlpha(this.veB);
    float f2 = BackwardSupportUtil.b.g(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.veF) {
      f1 = this.veF;
    }
    f2 = f1;
    if (f1 < this.veG) {
      f2 = this.veG;
    }
    paramCanvas.drawCircle(this.vet, this.veu, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.vew = 0.0F;
    this.vex = 0.0F;
    this.vey = 0.0F;
    this.vez = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.hVX)
    {
      f2 = this.vey;
      if (this.vex <= this.vew) {
        break label147;
      }
      f3 = (this.vex - this.vew) / this.veI;
      if (f3 <= this.veC) {
        break label128;
      }
      f1 = this.veC;
      f1 += f2;
    }
    for (;;)
    {
      this.vey = f1;
      this.vez = this.vey;
      this.radius = ((float)(260.0D * Math.sqrt(this.vey) - 130.0F * this.vey) / 1.5F);
      postInvalidate();
      this.vev.postDelayed(this, this.veE);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.veD) {
        break;
      }
      f1 = this.veD;
      break;
      label147:
      if (this.vex <= this.vew)
      {
        f3 = (this.vew - this.vex) / this.veH;
        if (f3 > this.veC) {
          f1 = this.veC;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.veD) {
            f1 = this.veD;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.ves = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.vew = this.vex;
    this.vex = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */