package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int jBZ;
  private int jCa;
  Paint paint;
  List<Point> points;
  private final int vqJ;
  private final int vqK;
  private final int vqL;
  private final float vqM;
  private final float vqN;
  private final float vqO;
  private final float vqP;
  private final float vqQ;
  private final int vqR;
  private final int vqS;
  private final int vqT;
  private final int vqU;
  private int vqV;
  private final float vqW;
  private final float vqX;
  private final int vqY;
  private final float vqZ;
  private final int vrA;
  private final int vrB;
  private final int vrC;
  private final float vrD;
  private final int vrE;
  private final float vrF;
  private final int vrG;
  private final float vrH;
  private final int vrI;
  private final float vrJ;
  private final int vrK;
  private final float vrL;
  private final int vrM;
  private final int vrN;
  private final int vrO;
  private final int vrP;
  private final int vrQ;
  private final int vrR;
  private final int vrS;
  private final int vrT;
  private final int vrU;
  private int vrV;
  private final Typeface vrW;
  private final Typeface vrX;
  private int vrY;
  private int vrZ;
  private final int vra;
  private final float vrb;
  private final int vrc;
  private final float vrd;
  private final int vre;
  private final float vrf;
  private final int vrg;
  private final float vrh;
  private final int vri;
  private final float vrj;
  private final int vrk;
  private final float vrl;
  private final int vrm;
  private final float vrn;
  private final int vro;
  private final float vrp;
  private final int vrq;
  private final float vrr;
  private final int vrs;
  private final float vrt;
  private final int vru;
  private final float vrv;
  private final float vrw;
  private final float vrx;
  private final float vry;
  private final int vrz;
  private int[] vsa;
  private final int vsb;
  private float[] vsc;
  private float[] vsd;
  private boolean[] vse;
  Path vsf;
  Path vsg;
  List<String> vsh;
  private boolean vsi;
  PathEffect vsj;
  private int vsk;
  private int vsl;
  private boolean vsm;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.vqJ = -1;
    this.vqK = -1;
    this.vqL = getResources().getColor(R.e.dko);
    this.vqM = 12.0F;
    this.vqN = 28.0F;
    this.vqO = 33.0F;
    this.vqP = 12.0F;
    this.vqQ = 12.0F;
    this.vqR = getResources().getColor(R.e.dkp);
    this.vqS = -1;
    this.vqT = getResources().getColor(R.e.dkp);
    this.vqU = -1;
    this.vqV = 2147483647;
    this.jBZ = 0;
    this.jCa = 0;
    this.vqW = 10.0F;
    this.vqX = 2.5F;
    this.vqY = ((int)r(1, 2.5F));
    this.vqZ = 4.0F;
    this.vra = ((int)r(1, 4.0F));
    this.vrb = 1.8F;
    this.vrc = ((int)r(1, 1.8F));
    this.vrd = 1.0F;
    this.vre = ((int)r(1, 1.0F));
    this.vrf = 8.0F;
    this.vrg = ((int)r(1, 8.0F));
    this.vrh = 22.0F;
    this.vri = ((int)r(1, 22.0F));
    this.vrj = 67.0F;
    this.vrk = ((int)r(1, 67.0F));
    this.vrl = 40.0F;
    this.vrm = ((int)r(1, 40.0F));
    this.vrn = 22.0F;
    this.vro = ((int)r(1, 22.0F));
    this.vrp = 55.0F;
    this.vrq = ((int)r(1, 55.0F));
    this.vrr = 35.0F;
    this.vrs = ((int)r(1, 35.0F));
    this.vrt = 45.0F;
    this.vru = ((int)r(1, 45.0F));
    this.vrv = 8.0F;
    this.vrw = ((int)r(1, 8.0F));
    this.vrx = 8.0F;
    this.vry = ((int)r(1, 8.0F));
    this.vrz = 2;
    this.vrA = ((int)r(1, 2.0F));
    this.vrB = 15;
    this.vrC = ((int)r(1, 15.0F));
    this.vrD = 33.0F;
    this.vrE = ((int)r(1, 33.0F));
    this.vrF = 8.0F;
    this.vrG = ((int)r(1, 8.0F));
    this.vrH = 35.0F;
    this.vrI = ((int)r(1, 35.0F));
    this.vrJ = 10.0F;
    this.vrK = ((int)r(1, 10.0F));
    this.vrL = 58.0F;
    this.vrM = ((int)r(1, 58.0F));
    this.vrN = ((int)r(1, 1.0F));
    this.vrO = 102;
    this.vrP = 102;
    this.vrQ = 153;
    this.vrR = 102;
    this.vrS = 102;
    this.vrT = 102;
    this.vrU = 204;
    this.vrV = 0;
    this.vrW = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.vrX = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.vrY = 0;
    this.vrZ = 0;
    this.vsa = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.vsb = 7;
    this.vsc = new float[7];
    this.vsd = new float[7];
    this.vse = new boolean[7];
    this.vsi = false;
    this.vsj = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    daR();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.vqJ = -1;
    this.vqK = -1;
    this.vqL = getResources().getColor(R.e.dko);
    this.vqM = 12.0F;
    this.vqN = 28.0F;
    this.vqO = 33.0F;
    this.vqP = 12.0F;
    this.vqQ = 12.0F;
    this.vqR = getResources().getColor(R.e.dkp);
    this.vqS = -1;
    this.vqT = getResources().getColor(R.e.dkp);
    this.vqU = -1;
    this.vqV = 2147483647;
    this.jBZ = 0;
    this.jCa = 0;
    this.vqW = 10.0F;
    this.vqX = 2.5F;
    this.vqY = ((int)r(1, 2.5F));
    this.vqZ = 4.0F;
    this.vra = ((int)r(1, 4.0F));
    this.vrb = 1.8F;
    this.vrc = ((int)r(1, 1.8F));
    this.vrd = 1.0F;
    this.vre = ((int)r(1, 1.0F));
    this.vrf = 8.0F;
    this.vrg = ((int)r(1, 8.0F));
    this.vrh = 22.0F;
    this.vri = ((int)r(1, 22.0F));
    this.vrj = 67.0F;
    this.vrk = ((int)r(1, 67.0F));
    this.vrl = 40.0F;
    this.vrm = ((int)r(1, 40.0F));
    this.vrn = 22.0F;
    this.vro = ((int)r(1, 22.0F));
    this.vrp = 55.0F;
    this.vrq = ((int)r(1, 55.0F));
    this.vrr = 35.0F;
    this.vrs = ((int)r(1, 35.0F));
    this.vrt = 45.0F;
    this.vru = ((int)r(1, 45.0F));
    this.vrv = 8.0F;
    this.vrw = ((int)r(1, 8.0F));
    this.vrx = 8.0F;
    this.vry = ((int)r(1, 8.0F));
    this.vrz = 2;
    this.vrA = ((int)r(1, 2.0F));
    this.vrB = 15;
    this.vrC = ((int)r(1, 15.0F));
    this.vrD = 33.0F;
    this.vrE = ((int)r(1, 33.0F));
    this.vrF = 8.0F;
    this.vrG = ((int)r(1, 8.0F));
    this.vrH = 35.0F;
    this.vrI = ((int)r(1, 35.0F));
    this.vrJ = 10.0F;
    this.vrK = ((int)r(1, 10.0F));
    this.vrL = 58.0F;
    this.vrM = ((int)r(1, 58.0F));
    this.vrN = ((int)r(1, 1.0F));
    this.vrO = 102;
    this.vrP = 102;
    this.vrQ = 153;
    this.vrR = 102;
    this.vrS = 102;
    this.vrT = 102;
    this.vrU = 204;
    this.vrV = 0;
    this.vrW = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.vrX = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.vrY = 0;
    this.vrZ = 0;
    this.vsa = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.vsb = 7;
    this.vsc = new float[7];
    this.vsd = new float[7];
    this.vse = new boolean[7];
    this.vsi = false;
    this.vsj = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    daR();
    AppMethodBeat.o(24297);
  }
  
  private void a(Canvas paramCanvas, List<String> paramList)
  {
    AppMethodBeat.i(24300);
    if ((paramList != null) && (paramList.size() == 7))
    {
      this.paint.reset();
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTextSize(r(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.vse[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.jCa - this.vrC, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.vqR);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int be(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.vqV = 2147483647;
    int i;
    if (this.points.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.points.size())
      {
        if (i != 0) {
          break label100;
        }
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.vrY / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.vqV = i;
        invalidate();
      }
      for (;;)
      {
        i = this.vqV;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.vrY / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.vrY / 2)) {
            break;
          }
          this.vqV = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.jBZ) || (paramFloat <= ((Point)this.points.get(i)).x - this.vrY / 2)) {
            break;
          }
          this.vqV = i;
          invalidate();
        }
        else
        {
          this.vqV = 2147483647;
        }
      }
      label264:
      i += 1;
    }
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(24298);
    if (paramBoolean)
    {
      this.vsg.reset();
      this.vsg.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.vsg.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.vsg.lineTo(this.vsc[(this.vsc.length - 1)], this.jCa - this.vrs - 1);
      this.vsg.lineTo(this.vrg, this.jCa - this.vrs - 1);
      this.vsg.lineTo(this.vrg, this.vsd[0]);
      paramCanvas.drawPath(this.vsg, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.vsg.reset();
    this.vsg.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.jCa - this.vrm)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.vrc);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.vsg.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.vsg, this.paint);
        this.vsg.reset();
        this.vsg.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        daT();
        continue;
        daT();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void daR()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.vsf = new Path();
    this.vsg = new Path();
    this.points = new LinkedList();
    this.vsh = new LinkedList();
    daS();
    AppMethodBeat.o(24301);
  }
  
  private void daS()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.vse[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.vse[i] = false;
      }
    }
  }
  
  private void daT()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.vrc);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(24302);
  }
  
  private void getData()
  {
    int n = 0;
    AppMethodBeat.i(24304);
    this.points.clear();
    this.vrY = ((this.jBZ - this.vrg - this.vri) / 6);
    this.vrZ = ((this.jCa - this.vrk - this.vrm) / 2);
    int i = 0;
    while (i < this.vsc.length)
    {
      this.vsc[i] = (this.vrg + this.vrY * i);
      i += 1;
    }
    i = this.vsa.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.vsa[i] > 100000) {
        this.vsa[i] = 100000;
      }
      if (this.vsa[i] < 0) {
        this.vsa[i] = 0;
      }
      m = j;
      if (this.vsa[i] > j) {
        m = this.vsa[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.vrV = ((this.jCa - this.vrk - this.vrm) * 10000 / i);
      this.vrV = (this.jCa - this.vrm - this.vrV);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.vsd[j] = (this.jCa - this.vrm - this.vsa[j] / i * (this.jCa - this.vrk - this.vrm));
          this.points.add(new Point((int)this.vsc[j], (int)this.vsd[j]));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label390;
          }
          i = j;
          if (j / 5000.0D <= j / 5000.0F) {
            break;
          }
          i = (j / 5000 + 1) * 5000;
          break;
        }
      }
      AppMethodBeat.o(24304);
      return;
      label390:
      i = 0;
    }
  }
  
  private float r(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(24299);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      AppMethodBeat.o(24299);
      return paramFloat;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(24303);
    getData();
    super.onDraw(paramCanvas);
    int i;
    Object localObject;
    float f;
    if (!this.vsi)
    {
      this.paint.reset();
      this.paint.setAntiAlias(true);
      this.paint.setColor(-1);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setStyle(Paint.Style.FILL);
      i = 0;
      if (i < this.points.size())
      {
        localObject = (Point)this.points.get(i);
        if (i == this.points.size() - 1) {
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.vra, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.vqY, this.paint);
        }
      }
      if (this.vqV != 2147483647)
      {
        i = this.vqV;
        this.paint.reset();
        this.paint.setColor(this.vqR);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(r(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.vsm)
          {
            this.vsk = (((Point)this.points.get(i)).y - this.vrM);
            this.vsl = this.vsk;
            this.vsm = true;
          }
          if (this.vsm)
          {
            f = (float)(this.vsl / 8.0D);
            if (this.vsk > 0) {
              this.paint.setAlpha((this.vsl - this.vsk) * 255 / this.vsl);
            }
            paramCanvas.drawText(this.vsa[i], ((Point)this.points.get(i)).x, this.vsk + this.vrM, this.paint);
            if (this.vsk <= 0) {
              break label1253;
            }
            if (this.vsk / this.vsl > 1.0F / f) {
              break label1226;
            }
            this.vsk -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.vqV;
      if ((i >= 0) && (i <= 6)) {
        this.vse[i] = true;
      }
      this.paint.reset();
      this.vsf.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.vqL);
      this.paint.setStrokeWidth(this.vre);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.vrV != 0) && (!this.vsi))
      {
        this.vsf.moveTo(this.vrg, this.vrV);
        this.vsf.lineTo(this.jBZ - this.vro, this.vrV);
        paramCanvas.drawPath(this.vsf, this.paint);
      }
      this.paint.reset();
      this.vsf.reset();
      this.paint.setColor(this.vqL);
      this.paint.setStrokeWidth(this.vre);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.vsf.reset();
      this.vsf.moveTo(this.vrw, this.jCa - this.vrs);
      this.vsf.lineTo(this.jBZ - this.vry, this.jCa - this.vrs);
      this.vsf.moveTo(this.vrw, this.vru);
      this.vsf.lineTo(this.jBZ - this.vry, this.vru);
      paramCanvas.drawPath(this.vsf, this.paint);
      if (!this.vsi)
      {
        this.paint.reset();
        this.paint.setColor(this.vqT);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(r(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(R.l.eDU), this.jBZ - this.vrA, (float)(this.vrV + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.vrW);
      this.paint.setTextSize(r(2, 28.0F));
      paramCanvas.drawText(getResources().getString(R.l.eDV), this.vrG, this.vrE, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(r(2, 33.0F));
      paramCanvas.drawText(this.vsa[(this.vsa.length - 1)], this.jBZ - this.vrK, this.vrI, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jCa - this.vrs, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        daT();
        if (!this.vsi) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.vsh);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.vsk = ((int)(this.vsk - this.vsk / this.vsl * f));
      break;
      label1253:
      this.vsm = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    Log.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.vqV);
    switch (paramMotionEvent.getAction())
    {
    default: 
      Log.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      AppMethodBeat.o(24306);
      return false;
    case 0: 
      Log.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      AppMethodBeat.o(24306);
      return true;
    }
    Log.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.vqV = be(f);
    daS();
    this.vsm = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */