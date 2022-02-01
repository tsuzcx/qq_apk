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
import com.tencent.mm.sdk.platformtools.ao;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  boolean hDs;
  private Context mContext;
  private Paint paint;
  private float radius;
  boolean ubH;
  private View ubI;
  private int ubJ;
  private int ubK;
  public ao ubL;
  private float ubM;
  private float ubN;
  private float ubO;
  private float ubP;
  private int ubQ;
  private int ubR;
  private float ubS;
  private float ubT;
  private int ubU;
  private float ubV;
  private float ubW;
  private float ubX;
  private float ubY;
  public Runnable ubZ;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.hDs = false;
    this.ubH = false;
    this.ubJ = -1;
    this.ubK = -1;
    this.ubL = null;
    this.ubQ = -6751336;
    this.ubR = 70;
    this.ubS = 0.5F;
    this.ubT = 0.001F;
    this.ubU = 20;
    this.radius = 0.0F;
    this.ubX = 40.0F;
    this.ubY = 30.0F;
    this.ubZ = new Runnable()
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
    this.hDs = false;
    this.ubH = false;
    this.ubJ = -1;
    this.ubK = -1;
    this.ubL = null;
    this.ubQ = -6751336;
    this.ubR = 70;
    this.ubS = 0.5F;
    this.ubT = 0.001F;
    this.ubU = 20;
    this.radius = 0.0F;
    this.ubX = 40.0F;
    this.ubY = 30.0F;
    this.ubZ = new Runnable()
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
  
  public final void cXF()
  {
    AppMethodBeat.i(55984);
    if (this.ubL == null)
    {
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new ao());
          VolumeMeter.this.cXF();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.ubL.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.ubI != null)
    {
      arrayOfInt = new int[2];
      this.ubI.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.ubJ < 0) || (this.ubK < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.ubI.getWidth();
      int j = this.ubI.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.b.g(this.mContext, 50.0F);
        this.ubJ = (arrayOfInt[0] + i / 2);
        this.ubK = (arrayOfInt[1] + j / 2 - k / 2);
        this.ubW = (i / 2);
        this.ubV = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.ubQ);
    this.paint.setAlpha(this.ubR);
    float f2 = BackwardSupportUtil.b.g(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.ubV) {
      f1 = this.ubV;
    }
    f2 = f1;
    if (f1 < this.ubW) {
      f2 = this.ubW;
    }
    paramCanvas.drawCircle(this.ubJ, this.ubK, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.ubM = 0.0F;
    this.ubN = 0.0F;
    this.ubO = 0.0F;
    this.ubP = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.hDs)
    {
      f2 = this.ubO;
      if (this.ubN <= this.ubM) {
        break label147;
      }
      f3 = (this.ubN - this.ubM) / this.ubY;
      if (f3 <= this.ubS) {
        break label128;
      }
      f1 = this.ubS;
      f1 += f2;
    }
    for (;;)
    {
      this.ubO = f1;
      this.ubP = this.ubO;
      this.radius = ((float)(260.0D * Math.sqrt(this.ubO) - 130.0F * this.ubO) / 1.5F);
      postInvalidate();
      this.ubL.postDelayed(this, this.ubU);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.ubT) {
        break;
      }
      f1 = this.ubT;
      break;
      label147:
      if (this.ubN <= this.ubM)
      {
        f3 = (this.ubM - this.ubN) / this.ubX;
        if (f3 > this.ubS) {
          f1 = this.ubS;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.ubT) {
            f1 = this.ubT;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.ubI = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.ubM = this.ubN;
    this.ubN = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */