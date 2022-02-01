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
import com.tencent.mm.sdk.platformtools.ae;
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
  protected static int fVW = 32;
  protected static int fVX;
  protected static int fVY = 1;
  protected static int fVZ;
  protected static int fWa = 10;
  protected static int fWb;
  protected static int fWc;
  protected static int fWd;
  Collection<com.tencent.mm.chatroom.d.a> fPO;
  protected int fWA;
  protected int fWB;
  protected int fWC;
  protected int fWD;
  protected int fWE;
  private int fWF;
  protected Boolean fWG;
  protected int fWH;
  protected int fWI;
  final Time fWJ;
  private final Calendar fWK;
  private final Boolean fWL;
  private DateFormatSymbols fWM;
  private a fWN;
  protected Paint fWe;
  protected Paint fWf;
  protected Paint fWg;
  protected Paint fWh;
  protected Paint fWi;
  protected int fWj;
  protected int fWk;
  protected int fWl;
  protected int fWm;
  protected int fWn;
  protected int fWo;
  protected int fWp;
  protected int fWq;
  protected int fWr;
  private final StringBuilder fWs;
  protected boolean fWt;
  protected boolean fWu;
  protected int fWv;
  protected int fWw;
  protected int fWx;
  protected int fWy;
  protected int fWz;
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
    this.fWt = false;
    this.fWu = false;
    this.fWv = -1;
    this.fWw = -1;
    this.fWx = -1;
    this.fWy = -1;
    this.fWz = -1;
    this.fWA = -1;
    this.fWB = -1;
    this.fWC = 1;
    this.fWD = 7;
    this.fWE = this.fWD;
    this.fWF = 0;
    this.fWH = fVW;
    this.fWI = 0;
    this.mNumRows = 6;
    this.fWM = new DateFormatSymbols();
    this.fPO = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.fWK = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.fWJ = new Time(Time.getCurrentTimezone());
    this.fWJ.setToNow();
    this.fWj = paramTypedArray.getColor(2, paramContext.getColor(2131100708));
    this.fWk = paramTypedArray.getColor(5, paramContext.getColor(2131100708));
    this.fWl = paramTypedArray.getColor(3, paramContext.getColor(2131100708));
    this.fWm = paramTypedArray.getColor(3, paramContext.getColor(2131100709));
    this.fWn = paramTypedArray.getColor(6, paramContext.getColor(2131100708));
    this.fWp = paramTypedArray.getColor(7, paramContext.getColor(2131100708));
    this.fWq = paramTypedArray.getColor(4, paramContext.getColor(2131100618));
    this.fWr = paramTypedArray.getColor(8, paramContext.getColor(2131100847));
    this.fWo = paramTypedArray.getColor(9, paramContext.getColor(2131100848));
    this.fWG = Boolean.valueOf(paramTypedArray.getBoolean(11, false));
    this.fWs = new StringBuilder(50);
    fVZ = paramTypedArray.getDimensionPixelSize(18, paramContext.getDimensionPixelSize(2131166909));
    fWd = paramTypedArray.getDimensionPixelSize(20, paramContext.getDimensionPixelSize(2131166911));
    fWb = paramTypedArray.getDimensionPixelSize(19, paramContext.getDimensionPixelSize(2131166910));
    fWc = paramTypedArray.getDimensionPixelOffset(14, paramContext.getDimensionPixelOffset(2131166415));
    fVX = paramTypedArray.getDimensionPixelSize(17, paramContext.getDimensionPixelOffset(2131166779));
    this.fWH = ((paramTypedArray.getDimensionPixelSize(0, paramContext.getDimensionPixelOffset(2131165948)) - fWc) / 6);
    this.fWI = paramTypedArray.getDimensionPixelSize(1, paramContext.getDimensionPixelOffset(2131166005));
    this.fWL = Boolean.valueOf(paramTypedArray.getBoolean(12, true));
    this.fWh = new Paint();
    this.fWh.setAntiAlias(true);
    this.fWh.setTextSize(fWd);
    this.fWh.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fWh.setColor(this.fWm);
    this.fWh.setTextAlign(Paint.Align.LEFT);
    this.fWh.setStyle(Paint.Style.FILL);
    this.fWg = new Paint();
    this.fWg.setFakeBoldText(true);
    this.fWg.setAntiAlias(true);
    this.fWg.setColor(this.fWo);
    this.fWg.setTextAlign(Paint.Align.CENTER);
    this.fWg.setStyle(Paint.Style.FILL);
    this.fWi = new Paint();
    this.fWi.setFakeBoldText(true);
    this.fWi.setAntiAlias(true);
    this.fWi.setColor(this.fWr);
    this.fWi.setTextAlign(Paint.Align.CENTER);
    this.fWi.setStyle(Paint.Style.FILL);
    this.fWe = new Paint();
    this.fWe.setAntiAlias(true);
    this.fWe.setTextSize(fWb);
    this.fWe.setColor(this.fWm);
    this.fWe.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fWe.setStyle(Paint.Style.FILL);
    this.fWe.setTextAlign(Paint.Align.CENTER);
    this.fWe.setFakeBoldText(true);
    this.fWf = new Paint();
    this.fWf.setAntiAlias(true);
    this.fWf.setTextSize(fVZ);
    this.fWf.setStyle(Paint.Style.FILL);
    this.fWf.setTextAlign(Paint.Align.CENTER);
    this.fWf.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private int ZF()
  {
    if (this.fWF < this.fWC) {}
    for (int i = this.fWF + this.fWD;; i = this.fWF) {
      return i - this.fWC;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = fWc;
    int k = fWb / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.fWD * 2);
    int i = 0;
    while (i < this.fWD)
    {
      int n = this.fWC;
      int i1 = this.fWD;
      int i2 = this.mPadding;
      this.fWK.set(7, (n + i) % i1);
      paramCanvas.drawText(this.fWM.getShortWeekdays()[this.fWK.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.fWe);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.fWH + fVZ) / 2 - fVY + fWc;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.fWD * 2);
    int i = ZF();
    int k = 1;
    while ((k <= this.fWE) && ((k <= this.fWB) || (-1 == this.fWB)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.fWx) && (this.fWv == k) && (this.fWz == this.mYear)) || ((this.mMonth == this.fWy) && (this.fWw == k) && (this.fWA == this.mYear)) || ((this.fWt) && (this.fWB == k) && (this.fWv == -1)))
      {
        if (!this.fWG.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - fVX, j - fVZ / 3 - fVX, fVX + m, j - fVZ / 3 + fVX), 10.0F, 10.0F, this.fWi);
      }
      for (;;)
      {
        if ((this.fWt) && (this.fWB == k) && (this.fWv == -1))
        {
          this.fWf.setColor(this.fWr);
          this.fWf.setTypeface(Typeface.defaultFromStyle(0));
          this.fWf.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131764448), m, j + 12 + fVX, this.fWf);
        }
        this.fWf.setTextSize(fVZ);
        if ((!this.fWt) || (this.fWB != k))
        {
          this.fWf.setColor(this.fWn);
          this.fWf.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.fWv != -1) && (this.fWw != -1) && (this.fWz == this.fWA) && (this.fWx == this.fWy) && (this.fWv == this.fWw) && (k == this.fWv) && (this.mMonth == this.fWx) && (this.mYear == this.fWz)) {
          this.fWf.setColor(this.fWr);
        }
        if ((this.fWv != -1) && (this.fWw != -1) && (this.fWz == this.fWA) && (this.fWz == this.mYear) && (((this.mMonth == this.fWx) && (this.fWy == this.fWx) && (((this.fWv < this.fWw) && (k > this.fWv) && (k < this.fWw)) || ((this.fWv > this.fWw) && (k < this.fWv) && (k > this.fWw)))) || ((this.fWx < this.fWy) && (this.mMonth == this.fWx) && (k > this.fWv)) || ((this.fWx < this.fWy) && (this.mMonth == this.fWy) && (k < this.fWw)) || ((this.fWx > this.fWy) && (this.mMonth == this.fWx) && (k < this.fWv)) || ((this.fWx > this.fWy) && (this.mMonth == this.fWy) && (k > this.fWw)))) {
          this.fWf.setColor(this.fWr);
        }
        if ((this.fWv != -1) && (this.fWw != -1) && (this.fWz != this.fWA) && (((this.fWz == this.mYear) && (this.mMonth == this.fWx)) || ((this.fWA == this.mYear) && (this.mMonth == this.fWy) && (((this.fWx < this.fWy) && (this.mMonth == this.fWx) && (k < this.fWv)) || ((this.fWx < this.fWy) && (this.mMonth == this.fWy) && (k > this.fWw)) || ((this.fWx > this.fWy) && (this.mMonth == this.fWx) && (k > this.fWv)) || ((this.fWx > this.fWy) && (this.mMonth == this.fWy) && (k < this.fWw)))))) {
          this.fWf.setColor(this.fWr);
        }
        if ((this.fWv != -1) && (this.fWw != -1) && (this.fWz == this.fWA) && (this.mYear == this.fWz) && (((this.mMonth > this.fWx) && (this.mMonth < this.fWy) && (this.fWx < this.fWy)) || ((this.mMonth < this.fWx) && (this.mMonth > this.fWy) && (this.fWx > this.fWy)))) {
          this.fWf.setColor(this.fWr);
        }
        if ((this.fWv != -1) && (this.fWw != -1) && (this.fWz != this.fWA) && (((this.fWz < this.fWA) && (((this.mMonth > this.fWx) && (this.mYear == this.fWz)) || ((this.mMonth < this.fWy) && (this.mYear == this.fWA)))) || ((this.fWz > this.fWA) && (((this.mMonth < this.fWx) && (this.mYear == this.fWz)) || ((this.mMonth > this.fWy) && (this.mYear == this.fWA)))))) {
          this.fWf.setColor(this.fWr);
        }
        if ((!this.fWL.booleanValue()) && (a(k, this.fWJ)) && (this.fWJ.month == this.mMonth) && (this.fWJ.year == this.mYear))
        {
          this.fWf.setColor(this.fWp);
          this.fWf.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.fPO.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.fMJ == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.fWf.setColor(this.fWq);
            this.fWf.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - fVZ / 3, fVX, this.fWi);
      }
      if (((this.mMonth == this.fWx) && (this.fWv == k) && (this.fWz == this.mYear)) || ((this.mMonth == this.fWy) && (this.fWw == k) && (this.fWA == this.mYear)) || ((this.fWt) && (this.fWB == k) && (this.fWv == -1)))
      {
        this.fWf.setTypeface(Typeface.defaultFromStyle(0));
        this.fWf.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.fWf);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.fWD)
      {
        i = 0;
        m = j + this.fWH;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.fWs.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.mPadding * 2) / (this.fWD * 2);
    int j = this.mPadding;
    int k = fWd / 2;
    int m = (fWc - fWd) / 2;
    int n = fWd;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.fWh);
    paramCanvas.drawLine(0.0F, fWc, this.mWidth, fWc + 1, this.fWh);
    f(paramCanvas);
    g(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.fWH * this.mNumRows + fWc + this.fWI);
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
      if ((paramMotionEvent != null) && (this.fWN != null) && ((this.fWL.booleanValue()) || (paramMotionEvent.month != this.fWJ.month) || (paramMotionEvent.year != this.fWJ.year) || (paramMotionEvent.fMJ >= this.fWJ.monthDay))) {
        this.fWN.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - fWc) / this.fWH;
      i = (int)((f1 - i) * this.fWD / (this.mWidth - i - this.mPadding)) - ZF() + 1 + j * this.fWD;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.h.a.cp(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.fPO.iterator();
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
      this.fPO = paramCollection;
      AppMethodBeat.o(12999);
      return;
    }
    ae.e("MicroMsg.SimpleMonthView", "markDateList is null");
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
      this.fWH = ((Integer)paramHashMap.get("height")).intValue();
      if (this.fWH < fWa) {
        this.fWH = fWa;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.fWv = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.fWw = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.fWx = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.fWy = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.fWz = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.fWA = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.fWt = false;
    this.fWB = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.fWF = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.fWC = ((Integer)paramHashMap.get("week_start")).intValue();
      this.fWE = com.tencent.mm.chatroom.h.a.cp(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.fWE) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.fWJ;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.fWt = true;
        this.fWB = m;
      }
      this.fWu = a(m, this.fWJ);
      i += 1;
      break label393;
      this.fWC = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = ZF();
    j = (this.fWE + m) / this.fWD;
    int i = k;
    if ((m + this.fWE) % this.fWD > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.fWN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.chatroom.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */