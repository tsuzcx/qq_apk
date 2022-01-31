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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView
  extends View
{
  Paint gaZ;
  private int jGA = 2147483647;
  private final float jGB = 10.0F;
  private final float jGC = 2.5F;
  private final int jGD = (int)j(1, 2.5F);
  private final float jGE = 4.0F;
  private final int jGF = (int)j(1, 4.0F);
  private final float jGG = 1.8F;
  private final int jGH = (int)j(1, 1.8F);
  private final float jGI = 1.0F;
  private final int jGJ = (int)j(1, 1.0F);
  private final float jGK = 8.0F;
  private final int jGL = (int)j(1, 8.0F);
  private final float jGM = 22.0F;
  private final int jGN = (int)j(1, 22.0F);
  private final float jGO = 67.0F;
  private final int jGP = (int)j(1, 67.0F);
  private final float jGQ = 40.0F;
  private final int jGR = (int)j(1, 40.0F);
  private final float jGS = 22.0F;
  private final int jGT = (int)j(1, 22.0F);
  private final float jGU = 55.0F;
  private final int jGV = (int)j(1, 55.0F);
  private final float jGW = 35.0F;
  private final int jGX = (int)j(1, 35.0F);
  private final float jGY = 45.0F;
  private final int jGZ = (int)j(1, 45.0F);
  private final int jGo = -1;
  private final int jGp = -1;
  private final int jGq = getResources().getColor(R.e.exdevice_step_chart_background_line_color);
  private final float jGr = 12.0F;
  private final float jGs = 28.0F;
  private final float jGt = 33.0F;
  private final float jGu = 12.0F;
  private final float jGv = 12.0F;
  private final int jGw = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
  private final int jGx = -1;
  private final int jGy = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
  private final int jGz = -1;
  private int jHA = 0;
  private final Typeface jHB = Typeface.create(Typeface.DEFAULT_BOLD, 0);
  private final Typeface jHC = Typeface.create(Typeface.DEFAULT_BOLD, 1);
  private int jHD = 0;
  private int jHE = 0;
  private int[] jHF = { 0, 0, 0, 0, 0, 0, 0 };
  private final int jHG = 7;
  private float[] jHH = new float[7];
  private float[] jHI = new float[7];
  private boolean[] jHJ = new boolean[7];
  Path jHK;
  Path jHL;
  List<String> jHM;
  private boolean jHN = false;
  PathEffect jHO = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
  private int jHP;
  private boolean jHQ;
  private final float jHa = 8.0F;
  private final float jHb = (int)j(1, 8.0F);
  private final float jHc = 8.0F;
  private final float jHd = (int)j(1, 8.0F);
  private final int jHe = 2;
  private final int jHf = (int)j(1, 2.0F);
  private final int jHg = 15;
  private final int jHh = (int)j(1, 15.0F);
  private final float jHi = 33.0F;
  private final int jHj = (int)j(1, 33.0F);
  private final float jHk = 8.0F;
  private final int jHl = (int)j(1, 8.0F);
  private final float jHm = 35.0F;
  private final int jHn = (int)j(1, 35.0F);
  private final float jHo = 10.0F;
  private final int jHp = (int)j(1, 10.0F);
  private final float jHq = 58.0F;
  private final int jHr = (int)j(1, 58.0F);
  private final int jHs = (int)j(1, 1.0F);
  private final int jHt = 102;
  private final int jHu = 102;
  private final int jHv = 153;
  private final int jHw = 102;
  private final int jHx = 102;
  private final int jHy = 102;
  private final int jHz = 204;
  private int jsq = 0;
  private int jsr = 0;
  List<Point> points;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aMS();
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    aMS();
  }
  
  private void aMS()
  {
    this.gaZ = new Paint();
    this.jHK = new Path();
    this.jHL = new Path();
    this.points = new LinkedList();
    this.jHM = new LinkedList();
    aMT();
  }
  
  private void aMT()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.jHJ[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.jHJ[i] = false;
      }
    }
  }
  
  private void aMU()
  {
    this.gaZ.reset();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setStrokeWidth(this.jGH);
    this.gaZ.setStyle(Paint.Style.STROKE);
    this.gaZ.setColor(-1);
  }
  
  private int aq(float paramFloat)
  {
    this.jGA = 2147483647;
    int i;
    if (this.points.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.points.size())
      {
        if (i != 0) {
          break label86;
        }
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.jHD / 2) || (paramFloat <= 0.0F)) {
          break label250;
        }
        this.jGA = i;
        invalidate();
      }
      for (;;)
      {
        return this.jGA;
        label86:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.jHD / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.jHD / 2)) {
            break;
          }
          this.jGA = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.jsq) || (paramFloat <= ((Point)this.points.get(i)).x - this.jHD / 2)) {
            break;
          }
          this.jGA = i;
          invalidate();
        }
        else
        {
          this.jGA = 2147483647;
        }
      }
      label250:
      i += 1;
    }
  }
  
  private void b(Canvas paramCanvas, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() == 7))
    {
      this.gaZ.reset();
      this.gaZ.setAntiAlias(true);
      this.gaZ.setStrokeWidth(0.0F);
      this.gaZ.setTextSize(j(2, 12.0F));
      this.gaZ.setAlpha(153);
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0)
        {
          this.gaZ.setTextAlign(Paint.Align.LEFT);
          label88:
          if (this.jHJ[i] == 0) {
            break label170;
          }
          this.gaZ.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.jsr - this.jHh, this.gaZ);
          i += 1;
          break;
          this.gaZ.setTextAlign(Paint.Align.CENTER);
          break label88;
          label170:
          this.gaZ.setColor(this.jGw);
        }
      }
    }
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jHL.reset();
      this.jHL.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.jHL.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.jHL.lineTo(this.jHH[(this.jHH.length - 1)], this.jsr - this.jGX - 1);
      this.jHL.lineTo(this.jGL, this.jsr - this.jGX - 1);
      this.jHL.lineTo(this.jGL, this.jHI[0]);
      paramCanvas.drawPath(this.jHL, this.gaZ);
      return;
    }
    this.jHL.reset();
    this.jHL.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    label251:
    if (i < this.points.size())
    {
      if (i <= 0) {
        break label493;
      }
      if (((Point)this.points.get(i - 1)).y != this.jsr - this.jGR) {
        break label486;
      }
      this.gaZ.reset();
      DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.gaZ.setPathEffect(localDashPathEffect);
      this.gaZ.setAntiAlias(true);
      this.gaZ.setStrokeWidth(this.jGH);
      this.gaZ.setStyle(Paint.Style.STROKE);
      this.gaZ.setColor(-1);
    }
    for (;;)
    {
      this.jHL.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
      paramCanvas.drawPath(this.jHL, this.gaZ);
      this.jHL.reset();
      this.jHL.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
      i += 1;
      break label251;
      break;
      label486:
      aMU();
      continue;
      label493:
      aMU();
    }
  }
  
  private void getData()
  {
    int n = 0;
    this.points.clear();
    View localView = findViewById(R.h.exdevice_rank_step_chart);
    this.jsq = localView.getWidth();
    this.jsr = localView.getHeight();
    this.jHD = ((this.jsq - this.jGL - this.jGN) / 6);
    this.jHE = ((this.jsr - this.jGP - this.jGR) / 2);
    int i = 0;
    while (i < this.jHH.length)
    {
      this.jHH[i] = (this.jGL + this.jHD * i);
      i += 1;
    }
    i = this.jHF.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.jHF[i] > 100000) {
        this.jHF[i] = 100000;
      }
      if (this.jHF[i] < 0) {
        this.jHF[i] = 0;
      }
      m = j;
      if (this.jHF[i] > j) {
        m = this.jHF[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.jHA = ((this.jsr - this.jGP - this.jGR) * 10000 / i);
      this.jHA = (this.jsr - this.jGR - this.jHA);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.jHI[j] = (this.jsr - this.jGR - this.jHF[j] / i * (this.jsr - this.jGP - this.jGR));
          this.points.add(new Point((int)this.jHH[j], (int)this.jHI[j]));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label405;
          }
          i = j;
          if (j / 5000.0D <= j / 5000.0F) {
            break;
          }
          i = (j / 5000 + 1) * 5000;
          break;
        }
      }
      return;
      label405:
      i = 0;
    }
  }
  
  private float j(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources()) {
      return TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getData();
    super.onDraw(paramCanvas);
    int i;
    Object localObject;
    float f;
    if (!this.jHN)
    {
      this.gaZ.reset();
      this.gaZ.setAntiAlias(true);
      this.gaZ.setColor(-1);
      this.gaZ.setStrokeWidth(0.0F);
      this.gaZ.setStyle(Paint.Style.FILL);
      i = 0;
      if (i < this.points.size())
      {
        localObject = (Point)this.points.get(i);
        if (i == this.points.size() - 1) {
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.jGF, this.gaZ);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.jGD, this.gaZ);
        }
      }
      if (this.jGA != 2147483647)
      {
        i = this.jGA;
        this.gaZ.reset();
        this.gaZ.setColor(this.jGw);
        this.gaZ.setAntiAlias(true);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setTextSize(j(2, 12.0F));
        this.gaZ.setTextAlign(Paint.Align.CENTER);
        if ((i >= 0) && (i <= 6))
        {
          if (i == 0) {
            this.gaZ.setTextAlign(Paint.Align.LEFT);
          }
          if (i == 6) {
            this.gaZ.setTextAlign(Paint.Align.RIGHT);
          }
          if (!this.jHQ)
          {
            this.jHP = (((Point)this.points.get(i)).y - this.jHr);
            this.startY = this.jHP;
            this.jHQ = true;
          }
          if (this.jHQ)
          {
            f = (float)(this.startY / 8.0D);
            if (this.jHP > 0) {
              this.gaZ.setAlpha((this.startY - this.jHP) * 255 / this.startY);
            }
            paramCanvas.drawText(this.jHF[i], ((Point)this.points.get(i)).x, this.jHP + this.jHr, this.gaZ);
            if (this.jHP <= 0) {
              break label1241;
            }
            if (this.jHP / this.startY > 1.0F / f) {
              break label1214;
            }
            this.jHP -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.jGA;
      if ((i >= 0) && (i <= 6)) {
        this.jHJ[i] = true;
      }
      this.gaZ.reset();
      this.jHK.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.gaZ.setPathEffect((PathEffect)localObject);
      this.gaZ.setColor(this.jGq);
      this.gaZ.setStrokeWidth(this.jGJ);
      this.gaZ.setAlpha(102);
      this.gaZ.setStyle(Paint.Style.STROKE);
      if ((this.jHA != 0) && (!this.jHN))
      {
        this.jHK.moveTo(this.jGL, this.jHA);
        this.jHK.lineTo(this.jsq - this.jGT, this.jHA);
        paramCanvas.drawPath(this.jHK, this.gaZ);
      }
      this.gaZ.reset();
      this.jHK.reset();
      this.gaZ.setColor(this.jGq);
      this.gaZ.setStrokeWidth(this.jGJ);
      this.gaZ.setStyle(Paint.Style.STROKE);
      this.gaZ.setAlpha(102);
      this.jHK.reset();
      this.jHK.moveTo(this.jHb, this.jsr - this.jGX);
      this.jHK.lineTo(this.jsq - this.jHd, this.jsr - this.jGX);
      this.jHK.moveTo(this.jHb, this.jGZ);
      this.jHK.lineTo(this.jsq - this.jHd, this.jGZ);
      paramCanvas.drawPath(this.jHK, this.gaZ);
      if (!this.jHN)
      {
        this.gaZ.reset();
        this.gaZ.setColor(this.jGy);
        this.gaZ.setAntiAlias(true);
        this.gaZ.setAlpha(102);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setTextSize(j(2, 12.0F));
        this.gaZ.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(R.l.exdevice_profile_step_chart_1w_tips), this.jsq - this.jHf, (float)(this.jHA + this.gaZ.getTextSize() * 0.34D), this.gaZ);
      }
      this.gaZ.reset();
      this.gaZ.setColor(-1);
      this.gaZ.setAntiAlias(true);
      this.gaZ.setStrokeWidth(0.0F);
      this.gaZ.setTypeface(this.jHB);
      this.gaZ.setTextSize(j(2, 28.0F));
      paramCanvas.drawText(getResources().getString(R.l.exdevice_profile_step_chart_step_tips), this.jHl, this.jHj, this.gaZ);
      this.gaZ.setTextAlign(Paint.Align.RIGHT);
      this.gaZ.setTextSize(j(2, 33.0F));
      paramCanvas.drawText(this.jHF[(this.jHF.length - 1)], this.jsq - this.jHp, this.jHn, this.gaZ);
      if (this.points.size() > 2)
      {
        this.gaZ.reset();
        this.gaZ.setAntiAlias(true);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setAlpha(102);
        this.gaZ.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jsr - this.jGX, -1, 16777215, Shader.TileMode.REPEAT);
        this.gaZ.setShader((Shader)localObject);
        this.gaZ.setColor(-1);
        c(paramCanvas, true);
        aMU();
        if (!this.jHN) {
          c(paramCanvas, false);
        }
      }
      b(paramCanvas, this.jHM);
      return;
      label1214:
      this.jHP = ((int)(this.jHP - this.jHP / this.startY * f));
      break;
      label1241:
      this.jHQ = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    y.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.jGA);
    switch (paramMotionEvent.getAction())
    {
    default: 
      y.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
      return false;
    case 0: 
      y.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
      return true;
    }
    y.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
    this.jGA = aq(f);
    aMT();
    this.jHQ = false;
    invalidate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */