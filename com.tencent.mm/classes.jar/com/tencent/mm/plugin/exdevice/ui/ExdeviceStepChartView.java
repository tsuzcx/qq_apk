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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  private int fMt;
  private int fMu;
  private final int pJI;
  private final int pJJ;
  private final int pJK;
  private final float pJL;
  private final float pJM;
  private final float pJN;
  private final float pJO;
  private final float pJP;
  private final int pJQ;
  private final int pJR;
  private final int pJS;
  private final int pJT;
  private int pJU;
  private final float pJV;
  private final float pJW;
  private final int pJX;
  private final float pJY;
  private final int pJZ;
  private final int pKA;
  private final int pKB;
  private final float pKC;
  private final int pKD;
  private final float pKE;
  private final int pKF;
  private final float pKG;
  private final int pKH;
  private final float pKI;
  private final int pKJ;
  private final float pKK;
  private final int pKL;
  private final int pKM;
  private final int pKN;
  private final int pKO;
  private final int pKP;
  private final int pKQ;
  private final int pKR;
  private final int pKS;
  private final int pKT;
  private int pKU;
  private final Typeface pKV;
  private final Typeface pKW;
  private int pKX;
  private int pKY;
  private int[] pKZ;
  private final float pKa;
  private final int pKb;
  private final float pKc;
  private final int pKd;
  private final float pKe;
  private final int pKf;
  private final float pKg;
  private final int pKh;
  private final float pKi;
  private final int pKj;
  private final float pKk;
  private final int pKl;
  private final float pKm;
  private final int pKn;
  private final float pKo;
  private final int pKp;
  private final float pKq;
  private final int pKr;
  private final float pKs;
  private final int pKt;
  private final float pKu;
  private final float pKv;
  private final float pKw;
  private final float pKx;
  private final int pKy;
  private final int pKz;
  private final int pLa;
  private float[] pLb;
  private float[] pLc;
  private boolean[] pLd;
  Path pLe;
  Path pLf;
  List<String> pLg;
  private boolean pLh;
  PathEffect pLi;
  private int pLj;
  private boolean pLk;
  Paint paint;
  List<Point> points;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.pJI = -1;
    this.pJJ = -1;
    this.pJK = getResources().getColor(2131100298);
    this.pJL = 12.0F;
    this.pJM = 28.0F;
    this.pJN = 33.0F;
    this.pJO = 12.0F;
    this.pJP = 12.0F;
    this.pJQ = getResources().getColor(2131100299);
    this.pJR = -1;
    this.pJS = getResources().getColor(2131100299);
    this.pJT = -1;
    this.pJU = 2147483647;
    this.fMt = 0;
    this.fMu = 0;
    this.pJV = 10.0F;
    this.pJW = 2.5F;
    this.pJX = ((int)o(1, 2.5F));
    this.pJY = 4.0F;
    this.pJZ = ((int)o(1, 4.0F));
    this.pKa = 1.8F;
    this.pKb = ((int)o(1, 1.8F));
    this.pKc = 1.0F;
    this.pKd = ((int)o(1, 1.0F));
    this.pKe = 8.0F;
    this.pKf = ((int)o(1, 8.0F));
    this.pKg = 22.0F;
    this.pKh = ((int)o(1, 22.0F));
    this.pKi = 67.0F;
    this.pKj = ((int)o(1, 67.0F));
    this.pKk = 40.0F;
    this.pKl = ((int)o(1, 40.0F));
    this.pKm = 22.0F;
    this.pKn = ((int)o(1, 22.0F));
    this.pKo = 55.0F;
    this.pKp = ((int)o(1, 55.0F));
    this.pKq = 35.0F;
    this.pKr = ((int)o(1, 35.0F));
    this.pKs = 45.0F;
    this.pKt = ((int)o(1, 45.0F));
    this.pKu = 8.0F;
    this.pKv = ((int)o(1, 8.0F));
    this.pKw = 8.0F;
    this.pKx = ((int)o(1, 8.0F));
    this.pKy = 2;
    this.pKz = ((int)o(1, 2.0F));
    this.pKA = 15;
    this.pKB = ((int)o(1, 15.0F));
    this.pKC = 33.0F;
    this.pKD = ((int)o(1, 33.0F));
    this.pKE = 8.0F;
    this.pKF = ((int)o(1, 8.0F));
    this.pKG = 35.0F;
    this.pKH = ((int)o(1, 35.0F));
    this.pKI = 10.0F;
    this.pKJ = ((int)o(1, 10.0F));
    this.pKK = 58.0F;
    this.pKL = ((int)o(1, 58.0F));
    this.pKM = ((int)o(1, 1.0F));
    this.pKN = 102;
    this.pKO = 102;
    this.pKP = 153;
    this.pKQ = 102;
    this.pKR = 102;
    this.pKS = 102;
    this.pKT = 204;
    this.pKU = 0;
    this.pKV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.pKW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.pKX = 0;
    this.pKY = 0;
    this.pKZ = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.pLa = 7;
    this.pLb = new float[7];
    this.pLc = new float[7];
    this.pLd = new boolean[7];
    this.pLh = false;
    this.pLi = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    chY();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.pJI = -1;
    this.pJJ = -1;
    this.pJK = getResources().getColor(2131100298);
    this.pJL = 12.0F;
    this.pJM = 28.0F;
    this.pJN = 33.0F;
    this.pJO = 12.0F;
    this.pJP = 12.0F;
    this.pJQ = getResources().getColor(2131100299);
    this.pJR = -1;
    this.pJS = getResources().getColor(2131100299);
    this.pJT = -1;
    this.pJU = 2147483647;
    this.fMt = 0;
    this.fMu = 0;
    this.pJV = 10.0F;
    this.pJW = 2.5F;
    this.pJX = ((int)o(1, 2.5F));
    this.pJY = 4.0F;
    this.pJZ = ((int)o(1, 4.0F));
    this.pKa = 1.8F;
    this.pKb = ((int)o(1, 1.8F));
    this.pKc = 1.0F;
    this.pKd = ((int)o(1, 1.0F));
    this.pKe = 8.0F;
    this.pKf = ((int)o(1, 8.0F));
    this.pKg = 22.0F;
    this.pKh = ((int)o(1, 22.0F));
    this.pKi = 67.0F;
    this.pKj = ((int)o(1, 67.0F));
    this.pKk = 40.0F;
    this.pKl = ((int)o(1, 40.0F));
    this.pKm = 22.0F;
    this.pKn = ((int)o(1, 22.0F));
    this.pKo = 55.0F;
    this.pKp = ((int)o(1, 55.0F));
    this.pKq = 35.0F;
    this.pKr = ((int)o(1, 35.0F));
    this.pKs = 45.0F;
    this.pKt = ((int)o(1, 45.0F));
    this.pKu = 8.0F;
    this.pKv = ((int)o(1, 8.0F));
    this.pKw = 8.0F;
    this.pKx = ((int)o(1, 8.0F));
    this.pKy = 2;
    this.pKz = ((int)o(1, 2.0F));
    this.pKA = 15;
    this.pKB = ((int)o(1, 15.0F));
    this.pKC = 33.0F;
    this.pKD = ((int)o(1, 33.0F));
    this.pKE = 8.0F;
    this.pKF = ((int)o(1, 8.0F));
    this.pKG = 35.0F;
    this.pKH = ((int)o(1, 35.0F));
    this.pKI = 10.0F;
    this.pKJ = ((int)o(1, 10.0F));
    this.pKK = 58.0F;
    this.pKL = ((int)o(1, 58.0F));
    this.pKM = ((int)o(1, 1.0F));
    this.pKN = 102;
    this.pKO = 102;
    this.pKP = 153;
    this.pKQ = 102;
    this.pKR = 102;
    this.pKS = 102;
    this.pKT = 204;
    this.pKU = 0;
    this.pKV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.pKW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.pKX = 0;
    this.pKY = 0;
    this.pKZ = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.pLa = 7;
    this.pLb = new float[7];
    this.pLc = new float[7];
    this.pLd = new boolean[7];
    this.pLh = false;
    this.pLi = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    chY();
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
      this.paint.setTextSize(o(2, 12.0F));
      this.paint.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.paint.setTextAlign(Paint.Align.LEFT);
          label94:
          if (this.pLd[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.fMu - this.pKB, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.pJQ);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int aV(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.pJU = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.pKX / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.pJU = i;
        invalidate();
      }
      for (;;)
      {
        i = this.pJU;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.pKX / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.pKX / 2)) {
            break;
          }
          this.pJU = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.fMt) || (paramFloat <= ((Point)this.points.get(i)).x - this.pKX / 2)) {
            break;
          }
          this.pJU = i;
          invalidate();
        }
        else
        {
          this.pJU = 2147483647;
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
      this.pLf.reset();
      this.pLf.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.pLf.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.pLf.lineTo(this.pLb[(this.pLb.length - 1)], this.fMu - this.pKr - 1);
      this.pLf.lineTo(this.pKf, this.fMu - this.pKr - 1);
      this.pLf.lineTo(this.pKf, this.pLc[0]);
      paramCanvas.drawPath(this.pLf, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.pLf.reset();
    this.pLf.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.fMu - this.pKl)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.pKb);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.pLf.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.pLf, this.paint);
        this.pLf.reset();
        this.pLf.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        cia();
        continue;
        cia();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void chY()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.pLe = new Path();
    this.pLf = new Path();
    this.points = new LinkedList();
    this.pLg = new LinkedList();
    chZ();
    AppMethodBeat.o(24301);
  }
  
  private void chZ()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.pLd[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.pLd[i] = false;
      }
    }
  }
  
  private void cia()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.pKb);
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
    this.fMt = localView.getWidth();
    this.fMu = localView.getHeight();
    this.pKX = ((this.fMt - this.pKf - this.pKh) / 6);
    this.pKY = ((this.fMu - this.pKj - this.pKl) / 2);
    int i = 0;
    while (i < this.pLb.length)
    {
      this.pLb[i] = (this.pKf + this.pKX * i);
      i += 1;
    }
    i = this.pKZ.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.pKZ[i] > 100000) {
        this.pKZ[i] = 100000;
      }
      if (this.pKZ[i] < 0) {
        this.pKZ[i] = 0;
      }
      m = j;
      if (this.pKZ[i] > j) {
        m = this.pKZ[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.pKU = ((this.fMu - this.pKj - this.pKl) * 10000 / i);
      this.pKU = (this.fMu - this.pKl - this.pKU);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.pLc[j] = (this.fMu - this.pKl - this.pKZ[j] / i * (this.fMu - this.pKj - this.pKl));
          this.points.add(new Point((int)this.pLb[j], (int)this.pLc[j]));
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
  
  private float o(int paramInt, float paramFloat)
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
    if (!this.pLh)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.pJZ, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.pJX, this.paint);
        }
      }
      if (this.pJU != 2147483647)
      {
        i = this.pJU;
        this.paint.reset();
        this.paint.setColor(this.pJQ);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(o(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.paint.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.pLk)
          {
            this.pLj = (((Point)this.points.get(i)).y - this.pKL);
            this.startY = this.pLj;
            this.pLk = true;
          }
          if (this.pLk)
          {
            f = (float)(this.startY / 8.0D);
            if (this.pLj > 0) {
              this.paint.setAlpha((this.startY - this.pLj) * 255 / this.startY);
            }
            paramCanvas.drawText(this.pKZ[i], ((Point)this.points.get(i)).x, this.pLj + this.pKL, this.paint);
            if (this.pLj <= 0) {
              break label1253;
            }
            if (this.pLj / this.startY > 1.0F / f) {
              break label1226;
            }
            this.pLj -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.pJU;
      if ((i >= 0) && (i <= 6)) {
        this.pLd[i] = true;
      }
      this.paint.reset();
      this.pLe.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.pJK);
      this.paint.setStrokeWidth(this.pKd);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.pKU != 0) && (!this.pLh))
      {
        this.pLe.moveTo(this.pKf, this.pKU);
        this.pLe.lineTo(this.fMt - this.pKn, this.pKU);
        paramCanvas.drawPath(this.pLe, this.paint);
      }
      this.paint.reset();
      this.pLe.reset();
      this.paint.setColor(this.pJK);
      this.paint.setStrokeWidth(this.pKd);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.pLe.reset();
      this.pLe.moveTo(this.pKv, this.fMu - this.pKr);
      this.pLe.lineTo(this.fMt - this.pKx, this.fMu - this.pKr);
      this.pLe.moveTo(this.pKv, this.pKt);
      this.pLe.lineTo(this.fMt - this.pKx, this.pKt);
      paramCanvas.drawPath(this.pLe, this.paint);
      if (!this.pLh)
      {
        this.paint.reset();
        this.paint.setColor(this.pJS);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(o(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131758581), this.fMt - this.pKz, (float)(this.pKU + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.pKV);
      this.paint.setTextSize(o(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131758583), this.pKF, this.pKD, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(o(2, 33.0F));
      paramCanvas.drawText(this.pKZ[(this.pKZ.length - 1)], this.fMt - this.pKJ, this.pKH, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.fMu - this.pKr, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        cia();
        if (!this.pLh) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.pLg);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.pLj = ((int)(this.pLj - this.pLj / this.startY * f));
      break;
      label1253:
      this.pLk = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    ac.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.pJU);
    switch (paramMotionEvent.getAction())
    {
    default: 
      ac.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      AppMethodBeat.o(24306);
      return false;
    case 0: 
      ac.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      AppMethodBeat.o(24306);
      return true;
    }
    ac.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.pJU = aV(f);
    chZ();
    this.pLk = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */