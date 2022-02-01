package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class c
  extends View
{
  protected static int fAA = 32;
  protected static int fAB;
  protected static int fAC = 1;
  protected static int fAD;
  protected static int fAE = 10;
  protected static int fAF;
  protected static int fAG;
  protected static int fAH;
  protected Paint fAI;
  protected Paint fAJ;
  protected Paint fAK;
  protected Paint fAL;
  protected Paint fAM;
  protected int fAN;
  protected int fAO;
  protected int fAP;
  protected int fAQ;
  protected int fAR;
  protected int fAS;
  protected int fAT;
  protected int fAU;
  protected int fAV;
  private final StringBuilder fAW;
  protected boolean fAX;
  protected boolean fAY;
  protected int fAZ;
  protected int fBa;
  protected int fBb;
  protected int fBc;
  protected int fBd;
  protected int fBe;
  protected int fBf;
  protected int fBg;
  protected int fBh;
  protected int fBi;
  private int fBj;
  protected Boolean fBk;
  protected int fBl;
  protected int fBm;
  final Time fBn;
  private final Calendar fBo;
  private final Boolean fBp;
  private DateFormatSymbols fBq;
  private a fBr;
  Collection<com.tencent.mm.chatroom.d.a> fuL;
  private final Calendar mCalendar;
  private Context mContext;
  protected int mMonth;
  public int mNumRows;
  protected int mPadding;
  protected int mWidth;
  protected int mYear;
  
  public c(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    AppMethodBeat.i(12992);
    this.mPadding = 80;
    this.fAX = false;
    this.fAY = false;
    this.fAZ = -1;
    this.fBa = -1;
    this.fBb = -1;
    this.fBc = -1;
    this.fBd = -1;
    this.fBe = -1;
    this.fBf = -1;
    this.fBg = 1;
    this.fBh = 7;
    this.fBi = this.fBh;
    this.fBj = 0;
    this.fBl = fAA;
    this.fBm = 0;
    this.mNumRows = 6;
    this.fBq = new DateFormatSymbols();
    this.fuL = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.fBo = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.fBn = new Time(Time.getCurrentTimezone());
    this.fBn.setToNow();
    this.fAN = paramTypedArray.getColor(2, paramContext.getColor(2131100708));
    this.fAO = paramTypedArray.getColor(5, paramContext.getColor(2131100708));
    this.fAP = paramTypedArray.getColor(3, paramContext.getColor(2131100708));
    this.fAQ = paramTypedArray.getColor(3, paramContext.getColor(2131100709));
    this.fAR = paramTypedArray.getColor(6, paramContext.getColor(2131100708));
    this.fAT = paramTypedArray.getColor(7, paramContext.getColor(2131100708));
    this.fAU = paramTypedArray.getColor(4, paramContext.getColor(2131100618));
    this.fAV = paramTypedArray.getColor(8, paramContext.getColor(2131100847));
    this.fAS = paramTypedArray.getColor(9, paramContext.getColor(2131100848));
    this.fBk = Boolean.valueOf(paramTypedArray.getBoolean(11, false));
    this.fAW = new StringBuilder(50);
    fAD = paramTypedArray.getDimensionPixelSize(18, paramContext.getDimensionPixelSize(2131166909));
    fAH = paramTypedArray.getDimensionPixelSize(20, paramContext.getDimensionPixelSize(2131166911));
    fAF = paramTypedArray.getDimensionPixelSize(19, paramContext.getDimensionPixelSize(2131166910));
    fAG = paramTypedArray.getDimensionPixelOffset(14, paramContext.getDimensionPixelOffset(2131166415));
    fAB = paramTypedArray.getDimensionPixelSize(17, paramContext.getDimensionPixelOffset(2131166779));
    this.fBl = ((paramTypedArray.getDimensionPixelSize(0, paramContext.getDimensionPixelOffset(2131165948)) - fAG) / 6);
    this.fBm = paramTypedArray.getDimensionPixelSize(1, paramContext.getDimensionPixelOffset(2131166005));
    this.fBp = Boolean.valueOf(paramTypedArray.getBoolean(12, true));
    this.fAL = new Paint();
    this.fAL.setAntiAlias(true);
    this.fAL.setTextSize(fAH);
    this.fAL.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fAL.setColor(this.fAQ);
    this.fAL.setTextAlign(Paint.Align.LEFT);
    this.fAL.setStyle(Paint.Style.FILL);
    this.fAK = new Paint();
    this.fAK.setFakeBoldText(true);
    this.fAK.setAntiAlias(true);
    this.fAK.setColor(this.fAS);
    this.fAK.setTextAlign(Paint.Align.CENTER);
    this.fAK.setStyle(Paint.Style.FILL);
    this.fAM = new Paint();
    this.fAM.setFakeBoldText(true);
    this.fAM.setAntiAlias(true);
    this.fAM.setColor(this.fAV);
    this.fAM.setTextAlign(Paint.Align.CENTER);
    this.fAM.setStyle(Paint.Style.FILL);
    this.fAI = new Paint();
    this.fAI.setAntiAlias(true);
    this.fAI.setTextSize(fAF);
    this.fAI.setColor(this.fAQ);
    this.fAI.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fAI.setStyle(Paint.Style.FILL);
    this.fAI.setTextAlign(Paint.Align.CENTER);
    this.fAI.setFakeBoldText(true);
    this.fAJ = new Paint();
    this.fAJ.setAntiAlias(true);
    this.fAJ.setTextSize(fAD);
    this.fAJ.setStyle(Paint.Style.FILL);
    this.fAJ.setTextAlign(Paint.Align.CENTER);
    this.fAJ.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private int Xd()
  {
    if (this.fBj < this.fBg) {}
    for (int i = this.fBj + this.fBh;; i = this.fBj) {
      return i - this.fBg;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = fAG;
    int k = fAF / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.fBh * 2);
    int i = 0;
    while (i < this.fBh)
    {
      int n = this.fBg;
      int i1 = this.fBh;
      int i2 = this.mPadding;
      this.fBo.set(7, (n + i) % i1);
      paramCanvas.drawText(this.fBq.getShortWeekdays()[this.fBo.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.fAI);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.fBl + fAD) / 2 - fAC + fAG;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.fBh * 2);
    int i = Xd();
    int k = 1;
    while ((k <= this.fBi) && ((k <= this.fBf) || (-1 == this.fBf)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.fBb) && (this.fAZ == k) && (this.fBd == this.mYear)) || ((this.mMonth == this.fBc) && (this.fBa == k) && (this.fBe == this.mYear)) || ((this.fAX) && (this.fBf == k) && (this.fAZ == -1)))
      {
        if (!this.fBk.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - fAB, j - fAD / 3 - fAB, fAB + m, j - fAD / 3 + fAB), 10.0F, 10.0F, this.fAM);
      }
      for (;;)
      {
        if ((this.fAX) && (this.fBf == k) && (this.fAZ == -1))
        {
          this.fAJ.setColor(this.fAV);
          this.fAJ.setTypeface(Typeface.defaultFromStyle(0));
          this.fAJ.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131764448), m, j + 12 + fAB, this.fAJ);
        }
        this.fAJ.setTextSize(fAD);
        if ((!this.fAX) || (this.fBf != k))
        {
          this.fAJ.setColor(this.fAR);
          this.fAJ.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.fAZ != -1) && (this.fBa != -1) && (this.fBd == this.fBe) && (this.fBb == this.fBc) && (this.fAZ == this.fBa) && (k == this.fAZ) && (this.mMonth == this.fBb) && (this.mYear == this.fBd)) {
          this.fAJ.setColor(this.fAV);
        }
        if ((this.fAZ != -1) && (this.fBa != -1) && (this.fBd == this.fBe) && (this.fBd == this.mYear) && (((this.mMonth == this.fBb) && (this.fBc == this.fBb) && (((this.fAZ < this.fBa) && (k > this.fAZ) && (k < this.fBa)) || ((this.fAZ > this.fBa) && (k < this.fAZ) && (k > this.fBa)))) || ((this.fBb < this.fBc) && (this.mMonth == this.fBb) && (k > this.fAZ)) || ((this.fBb < this.fBc) && (this.mMonth == this.fBc) && (k < this.fBa)) || ((this.fBb > this.fBc) && (this.mMonth == this.fBb) && (k < this.fAZ)) || ((this.fBb > this.fBc) && (this.mMonth == this.fBc) && (k > this.fBa)))) {
          this.fAJ.setColor(this.fAV);
        }
        if ((this.fAZ != -1) && (this.fBa != -1) && (this.fBd != this.fBe) && (((this.fBd == this.mYear) && (this.mMonth == this.fBb)) || ((this.fBe == this.mYear) && (this.mMonth == this.fBc) && (((this.fBb < this.fBc) && (this.mMonth == this.fBb) && (k < this.fAZ)) || ((this.fBb < this.fBc) && (this.mMonth == this.fBc) && (k > this.fBa)) || ((this.fBb > this.fBc) && (this.mMonth == this.fBb) && (k > this.fAZ)) || ((this.fBb > this.fBc) && (this.mMonth == this.fBc) && (k < this.fBa)))))) {
          this.fAJ.setColor(this.fAV);
        }
        if ((this.fAZ != -1) && (this.fBa != -1) && (this.fBd == this.fBe) && (this.mYear == this.fBd) && (((this.mMonth > this.fBb) && (this.mMonth < this.fBc) && (this.fBb < this.fBc)) || ((this.mMonth < this.fBb) && (this.mMonth > this.fBc) && (this.fBb > this.fBc)))) {
          this.fAJ.setColor(this.fAV);
        }
        if ((this.fAZ != -1) && (this.fBa != -1) && (this.fBd != this.fBe) && (((this.fBd < this.fBe) && (((this.mMonth > this.fBb) && (this.mYear == this.fBd)) || ((this.mMonth < this.fBc) && (this.mYear == this.fBe)))) || ((this.fBd > this.fBe) && (((this.mMonth < this.fBb) && (this.mYear == this.fBd)) || ((this.mMonth > this.fBc) && (this.mYear == this.fBe)))))) {
          this.fAJ.setColor(this.fAV);
        }
        if ((!this.fBp.booleanValue()) && (a(k, this.fBn)) && (this.fBn.month == this.mMonth) && (this.fBn.year == this.mYear))
        {
          this.fAJ.setColor(this.fAT);
          this.fAJ.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.fuL.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.fsg == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.fAJ.setColor(this.fAU);
            this.fAJ.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - fAD / 3, fAB, this.fAM);
      }
      if (((this.mMonth == this.fBb) && (this.fAZ == k) && (this.fBd == this.mYear)) || ((this.mMonth == this.fBc) && (this.fBa == k) && (this.fBe == this.mYear)) || ((this.fAX) && (this.fBf == k) && (this.fAZ == -1)))
      {
        this.fAJ.setTypeface(Typeface.defaultFromStyle(0));
        this.fAJ.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.fAJ);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.fBh)
      {
        i = 0;
        m = j + this.fBl;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.fAW.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.mPadding * 2) / (this.fBh * 2);
    int j = this.mPadding;
    int k = fAH / 2;
    int m = (fAG - fAH) / 2;
    int n = fAH;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.fAL);
    paramCanvas.drawLine(0.0F, fAG, this.mWidth, fAG + 1, this.fAL);
    f(paramCanvas);
    g(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.fBl * this.mNumRows + fAG + this.fBm);
    AppMethodBeat.o(12997);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(12998);
    float f1;
    float f2;
    int i;
    if (paramMotionEvent.getAction() == 1)
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = this.mPadding;
      if ((f1 >= i) && (f1 <= this.mWidth - this.mPadding)) {
        break label136;
      }
      paramMotionEvent = null;
    }
    for (;;)
    {
      if ((paramMotionEvent != null) && (this.fBr != null) && ((this.fBp.booleanValue()) || (paramMotionEvent.month != this.fBn.month) || (paramMotionEvent.year != this.fBn.year) || (paramMotionEvent.fsg >= this.fBn.monthDay))) {
        this.fBr.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - fAG) / this.fBl;
      i = (int)((f1 - i) * this.fBh / (this.mWidth - i - this.mPadding)) - Xd() + 1 + j * this.fBh;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.g.a.cn(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.fuL.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramMotionEvent = (com.tencent.mm.chatroom.d.a)localIterator.next();
            if (paramMotionEvent.equals(locala)) {
              break;
            }
          }
        }
        paramMotionEvent = null;
      }
    }
  }
  
  public final void setMarkDate(Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12999);
    if (paramCollection != null)
    {
      this.fuL = paramCollection;
      AppMethodBeat.o(12999);
      return;
    }
    ac.e("MicroMsg.SimpleMonthView", "markDateList is null");
    AppMethodBeat.o(12999);
  }
  
  public final void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    int k = 0;
    AppMethodBeat.i(13000);
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year")))
    {
      paramHashMap = new InvalidParameterException("You must specify month and year for this view");
      AppMethodBeat.o(13000);
      throw paramHashMap;
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.fBl = ((Integer)paramHashMap.get("height")).intValue();
      if (this.fBl < fAE) {
        this.fBl = fAE;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.fAZ = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.fBa = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.fBb = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.fBc = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.fBd = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.fBe = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.fAX = false;
    this.fBf = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.fBj = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.fBg = ((Integer)paramHashMap.get("week_start")).intValue();
      this.fBi = com.tencent.mm.chatroom.g.a.cn(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.fBi) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.fBn;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.fAX = true;
        this.fBf = m;
      }
      this.fAY = a(m, this.fBn);
      i += 1;
      break label393;
      this.fBg = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = Xd();
    j = (this.fBi + m) / this.fBh;
    int i = k;
    if ((m + this.fBi) % this.fBh > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.fBr = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.chatroom.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */