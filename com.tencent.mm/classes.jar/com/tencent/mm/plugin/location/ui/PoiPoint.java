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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

public class PoiPoint
  extends View
{
  private Context context;
  RectF cuN;
  private int position;
  private int tHg;
  d yHK;
  boolean yHM;
  private Paint yIb;
  private int yIc;
  private Paint yId;
  private int yIe;
  private Paint yIf;
  private int yIg;
  private Paint yIh;
  private int yIi;
  private ValueAnimator yIj;
  private ValueAnimator yIk;
  private ValueAnimator yIl;
  private double yIm;
  private double yIn;
  private int yIo;
  private float yIp;
  PoiPoint.b yIq;
  a yIr;
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55862);
    this.yHM = false;
    this.cuN = new RectF();
    this.yIq = PoiPoint.b.yIu;
    init(paramContext);
    AppMethodBeat.o(55862);
  }
  
  public PoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55863);
    this.yHM = false;
    this.cuN = new RectF();
    this.yIq = PoiPoint.b.yIu;
    init(paramContext);
    AppMethodBeat.o(55863);
  }
  
  public PoiPoint(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(55864);
    this.yHM = false;
    this.cuN = new RectF();
    this.yIq = PoiPoint.b.yIu;
    this.yHK = paramd;
    init(paramContext);
    AppMethodBeat.o(55864);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55865);
    setLayerType(1, null);
    this.context = paramContext;
    this.yIb = new Paint(1);
    this.yIb.setColor(-1);
    this.yIc = at.fromDPToPix(paramContext, 12);
    this.yId = new Paint(1);
    this.yId.setColor(paramContext.getResources().getColor(2131101414));
    int i = at.fromDPToPix(paramContext, 8);
    int j = at.fromDPToPix(paramContext, 16);
    this.yIe = i;
    this.yIf = new Paint(1);
    this.yIf.setColor(-1);
    int k = at.fromDPToPix(paramContext, 7);
    this.yIg = 0;
    this.yIh = new Paint(1);
    this.yIh.setColor(paramContext.getResources().getColor(2131101414));
    this.yIh.setStrokeWidth(at.fromDPToPix(paramContext, 4));
    int m = at.fromDPToPix(paramContext, 20);
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
          if (paramAnonymousValueAnimator.yHM) {
            paramAnonymousValueAnimator.yHK.updateMarkerView(paramAnonymousValueAnimator);
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
    this.yIj = ValueAnimator.ofInt(new int[] { i, j });
    this.yIj.setDuration(300L);
    this.yIj.addUpdateListener(local1);
    this.yIk = ValueAnimator.ofInt(new int[] { 0, k });
    this.yIk.setDuration(300L);
    this.yIk.addUpdateListener(local1);
    this.yIl = ValueAnimator.ofInt(new int[] { 0, m });
    this.yIl.setDuration(300L);
    this.yIl.addUpdateListener(local1);
    this.yIl.setStartDelay(100L);
    this.yIo = at.fromDPToPix(paramContext, 1);
    this.tHg = at.fromDPToPix(paramContext, 4);
    this.yIp = (at.getDensity(paramContext) * 2.5F);
    AppMethodBeat.o(55865);
  }
  
  public final void c(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(55870);
    if (!this.yHM)
    {
      this.yHM = true;
      this.yIm = paramDouble1;
      this.yIn = paramDouble2;
      this.yHK.addPinView(this, paramDouble1, paramDouble2);
      this.yHK.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener()
      {
        public final boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          AppMethodBeat.i(55858);
          Log.i("MicroMsg.PoiPoint", "onClick.");
          if (PoiPoint.this.yIr != null)
          {
            PoiPoint.this.yIr.a(PoiPoint.this.yIq, PoiPoint.this);
            AppMethodBeat.o(55858);
            return true;
          }
          AppMethodBeat.o(55858);
          return false;
        }
      });
      if (paramBoolean) {
        edj();
      }
    }
    AppMethodBeat.o(55870);
  }
  
  public final void edi()
  {
    AppMethodBeat.i(55868);
    if (PoiPoint.b.yIt == this.yIq)
    {
      this.yIq = PoiPoint.b.yIu;
      this.yIj.reverse();
      this.yIk.reverse();
      this.yIl.reverse();
    }
    AppMethodBeat.o(55868);
  }
  
  public final void edj()
  {
    AppMethodBeat.i(55869);
    if (PoiPoint.b.yIu == this.yIq)
    {
      this.yIq = PoiPoint.b.yIt;
      this.yIj.start();
      this.yIk.start();
      this.yIl.start();
    }
    AppMethodBeat.o(55869);
  }
  
  public double getLat()
  {
    return this.yIm;
  }
  
  public double getLng()
  {
    return this.yIn;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55867);
    super.onDraw(paramCanvas);
    Log.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", new Object[] { Integer.valueOf(this.yIe) });
    int i = getWidth() / 2;
    float f = getHeight() - getWidth() / 2 - this.yIi;
    if ((PoiPoint.b.yIu == this.yIq) && (0.0F == this.yIj.getAnimatedFraction()))
    {
      Log.i("MicroMsg.PoiPoint", "draw shade.");
      this.yIb.setShadowLayer(at.fromDPToPix(this.context, 1), 0.0F, this.yIo, this.context.getResources().getColor(2131099657));
    }
    paramCanvas.drawCircle(i, f, this.yIc, this.yIb);
    paramCanvas.drawCircle(i, f, this.yIe, this.yId);
    paramCanvas.drawCircle(i, f, this.yIg, this.yIf);
    this.cuN.set(i - this.tHg / 2.0F, this.yIe + f - this.yIp, i + this.tHg / 2.0F, f + this.yIe + this.yIi);
    paramCanvas.drawRoundRect(this.cuN, this.yIp, this.yIp, this.yIh);
    AppMethodBeat.o(55867);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55866);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = at.fromDPToPix(this.context, 32);
    paramInt2 = at.fromDPToPix(this.context, 52);
    Log.d("MicroMsg.PoiPoint", "point size: %s*%s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(55866);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55871);
    if (this.yHM) {
      this.yHK.removeView(this);
    }
    this.yHM = false;
    AppMethodBeat.o(55871);
  }
  
  public void setOnPointClick(a parama)
  {
    this.yIr = parama;
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