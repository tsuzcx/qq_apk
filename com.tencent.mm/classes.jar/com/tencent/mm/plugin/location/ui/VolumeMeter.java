package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  boolean iTN;
  private Context mContext;
  private Paint paint;
  private float radius;
  private int yKA;
  private int yKB;
  private float yKC;
  private float yKD;
  private int yKE;
  private float yKF;
  private float yKG;
  private float yKH;
  private float yKI;
  public Runnable yKJ;
  boolean yKr;
  private View yKs;
  private int yKt;
  private int yKu;
  public MMHandler yKv;
  private float yKw;
  private float yKx;
  private float yKy;
  private float yKz;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.iTN = false;
    this.yKr = false;
    this.yKt = -1;
    this.yKu = -1;
    this.yKv = null;
    this.yKA = -6751336;
    this.yKB = 70;
    this.yKC = 0.5F;
    this.yKD = 0.001F;
    this.yKE = 20;
    this.radius = 0.0F;
    this.yKH = 40.0F;
    this.yKI = 30.0F;
    this.yKJ = new Runnable()
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
    this.iTN = false;
    this.yKr = false;
    this.yKt = -1;
    this.yKu = -1;
    this.yKv = null;
    this.yKA = -6751336;
    this.yKB = 70;
    this.yKC = 0.5F;
    this.yKD = 0.001F;
    this.yKE = 20;
    this.radius = 0.0F;
    this.yKH = 40.0F;
    this.yKI = 30.0F;
    this.yKJ = new Runnable()
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
  
  public final void edB()
  {
    AppMethodBeat.i(55984);
    if (this.yKv == null)
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new MMHandler());
          VolumeMeter.this.edB();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.yKv.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.yKs != null)
    {
      arrayOfInt = new int[2];
      this.yKs.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.yKt < 0) || (this.yKu < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.yKs.getWidth();
      int j = this.yKs.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
        this.yKt = (arrayOfInt[0] + i / 2);
        this.yKu = (arrayOfInt[1] + j / 2 - k / 2);
        this.yKG = (i / 2);
        this.yKF = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.yKA);
    this.paint.setAlpha(this.yKB);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.yKF) {
      f1 = this.yKF;
    }
    f2 = f1;
    if (f1 < this.yKG) {
      f2 = this.yKG;
    }
    paramCanvas.drawCircle(this.yKt, this.yKu, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.yKw = 0.0F;
    this.yKx = 0.0F;
    this.yKy = 0.0F;
    this.yKz = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.iTN)
    {
      f2 = this.yKy;
      if (this.yKx <= this.yKw) {
        break label147;
      }
      f3 = (this.yKx - this.yKw) / this.yKI;
      if (f3 <= this.yKC) {
        break label128;
      }
      f1 = this.yKC;
      f1 += f2;
    }
    for (;;)
    {
      this.yKy = f1;
      this.yKz = this.yKy;
      this.radius = ((float)(260.0D * Math.sqrt(this.yKy) - 130.0F * this.yKy) / 1.5F);
      postInvalidate();
      this.yKv.postDelayed(this, this.yKE);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.yKD) {
        break;
      }
      f1 = this.yKD;
      break;
      label147:
      if (this.yKx <= this.yKw)
      {
        f3 = (this.yKw - this.yKx) / this.yKH;
        if (f3 > this.yKC) {
          f1 = this.yKC;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.yKD) {
            f1 = this.yKD;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.yKs = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.yKw = this.yKx;
    this.yKx = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */