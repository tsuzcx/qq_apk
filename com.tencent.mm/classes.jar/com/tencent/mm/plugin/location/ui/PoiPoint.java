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
import com.tencent.mm.plugin.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  d ElD;
  boolean ElF;
  private Paint ElU;
  private int ElV;
  private Paint ElW;
  private int ElX;
  private Paint ElY;
  private int ElZ;
  private Paint Ema;
  private int Emb;
  private ValueAnimator Emc;
  private ValueAnimator Emd;
  private ValueAnimator Eme;
  private double Emf;
  private double Emg;
  private int Emh;
  private float Emi;
  PoiPoint.b Emj;
  a Emk;
  private Context context;
  RectF ctb;
  private int position;
  private int xpS;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.ElF = false;
    this.ctb = new RectF();
    this.Emj = PoiPoint.b.Emn;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.ElF = false;
    this.ctb = new RectF();
    this.Emj = PoiPoint.b.Emn;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.ElF = false;
    this.ctb = new RectF();
    this.Emj = PoiPoint.b.Emn;
    this.ElD = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.ElU = new Paint(1);
    this.ElU.setColor(-1);
    this.ElV = aw.fromDPToPix(paramContext, 12);
    this.ElW = new Paint(1);
    this.ElW.setColor(paramContext.getResources().getColor(a.b.wechat_green));
    int i = aw.fromDPToPix(paramContext, 8);
    int j = aw.fromDPToPix(paramContext, 16);
    this.ElX = i;
    this.ElY = new Paint(1);
    this.ElY.setColor(-1);
    int k = aw.fromDPToPix(paramContext, 7);
    this.ElZ = 0;
    this.Ema = new Paint(1);
    this.Ema.setColor(paramContext.getResources().getColor(a.b.wechat_green));
    this.Ema.setStrokeWidth(aw.fromDPToPix(paramContext, 4));
    int m = aw.fromDPToPix(paramContext, 20);
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
          if (paramAnonymousValueAnimator.ElF) {
            paramAnonymousValueAnimator.ElD.updateMarkerView(paramAnonymousValueAnimator);
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
    this.Emc = ValueAnimator.ofInt(new int[] { i, j });
    this.Emc.setDuration(300L);
    this.Emc.addUpdateListener(local1);
    this.Emd = ValueAnimator.ofInt(new int[] { 0, k });
    this.Emd.setDuration(300L);
    this.Emd.addUpdateListener(local1);
    this.Eme = ValueAnimator.ofInt(new int[] { 0, m });
    this.Eme.setDuration(300L);
    this.Eme.addUpdateListener(local1);
    this.Eme.setStartDelay(100L);
    this.Emh = aw.fromDPToPix(paramContext, 1);
    this.xpS = aw.fromDPToPix(paramContext, 4);
    this.Emi = (aw.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.ElF)
    {
      this.ElF = true;
      this.Emf = paramDouble1;
      this.Emg = paramDouble2;
      this.ElD.addPinView(this, paramDouble1, paramDouble2);
      this.ElD.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          Log.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.Emk != null)
          {
            PoiPoint.this.Emk.a(PoiPoint.this.Emj, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        eMC();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void eMB()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.Emm == this.Emj)
    {
      this.Emj = PoiPoint.b.Emn;
      this.Emc.reverse();
      this.Emd.reverse();
      this.Eme.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void eMC()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.Emn == this.Emj)
    {
      this.Emj = PoiPoint.b.Emm;
      this.Emc.start();
      this.Emd.start();
      this.Eme.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.Emf;
  }
  
  public double getLng()
  {
    return this.Emg;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    Log.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.ElX) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.Emb;
    if ((PoiPoint.b.Emn == this.Emj) && (0.0F == this.Emc.getAnimatedFraction()))
    {
      Log.i("MicroMsg.PoiPoint", "draw shade.");
      this.ElU.setShadowLayer(aw.fromDPToPix(this.context, 1), 0.0F, this.Emh, this.context.getResources().getColor(a.b.BW_0_Alpha_0_1));
    }
    paramCanvas.drawCircle(i, f, this.ElV, this.ElU);
    paramCanvas.drawCircle(i, f, this.ElX, this.ElW);
    paramCanvas.drawCircle(i, f, this.ElZ, this.ElY);
    this.ctb.set(i - this.xpS / 2.0F, this.ElX + f - this.Emi, i + this.xpS / 2.0F, f + this.ElX + this.Emb);
    paramCanvas.drawRoundRect(this.ctb, this.Emi, this.Emi, this.Ema);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = aw.fromDPToPix(this.context, 32);
    paramInt2 = aw.fromDPToPix(this.context, 52);
    Log.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.ElF) {
      this.ElD.removeView(this);
    }
    this.ElF = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.Emk = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiPoint
 * JD-Core Version:    0.7.0.1
 */