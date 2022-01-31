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
import com.tencent.mm.sdk.platformtools.y;
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
  protected static int dsA = 32;
  protected static int dsB;
  protected static int dsC = 1;
  protected static int dsD;
  protected static int dsE = 10;
  protected static int dsF;
  protected static int dsG;
  protected static int dsH;
  Collection<com.tencent.mm.chatroom.c.a> doH = new ArrayList();
  protected int dsI = 80;
  protected Paint dsJ;
  protected Paint dsK;
  protected Paint dsL;
  protected Paint dsM;
  protected Paint dsN;
  protected int dsO;
  protected int dsP;
  protected int dsQ;
  protected int dsR;
  protected int dsS;
  protected int dsT;
  protected int dsU;
  protected int dsV;
  protected int dsW;
  private final StringBuilder dsX;
  protected boolean dsY = false;
  protected boolean dsZ = false;
  protected int dta = -1;
  protected int dtb = -1;
  protected int dtc = -1;
  protected int dtd = -1;
  protected int dte = -1;
  protected int dtf = -1;
  protected int dtg = -1;
  protected int dth = 1;
  protected int dti = 7;
  protected int dtj = this.dti;
  private int dtk = 0;
  protected int dtl;
  protected Boolean dtm;
  protected int dtn = dsA;
  protected int dto = 0;
  protected int dtp;
  final Time dtq;
  private final Calendar dtr;
  private final Calendar dts;
  private final Boolean dtt;
  public int dtu = 6;
  private DateFormatSymbols dtv = new DateFormatSymbols();
  private c.a dtw;
  private Context mContext;
  protected int mWidth;
  
  public c(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.dts = Calendar.getInstance();
    this.dtr = Calendar.getInstance();
    this.dtq = new Time(Time.getCurrentTimezone());
    this.dtq.setToNow();
    this.dsO = paramTypedArray.getColor(a.j.DayPickerView_colorCurrentDay, paramContext.getColor(a.b.normal_day));
    this.dsP = paramTypedArray.getColor(a.j.DayPickerView_colorMonthName, paramContext.getColor(a.b.normal_day));
    this.dsQ = paramTypedArray.getColor(a.j.DayPickerView_colorDayName, paramContext.getColor(a.b.normal_day));
    this.dsR = paramTypedArray.getColor(a.j.DayPickerView_colorDayName, paramContext.getColor(a.b.normal_label));
    this.dsS = paramTypedArray.getColor(a.j.DayPickerView_colorNormalDay, paramContext.getColor(a.b.normal_day));
    this.dsU = paramTypedArray.getColor(a.j.DayPickerView_colorPreviousDay, paramContext.getColor(a.b.normal_day));
    this.dsV = paramTypedArray.getColor(a.j.DayPickerView_colorMarkDay, paramContext.getColor(a.b.marked_day_text));
    this.dsW = paramTypedArray.getColor(a.j.DayPickerView_colorSelectedDayBackground, paramContext.getColor(a.b.selected_day_background));
    this.dsT = paramTypedArray.getColor(a.j.DayPickerView_colorSelectedDayText, paramContext.getColor(a.b.selected_day_text));
    this.dtm = Boolean.valueOf(paramTypedArray.getBoolean(a.j.DayPickerView_drawRoundRect, false));
    this.dsX = new StringBuilder(50);
    dsD = paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_textSizeDay, paramContext.getDimensionPixelSize(a.c.text_size_day));
    dsH = paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_textSizeMonth, paramContext.getDimensionPixelSize(a.c.text_size_month));
    dsF = paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_textSizeDayName, paramContext.getDimensionPixelSize(a.c.text_size_day_name));
    dsG = paramTypedArray.getDimensionPixelOffset(a.j.DayPickerView_headerMonthHeight, paramContext.getDimensionPixelOffset(a.c.header_month_height));
    dsB = paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_selectedDayRadius, paramContext.getDimensionPixelOffset(a.c.selected_day_radius));
    this.dtn = ((paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_calendarHeight, paramContext.getDimensionPixelOffset(a.c.calendar_height)) - dsG) / 6);
    this.dto = paramTypedArray.getDimensionPixelSize(a.j.DayPickerView_catteryPadding, paramContext.getDimensionPixelOffset(a.c.cattery_padding));
    this.dtt = Boolean.valueOf(paramTypedArray.getBoolean(a.j.DayPickerView_enablePreviousDay, true));
    this.dsM = new Paint();
    this.dsM.setAntiAlias(true);
    this.dsM.setTextSize(dsH);
    this.dsM.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.dsM.setColor(this.dsR);
    this.dsM.setTextAlign(Paint.Align.LEFT);
    this.dsM.setStyle(Paint.Style.FILL);
    this.dsL = new Paint();
    this.dsL.setFakeBoldText(true);
    this.dsL.setAntiAlias(true);
    this.dsL.setColor(this.dsT);
    this.dsL.setTextAlign(Paint.Align.CENTER);
    this.dsL.setStyle(Paint.Style.FILL);
    this.dsN = new Paint();
    this.dsN.setFakeBoldText(true);
    this.dsN.setAntiAlias(true);
    this.dsN.setColor(this.dsW);
    this.dsN.setTextAlign(Paint.Align.CENTER);
    this.dsN.setStyle(Paint.Style.FILL);
    this.dsJ = new Paint();
    this.dsJ.setAntiAlias(true);
    this.dsJ.setTextSize(dsF);
    this.dsJ.setColor(this.dsR);
    this.dsJ.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.dsJ.setStyle(Paint.Style.FILL);
    this.dsJ.setTextAlign(Paint.Align.CENTER);
    this.dsJ.setFakeBoldText(true);
    this.dsK = new Paint();
    this.dsK.setAntiAlias(true);
    this.dsK.setTextSize(dsD);
    this.dsK.setStyle(Paint.Style.FILL);
    this.dsK.setTextAlign(Paint.Align.CENTER);
    this.dsK.setFakeBoldText(false);
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.dtp < paramTime.year) || ((this.dtp == paramTime.year) && (this.dtl < paramTime.month)) || ((this.dtl == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void d(Canvas paramCanvas)
  {
    int j = dsG;
    int k = dsF / 2;
    int m = (this.mWidth - this.dsI * 2) / (this.dti * 2);
    int i = 0;
    while (i < this.dti)
    {
      int n = this.dth;
      int i1 = this.dti;
      int i2 = this.dsI;
      this.dts.set(7, (n + i) % i1);
      paramCanvas.drawText(this.dtv.getShortWeekdays()[this.dts.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.dsJ);
      i += 1;
    }
  }
  
  private void e(Canvas paramCanvas)
  {
    int j = (this.dtn + dsD) / 2 - dsC + dsG;
    int i1 = (this.mWidth - this.dsI * 2) / (this.dti * 2);
    int i = ye();
    int k = 1;
    while ((k <= this.dtj) && ((k <= this.dtg) || (-1 == this.dtg)))
    {
      int m = this.dsI + (i * 2 + 1) * i1;
      if (((this.dtl == this.dtc) && (this.dta == k) && (this.dte == this.dtp)) || ((this.dtl == this.dtd) && (this.dtb == k) && (this.dtf == this.dtp)) || ((this.dsY) && (this.dtg == k) && (this.dta == -1)))
      {
        if (!this.dtm.booleanValue()) {
          break label1363;
        }
        paramCanvas.drawRoundRect(new RectF(m - dsB, j - dsD / 3 - dsB, dsB + m, j - dsD / 3 + dsB), 10.0F, 10.0F, this.dsN);
      }
      for (;;)
      {
        if ((this.dsY) && (this.dtg == k) && (this.dta == -1))
        {
          this.dsK.setColor(this.dsW);
          this.dsK.setTypeface(Typeface.defaultFromStyle(0));
          this.dsK.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(a.i.today_tip), m, j + 12 + dsB, this.dsK);
        }
        this.dsK.setTextSize(dsD);
        if ((!this.dsY) || (this.dtg != k))
        {
          this.dsK.setColor(this.dsS);
          this.dsK.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.dta != -1) && (this.dtb != -1) && (this.dte == this.dtf) && (this.dtc == this.dtd) && (this.dta == this.dtb) && (k == this.dta) && (this.dtl == this.dtc) && (this.dtp == this.dte)) {
          this.dsK.setColor(this.dsW);
        }
        if ((this.dta != -1) && (this.dtb != -1) && (this.dte == this.dtf) && (this.dte == this.dtp) && (((this.dtl == this.dtc) && (this.dtd == this.dtc) && (((this.dta < this.dtb) && (k > this.dta) && (k < this.dtb)) || ((this.dta > this.dtb) && (k < this.dta) && (k > this.dtb)))) || ((this.dtc < this.dtd) && (this.dtl == this.dtc) && (k > this.dta)) || ((this.dtc < this.dtd) && (this.dtl == this.dtd) && (k < this.dtb)) || ((this.dtc > this.dtd) && (this.dtl == this.dtc) && (k < this.dta)) || ((this.dtc > this.dtd) && (this.dtl == this.dtd) && (k > this.dtb)))) {
          this.dsK.setColor(this.dsW);
        }
        if ((this.dta != -1) && (this.dtb != -1) && (this.dte != this.dtf) && (((this.dte == this.dtp) && (this.dtl == this.dtc)) || ((this.dtf == this.dtp) && (this.dtl == this.dtd) && (((this.dtc < this.dtd) && (this.dtl == this.dtc) && (k < this.dta)) || ((this.dtc < this.dtd) && (this.dtl == this.dtd) && (k > this.dtb)) || ((this.dtc > this.dtd) && (this.dtl == this.dtc) && (k > this.dta)) || ((this.dtc > this.dtd) && (this.dtl == this.dtd) && (k < this.dtb)))))) {
          this.dsK.setColor(this.dsW);
        }
        if ((this.dta != -1) && (this.dtb != -1) && (this.dte == this.dtf) && (this.dtp == this.dte) && (((this.dtl > this.dtc) && (this.dtl < this.dtd) && (this.dtc < this.dtd)) || ((this.dtl < this.dtc) && (this.dtl > this.dtd) && (this.dtc > this.dtd)))) {
          this.dsK.setColor(this.dsW);
        }
        if ((this.dta != -1) && (this.dtb != -1) && (this.dte != this.dtf) && (((this.dte < this.dtf) && (((this.dtl > this.dtc) && (this.dtp == this.dte)) || ((this.dtl < this.dtd) && (this.dtp == this.dtf)))) || ((this.dte > this.dtf) && (((this.dtl < this.dtc) && (this.dtp == this.dte)) || ((this.dtl > this.dtd) && (this.dtp == this.dtf)))))) {
          this.dsK.setColor(this.dsW);
        }
        if ((!this.dtt.booleanValue()) && (a(k, this.dtq)) && (this.dtq.month == this.dtl) && (this.dtq.year == this.dtp))
        {
          this.dsK.setColor(this.dsU);
          this.dsK.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.doH.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.c.a locala = (com.tencent.mm.chatroom.c.a)localIterator.next();
          if ((locala.day == k) && (locala.month == this.dtl) && (locala.year == this.dtp))
          {
            this.dsK.setColor(this.dsV);
            this.dsK.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1363:
        paramCanvas.drawCircle(m, j - dsD / 3, dsB, this.dsN);
      }
      if (((this.dtl == this.dtc) && (this.dta == k) && (this.dte == this.dtp)) || ((this.dtl == this.dtd) && (this.dtb == k) && (this.dtf == this.dtp)) || ((this.dsY) && (this.dtg == k) && (this.dta == -1)))
      {
        this.dsK.setTypeface(Typeface.defaultFromStyle(0));
        this.dsK.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.dsK);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.dti)
      {
        i = 0;
        m = j + this.dtn;
      }
      k += 1;
      j = m;
    }
  }
  
  private String getMonthAndYearString()
  {
    this.dsX.setLength(0);
    long l = this.dtr.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), l, l, 52);
  }
  
  private int ye()
  {
    if (this.dtk < this.dth) {}
    for (int i = this.dtk + this.dti;; i = this.dtk) {
      return i - this.dth;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    int i = (this.mWidth - this.dsI * 2) / (this.dti * 2);
    int j = this.dsI;
    int k = dsH / 2;
    int m = (dsG - dsH) / 2;
    int n = dsH;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.dsM);
    paramCanvas.drawLine(0.0F, dsG, this.mWidth, dsG + 1, this.dsM);
    d(paramCanvas);
    e(paramCanvas);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.dtn * this.dtu + dsG + this.dto);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    float f2;
    int i;
    if (paramMotionEvent.getAction() == 1)
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = this.dsI;
      if ((f1 >= i) && (f1 <= this.mWidth - this.dsI)) {
        break label124;
      }
      paramMotionEvent = null;
    }
    for (;;)
    {
      if ((paramMotionEvent != null) && (this.dtw != null) && ((this.dtt.booleanValue()) || (paramMotionEvent.month != this.dtq.month) || (paramMotionEvent.year != this.dtq.year) || (paramMotionEvent.day >= this.dtq.monthDay))) {
        this.dtw.b(paramMotionEvent);
      }
      return true;
      label124:
      int j = (int)(f2 - dsG) / this.dtn;
      i = (int)((f1 - i) * this.dti / (this.mWidth - i - this.dsI)) - ye() + 1 + j * this.dti;
      if ((this.dtl > 11) || (this.dtl < 0) || (com.tencent.mm.chatroom.f.a.aW(this.dtl, this.dtp) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.c.a locala = new com.tencent.mm.chatroom.c.a(this.dtp, this.dtl, i);
        Iterator localIterator = this.doH.iterator();
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
    if (paramCollection != null)
    {
      this.doH = paramCollection;
      return;
    }
    y.e("MicroMsg.SimpleMonthView", "markDateList is null");
  }
  
  public final void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    int k = 0;
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.dtn = ((Integer)paramHashMap.get("height")).intValue();
      if (this.dtn < dsE) {
        this.dtn = dsE;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.dta = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.dtb = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.dtc = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.dtd = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.dte = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.dtf = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.dtl = ((Integer)paramHashMap.get("month")).intValue();
    this.dtp = ((Integer)paramHashMap.get("year")).intValue();
    this.dsY = false;
    this.dtg = -1;
    this.dtr.set(2, this.dtl);
    this.dtr.set(1, this.dtp);
    this.dtr.set(5, 1);
    this.dtk = this.dtr.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.dth = ((Integer)paramHashMap.get("week_start")).intValue();
      this.dtj = com.tencent.mm.chatroom.f.a.aW(this.dtl, this.dtp);
      i = 0;
      label379:
      if (i >= this.dtj) {
        break label485;
      }
      m = i + 1;
      paramHashMap = this.dtq;
      if ((this.dtp != paramHashMap.year) || (this.dtl != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label480;
      }
    }
    label480:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.dsY = true;
        this.dtg = m;
      }
      this.dsZ = a(m, this.dtq);
      i += 1;
      break label379;
      this.dth = this.dtr.getFirstDayOfWeek();
      break;
    }
    label485:
    int m = ye();
    j = (this.dtj + m) / this.dti;
    int i = k;
    if ((m + this.dtj) % this.dti > 0) {
      i = 1;
    }
    this.dtu = (j + i);
  }
  
  public final void setOnDayClickListener(c.a parama)
  {
    this.dtw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */