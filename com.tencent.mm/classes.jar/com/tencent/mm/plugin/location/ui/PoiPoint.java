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
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  RectF bYy;
  private Context context;
  private int position;
  d tYZ;
  private ValueAnimator tZA;
  private double tZB;
  private double tZC;
  private int tZD;
  private int tZE;
  private float tZF;
  PoiPoint.b tZG;
  a tZH;
  boolean tZb;
  private Paint tZq;
  private int tZr;
  private Paint tZs;
  private int tZt;
  private Paint tZu;
  private int tZv;
  private Paint tZw;
  private int tZx;
  private ValueAnimator tZy;
  private ValueAnimator tZz;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.tZb = false;
    this.bYy = new RectF();
    this.tZG = PoiPoint.b.tZK;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.tZb = false;
    this.bYy = new RectF();
    this.tZG = PoiPoint.b.tZK;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.tZb = false;
    this.bYy = new RectF();
    this.tZG = PoiPoint.b.tZK;
    this.tYZ = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.tZq = new Paint(1);
    this.tZq.setColor(-1);
    this.tZr = ao.fromDPToPix(paramContext, 12);
    this.tZs = new Paint(1);
    this.tZs.setColor(paramContext.getResources().getColor(2131101171));
    int i = ao.fromDPToPix(paramContext, 8);
    int j = ao.fromDPToPix(paramContext, 16);
    this.tZt = i;
    this.tZu = new Paint(1);
    this.tZu.setColor(-1);
    int k = ao.fromDPToPix(paramContext, 7);
    this.tZv = 0;
    this.tZw = new Paint(1);
    this.tZw.setColor(paramContext.getResources().getColor(2131101171));
    this.tZw.setStrokeWidth(ao.fromDPToPix(paramContext, 4));
    int m = ao.fromDPToPix(paramContext, 20);
    ValueAnimator.AnimatorUpdateListener local1 = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(55857);
        int i;
        if (paramAnonymousValueAnimator == PoiPoint.a(PoiPoint.this))
        {
          i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ac.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
          PoiPoint.a(PoiPoint.this, i);
        }
        for (;;)
        {
          paramAnonymousValueAnimator = PoiPoint.this;
          if (paramAnonymousValueAnimator.tZb) {
            paramAnonymousValueAnimator.tYZ.updateMarkerView(paramAnonymousValueAnimator);
          }
          AppMethodBeat.o(55857);
          return;
          if (paramAnonymousValueAnimator == PoiPoint.b(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ac.i("MicroMsg.PoiPoint", "whiteRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.b(PoiPoint.this, i);
          }
          else if (paramAnonymousValueAnimator == PoiPoint.c(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ac.i("MicroMsg.PoiPoint", "greenLineChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.c(PoiPoint.this, i);
          }
        }
      }
    };
    this.tZy = ValueAnimator.ofInt(new int[] { i, j });
    this.tZy.setDuration(300L);
    this.tZy.addUpdateListener(local1);
    this.tZz = ValueAnimator.ofInt(new int[] { 0, k });
    this.tZz.setDuration(300L);
    this.tZz.addUpdateListener(local1);
    this.tZA = ValueAnimator.ofInt(new int[] { 0, m });
    this.tZA.setDuration(300L);
    this.tZA.addUpdateListener(local1);
    this.tZA.setStartDelay(100L);
    this.tZD = ao.fromDPToPix(paramContext, 1);
    this.tZE = ao.fromDPToPix(paramContext, 4);
    this.tZF = (ao.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.tZb)
    {
      this.tZb = true;
      this.tZB = paramDouble1;
      this.tZC = paramDouble2;
      this.tYZ.addPinView(this, paramDouble1, paramDouble2);
      this.tYZ.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          ac.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.tZH != null)
          {
            PoiPoint.this.tZH.a(PoiPoint.this.tZG, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        cXn();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void cXm()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.tZJ == this.tZG)
    {
      this.tZG = PoiPoint.b.tZK;
      this.tZy.reverse();
      this.tZz.reverse();
      this.tZA.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void cXn()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.tZK == this.tZG)
    {
      this.tZG = PoiPoint.b.tZJ;
      this.tZy.start();
      this.tZz.start();
      this.tZA.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.tZB;
  }
  
  public double getLng()
  {
    return this.tZC;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    ac.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.tZt) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.tZx;
    if ((PoiPoint.b.tZK == this.tZG) && (0.0F == this.tZy.getAnimatedFraction()))
    {
      ac.i("MicroMsg.PoiPoint", "draw shade.");
      this.tZq.setShadowLayer(ao.fromDPToPix(this.context, 1), 0.0F, this.tZD, this.context.getResources().getColor(2131099656));
    }
    paramCanvas.drawCircle(i, f, this.tZr, this.tZq);
    paramCanvas.drawCircle(i, f, this.tZt, this.tZs);
    paramCanvas.drawCircle(i, f, this.tZv, this.tZu);
    this.bYy.set(i - this.tZE / 2.0F, this.tZt + f - this.tZF, i + this.tZE / 2.0F, f + this.tZt + this.tZx);
    paramCanvas.drawRoundRect(this.bYy, this.tZF, this.tZF, this.tZw);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = ao.fromDPToPix(this.context, 32);
    paramInt2 = ao.fromDPToPix(this.context, 52);
    ac.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.tZb) {
      this.tYZ.removeView(this);
    }
    this.tZb = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.tZH = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiPoint
 * JD-Core Version:    0.7.0.1
 */