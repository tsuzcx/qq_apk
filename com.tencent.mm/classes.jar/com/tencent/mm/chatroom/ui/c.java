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
  protected static int fwT = 32;
  protected static int fwU;
  protected static int fwV = 1;
  protected static int fwW;
  protected static int fwX = 10;
  protected static int fwY;
  protected static int fwZ;
  protected static int fxa;
  Collection<com.tencent.mm.chatroom.d.a> fre;
  protected int fxA;
  protected int fxB;
  private int fxC;
  protected Boolean fxD;
  protected int fxE;
  protected int fxF;
  final Time fxG;
  private final Calendar fxH;
  private final Boolean fxI;
  private DateFormatSymbols fxJ;
  private a fxK;
  protected Paint fxb;
  protected Paint fxc;
  protected Paint fxd;
  protected Paint fxe;
  protected Paint fxf;
  protected int fxg;
  protected int fxh;
  protected int fxi;
  protected int fxj;
  protected int fxk;
  protected int fxl;
  protected int fxm;
  protected int fxn;
  protected int fxo;
  private final StringBuilder fxp;
  protected boolean fxq;
  protected boolean fxr;
  protected int fxs;
  protected int fxt;
  protected int fxu;
  protected int fxv;
  protected int fxw;
  protected int fxx;
  protected int fxy;
  protected int fxz;
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
    this.fxq = false;
    this.fxr = false;
    this.fxs = -1;
    this.fxt = -1;
    this.fxu = -1;
    this.fxv = -1;
    this.fxw = -1;
    this.fxx = -1;
    this.fxy = -1;
    this.fxz = 1;
    this.fxA = 7;
    this.fxB = this.fxA;
    this.fxC = 0;
    this.fxE = fwT;
    this.fxF = 0;
    this.mNumRows = 6;
    this.fxJ = new DateFormatSymbols();
    this.fre = new ArrayList();
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.fxH = Calendar.getInstance();
    this.mCalendar = Calendar.getInstance();
    this.fxG = new Time(Time.getCurrentTimezone());
    this.fxG.setToNow();
    this.fxg = paramTypedArray.getColor(2, paramContext.getColor(2131100708));
    this.fxh = paramTypedArray.getColor(5, paramContext.getColor(2131100708));
    this.fxi = paramTypedArray.getColor(3, paramContext.getColor(2131100708));
    this.fxj = paramTypedArray.getColor(3, paramContext.getColor(2131100709));
    this.fxk = paramTypedArray.getColor(6, paramContext.getColor(2131100708));
    this.fxm = paramTypedArray.getColor(7, paramContext.getColor(2131100708));
    this.fxn = paramTypedArray.getColor(4, paramContext.getColor(2131100618));
    this.fxo = paramTypedArray.getColor(8, paramContext.getColor(2131100847));
    this.fxl = paramTypedArray.getColor(9, paramContext.getColor(2131100848));
    this.fxD = Boolean.valueOf(paramTypedArray.getBoolean(11, false));
    this.fxp = new StringBuilder(50);
    fwW = paramTypedArray.getDimensionPixelSize(18, paramContext.getDimensionPixelSize(2131166909));
    fxa = paramTypedArray.getDimensionPixelSize(20, paramContext.getDimensionPixelSize(2131166911));
    fwY = paramTypedArray.getDimensionPixelSize(19, paramContext.getDimensionPixelSize(2131166910));
    fwZ = paramTypedArray.getDimensionPixelOffset(14, paramContext.getDimensionPixelOffset(2131166415));
    fwU = paramTypedArray.getDimensionPixelSize(17, paramContext.getDimensionPixelOffset(2131166779));
    this.fxE = ((paramTypedArray.getDimensionPixelSize(0, paramContext.getDimensionPixelOffset(2131165948)) - fwZ) / 6);
    this.fxF = paramTypedArray.getDimensionPixelSize(1, paramContext.getDimensionPixelOffset(2131166005));
    this.fxI = Boolean.valueOf(paramTypedArray.getBoolean(12, true));
    this.fxe = new Paint();
    this.fxe.setAntiAlias(true);
    this.fxe.setTextSize(fxa);
    this.fxe.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fxe.setColor(this.fxj);
    this.fxe.setTextAlign(Paint.Align.LEFT);
    this.fxe.setStyle(Paint.Style.FILL);
    this.fxd = new Paint();
    this.fxd.setFakeBoldText(true);
    this.fxd.setAntiAlias(true);
    this.fxd.setColor(this.fxl);
    this.fxd.setTextAlign(Paint.Align.CENTER);
    this.fxd.setStyle(Paint.Style.FILL);
    this.fxf = new Paint();
    this.fxf.setFakeBoldText(true);
    this.fxf.setAntiAlias(true);
    this.fxf.setColor(this.fxo);
    this.fxf.setTextAlign(Paint.Align.CENTER);
    this.fxf.setStyle(Paint.Style.FILL);
    this.fxb = new Paint();
    this.fxb.setAntiAlias(true);
    this.fxb.setTextSize(fwY);
    this.fxb.setColor(this.fxj);
    this.fxb.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    this.fxb.setStyle(Paint.Style.FILL);
    this.fxb.setTextAlign(Paint.Align.CENTER);
    this.fxb.setFakeBoldText(true);
    this.fxc = new Paint();
    this.fxc.setAntiAlias(true);
    this.fxc.setTextSize(fwW);
    this.fxc.setStyle(Paint.Style.FILL);
    this.fxc.setTextAlign(Paint.Align.CENTER);
    this.fxc.setFakeBoldText(false);
    AppMethodBeat.o(12992);
  }
  
  private int Wf()
  {
    if (this.fxC < this.fxz) {}
    for (int i = this.fxC + this.fxA;; i = this.fxC) {
      return i - this.fxz;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.mYear < paramTime.year) || ((this.mYear == paramTime.year) && (this.mMonth < paramTime.month)) || ((this.mMonth == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(12993);
    int j = fwZ;
    int k = fwY / 2;
    int m = (this.mWidth - this.mPadding * 2) / (this.fxA * 2);
    int i = 0;
    while (i < this.fxA)
    {
      int n = this.fxz;
      int i1 = this.fxA;
      int i2 = this.mPadding;
      this.fxH.set(7, (n + i) % i1);
      paramCanvas.drawText(this.fxJ.getShortWeekdays()[this.fxH.get(7)].toUpperCase(Locale.getDefault()), (i * 2 + 1) * m + i2, j - k, this.fxb);
      i += 1;
    }
    AppMethodBeat.o(12993);
  }
  
  private void g(Canvas paramCanvas)
  {
    AppMethodBeat.i(12995);
    int j = (this.fxE + fwW) / 2 - fwV + fwZ;
    int i1 = (this.mWidth - this.mPadding * 2) / (this.fxA * 2);
    int i = Wf();
    int k = 1;
    while ((k <= this.fxB) && ((k <= this.fxy) || (-1 == this.fxy)))
    {
      int m = this.mPadding + (i * 2 + 1) * i1;
      if (((this.mMonth == this.fxu) && (this.fxs == k) && (this.fxw == this.mYear)) || ((this.mMonth == this.fxv) && (this.fxt == k) && (this.fxx == this.mYear)) || ((this.fxq) && (this.fxy == k) && (this.fxs == -1)))
      {
        if (!this.fxD.booleanValue()) {
          break label1369;
        }
        paramCanvas.drawRoundRect(new RectF(m - fwU, j - fwW / 3 - fwU, fwU + m, j - fwW / 3 + fwU), 10.0F, 10.0F, this.fxf);
      }
      for (;;)
      {
        if ((this.fxq) && (this.fxy == k) && (this.fxs == -1))
        {
          this.fxc.setColor(this.fxo);
          this.fxc.setTypeface(Typeface.defaultFromStyle(0));
          this.fxc.setTextSize(30.0F);
          paramCanvas.drawText(this.mContext.getResources().getString(2131764448), m, j + 12 + fwU, this.fxc);
        }
        this.fxc.setTextSize(fwW);
        if ((!this.fxq) || (this.fxy != k))
        {
          this.fxc.setColor(this.fxk);
          this.fxc.setTypeface(Typeface.defaultFromStyle(0));
        }
        if ((this.fxs != -1) && (this.fxt != -1) && (this.fxw == this.fxx) && (this.fxu == this.fxv) && (this.fxs == this.fxt) && (k == this.fxs) && (this.mMonth == this.fxu) && (this.mYear == this.fxw)) {
          this.fxc.setColor(this.fxo);
        }
        if ((this.fxs != -1) && (this.fxt != -1) && (this.fxw == this.fxx) && (this.fxw == this.mYear) && (((this.mMonth == this.fxu) && (this.fxv == this.fxu) && (((this.fxs < this.fxt) && (k > this.fxs) && (k < this.fxt)) || ((this.fxs > this.fxt) && (k < this.fxs) && (k > this.fxt)))) || ((this.fxu < this.fxv) && (this.mMonth == this.fxu) && (k > this.fxs)) || ((this.fxu < this.fxv) && (this.mMonth == this.fxv) && (k < this.fxt)) || ((this.fxu > this.fxv) && (this.mMonth == this.fxu) && (k < this.fxs)) || ((this.fxu > this.fxv) && (this.mMonth == this.fxv) && (k > this.fxt)))) {
          this.fxc.setColor(this.fxo);
        }
        if ((this.fxs != -1) && (this.fxt != -1) && (this.fxw != this.fxx) && (((this.fxw == this.mYear) && (this.mMonth == this.fxu)) || ((this.fxx == this.mYear) && (this.mMonth == this.fxv) && (((this.fxu < this.fxv) && (this.mMonth == this.fxu) && (k < this.fxs)) || ((this.fxu < this.fxv) && (this.mMonth == this.fxv) && (k > this.fxt)) || ((this.fxu > this.fxv) && (this.mMonth == this.fxu) && (k > this.fxs)) || ((this.fxu > this.fxv) && (this.mMonth == this.fxv) && (k < this.fxt)))))) {
          this.fxc.setColor(this.fxo);
        }
        if ((this.fxs != -1) && (this.fxt != -1) && (this.fxw == this.fxx) && (this.mYear == this.fxw) && (((this.mMonth > this.fxu) && (this.mMonth < this.fxv) && (this.fxu < this.fxv)) || ((this.mMonth < this.fxu) && (this.mMonth > this.fxv) && (this.fxu > this.fxv)))) {
          this.fxc.setColor(this.fxo);
        }
        if ((this.fxs != -1) && (this.fxt != -1) && (this.fxw != this.fxx) && (((this.fxw < this.fxx) && (((this.mMonth > this.fxu) && (this.mYear == this.fxw)) || ((this.mMonth < this.fxv) && (this.mYear == this.fxx)))) || ((this.fxw > this.fxx) && (((this.mMonth < this.fxu) && (this.mYear == this.fxw)) || ((this.mMonth > this.fxv) && (this.mYear == this.fxx)))))) {
          this.fxc.setColor(this.fxo);
        }
        if ((!this.fxI.booleanValue()) && (a(k, this.fxG)) && (this.fxG.month == this.mMonth) && (this.fxG.year == this.mYear))
        {
          this.fxc.setColor(this.fxm);
          this.fxc.setTypeface(Typeface.defaultFromStyle(2));
        }
        Iterator localIterator = this.fre.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.d.a locala = (com.tencent.mm.chatroom.d.a)localIterator.next();
          if ((locala.foG == k) && (locala.month == this.mMonth) && (locala.year == this.mYear))
          {
            this.fxc.setColor(this.fxn);
            this.fxc.setTypeface(Typeface.defaultFromStyle(0));
          }
        }
        label1369:
        paramCanvas.drawCircle(m, j - fwW / 3, fwU, this.fxf);
      }
      if (((this.mMonth == this.fxu) && (this.fxs == k) && (this.fxw == this.mYear)) || ((this.mMonth == this.fxv) && (this.fxt == k) && (this.fxx == this.mYear)) || ((this.fxq) && (this.fxy == k) && (this.fxs == -1)))
      {
        this.fxc.setTypeface(Typeface.defaultFromStyle(0));
        this.fxc.setColor(-1);
      }
      paramCanvas.drawText(String.format("%d", new Object[] { Integer.valueOf(k) }), m, j, this.fxc);
      int n = i + 1;
      i = n;
      m = j;
      if (n == this.fxA)
      {
        i = 0;
        m = j + this.fxE;
      }
      k += 1;
      j = m;
    }
    AppMethodBeat.o(12995);
  }
  
  private String getMonthAndYearString()
  {
    AppMethodBeat.i(12994);
    this.fxp.setLength(0);
    long l = this.mCalendar.getTimeInMillis();
    String str = DateUtils.formatDateRange(getContext(), l, l, 52);
    AppMethodBeat.o(12994);
    return str;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12996);
    int i = (this.mWidth - this.mPadding * 2) / (this.fxA * 2);
    int j = this.mPadding;
    int k = fxa / 2;
    int m = (fwZ - fxa) / 2;
    int n = fxa;
    StringBuilder localStringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
    localStringBuilder.setCharAt(0, Character.toUpperCase(localStringBuilder.charAt(0)));
    paramCanvas.drawText(localStringBuilder.toString(), i + j - k, m + n, this.fxe);
    paramCanvas.drawLine(0.0F, fwZ, this.mWidth, fwZ + 1, this.fxe);
    f(paramCanvas);
    g(paramCanvas);
    AppMethodBeat.o(12996);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12997);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.fxE * this.mNumRows + fwZ + this.fxF);
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
      if ((paramMotionEvent != null) && (this.fxK != null) && ((this.fxI.booleanValue()) || (paramMotionEvent.month != this.fxG.month) || (paramMotionEvent.year != this.fxG.year) || (paramMotionEvent.foG >= this.fxG.monthDay))) {
        this.fxK.b(paramMotionEvent);
      }
      AppMethodBeat.o(12998);
      return true;
      label136:
      int j = (int)(f2 - fwZ) / this.fxE;
      i = (int)((f1 - i) * this.fxA / (this.mWidth - i - this.mPadding)) - Wf() + 1 + j * this.fxA;
      if ((this.mMonth > 11) || (this.mMonth < 0) || (com.tencent.mm.chatroom.g.a.cp(this.mMonth, this.mYear) < i) || (i <= 0))
      {
        paramMotionEvent = null;
      }
      else
      {
        com.tencent.mm.chatroom.d.a locala = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, i);
        Iterator localIterator = this.fre.iterator();
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
      this.fre = paramCollection;
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
      this.fxE = ((Integer)paramHashMap.get("height")).intValue();
      if (this.fxE < fwX) {
        this.fxE = fwX;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.fxs = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.fxt = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.fxu = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.fxv = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.fxw = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.fxx = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.mMonth = ((Integer)paramHashMap.get("month")).intValue();
    this.mYear = ((Integer)paramHashMap.get("year")).intValue();
    this.fxq = false;
    this.fxy = -1;
    this.mCalendar.set(2, this.mMonth);
    this.mCalendar.set(1, this.mYear);
    this.mCalendar.set(5, 1);
    this.fxC = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start"))
    {
      this.fxz = ((Integer)paramHashMap.get("week_start")).intValue();
      this.fxB = com.tencent.mm.chatroom.g.a.cp(this.mMonth, this.mYear);
      i = 0;
      label393:
      if (i >= this.fxB) {
        break label499;
      }
      m = i + 1;
      paramHashMap = this.fxG;
      if ((this.mYear != paramHashMap.year) || (this.mMonth != paramHashMap.month) || (m != paramHashMap.monthDay)) {
        break label494;
      }
    }
    label494:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.fxq = true;
        this.fxy = m;
      }
      this.fxr = a(m, this.fxG);
      i += 1;
      break label393;
      this.fxz = this.mCalendar.getFirstDayOfWeek();
      break;
    }
    label499:
    int m = Wf();
    j = (this.fxB + m) / this.fxA;
    int i = k;
    if ((m + this.fxB) % this.fxA > 0) {
      i = 1;
    }
    this.mNumRows = (j + i);
    AppMethodBeat.o(13000);
  }
  
  public final void setOnDayClickListener(a parama)
  {
    this.fxK = parama;
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