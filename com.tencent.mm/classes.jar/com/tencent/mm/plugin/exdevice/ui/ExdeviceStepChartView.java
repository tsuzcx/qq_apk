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
  private int mbM;
  private int mbN;
  Paint paint;
  List<Point> points;
  private int xRatio;
  private final float yDA;
  private final int yDB;
  private final float yDC;
  private final int yDD;
  private final float yDE;
  private final int yDF;
  private final float yDG;
  private final int yDH;
  private final float yDI;
  private final int yDJ;
  private final float yDK;
  private final int yDL;
  private final float yDM;
  private final float yDN;
  private final float yDO;
  private final float yDP;
  private final int yDQ;
  private final int yDR;
  private final int yDS;
  private final int yDT;
  private final float yDU;
  private final int yDV;
  private final float yDW;
  private final int yDX;
  private final float yDY;
  private final int yDZ;
  private final int yDa;
  private final int yDb;
  private final int yDc;
  private final float yDd;
  private final float yDe;
  private final float yDf;
  private final float yDg;
  private final float yDh;
  private final int yDi;
  private final int yDj;
  private final int yDk;
  private final int yDl;
  private int yDm;
  private final float yDn;
  private final float yDo;
  private final int yDp;
  private final float yDq;
  private final int yDr;
  private final float yDs;
  private final int yDt;
  private final float yDu;
  private final int yDv;
  private final float yDw;
  private final int yDx;
  private final float yDy;
  private final int yDz;
  private int yEA;
  private boolean yEB;
  private final float yEa;
  private final int yEb;
  private final float yEc;
  private final int yEd;
  private final int yEe;
  private final int yEf;
  private final int yEg;
  private final int yEh;
  private final int yEi;
  private final int yEj;
  private final int yEk;
  private final int yEl;
  private int yEm;
  private final Typeface yEn;
  private final Typeface yEo;
  private int[] yEp;
  private final int yEq;
  private float[] yEr;
  private float[] yEs;
  private boolean[] yEt;
  Path yEu;
  Path yEv;
  List<String> yEw;
  private boolean yEx;
  PathEffect yEy;
  private int yEz;
  private int yRatio;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.yDa = -1;
    this.yDb = -1;
    this.yDc = getResources().getColor(R.e.fkt);
    this.yDd = 12.0F;
    this.yDe = 28.0F;
    this.yDf = 33.0F;
    this.yDg = 12.0F;
    this.yDh = 12.0F;
    this.yDi = getResources().getColor(R.e.fku);
    this.yDj = -1;
    this.yDk = getResources().getColor(R.e.fku);
    this.yDl = -1;
    this.yDm = 2147483647;
    this.mbM = 0;
    this.mbN = 0;
    this.yDn = 10.0F;
    this.yDo = 2.5F;
    this.yDp = ((int)u(1, 2.5F));
    this.yDq = 4.0F;
    this.yDr = ((int)u(1, 4.0F));
    this.yDs = 1.8F;
    this.yDt = ((int)u(1, 1.8F));
    this.yDu = 1.0F;
    this.yDv = ((int)u(1, 1.0F));
    this.yDw = 8.0F;
    this.yDx = ((int)u(1, 8.0F));
    this.yDy = 22.0F;
    this.yDz = ((int)u(1, 22.0F));
    this.yDA = 67.0F;
    this.yDB = ((int)u(1, 67.0F));
    this.yDC = 40.0F;
    this.yDD = ((int)u(1, 40.0F));
    this.yDE = 22.0F;
    this.yDF = ((int)u(1, 22.0F));
    this.yDG = 55.0F;
    this.yDH = ((int)u(1, 55.0F));
    this.yDI = 35.0F;
    this.yDJ = ((int)u(1, 35.0F));
    this.yDK = 45.0F;
    this.yDL = ((int)u(1, 45.0F));
    this.yDM = 8.0F;
    this.yDN = ((int)u(1, 8.0F));
    this.yDO = 8.0F;
    this.yDP = ((int)u(1, 8.0F));
    this.yDQ = 2;
    this.yDR = ((int)u(1, 2.0F));
    this.yDS = 15;
    this.yDT = ((int)u(1, 15.0F));
    this.yDU = 33.0F;
    this.yDV = ((int)u(1, 33.0F));
    this.yDW = 8.0F;
    this.yDX = ((int)u(1, 8.0F));
    this.yDY = 35.0F;
    this.yDZ = ((int)u(1, 35.0F));
    this.yEa = 10.0F;
    this.yEb = ((int)u(1, 10.0F));
    this.yEc = 58.0F;
    this.yEd = ((int)u(1, 58.0F));
    this.yEe = ((int)u(1, 1.0F));
    this.yEf = 102;
    this.yEg = 102;
    this.yEh = 153;
    this.yEi = 102;
    this.yEj = 102;
    this.yEk = 102;
    this.yEl = 204;
    this.yEm = 0;
    this.yEn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.yEo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.xRatio = 0;
    this.yRatio = 0;
    this.yEp = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.yEq = 7;
    this.yEr = new float[7];
    this.yEs = new float[7];
    this.yEt = new boolean[7];
    this.yEx = false;
    this.yEy = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    dHl();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.yDa = -1;
    this.yDb = -1;
    this.yDc = getResources().getColor(R.e.fkt);
    this.yDd = 12.0F;
    this.yDe = 28.0F;
    this.yDf = 33.0F;
    this.yDg = 12.0F;
    this.yDh = 12.0F;
    this.yDi = getResources().getColor(R.e.fku);
    this.yDj = -1;
    this.yDk = getResources().getColor(R.e.fku);
    this.yDl = -1;
    this.yDm = 2147483647;
    this.mbM = 0;
    this.mbN = 0;
    this.yDn = 10.0F;
    this.yDo = 2.5F;
    this.yDp = ((int)u(1, 2.5F));
    this.yDq = 4.0F;
    this.yDr = ((int)u(1, 4.0F));
    this.yDs = 1.8F;
    this.yDt = ((int)u(1, 1.8F));
    this.yDu = 1.0F;
    this.yDv = ((int)u(1, 1.0F));
    this.yDw = 8.0F;
    this.yDx = ((int)u(1, 8.0F));
    this.yDy = 22.0F;
    this.yDz = ((int)u(1, 22.0F));
    this.yDA = 67.0F;
    this.yDB = ((int)u(1, 67.0F));
    this.yDC = 40.0F;
    this.yDD = ((int)u(1, 40.0F));
    this.yDE = 22.0F;
    this.yDF = ((int)u(1, 22.0F));
    this.yDG = 55.0F;
    this.yDH = ((int)u(1, 55.0F));
    this.yDI = 35.0F;
    this.yDJ = ((int)u(1, 35.0F));
    this.yDK = 45.0F;
    this.yDL = ((int)u(1, 45.0F));
    this.yDM = 8.0F;
    this.yDN = ((int)u(1, 8.0F));
    this.yDO = 8.0F;
    this.yDP = ((int)u(1, 8.0F));
    this.yDQ = 2;
    this.yDR = ((int)u(1, 2.0F));
    this.yDS = 15;
    this.yDT = ((int)u(1, 15.0F));
    this.yDU = 33.0F;
    this.yDV = ((int)u(1, 33.0F));
    this.yDW = 8.0F;
    this.yDX = ((int)u(1, 8.0F));
    this.yDY = 35.0F;
    this.yDZ = ((int)u(1, 35.0F));
    this.yEa = 10.0F;
    this.yEb = ((int)u(1, 10.0F));
    this.yEc = 58.0F;
    this.yEd = ((int)u(1, 58.0F));
    this.yEe = ((int)u(1, 1.0F));
    this.yEf = 102;
    this.yEg = 102;
    this.yEh = 153;
    this.yEi = 102;
    this.yEj = 102;
    this.yEk = 102;
    this.yEl = 204;
    this.yEm = 0;
    this.yEn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.yEo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.xRatio = 0;
    this.yRatio = 0;
    this.yEp = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.yEq = 7;
    this.yEr = new float[7];
    this.yEs = new float[7];
    this.yEt = new boolean[7];
    this.yEx = false;
    this.yEy = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    dHl();
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
      this.paint.setTextSize(u(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.yEt[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.mbN - this.yDT, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.yDi);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int ch(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.yDm = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.xRatio / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.yDm = i;
        invalidate();
      }
      for (;;)
      {
        i = this.yDm;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.xRatio / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.xRatio / 2)) {
            break;
          }
          this.yDm = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.mbM) || (paramFloat <= ((Point)this.points.get(i)).x - this.xRatio / 2)) {
            break;
          }
          this.yDm = i;
          invalidate();
        }
        else
        {
          this.yDm = 2147483647;
        }
      }
      label264:
      i += 1;
    }
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(24298);
    if (paramBoolean)
    {
      this.yEv.reset();
      this.yEv.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.yEv.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.yEv.lineTo(this.yEr[(this.yEr.length - 1)], this.mbN - this.yDJ - 1);
      this.yEv.lineTo(this.yDx, this.mbN - this.yDJ - 1);
      this.yEv.lineTo(this.yDx, this.yEs[0]);
      paramCanvas.drawPath(this.yEv, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.yEv.reset();
    this.yEv.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.mbN - this.yDD)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.yDt);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.yEv.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.yEv, this.paint);
        this.yEv.reset();
        this.yEv.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        dHn();
        continue;
        dHn();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void dHl()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.yEu = new Path();
    this.yEv = new Path();
    this.points = new LinkedList();
    this.yEw = new LinkedList();
    dHm();
    AppMethodBeat.o(24301);
  }
  
  private void dHm()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.yEt[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.yEt[i] = false;
      }
    }
  }
  
  private void dHn()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.yDt);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(24302);
  }
  
  private void getData()
  {
    int n = 0;
    AppMethodBeat.i(24304);
    this.points.clear();
    this.xRatio = ((this.mbM - this.yDx - this.yDz) / 6);
    this.yRatio = ((this.mbN - this.yDB - this.yDD) / 2);
    int i = 0;
    while (i < this.yEr.length)
    {
      this.yEr[i] = (this.yDx + this.xRatio * i);
      i += 1;
    }
    i = this.yEp.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.yEp[i] > 100000) {
        this.yEp[i] = 100000;
      }
      if (this.yEp[i] < 0) {
        this.yEp[i] = 0;
      }
      m = j;
      if (this.yEp[i] > j) {
        m = this.yEp[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.yEm = ((this.mbN - this.yDB - this.yDD) * 10000 / i);
      this.yEm = (this.mbN - this.yDD - this.yEm);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.yEs[j] = (this.mbN - this.yDD - this.yEp[j] / i * (this.mbN - this.yDB - this.yDD));
          this.points.add(new Point((int)this.yEr[j], (int)this.yEs[j]));
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
  
  private float u(int paramInt, float paramFloat)
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
    if (!this.yEx)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.yDr, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.yDp, this.paint);
        }
      }
      if (this.yDm != 2147483647)
      {
        i = this.yDm;
        this.paint.reset();
        this.paint.setColor(this.yDi);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(u(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.yEB)
          {
            this.yEz = (((Point)this.points.get(i)).y - this.yEd);
            this.yEA = this.yEz;
            this.yEB = true;
          }
          if (this.yEB)
          {
            f = (float)(this.yEA / 8.0D);
            if (this.yEz > 0) {
              this.paint.setAlpha((this.yEA - this.yEz) * 255 / this.yEA);
            }
            paramCanvas.drawText(this.yEp[i], ((Point)this.points.get(i)).x, this.yEz + this.yEd, this.paint);
            if (this.yEz <= 0) {
              break label1253;
            }
            if (this.yEz / this.yEA > 1.0F / f) {
              break label1226;
            }
            this.yEz -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.yDm;
      if ((i >= 0) && (i <= 6)) {
        this.yEt[i] = true;
      }
      this.paint.reset();
      this.yEu.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.yDc);
      this.paint.setStrokeWidth(this.yDv);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.yEm != 0) && (!this.yEx))
      {
        this.yEu.moveTo(this.yDx, this.yEm);
        this.yEu.lineTo(this.mbM - this.yDF, this.yEm);
        paramCanvas.drawPath(this.yEu, this.paint);
      }
      this.paint.reset();
      this.yEu.reset();
      this.paint.setColor(this.yDc);
      this.paint.setStrokeWidth(this.yDv);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.yEu.reset();
      this.yEu.moveTo(this.yDN, this.mbN - this.yDJ);
      this.yEu.lineTo(this.mbM - this.yDP, this.mbN - this.yDJ);
      this.yEu.moveTo(this.yDN, this.yDL);
      this.yEu.lineTo(this.mbM - this.yDP, this.yDL);
      paramCanvas.drawPath(this.yEu, this.paint);
      if (!this.yEx)
      {
        this.paint.reset();
        this.paint.setColor(this.yDk);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(u(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(R.l.gGI), this.mbM - this.yDR, (float)(this.yEm + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.yEn);
      this.paint.setTextSize(u(2, 28.0F));
      paramCanvas.drawText(getResources().getString(R.l.gGJ), this.yDX, this.yDV, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(u(2, 33.0F));
      paramCanvas.drawText(this.yEp[(this.yEp.length - 1)], this.mbM - this.yEb, this.yDZ, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.mbN - this.yDJ, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        d(paramCanvas, true);
        dHn();
        if (!this.yEx) {
          d(paramCanvas, false);
        }
      }
      a(paramCanvas, this.yEw);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.yEz = ((int)(this.yEz - this.yEz / this.yEA * f));
      break;
      label1253:
      this.yEB = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    Log.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.yDm);
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
    this.yDm = ch(f);
    dHm();
    this.yEB = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */