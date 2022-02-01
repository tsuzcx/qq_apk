package com.tencent.mm.plugin.location.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  private int AMY;
  private Paint KeD;
  private int KeE;
  private Paint KeF;
  private int KeG;
  private Paint KeH;
  private int KeI;
  private Paint KeJ;
  private int KeK;
  private ValueAnimator KeL;
  private ValueAnimator KeM;
  private ValueAnimator KeN;
  private double KeO;
  private double KeP;
  private int KeQ;
  private float KeR;
  PoiPoint.b KeS;
  a KeT;
  d Kem;
  boolean Keo;
  private Context context;
  RectF ekW;
  private int position;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.Keo = false;
    this.ekW = new RectF();
    this.KeS = PoiPoint.b.KeW;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.Keo = false;
    this.ekW = new RectF();
    this.KeS = PoiPoint.b.KeW;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.Keo = false;
    this.ekW = new RectF();
    this.KeS = PoiPoint.b.KeW;
    this.Kem = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.KeD = new Paint(1);
    this.KeD.setColor(-1);
    this.KeE = bd.fromDPToPix(paramContext, 12);
    this.KeF = new Paint(1);
    this.KeF.setColor(paramContext.getResources().getColor(a.b.wechat_green));
    int i = bd.fromDPToPix(paramContext, 8);
    int j = bd.fromDPToPix(paramContext, 16);
    this.KeG = i;
    this.KeH = new Paint(1);
    this.KeH.setColor(-1);
    int k = bd.fromDPToPix(paramContext, 7);
    this.KeI = 0;
    this.KeJ = new Paint(1);
    this.KeJ.setColor(paramContext.getResources().getColor(a.b.wechat_green));
    this.KeJ.setStrokeWidth(bd.fromDPToPix(paramContext, 4));
    int m = bd.fromDPToPix(paramContext, 20);
    ValueAnimator.AnimatorUpdateListener local1 = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(55857);
        int i;
        if (paramAnonymousValueAnimator == PoiPoint.a(PoiPoint.this))
        {
          i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          Log.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
          PoiPoint.a(PoiPoint.this, i);
        }
        for (;;)
        {
          paramAnonymousValueAnimator = PoiPoint.this;
          if (paramAnonymousValueAnimator.Keo) {
            paramAnonymousValueAnimator.Kem.updateMarkerView(paramAnonymousValueAnimator);
          }
          AppMethodBeat.o(55857);
          return;
          if (paramAnonymousValueAnimator == PoiPoint.b(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            Log.i("MicroMsg.PoiPoint", "whiteRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.b(PoiPoint.this, i);
          }
          else if (paramAnonymousValueAnimator == PoiPoint.c(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            Log.i("MicroMsg.PoiPoint", "greenLineChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.c(PoiPoint.this, i);
          }
        }
      }
    };
    this.KeL = ValueAnimator.ofInt(new int[] { i, j });
    this.KeL.setDuration(300L);
    this.KeL.addUpdateListener(local1);
    this.KeM = ValueAnimator.ofInt(new int[] { 0, k });
    this.KeM.setDuration(300L);
    this.KeM.addUpdateListener(local1);
    this.KeN = ValueAnimator.ofInt(new int[] { 0, m });
    this.KeN.setDuration(300L);
    this.KeN.addUpdateListener(local1);
    this.KeN.setStartDelay(100L);
    this.KeQ = bd.fromDPToPix(paramContext, 1);
    this.AMY = bd.fromDPToPix(paramContext, 4);
    this.KeR = (bd.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void d(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.Keo)
    {
      this.Keo = true;
      this.KeO = paramDouble1;
      this.KeP = paramDouble2;
      this.Kem.addPinView(this, paramDouble1, paramDouble2);
      this.Kem.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          Log.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.KeT != null)
          {
            PoiPoint.this.KeT.a(PoiPoint.this.KeS, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        fUV();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void fUU()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.KeV == this.KeS)
    {
      this.KeS = PoiPoint.b.KeW;
      this.KeL.reverse();
      this.KeM.reverse();
      this.KeN.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void fUV()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.KeW == this.KeS)
    {
      this.KeS = PoiPoint.b.KeV;
      this.KeL.start();
      this.KeM.start();
      this.KeN.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.KeO;
  }
  
  public double getLng()
  {
    return this.KeP;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    Log.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.KeG) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.KeK;
    if ((PoiPoint.b.KeW == this.KeS) && (0.0F == this.KeL.getAnimatedFraction()))
    {
      Log.i("MicroMsg.PoiPoint", "draw shade.");
      this.KeD.setShadowLayer(bd.fromDPToPix(this.context, 1), 0.0F, this.KeQ, this.context.getResources().getColor(a.b.BW_0_Alpha_0_1));
    }
    paramCanvas.drawCircle(i, f, this.KeE, this.KeD);
    paramCanvas.drawCircle(i, f, this.KeG, this.KeF);
    paramCanvas.drawCircle(i, f, this.KeI, this.KeH);
    this.ekW.set(i - this.AMY / 2.0F, this.KeG + f - this.KeR, i + this.AMY / 2.0F, f + this.KeG + this.KeK);
    paramCanvas.drawRoundRect(this.ekW, this.KeR, this.KeR, this.KeJ);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = bd.fromDPToPix(this.context, 32);
    paramInt2 = bd.fromDPToPix(this.context, 52);
    Log.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.Keo) {
      this.Kem.removeView(this);
    }
    this.Keo = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.KeT = parama;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(PoiPoint.b paramb, PoiPoint paramPoiPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiPoint
 * JD-Core Version:    0.7.0.1
 */