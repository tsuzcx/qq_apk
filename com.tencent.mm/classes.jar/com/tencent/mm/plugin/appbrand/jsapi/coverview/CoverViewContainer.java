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
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements com.tencent.mm.plugin.appbrand.jsapi.ae.g, cc
{
  private static HashMap<Integer, CoverViewContainer> oPE;
  private View alI;
  private float flk;
  private float fll;
  private float jAh;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private float oPA;
  private float[] oPB;
  private int oPC;
  private Paint oPD;
  public boolean oPF;
  public String oPG;
  private int oPH;
  private boolean oPI;
  private String oPJ;
  private long oPK;
  GradientDrawable oPL;
  float[] oPM;
  private a oPN;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(208887);
    oPE = new HashMap();
    AppMethodBeat.o(208887);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.oPD = new Paint();
    this.oPF = false;
    this.oPG = "";
    this.oPI = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.oPL = new GradientDrawable();
    this.oPM = new float[8];
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.oPD = new Paint();
    this.oPF = false;
    this.oPG = "";
    this.oPI = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.oPL = new GradientDrawable();
    this.oPM = new float[8];
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.oPD = new Paint();
    this.oPF = false;
    this.oPG = "";
    this.oPI = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.oPL = new GradientDrawable();
    this.oPM = new float[8];
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  public static void Ar(int paramInt)
  {
    AppMethodBeat.i(208876);
    oPE.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(208876);
  }
  
  private static JSONObject P(View paramView, int paramInt)
  {
    AppMethodBeat.i(208885);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", com.tencent.mm.plugin.appbrand.ac.g.aT(paramView.getX()));
      localJSONObject.put("top", com.tencent.mm.plugin.appbrand.ac.g.aT(paramView.getY()));
      AppMethodBeat.o(208885);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(208885);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208884);
    if (this.oPN != null) {
      this.oPN.a(paramString, paramCoverViewContainer.oPG, P(paramCoverViewContainer, paramCoverViewContainer.viewId), z(paramMotionEvent));
    }
    AppMethodBeat.o(208884);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(208883);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(208883);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(208883);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(208883);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(208883);
    return false;
  }
  
  public static RectF cN(View paramView)
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
    AppMethodBeat.i(208864);
    if (this.mBgColor != 0) {
      this.oPL.setColor(this.mBgColor);
    }
    this.oPM[0] = this.oPB[0];
    this.oPM[1] = this.oPB[0];
    this.oPM[2] = this.oPB[1];
    this.oPM[3] = this.oPB[1];
    this.oPM[4] = this.oPB[3];
    this.oPM[5] = this.oPB[3];
    this.oPM[6] = this.oPB[2];
    this.oPM[7] = this.oPB[2];
    this.oPL.setCornerRadii(this.oPM);
    if ((this.jAh > 0.0F) && (this.oPC != 0)) {
      this.oPL.setStroke((int)this.jAh, this.oPC);
    }
    GradientDrawable localGradientDrawable = this.oPL;
    AppMethodBeat.o(208864);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.oPD.setStyle(Paint.Style.STROKE);
    this.oPD.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    AppMethodBeat.o(140661);
  }
  
  private JSONObject z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208886);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.viewId);
      localJSONObject.put("x", com.tencent.mm.plugin.appbrand.ac.g.aT(paramMotionEvent.getRawX()));
      localJSONObject.put("y", com.tencent.mm.plugin.appbrand.ac.g.aT(paramMotionEvent.getRawY()));
      AppMethodBeat.o(208886);
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      AppMethodBeat.o(208886);
    }
    return null;
  }
  
  protected final boolean L(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.oPA <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.oPA, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.oPA)
    {
      if (paramFloat2 < this.oPA)
      {
        if (Math.pow(this.oPA - paramFloat1, 2.0D) + Math.pow(this.oPA - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.oPA)
      {
        d2 = Math.pow(this.oPA - paramFloat1, 2.0D);
        if (Math.pow(this.oPA + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.oPA) {
      if (paramFloat2 < this.oPA)
      {
        if (Math.pow(this.oPA + paramFloat1 - f1, 2.0D) + Math.pow(this.oPA - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.oPA)
      {
        d2 = Math.pow(this.oPA + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.oPA + paramFloat2 - f2, 2.0D) + d2 > d1)
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
    AppMethodBeat.i(208875);
    this.oPF = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.oPG = paramString;
      oPE.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(208875);
      return;
    }
    oPE.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(208875);
  }
  
  public final <T> T aA(Class<T> paramClass)
  {
    AppMethodBeat.i(140663);
    try
    {
      if (paramClass.isAssignableFrom(this.alI.getClass()))
      {
        paramClass = this.alI;
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
  
  public boolean bRT()
  {
    return false;
  }
  
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(208860);
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(208860);
      return true;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0.0F, 0.0F, getWidth(), getHeight());
    draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(208860);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cN(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!L(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
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
    if ((this.oPB != null) && (this.oPB.length > 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.oPA > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.oPA, this.oPA, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.jAh <= 0.0F) {
        break label320;
      }
      float f1 = this.jAh / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.oPA, this.oPA, this.oPD);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.oPA > 0.0F)
      {
        f1 = f2;
        if (this.oPA - this.jAh > 0.0F) {
          f1 = this.oPA - this.jAh;
        }
      }
      localPath.addRoundRect(new RectF(this.jAh, this.jAh, getWidth() - this.jAh, getHeight() - this.jAh), f1, f1, Path.Direction.CW);
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
  
  public final void ez(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.oPH = paramInt2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(208880);
    Log.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.oPF)
    {
      localCoverViewContainer = this;
      if ((!this.oPF) && ((!this.oPI) || (!a(localCoverViewContainer, this)))) {}
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
            AppMethodBeat.o(208880);
            return true;
            if (this.oPH <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)oPE.get(Integer.valueOf(this.oPH));
            break;
            this.flk = paramMotionEvent.getRawX();
            this.fll = paramMotionEvent.getRawY();
            this.oPK = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer, paramMotionEvent);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.flk;
          f2 = paramMotionEvent.getRawY() - this.fll;
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
      this.flk = paramMotionEvent.getRawX();
      this.fll = paramMotionEvent.getRawY();
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
        long l = System.currentTimeMillis() - this.oPK;
        if ((this.oPK != 0L) && (l < 300L) && (l >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer, paramMotionEvent);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(208880);
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
    this.oPC = paramInt;
    this.oPD.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.oPA = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(208868);
    this.oPB = paramArrayOfFloat;
    if ((this.oPB != null) && (this.oPB.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(208868);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.jAh = paramFloat;
    this.oPD.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.oPJ = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.oPN = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.oPI = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.alI = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */