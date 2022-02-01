package com.tencent.mm.picker.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.picker.base.c.d;
import com.tencent.mm.picker.base.c.e;
import com.tencent.mm.ui.bc;
import java.util.concurrent.Future;

public class WheelView
  extends View
{
  public Future<?> PL;
  private int Sc;
  String content;
  private Paint dZu;
  private Handler handler;
  private String label;
  private Context mContext;
  private GestureDetector nwZ;
  public boolean oYG;
  private int pxU;
  private int pxV;
  private final int pxW;
  public com.tencent.mm.picker.base.b.b pxX;
  private boolean pxY;
  public boolean pxZ;
  public final com.tencent.mm.picker.base.c.b pya;
  private Paint pyb;
  private com.tencent.mm.picker.base.a.b<?> pyc;
  private int pyd;
  private float pye;
  private int pyf;
  private boolean pyg;
  private boolean pyh;
  private float pyi;
  private float pyj;
  private float pyk;
  private int pyl;
  private int pym;
  private int pyn;
  private int pyo;
  private int pyp;
  private int pyq;
  private float pyr;
  private int pys;
  private int pyt;
  private Rect rect;
  private long startTime;
  private int tJ;
  private int textColor;
  private int textSize;
  
  public WheelView(Context paramContext)
  {
    this(paramContext, null);
    this.mContext = paramContext;
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(175306);
    this.pxU = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.pxW = 2;
    this.content = "";
    this.pxY = false;
    this.pxZ = true;
    if (com.tencent.mm.picker.c.a.pyD == null) {
      com.tencent.mm.picker.c.a.pyD = new com.tencent.mm.picker.base.c.a();
    }
    this.pya = com.tencent.mm.picker.c.a.pyD;
    this.pyo = 5;
    this.Sc = 0;
    this.pyr = 0.0F;
    this.startTime = 0L;
    this.tJ = 17;
    this.pyt = 0;
    this.rect = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(a.d.pickerview_textsize);
    this.pyd = getResources().getDimensionPixelSize(a.d.pickerview_min_textsize);
    this.tJ = 17;
    this.pyf = -2763307;
    this.handler = new d(this);
    this.nwZ = new GestureDetector(paramContext, new com.tencent.mm.picker.base.b.a(this));
    this.nwZ.setIsLongpressEnabled(false);
    this.oYG = true;
    this.pyk = 0.0F;
    this.pyl = -1;
    this.dZu = new Paint();
    this.dZu.setColor(this.textColor);
    this.dZu.setAntiAlias(true);
    this.dZu.setTextSize(this.textSize);
    this.pyb = new Paint();
    this.pyb.setColor(this.pyf);
    this.pyb.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void bSP()
  {
    AppMethodBeat.i(175307);
    if (this.pyc == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.pye = (this.pxU + getPaddingBottom() + getPaddingTop());
    this.pyp = ((int)(this.pye * this.pyo));
    this.pyq = View.MeasureSpec.getSize(this.pys);
    this.pyi = ((this.pyp - this.pye) / 2.0F);
    this.pyj = ((this.pyp + this.pye) / 2.0F);
    if (this.pyl == -1) {
      if (!this.oYG) {
        break label141;
      }
    }
    label141:
    for (this.pyl = ((this.pyc.getItemsCount() + 1) / 2);; this.pyl = 0)
    {
      this.pyn = this.pyl;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void bSS()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.dZu.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.dZu.getTextBounds(this.content, 0, 0, localRect);
    int j = this.content.length();
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j - i <= 1) {
        break;
      }
      localRect = new Rect();
      k = (j - i >> 1) + i;
      this.dZu.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= bST()) {
        j = k - 1;
      } else if (localRect.width() < bST()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.dZu.measureText(this.content + "...") <= bST()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int bST()
  {
    AppMethodBeat.i(175318);
    int i = this.pyq;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void bSU()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.dZu.setTextSize(i);
    while ((i > this.pyd) && (!bSV()))
    {
      i -= 1;
      this.dZu.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean bSV()
  {
    AppMethodBeat.i(175320);
    if (this.dZu.measureText(this.content) <= this.pyq - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(175320);
      return true;
    }
    AppMethodBeat.o(175320);
    return false;
  }
  
  private static String dD(Object paramObject)
  {
    AppMethodBeat.i(175316);
    if (paramObject == null)
    {
      AppMethodBeat.o(175316);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(175316);
    return paramObject;
  }
  
  private String xP(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.oYG) {
      i = xQ(paramInt);
    }
    String str = this.pyc.xN(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int xQ(int paramInt)
  {
    AppMethodBeat.i(175315);
    int j = this.pyc.getItemsCount();
    if (j == 0)
    {
      AppMethodBeat.o(175315);
      return j;
    }
    int i = paramInt % j;
    paramInt = i;
    if (i < 0) {
      paramInt = i + j;
    }
    AppMethodBeat.o(175315);
    return paramInt;
  }
  
  public final void a(WheelView.a parama)
  {
    AppMethodBeat.i(175308);
    bSQ();
    if ((parama == WheelView.a.pyw) || (parama == WheelView.a.pyx))
    {
      this.Sc = ((int)((this.pyk % this.pye + this.pye) % this.pye));
      if (this.Sc <= this.pye / 2.0F) {
        break label113;
      }
    }
    label113:
    for (this.Sc = ((int)(this.pye - this.Sc));; this.Sc = (-this.Sc))
    {
      this.PL = this.pya.f(new e(this, this.Sc), 10L);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void bSQ()
  {
    AppMethodBeat.i(175309);
    if ((this.PL != null) && (!this.PL.isCancelled()))
    {
      this.PL.cancel(true);
      this.PL = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final void bSR()
  {
    AppMethodBeat.i(231667);
    String str = dD(xP(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(231667);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.pyc;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.pyc == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.pyg) && (this.pym == 0))
    {
      AppMethodBeat.o(175312);
      return -1;
    }
    if ((this.oYG) && ((this.pym < 0) || (this.pym >= this.pyc.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.pym) - this.pyc.getItemsCount()), this.pyc.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.pym, this.pyc.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.pyl;
  }
  
  public float getItemHeight()
  {
    return this.pye;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.pyc != null)
    {
      int i = this.pyc.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.pyk;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.pyc == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.pyl = Math.min(Math.max(0, this.pyl), this.pyc.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.pyo];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.pyk / this.pye);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.pyl;
        this.pyn = (i % this.pyc.getItemsCount() + j);
        if (!this.oYG)
        {
          if (this.pyn < 0) {
            this.pyn = 0;
          }
          if (this.pyn > this.pyc.getItemsCount() - 1) {
            this.pyn = (this.pyc.getItemsCount() - 1);
          }
          f1 = this.pyk;
          f2 = this.pye;
          i = 0;
          if (i >= this.pyo) {
            continue;
          }
          j = this.pyn - (this.pyo / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = xP(j - 1);
          if (i != this.pyo - 1) {
            break label1070;
          }
          localObject1 = xP(j + 1);
          arrayOfObject[i] = xP(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        bc.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        continue;
        if (this.pyn < 0) {
          this.pyn = (this.pyc.getItemsCount() + this.pyn);
        }
        if (this.pyn <= this.pyc.getItemsCount() - 1) {
          continue;
        }
        this.pyn -= this.pyc.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.pyi, this.pyq, this.pyi, this.pyb);
        paramCanvas.drawLine(0.0F, this.pyj, this.pyq, this.pyj, this.pyb);
        int j = 0;
        if (j < this.pyo + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.pye * j - f1 % f2 + this.pye / 2.0F - this.pye;
            if ((this.pxZ) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(dD(localObject3))) || ((this.pyg) && (localObject3.equals(this.mContext.getString(a.i.picker_long_term))))) {
              continue;
            }
            this.content = (dD(localObject3) + this.label);
            this.dZu.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.tJ)
          {
          default: 
            float f4 = this.pyp / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.pxV);
            if (k < this.pxV * 0.14F)
            {
              i = (int)(this.pxV * 0.14F);
              this.dZu.setAlpha(i);
              if ((f3 >= this.pyi) && (f3 <= this.pyj)) {
                this.pym = (this.pyn - (this.pyo / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.pyp))
              {
                localObject3 = this.content;
                f4 = this.pyt;
                Paint.FontMetricsInt localFontMetricsInt = this.dZu.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.dZu);
              }
              j += 1;
              this.dZu.setTextSize(this.textSize);
              continue;
              if (j == this.pyo + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = dD(localObject3);
            }
            break;
          case 17: 
            if ((this.pxY) || (this.label == null) || (this.label.equals("")) || (!this.pxZ))
            {
              if (this.pyq < this.rect.width())
              {
                bSU();
                if (!bSV()) {
                  bSS();
                }
                this.dZu.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.pyt = ((int)((this.pyq - this.rect.width()) * 0.5D));
                continue;
              }
              this.pyt = ((int)((this.pyq - this.rect.width()) * 0.5D));
              continue;
            }
            this.pyt = ((int)((this.pyq - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.pyt = 0;
            break;
          case 5: 
            this.pyt = (this.pyq - this.rect.width());
            continue;
            i = k;
            if (k <= this.pxV) {
              continue;
            }
            i = this.pxV;
            break;
          }
        }
        AppMethodBeat.o(175313);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175321);
    this.pys = paramInt1;
    bSP();
    setMeasuredDimension(this.pyq, this.pyp);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.pyl;
    float f2 = this.pye;
    float f3 = this.pyc.getItemsCount() - 1 - this.pyl;
    float f4 = this.pye;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.pyx);
        i = 0;
      }
      break;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i == 0) && (paramMotionEvent.getAction() != 0)) {
          invalidate();
        }
        AppMethodBeat.o(175322);
        return true;
        this.startTime = System.currentTimeMillis();
        bSQ();
        this.pyr = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.pyr - paramMotionEvent.getRawY();
        this.pyr = paramMotionEvent.getRawY();
        this.pyk += f5;
        if (this.oYG) {
          break;
        }
        if (((this.pyk - this.pye * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.pyk + this.pye * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.pyk -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.pyp / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.pye / 2.0F);; i = (int)(i - this.pye / 2.0F))
    {
      if (this.pye != 0.0F)
      {
        this.Sc = ((int)((int)(i / this.pye) * this.pye));
        a(WheelView.a.pyv);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.pyc = paramb;
    bSP();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.pym = paramInt;
    this.pyl = paramInt;
    this.pyk = 0.0F;
    bSR();
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.oYG = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.pyf = paramInt;
      this.pyb.setColor(this.pyf);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.pyb.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.tJ = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.pxY = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.pyh = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.pyg = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.pxX = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.pyk = paramFloat;
  }
  
  public final WheelView xR(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.pxU = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView xS(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.dZu.setColor(this.textColor);
    this.pxV = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */