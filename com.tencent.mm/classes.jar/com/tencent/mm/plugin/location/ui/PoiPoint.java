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
import com.tencent.mm.ui.ao;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  RectF cbB;
  private Context context;
  private int position;
  d sQM;
  boolean sQO;
  private Paint sRd;
  private int sRe;
  private Paint sRf;
  private int sRg;
  private Paint sRh;
  private int sRi;
  private Paint sRj;
  private int sRk;
  private ValueAnimator sRl;
  private ValueAnimator sRm;
  private ValueAnimator sRn;
  private double sRo;
  private double sRp;
  private int sRq;
  private int sRr;
  private float sRs;
  PoiPoint.b sRt;
  a sRu;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.sQO = false;
    this.cbB = new RectF();
    this.sRt = PoiPoint.b.sRx;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.sQO = false;
    this.cbB = new RectF();
    this.sRt = PoiPoint.b.sRx;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.sQO = false;
    this.cbB = new RectF();
    this.sRt = PoiPoint.b.sRx;
    this.sQM = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.sRd = new Paint(1);
    this.sRd.setColor(-1);
    this.sRe = ao.fromDPToPix(paramContext, 12);
    this.sRf = new Paint(1);
    this.sRf.setColor(paramContext.getResources().getColor(2131101171));
    int i = ao.fromDPToPix(paramContext, 8);
    int j = ao.fromDPToPix(paramContext, 16);
    this.sRg = i;
    this.sRh = new Paint(1);
    this.sRh.setColor(-1);
    int k = ao.fromDPToPix(paramContext, 7);
    this.sRi = 0;
    this.sRj = new Paint(1);
    this.sRj.setColor(paramContext.getResources().getColor(2131101171));
    this.sRj.setStrokeWidth(ao.fromDPToPix(paramContext, 4));
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
          ad.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
          PoiPoint.a(PoiPoint.this, i);
        }
        for (;;)
        {
          paramAnonymousValueAnimator = PoiPoint.this;
          if (paramAnonymousValueAnimator.sQO) {
            paramAnonymousValueAnimator.sQM.updateMarkerView(paramAnonymousValueAnimator);
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
    this.sRl = ValueAnimator.ofInt(new int[] { i, j });
    this.sRl.setDuration(300L);
    this.sRl.addUpdateListener(local1);
    this.sRm = ValueAnimator.ofInt(new int[] { 0, k });
    this.sRm.setDuration(300L);
    this.sRm.addUpdateListener(local1);
    this.sRn = ValueAnimator.ofInt(new int[] { 0, m });
    this.sRn.setDuration(300L);
    this.sRn.addUpdateListener(local1);
    this.sRn.setStartDelay(100L);
    this.sRq = ao.fromDPToPix(paramContext, 1);
    this.sRr = ao.fromDPToPix(paramContext, 4);
    this.sRs = (ao.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.sQO)
    {
      this.sQO = true;
      this.sRo = paramDouble1;
      this.sRp = paramDouble2;
      this.sQM.addPinView(this, paramDouble1, paramDouble2);
      this.sQM.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          ad.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.sRu != null)
          {
            PoiPoint.this.sRu.a(PoiPoint.this.sRt, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        cJI();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void cJH()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.sRw == this.sRt)
    {
      this.sRt = PoiPoint.b.sRx;
      this.sRl.reverse();
      this.sRm.reverse();
      this.sRn.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void cJI()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.sRx == this.sRt)
    {
      this.sRt = PoiPoint.b.sRw;
      this.sRl.start();
      this.sRm.start();
      this.sRn.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.sRo;
  }
  
  public double getLng()
  {
    return this.sRp;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    ad.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.sRg) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.sRk;
    if ((PoiPoint.b.sRx == this.sRt) && (0.0F == this.sRl.getAnimatedFraction()))
    {
      ad.i("MicroMsg.PoiPoint", "draw shade.");
      this.sRd.setShadowLayer(ao.fromDPToPix(this.context, 1), 0.0F, this.sRq, this.context.getResources().getColor(2131099656));
    }
    paramCanvas.drawCircle(i, f, this.sRe, this.sRd);
    paramCanvas.drawCircle(i, f, this.sRg, this.sRf);
    paramCanvas.drawCircle(i, f, this.sRi, this.sRh);
    this.cbB.set(i - this.sRr / 2.0F, this.sRg + f - this.sRs, i + this.sRr / 2.0F, f + this.sRg + this.sRk);
    paramCanvas.drawRoundRect(this.cbB, this.sRs, this.sRs, this.sRj);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = ao.fromDPToPix(this.context, 32);
    paramInt2 = ao.fromDPToPix(this.context, 52);
    ad.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.sQO) {
      this.sQM.removeView(this);
    }
    this.sQO = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.sRu = parama;
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