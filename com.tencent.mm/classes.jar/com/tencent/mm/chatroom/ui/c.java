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
  protected static int gBc = 32;
  protected static int gBd;
  protected static int gBe = 1;
  protected static int gBf;
  protected static int gBg = 10;
  protected static int gBh;
  protected static int gBi;
  protected static int gBj;
  protected boolean gBA;
  protected int gBB;
  protected int gBC;
  protected int gBD;
  protected int gBE;
  protected int gBF;
  protected int gBG;
  protected int gBH;
  protected int gBI;
  protected int gBJ;
  protected int gBK;
  private int gBL;
  protected Boolean gBM;
  protected int gBN;
  protected int gBO;
  final Time gBP;
  private final Calendar gBQ;
  private final Boolean gBR;
  private DateFormatSymbols gBS;
  private a gBT;
  protected Paint gBk;
  protected Paint gBl;
  protected Paint gBm;
  protected Paint gBn;
  protected Paint gBo;
  protected int gBp;
  protected int gBq;
  protected int gBr;
  protected int gBs;
  protected int gBt;
  protected int gBu;
  protected int gBv;
  protected int gBw;
  protected int gBx;
  private final StringBuilder gBy;
  protected boolean gBz;
  Collection<com.tencent.mm.chatroom.d.a> guY;
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
    this.gBz = false;
    this.gBA = false;
    this.gBB = -1;
    this.gBC = -1;
    this.gBD = -1;
    this.gBE = -1;
    this.gBF = -1;
    this.gBG = -1;
    this.gBH = -1;
    this.gBI = 1;
    this.gBJ = 7;
    this.gBK = this.gBJ;
    this.gBL = 0;
    this.gBN = gBc;
    this.gBO = 0;
    this.mNumRows = 6;
    this.gBS = new DateFormatSymbols();
    this.guY = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.gBQ = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.gBP = new Time(Time.getCurrentTimezone());
    this.gBP.setToNow();
    this.gBp = paramTypedArray.getColor(2, paramContext.getColor(2131100901));
    this.gBq = paramTypedArray.getColor(5, paramContext.getColor(2131100901));
    this.gBr = paramTypedArray.getColor(3, paramContext.getColor(2131100901));
    this.gBs = paramTypedArray.getColor(3, paramContext.getColor(2131100902));
    this.gBt = paramTypedArray.getColor(6, paramContext.getColor(2131100901));
    this.gBv = paramTypedArray.getColor(7, paramContext.getColor(2131100901));
    this.gBw = paramTypedArray.getColor(4, paramContext.getColor(2131100786));
    this.gBx = paramTypedArray.getColor(8, paramContext.getColor(2131101046));
    this.gBu = paramTypedArray.getColor(9, paramContext.getColor(2131101047));
    this.gBM = Boolean.valueOf(paramTypedArray.getBoolean(11, false));
    this.gBy = new StringBuilder(50);
    gBf = paramTypedArray.getDimensionPixelSize(18, paramContext.getDimensionPixelSize(2131167044));
    gBj = paramTypedArray.getDimensionPixelSize(20, paramContext.getDimensionPixelSize(2131167046));
    gBh = paramTypedArray.getDimensionPixelSize(19, paramContext.getDimensionPixelSize(2131167045));
    gBi = paramTypedArray.getDimensionPixelOffset(14, paramContext.getDimensionPixelOffset(2131166507));
    gBd = paramTypedArray.getDimensionPixelSize(17, paramContext.getDimensionPixelOffset(2131166903));
    this.gBN = ((paramTypedArray.getDimensionPixelSize(0, paramContext.getDimensionPixelOffset(2131165980)) - gBi) / 6);
    this.gBO = paramTypedArray.getDimensionPixelSize(1, paramContext.getDimensionPixelOffset(2131166037));
    this.gBR = Boolean.valueOf(paramTypedArray.getBoolean(12, true));
    this.gBn = new Paint();
    this.gBn.setAntiAlias(true);
    this.gBn.setTextSize(gBj);
    this.gBn.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.gBn.setColor(this.gBs);
    this.gBn.setTextAlign(Paint.Align.LEFT);
    this.gBn.setStyle(Paint.Style.FILL);
    this.gBm = new Paint();
    this.gBm.setFakeBoldText(true);
    this.gBm.setAntiAlias(true);
    this.gBm.setColor(this.gBu);
    this.gBm.setTextAlign(Paint.Align.CENTER);
    this.gBm.setStyle(Paint.Style.FILL);
    this.gBo = new Paint();
    this.gBo.setFakeBoldText(true);
    this.gBo.setAntiAlias(true);
    this.gBo.setColor(this.gBx);
    this.gBo.setTextAlign(Paint.Align.CENTER);
    this.gBo.setStyle(Paint.Style.FILL);
    this.gBk = new Paint();
    this.gBk.setAntiAlias(true);
    this.gBk.setTextSize(gBh);
    this.gBk.setColor(this.gBs);
    this.gBk.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.gBk.setStyle(Paint.Style.FILL);
    this.gBk.setTextAlign(Paint.Align.CENTER);
    this.gBk.setFakeBoldText(true);
    this.gBl = new Paint();
    this.gBl.setAntiAlias(true);
    this.gBl.setTextSize(gBf);
    this.gBl.setStyle(Paint.Style.FILL);
    this.gBl.setTextAlign(Paint.Align.CENTER);
    this.gBl.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private int ans()
  {
    if (this.gBL < this.gBI) {}
    for (int i = this.gBL + this.gBJ;; i = this.gBL) {
      return i - this.gBI;
    }
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = gBi;
    int k = gBh / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.gBJ * 2);
    int i = 0;
    while (i < this.gBJ)
    {
      int n = this.gBI;
      int i1 = this.gBJ;
      int i2 = this.mPadding;
      this.gBQ.set(7, (n + i) % i1);
      paramCanvas.drawText(this.gBS.getShortWeekdays()[this.gBQ.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.gBk);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.gBN + gBf) / 2 - gBe + gBi;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.gBJ * 2);
    int i = ans();
    int k = 1;
    while ((k <= this.gBK) && ((k <= this.gBH) || (-1 == this.gBH)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.gBD) && (this.gBB == k) && (this.gBF == this.mYear)) || ((this.mMonth == this.gBE) && (this.gBC == k) && (this.gBG == this.mYear)) || ((this.gBz) && (this.gBH == k) && (this.gBB == -1)))
      {
        if (!this.gBM.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - gBd, j - gBf / 3 - gBd, gBd + m, j - gBf / 3 + gBd), 10.0F, 10.0F, this.gBo);
      }
      for (;;)
      {
        if ((this.gBz) && (this.gBH == k) && (this.gBB == -1))
        {
          this.gBl.setColor(this.gBx);
          this.gBl.setTypeface(Typeface.defaultFromStyle(0));
          this.gBl.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131766792), m, j + 12 + gBd, this.gBl);
        }
        this.gBl.setTextSize(gBf);
        if ((!this.gBz) || (this.gBH != k))
        {
          this.gBl.setColor(this.gBt);
          this.gBl.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.gBB != -1) && (this.gBC != -1) && (this.gBF == this.gBG) && (this.gBD == this.gBE) && (this.gBB == this.gBC) && (k == this.gBB) && (this.mMonth == this.gBD) && (this.mYear == this.gBF)) {
          this.gBl.setColor(this.gBx);
        }
        if ((this.gBB != -1) && (this.gBC != -1) && (this.gBF == this.gBG) && (this.gBF == this.mYear) && (((this.mMonth == this.gBD) && (this.gBE == this.gBD) && (((this.gBB < this.gBC) && (k > this.gBB) && (k < this.gBC)) || ((this.gBB > this.gBC) && (k < this.gBB) && (k > this.gBC)))) || ((this.gBD < this.gBE) && (this.mMonth == this.gBD) && (k > this.gBB)) || ((this.gBD < this.gBE) && (this.mMonth == this.gBE) && (k < this.gBC)) || ((this.gBD > this.gBE) && (this.mMonth == this.gBD) && (k < this.gBB)) || ((this.gBD > this.gBE) && (this.mMonth == this.gBE) && (k > this.gBC)))) {
          this.gBl.setColor(this.gBx);
        }
        if ((this.gBB != -1) && (this.gBC != -1) && (this.gBF != this.gBG) && (((this.gBF == this.mYear) && (this.mMonth == this.gBD)) || ((this.gBG == this.mYear) && (this.mMonth == this.gBE) && (((this.gBD < this.gBE) && (this.mMonth == this.gBD) && (k < this.gBB)) || ((this.gBD < this.gBE) && (this.mMonth == this.gBE) && (k > this.gBC)) || ((this.gBD > this.gBE) && (this.mMonth == this.gBD) && (k > this.gBB)) || ((this.gBD > this.gBE) && (this.mMonth == this.gBE) && (k < this.gBC)))))) {
          this.gBl.setColor(this.gBx);
        }
        if ((this.gBB != -1) && (this.gBC != -1) && (this.gBF == this.gBG) && (this.mYear == this.gBF) && (((this.mMonth > this.gBD) && (this.mMonth < this.gBE) && (this.gBD < this.gBE)) || ((this.mMonth < this.gBD) && (this.mMonth > this.gBE) && (this.gBD > this.gBE)))) {
          this.gBl.setColor(this.gBx);
        }
        if ((this.gBB != -1) && (this.gBC != -1) && (this.gBF != this.gBG) && (((this.gBF < this.gBG) && (((this.mMonth > this.gBD) && (this.mYear == this.gBF)) || ((this.mMonth < this.gBE) && (this.mYear == this.gBG)))) || ((this.gBF > this.gBG) && (((this.mMonth < this.gBD) && (this.mYear == this.gBF)) || ((this.mMonth > this.gBE) && (this.mYear == this.gBG)))))) {
          this.gBl.setColor(this.gBx);
        }
        if ((!this.gBR.booleanValue()) && (a(k, this.gBP)) && (this.gBP.month == this.mMonth) && (this.gBP.year == this.mYear))
        {
          this.gBl.setColor(this.gBv);
          this.gBl.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.guY.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.grV == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.gBl.setColor(this.gBw);
            this.gBl.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - gBf / 3, gBd, this.gBo);
      }
      if (((this.mMonth == this.gBD) && (this.gBB == k) && (this.gBF == this.mYear)) || ((this.mMonth == this.gBE) && (this.gBC == k) && (this.gBG == this.mYear)) || ((this.gBz) && (this.gBH == k) && (this.gBB == -1)))
      {
        this.gBl.setTypeface(Typeface.defaultFromStyle(0));
        this.gBl.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.gBl);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.gBJ)
      {
        i = 0;
        m = j + this.gBN;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.gBy.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.mPadding * 2) / (this.gBJ * 2);
    int j = this.mPadding;
    int k = gBj / 2;
    int m = (gBi - gBj) / 2;
    int n = gBj;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.gBn);
    paramCanvas.drawLine(0.0F, gBi, this.mWidth, gBi + 1, this.gBn);
    f(paramCanvas);
    g(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.gBN * this.mNumRows + gBi + this.gBO);
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
      if ((paramMotionEvent != null) && (this.gBT != null) && ((this.gBR.booleanValue()) || (paramMotionEvent.month != this.gBP.month) || (paramMotionEvent.year != this.gBP.year) || (paramMotionEvent.grV >= this.gBP.monthDay))) {
        this.gBT.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - gBi) / this.gBN;
      i = (int)((f1 - i) * this.gBJ / (this.mWidth - i - this.mPadding)) - ans() + 1 + j * this.gBJ;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.h.a.cr(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.guY.iterator();
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
      this.guY = paramCollection;
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
      this.gBN = ((Integer)paramHashMap.get("height")).intValue();
      if (this.gBN < gBg) {
        this.gBN = gBg;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.gBB = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.gBC = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.gBD = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.gBE = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.gBF = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.gBG = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.gBz = false;
    this.gBH = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.gBL = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.gBI = ((Integer)paramHashMap.get("week_start")).intValue();
      this.gBK = com.tencent.mm.chatroom.h.a.cr(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.gBK) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.gBP;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.gBz = true;
        this.gBH = m;
      }
      this.gBA = a(m, this.gBP);
      i += 1;
      break label393;
      this.gBI = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = ans();
    j = (this.gBK + m) / this.gBJ;
    int i = k;
    if ((m + this.gBK) % this.gBJ > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.gBT = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.chatroom.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */