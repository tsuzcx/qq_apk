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
import com.tencent.mm.sdk.platformtools.ad;
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
  protected static int fTQ = 32;
  protected static int fTR;
  protected static int fTS = 1;
  protected static int fTT;
  protected static int fTU = 10;
  protected static int fTV;
  protected static int fTW;
  protected static int fTX;
  Collection<com.tencent.mm.chatroom.d.a> fNH;
  protected Paint fTY;
  protected Paint fTZ;
  protected Boolean fUA;
  protected int fUB;
  protected int fUC;
  final Time fUD;
  private final Calendar fUE;
  private final Boolean fUF;
  private DateFormatSymbols fUG;
  private a fUH;
  protected Paint fUa;
  protected Paint fUb;
  protected Paint fUc;
  protected int fUd;
  protected int fUe;
  protected int fUf;
  protected int fUg;
  protected int fUh;
  protected int fUi;
  protected int fUj;
  protected int fUk;
  protected int fUl;
  private final StringBuilder fUm;
  protected boolean fUn;
  protected boolean fUo;
  protected int fUp;
  protected int fUq;
  protected int fUr;
  protected int fUs;
  protected int fUt;
  protected int fUu;
  protected int fUv;
  protected int fUw;
  protected int fUx;
  protected int fUy;
  private int fUz;
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
    this.fUn = false;
    this.fUo = false;
    this.fUp = -1;
    this.fUq = -1;
    this.fUr = -1;
    this.fUs = -1;
    this.fUt = -1;
    this.fUu = -1;
    this.fUv = -1;
    this.fUw = 1;
    this.fUx = 7;
    this.fUy = this.fUx;
    this.fUz = 0;
    this.fUB = fTQ;
    this.fUC = 0;
    this.mNumRows = 6;
    this.fUG = new DateFormatSymbols();
    this.fNH = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.fUE = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.fUD = new Time(Time.getCurrentTimezone());
    this.fUD.setToNow();
    this.fUd = paramTypedArray.getColor(2, paramContext.getColor(2131100708));
    this.fUe = paramTypedArray.getColor(5, paramContext.getColor(2131100708));
    this.fUf = paramTypedArray.getColor(3, paramContext.getColor(2131100708));
    this.fUg = paramTypedArray.getColor(3, paramContext.getColor(2131100709));
    this.fUh = paramTypedArray.getColor(6, paramContext.getColor(2131100708));
    this.fUj = paramTypedArray.getColor(7, paramContext.getColor(2131100708));
    this.fUk = paramTypedArray.getColor(4, paramContext.getColor(2131100618));
    this.fUl = paramTypedArray.getColor(8, paramContext.getColor(2131100847));
    this.fUi = paramTypedArray.getColor(9, paramContext.getColor(2131100848));
    this.fUA = Boolean.valueOf(paramTypedArray.getBoolean(11, false));
    this.fUm = new StringBuilder(50);
    fTT = paramTypedArray.getDimensionPixelSize(18, paramContext.getDimensionPixelSize(2131166909));
    fTX = paramTypedArray.getDimensionPixelSize(20, paramContext.getDimensionPixelSize(2131166911));
    fTV = paramTypedArray.getDimensionPixelSize(19, paramContext.getDimensionPixelSize(2131166910));
    fTW = paramTypedArray.getDimensionPixelOffset(14, paramContext.getDimensionPixelOffset(2131166415));
    fTR = paramTypedArray.getDimensionPixelSize(17, paramContext.getDimensionPixelOffset(2131166779));
    this.fUB = ((paramTypedArray.getDimensionPixelSize(0, paramContext.getDimensionPixelOffset(2131165948)) - fTW) / 6);
    this.fUC = paramTypedArray.getDimensionPixelSize(1, paramContext.getDimensionPixelOffset(2131166005));
    this.fUF = Boolean.valueOf(paramTypedArray.getBoolean(12, true));
    this.fUb = new Paint();
    this.fUb.setAntiAlias(true);
    this.fUb.setTextSize(fTX);
    this.fUb.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fUb.setColor(this.fUg);
    this.fUb.setTextAlign(Paint.Align.LEFT);
    this.fUb.setStyle(Paint.Style.FILL);
    this.fUa = new Paint();
    this.fUa.setFakeBoldText(true);
    this.fUa.setAntiAlias(true);
    this.fUa.setColor(this.fUi);
    this.fUa.setTextAlign(Paint.Align.CENTER);
    this.fUa.setStyle(Paint.Style.FILL);
    this.fUc = new Paint();
    this.fUc.setFakeBoldText(true);
    this.fUc.setAntiAlias(true);
    this.fUc.setColor(this.fUl);
    this.fUc.setTextAlign(Paint.Align.CENTER);
    this.fUc.setStyle(Paint.Style.FILL);
    this.fTY = new Paint();
    this.fTY.setAntiAlias(true);
    this.fTY.setTextSize(fTV);
    this.fTY.setColor(this.fUg);
    this.fTY.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fTY.setStyle(Paint.Style.FILL);
    this.fTY.setTextAlign(Paint.Align.CENTER);
    this.fTY.setFakeBoldText(true);
    this.fTZ = new Paint();
    this.fTZ.setAntiAlias(true);
    this.fTZ.setTextSize(fTT);
    this.fTZ.setStyle(Paint.Style.FILL);
    this.fTZ.setTextAlign(Paint.Align.CENTER);
    this.fTZ.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private int Zw()
  {
    if (this.fUz < this.fUw) {}
    for (int i = this.fUz + this.fUx;; i = this.fUz) {
      return i - this.fUw;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = fTW;
    int k = fTV / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.fUx * 2);
    int i = 0;
    while (i < this.fUx)
    {
      int n = this.fUw;
      int i1 = this.fUx;
      int i2 = this.mPadding;
      this.fUE.set(7, (n + i) % i1);
      paramCanvas.drawText(this.fUG.getShortWeekdays()[this.fUE.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.fTY);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.fUB + fTT) / 2 - fTS + fTW;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.fUx * 2);
    int i = Zw();
    int k = 1;
    while ((k <= this.fUy) && ((k <= this.fUv) || (-1 == this.fUv)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.fUr) && (this.fUp == k) && (this.fUt == this.mYear)) || ((this.mMonth == this.fUs) && (this.fUq == k) && (this.fUu == this.mYear)) || ((this.fUn) && (this.fUv == k) && (this.fUp == -1)))
      {
        if (!this.fUA.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - fTR, j - fTT / 3 - fTR, fTR + m, j - fTT / 3 + fTR), 10.0F, 10.0F, this.fUc);
      }
      for (;;)
      {
        if ((this.fUn) && (this.fUv == k) && (this.fUp == -1))
        {
          this.fTZ.setColor(this.fUl);
          this.fTZ.setTypeface(Typeface.defaultFromStyle(0));
          this.fTZ.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131764448), m, j + 12 + fTR, this.fTZ);
        }
        this.fTZ.setTextSize(fTT);
        if ((!this.fUn) || (this.fUv != k))
        {
          this.fTZ.setColor(this.fUh);
          this.fTZ.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.fUp != -1) && (this.fUq != -1) && (this.fUt == this.fUu) && (this.fUr == this.fUs) && (this.fUp == this.fUq) && (k == this.fUp) && (this.mMonth == this.fUr) && (this.mYear == this.fUt)) {
          this.fTZ.setColor(this.fUl);
        }
        if ((this.fUp != -1) && (this.fUq != -1) && (this.fUt == this.fUu) && (this.fUt == this.mYear) && (((this.mMonth == this.fUr) && (this.fUs == this.fUr) && (((this.fUp < this.fUq) && (k > this.fUp) && (k < this.fUq)) || ((this.fUp > this.fUq) && (k < this.fUp) && (k > this.fUq)))) || ((this.fUr < this.fUs) && (this.mMonth == this.fUr) && (k > this.fUp)) || ((this.fUr < this.fUs) && (this.mMonth == this.fUs) && (k < this.fUq)) || ((this.fUr > this.fUs) && (this.mMonth == this.fUr) && (k < this.fUp)) || ((this.fUr > this.fUs) && (this.mMonth == this.fUs) && (k > this.fUq)))) {
          this.fTZ.setColor(this.fUl);
        }
        if ((this.fUp != -1) && (this.fUq != -1) && (this.fUt != this.fUu) && (((this.fUt == this.mYear) && (this.mMonth == this.fUr)) || ((this.fUu == this.mYear) && (this.mMonth == this.fUs) && (((this.fUr < this.fUs) && (this.mMonth == this.fUr) && (k < this.fUp)) || ((this.fUr < this.fUs) && (this.mMonth == this.fUs) && (k > this.fUq)) || ((this.fUr > this.fUs) && (this.mMonth == this.fUr) && (k > this.fUp)) || ((this.fUr > this.fUs) && (this.mMonth == this.fUs) && (k < this.fUq)))))) {
          this.fTZ.setColor(this.fUl);
        }
        if ((this.fUp != -1) && (this.fUq != -1) && (this.fUt == this.fUu) && (this.mYear == this.fUt) && (((this.mMonth > this.fUr) && (this.mMonth < this.fUs) && (this.fUr < this.fUs)) || ((this.mMonth < this.fUr) && (this.mMonth > this.fUs) && (this.fUr > this.fUs)))) {
          this.fTZ.setColor(this.fUl);
        }
        if ((this.fUp != -1) && (this.fUq != -1) && (this.fUt != this.fUu) && (((this.fUt < this.fUu) && (((this.mMonth > this.fUr) && (this.mYear == this.fUt)) || ((this.mMonth < this.fUs) && (this.mYear == this.fUu)))) || ((this.fUt > this.fUu) && (((this.mMonth < this.fUr) && (this.mYear == this.fUt)) || ((this.mMonth > this.fUs) && (this.mYear == this.fUu)))))) {
          this.fTZ.setColor(this.fUl);
        }
        if ((!this.fUF.booleanValue()) && (a(k, this.fUD)) && (this.fUD.month == this.mMonth) && (this.fUD.year == this.mYear))
        {
          this.fTZ.setColor(this.fUj);
          this.fTZ.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.fNH.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.fKG == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.fTZ.setColor(this.fUk);
            this.fTZ.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - fTT / 3, fTR, this.fUc);
      }
      if (((this.mMonth == this.fUr) && (this.fUp == k) && (this.fUt == this.mYear)) || ((this.mMonth == this.fUs) && (this.fUq == k) && (this.fUu == this.mYear)) || ((this.fUn) && (this.fUv == k) && (this.fUp == -1)))
      {
        this.fTZ.setTypeface(Typeface.defaultFromStyle(0));
        this.fTZ.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.fTZ);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.fUx)
      {
        i = 0;
        m = j + this.fUB;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.fUm.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.mPadding * 2) / (this.fUx * 2);
    int j = this.mPadding;
    int k = fTX / 2;
    int m = (fTW - fTX) / 2;
    int n = fTX;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.fUb);
    paramCanvas.drawLine(0.0F, fTW, this.mWidth, fTW + 1, this.fUb);
    f(paramCanvas);
    g(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.fUB * this.mNumRows + fTW + this.fUC);
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
      if ((paramMotionEvent != null) && (this.fUH != null) && ((this.fUF.booleanValue()) || (paramMotionEvent.month != this.fUD.month) || (paramMotionEvent.year != this.fUD.year) || (paramMotionEvent.fKG >= this.fUD.monthDay))) {
        this.fUH.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - fTW) / this.fUB;
      i = (int)((f1 - i) * this.fUx / (this.mWidth - i - this.mPadding)) - Zw() + 1 + j * this.fUx;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.h.a.cp(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.fNH.iterator();
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
      this.fNH = paramCollection;
      AppMethodBeat.o(12999);
      return;
    }
    ad.e("MicroMsg.SimpleMonthView", "markDateList is null");
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
      this.fUB = ((Integer)paramHashMap.get("height")).intValue();
      if (this.fUB < fTU) {
        this.fUB = fTU;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.fUp = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.fUq = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.fUr = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.fUs = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.fUt = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.fUu = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.fUn = false;
    this.fUv = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.fUz = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.fUw = ((Integer)paramHashMap.get("week_start")).intValue();
      this.fUy = com.tencent.mm.chatroom.h.a.cp(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.fUy) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.fUD;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.fUn = true;
        this.fUv = m;
      }
      this.fUo = a(m, this.fUD);
      i += 1;
      break label393;
      this.fUw = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = Zw();
    j = (this.fUy + m) / this.fUx;
    int i = k;
    if ((m + this.fUy) % this.fUx > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.fUH = parama;
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