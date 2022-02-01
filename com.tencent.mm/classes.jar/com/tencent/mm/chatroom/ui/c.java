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
import com.tencent.mm.sdk.platformtools.Log;
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
  protected static int jli = 32;
  protected static int jlj;
  protected static int jlk = 1;
  protected static int jll;
  protected static int jlm = 10;
  protected static int jln;
  protected static int jlo;
  protected static int jlp;
  public int AA;
  protected int clC;
  Collection<com.tencent.mm.chatroom.d.a> iZj;
  protected int jlA;
  protected int jlB;
  protected int jlC;
  protected int jlD;
  private final StringBuilder jlE;
  protected boolean jlF;
  protected boolean jlG;
  protected int jlH;
  protected int jlI;
  protected int jlJ;
  protected int jlK;
  protected int jlL;
  protected int jlM;
  protected int jlN;
  protected int jlO;
  protected int jlP;
  protected int jlQ;
  private int jlR;
  protected Boolean jlS;
  protected int jlT;
  protected int jlU;
  final Time jlV;
  private final Calendar jlW;
  private final Boolean jlX;
  private DateFormatSymbols jlY;
  private a jlZ;
  protected Paint jlq;
  protected Paint jlr;
  protected Paint jls;
  protected Paint jlt;
  protected Paint jlu;
  protected int jlv;
  protected int jlw;
  protected int jlx;
  protected int jly;
  protected int jlz;
  private final Calendar mCalendar;
  private Context mContext;
  protected int mMonth;
  protected int mWidth;
  protected int mYear;
  
  public c(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    AppMethodBeat.i(12992);
    this.clC = 80;
    this.jlF = false;
    this.jlG = false;
    this.jlH = -1;
    this.jlI = -1;
    this.jlJ = -1;
    this.jlK = -1;
    this.jlL = -1;
    this.jlM = -1;
    this.jlN = -1;
    this.jlO = 1;
    this.jlP = 7;
    this.jlQ = this.jlP;
    this.jlR = 0;
    this.jlT = jli;
    this.jlU = 0;
    this.AA = 6;
    this.jlY = new DateFormatSymbols();
    this.iZj = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.jlW = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.jlV = new Time(Time.getCurrentTimezone());
    this.jlV.setToNow();
    this.jlv = paramTypedArray.getColor(a.j.jhm, paramContext.getColor(a.b.jbX));
    this.jlw = paramTypedArray.getColor(a.j.jhp, paramContext.getColor(a.b.jbX));
    this.jlx = paramTypedArray.getColor(a.j.jhn, paramContext.getColor(a.b.jbX));
    this.jly = paramTypedArray.getColor(a.j.jhn, paramContext.getColor(a.b.jbY));
    this.jlz = paramTypedArray.getColor(a.j.jhq, paramContext.getColor(a.b.jbX));
    this.jlB = paramTypedArray.getColor(a.j.jhr, paramContext.getColor(a.b.jbX));
    this.jlC = paramTypedArray.getColor(a.j.jho, paramContext.getColor(a.b.jbW));
    this.jlD = paramTypedArray.getColor(a.j.jhs, paramContext.getColor(a.b.jbZ));
    this.jlA = paramTypedArray.getColor(a.j.jht, paramContext.getColor(a.b.jca));
    this.jlS = Boolean.valueOf(paramTypedArray.getBoolean(a.j.jhv, false));
    this.jlE = new StringBuilder(50);
    jll = paramTypedArray.getDimensionPixelSize(a.j.jhC, paramContext.getDimensionPixelSize(a.c.jcg));
    jlp = paramTypedArray.getDimensionPixelSize(a.j.jhE, paramContext.getDimensionPixelSize(a.c.jci));
    jln = paramTypedArray.getDimensionPixelSize(a.j.jhD, paramContext.getDimensionPixelSize(a.c.jch));
    jlo = paramTypedArray.getDimensionPixelOffset(a.j.jhy, paramContext.getDimensionPixelOffset(a.c.jce));
    jlj = paramTypedArray.getDimensionPixelSize(a.j.jhB, paramContext.getDimensionPixelOffset(a.c.jcf));
    this.jlT = ((paramTypedArray.getDimensionPixelSize(a.j.jhk, paramContext.getDimensionPixelOffset(a.c.jcc)) - jlo) / 6);
    this.jlU = paramTypedArray.getDimensionPixelSize(a.j.jhl, paramContext.getDimensionPixelOffset(a.c.jcd));
    this.jlX = Boolean.valueOf(paramTypedArray.getBoolean(a.j.jhw, true));
    this.jlt = new Paint();
    this.jlt.setAntiAlias(true);
    this.jlt.setTextSize(jlp);
    this.jlt.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.jlt.setColor(this.jly);
    this.jlt.setTextAlign(Paint.Align.LEFT);
    this.jlt.setStyle(Paint.Style.FILL);
    this.jls = new Paint();
    this.jls.setFakeBoldText(true);
    this.jls.setAntiAlias(true);
    this.jls.setColor(this.jlA);
    this.jls.setTextAlign(Paint.Align.CENTER);
    this.jls.setStyle(Paint.Style.FILL);
    this.jlu = new Paint();
    this.jlu.setFakeBoldText(true);
    this.jlu.setAntiAlias(true);
    this.jlu.setColor(this.jlD);
    this.jlu.setTextAlign(Paint.Align.CENTER);
    this.jlu.setStyle(Paint.Style.FILL);
    this.jlq = new Paint();
    this.jlq.setAntiAlias(true);
    this.jlq.setTextSize(jln);
    this.jlq.setColor(this.jly);
    this.jlq.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.jlq.setStyle(Paint.Style.FILL);
    this.jlq.setTextAlign(Paint.Align.CENTER);
    this.jlq.setFakeBoldText(true);
    this.jlr = new Paint();
    this.jlr.setAntiAlias(true);
    this.jlr.setTextSize(jll);
    this.jlr.setStyle(Paint.Style.FILL);
    this.jlr.setTextAlign(Paint.Align.CENTER);
    this.jlr.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private int att()
  {
    if (this.jlR < this.jlO) {}
    for (int i = this.jlR + this.jlP;; i = this.jlR) {
      return i - this.jlO;
    }
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = jlo;
    int k = jln / 2;
    int m = (this.mWidth - this.clC * 2) / (this.jlP * 2);
    int i = 0;
    while (i < this.jlP)
    {
      int n = this.jlO;
      int i1 = this.jlP;
      int i2 = this.clC;
      this.jlW.set(7, (n + i) % i1);
      paramCanvas.drawText(this.jlY.getShortWeekdays()[this.jlW.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.jlq);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.jlE.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  private void h(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.jlT + jll) / 2 - jlk + jlo;
    int i1 = (this.mWidth - this.clC * 2) / (this.jlP * 2);
    int i = att();
    int k = 1;
    while ((k <= this.jlQ) && ((k <= this.jlN) || (-1 == this.jlN)))
    {
      int m = this.clC + (i * 2 + 1) * i1;
      if (((this.mMonth == this.jlJ) && (this.jlH == k) && (this.jlL == this.mYear)) || ((this.mMonth == this.jlK) && (this.jlI == k) && (this.jlM == this.mYear)) || ((this.jlF) && (this.jlN == k) && (this.jlH == -1)))
      {
        if (!this.jlS.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - jlj, j - jll / 3 - jlj, jlj + m, j - jll / 3 + jlj), 10.0F, 10.0F, this.jlu);
      }
      for (;;)
      {
        if ((this.jlF) && (this.jlN == k) && (this.jlH == -1))
        {
          this.jlr.setColor(this.jlD);
          this.jlr.setTypeface(Typeface.defaultFromStyle(0));
          this.jlr.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(a.i.jhe), m, j + 12 + jlj, this.jlr);
        }
        this.jlr.setTextSize(jll);
        if ((!this.jlF) || (this.jlN != k))
        {
          this.jlr.setColor(this.jlz);
          this.jlr.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.jlH != -1) && (this.jlI != -1) && (this.jlL == this.jlM) && (this.jlJ == this.jlK) && (this.jlH == this.jlI) && (k == this.jlH) && (this.mMonth == this.jlJ) && (this.mYear == this.jlL)) {
          this.jlr.setColor(this.jlD);
        }
        if ((this.jlH != -1) && (this.jlI != -1) && (this.jlL == this.jlM) && (this.jlL == this.mYear) && (((this.mMonth == this.jlJ) && (this.jlK == this.jlJ) && (((this.jlH < this.jlI) && (k > this.jlH) && (k < this.jlI)) || ((this.jlH > this.jlI) && (k < this.jlH) && (k > this.jlI)))) || ((this.jlJ < this.jlK) && (this.mMonth == this.jlJ) && (k > this.jlH)) || ((this.jlJ < this.jlK) && (this.mMonth == this.jlK) && (k < this.jlI)) || ((this.jlJ > this.jlK) && (this.mMonth == this.jlJ) && (k < this.jlH)) || ((this.jlJ > this.jlK) && (this.mMonth == this.jlK) && (k > this.jlI)))) {
          this.jlr.setColor(this.jlD);
        }
        if ((this.jlH != -1) && (this.jlI != -1) && (this.jlL != this.jlM) && (((this.jlL == this.mYear) && (this.mMonth == this.jlJ)) || ((this.jlM == this.mYear) && (this.mMonth == this.jlK) && (((this.jlJ < this.jlK) && (this.mMonth == this.jlJ) && (k < this.jlH)) || ((this.jlJ < this.jlK) && (this.mMonth == this.jlK) && (k > this.jlI)) || ((this.jlJ > this.jlK) && (this.mMonth == this.jlJ) && (k > this.jlH)) || ((this.jlJ > this.jlK) && (this.mMonth == this.jlK) && (k < this.jlI)))))) {
          this.jlr.setColor(this.jlD);
        }
        if ((this.jlH != -1) && (this.jlI != -1) && (this.jlL == this.jlM) && (this.mYear == this.jlL) && (((this.mMonth > this.jlJ) && (this.mMonth < this.jlK) && (this.jlJ < this.jlK)) || ((this.mMonth < this.jlJ) && (this.mMonth > this.jlK) && (this.jlJ > this.jlK)))) {
          this.jlr.setColor(this.jlD);
        }
        if ((this.jlH != -1) && (this.jlI != -1) && (this.jlL != this.jlM) && (((this.jlL < this.jlM) && (((this.mMonth > this.jlJ) && (this.mYear == this.jlL)) || ((this.mMonth < this.jlK) && (this.mYear == this.jlM)))) || ((this.jlL > this.jlM) && (((this.mMonth < this.jlJ) && (this.mYear == this.jlL)) || ((this.mMonth > this.jlK) && (this.mYear == this.jlM)))))) {
          this.jlr.setColor(this.jlD);
        }
        if ((!this.jlX.booleanValue()) && (a(k, this.jlV)) && (this.jlV.month == this.mMonth) && (this.jlV.year == this.mYear))
        {
          this.jlr.setColor(this.jlB);
          this.jlr.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.iZj.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.day == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.jlr.setColor(this.jlC);
            this.jlr.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - jll / 3, jlj, this.jlu);
      }
      if (((this.mMonth == this.jlJ) && (this.jlH == k) && (this.jlL == this.mYear)) || ((this.mMonth == this.jlK) && (this.jlI == k) && (this.jlM == this.mYear)) || ((this.jlF) && (this.jlN == k) && (this.jlH == -1)))
      {
        this.jlr.setTypeface(Typeface.defaultFromStyle(0));
        this.jlr.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.jlr);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.jlP)
      {
        i = 0;
        m = j + this.jlT;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.clC * 2) / (this.jlP * 2);
    int j = this.clC;
    int k = jlp / 2;
    int m = (jlo - jlp) / 2;
    int n = jlp;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.jlt);
    paramCanvas.drawLine(0.0F, jlo, this.mWidth, jlo + 1, this.jlt);
    g(paramCanvas);
    h(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jlT * this.AA + jlo + this.jlU);
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
      i = this.clC;
      if ((f1 >= i) && (f1 <= this.mWidth - this.clC)) {
        break label136;
      }
      paramMotionEvent = null;
    }
    for (;;)
    {
      if ((paramMotionEvent != null) && (this.jlZ != null) && ((this.jlX.booleanValue()) || (paramMotionEvent.month != this.jlV.month) || (paramMotionEvent.year != this.jlV.year) || (paramMotionEvent.day >= this.jlV.monthDay))) {
        this.jlZ.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - jlo) / this.jlT;
      i = (int)((f1 - i) * this.jlP / (this.mWidth - i - this.clC)) - att() + 1 + j * this.jlP;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.h.a.cJ(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.iZj.iterator();
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
      this.iZj = paramCollection;
      AppMethodBeat.o(12999);
      return;
    }
    Log.e("MicroMsg.SimpleMonthView", "markDateList is null");
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
      this.jlT = ((Integer)paramHashMap.get("height")).intValue();
      if (this.jlT < jlm) {
        this.jlT = jlm;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.jlH = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.jlI = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.jlJ = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.jlK = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.jlL = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.jlM = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.jlF = false;
    this.jlN = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.jlR = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.jlO = ((Integer)paramHashMap.get("week_start")).intValue();
      this.jlQ = com.tencent.mm.chatroom.h.a.cJ(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.jlQ) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.jlV;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.jlF = true;
        this.jlN = m;
      }
      this.jlG = a(m, this.jlV);
      i += 1;
      break label393;
      this.jlO = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = att();
    j = (this.jlQ + m) / this.jlP;
    int i = k;
    if ((m + this.jlQ) % this.jlP > 0) {
      i = 1;
    }
    this.AA = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.jlZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.chatroom.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */