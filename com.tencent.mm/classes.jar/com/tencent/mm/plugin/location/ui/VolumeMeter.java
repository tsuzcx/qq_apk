package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  private float EoA;
  private float EoB;
  public Runnable EoC;
  boolean Eok;
  private View Eol;
  private int Eom;
  private int Eon;
  public MMHandler Eoo;
  private float Eop;
  private float Eoq;
  private float Eor;
  private float Eos;
  private int Eot;
  private int Eou;
  private float Eov;
  private float Eow;
  private int Eox;
  private float Eoy;
  private float Eoz;
  boolean lKg;
  private Context mContext;
  private Paint paint;
  private float radius;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55987);
    this.lKg = false;
    this.Eok = false;
    this.Eom = -1;
    this.Eon = -1;
    this.Eoo = null;
    this.Eot = -6751336;
    this.Eou = 70;
    this.Eov = 0.5F;
    this.Eow = 0.001F;
    this.Eox = 20;
    this.radius = 0.0F;
    this.EoA = 40.0F;
    this.EoB = 30.0F;
    this.EoC = new Runnable()
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
    this.lKg = false;
    this.Eok = false;
    this.Eom = -1;
    this.Eon = -1;
    this.Eoo = null;
    this.Eot = -6751336;
    this.Eou = 70;
    this.Eov = 0.5F;
    this.Eow = 0.001F;
    this.Eox = 20;
    this.radius = 0.0F;
    this.EoA = 40.0F;
    this.EoB = 30.0F;
    this.EoC = new Runnable()
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
  
  public final void eMV()
  {
    AppMethodBeat.i(55984);
    if (this.Eoo == null)
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55981);
          VolumeMeter.a(VolumeMeter.this, new MMHandler());
          VolumeMeter.this.eMV();
          AppMethodBeat.o(55981);
        }
      }, 100L);
      AppMethodBeat.o(55984);
      return;
    }
    this.Eoo.post(this);
    AppMethodBeat.o(55984);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55989);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.Eol != null)
    {
      arrayOfInt = new int[2];
      this.Eol.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label75;
      }
    }
    while ((this.Eom < 0) || (this.Eon < 0))
    {
      AppMethodBeat.o(55989);
      return;
      label75:
      int i = this.Eol.getWidth();
      int j = this.Eol.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
        this.Eom = (arrayOfInt[0] + i / 2);
        this.Eon = (arrayOfInt[1] + j / 2 - k / 2);
        this.Eoz = (i / 2);
        this.Eoy = (i / 2 * 2.0F);
      }
    }
    this.paint.setColor(this.Eot);
    this.paint.setAlpha(this.Eou);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.Eoy) {
      f1 = this.Eoy;
    }
    f2 = f1;
    if (f1 < this.Eoz) {
      f2 = this.Eoz;
    }
    paramCanvas.drawCircle(this.Eom, this.Eon, f2, this.paint);
    AppMethodBeat.o(55989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55990);
    this.radius = 0.0F;
    this.Eop = 0.0F;
    this.Eoq = 0.0F;
    this.Eor = 0.0F;
    this.Eos = 0.0F;
    postInvalidate();
    AppMethodBeat.o(55990);
  }
  
  public void run()
  {
    AppMethodBeat.i(55985);
    float f2;
    float f3;
    float f1;
    if (this.lKg)
    {
      f2 = this.Eor;
      if (this.Eoq <= this.Eop) {
        break label147;
      }
      f3 = (this.Eoq - this.Eop) / this.EoB;
      if (f3 <= this.Eov) {
        break label128;
      }
      f1 = this.Eov;
      f1 += f2;
    }
    for (;;)
    {
      this.Eor = f1;
      this.Eos = this.Eor;
      this.radius = ((float)(260.0D * Math.sqrt(this.Eor) - 130.0F * this.Eor) / 1.5F);
      postInvalidate();
      this.Eoo.postDelayed(this, this.Eox);
      AppMethodBeat.o(55985);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.Eow) {
        break;
      }
      f1 = this.Eow;
      break;
      label147:
      if (this.Eoq <= this.Eop)
      {
        f3 = (this.Eop - this.Eoq) / this.EoA;
        if (f3 > this.Eov) {
          f1 = this.Eov;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.Eow) {
            f1 = this.Eow;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.Eol = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.Eop = this.Eoq;
    this.Eoq = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */