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
import com.tencent.mm.sdk.platformtools.aq;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  boolean hYP;
  private Context mContext;
  private Paint paint;
  private float radius;
  boolean vqB;
  private View vqC;
  private int vqD;
  private int vqE;
  public aq vqF;
  private float vqG;
  private float vqH;
  private float vqI;
  private float vqJ;
  private int vqK;
  private int vqL;
  private float vqM;
  private float vqN;
  private int vqO;
  private float vqP;
  private float vqQ;
  private float vqR;
  private float vqS;
  public Runnable vqT;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.hYP = false;
    this.vqB = false;
    this.vqD = -1;
    this.vqE = -1;
    this.vqF = null;
    this.vqK = -6751336;
    this.vqL = 70;
    this.vqM = 0.5F;
    this.vqN = 0.001F;
    this.vqO = 20;
    this.radius = 0.0F;
    this.vqR = 40.0F;
    this.vqS = 30.0F;
    this.vqT = new Runnable()
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
    this.hYP = false;
    this.vqB = false;
    this.vqD = -1;
    this.vqE = -1;
    this.vqF = null;
    this.vqK = -6751336;
    this.vqL = 70;
    this.vqM = 0.5F;
    this.vqN = 0.001F;
    this.vqO = 20;
    this.radius = 0.0F;
    this.vqR = 40.0F;
    this.vqS = 30.0F;
    this.vqT = new Runnable()
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
  
  public final void djQ()
  {
    AppMethodBeat.i(55984);
    if (this.vqF == null)
    {
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new aq());
          VolumeMeter.this.djQ();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.vqF.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.vqC != null)
    {
      arrayOfInt = new int[2];
      this.vqC.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.vqD < 0) || (this.vqE < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.vqC.getWidth();
      int j = this.vqC.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.b.h(this.mContext, 50.0F);
        this.vqD = (arrayOfInt[0] + i / 2);
        this.vqE = (arrayOfInt[1] + j / 2 - k / 2);
        this.vqQ = (i / 2);
        this.vqP = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.vqK);
    this.paint.setAlpha(this.vqL);
    float f2 = BackwardSupportUtil.b.h(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.vqP) {
      f1 = this.vqP;
    }
    f2 = f1;
    if (f1 < this.vqQ) {
      f2 = this.vqQ;
    }
    paramCanvas.drawCircle(this.vqD, this.vqE, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.vqG = 0.0F;
    this.vqH = 0.0F;
    this.vqI = 0.0F;
    this.vqJ = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.hYP)
    {
      f2 = this.vqI;
      if (this.vqH <= this.vqG) {
        break label147;
      }
      f3 = (this.vqH - this.vqG) / this.vqS;
      if (f3 <= this.vqM) {
        break label128;
      }
      f1 = this.vqM;
      f1 += f2;
    }
    for (;;)
    {
      this.vqI = f1;
      this.vqJ = this.vqI;
      this.radius = ((float)(260.0D * Math.sqrt(this.vqI) - 130.0F * this.vqI) / 1.5F);
      postInvalidate();
      this.vqF.postDelayed(this, this.vqO);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.vqN) {
        break;
      }
      f1 = this.vqN;
      break;
      label147:
      if (this.vqH <= this.vqG)
      {
        f3 = (this.vqG - this.vqH) / this.vqR;
        if (f3 > this.vqM) {
          f1 = this.vqM;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.vqN) {
            f1 = this.vqN;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.vqC = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.vqG = this.vqH;
    this.vqH = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */