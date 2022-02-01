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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int gRD;
  private int gRE;
  Paint paint;
  List<Point> points;
  private final float rLA;
  private final int rLB;
  private final float rLC;
  private final int rLD;
  private final float rLE;
  private final int rLF;
  private final float rLG;
  private final int rLH;
  private final float rLI;
  private final int rLJ;
  private final float rLK;
  private final int rLL;
  private final float rLM;
  private final float rLN;
  private final float rLO;
  private final float rLP;
  private final int rLQ;
  private final int rLR;
  private final int rLS;
  private final int rLT;
  private final float rLU;
  private final int rLV;
  private final float rLW;
  private final int rLX;
  private final float rLY;
  private final int rLZ;
  private final int rLa;
  private final int rLb;
  private final int rLc;
  private final float rLd;
  private final float rLe;
  private final float rLf;
  private final float rLg;
  private final float rLh;
  private final int rLi;
  private final int rLj;
  private final int rLk;
  private final int rLl;
  private int rLm;
  private final float rLn;
  private final float rLo;
  private final int rLp;
  private final float rLq;
  private final int rLr;
  private final float rLs;
  private final int rLt;
  private final float rLu;
  private final int rLv;
  private final float rLw;
  private final int rLx;
  private final float rLy;
  private final int rLz;
  PathEffect rMA;
  private int rMB;
  private boolean rMC;
  private final float rMa;
  private final int rMb;
  private final float rMc;
  private final int rMd;
  private final int rMe;
  private final int rMf;
  private final int rMg;
  private final int rMh;
  private final int rMi;
  private final int rMj;
  private final int rMk;
  private final int rMl;
  private int rMm;
  private final Typeface rMn;
  private final Typeface rMo;
  private int rMp;
  private int rMq;
  private int[] rMr;
  private final int rMs;
  private float[] rMt;
  private float[] rMu;
  private boolean[] rMv;
  Path rMw;
  Path rMx;
  List<String> rMy;
  private boolean rMz;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.rLa = -1;
    this.rLb = -1;
    this.rLc = getResources().getColor(2131100333);
    this.rLd = 12.0F;
    this.rLe = 28.0F;
    this.rLf = 33.0F;
    this.rLg = 12.0F;
    this.rLh = 12.0F;
    this.rLi = getResources().getColor(2131100334);
    this.rLj = -1;
    this.rLk = getResources().getColor(2131100334);
    this.rLl = -1;
    this.rLm = 2147483647;
    this.gRD = 0;
    this.gRE = 0;
    this.rLn = 10.0F;
    this.rLo = 2.5F;
    this.rLp = ((int)q(1, 2.5F));
    this.rLq = 4.0F;
    this.rLr = ((int)q(1, 4.0F));
    this.rLs = 1.8F;
    this.rLt = ((int)q(1, 1.8F));
    this.rLu = 1.0F;
    this.rLv = ((int)q(1, 1.0F));
    this.rLw = 8.0F;
    this.rLx = ((int)q(1, 8.0F));
    this.rLy = 22.0F;
    this.rLz = ((int)q(1, 22.0F));
    this.rLA = 67.0F;
    this.rLB = ((int)q(1, 67.0F));
    this.rLC = 40.0F;
    this.rLD = ((int)q(1, 40.0F));
    this.rLE = 22.0F;
    this.rLF = ((int)q(1, 22.0F));
    this.rLG = 55.0F;
    this.rLH = ((int)q(1, 55.0F));
    this.rLI = 35.0F;
    this.rLJ = ((int)q(1, 35.0F));
    this.rLK = 45.0F;
    this.rLL = ((int)q(1, 45.0F));
    this.rLM = 8.0F;
    this.rLN = ((int)q(1, 8.0F));
    this.rLO = 8.0F;
    this.rLP = ((int)q(1, 8.0F));
    this.rLQ = 2;
    this.rLR = ((int)q(1, 2.0F));
    this.rLS = 15;
    this.rLT = ((int)q(1, 15.0F));
    this.rLU = 33.0F;
    this.rLV = ((int)q(1, 33.0F));
    this.rLW = 8.0F;
    this.rLX = ((int)q(1, 8.0F));
    this.rLY = 35.0F;
    this.rLZ = ((int)q(1, 35.0F));
    this.rMa = 10.0F;
    this.rMb = ((int)q(1, 10.0F));
    this.rMc = 58.0F;
    this.rMd = ((int)q(1, 58.0F));
    this.rMe = ((int)q(1, 1.0F));
    this.rMf = 102;
    this.rMg = 102;
    this.rMh = 153;
    this.rMi = 102;
    this.rMj = 102;
    this.rMk = 102;
    this.rMl = 204;
    this.rMm = 0;
    this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.rMp = 0;
    this.rMq = 0;
    this.rMr = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.rMs = 7;
    this.rMt = new float[7];
    this.rMu = new float[7];
    this.rMv = new boolean[7];
    this.rMz = false;
    this.rMA = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cMe();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.rLa = -1;
    this.rLb = -1;
    this.rLc = getResources().getColor(2131100333);
    this.rLd = 12.0F;
    this.rLe = 28.0F;
    this.rLf = 33.0F;
    this.rLg = 12.0F;
    this.rLh = 12.0F;
    this.rLi = getResources().getColor(2131100334);
    this.rLj = -1;
    this.rLk = getResources().getColor(2131100334);
    this.rLl = -1;
    this.rLm = 2147483647;
    this.gRD = 0;
    this.gRE = 0;
    this.rLn = 10.0F;
    this.rLo = 2.5F;
    this.rLp = ((int)q(1, 2.5F));
    this.rLq = 4.0F;
    this.rLr = ((int)q(1, 4.0F));
    this.rLs = 1.8F;
    this.rLt = ((int)q(1, 1.8F));
    this.rLu = 1.0F;
    this.rLv = ((int)q(1, 1.0F));
    this.rLw = 8.0F;
    this.rLx = ((int)q(1, 8.0F));
    this.rLy = 22.0F;
    this.rLz = ((int)q(1, 22.0F));
    this.rLA = 67.0F;
    this.rLB = ((int)q(1, 67.0F));
    this.rLC = 40.0F;
    this.rLD = ((int)q(1, 40.0F));
    this.rLE = 22.0F;
    this.rLF = ((int)q(1, 22.0F));
    this.rLG = 55.0F;
    this.rLH = ((int)q(1, 55.0F));
    this.rLI = 35.0F;
    this.rLJ = ((int)q(1, 35.0F));
    this.rLK = 45.0F;
    this.rLL = ((int)q(1, 45.0F));
    this.rLM = 8.0F;
    this.rLN = ((int)q(1, 8.0F));
    this.rLO = 8.0F;
    this.rLP = ((int)q(1, 8.0F));
    this.rLQ = 2;
    this.rLR = ((int)q(1, 2.0F));
    this.rLS = 15;
    this.rLT = ((int)q(1, 15.0F));
    this.rLU = 33.0F;
    this.rLV = ((int)q(1, 33.0F));
    this.rLW = 8.0F;
    this.rLX = ((int)q(1, 8.0F));
    this.rLY = 35.0F;
    this.rLZ = ((int)q(1, 35.0F));
    this.rMa = 10.0F;
    this.rMb = ((int)q(1, 10.0F));
    this.rMc = 58.0F;
    this.rMd = ((int)q(1, 58.0F));
    this.rMe = ((int)q(1, 1.0F));
    this.rMf = 102;
    this.rMg = 102;
    this.rMh = 153;
    this.rMi = 102;
    this.rMj = 102;
    this.rMk = 102;
    this.rMl = 204;
    this.rMm = 0;
    this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.rMp = 0;
    this.rMq = 0;
    this.rMr = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.rMs = 7;
    this.rMt = new float[7];
    this.rMu = new float[7];
    this.rMv = new boolean[7];
    this.rMz = false;
    this.rMA = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cMe();
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
      this.paint.setTextSize(q(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.rMv[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.gRE - this.rLT, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.rLi);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int bf(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.rLm = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.rMp / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.rLm = i;
        invalidate();
      }
      for (;;)
      {
        i = this.rLm;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.rMp / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.rMp / 2)) {
            break;
          }
          this.rLm = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.gRD) || (paramFloat <= ((Point)this.points.get(i)).x - this.rMp / 2)) {
            break;
          }
          this.rLm = i;
          invalidate();
        }
        else
        {
          this.rLm = 2147483647;
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
      this.rMx.reset();
      this.rMx.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.rMx.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.rMx.lineTo(this.rMt[(this.rMt.length - 1)], this.gRE - this.rLJ - 1);
      this.rMx.lineTo(this.rLx, this.gRE - this.rLJ - 1);
      this.rMx.lineTo(this.rLx, this.rMu[0]);
      paramCanvas.drawPath(this.rMx, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.rMx.reset();
    this.rMx.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.gRE - this.rLD)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.rLt);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.rMx.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.rMx, this.paint);
        this.rMx.reset();
        this.rMx.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        cMg();
        continue;
        cMg();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void cMe()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.rMw = new Path();
    this.rMx = new Path();
    this.points = new LinkedList();
    this.rMy = new LinkedList();
    cMf();
    AppMethodBeat.o(24301);
  }
  
  private void cMf()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.rMv[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.rMv[i] = false;
      }
    }
  }
  
  private void cMg()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.rLt);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(24302);
  }
  
  private void getData()
  {
    int n = 0;
    AppMethodBeat.i(24304);
    this.points.clear();
    this.rMp = ((this.gRD - this.rLx - this.rLz) / 6);
    this.rMq = ((this.gRE - this.rLB - this.rLD) / 2);
    int i = 0;
    while (i < this.rMt.length)
    {
      this.rMt[i] = (this.rLx + this.rMp * i);
      i += 1;
    }
    i = this.rMr.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.rMr[i] > 100000) {
        this.rMr[i] = 100000;
      }
      if (this.rMr[i] < 0) {
        this.rMr[i] = 0;
      }
      m = j;
      if (this.rMr[i] > j) {
        m = this.rMr[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.rMm = ((this.gRE - this.rLB - this.rLD) * 10000 / i);
      this.rMm = (this.gRE - this.rLD - this.rMm);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.rMu[j] = (this.gRE - this.rLD - this.rMr[j] / i * (this.gRE - this.rLB - this.rLD));
          this.points.add(new Point((int)this.rMt[j], (int)this.rMu[j]));
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
  
  private float q(int paramInt, float paramFloat)
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
    if (!this.rMz)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.rLr, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.rLp, this.paint);
        }
      }
      if (this.rLm != 2147483647)
      {
        i = this.rLm;
        this.paint.reset();
        this.paint.setColor(this.rLi);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(q(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.rMC)
          {
            this.rMB = (((Point)this.points.get(i)).y - this.rMd);
            this.startY = this.rMB;
            this.rMC = true;
          }
          if (this.rMC)
          {
            f = (float)(this.startY / 8.0D);
            if (this.rMB > 0) {
              this.paint.setAlpha((this.startY - this.rMB) * 255 / this.startY);
            }
            paramCanvas.drawText(this.rMr[i], ((Point)this.points.get(i)).x, this.rMB + this.rMd, this.paint);
            if (this.rMB <= 0) {
              break label1253;
            }
            if (this.rMB / this.startY > 1.0F / f) {
              break label1226;
            }
            this.rMB -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.rLm;
      if ((i >= 0) && (i <= 6)) {
        this.rMv[i] = true;
      }
      this.paint.reset();
      this.rMw.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.rLc);
      this.paint.setStrokeWidth(this.rLv);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.rMm != 0) && (!this.rMz))
      {
        this.rMw.moveTo(this.rLx, this.rMm);
        this.rMw.lineTo(this.gRD - this.rLF, this.rMm);
        paramCanvas.drawPath(this.rMw, this.paint);
      }
      this.paint.reset();
      this.rMw.reset();
      this.paint.setColor(this.rLc);
      this.paint.setStrokeWidth(this.rLv);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.rMw.reset();
      this.rMw.moveTo(this.rLN, this.gRE - this.rLJ);
      this.rMw.lineTo(this.gRD - this.rLP, this.gRE - this.rLJ);
      this.rMw.moveTo(this.rLN, this.rLL);
      this.rMw.lineTo(this.gRD - this.rLP, this.rLL);
      paramCanvas.drawPath(this.rMw, this.paint);
      if (!this.rMz)
      {
        this.paint.reset();
        this.paint.setColor(this.rLk);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(q(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131758882), this.gRD - this.rLR, (float)(this.rMm + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.rMn);
      this.paint.setTextSize(q(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131758884), this.rLX, this.rLV, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(q(2, 33.0F));
      paramCanvas.drawText(this.rMr[(this.rMr.length - 1)], this.gRD - this.rMb, this.rLZ, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gRE - this.rLJ, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        cMg();
        if (!this.rMz) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.rMy);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.rMB = ((int)(this.rMB - this.rMB / this.startY * f));
      break;
      label1253:
      this.rMC = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    Log.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.rLm);
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
    this.rLm = bf(f);
    cMf();
    this.rMC = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */