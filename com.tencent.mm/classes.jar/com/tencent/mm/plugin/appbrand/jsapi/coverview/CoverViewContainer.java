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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements com.tencent.mm.plugin.appbrand.jsapi.z.g
{
  private static HashMap<Integer, CoverViewContainer> kKO;
  private View atS;
  private float daO;
  private float daP;
  private float kKJ;
  private float[] kKK;
  private float kKL;
  private int kKM;
  private Paint kKN;
  public boolean kKP;
  public String kKQ;
  private int kKR;
  private boolean kKS;
  private String kKT;
  private long kKU;
  GradientDrawable kKV;
  float[] kKW;
  private a kKX;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(187626);
    kKO = new HashMap();
    AppMethodBeat.o(187626);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.kKN = new Paint();
    this.kKP = false;
    this.kKQ = "";
    this.kKS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.kKN = new Paint();
    this.kKP = false;
    this.kKQ = "";
    this.kKS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.kKN = new Paint();
    this.kKP = false;
    this.kKQ = "";
    this.kKS = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  private static JSONObject P(View paramView, int paramInt)
  {
    AppMethodBeat.i(187624);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", com.tencent.mm.plugin.appbrand.z.g.aI(paramView.getX()));
      localJSONObject.put("top", com.tencent.mm.plugin.appbrand.z.g.aI(paramView.getY()));
      AppMethodBeat.o(187624);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(187624);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187623);
    if (this.kKX != null) {
      this.kKX.a(paramString, paramCoverViewContainer.kKQ, P(paramCoverViewContainer, paramCoverViewContainer.viewId), u(paramMotionEvent));
    }
    AppMethodBeat.o(187623);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(187622);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(187622);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(187622);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(187622);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(187622);
    return false;
  }
  
  public static RectF cC(View paramView)
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
    AppMethodBeat.i(187617);
    if (this.mBgColor != 0) {
      this.kKV.setColor(this.mBgColor);
    }
    this.kKW[0] = this.kKK[0];
    this.kKW[1] = this.kKK[0];
    this.kKW[2] = this.kKK[1];
    this.kKW[3] = this.kKK[1];
    this.kKW[4] = this.kKK[3];
    this.kKW[5] = this.kKK[3];
    this.kKW[6] = this.kKK[2];
    this.kKW[7] = this.kKK[2];
    this.kKV.setCornerRadii(this.kKW);
    if ((this.kKL > 0.0F) && (this.kKM != 0)) {
      this.kKV.setStroke((int)this.kKL, this.kKM);
    }
    GradientDrawable localGradientDrawable = this.kKV;
    AppMethodBeat.o(187617);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.kKN.setStyle(Paint.Style.STROKE);
    this.kKN.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    AppMethodBeat.o(140661);
  }
  
  public static void tc(int paramInt)
  {
    AppMethodBeat.i(187620);
    kKO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(187620);
  }
  
  private JSONObject u(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187625);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.viewId);
      localJSONObject.put("x", com.tencent.mm.plugin.appbrand.z.g.aI(paramMotionEvent.getRawX()));
      localJSONObject.put("y", com.tencent.mm.plugin.appbrand.z.g.aI(paramMotionEvent.getRawY()));
      AppMethodBeat.o(187625);
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      AppMethodBeat.o(187625);
    }
    return null;
  }
  
  protected final boolean G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.kKJ <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.kKJ, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.kKJ)
    {
      if (paramFloat2 < this.kKJ)
      {
        if (Math.pow(this.kKJ - paramFloat1, 2.0D) + Math.pow(this.kKJ - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kKJ)
      {
        d2 = Math.pow(this.kKJ - paramFloat1, 2.0D);
        if (Math.pow(this.kKJ + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.kKJ) {
      if (paramFloat2 < this.kKJ)
      {
        if (Math.pow(this.kKJ + paramFloat1 - f1, 2.0D) + Math.pow(this.kKJ - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kKJ)
      {
        d2 = Math.pow(this.kKJ + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.kKJ + paramFloat2 - f2, 2.0D) + d2 > d1)
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
    AppMethodBeat.i(187619);
    this.kKP = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.kKQ = paramString;
      kKO.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(187619);
      return;
    }
    kKO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(187619);
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
      if (paramClass.isAssignableFrom(this.atS.getClass()))
      {
        paramClass = this.atS;
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
  
  public boolean bkd()
  {
    return false;
  }
  
  public final void dP(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.kKR = paramInt2;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cC(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!G(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
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
    if ((this.kKK != null) && (this.kKK.length > 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.kKJ > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kKJ, this.kKJ, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kKL <= 0.0F) {
        break label320;
      }
      float f1 = this.kKL / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kKJ, this.kKJ, this.kKN);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kKJ > 0.0F)
      {
        f1 = f2;
        if (this.kKJ - this.kKL > 0.0F) {
          f1 = this.kKJ - this.kKL;
        }
      }
      localPath.addRoundRect(new RectF(this.kKL, this.kKL, getWidth() - this.kKL, getHeight() - this.kKL), f1, f1, Path.Direction.CW);
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(187621);
    ad.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.kKP)
    {
      localCoverViewContainer = this;
      if ((!this.kKP) && ((!this.kKS) || (!a(localCoverViewContainer, this)))) {}
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
            AppMethodBeat.o(187621);
            return true;
            if (this.kKR <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)kKO.get(Integer.valueOf(this.kKR));
            break;
            this.daO = paramMotionEvent.getRawX();
            this.daP = paramMotionEvent.getRawY();
            this.kKU = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer, paramMotionEvent);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.daO;
          f2 = paramMotionEvent.getRawY() - this.daP;
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
      this.daO = paramMotionEvent.getRawX();
      this.daP = paramMotionEvent.getRawY();
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
        long l = System.currentTimeMillis() - this.kKU;
        if ((this.kKU != 0L) && (l < 300L) && (l >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer, paramMotionEvent);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(187621);
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
    this.kKM = paramInt;
    this.kKN.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kKJ = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(187618);
    this.kKK = paramArrayOfFloat;
    if ((this.kKK != null) && (this.kKK.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(187618);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.kKL = paramFloat;
    this.kKN.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.kKT = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.kKX = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.kKS = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.atS = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */