package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements com.tencent.mm.plugin.appbrand.jsapi.w.g
{
  private static HashMap<Integer, CoverViewContainer> kpO;
  private View asb;
  private float cPy;
  private float cPz;
  private float kpJ;
  private float[] kpK;
  private float kpL;
  private int kpM;
  private Paint kpN;
  public boolean kpP;
  public String kpQ;
  private int kpR;
  private boolean kpS;
  private String kpT;
  private long kpU;
  private a kpV;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(200945);
    kpO = new HashMap();
    AppMethodBeat.o(200945);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.kpN = new Paint();
    this.kpP = false;
    this.kpQ = "";
    this.kpS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.kpN = new Paint();
    this.kpP = false;
    this.kpQ = "";
    this.kpS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.kpN = new Paint();
    this.kpP = false;
    this.kpQ = "";
    this.kpS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  private static JSONObject P(View paramView, int paramInt)
  {
    AppMethodBeat.i(200944);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInt);
      localJSONObject.put("left", com.tencent.mm.plugin.appbrand.z.g.aF(paramView.getX()));
      localJSONObject.put("top", com.tencent.mm.plugin.appbrand.z.g.aF(paramView.getY()));
      AppMethodBeat.o(200944);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(200944);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer)
  {
    AppMethodBeat.i(200943);
    if (this.kpV != null) {
      this.kpV.b(paramString, paramCoverViewContainer.kpQ, P(paramCoverViewContainer, paramCoverViewContainer.viewId));
    }
    AppMethodBeat.o(200943);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(200942);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(200942);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(200942);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(200942);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(200942);
    return false;
  }
  
  public static RectF cB(View paramView)
  {
    AppMethodBeat.i(140670);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    AppMethodBeat.o(140670);
    return paramView;
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(200938);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (this.mBgColor != 0) {
      localGradientDrawable.setColor(this.mBgColor);
    }
    localGradientDrawable.setCornerRadii(new float[] { this.kpK[0], this.kpK[0], this.kpK[1], this.kpK[1], this.kpK[3], this.kpK[3], this.kpK[2], this.kpK[2] });
    if ((this.kpL > 0.0F) && (this.kpM != 0)) {
      localGradientDrawable.setStroke((int)this.kpL, this.kpM);
    }
    AppMethodBeat.o(200938);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.kpN.setStyle(Paint.Style.STROKE);
    this.kpN.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    AppMethodBeat.o(140661);
  }
  
  public static void sA(int paramInt)
  {
    AppMethodBeat.i(200940);
    kpO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(200940);
  }
  
  protected final boolean F(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.kpJ <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.kpJ, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.kpJ)
    {
      if (paramFloat2 < this.kpJ)
      {
        if (Math.pow(this.kpJ - paramFloat1, 2.0D) + Math.pow(this.kpJ - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kpJ)
      {
        d2 = Math.pow(this.kpJ - paramFloat1, 2.0D);
        if (Math.pow(this.kpJ + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.kpJ) {
      if (paramFloat2 < this.kpJ)
      {
        if (Math.pow(this.kpJ + paramFloat1 - f1, 2.0D) + Math.pow(this.kpJ - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kpJ)
      {
        d2 = Math.pow(this.kpJ + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.kpJ + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    AppMethodBeat.o(140669);
    return true;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(200939);
    this.kpP = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.kpQ = paramString;
      kpO.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(200939);
      return;
    }
    kpO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(200939);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(140664);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1);
      AppMethodBeat.o(140664);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(140665);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1, paramLayoutParams);
      AppMethodBeat.o(140665);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public final <T> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(140663);
    try
    {
      if (paramClass.isAssignableFrom(this.asb.getClass()))
      {
        paramClass = this.asb;
        AppMethodBeat.o(140663);
        return paramClass;
      }
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(140663);
    }
    return null;
  }
  
  public boolean bgz()
  {
    return false;
  }
  
  public final void dN(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.kpR = paramInt2;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cB(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!F(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
    {
      AppMethodBeat.o(140668);
      return false;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(140668);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(140662);
    if ((this.kpK != null) && (this.kpK.length > 0))
    {
      setBackground(getShadowDrawable());
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.kpJ > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kpJ, this.kpJ, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kpL <= 0.0F) {
        break label328;
      }
      float f1 = this.kpL / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kpJ, this.kpJ, this.kpN);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kpJ > 0.0F)
      {
        f1 = f2;
        if (this.kpJ - this.kpL > 0.0F) {
          f1 = this.kpJ - this.kpL;
        }
      }
      localPath.addRoundRect(new RectF(this.kpL, this.kpL, getWidth() - this.kpL, getHeight() - this.kpL), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label328:
    for (;;)
    {
      super.draw(paramCanvas);
      if (i != 0) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(140662);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(200941);
    ac.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.kpP)
    {
      localCoverViewContainer = this;
      if ((!this.kpP) && ((!this.kpS) || (!a(localCoverViewContainer, this)))) {}
    }
    else
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        float f1;
        float f2;
        do
        {
          for (;;)
          {
            AppMethodBeat.o(200941);
            return true;
            if (this.kpR <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)kpO.get(Integer.valueOf(this.kpR));
            break;
            this.cPy = paramMotionEvent.getRawX();
            this.cPz = paramMotionEvent.getRawY();
            this.kpU = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.cPy;
          f2 = paramMotionEvent.getRawY() - this.cPz;
        } while ((localCoverViewContainer == null) || ((Math.abs(f1) <= 1.0F) && (Math.abs(f2) <= 1.0F)));
        m = (int)(f1 + localCoverViewContainer.getX());
        k = (int)(f2 + localCoverViewContainer.getY());
        if (m < 0)
        {
          i = 0;
          label251:
          localCoverViewContainer.setX(i);
          if (k >= 0) {
            break label338;
          }
          i = j;
        }
        break;
      }
    }
    for (;;)
    {
      localCoverViewContainer.setY(i);
      this.cPy = paramMotionEvent.getRawX();
      this.cPz = paramMotionEvent.getRawY();
      a("dragging", localCoverViewContainer);
      break;
      i = m;
      if (localCoverViewContainer.getWidth() + m <= this.mScreenWidth) {
        break label251;
      }
      i = this.mScreenWidth - localCoverViewContainer.getWidth();
      break label251;
      label338:
      if (localCoverViewContainer.getHeight() + k > this.mScreenHeight)
      {
        i = this.mScreenHeight - localCoverViewContainer.getHeight();
        continue;
        long l = System.currentTimeMillis() - this.kpU;
        if ((this.kpU != 0L) && (l < 300L) && (l >= 0L))
        {
          if (this.mOnClickListener == null) {
            break;
          }
          this.mOnClickListener.onClick(this);
          break;
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(200941);
        return bool;
      }
      i = k;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    this.mBgColor = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(140666);
    this.kpM = paramInt;
    this.kpN.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kpJ = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    this.kpK = paramArrayOfFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.kpL = paramFloat;
    this.kpN.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.kpT = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.kpV = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.kpS = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.asb = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString1, String paramString2, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */