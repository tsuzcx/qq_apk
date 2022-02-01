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
  private int fIN;
  private int fIO;
  Paint paint;
  private final int pgA;
  private final float pgB;
  private final float pgC;
  private final float pgD;
  private final float pgE;
  private final float pgF;
  private final int pgG;
  private final int pgH;
  private final int pgI;
  private final int pgJ;
  private int pgK;
  private final float pgL;
  private final float pgM;
  private final int pgN;
  private final float pgO;
  private final int pgP;
  private final float pgQ;
  private final int pgR;
  private final float pgS;
  private final int pgT;
  private final float pgU;
  private final int pgV;
  private final float pgW;
  private final int pgX;
  private final float pgY;
  private final int pgZ;
  private final int pgy;
  private final int pgz;
  private final float phA;
  private final int phB;
  private final int phC;
  private final int phD;
  private final int phE;
  private final int phF;
  private final int phG;
  private final int phH;
  private final int phI;
  private final int phJ;
  private int phK;
  private final Typeface phL;
  private final Typeface phM;
  private int phN;
  private int phO;
  private int[] phP;
  private final int phQ;
  private float[] phR;
  private float[] phS;
  private boolean[] phT;
  Path phU;
  Path phV;
  List<String> phW;
  private boolean phX;
  PathEffect phY;
  private int phZ;
  private final float pha;
  private final int phb;
  private final float phc;
  private final int phd;
  private final float phe;
  private final int phf;
  private final float phg;
  private final int phh;
  private final float phi;
  private final int phj;
  private final float phk;
  private final float phl;
  private final float phm;
  private final float phn;
  private final int pho;
  private final int php;
  private final int phq;
  private final int phr;
  private final float phs;
  private final int pht;
  private final float phu;
  private final int phv;
  private final float phw;
  private final int phx;
  private final float phy;
  private final int phz;
  private boolean pia;
  List<Point> points;
  private int startY;
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24296);
    this.pgy = -1;
    this.pgz = -1;
    this.pgA = getResources().getColor(2131100298);
    this.pgB = 12.0F;
    this.pgC = 28.0F;
    this.pgD = 33.0F;
    this.pgE = 12.0F;
    this.pgF = 12.0F;
    this.pgG = getResources().getColor(2131100299);
    this.pgH = -1;
    this.pgI = getResources().getColor(2131100299);
    this.pgJ = -1;
    this.pgK = 2147483647;
    this.fIN = 0;
    this.fIO = 0;
    this.pgL = 10.0F;
    this.pgM = 2.5F;
    this.pgN = ((int)o(1, 2.5F));
    this.pgO = 4.0F;
    this.pgP = ((int)o(1, 4.0F));
    this.pgQ = 1.8F;
    this.pgR = ((int)o(1, 1.8F));
    this.pgS = 1.0F;
    this.pgT = ((int)o(1, 1.0F));
    this.pgU = 8.0F;
    this.pgV = ((int)o(1, 8.0F));
    this.pgW = 22.0F;
    this.pgX = ((int)o(1, 22.0F));
    this.pgY = 67.0F;
    this.pgZ = ((int)o(1, 67.0F));
    this.pha = 40.0F;
    this.phb = ((int)o(1, 40.0F));
    this.phc = 22.0F;
    this.phd = ((int)o(1, 22.0F));
    this.phe = 55.0F;
    this.phf = ((int)o(1, 55.0F));
    this.phg = 35.0F;
    this.phh = ((int)o(1, 35.0F));
    this.phi = 45.0F;
    this.phj = ((int)o(1, 45.0F));
    this.phk = 8.0F;
    this.phl = ((int)o(1, 8.0F));
    this.phm = 8.0F;
    this.phn = ((int)o(1, 8.0F));
    this.pho = 2;
    this.php = ((int)o(1, 2.0F));
    this.phq = 15;
    this.phr = ((int)o(1, 15.0F));
    this.phs = 33.0F;
    this.pht = ((int)o(1, 33.0F));
    this.phu = 8.0F;
    this.phv = ((int)o(1, 8.0F));
    this.phw = 35.0F;
    this.phx = ((int)o(1, 35.0F));
    this.phy = 10.0F;
    this.phz = ((int)o(1, 10.0F));
    this.phA = 58.0F;
    this.phB = ((int)o(1, 58.0F));
    this.phC = ((int)o(1, 1.0F));
    this.phD = 102;
    this.phE = 102;
    this.phF = 153;
    this.phG = 102;
    this.phH = 102;
    this.phI = 102;
    this.phJ = 204;
    this.phK = 0;
    this.phL = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.phM = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.phN = 0;
    this.phO = 0;
    this.phP = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.phQ = 7;
    this.phR = new float[7];
    this.phS = new float[7];
    this.phT = new boolean[7];
    this.phX = false;
    this.phY = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    caP();
    AppMethodBeat.o(24296);
  }
  
  public ExdeviceStepChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24297);
    this.pgy = -1;
    this.pgz = -1;
    this.pgA = getResources().getColor(2131100298);
    this.pgB = 12.0F;
    this.pgC = 28.0F;
    this.pgD = 33.0F;
    this.pgE = 12.0F;
    this.pgF = 12.0F;
    this.pgG = getResources().getColor(2131100299);
    this.pgH = -1;
    this.pgI = getResources().getColor(2131100299);
    this.pgJ = -1;
    this.pgK = 2147483647;
    this.fIN = 0;
    this.fIO = 0;
    this.pgL = 10.0F;
    this.pgM = 2.5F;
    this.pgN = ((int)o(1, 2.5F));
    this.pgO = 4.0F;
    this.pgP = ((int)o(1, 4.0F));
    this.pgQ = 1.8F;
    this.pgR = ((int)o(1, 1.8F));
    this.pgS = 1.0F;
    this.pgT = ((int)o(1, 1.0F));
    this.pgU = 8.0F;
    this.pgV = ((int)o(1, 8.0F));
    this.pgW = 22.0F;
    this.pgX = ((int)o(1, 22.0F));
    this.pgY = 67.0F;
    this.pgZ = ((int)o(1, 67.0F));
    this.pha = 40.0F;
    this.phb = ((int)o(1, 40.0F));
    this.phc = 22.0F;
    this.phd = ((int)o(1, 22.0F));
    this.phe = 55.0F;
    this.phf = ((int)o(1, 55.0F));
    this.phg = 35.0F;
    this.phh = ((int)o(1, 35.0F));
    this.phi = 45.0F;
    this.phj = ((int)o(1, 45.0F));
    this.phk = 8.0F;
    this.phl = ((int)o(1, 8.0F));
    this.phm = 8.0F;
    this.phn = ((int)o(1, 8.0F));
    this.pho = 2;
    this.php = ((int)o(1, 2.0F));
    this.phq = 15;
    this.phr = ((int)o(1, 15.0F));
    this.phs = 33.0F;
    this.pht = ((int)o(1, 33.0F));
    this.phu = 8.0F;
    this.phv = ((int)o(1, 8.0F));
    this.phw = 35.0F;
    this.phx = ((int)o(1, 35.0F));
    this.phy = 10.0F;
    this.phz = ((int)o(1, 10.0F));
    this.phA = 58.0F;
    this.phB = ((int)o(1, 58.0F));
    this.phC = ((int)o(1, 1.0F));
    this.phD = 102;
    this.phE = 102;
    this.phF = 153;
    this.phG = 102;
    this.phH = 102;
    this.phI = 102;
    this.phJ = 204;
    this.phK = 0;
    this.phL = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.phM = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.phN = 0;
    this.phO = 0;
    this.phP = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    this.phQ = 7;
    this.phR = new float[7];
    this.phS = new float[7];
    this.phT = new boolean[7];
    this.phX = false;
    this.phY = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
    caP();
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
          if (this.phT[i] == 0) {
            break label176;
          }
          this.paint.setColor(-1);
        }
        for (;;)
        {
          paramCanvas.drawText((String)paramList.get(i), ((Point)this.points.get(i)).x, this.fIO - this.phr, this.paint);
          i += 1;
          break;
          this.paint.setTextAlign(Paint.Align.CENTER);
          break label94;
          label176:
          this.paint.setColor(this.pgG);
        }
      }
    }
    AppMethodBeat.o(24300);
  }
  
  private int aR(float paramFloat)
  {
    AppMethodBeat.i(24305);
    this.pgK = 2147483647;
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
        if ((paramFloat >= ((Point)this.points.get(i)).x + this.phN / 2) || (paramFloat <= 0.0F)) {
          break label264;
        }
        this.pgK = i;
        invalidate();
      }
      for (;;)
      {
        i = this.pgK;
        AppMethodBeat.o(24305);
        return i;
        label100:
        if ((i > 0) && (i < this.points.size() - 1))
        {
          if ((paramFloat >= ((Point)this.points.get(i)).x + this.phN / 2) || (paramFloat <= ((Point)this.points.get(i)).x - this.phN / 2)) {
            break;
          }
          this.pgK = i;
          invalidate();
        }
        else if (i == this.points.size() - 1)
        {
          if ((paramFloat >= this.fIN) || (paramFloat <= ((Point)this.points.get(i)).x - this.phN / 2)) {
            break;
          }
          this.pgK = i;
          invalidate();
        }
        else
        {
          this.pgK = 2147483647;
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
      this.phV.reset();
      this.phV.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
      i = 0;
      while (i < this.points.size())
      {
        this.phV.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
      }
      this.phV.lineTo(this.phR[(this.phR.length - 1)], this.fIO - this.phh - 1);
      this.phV.lineTo(this.pgV, this.fIO - this.phh - 1);
      this.phV.lineTo(this.pgV, this.phS[0]);
      paramCanvas.drawPath(this.phV, this.paint);
      AppMethodBeat.o(24298);
      return;
    }
    this.phV.reset();
    this.phV.moveTo(((Point)this.points.get(0)).x, ((Point)this.points.get(0)).y);
    if (i < this.points.size())
    {
      if (i > 0) {
        if (((Point)this.points.get(i - 1)).y == this.fIO - this.phb)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.pgR);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.phV.lineTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        paramCanvas.drawPath(this.phV, this.paint);
        this.phV.reset();
        this.phV.moveTo(((Point)this.points.get(i)).x, ((Point)this.points.get(i)).y);
        i += 1;
        break;
        caR();
        continue;
        caR();
      }
    }
    AppMethodBeat.o(24298);
  }
  
  private void caP()
  {
    AppMethodBeat.i(24301);
    this.paint = new Paint();
    this.phU = new Path();
    this.phV = new Path();
    this.points = new LinkedList();
    this.phW = new LinkedList();
    caQ();
    AppMethodBeat.o(24301);
  }
  
  private void caQ()
  {
    int i = 0;
    if (i < 7)
    {
      if (i == 6) {
        this.phT[i] = true;
      }
      for (;;)
      {
        i += 1;
        break;
        this.phT[i] = false;
      }
    }
  }
  
  private void caR()
  {
    AppMethodBeat.i(24302);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.pgR);
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
    this.fIN = localView.getWidth();
    this.fIO = localView.getHeight();
    this.phN = ((this.fIN - this.pgV - this.pgX) / 6);
    this.phO = ((this.fIO - this.pgZ - this.phb) / 2);
    int i = 0;
    while (i < this.phR.length)
    {
      this.phR[i] = (this.pgV + this.phN * i);
      i += 1;
    }
    i = this.phP.length;
    int k = i;
    if (i > 7) {
      k = 7;
    }
    i = 0;
    int m;
    for (int j = 0; i < k; j = m)
    {
      if (this.phP[i] > 100000) {
        this.phP[i] = 100000;
      }
      if (this.phP[i] < 0) {
        this.phP[i] = 0;
      }
      m = j;
      if (this.phP[i] > j) {
        m = this.phP[i];
      }
      i += 1;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.phK = ((this.fIO - this.pgZ - this.phb) * 10000 / i);
      this.phK = (this.fIO - this.phb - this.phK);
      j = n;
      for (;;)
      {
        if (j < k)
        {
          this.phS[j] = (this.fIO - this.phb - this.phP[j] / i * (this.fIO - this.pgZ - this.phb));
          this.points.add(new Point((int)this.phR[j], (int)this.phS[j]));
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
    if (!this.phX)
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
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.pgP, this.paint);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.pgN, this.paint);
        }
      }
      if (this.pgK != 2147483647)
      {
        i = this.pgK;
        this.paint.reset();
        this.paint.setColor(this.pgG);
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
          if (!this.pia)
          {
            this.phZ = (((Point)this.points.get(i)).y - this.phB);
            this.startY = this.phZ;
            this.pia = true;
          }
          if (this.pia)
          {
            f = (float)(this.startY / 8.0D);
            if (this.phZ > 0) {
              this.paint.setAlpha((this.startY - this.phZ) * 255 / this.startY);
            }
            paramCanvas.drawText(this.phP[i], ((Point)this.points.get(i)).x, this.phZ + this.phB, this.paint);
            if (this.phZ <= 0) {
              break label1253;
            }
            if (this.phZ / this.startY > 1.0F / f) {
              break label1226;
            }
            this.phZ -= 1;
            invalidate();
          }
        }
      }
    }
    for (;;)
    {
      i = this.pgK;
      if ((i >= 0) && (i <= 6)) {
        this.phT[i] = true;
      }
      this.paint.reset();
      this.phU.reset();
      localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.pgA);
      this.paint.setStrokeWidth(this.pgT);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.phK != 0) && (!this.phX))
      {
        this.phU.moveTo(this.pgV, this.phK);
        this.phU.lineTo(this.fIN - this.phd, this.phK);
        paramCanvas.drawPath(this.phU, this.paint);
      }
      this.paint.reset();
      this.phU.reset();
      this.paint.setColor(this.pgA);
      this.paint.setStrokeWidth(this.pgT);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.phU.reset();
      this.phU.moveTo(this.phl, this.fIO - this.phh);
      this.phU.lineTo(this.fIN - this.phn, this.fIO - this.phh);
      this.phU.moveTo(this.phl, this.phj);
      this.phU.lineTo(this.fIN - this.phn, this.phj);
      paramCanvas.drawPath(this.phU, this.paint);
      if (!this.phX)
      {
        this.paint.reset();
        this.paint.setColor(this.pgI);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(o(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131758581), this.fIN - this.php, (float)(this.phK + this.paint.getTextSize() * 0.34D), this.paint);
      }
      this.paint.reset();
      this.paint.setColor(-1);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(0.0F);
      this.paint.setTypeface(this.phL);
      this.paint.setTextSize(o(2, 28.0F));
      paramCanvas.drawText(getResources().getString(2131758583), this.phv, this.pht, this.paint);
      this.paint.setTextAlign(Paint.Align.RIGHT);
      this.paint.setTextSize(o(2, 33.0F));
      paramCanvas.drawText(this.phP[(this.phP.length - 1)], this.fIN - this.phz, this.phx, this.paint);
      if (this.points.size() > 2)
      {
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.fIO - this.phh, -1, 16777215, Shader.TileMode.REPEAT);
        this.paint.setShader((Shader)localObject);
        this.paint.setColor(-1);
        c(paramCanvas, true);
        caR();
        if (!this.phX) {
          c(paramCanvas, false);
        }
      }
      a(paramCanvas, this.phW);
      AppMethodBeat.o(24303);
      return;
      label1226:
      this.phZ = ((int)(this.phZ - this.phZ / this.startY * f));
      break;
      label1253:
      this.pia = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24306);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    ad.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.pgK);
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
    this.pgK = aR(f);
    caQ();
    this.pia = false;
    invalidate();
    AppMethodBeat.o(24306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceStepChartView
 * JD-Core Version:    0.7.0.1
 */