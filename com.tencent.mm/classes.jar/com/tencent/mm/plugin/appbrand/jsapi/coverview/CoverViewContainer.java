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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements com.tencent.mm.plugin.appbrand.jsapi.aa.g
{
  private static HashMap<Integer, CoverViewContainer> kOd;
  private View atS;
  private float dbQ;
  private float dbR;
  private float kNY;
  private float[] kNZ;
  private float kOa;
  private int kOb;
  private Paint kOc;
  public boolean kOe;
  public String kOf;
  private int kOg;
  private boolean kOh;
  private String kOi;
  private long kOj;
  GradientDrawable kOk;
  float[] kOl;
  private a kOm;
  private int mBgColor;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(201193);
    kOd = new HashMap();
    AppMethodBeat.o(201193);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.kOc = new Paint();
    this.kOe = false;
    this.kOf = "";
    this.kOh = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.kOc = new Paint();
    this.kOe = false;
    this.kOf = "";
    this.kOh = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.kOc = new Paint();
    this.kOe = false;
    this.kOf = "";
    this.kOh = false;
    this.mScreenWidth = 0;
    this.mScreenHeight = 0;
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  private static JSONObject P(View paramView, int paramInt)
  {
    AppMethodBeat.i(201191);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("left", com.tencent.mm.plugin.appbrand.y.g.aI(paramView.getX()));
      localJSONObject.put("top", com.tencent.mm.plugin.appbrand.y.g.aI(paramView.getY()));
      AppMethodBeat.o(201191);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      AppMethodBeat.o(201191);
    }
    return null;
  }
  
  private void a(String paramString, CoverViewContainer paramCoverViewContainer, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201190);
    if (this.kOm != null) {
      this.kOm.a(paramString, paramCoverViewContainer.kOf, P(paramCoverViewContainer, paramCoverViewContainer.viewId), u(paramMotionEvent));
    }
    AppMethodBeat.o(201190);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(201189);
    if (paramViewGroup1 == paramViewGroup2)
    {
      AppMethodBeat.o(201189);
      return false;
    }
    int j = paramViewGroup1.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup1.getChildAt(i);
      if (localView == paramViewGroup2)
      {
        AppMethodBeat.o(201189);
        return true;
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramViewGroup2)))
      {
        AppMethodBeat.o(201189);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(201189);
    return false;
  }
  
  public static RectF cD(View paramView)
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
    AppMethodBeat.i(201184);
    if (this.mBgColor != 0) {
      this.kOk.setColor(this.mBgColor);
    }
    this.kOl[0] = this.kNZ[0];
    this.kOl[1] = this.kNZ[0];
    this.kOl[2] = this.kNZ[1];
    this.kOl[3] = this.kNZ[1];
    this.kOl[4] = this.kNZ[3];
    this.kOl[5] = this.kNZ[3];
    this.kOl[6] = this.kNZ[2];
    this.kOl[7] = this.kNZ[2];
    this.kOk.setCornerRadii(this.kOl);
    if ((this.kOa > 0.0F) && (this.kOb != 0)) {
      this.kOk.setStroke((int)this.kOa, this.kOb);
    }
    GradientDrawable localGradientDrawable = this.kOk;
    AppMethodBeat.o(201184);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.kOc.setStyle(Paint.Style.STROKE);
    this.kOc.setAntiAlias(true);
    setWillNotDraw(false);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    AppMethodBeat.o(140661);
  }
  
  public static void tf(int paramInt)
  {
    AppMethodBeat.i(201187);
    kOd.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(201187);
  }
  
  private JSONObject u(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201192);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", this.viewId);
      localJSONObject.put("x", com.tencent.mm.plugin.appbrand.y.g.aI(paramMotionEvent.getRawX()));
      localJSONObject.put("y", com.tencent.mm.plugin.appbrand.y.g.aI(paramMotionEvent.getRawY()));
      AppMethodBeat.o(201192);
      return localJSONObject;
    }
    catch (JSONException paramMotionEvent)
    {
      AppMethodBeat.o(201192);
    }
    return null;
  }
  
  protected final boolean G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.kNY <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.kNY, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.kNY)
    {
      if (paramFloat2 < this.kNY)
      {
        if (Math.pow(this.kNY - paramFloat1, 2.0D) + Math.pow(this.kNY - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kNY)
      {
        d2 = Math.pow(this.kNY - paramFloat1, 2.0D);
        if (Math.pow(this.kNY + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.kNY) {
      if (paramFloat2 < this.kNY)
      {
        if (Math.pow(this.kNY + paramFloat1 - f1, 2.0D) + Math.pow(this.kNY - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.kNY)
      {
        d2 = Math.pow(this.kNY + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.kNY + paramFloat2 - f2, 2.0D) + d2 > d1)
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
    AppMethodBeat.i(201186);
    this.kOe = paramBoolean;
    this.viewId = paramInt;
    if (paramBoolean)
    {
      this.kOf = paramString;
      kOd.put(Integer.valueOf(paramInt), this);
      AppMethodBeat.o(201186);
      return;
    }
    kOd.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(201186);
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
  
  public boolean bkM()
  {
    return false;
  }
  
  public final void dP(int paramInt1, int paramInt2)
  {
    this.viewId = paramInt1;
    this.kOg = paramInt2;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cD(this).contains(f1, f2);
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
    if ((this.kNZ != null) && (this.kNZ.length > 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(140662);
      return;
    }
    int i;
    if (this.kNY > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kNY, this.kNY, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kOa <= 0.0F) {
        break label320;
      }
      float f1 = this.kOa / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kNY, this.kNY, this.kOc);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kNY > 0.0F)
      {
        f1 = f2;
        if (this.kNY - this.kOa > 0.0F) {
          f1 = this.kNY - this.kOa;
        }
      }
      localPath.addRoundRect(new RectF(this.kOa, this.kOa, getWidth() - this.kOa, getHeight() - this.kOa), f1, f1, Path.Direction.CW);
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
    AppMethodBeat.i(201188);
    ae.d("MicroMsg.CoverViewContainer", "event: " + paramMotionEvent.getAction());
    CoverViewContainer localCoverViewContainer = null;
    int m;
    int k;
    int i;
    if (this.kOe)
    {
      localCoverViewContainer = this;
      if ((!this.kOe) && ((!this.kOh) || (!a(localCoverViewContainer, this)))) {}
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
            AppMethodBeat.o(201188);
            return true;
            if (this.kOg <= 0) {
              break;
            }
            localCoverViewContainer = (CoverViewContainer)kOd.get(Integer.valueOf(this.kOg));
            break;
            this.dbQ = paramMotionEvent.getRawX();
            this.dbR = paramMotionEvent.getRawY();
            this.kOj = System.currentTimeMillis();
            if (localCoverViewContainer != null) {
              a("start", localCoverViewContainer, paramMotionEvent);
            }
          }
          f1 = paramMotionEvent.getRawX() - this.dbQ;
          f2 = paramMotionEvent.getRawY() - this.dbR;
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
      this.dbQ = paramMotionEvent.getRawX();
      this.dbR = paramMotionEvent.getRawY();
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
        long l = System.currentTimeMillis() - this.kOj;
        if ((this.kOj != 0L) && (l < 300L) && (l >= 0L) && (this.mOnClickListener != null)) {
          this.mOnClickListener.onClick(this);
        }
        if (localCoverViewContainer == null) {
          break;
        }
        a("end", localCoverViewContainer, paramMotionEvent);
        break;
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(201188);
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
    this.kOb = paramInt;
    this.kOc.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kNY = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(201185);
    this.kNZ = paramArrayOfFloat;
    if ((this.kNZ != null) && (this.kNZ.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(201185);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.kOa = paramFloat;
    this.kOc.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setDragConfig(String paramString)
  {
    this.kOi = paramString;
  }
  
  public void setDragEventCallback(a parama)
  {
    this.kOm = parama;
  }
  
  public void setIsInterceptEvent(boolean paramBoolean)
  {
    this.kOh = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */