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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int jgD;
  private int jgE;
  private final int lPM;
  private final int lPN;
  private final int lPO;
  private final float lPP;
  private final float lPQ;
  private final float lPR;
  private final float lPS;
  private final float lPT;
  private final int lPU;
  private final int lPV;
  private final int lPW;
  private final int lPX;
  private int lPY;
  private final float lPZ;
  private final float lQA;
  private final float lQB;
  private final int lQC;
  private final int lQD;
  private final int lQE;
  private final int lQF;
  private final float lQG;
  private final int lQH;
  private final float lQI;
  private final int lQJ;
  private final float lQK;
  private final int lQL;
  private final float lQM;
  private final int lQN;
  private final float lQO;
  private final int lQP;
  private final int lQQ;
  private final int lQR;
  private final int lQS;
  private final int lQT;
  private final int lQU;
  private final int lQV;
  private final int lQW;
  private final int lQX;
  private int lQY;
  private final Typeface lQZ;
  private final float lQa;
  private final int lQb;
  private final float lQc;
  private final int lQd;
  private final float lQe;
  private final int lQf;
  private final float lQg;
  private final int lQh;
  private final float lQi;
  private final int lQj;
  private final float lQk;
  private final int lQl;
  private final float lQm;
  private final int lQn;
  private final float lQo;
  private final int lQp;
  private final float lQq;
  private final int lQr;
  private final float lQs;
  private final int lQt;
  private final float lQu;
  private final int lQv;
  private final float lQw;
  private final int lQx;
  private final float lQy;
  private final float lQz;
  private final Typeface lRa;
  private int lRb;
  private int lRc;
  private int[] lRd;
  private final int lRe;
  private float[] lRf;
  private float[] lRg;
  private boolean[] lRh;
  Path lRi;
  Path lRj;
  List<String> lRk;
  private boolean lRl;
  PathEffect lRm;
  private int lRn;
  private boolean lRo;
  Paint paint;
  List<Point> points;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20223);
    this.lPM = -1;
    this.lPN = -1;
    this.lPO = getResources().getColor(2131690000);
    this.lPP = 12.0F;
    this.lPQ = 28.0F;
    this.lPR = 33.0F;
    this.lPS = 12.0F;
    this.lPT = 12.0F;
    this.lPU = getResources().getColor(2131690001);
    this.lPV = -1;
    this.lPW = getResources().getColor(2131690001);
    this.lPX = -1;
    this.lPY = 2147483647;
    this.jgD = 0;
    this.jgE = 0;
    this.lPZ = 10.0F;
    this.lQa = 2.5F;
    this.lQb = ((int)l(1, 2.5F));
    this.lQc = 4.0F;
    this.lQd = ((int)l(1, 4.0F));
    this.lQe = 1.8F;
    this.lQf = ((int)l(1, 1.8F));
    this.lQg = 1.0F;
    this.lQh = ((int)l(1, 1.0F));
    this.lQi = 8.0F;
    this.lQj = ((int)l(1, 8.0F));
    this.lQk = 22.0F;
    this.lQl = ((int)l(1, 22.0F));
    this.lQm = 67.0F;
    this.lQn = ((int)l(1, 67.0F));
    this.lQo = 40.0F;
    this.lQp = ((int)l(1, 40.0F));
    this.lQq = 22.0F;
    this.lQr = ((int)l(1, 22.0F));
    this.lQs = 55.0F;
    this.lQt = ((int)l(1, 55.0F));
    this.lQu = 35.0F;
    this.lQv = ((int)l(1, 35.0F));
    this.lQw = 45.0F;
    this.lQx = ((int)l(1, 45.0F));
    this.lQy = 8.0F;
    this.lQz = ((int)l(1, 8.0F));
    this.lQA = 8.0F;
    this.lQB = ((int)l(1, 8.0F));
    this.lQC = 2;
    this.lQD = ((int)l(1, 2.0F));
    this.lQE = 15;
    this.lQF = ((int)l(1, 15.0F));
    this.lQG = 33.0F;
    this.lQH = ((int)l(1, 33.0F));
    this.lQI = 8.0F;
    this.lQJ = ((int)l(1, 8.0F));
    this.lQK = 35.0F;
    this.lQL = ((int)l(1, 35.0F));
    this.lQM = 10.0F;
    this.lQN = ((int)l(1, 10.0F));
    this.lQO = 58.0F;
    this.lQP = ((int)l(1, 58.0F));
    this.lQQ = ((int)l(1, 1.0F));
    this.lQR = 102;
    this.lQS = 102;
    this.lQT = 153;
    this.lQU = 102;
    this.lQV = 102;
    this.lQW = 102;
    this.lQX = 204;
    this.lQY = 0;
    this.lQZ = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.lRa = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.lRb = 0;
    this.lRc = 0;
    this.lRd = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.lRe = 7;
    this.lRf = new float[7];
    this.lRg = new float[7];
    this.lRh = new boolean[7];
    this.lRl = false;
    this.lRm = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    brg();
    AppMethodBeat.o(20223);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(20224);
    this.lPM = -1;
    this.lPN = -1;
    this.lPO = getResources().getColor(2131690000);
    this.lPP = 12.0F;
    this.lPQ = 28.0F;
    this.lPR = 33.0F;
    this.lPS = 12.0F;
    this.lPT = 12.0F;
    this.lPU = getResources().getColor(2131690001);
    this.lPV = -1;
    this.lPW = getResources().getColor(2131690001);
    this.lPX = -1;
    this.lPY = 2147483647;
    this.jgD = 0;
    this.jgE = 0;
    this.lPZ = 10.0F;
    this.lQa = 2.5F;
    this.lQb = ((int)l(1, 2.5F));
    this.lQc = 4.0F;
    this.lQd = ((int)l(1, 4.0F));
    this.lQe = 1.8F;
    this.lQf = ((int)l(1, 1.8F));
    this.lQg = 1.0F;
    this.lQh = ((int)l(1, 1.0F));
    this.lQi = 8.0F;
    this.lQj = ((int)l(1, 8.0F));
    this.lQk = 22.0F;
    this.lQl = ((int)l(1, 22.0F));
    this.lQm = 67.0F;
    this.lQn = ((int)l(1, 67.0F));
    this.lQo = 40.0F;
    this.lQp = ((int)l(1, 40.0F));
    this.lQq = 22.0F;
    this.lQr = ((int)l(1, 22.0F));
    this.lQs = 55.0F;
    this.lQt = ((int)l(1, 55.0F));
    this.lQu = 35.0F;
    this.lQv = ((int)l(1, 35.0F));
    this.lQw = 45.0F;
    this.lQx = ((int)l(1, 45.0F));
    this.lQy = 8.0F;
    this.lQz = ((int)l(1, 8.0F));
    this.lQA = 8.0F;
    this.lQB = ((int)l(1, 8.0F));
    this.lQC = 2;
    this.lQD = ((int)l(1, 2.0F));
    this.lQE = 15;
    this.lQF = ((int)l(1, 15.0F));
    this.lQG = 33.0F;
    this.lQH = ((int)l(1, 33.0F));
    this.lQI = 8.0F;
    this.lQJ = ((int)l(1, 8.0F));
    this.lQK = 35.0F;
    this.lQL = ((int)l(1, 35.0F));
    this.lQM = 10.0F;
    this.lQN = ((int)l(1, 10.0F));
    this.lQO = 58.0F;
    this.lQP = ((int)l(1, 58.0F));
    this.lQQ = ((int)l(1, 1.0F));
    this.lQR = 102;
    this.lQS = 102;
    this.lQT = 153;
    this.lQU = 102;
    this.lQV = 102;
    this.lQW = 102;
    this.lQX = 204;
    this.lQY = 0;
    this.lQZ = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.lRa = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.lRb = 0;
    this.lRc = 0;
    this.lRd = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.lRe = 7;
    this.lRf = new float[7];
    this.lRg = new float[7];
    this.lRh = new boolean[7];
    this.lRl = false;
    this.lRm = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    brg();
    AppMethodBeat.o(20224);
  }
  
  private void a(Canvas paramCanvas, List<String> paramList)
  {
    AppMethodBeat.i(20227);
    if ((paramList != null) && (paramList.size() == 7))
    {
      this.paint.reset();
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTextSize(l(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.lRh[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.jgE - this.lQF, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.lPU);
        }
      }
    }
    AppMethodBeat.o(20227);
  }
  
  private int aI(float paramFloat)
  {
    AppMethodBeat.i(20232);
    this.lPY = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.lRb / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.lPY = i;
        invalidate();
      }
      for (;;)
      {
        i = this.lPY;
        AppMethodBeat.o(20232);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.lRb / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.lRb / 2)) {
            break;
          }
          this.lPY = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.jgD) || (paramFloat <= ((Point)this.points.get(i)).x - this.lRb / 2)) {
            break;
          }
          this.lPY = i;
          invalidate();
        }
        else
        {
          this.lPY = 2147483647;
        }
      }
      label264:
      i += 1;
    }
  }
  
  private void brg()
  {
    AppMethodBeat.i(20228);
    this.paint = new Paint();
    this.lRi = new Path();
    this.lRj = new Path();
    this.points = new LinkedList();
    this.lRk = new LinkedList();
    brh();
    AppMethodBeat.o(20228);
  }
  
  private void brh()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.lRh[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.lRh[i] = false;
      }
    }
  }
  
  private void bri()
  {
    AppMethodBeat.i(20229);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.lQf);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(20229);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(20225);
    if (paramBoolean)
    {
      this.lRj.reset();
      this.lRj.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.lRj.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.lRj.lineTo(this.lRf[(this.lRf.length - 1)], this.jgE - this.lQv - 1);
      this.lRj.lineTo(this.lQj, this.jgE - this.lQv - 1);
      this.lRj.lineTo(this.lQj, this.lRg[0]);
      paramCanvas.drawPath(this.lRj, this.paint);
      AppMethodBeat.o(20225);
      return;
    }
    this.lRj.reset();
    this.lRj.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.jgE - this.lQp)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.lQf);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.lRj.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.lRj, this.paint);
        this.lRj.reset();
        this.lRj.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        bri();
        continue;
        bri();
      }
    }
    AppMethodBeat.o(20225);
  }
  
  private void getData()
  {
    int n = 0;
    AppMethodBeat.i(20231);
    this.points.clear();
    View localView = findViewById(2131823811);
    this.jgD = localView.getWidth();
    this.jgE = localView.getHeight();
    this.lRb = ((this.jgD - this.lQj - this.lQl) / 6);
    this.lRc = ((this.jgE - this.lQn - this.lQp) / 2);
    int i = 0;
    while (i < this.lRf.length)
    {
      this.lRf[i] = (this.lQj + this.lRb * i);
      i += 1;
    }
    i = this.lRd.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.lRd[i] > 100000) {
        this.lRd[i] = 100000;
      }
      if (this.lRd[i] < 0) {
        this.lRd[i] = 0;
      }
      m = j;
      if (this.lRd[i] > j) {
        m = this.lRd[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.lQY = ((this.jgE - this.lQn - this.lQp) * 10000 / i);
      this.lQY = (this.jgE - this.lQp - this.lQY);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.lRg[j] = (this.jgE - this.lQp - this.lRd[j] / i * (this.jgE - this.lQn - this.lQp));
          this.points.add(new Point((int)this.lRf[j], (int)this.lRg[j]));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label417;
          }
          i = j;
          if (j / 5000.0D <= j / 5000.0F) {
            break;
          }
          i = (j / 5000 + 1) * 5000;
          break;
        }
      }
      AppMethodBeat.o(20231);
      return;
      label417:
      i = 0;
    }
  }
  
  private float l(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(20226);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      AppMethodBeat.o(20226);
      return paramFloat;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(20230);
    getData();
    super.onDraw(paramCanvas);
    int i;
    Object localObject;
    float f;
    if (!this.lRl)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.lQd, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.lQb, this.paint);
        }
      }
      if (this.lPY != 2147483647)
      {
        i = this.lPY;
        this.paint.reset();
        this.paint.setColor(this.lPU);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(l(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.lRo)
          {
            this.lRn = (((Point)this.points.get(i)).y - this.lQP);
            this.startY = this.lRn;
            this.lRo = true;
          }
          if (this.lRo)
          {
            f = (float)(this.startY / 8.0D);
            if (this.lRn > 0) {
              this.paint.setAlpha((this.startY - this.lRn) * 255 / this.startY);
            }
            paramCanvas.drawText(this.lRd[i], ((Point)this.points.get(i)).x, this.lRn + this.lQP, this.paint);
            if (this.lRn <= 0) {
              break label1253;
            }
            if (this.lRn / this.startY > 1.0F / f) {
              break label1226;
            }
            this.lRn -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.lPY;
      if ((i >= 0) && (i <= 6)) {
        this.lRh[i] = true;
      }
      this.paint.reset();
      this.lRi.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.lPO);
      this.paint.setStrokeWidth(this.lQh);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.lQY != 0) && (!this.lRl))
      {
        this.lRi.moveTo(this.lQj, this.lQY);
        this.lRi.lineTo(this.jgD - this.lQr, this.lQY);
        paramCanvas.drawPath(this.lRi, this.paint);
      }
      this.paint.reset();
      this.lRi.reset();
      this.paint.setColor(this.lPO);
      this.paint.setStrokeWidth(this.lQh);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.lRi.reset();
      this.lRi.moveTo(this.lQz, this.jgE - this.lQv);
      this.lRi.lineTo(this.jgD - this.lQB, this.jgE - this.lQv);
      this.lRi.moveTo(this.lQz, this.lQx);
      this.lRi.lineTo(this.jgD - this.lQB, this.lQx);
      paramCanvas.drawPath(this.lRi, this.paint);
      if (!this.lRl)
      {
        this.paint.reset();
        this.paint.setColor(this.lPW);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(l(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131299451), this.jgD - this.lQD, (float)(this.lQY + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.lQZ);
      this.paint.setTextSize(l(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131299453), this.lQJ, this.lQH, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(l(2, 33.0F));
      paramCanvas.drawText(this.lRd[(this.lRd.length - 1)], this.jgD - this.lQN, this.lQL, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jgE - this.lQv, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        bri();
        if (!this.lRl) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.lRk);
      AppMethodBeat.o(20230);
      return;
      label1226:
      this.lRn = ((int)(this.lRn - this.lRn / this.startY * f));
      break;
      label1253:
      this.lRo = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20233);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    ab.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.lPY);
    switch (paramMotionEvent.getAction())
    {
    default: 
      ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      AppMethodBeat.o(20233);
      return false;
    case 0: 
      ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      AppMethodBeat.o(20233);
      return true;
    }
    ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.lPY = aI(f);
    brh();
    this.lRo = false;
    invalidate();
    AppMethodBeat.o(20233);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */