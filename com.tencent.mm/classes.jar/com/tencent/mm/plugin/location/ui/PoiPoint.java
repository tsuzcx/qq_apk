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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  RectF ciS;
  private Context context;
  private int position;
  d vnT;
  boolean vnV;
  PoiPoint.b voA;
  a voB;
  private Paint vok;
  private int vol;
  private Paint vom;
  private int von;
  private Paint voo;
  private int vop;
  private Paint voq;
  private int vor;
  private ValueAnimator vos;
  private ValueAnimator vot;
  private ValueAnimator vou;
  private double vov;
  private double vow;
  private int vox;
  private int voy;
  private float voz;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.vnV = false;
    this.ciS = new RectF();
    this.voA = PoiPoint.b.voE;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.vnV = false;
    this.ciS = new RectF();
    this.voA = PoiPoint.b.voE;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.vnV = false;
    this.ciS = new RectF();
    this.voA = PoiPoint.b.voE;
    this.vnT = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.vok = new Paint(1);
    this.vok.setColor(-1);
    this.vol = aq.fromDPToPix(paramContext, 12);
    this.vom = new Paint(1);
    this.vom.setColor(paramContext.getResources().getColor(2131101171));
    int i = aq.fromDPToPix(paramContext, 8);
    int j = aq.fromDPToPix(paramContext, 16);
    this.von = i;
    this.voo = new Paint(1);
    this.voo.setColor(-1);
    int k = aq.fromDPToPix(paramContext, 7);
    this.vop = 0;
    this.voq = new Paint(1);
    this.voq.setColor(paramContext.getResources().getColor(2131101171));
    this.voq.setStrokeWidth(aq.fromDPToPix(paramContext, 4));
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
          ae.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
          PoiPoint.a(PoiPoint.this, i);
        }
        for (;;)
        {
          paramAnonymousValueAnimator = PoiPoint.this;
          if (paramAnonymousValueAnimator.vnV) {
            paramAnonymousValueAnimator.vnT.updateMarkerView(paramAnonymousValueAnimator);
          }
          AppMethodBeat.o(55857);
          return;
          if (paramAnonymousValueAnimator == PoiPoint.b(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ae.i("MicroMsg.PoiPoint", "whiteRadiusChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.b(PoiPoint.this, i);
          }
          else if (paramAnonymousValueAnimator == PoiPoint.c(PoiPoint.this))
          {
            i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ae.i("MicroMsg.PoiPoint", "greenLineChangeAnim, val: %s.", new Object[] { Integer.valueOf(i) });
            PoiPoint.c(PoiPoint.this, i);
          }
        }
      }
    };
    this.vos = ValueAnimator.ofInt(new int[] { i, j });
    this.vos.setDuration(300L);
    this.vos.addUpdateListener(local1);
    this.vot = ValueAnimator.ofInt(new int[] { 0, k });
    this.vot.setDuration(300L);
    this.vot.addUpdateListener(local1);
    this.vou = ValueAnimator.ofInt(new int[] { 0, m });
    this.vou.setDuration(300L);
    this.vou.addUpdateListener(local1);
    this.vou.setStartDelay(100L);
    this.vox = aq.fromDPToPix(paramContext, 1);
    this.voy = aq.fromDPToPix(paramContext, 4);
    this.voz = (aq.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.vnV)
    {
      this.vnV = true;
      this.vov = paramDouble1;
      this.vow = paramDouble2;
      this.vnT.addPinView(this, paramDouble1, paramDouble2);
      this.vnT.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          ae.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.voB != null)
          {
            PoiPoint.this.voB.a(PoiPoint.this.voA, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        djy();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void djx()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.voD == this.voA)
    {
      this.voA = PoiPoint.b.voE;
      this.vos.reverse();
      this.vot.reverse();
      this.vou.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void djy()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.voE == this.voA)
    {
      this.voA = PoiPoint.b.voD;
      this.vos.start();
      this.vot.start();
      this.vou.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.vov;
  }
  
  public double getLng()
  {
    return this.vow;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    ae.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.von) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.vor;
    if ((PoiPoint.b.voE == this.voA) && (0.0F == this.vos.getAnimatedFraction()))
    {
      ae.i("MicroMsg.PoiPoint", "draw shade.");
      this.vok.setShadowLayer(aq.fromDPToPix(this.context, 1), 0.0F, this.vox, this.context.getResources().getColor(2131099656));
    }
    paramCanvas.drawCircle(i, f, this.vol, this.vok);
    paramCanvas.drawCircle(i, f, this.von, this.vom);
    paramCanvas.drawCircle(i, f, this.vop, this.voo);
    this.ciS.set(i - this.voy / 2.0F, this.von + f - this.voz, i + this.voy / 2.0F, f + this.von + this.vor);
    paramCanvas.drawRoundRect(this.ciS, this.voz, this.voz, this.voq);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = aq.fromDPToPix(this.context, 32);
    paramInt2 = aq.fromDPToPix(this.context, 52);
    ae.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.vnV) {
      this.vnT.removeView(this);
    }
    this.vnV = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.voB = parama;
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