package com.tencent.mm.picker.base.view;

import android.annotation.SuppressLint;
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
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.picker.base.c.d;
import com.tencent.mm.picker.base.c.e;
import com.tencent.mm.ui.av;
import java.util.concurrent.Future;

public class WheelView
  extends View
{
  private Rect byG;
  private Paint ciV;
  String content;
  private Handler handler;
  private String label;
  private float mBA;
  private float mBB;
  private float mBC;
  private int mBD;
  private int mBE;
  private int mBF;
  private int mBG;
  private int mBH;
  private int mBI;
  private float mBJ;
  private int mBK;
  private int mBL;
  private int mBk;
  private int mBl;
  private final int mBm;
  private GestureDetector mBn;
  public com.tencent.mm.picker.base.b.b mBo;
  private boolean mBp;
  public boolean mBq;
  public final com.tencent.mm.picker.base.c.b mBr;
  public Future<?> mBs;
  private Paint mBt;
  private com.tencent.mm.picker.base.a.b<?> mBu;
  private int mBv;
  private float mBw;
  private int mBx;
  private boolean mBy;
  private boolean mBz;
  private Context mContext;
  public boolean mfK;
  private int sK;
  private long startTime;
  private int textColor;
  private int textSize;
  private int zP;
  
  public WheelView(Context paramContext)
  {
    this(paramContext, null);
    this.mContext = paramContext;
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(175306);
    this.mBk = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.mBm = 2;
    this.content = "";
    this.mBp = false;
    this.mBq = true;
    if (com.tencent.mm.picker.c.a.mBV == null) {
      com.tencent.mm.picker.c.a.mBV = new com.tencent.mm.picker.base.c.a();
    }
    this.mBr = com.tencent.mm.picker.c.a.mBV;
    this.mBG = 5;
    this.zP = 0;
    this.mBJ = 0.0F;
    this.startTime = 0L;
    this.sK = 17;
    this.mBL = 0;
    this.byG = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(a.d.pickerview_textsize);
    this.mBv = getResources().getDimensionPixelSize(a.d.pickerview_min_textsize);
    this.sK = 17;
    this.mBx = -2763307;
    this.handler = new d(this);
    this.mBn = new GestureDetector(paramContext, new com.tencent.mm.picker.base.b.a(this));
    this.mBn.setIsLongpressEnabled(false);
    this.mfK = true;
    this.mBC = 0.0F;
    this.mBD = -1;
    this.ciV = new Paint();
    this.ciV.setColor(this.textColor);
    this.ciV.setAntiAlias(true);
    this.ciV.setTextSize(this.textSize);
    this.mBt = new Paint();
    this.mBt.setColor(this.mBx);
    this.mBt.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void buG()
  {
    AppMethodBeat.i(175307);
    if (this.mBu == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.mBw = (this.mBk + getPaddingBottom() + getPaddingTop());
    this.mBH = ((int)(this.mBw * this.mBG));
    this.mBI = View.MeasureSpec.getSize(this.mBK);
    this.mBA = ((this.mBH - this.mBw) / 2.0F);
    this.mBB = ((this.mBH + this.mBw) / 2.0F);
    if (this.mBD == -1) {
      if (!this.mfK) {
        break label141;
      }
    }
    label141:
    for (this.mBD = ((this.mBu.getItemsCount() + 1) / 2);; this.mBD = 0)
    {
      this.mBF = this.mBD;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void buJ()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.ciV.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.ciV.getTextBounds(this.content, 0, 0, localRect);
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
      this.ciV.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= buK()) {
        j = k - 1;
      } else if (localRect.width() < buK()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.ciV.measureText(this.content + "...") <= buK()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int buK()
  {
    AppMethodBeat.i(175318);
    int i = this.mBI;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void buL()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.ciV.setTextSize(i);
    while ((i > this.mBv) && (!buM()))
    {
      i -= 1;
      this.ciV.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean buM()
  {
    AppMethodBeat.i(175320);
    if (this.ciV.measureText(this.content) <= this.mBI - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(175320);
      return true;
    }
    AppMethodBeat.o(175320);
    return false;
  }
  
  private static String ck(Object paramObject)
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
  
  private String xK(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.mfK) {
      i = xL(paramInt);
    }
    String str = this.mBu.xI(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int xL(int paramInt)
  {
    AppMethodBeat.i(175315);
    int j = this.mBu.getItemsCount();
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
    buH();
    if ((parama == WheelView.a.mBO) || (parama == WheelView.a.mBP))
    {
      this.zP = ((int)((this.mBC % this.mBw + this.mBw) % this.mBw));
      if (this.zP <= this.mBw / 2.0F) {
        break label113;
      }
    }
    label113:
    for (this.zP = ((int)(this.mBw - this.zP));; this.zP = (-this.zP))
    {
      this.mBs = this.mBr.e(new e(this, this.zP), 10L);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void buH()
  {
    AppMethodBeat.i(175309);
    if ((this.mBs != null) && (!this.mBs.isCancelled()))
    {
      this.mBs.cancel(true);
      this.mBs = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final void buI()
  {
    AppMethodBeat.i(249494);
    String str = ck(xK(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(249494);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.mBu;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.mBu == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.mBy) && (this.mBE == 0))
    {
      AppMethodBeat.o(175312);
      return -1;
    }
    if ((this.mfK) && ((this.mBE < 0) || (this.mBE >= this.mBu.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.mBE) - this.mBu.getItemsCount()), this.mBu.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.mBE, this.mBu.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.mBD;
  }
  
  public float getItemHeight()
  {
    return this.mBw;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.mBu != null)
    {
      int i = this.mBu.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.mBC;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.mBu == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.mBD = Math.min(Math.max(0, this.mBD), this.mBu.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.mBG];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.mBC / this.mBw);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.mBD;
        this.mBF = (i % this.mBu.getItemsCount() + j);
        if (!this.mfK)
        {
          if (this.mBF < 0) {
            this.mBF = 0;
          }
          if (this.mBF > this.mBu.getItemsCount() - 1) {
            this.mBF = (this.mBu.getItemsCount() - 1);
          }
          f1 = this.mBC;
          f2 = this.mBw;
          i = 0;
          if (i >= this.mBG) {
            continue;
          }
          j = this.mBF - (this.mBG / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = xK(j - 1);
          if (i != this.mBG - 1) {
            break label1070;
          }
          localObject1 = xK(j + 1);
          arrayOfObject[i] = xK(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        av.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        continue;
        if (this.mBF < 0) {
          this.mBF = (this.mBu.getItemsCount() + this.mBF);
        }
        if (this.mBF <= this.mBu.getItemsCount() - 1) {
          continue;
        }
        this.mBF -= this.mBu.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.mBA, this.mBI, this.mBA, this.mBt);
        paramCanvas.drawLine(0.0F, this.mBB, this.mBI, this.mBB, this.mBt);
        int j = 0;
        if (j < this.mBG + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.mBw * j - f1 % f2 + this.mBw / 2.0F - this.mBw;
            if ((this.mBq) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(ck(localObject3))) || ((this.mBy) && (localObject3.equals(this.mContext.getString(a.i.picker_long_term))))) {
              continue;
            }
            this.content = (ck(localObject3) + this.label);
            this.ciV.getTextBounds(this.content, 0, this.content.length(), this.byG);
          }
          int k;
          switch (this.sK)
          {
          default: 
            float f4 = this.mBH / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.mBl);
            if (k < this.mBl * 0.14F)
            {
              i = (int)(this.mBl * 0.14F);
              this.ciV.setAlpha(i);
              if ((f3 >= this.mBA) && (f3 <= this.mBB)) {
                this.mBE = (this.mBF - (this.mBG / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.mBH))
              {
                localObject3 = this.content;
                f4 = this.mBL;
                Paint.FontMetricsInt localFontMetricsInt = this.ciV.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.ciV);
              }
              j += 1;
              this.ciV.setTextSize(this.textSize);
              continue;
              if (j == this.mBG + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = ck(localObject3);
            }
            break;
          case 17: 
            if ((this.mBp) || (this.label == null) || (this.label.equals("")) || (!this.mBq))
            {
              if (this.mBI < this.byG.width())
              {
                buL();
                if (!buM()) {
                  buJ();
                }
                this.ciV.getTextBounds(this.content, 0, this.content.length(), this.byG);
                this.mBL = ((int)((this.mBI - this.byG.width()) * 0.5D));
                continue;
              }
              this.mBL = ((int)((this.mBI - this.byG.width()) * 0.5D));
              continue;
            }
            this.mBL = ((int)((this.mBI - this.byG.width()) * 0.25D));
            break;
          case 3: 
            this.mBL = 0;
            break;
          case 5: 
            this.mBL = (this.mBI - this.byG.width());
            continue;
            i = k;
            if (k <= this.mBl) {
              continue;
            }
            i = this.mBl;
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
    this.mBK = paramInt1;
    buG();
    setMeasuredDimension(this.mBI, this.mBH);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    GestureDetector localGestureDetector = this.mBn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.mBD;
    float f2 = this.mBw;
    float f3 = this.mBu.getItemsCount() - 1 - this.mBD;
    float f4 = this.mBw;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.mBP);
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
        buH();
        this.mBJ = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.mBJ - paramMotionEvent.getRawY();
        this.mBJ = paramMotionEvent.getRawY();
        this.mBC += f5;
        if (this.mfK) {
          break;
        }
        if (((this.mBC - this.mBw * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.mBC + this.mBw * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.mBC -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.mBH / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.mBw / 2.0F);; i = (int)(i - this.mBw / 2.0F))
    {
      if (this.mBw != 0.0F)
      {
        this.zP = ((int)((int)(i / this.mBw) * this.mBw));
        a(WheelView.a.mBN);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.mBu = paramb;
    buG();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.mBE = paramInt;
    this.mBD = paramInt;
    this.mBC = 0.0F;
    buI();
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.mfK = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.mBx = paramInt;
      this.mBt.setColor(this.mBx);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.mBt.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.sK = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.mBp = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.mBz = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.mBy = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.mBo = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.mBC = paramFloat;
  }
  
  public final WheelView xM(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.mBk = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView xN(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.ciV.setColor(this.textColor);
    this.mBl = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */