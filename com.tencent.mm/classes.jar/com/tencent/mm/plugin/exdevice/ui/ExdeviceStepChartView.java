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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int gfT;
  private int gfU;
  Paint paint;
  List<Point> points;
  private final float qnA;
  private final float qnB;
  private final int qnC;
  private final float qnD;
  private final int qnE;
  private final float qnF;
  private final int qnG;
  private final float qnH;
  private final int qnI;
  private final float qnJ;
  private final int qnK;
  private final float qnL;
  private final int qnM;
  private final float qnN;
  private final int qnO;
  private final float qnP;
  private final int qnQ;
  private final float qnR;
  private final int qnS;
  private final float qnT;
  private final int qnU;
  private final float qnV;
  private final int qnW;
  private final float qnX;
  private final int qnY;
  private final float qnZ;
  private final int qnn;
  private final int qno;
  private final int qnp;
  private final float qnq;
  private final float qnr;
  private final float qns;
  private final float qnt;
  private final float qnu;
  private final int qnv;
  private final int qnw;
  private final int qnx;
  private final int qny;
  private int qnz;
  private final Typeface qoA;
  private final Typeface qoB;
  private int qoC;
  private int qoD;
  private int[] qoE;
  private final int qoF;
  private float[] qoG;
  private float[] qoH;
  private boolean[] qoI;
  Path qoJ;
  Path qoK;
  List<String> qoL;
  private boolean qoM;
  PathEffect qoN;
  private int qoO;
  private boolean qoP;
  private final float qoa;
  private final float qob;
  private final float qoc;
  private final int qod;
  private final int qoe;
  private final int qof;
  private final int qog;
  private final float qoh;
  private final int qoi;
  private final float qoj;
  private final int qok;
  private final float qol;
  private final int qom;
  private final float qon;
  private final int qoo;
  private final float qop;
  private final int qoq;
  private final int qor;
  private final int qos;
  private final int qot;
  private final int qou;
  private final int qov;
  private final int qow;
  private final int qox;
  private final int qoy;
  private int qoz;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.qnn = -1;
    this.qno = -1;
    this.qnp = getResources().getColor(2131100298);
    this.qnq = 12.0F;
    this.qnr = 28.0F;
    this.qns = 33.0F;
    this.qnt = 12.0F;
    this.qnu = 12.0F;
    this.qnv = getResources().getColor(2131100299);
    this.qnw = -1;
    this.qnx = getResources().getColor(2131100299);
    this.qny = -1;
    this.qnz = 2147483647;
    this.gfT = 0;
    this.gfU = 0;
    this.qnA = 10.0F;
    this.qnB = 2.5F;
    this.qnC = ((int)p(1, 2.5F));
    this.qnD = 4.0F;
    this.qnE = ((int)p(1, 4.0F));
    this.qnF = 1.8F;
    this.qnG = ((int)p(1, 1.8F));
    this.qnH = 1.0F;
    this.qnI = ((int)p(1, 1.0F));
    this.qnJ = 8.0F;
    this.qnK = ((int)p(1, 8.0F));
    this.qnL = 22.0F;
    this.qnM = ((int)p(1, 22.0F));
    this.qnN = 67.0F;
    this.qnO = ((int)p(1, 67.0F));
    this.qnP = 40.0F;
    this.qnQ = ((int)p(1, 40.0F));
    this.qnR = 22.0F;
    this.qnS = ((int)p(1, 22.0F));
    this.qnT = 55.0F;
    this.qnU = ((int)p(1, 55.0F));
    this.qnV = 35.0F;
    this.qnW = ((int)p(1, 35.0F));
    this.qnX = 45.0F;
    this.qnY = ((int)p(1, 45.0F));
    this.qnZ = 8.0F;
    this.qoa = ((int)p(1, 8.0F));
    this.qob = 8.0F;
    this.qoc = ((int)p(1, 8.0F));
    this.qod = 2;
    this.qoe = ((int)p(1, 2.0F));
    this.qof = 15;
    this.qog = ((int)p(1, 15.0F));
    this.qoh = 33.0F;
    this.qoi = ((int)p(1, 33.0F));
    this.qoj = 8.0F;
    this.qok = ((int)p(1, 8.0F));
    this.qol = 35.0F;
    this.qom = ((int)p(1, 35.0F));
    this.qon = 10.0F;
    this.qoo = ((int)p(1, 10.0F));
    this.qop = 58.0F;
    this.qoq = ((int)p(1, 58.0F));
    this.qor = ((int)p(1, 1.0F));
    this.qos = 102;
    this.qot = 102;
    this.qou = 153;
    this.qov = 102;
    this.qow = 102;
    this.qox = 102;
    this.qoy = 204;
    this.qoz = 0;
    this.qoA = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qoB = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qoC = 0;
    this.qoD = 0;
    this.qoE = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.qoF = 7;
    this.qoG = new float[7];
    this.qoH = new float[7];
    this.qoI = new boolean[7];
    this.qoM = false;
    this.qoN = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cmC();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.qnn = -1;
    this.qno = -1;
    this.qnp = getResources().getColor(2131100298);
    this.qnq = 12.0F;
    this.qnr = 28.0F;
    this.qns = 33.0F;
    this.qnt = 12.0F;
    this.qnu = 12.0F;
    this.qnv = getResources().getColor(2131100299);
    this.qnw = -1;
    this.qnx = getResources().getColor(2131100299);
    this.qny = -1;
    this.qnz = 2147483647;
    this.gfT = 0;
    this.gfU = 0;
    this.qnA = 10.0F;
    this.qnB = 2.5F;
    this.qnC = ((int)p(1, 2.5F));
    this.qnD = 4.0F;
    this.qnE = ((int)p(1, 4.0F));
    this.qnF = 1.8F;
    this.qnG = ((int)p(1, 1.8F));
    this.qnH = 1.0F;
    this.qnI = ((int)p(1, 1.0F));
    this.qnJ = 8.0F;
    this.qnK = ((int)p(1, 8.0F));
    this.qnL = 22.0F;
    this.qnM = ((int)p(1, 22.0F));
    this.qnN = 67.0F;
    this.qnO = ((int)p(1, 67.0F));
    this.qnP = 40.0F;
    this.qnQ = ((int)p(1, 40.0F));
    this.qnR = 22.0F;
    this.qnS = ((int)p(1, 22.0F));
    this.qnT = 55.0F;
    this.qnU = ((int)p(1, 55.0F));
    this.qnV = 35.0F;
    this.qnW = ((int)p(1, 35.0F));
    this.qnX = 45.0F;
    this.qnY = ((int)p(1, 45.0F));
    this.qnZ = 8.0F;
    this.qoa = ((int)p(1, 8.0F));
    this.qob = 8.0F;
    this.qoc = ((int)p(1, 8.0F));
    this.qod = 2;
    this.qoe = ((int)p(1, 2.0F));
    this.qof = 15;
    this.qog = ((int)p(1, 15.0F));
    this.qoh = 33.0F;
    this.qoi = ((int)p(1, 33.0F));
    this.qoj = 8.0F;
    this.qok = ((int)p(1, 8.0F));
    this.qol = 35.0F;
    this.qom = ((int)p(1, 35.0F));
    this.qon = 10.0F;
    this.qoo = ((int)p(1, 10.0F));
    this.qop = 58.0F;
    this.qoq = ((int)p(1, 58.0F));
    this.qor = ((int)p(1, 1.0F));
    this.qos = 102;
    this.qot = 102;
    this.qou = 153;
    this.qov = 102;
    this.qow = 102;
    this.qox = 102;
    this.qoy = 204;
    this.qoz = 0;
    this.qoA = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qoB = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qoC = 0;
    this.qoD = 0;
    this.qoE = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.qoF = 7;
    this.qoG = new float[7];
    this.qoH = new float[7];
    this.qoI = new boolean[7];
    this.qoM = false;
    this.qoN = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    cmC();
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
          if (this.qoI[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.gfU - this.qog, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.qnv);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int aY(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.qnz = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.qoC / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.qnz = i;
        invalidate();
      }
      for (;;)
      {
        i = this.qnz;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.qoC / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.qoC / 2)) {
            break;
          }
          this.qnz = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.gfT) || (paramFloat <= ((Point)this.points.get(i)).x - this.qoC / 2)) {
            break;
          }
          this.qnz = i;
          invalidate();
        }
        else
        {
          this.qnz = 2147483647;
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
      this.qoK.reset();
      this.qoK.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.qoK.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.qoK.lineTo(this.qoG[(this.qoG.length - 1)], this.gfU - this.qnW - 1);
      this.qoK.lineTo(this.qnK, this.gfU - this.qnW - 1);
      this.qoK.lineTo(this.qnK, this.qoH[0]);
      paramCanvas.drawPath(this.qoK, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.qoK.reset();
    this.qoK.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.gfU - this.qnQ)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.qnG);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.qoK.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.qoK, this.paint);
        this.qoK.reset();
        this.qoK.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        cmE();
        continue;
        cmE();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void cmC()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.qoJ = new Path();
    this.qoK = new Path();
    this.points = new LinkedList();
    this.qoL = new LinkedList();
    cmD();
    AppMethodBeat.o(24301);
  }
  
  private void cmD()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.qoI[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.qoI[i] = false;
      }
    }
  }
  
  private void cmE()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.qnG);
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
    this.gfT = localView.getWidth();
    this.gfU = localView.getHeight();
    this.qoC = ((this.gfT - this.qnK - this.qnM) / 6);
    this.qoD = ((this.gfU - this.qnO - this.qnQ) / 2);
    int i = 0;
    while (i < this.qoG.length)
    {
      this.qoG[i] = (this.qnK + this.qoC * i);
      i += 1;
    }
    i = this.qoE.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.qoE[i] > 100000) {
        this.qoE[i] = 100000;
      }
      if (this.qoE[i] < 0) {
        this.qoE[i] = 0;
      }
      m = j;
      if (this.qoE[i] > j) {
        m = this.qoE[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.qoz = ((this.gfU - this.qnO - this.qnQ) * 10000 / i);
      this.qoz = (this.gfU - this.qnQ - this.qoz);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.qoH[j] = (this.gfU - this.qnQ - this.qoE[j] / i * (this.gfU - this.qnO - this.qnQ));
          this.points.add(new Point((int)this.qoG[j], (int)this.qoH[j]));
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
    if (!this.qoM)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.qnE, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.qnC, this.paint);
        }
      }
      if (this.qnz != 2147483647)
      {
        i = this.qnz;
        this.paint.reset();
        this.paint.setColor(this.qnv);
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
          if (!this.qoP)
          {
            this.qoO = (((Point)this.points.get(i)).y - this.qoq);
            this.startY = this.qoO;
            this.qoP = true;
          }
          if (this.qoP)
          {
            f = (float)(this.startY / 8.0D);
            if (this.qoO > 0) {
              this.paint.setAlpha((this.startY - this.qoO) * 255 / this.startY);
            }
            paramCanvas.drawText(this.qoE[i], ((Point)this.points.get(i)).x, this.qoO + this.qoq, this.paint);
            if (this.qoO <= 0) {
              break label1253;
            }
            if (this.qoO / this.startY > 1.0F / f) {
              break label1226;
            }
            this.qoO -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.qnz;
      if ((i >= 0) && (i <= 6)) {
        this.qoI[i] = true;
      }
      this.paint.reset();
      this.qoJ.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.qnp);
      this.paint.setStrokeWidth(this.qnI);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.qoz != 0) && (!this.qoM))
      {
        this.qoJ.moveTo(this.qnK, this.qoz);
        this.qoJ.lineTo(this.gfT - this.qnS, this.qoz);
        paramCanvas.drawPath(this.qoJ, this.paint);
      }
      this.paint.reset();
      this.qoJ.reset();
      this.paint.setColor(this.qnp);
      this.paint.setStrokeWidth(this.qnI);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.qoJ.reset();
      this.qoJ.moveTo(this.qoa, this.gfU - this.qnW);
      this.qoJ.lineTo(this.gfT - this.qoc, this.gfU - this.qnW);
      this.qoJ.moveTo(this.qoa, this.qnY);
      this.qoJ.lineTo(this.gfT - this.qoc, this.qnY);
      paramCanvas.drawPath(this.qoJ, this.paint);
      if (!this.qoM)
      {
        this.paint.reset();
        this.paint.setColor(this.qnx);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(p(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131758581), this.gfT - this.qoe, (float)(this.qoz + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.qoA);
      this.paint.setTextSize(p(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131758583), this.qok, this.qoi, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(p(2, 33.0F));
      paramCanvas.drawText(this.qoE[(this.qoE.length - 1)], this.gfT - this.qoo, this.qom, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gfU - this.qnW, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        cmE();
        if (!this.qoM) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.qoL);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.qoO = ((int)(this.qoO - this.qoO / this.startY * f));
      break;
      label1253:
      this.qoP = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    ad.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.qnz);
    switch (paramMotionEvent.getAction())
    {
    default: 
      ad.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      AppMethodBeat.o(24306);
      return false;
    case 0: 
      ad.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      AppMethodBeat.o(24306);
      return true;
    }
    ad.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.qnz = aY(f);
    cmD();
    this.qoP = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */