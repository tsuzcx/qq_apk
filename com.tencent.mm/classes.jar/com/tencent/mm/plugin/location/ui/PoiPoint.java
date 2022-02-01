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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  RectF ciQ;
  private Context context;
  private int position;
  d vbI;
  boolean vbK;
  private Paint vbZ;
  private int vca;
  private Paint vcb;
  private int vcc;
  private Paint vcd;
  private int vce;
  private Paint vcf;
  private int vcg;
  private ValueAnimator vch;
  private ValueAnimator vci;
  private ValueAnimator vcj;
  private double vck;
  private double vcl;
  private int vcm;
  private int vcn;
  private float vco;
  PoiPoint.b vcp;
  a vcq;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.vbK = false;
    this.ciQ = new RectF();
    this.vcp = PoiPoint.b.vct;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.vbK = false;
    this.ciQ = new RectF();
    this.vcp = PoiPoint.b.vct;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.vbK = false;
    this.ciQ = new RectF();
    this.vcp = PoiPoint.b.vct;
    this.vbI = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.vbZ = new Paint(1);
    this.vbZ.setColor(-1);
    this.vca = aq.fromDPToPix(paramContext, 12);
    this.vcb = new Paint(1);
    this.vcb.setColor(paramContext.getResources().getColor(2131101171));
    int i = aq.fromDPToPix(paramContext, 8);
    int j = aq.fromDPToPix(paramContext, 16);
    this.vcc = i;
    this.vcd = new Paint(1);
    this.vcd.setColor(-1);
    int k = aq.fromDPToPix(paramContext, 7);
    this.vce = 0;
    this.vcf = new Paint(1);
    this.vcf.setColor(paramContext.getResources().getColor(2131101171));
    this.vcf.setStrokeWidth(aq.fromDPToPix(paramContext, 4));
    int m = aq.fromDPToPix(paramContext, 20);
    ValueAnimator.AnimatorUpdateListener local1 = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(55857);
        int i;
        if (paramAnonymousValueAnimator == PoiPoint.a(PoiPoint.this))
        {
          i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ad.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
          PoiPoint.a(PoiPoint.this, i);
        }
        for (;;)
        {
          paramAnonymousValueAnimator = PoiPoint.this;
          if (paramAnonymousValueAnimator.vbK) {
            paramAnonymousValueAnimator.vbI.updateMarkerView(paramAnonymousValueAnimator);
          }
          AppMethodBeat.o(55857);
          return;
          if (paramAnonymousValueAnimator == PoiPoint.b(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ad.i("MicroMsg.PoiPoint", "whiteRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.b(PoiPoint.this, i);
          }
          else if (paramAnonymousValueAnimator == PoiPoint.c(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ad.i("MicroMsg.PoiPoint", "greenLineChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.c(PoiPoint.this, i);
          }
        }
      }
    };
    this.vch = ValueAnimator.ofInt(new int[] { i, j });
    this.vch.setDuration(300L);
    this.vch.addUpdateListener(local1);
    this.vci = ValueAnimator.ofInt(new int[] { 0, k });
    this.vci.setDuration(300L);
    this.vci.addUpdateListener(local1);
    this.vcj = ValueAnimator.ofInt(new int[] { 0, m });
    this.vcj.setDuration(300L);
    this.vcj.addUpdateListener(local1);
    this.vcj.setStartDelay(100L);
    this.vcm = aq.fromDPToPix(paramContext, 1);
    this.vcn = aq.fromDPToPix(paramContext, 4);
    this.vco = (aq.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.vbK)
    {
      this.vbK = true;
      this.vck = paramDouble1;
      this.vcl = paramDouble2;
      this.vbI.addPinView(this, paramDouble1, paramDouble2);
      this.vbI.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          ad.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.vcq != null)
          {
            PoiPoint.this.vcq.a(PoiPoint.this.vcp, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        dgz();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void dgy()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.vcs == this.vcp)
    {
      this.vcp = PoiPoint.b.vct;
      this.vch.reverse();
      this.vci.reverse();
      this.vcj.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void dgz()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.vct == this.vcp)
    {
      this.vcp = PoiPoint.b.vcs;
      this.vch.start();
      this.vci.start();
      this.vcj.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.vck;
  }
  
  public double getLng()
  {
    return this.vcl;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    ad.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.vcc) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.vcg;
    if ((PoiPoint.b.vct == this.vcp) && (0.0F == this.vch.getAnimatedFraction()))
    {
      ad.i("MicroMsg.PoiPoint", "draw shade.");
      this.vbZ.setShadowLayer(aq.fromDPToPix(this.context, 1), 0.0F, this.vcm, this.context.getResources().getColor(2131099656));
    }
    paramCanvas.drawCircle(i, f, this.vca, this.vbZ);
    paramCanvas.drawCircle(i, f, this.vcc, this.vcb);
    paramCanvas.drawCircle(i, f, this.vce, this.vcd);
    this.ciQ.set(i - this.vcn / 2.0F, this.vcc + f - this.vco, i + this.vcn / 2.0F, f + this.vcc + this.vcg);
    paramCanvas.drawRoundRect(this.ciQ, this.vco, this.vco, this.vcf);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = aq.fromDPToPix(this.context, 32);
    paramInt2 = aq.fromDPToPix(this.context, 52);
    ad.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.vbK) {
      this.vbI.removeView(this);
    }
    this.vbK = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.vcq = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiPoint
 * JD-Core Version:    0.7.0.1
 */