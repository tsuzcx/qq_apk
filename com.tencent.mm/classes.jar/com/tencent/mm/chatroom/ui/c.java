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
import com.tencent.mm.sdk.platformtools.ab;
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
  protected static int eki = 32;
  protected static int ekj;
  protected static int ekk = 1;
  protected static int ekl;
  protected static int ekm = 10;
  protected static int ekn;
  protected static int eko;
  protected static int ekp;
  Collection<com.tencent.mm.chatroom.c.a> egd;
  protected int ekA;
  protected int ekB;
  protected int ekC;
  protected int ekD;
  private final StringBuilder ekE;
  protected boolean ekF;
  protected boolean ekG;
  protected int ekH;
  protected int ekI;
  protected int ekJ;
  protected int ekK;
  protected int ekL;
  protected int ekM;
  protected int ekN;
  protected int ekO;
  protected int ekP;
  protected int ekQ;
  private int ekR;
  protected Boolean ekS;
  protected int ekT;
  protected int ekU;
  final Time ekV;
  private final Calendar ekW;
  private final Calendar ekX;
  private final Boolean ekY;
  private DateFormatSymbols ekZ;
  protected Paint ekq;
  protected Paint ekr;
  protected Paint eks;
  protected Paint ekt;
  protected Paint eku;
  protected int ekv;
  protected int ekw;
  protected int ekx;
  protected int eky;
  protected int ekz;
  private c.a ela;
  private Context mContext;
  protected int mMonth;
  public int mNumRows;
  protected int mPadding;
  protected int mWidth;
  protected int mYear;
  
  public c(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    AppMethodBeat.i(104451);
    this.mPadding = 80;
    this.ekF = false;
    this.ekG = false;
    this.ekH = -1;
    this.ekI = -1;
    this.ekJ = -1;
    this.ekK = -1;
    this.ekL = -1;
    this.ekM = -1;
    this.ekN = -1;
    this.ekO = 1;
    this.ekP = 7;
    this.ekQ = this.ekP;
    this.ekR = 0;
    this.ekT = eki;
    this.ekU = 0;
    this.mNumRows = 6;
    this.ekZ = new DateFormatSymbols();
    this.egd = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.ekX = Calendar.getInstance();
    this.ekW = Calendar.getInstance();
    this.ekV = new Time(Time.getCurrentTimezone());
    this.ekV.setToNow();
    this.ekv = paramTypedArray.getColor(0, paramContext.getColor(2131690319));
    this.ekw = paramTypedArray.getColor(6, paramContext.getColor(2131690319));
    this.ekx = paramTypedArray.getColor(7, paramContext.getColor(2131690319));
    this.eky = paramTypedArray.getColor(7, paramContext.getColor(2131690320));
    this.ekz = paramTypedArray.getColor(5, paramContext.getColor(2131690319));
    this.ekB = paramTypedArray.getColor(3, paramContext.getColor(2131690319));
    this.ekC = paramTypedArray.getColor(4, paramContext.getColor(2131690276));
    this.ekD = paramTypedArray.getColor(1, paramContext.getColor(2131690432));
    this.ekA = paramTypedArray.getColor(2, paramContext.getColor(2131690433));
    this.ekS = Boolean.valueOf(paramTypedArray.getBoolean(17, false));
    this.ekE = new StringBuilder(50);
    ekl = paramTypedArray.getDimensionPixelSize(8, paramContext.getDimensionPixelSize(2131428748));
    ekp = paramTypedArray.getDimensionPixelSize(9, paramContext.getDimensionPixelSize(2131428750));
    ekn = paramTypedArray.getDimensionPixelSize(10, paramContext.getDimensionPixelSize(2131428749));
    eko = paramTypedArray.getDimensionPixelOffset(11, paramContext.getDimensionPixelOffset(2131428453));
    ekj = paramTypedArray.getDimensionPixelSize(12, paramContext.getDimensionPixelOffset(2131428653));
    this.ekT = ((paramTypedArray.getDimensionPixelSize(13, paramContext.getDimensionPixelOffset(2131428150)) - eko) / 6);
    this.ekU = paramTypedArray.getDimensionPixelSize(14, paramContext.getDimensionPixelOffset(2131428206));
    this.ekY = Boolean.valueOf(paramTypedArray.getBoolean(15, true));
    this.ekt = new Paint();
    this.ekt.setAntiAlias(true);
    this.ekt.setTextSize(ekp);
    this.ekt.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.ekt.setColor(this.eky);
    this.ekt.setTextAlign(Paint.Align.LEFT);
    this.ekt.setStyle(Paint.Style.FILL);
    this.eks = new Paint();
    this.eks.setFakeBoldText(true);
    this.eks.setAntiAlias(true);
    this.eks.setColor(this.ekA);
    this.eks.setTextAlign(Paint.Align.CENTER);
    this.eks.setStyle(Paint.Style.FILL);
    this.eku = new Paint();
    this.eku.setFakeBoldText(true);
    this.eku.setAntiAlias(true);
    this.eku.setColor(this.ekD);
    this.eku.setTextAlign(Paint.Align.CENTER);
    this.eku.setStyle(Paint.Style.FILL);
    this.ekq = new Paint();
    this.ekq.setAntiAlias(true);
    this.ekq.setTextSize(ekn);
    this.ekq.setColor(this.eky);
    this.ekq.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.ekq.setStyle(Paint.Style.FILL);
    this.ekq.setTextAlign(Paint.Align.CENTER);
    this.ekq.setFakeBoldText(true);
    this.ekr = new Paint();
    this.ekr.setAntiAlias(true);
    this.ekr.setTextSize(ekl);
    this.ekr.setStyle(Paint.Style.FILL);
    this.ekr.setTextAlign(Paint.Align.CENTER);
    this.ekr.setFakeBoldText(false);
    AppMethodBeat.o(104451);
  }
  
  private int Kw()
  {
    if (this.ekR < this.ekO) {}
    for (int i = this.ekR + this.ekP;; i = this.ekR) {
      return i - this.ekO;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void d(Canvas paramCanvas)
  {
    AppMethodBeat.i(104452);
    int j = eko;
    int k = ekn / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.ekP * 2);
    int i = 0;
    while (i < this.ekP)
    {
      int n = this.ekO;
      int i1 = this.ekP;
      int i2 = this.mPadding;
      this.ekX.set(7, (n + i) % i1);
      paramCanvas.drawText(this.ekZ.getShortWeekdays()[this.ekX.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.ekq);
      i += 1;
    }
    AppMethodBeat.o(104452);
  }
  
  private void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(104454);
    int j = (this.ekT + ekl) / 2 - ekk + eko;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.ekP * 2);
    int i = Kw();
    int k = 1;
    while ((k <= this.ekQ) && ((k <= this.ekN) || (-1 == this.ekN)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.ekJ) && (this.ekH == k) && (this.ekL == this.mYear)) || ((this.mMonth == this.ekK) && (this.ekI == k) && (this.ekM == this.mYear)) || ((this.ekF) && (this.ekN == k) && (this.ekH == -1)))
      {
        if (!this.ekS.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - ekj, j - ekl / 3 - ekj, ekj + m, j - ekl / 3 + ekj), 10.0F, 10.0F, this.eku);
      }
      for (;;)
      {
        if ((this.ekF) && (this.ekN == k) && (this.ekH == -1))
        {
          this.ekr.setColor(this.ekD);
          this.ekr.setTypeface(Typeface.defaultFromStyle(0));
          this.ekr.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131304315), m, j + 12 + ekj, this.ekr);
        }
        this.ekr.setTextSize(ekl);
        if ((!this.ekF) || (this.ekN != k))
        {
          this.ekr.setColor(this.ekz);
          this.ekr.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.ekH != -1) && (this.ekI != -1) && (this.ekL == this.ekM) && (this.ekJ == this.ekK) && (this.ekH == this.ekI) && (k == this.ekH) && (this.mMonth == this.ekJ) && (this.mYear == this.ekL)) {
          this.ekr.setColor(this.ekD);
        }
        if ((this.ekH != -1) && (this.ekI != -1) && (this.ekL == this.ekM) && (this.ekL == this.mYear) && (((this.mMonth == this.ekJ) && (this.ekK == this.ekJ) && (((this.ekH < this.ekI) && (k > this.ekH) && (k < this.ekI)) || ((this.ekH > this.ekI) && (k < this.ekH) && (k > this.ekI)))) || ((this.ekJ < this.ekK) && (this.mMonth == this.ekJ) && (k > this.ekH)) || ((this.ekJ < this.ekK) && (this.mMonth == this.ekK) && (k < this.ekI)) || ((this.ekJ > this.ekK) && (this.mMonth == this.ekJ) && (k < this.ekH)) || ((this.ekJ > this.ekK) && (this.mMonth == this.ekK) && (k > this.ekI)))) {
          this.ekr.setColor(this.ekD);
        }
        if ((this.ekH != -1) && (this.ekI != -1) && (this.ekL != this.ekM) && (((this.ekL == this.mYear) && (this.mMonth == this.ekJ)) || ((this.ekM == this.mYear) && (this.mMonth == this.ekK) && (((this.ekJ < this.ekK) && (this.mMonth == this.ekJ) && (k < this.ekH)) || ((this.ekJ < this.ekK) && (this.mMonth == this.ekK) && (k > this.ekI)) || ((this.ekJ > this.ekK) && (this.mMonth == this.ekJ) && (k > this.ekH)) || ((this.ekJ > this.ekK) && (this.mMonth == this.ekK) && (k < this.ekI)))))) {
          this.ekr.setColor(this.ekD);
        }
        if ((this.ekH != -1) && (this.ekI != -1) && (this.ekL == this.ekM) && (this.mYear == this.ekL) && (((this.mMonth > this.ekJ) && (this.mMonth < this.ekK) && (this.ekJ < this.ekK)) || ((this.mMonth < this.ekJ) && (this.mMonth > this.ekK) && (this.ekJ > this.ekK)))) {
          this.ekr.setColor(this.ekD);
        }
        if ((this.ekH != -1) && (this.ekI != -1) && (this.ekL != this.ekM) && (((this.ekL < this.ekM) && (((this.mMonth > this.ekJ) && (this.mYear == this.ekL)) || ((this.mMonth < this.ekK) && (this.mYear == this.ekM)))) || ((this.ekL > this.ekM) && (((this.mMonth < this.ekJ) && (this.mYear == this.ekL)) || ((this.mMonth > this.ekK) && (this.mYear == this.ekM)))))) {
          this.ekr.setColor(this.ekD);
        }
        if ((!this.ekY.booleanValue()) && (a(k, this.ekV)) && (this.ekV.month == this.mMonth) && (this.ekV.year == this.mYear))
        {
          this.ekr.setColor(this.ekB);
          this.ekr.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.egd.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.c.a locala = (com.tencent.mm.chatroom.c.a)localIterator.next();
          if ((locala.eel == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.ekr.setColor(this.ekC);
            this.ekr.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - ekl / 3, ekj, this.eku);
      }
      if (((this.mMonth == this.ekJ) && (this.ekH == k) && (this.ekL == this.mYear)) || ((this.mMonth == this.ekK) && (this.ekI == k) && (this.ekM == this.mYear)) || ((this.ekF) && (this.ekN == k) && (this.ekH == -1)))
      {
        this.ekr.setTypeface(Typeface.defaultFromStyle(0));
        this.ekr.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.ekr);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.ekP)
      {
        i = 0;
        m = j + this.ekT;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(104454);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(104453);
    this.ekE.setLength(0);
    long l = this.ekW.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(104453);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104455);
    int i = (this.mWidth - this.mPadding * 2) / (this.ekP * 2);
    int j = this.mPadding;
    int k = ekp / 2;
    int m = (eko - ekp) / 2;
    int n = ekp;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.ekt);
    paramCanvas.drawLine(0.0F, eko, this.mWidth, eko + 1, this.ekt);
    d(paramCanvas);
    e(paramCanvas);
    AppMethodBeat.o(104455);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104456);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.ekT * this.mNumRows + eko + this.ekU);
    AppMethodBeat.o(104456);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(104457);
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
      if ((paramMotionEvent != null) && (this.ela != null) && ((this.ekY.booleanValue()) || (paramMotionEvent.month != this.ekV.month) || (paramMotionEvent.year != this.ekV.year) || (paramMotionEvent.eel >= this.ekV.monthDay))) {
        this.ela.b(paramMotionEvent);
      }
      AppMethodBeat.o(104457);
      return true;
      label136:
      int j = (int)(f2 - eko) / this.ekT;
      i = (int)((f1 - i) * this.ekP / (this.mWidth - i - this.mPadding)) - Kw() + 1 + j * this.ekP;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.f.a.bU(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.c.a locala = new com.tencent.mm.chatroom.c.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.egd.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramMotionEvent = (com.tencent.mm.chatroom.c.a)localIterator.next();
            if (paramMotionEvent.equals(locala)) {
              break;
            }
          }
        }
        paramMotionEvent = null;
      }
    }
  }
  
  public final void setMarkDate(Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    AppMethodBeat.i(104458);
    if (paramCollection != null)
    {
      this.egd = paramCollection;
      AppMethodBeat.o(104458);
      return;
    }
    ab.e("MicroMsg.SimpleMonthView", "markDateList is null");
    AppMethodBeat.o(104458);
  }
  
  public final void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    int k = 0;
    AppMethodBeat.i(104459);
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year")))
    {
      paramHashMap = new InvalidParameterException("You must specify month and year for this view");
      AppMethodBeat.o(104459);
      throw paramHashMap;
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.ekT = ((Integer)paramHashMap.get("height")).intValue();
      if (this.ekT < ekm) {
        this.ekT = ekm;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.ekH = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.ekI = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.ekJ = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.ekK = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.ekL = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.ekM = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.ekF = false;
    this.ekN = -1;
    this.ekW.set(2, this.mMonth);
    this.ekW.set(1, this.mYear);
    this.ekW.set(5, 1);
    this.ekR = this.ekW.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.ekO = ((Integer)paramHashMap.get("week_start")).intValue();
      this.ekQ = com.tencent.mm.chatroom.f.a.bU(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.ekQ) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.ekV;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.ekF = true;
        this.ekN = m;
      }
      this.ekG = a(m, this.ekV);
      i += 1;
      break label393;
      this.ekO = this.ekW.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = Kw();
    j = (this.ekQ + m) / this.ekP;
    int i = k;
    if ((m + this.ekQ) % this.ekP > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(104459);
  }
  
  public final void setOnDayClickListener(c.a parama)
  {
    this.ela = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */