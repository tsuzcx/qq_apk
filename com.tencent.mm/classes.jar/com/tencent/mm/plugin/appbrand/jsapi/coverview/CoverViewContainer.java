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
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.ah.g;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.page.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements g, cg
{
  private static HashMap<Integer, CoverViewContainer> rTs;
  private View cai;
  private float hpx;
  private float hpy;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  float[] rTA;
  private a rTB;
  private float rTn;
  private float[] rTo;
  private float rTp;
  private int rTq;
  private Paint rTr;
  public boolean rTt;
  public String rTu;
  private int rTv;
  private boolean rTw;
  private String rTx;
  private long rTy;
  GradientDrawable rTz;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(327333);
    rTs = new HashMap();
    AppMethodBeat.o(327333);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.rTr = new Paint();
    this.rTt = false;
    this.rTu = "";
    this.rTw = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.rTr = new Paint();
    this.rTt = false;
    this.rTu = "";
    this.rTw = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.rTr = new Paint();
    this.rTt = false;
    this.rTu = "";
    this.rTw = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  public static void AI(int paramInt)
  {
    AppMethodBeat.i(327312);
    rTs.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(327312);
  }
  
  private static JSONObject U(View paramView, int paramInt)
  {
    AppMethodBeat.i(327324);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", i.bV(paramView.getX()));
      localJSONObject.put("top", i.bV(paramView.getY()));
      AppMethodBeat.o(327324);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(327324);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(327320);
    if (this.rTB != null) {
      this.rTB.a(paramString, paramCoverViewContainer.rTu, U(paramCoverViewContainer, paramCoverViewContainer.viewId), z(paramMotionEvent));
    }
    AppMethodBeat.o(327320);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(327316);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(327316);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(327316);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(327316);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(327316);
    return false;
  }
  
  public static RectF dv(View paramView)
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
    AppMethodBeat.i(327308);
    if (this.mBgColor != 0) {
      this.rTz.setColor(this.mBgColor);
    }
    this.rTA[0] = this.rTo[0];
    this.rTA[1] = this.rTo[0];
    this.rTA[2] = this.rTo[1];
    this.rTA[3] = this.rTo[1];
    this.rTA[4] = this.rTo[3];
    this.rTA[5] = this.rTo[3];
    this.rTA[6] = this.rTo[2];
    this.rTA[7] = this.rTo[2];
    this.rTz.setCornerRadii(this.rTA);
    if ((this.rTp > 0.0F) && (this.rTq != 0)) {
      this.rTz.setStroke((int)this.rTp, this.rTq);
    }
    GradientDrawable localGradientDrawable = this.rTz;
    AppMethodBeat.o(327308);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.rTr.setStyle(Paint.Style.STROKE);
    this.rTr.setAntiAlias(true);
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
    AppMethodBeat.i(327329);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.viewId);
      localJSONObject.put("x", i.bV(paramMotionEvent.getRawX()));
      localJSONObject.put("y", i.bV(paramMotionEvent.getRawY()));
      AppMethodBeat.o(327329);
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      AppMethodBeat.o(327329);
    }
    return null;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(327379);
    this.rTt = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.rTu = paramString;
      rTs.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(327379);
      return;
    }
    rTs.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(327379);
  }
  
  public final <T> T aT(Class<T> paramClass)
  {
    AppMethodBeat.i(140663);
    try
    {
      if (paramClass.isAssignableFrom(this.cai.getClass()))
      {
        paramClass = this.cai;
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
  
  protected final boolean ap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.rTn <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.rTn, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.rTn)
    {
      if (paramFloat2 < this.rTn)
      {
        if (Math.pow(this.rTn - paramFloat1, 2.0D) + Math.pow(this.rTn - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.rTn)
      {
        d2 = Math.pow(this.rTn - paramFloat1, 2.0D);
        if (Math.pow(this.rTn + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.rTn) {
      if (paramFloat2 < this.rTn)
      {
        if (Math.pow(this.rTn + paramFloat1 - f1, 2.0D) + Math.pow(this.rTn - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.rTn)
      {
        d2 = Math.pow(this.rTn + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.rTn + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    AppMethodBeat.o(140669);
    return true;
  }
  
  public boolean crX()
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = dv(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!ap(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
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
    if ((this.rTo != null) && (this.rTo.length > 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.rTn > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.rTn, this.rTn, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.rTp <= 0.0F) {
        break label320;
      }
      float f1 = this.rTp / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.rTn, this.rTn, this.rTr);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.rTn > 0.0F)
      {
        f1 = f2;
        if (this.rTn - this.rTp > 0.0F) {
          f1 = this.rTn - this.rTp;
        }
      }
      localPath.addRoundRect(new RectF(this.rTp, this.rTp, getWidth() - this.rTp, getHeight() - this.rTp), f1, f1, Path.Direction.CW);
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
  
  public final void ft(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.rTv = paramInt2;
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(327339);
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(327339);
      return true;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0.0F, 0.0F, getWidth(), getHeight());
    draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(327339);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(327403);
    Log.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.rTt)
    {
      localCoverViewContainer = this;
      if ((!this.rTt) && ((!this.rTw) || (!a(localCoverViewContainer, this)))) {}
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
            AppMethodBeat.o(327403);
            return true;
            if (this.rTv <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)rTs.get(Integer.valueOf(this.rTv));
            break;
            this.hpx = paramMotionEvent.getRawX();
            this.hpy = paramMotionEvent.getRawY();
            this.rTy = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer, paramMotionEvent);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.hpx;
          f2 = paramMotionEvent.getRawY() - this.hpy;
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
      this.hpx = paramMotionEvent.getRawX();
      this.hpy = paramMotionEvent.getRawY();
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
        long l = System.currentTimeMillis() - this.rTy;
        if ((this.rTy != 0L) && (l < 300L) && (l >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer, paramMotionEvent);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(327403);
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
    this.rTq = paramInt;
    this.rTr.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.rTn = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(327357);
    this.rTo = paramArrayOfFloat;
    if ((this.rTo != null) && (this.rTo.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(327357);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.rTp = paramFloat;
    this.rTr.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.rTx = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.rTB = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.rTw = paramBoolean;
  }
  
  public void setOnCustomerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.cai = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */