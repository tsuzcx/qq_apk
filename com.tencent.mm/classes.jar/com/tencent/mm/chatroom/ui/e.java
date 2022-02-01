package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  extends View
{
  protected static int DEFAULT_HEIGHT = 32;
  protected static int lOa;
  protected static int lOb = 1;
  protected static int lOc;
  protected static int lOd = 10;
  protected static int lOe;
  protected static int lOf;
  protected static int lOg;
  public int bgI;
  protected int ebX;
  Collection<com.tencent.mm.chatroom.d.a> lBf;
  protected int lOA;
  protected int lOB;
  protected int lOC;
  protected int lOD;
  protected int lOE;
  protected int lOF;
  protected int lOG;
  protected int lOH;
  private int lOI;
  protected Boolean lOJ;
  protected int lOK;
  protected int lOL;
  final Time lOM;
  private final Calendar lON;
  private final Boolean lOO;
  private DateFormatSymbols lOP;
  private a lOQ;
  private final c lOR;
  private int lOS;
  private int lOT;
  private Map<Integer, Pair<com.tencent.mm.chatroom.d.a, Rect>> lOU;
  protected Paint lOh;
  protected Paint lOi;
  protected Paint lOj;
  protected Paint lOk;
  protected Paint lOl;
  protected int lOm;
  protected int lOn;
  protected int lOo;
  protected int lOp;
  protected int lOq;
  protected int lOr;
  protected int lOs;
  protected int lOt;
  protected int lOu;
  private final StringBuilder lOv;
  protected boolean lOw;
  protected boolean lOx;
  protected int lOy;
  protected int lOz;
  private final Calendar mCalendar;
  private Context mContext;
  protected int mMonth;
  protected int mWidth;
  protected int mYear;
  
  public e(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    AppMethodBeat.i(12992);
    this.ebX = 80;
    this.lOw = false;
    this.lOx = false;
    this.lOy = -1;
    this.lOz = -1;
    this.lOA = -1;
    this.lOB = -1;
    this.lOC = -1;
    this.lOD = -1;
    this.lOE = -1;
    this.lOF = 1;
    this.lOG = 7;
    this.lOH = this.lOG;
    this.lOI = 0;
    this.lOK = DEFAULT_HEIGHT;
    this.lOL = 0;
    this.bgI = 6;
    this.lOP = new DateFormatSymbols();
    this.lOR = new c();
    this.lBf = new ArrayList();
    this.lOS = -2147483648;
    this.lOT = -2147483648;
    this.lOU = new HashMap();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.lON = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.lOM = new Time(Time.getCurrentTimezone());
    this.lOM.setToNow();
    this.lOm = paramTypedArray.getColor(a.j.lJC, paramContext.getColor(a.b.lDX));
    this.lOn = paramTypedArray.getColor(a.j.lJF, paramContext.getColor(a.b.lDX));
    this.lOo = paramTypedArray.getColor(a.j.lJD, paramContext.getColor(a.b.lDX));
    this.lOp = paramTypedArray.getColor(a.j.lJD, paramContext.getColor(a.b.lDY));
    this.lOq = paramTypedArray.getColor(a.j.lJG, paramContext.getColor(a.b.lDX));
    this.lOs = paramTypedArray.getColor(a.j.lJH, paramContext.getColor(a.b.lDX));
    this.lOt = paramTypedArray.getColor(a.j.lJE, paramContext.getColor(a.b.lDW));
    this.lOu = paramTypedArray.getColor(a.j.lJI, paramContext.getColor(a.b.lDZ));
    this.lOr = paramTypedArray.getColor(a.j.lJJ, paramContext.getColor(a.b.lEa));
    this.lOJ = Boolean.valueOf(paramTypedArray.getBoolean(a.j.lJL, false));
    this.lOv = new StringBuilder(50);
    lOc = paramTypedArray.getDimensionPixelSize(a.j.lJS, paramContext.getDimensionPixelSize(a.c.lEg));
    lOg = paramTypedArray.getDimensionPixelSize(a.j.lJU, paramContext.getDimensionPixelSize(a.c.lEi));
    lOe = paramTypedArray.getDimensionPixelSize(a.j.lJT, paramContext.getDimensionPixelSize(a.c.lEh));
    lOf = paramTypedArray.getDimensionPixelOffset(a.j.lJO, paramContext.getDimensionPixelOffset(a.c.lEe));
    lOa = paramTypedArray.getDimensionPixelSize(a.j.lJR, paramContext.getDimensionPixelOffset(a.c.lEf));
    this.lOK = ((paramTypedArray.getDimensionPixelSize(a.j.lJA, paramContext.getDimensionPixelOffset(a.c.lEc)) - lOf) / 6);
    this.lOL = paramTypedArray.getDimensionPixelSize(a.j.lJB, paramContext.getDimensionPixelOffset(a.c.lEd));
    this.lOO = Boolean.valueOf(paramTypedArray.getBoolean(a.j.lJM, true));
    this.lOk = new Paint();
    this.lOk.setAntiAlias(true);
    this.lOk.setTextSize(lOg);
    this.lOk.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.lOk.setColor(this.lOp);
    this.lOk.setTextAlign(Paint.Align.LEFT);
    this.lOk.setStyle(Paint.Style.FILL);
    this.lOj = new Paint();
    this.lOj.setFakeBoldText(true);
    this.lOj.setAntiAlias(true);
    this.lOj.setColor(this.lOr);
    this.lOj.setTextAlign(Paint.Align.CENTER);
    this.lOj.setStyle(Paint.Style.FILL);
    this.lOl = new Paint();
    this.lOl.setFakeBoldText(true);
    this.lOl.setAntiAlias(true);
    this.lOl.setColor(this.lOu);
    this.lOl.setTextAlign(Paint.Align.CENTER);
    this.lOl.setStyle(Paint.Style.FILL);
    this.lOh = new Paint();
    this.lOh.setAntiAlias(true);
    this.lOh.setTextSize(lOe);
    this.lOh.setColor(this.lOp);
    this.lOh.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.lOh.setStyle(Paint.Style.FILL);
    this.lOh.setTextAlign(Paint.Align.CENTER);
    this.lOh.setFakeBoldText(true);
    this.lOi = new Paint();
    this.lOi.setAntiAlias(true);
    this.lOi.setTextSize(lOc);
    this.lOi.setStyle(Paint.Style.FILL);
    this.lOi.setTextAlign(Paint.Align.CENTER);
    this.lOi.setFakeBoldText(false);
    setAccessibilityDelegate(new b());
    AppMethodBeat.o(12992);
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private int aNA()
  {
    if (this.lOI < this.lOF) {}
    for (int i = this.lOI + this.lOG;; i = this.lOI) {
      return i - this.lOF;
    }
  }
  
  private boolean cY(int paramInt)
  {
    return paramInt == this.lOS;
  }
  
  private void e(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(241651);
    if ((this.lOQ != null) && ((this.lOO.booleanValue()) || (parama.month != this.lOM.month) || (parama.year != this.lOM.year) || (parama.day >= this.lOM.monthDay))) {
      this.lOQ.b(parama);
    }
    AppMethodBeat.o(241651);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.lOv.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  private void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = lOf;
    int k = lOe / 2;
    int m = (this.mWidth - this.ebX * 2) / (this.lOG * 2);
    int i = 0;
    while (i < this.lOG)
    {
      int n = this.lOF;
      int i1 = this.lOG;
      int i2 = this.ebX;
      this.lON.set(7, (n + i) % i1);
      paramCanvas.drawText(this.lOP.getShortWeekdays()[this.lON.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.lOh);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void k(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.lOK + lOc) / 2 - lOb + lOf;
    int i1 = (this.mWidth - this.ebX * 2) / (this.lOG * 2);
    int i = aNA();
    int k = 1;
    while ((k <= this.lOH) && ((k <= this.lOE) || (-1 == this.lOE)))
    {
      int m = this.ebX + (i * 2 + 1) * i1;
      if (((this.mMonth == this.lOA) && (this.lOy == k) && (this.lOC == this.mYear)) || ((this.mMonth == this.lOB) && (this.lOz == k) && (this.lOD == this.mYear)) || ((this.lOw) && (this.lOE == k) && (this.lOy == -1)))
      {
        if (!this.lOJ.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - lOa, j - lOc / 3 - lOa, lOa + m, j - lOc / 3 + lOa), 10.0F, 10.0F, this.lOl);
      }
      for (;;)
      {
        if ((this.lOw) && (this.lOE == k) && (this.lOy == -1))
        {
          this.lOi.setColor(this.lOu);
          this.lOi.setTypeface(Typeface.defaultFromStyle(0));
          this.lOi.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(a.i.lJu), m, j + 12 + lOa, this.lOi);
        }
        this.lOi.setTextSize(lOc);
        if ((!this.lOw) || (this.lOE != k))
        {
          this.lOi.setColor(this.lOq);
          this.lOi.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.lOy != -1) && (this.lOz != -1) && (this.lOC == this.lOD) && (this.lOA == this.lOB) && (this.lOy == this.lOz) && (k == this.lOy) && (this.mMonth == this.lOA) && (this.mYear == this.lOC)) {
          this.lOi.setColor(this.lOu);
        }
        if ((this.lOy != -1) && (this.lOz != -1) && (this.lOC == this.lOD) && (this.lOC == this.mYear) && (((this.mMonth == this.lOA) && (this.lOB == this.lOA) && (((this.lOy < this.lOz) && (k > this.lOy) && (k < this.lOz)) || ((this.lOy > this.lOz) && (k < this.lOy) && (k > this.lOz)))) || ((this.lOA < this.lOB) && (this.mMonth == this.lOA) && (k > this.lOy)) || ((this.lOA < this.lOB) && (this.mMonth == this.lOB) && (k < this.lOz)) || ((this.lOA > this.lOB) && (this.mMonth == this.lOA) && (k < this.lOy)) || ((this.lOA > this.lOB) && (this.mMonth == this.lOB) && (k > this.lOz)))) {
          this.lOi.setColor(this.lOu);
        }
        if ((this.lOy != -1) && (this.lOz != -1) && (this.lOC != this.lOD) && (((this.lOC == this.mYear) && (this.mMonth == this.lOA)) || ((this.lOD == this.mYear) && (this.mMonth == this.lOB) && (((this.lOA < this.lOB) && (this.mMonth == this.lOA) && (k < this.lOy)) || ((this.lOA < this.lOB) && (this.mMonth == this.lOB) && (k > this.lOz)) || ((this.lOA > this.lOB) && (this.mMonth == this.lOA) && (k > this.lOy)) || ((this.lOA > this.lOB) && (this.mMonth == this.lOB) && (k < this.lOz)))))) {
          this.lOi.setColor(this.lOu);
        }
        if ((this.lOy != -1) && (this.lOz != -1) && (this.lOC == this.lOD) && (this.mYear == this.lOC) && (((this.mMonth > this.lOA) && (this.mMonth < this.lOB) && (this.lOA < this.lOB)) || ((this.mMonth < this.lOA) && (this.mMonth > this.lOB) && (this.lOA > this.lOB)))) {
          this.lOi.setColor(this.lOu);
        }
        if ((this.lOy != -1) && (this.lOz != -1) && (this.lOC != this.lOD) && (((this.lOC < this.lOD) && (((this.mMonth > this.lOA) && (this.mYear == this.lOC)) || ((this.mMonth < this.lOB) && (this.mYear == this.lOD)))) || ((this.lOC > this.lOD) && (((this.mMonth < this.lOA) && (this.mYear == this.lOC)) || ((this.mMonth > this.lOB) && (this.mYear == this.lOD)))))) {
          this.lOi.setColor(this.lOu);
        }
        if ((!this.lOO.booleanValue()) && (a(k, this.lOM)) && (this.lOM.month == this.mMonth) && (this.lOM.year == this.mYear))
        {
          this.lOi.setColor(this.lOs);
          this.lOi.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.lBf.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.day == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.lOi.setColor(this.lOt);
            this.lOi.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - lOc / 3, lOa, this.lOl);
      }
      if (((this.mMonth == this.lOA) && (this.lOy == k) && (this.lOC == this.mYear)) || ((this.mMonth == this.lOB) && (this.lOz == k) && (this.lOD == this.mYear)) || ((this.lOw) && (this.lOE == k) && (this.lOy == -1)))
      {
        this.lOi.setTypeface(Typeface.defaultFromStyle(0));
        this.lOi.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.lOi);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.lOG)
      {
        i = 0;
        m = j + this.lOK;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241666);
    if (paramInt1 == -2147483648)
    {
      AppMethodBeat.o(241666);
      return false;
    }
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName("android.view.View");
    localAccessibilityEvent.setPackageName(getContext().getPackageName());
    localAccessibilityEvent.setSource(this, paramInt1);
    boolean bool = getParent().requestSendAccessibilityEvent(this, localAccessibilityEvent);
    AppMethodBeat.o(241666);
    return bool;
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    AppMethodBeat.i(241673);
    if (this.lOT == paramInt)
    {
      AppMethodBeat.o(241673);
      return;
    }
    int i = this.lOT;
    this.lOT = paramInt;
    if (paramInt != -2147483648) {
      sendEventForVirtualView(paramInt, 128);
    }
    sendEventForVirtualView(i, 256);
    AppMethodBeat.o(241673);
  }
  
  protected final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241718);
    if (AccUtil.INSTANCE.isAccessibilityEnabled()) {}
    switch (paramMotionEvent.getAction())
    {
    case 8: 
    default: 
      boolean bool = super.dispatchHoverEvent(paramMotionEvent);
      AppMethodBeat.o(241718);
      return bool;
    case 7: 
    case 9: 
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      paramMotionEvent = this.lOU.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!paramMotionEvent.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramMotionEvent.next();
      } while (!((Rect)((Pair)localEntry.getValue()).second).contains((int)f1, (int)f2));
      for (int i = ((Integer)localEntry.getKey()).intValue();; i = -2147483648)
      {
        updateHoveredVirtualView(i);
        AppMethodBeat.o(241718);
        return true;
      }
    }
    if (this.lOT != -2147483648) {
      updateHoveredVirtualView(-2147483648);
    }
    AppMethodBeat.o(241718);
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.ebX * 2) / (this.lOG * 2);
    int j = this.ebX;
    int k = lOg / 2;
    int m = (lOf - lOg) / 2;
    int n = lOg;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.lOk);
    paramCanvas.drawLine(0.0F, lOf, this.mWidth, lOf + 1, this.lOk);
    j(paramCanvas);
    k(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.lOK * this.bgI + lOf + this.lOL);
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
      i = this.ebX;
      if ((f1 >= i) && (f1 <= this.mWidth - this.ebX) && (f2 >= lOf)) {
        break label81;
      }
      paramMotionEvent = null;
    }
    for (;;)
    {
      if (paramMotionEvent != null) {
        e(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label81:
      int j = (int)(f2 - lOf) / this.lOK;
      i = (int)((f1 - i) * this.lOG / (this.mWidth - i - this.ebX)) - aNA() + 1 + j * this.lOG;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.h.a.dz(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.lBf.iterator();
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
  
  public final void setMarkDate(final Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12999);
    if (paramCollection != null)
    {
      this.lBf = paramCollection;
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241693);
          e.b(e.this);
          e.a(e.this, new ArrayList(paramCollection));
          e.this.invalidate();
          AppMethodBeat.o(241693);
        }
      });
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
      this.lOK = ((Integer)paramHashMap.get("height")).intValue();
      if (this.lOK < lOd) {
        this.lOK = lOd;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.lOy = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.lOz = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.lOA = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.lOB = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.lOC = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.lOD = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.lOw = false;
    this.lOE = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.lOI = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.lOF = ((Integer)paramHashMap.get("week_start")).intValue();
      this.lOH = com.tencent.mm.chatroom.h.a.dz(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.lOH) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.lOM;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.lOw = true;
        this.lOE = m;
      }
      this.lOx = a(m, this.lOM);
      i += 1;
      break label393;
      this.lOF = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = aNA();
    j = (this.lOH + m) / this.lOG;
    int i = k;
    if ((m + this.lOH) % this.lOG > 0) {
      i = 1;
    }
    this.bgI = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.lOQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.chatroom.d.a parama);
  }
  
  final class b
    extends View.AccessibilityDelegate
  {
    b() {}
    
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      AppMethodBeat.i(241755);
      paramView = e.a(e.this);
      AppMethodBeat.o(241755);
      return paramView;
    }
  }
  
  public final class c
    extends AccessibilityNodeProvider
  {
    public c() {}
    
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      AppMethodBeat.i(241759);
      if (!e.aNB())
      {
        AppMethodBeat.o(241759);
        return null;
      }
      AccessibilityNodeInfo localAccessibilityNodeInfo = e.a(e.this, paramInt);
      AppMethodBeat.o(241759);
      return localAccessibilityNodeInfo;
    }
    
    public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(241762);
      if (!e.aNB())
      {
        AppMethodBeat.o(241762);
        return false;
      }
      boolean bool = e.a(e.this, paramInt1, paramInt2);
      AppMethodBeat.o(241762);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.e
 * JD-Core Version:    0.7.0.1
 */