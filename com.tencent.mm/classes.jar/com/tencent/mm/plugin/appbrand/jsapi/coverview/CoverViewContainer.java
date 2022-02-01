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
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements com.tencent.mm.plugin.appbrand.jsapi.ac.g, bz
{
  private static HashMap<Integer, CoverViewContainer> lSV;
  private View atQ;
  private float dsy;
  private float dsz;
  private float gPO;
  private float lSR;
  private float[] lSS;
  private int lST;
  private Paint lSU;
  public boolean lSW;
  public String lSX;
  private int lSY;
  private boolean lSZ;
  private String lTa;
  private long lTb;
  GradientDrawable lTc;
  float[] lTd;
  private a lTe;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(221236);
    lSV = new HashMap();
    AppMethodBeat.o(221236);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.lSU = new Paint();
    this.lSW = false;
    this.lSX = "";
    this.lSZ = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.lSU = new Paint();
    this.lSW = false;
    this.lSX = "";
    this.lSZ = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.lSU = new Paint();
    this.lSW = false;
    this.lSX = "";
    this.lSZ = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  private static JSONObject O(View paramView, int paramInt)
  {
    AppMethodBeat.i(221234);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", com.tencent.mm.plugin.appbrand.ac.g.aS(paramView.getX()));
      localJSONObject.put("top", com.tencent.mm.plugin.appbrand.ac.g.aS(paramView.getY()));
      AppMethodBeat.o(221234);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(221234);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221233);
    if (this.lTe != null) {
      this.lTe.a(paramString, paramCoverViewContainer.lSX, O(paramCoverViewContainer, paramCoverViewContainer.viewId), y(paramMotionEvent));
    }
    AppMethodBeat.o(221233);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(221232);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(221232);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(221232);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(221232);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(221232);
    return false;
  }
  
  public static RectF cu(View paramView)
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
    AppMethodBeat.i(221227);
    if (this.mBgColor != 0) {
      this.lTc.setColor(this.mBgColor);
    }
    this.lTd[0] = this.lSS[0];
    this.lTd[1] = this.lSS[0];
    this.lTd[2] = this.lSS[1];
    this.lTd[3] = this.lSS[1];
    this.lTd[4] = this.lSS[3];
    this.lTd[5] = this.lSS[3];
    this.lTd[6] = this.lSS[2];
    this.lTd[7] = this.lSS[2];
    this.lTc.setCornerRadii(this.lTd);
    if ((this.gPO > 0.0F) && (this.lST != 0)) {
      this.lTc.setStroke((int)this.gPO, this.lST);
    }
    GradientDrawable localGradientDrawable = this.lTc;
    AppMethodBeat.o(221227);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.lSU.setStyle(Paint.Style.STROKE);
    this.lSU.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    AppMethodBeat.o(140661);
  }
  
  public static void xb(int paramInt)
  {
    AppMethodBeat.i(221230);
    lSV.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(221230);
  }
  
  private JSONObject y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221235);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.viewId);
      localJSONObject.put("x", com.tencent.mm.plugin.appbrand.ac.g.aS(paramMotionEvent.getRawX()));
      localJSONObject.put("y", com.tencent.mm.plugin.appbrand.ac.g.aS(paramMotionEvent.getRawY()));
      AppMethodBeat.o(221235);
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      AppMethodBeat.o(221235);
    }
    return null;
  }
  
  protected final boolean K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.lSR <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.lSR, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.lSR)
    {
      if (paramFloat2 < this.lSR)
      {
        if (Math.pow(this.lSR - paramFloat1, 2.0D) + Math.pow(this.lSR - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.lSR)
      {
        d2 = Math.pow(this.lSR - paramFloat1, 2.0D);
        if (Math.pow(this.lSR + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.lSR) {
      if (paramFloat2 < this.lSR)
      {
        if (Math.pow(this.lSR + paramFloat1 - f1, 2.0D) + Math.pow(this.lSR - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.lSR)
      {
        d2 = Math.pow(this.lSR + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.lSR + paramFloat2 - f2, 2.0D) + d2 > d1)
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
    AppMethodBeat.i(221229);
    this.lSW = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.lSX = paramString;
      lSV.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(221229);
      return;
    }
    lSV.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(221229);
  }
  
  public final <T> T aB(Class<T> paramClass)
  {
    AppMethodBeat.i(140663);
    try
    {
      if (paramClass.isAssignableFrom(this.atQ.getClass()))
      {
        paramClass = this.atQ;
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
  
  public boolean bGj()
  {
    return false;
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(221226);
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(221226);
      return true;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0.0F, 0.0F, getWidth(), getHeight());
    draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(221226);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cu(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!K(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
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
    if ((this.lSS != null) && (this.lSS.length > 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.lSR > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.lSR, this.lSR, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.gPO <= 0.0F) {
        break label320;
      }
      float f1 = this.gPO / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.lSR, this.lSR, this.lSU);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.lSR > 0.0F)
      {
        f1 = f2;
        if (this.lSR - this.gPO > 0.0F) {
          f1 = this.lSR - this.gPO;
        }
      }
      localPath.addRoundRect(new RectF(this.gPO, this.gPO, getWidth() - this.gPO, getHeight() - this.gPO), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label320:
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
  
  public final void eb(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.lSY = paramInt2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(221231);
    Log.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.lSW)
    {
      localCoverViewContainer = this;
      if ((!this.lSW) && ((!this.lSZ) || (!a(localCoverViewContainer, this)))) {}
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
            AppMethodBeat.o(221231);
            return true;
            if (this.lSY <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)lSV.get(Integer.valueOf(this.lSY));
            break;
            this.dsy = paramMotionEvent.getRawX();
            this.dsz = paramMotionEvent.getRawY();
            this.lTb = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer, paramMotionEvent);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.dsy;
          f2 = paramMotionEvent.getRawY() - this.dsz;
        } while ((localCoverViewContainer == null) || ((Math.abs(f1) <= 1.0F) && (Math.abs(f2) <= 1.0F)));
        m = (int)(f1 + localCoverViewContainer.getX());
        k = (int)(f2 + localCoverViewContainer.getY());
        if (m < 0)
        {
          i = 0;
          label252:
          localCoverViewContainer.setX(i);
          if (k >= 0) {
            break label340;
          }
          i = j;
        }
        break;
      }
    }
    for (;;)
    {
      localCoverViewContainer.setY(i);
      this.dsy = paramMotionEvent.getRawX();
      this.dsz = paramMotionEvent.getRawY();
      a("dragging", localCoverViewContainer, paramMotionEvent);
      break;
      i = m;
      if (localCoverViewContainer.getWidth() + m <= this.mScreenWidth) {
        break label252;
      }
      i = this.mScreenWidth - localCoverViewContainer.getWidth();
      break label252;
      label340:
      if (localCoverViewContainer.getHeight() + k > this.mScreenHeight)
      {
        i = this.mScreenHeight - localCoverViewContainer.getHeight();
        continue;
        long l = System.currentTimeMillis() - this.lTb;
        if ((this.lTb != 0L) && (l < 300L) && (l >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer, paramMotionEvent);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(221231);
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
    this.lST = paramInt;
    this.lSU.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.lSR = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221228);
    this.lSS = paramArrayOfFloat;
    if ((this.lSS != null) && (this.lSS.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(221228);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.gPO = paramFloat;
    this.lSU.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.lTa = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.lTe = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.lSZ = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.atQ = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */