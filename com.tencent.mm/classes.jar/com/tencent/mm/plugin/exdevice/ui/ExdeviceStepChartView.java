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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int gil;
  private int gim;
  Paint paint;
  List<Point> points;
  private final int qtS;
  private final int qtT;
  private final int qtU;
  private final float qtV;
  private final float qtW;
  private final float qtX;
  private final float qtY;
  private final float qtZ;
  private final int quA;
  private final float quB;
  private final int quC;
  private final float quD;
  private final int quE;
  private final float quF;
  private final float quG;
  private final float quH;
  private final float quI;
  private final int quJ;
  private final int quK;
  private final int quL;
  private final int quM;
  private final float quN;
  private final int quO;
  private final float quP;
  private final int quQ;
  private final float quR;
  private final int quS;
  private final float quT;
  private final int quU;
  private final float quV;
  private final int quW;
  private final int quX;
  private final int quY;
  private final int quZ;
  private final int qub;
  private final int quc;
  private final int qud;
  private final int que;
  private int quf;
  private final float qug;
  private final float quh;
  private final int qui;
  private final float quj;
  private final int quk;
  private final float qul;
  private final int qum;
  private final float qun;
  private final int quo;
  private final float qup;
  private final int quq;
  private final float qur;
  private final int qus;
  private final float qut;
  private final int quu;
  private final float quv;
  private final int quw;
  private final float qux;
  private final int quy;
  private final float quz;
  private final int qva;
  private final int qvb;
  private final int qvc;
  private final int qvd;
  private final int qve;
  private int qvf;
  private final Typeface qvg;
  private final Typeface qvh;
  private int qvi;
  private int qvj;
  private int[] qvk;
  private final int qvl;
  private float[] qvm;
  private float[] qvn;
  private boolean[] qvo;
  Path qvp;
  Path qvq;
  List<String> qvr;
  private boolean qvs;
  PathEffect qvt;
  private int qvu;
  private boolean qvv;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.qtS = -1;
    this.qtT = -1;
    this.qtU = getResources().getColor(2131100298);
    this.qtV = 12.0F;
    this.qtW = 28.0F;
    this.qtX = 33.0F;
    this.qtY = 12.0F;
    this.qtZ = 12.0F;
    this.qub = getResources().getColor(2131100299);
    this.quc = -1;
    this.qud = getResources().getColor(2131100299);
    this.que = -1;
    this.quf = 2147483647;
    this.gil = 0;
    this.gim = 0;
    this.qug = 10.0F;
    this.quh = 2.5F;
    this.qui = ((int)p(1, 2.5F));
    this.quj = 4.0F;
    this.quk = ((int)p(1, 4.0F));
    this.qul = 1.8F;
    this.qum = ((int)p(1, 1.8F));
    this.qun = 1.0F;
    this.quo = ((int)p(1, 1.0F));
    this.qup = 8.0F;
    this.quq = ((int)p(1, 8.0F));
    this.qur = 22.0F;
    this.qus = ((int)p(1, 22.0F));
    this.qut = 67.0F;
    this.quu = ((int)p(1, 67.0F));
    this.quv = 40.0F;
    this.quw = ((int)p(1, 40.0F));
    this.qux = 22.0F;
    this.quy = ((int)p(1, 22.0F));
    this.quz = 55.0F;
    this.quA = ((int)p(1, 55.0F));
    this.quB = 35.0F;
    this.quC = ((int)p(1, 35.0F));
    this.quD = 45.0F;
    this.quE = ((int)p(1, 45.0F));
    this.quF = 8.0F;
    this.quG = ((int)p(1, 8.0F));
    this.quH = 8.0F;
    this.quI = ((int)p(1, 8.0F));
    this.quJ = 2;
    this.quK = ((int)p(1, 2.0F));
    this.quL = 15;
    this.quM = ((int)p(1, 15.0F));
    this.quN = 33.0F;
    this.quO = ((int)p(1, 33.0F));
    this.quP = 8.0F;
    this.quQ = ((int)p(1, 8.0F));
    this.quR = 35.0F;
    this.quS = ((int)p(1, 35.0F));
    this.quT = 10.0F;
    this.quU = ((int)p(1, 10.0F));
    this.quV = 58.0F;
    this.quW = ((int)p(1, 58.0F));
    this.quX = ((int)p(1, 1.0F));
    this.quY = 102;
    this.quZ = 102;
    this.qva = 153;
    this.qvb = 102;
    this.qvc = 102;
    this.qvd = 102;
    this.qve = 204;
    this.qvf = 0;
    this.qvg = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qvh = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qvi = 0;
    this.qvj = 0;
    this.qvk = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.qvl = 7;
    this.qvm = new float[7];
    this.qvn = new float[7];
    this.qvo = new boolean[7];
    this.qvs = false;
    this.qvt = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cnS();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.qtS = -1;
    this.qtT = -1;
    this.qtU = getResources().getColor(2131100298);
    this.qtV = 12.0F;
    this.qtW = 28.0F;
    this.qtX = 33.0F;
    this.qtY = 12.0F;
    this.qtZ = 12.0F;
    this.qub = getResources().getColor(2131100299);
    this.quc = -1;
    this.qud = getResources().getColor(2131100299);
    this.que = -1;
    this.quf = 2147483647;
    this.gil = 0;
    this.gim = 0;
    this.qug = 10.0F;
    this.quh = 2.5F;
    this.qui = ((int)p(1, 2.5F));
    this.quj = 4.0F;
    this.quk = ((int)p(1, 4.0F));
    this.qul = 1.8F;
    this.qum = ((int)p(1, 1.8F));
    this.qun = 1.0F;
    this.quo = ((int)p(1, 1.0F));
    this.qup = 8.0F;
    this.quq = ((int)p(1, 8.0F));
    this.qur = 22.0F;
    this.qus = ((int)p(1, 22.0F));
    this.qut = 67.0F;
    this.quu = ((int)p(1, 67.0F));
    this.quv = 40.0F;
    this.quw = ((int)p(1, 40.0F));
    this.qux = 22.0F;
    this.quy = ((int)p(1, 22.0F));
    this.quz = 55.0F;
    this.quA = ((int)p(1, 55.0F));
    this.quB = 35.0F;
    this.quC = ((int)p(1, 35.0F));
    this.quD = 45.0F;
    this.quE = ((int)p(1, 45.0F));
    this.quF = 8.0F;
    this.quG = ((int)p(1, 8.0F));
    this.quH = 8.0F;
    this.quI = ((int)p(1, 8.0F));
    this.quJ = 2;
    this.quK = ((int)p(1, 2.0F));
    this.quL = 15;
    this.quM = ((int)p(1, 15.0F));
    this.quN = 33.0F;
    this.quO = ((int)p(1, 33.0F));
    this.quP = 8.0F;
    this.quQ = ((int)p(1, 8.0F));
    this.quR = 35.0F;
    this.quS = ((int)p(1, 35.0F));
    this.quT = 10.0F;
    this.quU = ((int)p(1, 10.0F));
    this.quV = 58.0F;
    this.quW = ((int)p(1, 58.0F));
    this.quX = ((int)p(1, 1.0F));
    this.quY = 102;
    this.quZ = 102;
    this.qva = 153;
    this.qvb = 102;
    this.qvc = 102;
    this.qvd = 102;
    this.qve = 204;
    this.qvf = 0;
    this.qvg = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qvh = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qvi = 0;
    this.qvj = 0;
    this.qvk = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.qvl = 7;
    this.qvm = new float[7];
    this.qvn = new float[7];
    this.qvo = new boolean[7];
    this.qvs = false;
    this.qvt = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cnS();
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
      this.paint.setTextSize(p(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.qvo[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.gim - this.quM, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.qub);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int aY(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.quf = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.qvi / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.quf = i;
        invalidate();
      }
      for (;;)
      {
        i = this.quf;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.qvi / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.qvi / 2)) {
            break;
          }
          this.quf = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.gil) || (paramFloat <= ((Point)this.points.get(i)).x - this.qvi / 2)) {
            break;
          }
          this.quf = i;
          invalidate();
        }
        else
        {
          this.quf = 2147483647;
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
      this.qvq.reset();
      this.qvq.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.qvq.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.qvq.lineTo(this.qvm[(this.qvm.length - 1)], this.gim - this.quC - 1);
      this.qvq.lineTo(this.quq, this.gim - this.quC - 1);
      this.qvq.lineTo(this.quq, this.qvn[0]);
      paramCanvas.drawPath(this.qvq, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.qvq.reset();
    this.qvq.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.gim - this.quw)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.qum);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.qvq.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.qvq, this.paint);
        this.qvq.reset();
        this.qvq.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        cnU();
        continue;
        cnU();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void cnS()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.qvp = new Path();
    this.qvq = new Path();
    this.points = new LinkedList();
    this.qvr = new LinkedList();
    cnT();
    AppMethodBeat.o(24301);
  }
  
  private void cnT()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.qvo[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.qvo[i] = false;
      }
    }
  }
  
  private void cnU()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.qum);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(24302);
  }
  
  private void getData()
  {
    int n = 0;
    AppMethodBeat.i(24304);
    this.points.clear();
    View localView = findViewById(2131299585);
    this.gil = localView.getWidth();
    this.gim = localView.getHeight();
    this.qvi = ((this.gil - this.quq - this.qus) / 6);
    this.qvj = ((this.gim - this.quu - this.quw) / 2);
    int i = 0;
    while (i < this.qvm.length)
    {
      this.qvm[i] = (this.quq + this.qvi * i);
      i += 1;
    }
    i = this.qvk.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.qvk[i] > 100000) {
        this.qvk[i] = 100000;
      }
      if (this.qvk[i] < 0) {
        this.qvk[i] = 0;
      }
      m = j;
      if (this.qvk[i] > j) {
        m = this.qvk[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.qvf = ((this.gim - this.quu - this.quw) * 10000 / i);
      this.qvf = (this.gim - this.quw - this.qvf);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.qvn[j] = (this.gim - this.quw - this.qvk[j] / i * (this.gim - this.quu - this.quw));
          this.points.add(new Point((int)this.qvm[j], (int)this.qvn[j]));
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
      AppMethodBeat.o(24304);
      return;
      label417:
      i = 0;
    }
  }
  
  private float p(int paramInt, float paramFloat)
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
    if (!this.qvs)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.quk, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.qui, this.paint);
        }
      }
      if (this.quf != 2147483647)
      {
        i = this.quf;
        this.paint.reset();
        this.paint.setColor(this.qub);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(p(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.qvv)
          {
            this.qvu = (((Point)this.points.get(i)).y - this.quW);
            this.startY = this.qvu;
            this.qvv = true;
          }
          if (this.qvv)
          {
            f = (float)(this.startY / 8.0D);
            if (this.qvu > 0) {
              this.paint.setAlpha((this.startY - this.qvu) * 255 / this.startY);
            }
            paramCanvas.drawText(this.qvk[i], ((Point)this.points.get(i)).x, this.qvu + this.quW, this.paint);
            if (this.qvu <= 0) {
              break label1253;
            }
            if (this.qvu / this.startY > 1.0F / f) {
              break label1226;
            }
            this.qvu -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.quf;
      if ((i >= 0) && (i <= 6)) {
        this.qvo[i] = true;
      }
      this.paint.reset();
      this.qvp.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.qtU);
      this.paint.setStrokeWidth(this.quo);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.qvf != 0) && (!this.qvs))
      {
        this.qvp.moveTo(this.quq, this.qvf);
        this.qvp.lineTo(this.gil - this.quy, this.qvf);
        paramCanvas.drawPath(this.qvp, this.paint);
      }
      this.paint.reset();
      this.qvp.reset();
      this.paint.setColor(this.qtU);
      this.paint.setStrokeWidth(this.quo);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.qvp.reset();
      this.qvp.moveTo(this.quG, this.gim - this.quC);
      this.qvp.lineTo(this.gil - this.quI, this.gim - this.quC);
      this.qvp.moveTo(this.quG, this.quE);
      this.qvp.lineTo(this.gil - this.quI, this.quE);
      paramCanvas.drawPath(this.qvp, this.paint);
      if (!this.qvs)
      {
        this.paint.reset();
        this.paint.setColor(this.qud);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(p(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131758581), this.gil - this.quK, (float)(this.qvf + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.qvg);
      this.paint.setTextSize(p(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131758583), this.quQ, this.quO, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(p(2, 33.0F));
      paramCanvas.drawText(this.qvk[(this.qvk.length - 1)], this.gil - this.quU, this.quS, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gim - this.quC, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        cnU();
        if (!this.qvs) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.qvr);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.qvu = ((int)(this.qvu - this.qvu / this.startY * f));
      break;
      label1253:
      this.qvv = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    ae.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.quf);
    switch (paramMotionEvent.getAction())
    {
    default: 
      ae.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      AppMethodBeat.o(24306);
      return false;
    case 0: 
      ae.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      AppMethodBeat.o(24306);
      return true;
    }
    ae.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.quf = aY(f);
    cnT();
    this.qvv = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */