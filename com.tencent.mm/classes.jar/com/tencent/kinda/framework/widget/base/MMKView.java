package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KRect;
import com.tencent.kinda.gen.KSize;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.kinda.gen.Visible;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidKRectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMKView<T extends View>
  extends ViewBase
  implements MMKViewBase<T>, KView
{
  public static final String TAG = "base_MMKView";
  protected DynamicColor backgroundColor;
  private Drawable backgroundDrawable;
  protected DynamicColor borderColor;
  protected DynamicColor borderPressedColor;
  protected float borderRadius;
  protected float borderWidth;
  private float bottomLeftBorderRadius;
  private float bottomRightBorderRadius;
  private String id;
  private MMKViewBackgroundBorderDrawable internalDrawable;
  private boolean isHighlight;
  private boolean isSecure;
  private KViewAnimatorProxy mAnimatorProxy;
  protected Context mContext;
  private KViewOnClickCallback onClickCallback;
  private KViewOnLongClickCallback onLongClickCallback;
  private KViewOnTouchCallback onTouchCallback;
  protected DynamicColor shadowColor;
  protected float shadowOffset;
  protected float shadowRadius;
  private DynamicColor tmpSaveBgColor;
  private float topLeftBorderRadius;
  private float topRightBorderRadius;
  private WeakReference<UIPagePlatformDelegateImpl> uiPageDelegate;
  protected T view;
  
  public MMKView()
  {
    AppMethodBeat.i(19126);
    this.borderColor = new DynamicColor(0L, 0L);
    this.borderPressedColor = new DynamicColor(0L, 0L);
    this.backgroundColor = new DynamicColor(0L, 0L);
    this.topLeftBorderRadius = 0.0F;
    this.topRightBorderRadius = 0.0F;
    this.bottomLeftBorderRadius = 0.0F;
    this.bottomRightBorderRadius = 0.0F;
    this.shadowColor = new DynamicColor(0L, 0L);
    this.mAnimatorProxy = new KViewAnimatorProxy(this);
    AppMethodBeat.o(19126);
  }
  
  private MMKViewBackgroundBorderDrawable checkIfNeedCreateBorderDrawable()
  {
    AppMethodBeat.i(19127);
    if (this.internalDrawable == null) {
      this.internalDrawable = new MMKViewBackgroundBorderDrawable(getView());
    }
    MMKViewBackgroundBorderDrawable localMMKViewBackgroundBorderDrawable = this.internalDrawable;
    AppMethodBeat.o(19127);
    return localMMKViewBackgroundBorderDrawable;
  }
  
  private boolean isViewLayout()
  {
    AppMethodBeat.i(19245);
    View localView = getView();
    if (localView == null)
    {
      AppMethodBeat.o(19245);
      return false;
    }
    if ((localView.getLeft() != 0) || (localView.getTop() != 0) || (localView.getRight() != 0) || (localView.getBottom() != 0))
    {
      AppMethodBeat.o(19245);
      return true;
    }
    AppMethodBeat.o(19245);
    return false;
  }
  
  private void removeYogaNode()
  {
    AppMethodBeat.i(19224);
    if (node().getParent() != null)
    {
      int i = node().getParent().indexOf(node());
      node().getParent().removeChildAt(i);
    }
    AppMethodBeat.o(19224);
  }
  
  private void resumeYogaNode()
  {
    AppMethodBeat.i(19225);
    if (node().getParent() != null)
    {
      AppMethodBeat.o(19225);
      return;
    }
    if ((getView().getParent() != null) && ((getView().getParent() instanceof YogaLayout)))
    {
      YogaLayout localYogaLayout = (YogaLayout)getView().getParent();
      int i = localYogaLayout.indexOfChild(getView());
      localYogaLayout.getYogaNode().addChildAt(node(), i);
    }
    AppMethodBeat.o(19225);
  }
  
  public void addBlurEffect(int paramInt) {}
  
  public KPoint convertPointToScreen(KPoint paramKPoint)
  {
    AppMethodBeat.i(19244);
    paramKPoint = convertPointToView(paramKPoint, null);
    AppMethodBeat.o(19244);
    return paramKPoint;
  }
  
  public KPoint convertPointToView(KPoint paramKPoint, KView paramKView)
  {
    AppMethodBeat.i(19243);
    if ((paramKPoint == null) || (getView() == null) || (getView().getContext() == null))
    {
      Log.e("base_MMKView", "%s call convertPointToView params illegal! point: %s, getView(): %s.", new Object[] { this, paramKPoint, getView() });
      paramKPoint = new KPoint(0.0F, 0.0F);
      AppMethodBeat.o(19243);
      return paramKPoint;
    }
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getView().getLocationOnScreen(arrayOfInt1);
    if (paramKView == null) {
      arrayOfInt2[1] = ar.getStatusBarHeight(getView().getContext());
    }
    for (;;)
    {
      paramKPoint = new KPoint(MMKViewUtil.pxToDp(getView().getContext(), arrayOfInt1[0] - arrayOfInt2[0] + paramKPoint.mX), MMKViewUtil.pxToDp(getView().getContext(), arrayOfInt1[1] - arrayOfInt2[1] + paramKPoint.mY));
      AppMethodBeat.o(19243);
      return paramKPoint;
      ((MMKView)paramKView).getView().getLocationOnScreen(arrayOfInt2);
    }
  }
  
  public T createView(Context paramContext)
  {
    AppMethodBeat.i(19128);
    paramContext = new View(paramContext);
    AppMethodBeat.o(19128);
    return paramContext;
  }
  
  public String getAccessibilityString()
  {
    AppMethodBeat.i(19242);
    if (getView().getContentDescription() == null)
    {
      AppMethodBeat.o(19242);
      return "";
    }
    String str = (String)getView().getContentDescription();
    AppMethodBeat.o(19242);
    return str;
  }
  
  public boolean getAccessible()
  {
    return false;
  }
  
  public Align getAlignSelf()
  {
    AppMethodBeat.i(19137);
    Align localAlign = this.flexAttr.getAlignSelf();
    AppMethodBeat.o(19137);
    return localAlign;
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(19166);
    float f = getView().getAlpha();
    AppMethodBeat.o(19166);
    return f;
  }
  
  public float getAspectRatio()
  {
    AppMethodBeat.i(19159);
    float f = this.flexAttr.getAspectRatio();
    AppMethodBeat.o(19159);
    return f;
  }
  
  public DynamicColor getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public DynamicColor getBorderColor()
  {
    return this.borderColor;
  }
  
  public DynamicColor getBorderPressedColor()
  {
    return this.borderPressedColor;
  }
  
  public float getBorderWidth()
  {
    return this.borderWidth;
  }
  
  public float getBottom()
  {
    AppMethodBeat.i(19149);
    if (isViewLayout())
    {
      f = MMKViewUtil.pxToDp(getView().getContext(), getView().getBottom());
      AppMethodBeat.o(19149);
      return f;
    }
    float f = this.flexAttr.getBottom();
    AppMethodBeat.o(19149);
    return f;
  }
  
  public float getBottomLeftCornerRadius()
  {
    return this.bottomLeftBorderRadius;
  }
  
  public float getBottomPercent()
  {
    return 0.0F;
  }
  
  public float getBottomRightCornerRadius()
  {
    return this.bottomRightBorderRadius;
  }
  
  public boolean getClickable()
  {
    AppMethodBeat.i(19222);
    boolean bool = getView().isClickable();
    AppMethodBeat.o(19222);
    return bool;
  }
  
  public float getCornerRadius()
  {
    return this.borderRadius;
  }
  
  public boolean getEnableHighLight()
  {
    return this.isHighlight;
  }
  
  public float getFlexBasis()
  {
    AppMethodBeat.i(19139);
    float f = this.flexAttr.getFlexBasis();
    AppMethodBeat.o(19139);
    return f;
  }
  
  public float getFlexGrow()
  {
    AppMethodBeat.i(19161);
    float f = this.flexAttr.getFlexGrow();
    AppMethodBeat.o(19161);
    return f;
  }
  
  public float getFlexShrink()
  {
    AppMethodBeat.i(19163);
    float f = this.flexAttr.getFlexShrink();
    AppMethodBeat.o(19163);
    return f;
  }
  
  public float getFrameOriginX()
  {
    AppMethodBeat.i(264159);
    if ((getView() == null) || (getView().getContext() == null))
    {
      Log.e("base_MMKView", "%s call convertPointToView params illegal!, getView(): %s.", new Object[] { this, getView() });
      AppMethodBeat.o(264159);
      return 0.0F;
    }
    Log.i("base_MMKView", " get getFrameOriginX getView().getLeft(): %s.", new Object[] { Integer.valueOf(getView().getLeft()) });
    float f = a.H(getView().getContext(), getView().getLeft());
    AppMethodBeat.o(264159);
    return f;
  }
  
  public float getFrameOriginY()
  {
    AppMethodBeat.i(264160);
    if ((getView() == null) || (getView().getContext() == null))
    {
      Log.e("base_MMKView", "%s call convertPointToView params illegal!, getView(): %s.", new Object[] { this, getView() });
      AppMethodBeat.o(264160);
      return 0.0F;
    }
    Log.i("base_MMKView", " get getFrameOriginY getView().getTop(): %s.", new Object[] { Integer.valueOf(getView().getTop()) });
    float f = a.H(getView().getContext(), getView().getTop());
    AppMethodBeat.o(264160);
    return f;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(19135);
    float f = this.flexAttr.getHeight();
    AppMethodBeat.o(19135);
    return f;
  }
  
  public float getHeightPercent()
  {
    AppMethodBeat.i(19187);
    float f = this.flexAttr.getHeightPercent();
    AppMethodBeat.o(19187);
    return f;
  }
  
  public boolean getIsRefreshing()
  {
    return false;
  }
  
  public float getLeft()
  {
    AppMethodBeat.i(19143);
    if (isViewLayout())
    {
      f = MMKViewUtil.pxToDp(getView().getContext(), getView().getLeft());
      AppMethodBeat.o(19143);
      return f;
    }
    float f = this.flexAttr.getLeft();
    AppMethodBeat.o(19143);
    return f;
  }
  
  public float getLeftPercent()
  {
    AppMethodBeat.i(19178);
    float f = this.flexAttr.getLeftPercent();
    AppMethodBeat.o(19178);
    return f;
  }
  
  public float getMarginBottom()
  {
    AppMethodBeat.i(19211);
    float f = this.flexAttr.getMarginBottom();
    AppMethodBeat.o(19211);
    return f;
  }
  
  public float getMarginBottomPercent()
  {
    AppMethodBeat.i(19195);
    float f = this.flexAttr.getMarginBottomPercent();
    AppMethodBeat.o(19195);
    return f;
  }
  
  public float getMarginLeft()
  {
    AppMethodBeat.i(19205);
    float f = this.flexAttr.getMarginLeft();
    AppMethodBeat.o(19205);
    return f;
  }
  
  public float getMarginLeftPercent()
  {
    AppMethodBeat.i(19189);
    float f = this.flexAttr.getMarginLeftPercent();
    AppMethodBeat.o(19189);
    return f;
  }
  
  public float getMarginRight()
  {
    AppMethodBeat.i(19209);
    float f = this.flexAttr.getMarginRight();
    AppMethodBeat.o(19209);
    return f;
  }
  
  public float getMarginRightPercent()
  {
    AppMethodBeat.i(19193);
    float f = this.flexAttr.getMarginRightPercent();
    AppMethodBeat.o(19193);
    return f;
  }
  
  public float getMarginTop()
  {
    AppMethodBeat.i(19207);
    float f = this.flexAttr.getMarginTop();
    AppMethodBeat.o(19207);
    return f;
  }
  
  public float getMarginTopPercent()
  {
    AppMethodBeat.i(19191);
    float f = this.flexAttr.getMarginTopPercent();
    AppMethodBeat.o(19191);
    return f;
  }
  
  public float getMaxHeight()
  {
    AppMethodBeat.i(19157);
    float f = this.flexAttr.getMaxHeight();
    AppMethodBeat.o(19157);
    return f;
  }
  
  public float getMaxWidth()
  {
    AppMethodBeat.i(19153);
    float f = this.flexAttr.getMaxWidth();
    AppMethodBeat.o(19153);
    return f;
  }
  
  public float getMinHeight()
  {
    AppMethodBeat.i(19155);
    float f = this.flexAttr.getMinHeight();
    AppMethodBeat.o(19155);
    return f;
  }
  
  public float getMinWidth()
  {
    AppMethodBeat.i(19151);
    float f = this.flexAttr.getMinWidth();
    AppMethodBeat.o(19151);
    return f;
  }
  
  public KViewOnClickCallback getOnClickCallback()
  {
    return this.onClickCallback;
  }
  
  public float getPaddingBottom()
  {
    AppMethodBeat.i(19219);
    float f = this.flexAttr.getPaddingBottom();
    AppMethodBeat.o(19219);
    return f;
  }
  
  public float getPaddingBottomPercent()
  {
    AppMethodBeat.i(19203);
    float f = this.flexAttr.getPaddingBottomPercent();
    AppMethodBeat.o(19203);
    return f;
  }
  
  public float getPaddingLeft()
  {
    AppMethodBeat.i(19213);
    float f = this.flexAttr.getPaddingLeft();
    AppMethodBeat.o(19213);
    return f;
  }
  
  public float getPaddingLeftPercent()
  {
    AppMethodBeat.i(19197);
    float f = this.flexAttr.getPaddingLeftPercent();
    AppMethodBeat.o(19197);
    return f;
  }
  
  public float getPaddingRight()
  {
    AppMethodBeat.i(19217);
    float f = this.flexAttr.getPaddingRight();
    AppMethodBeat.o(19217);
    return f;
  }
  
  public float getPaddingRightPercent()
  {
    AppMethodBeat.i(19201);
    float f = this.flexAttr.getPaddingRightPercent();
    AppMethodBeat.o(19201);
    return f;
  }
  
  public float getPaddingTop()
  {
    AppMethodBeat.i(19215);
    float f = this.flexAttr.getPaddingTop();
    AppMethodBeat.o(19215);
    return f;
  }
  
  public float getPaddingTopPercent()
  {
    AppMethodBeat.i(19199);
    float f = this.flexAttr.getPaddingTopPercent();
    AppMethodBeat.o(19199);
    return f;
  }
  
  public PositionType getPositionType()
  {
    AppMethodBeat.i(19141);
    PositionType localPositionType = this.flexAttr.getPositionType();
    AppMethodBeat.o(19141);
    return localPositionType;
  }
  
  public float getRight()
  {
    AppMethodBeat.i(19147);
    if (isViewLayout())
    {
      f = MMKViewUtil.pxToDp(getView().getContext(), getView().getRight());
      AppMethodBeat.o(19147);
      return f;
    }
    float f = this.flexAttr.getRight();
    AppMethodBeat.o(19147);
    return f;
  }
  
  public float getRightPercent()
  {
    AppMethodBeat.i(19182);
    float f = this.flexAttr.getRightPercent();
    AppMethodBeat.o(19182);
    return f;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(19172);
    float f = getView().getRotation();
    AppMethodBeat.o(19172);
    return f;
  }
  
  public float getScaleX()
  {
    AppMethodBeat.i(19174);
    float f = getView().getScaleX();
    AppMethodBeat.o(19174);
    return f;
  }
  
  public float getScaleY()
  {
    AppMethodBeat.i(19176);
    float f = getView().getScaleY();
    AppMethodBeat.o(19176);
    return f;
  }
  
  public boolean getSecure()
  {
    return this.isSecure;
  }
  
  public DynamicColor getShadowColor()
  {
    return this.shadowColor;
  }
  
  public float getShadowOffset()
  {
    return 0.0F;
  }
  
  public float getShadowRadius()
  {
    return 0.0F;
  }
  
  public float getTop()
  {
    AppMethodBeat.i(19145);
    if (isViewLayout())
    {
      f = MMKViewUtil.pxToDp(getView().getContext(), getView().getTop());
      AppMethodBeat.o(19145);
      return f;
    }
    float f = this.flexAttr.getTop();
    AppMethodBeat.o(19145);
    return f;
  }
  
  public float getTopLeftCornerRadius()
  {
    return this.topLeftBorderRadius;
  }
  
  public float getTopPercent()
  {
    AppMethodBeat.i(19180);
    float f = this.flexAttr.getTopPercent();
    AppMethodBeat.o(19180);
    return f;
  }
  
  public float getTopRightCornerRadius()
  {
    return this.topRightBorderRadius;
  }
  
  public float getTranslateX()
  {
    AppMethodBeat.i(19168);
    float f = getView().getTranslationX();
    AppMethodBeat.o(19168);
    return f;
  }
  
  public float getTranslateY()
  {
    AppMethodBeat.i(19170);
    float f = getView().getTranslationY();
    AppMethodBeat.o(19170);
    return f;
  }
  
  public final T getView()
  {
    return this.view;
  }
  
  public String getViewId()
  {
    AppMethodBeat.i(19131);
    if (Util.isNullOrNil(this.id))
    {
      AppMethodBeat.o(19131);
      return "";
    }
    String str = this.id;
    AppMethodBeat.o(19131);
    return str;
  }
  
  public Visible getVisible()
  {
    AppMethodBeat.i(19226);
    switch (getView().getVisibility())
    {
    default: 
      localVisible = Visible.VISIBLE;
      AppMethodBeat.o(19226);
      return localVisible;
    case 0: 
      localVisible = Visible.VISIBLE;
      AppMethodBeat.o(19226);
      return localVisible;
    case 4: 
      localVisible = Visible.INVISIBLE;
      AppMethodBeat.o(19226);
      return localVisible;
    }
    Visible localVisible = Visible.GONE;
    AppMethodBeat.o(19226);
    return localVisible;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(19133);
    float f = this.flexAttr.getWidth();
    AppMethodBeat.o(19133);
    return f;
  }
  
  public float getWidthPercent()
  {
    AppMethodBeat.i(19185);
    float f = this.flexAttr.getWidthPercent();
    AppMethodBeat.o(19185);
    return f;
  }
  
  public final void initWithPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
  {
    AppMethodBeat.i(19129);
    if ((paramIUIPagePlatformDelegate instanceof UIPagePlatformDelegateImpl))
    {
      this.uiPageDelegate = new WeakReference((UIPagePlatformDelegateImpl)paramIUIPagePlatformDelegate);
      paramIUIPagePlatformDelegate = ((UIPagePlatformDelegateImpl)paramIUIPagePlatformDelegate).getContext();
      if (paramIUIPagePlatformDelegate != null) {
        setView(createView(paramIUIPagePlatformDelegate));
      }
      this.mContext = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(19129);
  }
  
  protected void notifyChanged()
  {
    AppMethodBeat.i(19239);
    if ((node().isMeasureDefined()) && (!node().isDirty())) {
      node().dirty();
    }
    getView().requestLayout();
    AppMethodBeat.o(19239);
  }
  
  protected void onFlexAttribute()
  {
    AppMethodBeat.i(19240);
    notifyChanged();
    AppMethodBeat.o(19240);
  }
  
  public void removeBlurEffect() {}
  
  public void requestFrameImpl(final VoidKRectCallback paramVoidKRectCallback)
  {
    AppMethodBeat.i(264163);
    this.view.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(263971);
        KRect localKRect = new KRect();
        localKRect.mOrigin = new KPoint();
        localKRect.mSize = new KSize();
        localKRect.mOrigin.mX = MMKView.this.view.getLeft();
        localKRect.mOrigin.mY = MMKView.this.view.getTop();
        localKRect.mSize.mWidth = MMKView.this.view.getWidth();
        localKRect.mSize.mHeight = MMKView.this.view.getHeight();
        paramVoidKRectCallback.call(localKRect);
        AppMethodBeat.o(263971);
      }
    });
    AppMethodBeat.o(264163);
  }
  
  public void requestLayout() {}
  
  public void setAccessibilityString(String paramString)
  {
    AppMethodBeat.i(19241);
    getView().setContentDescription(paramString);
    AppMethodBeat.o(19241);
  }
  
  public void setAccessible(boolean paramBoolean) {}
  
  public void setAlignSelf(Align paramAlign)
  {
    AppMethodBeat.i(19136);
    this.flexAttr.setAlignSelf(paramAlign);
    AppMethodBeat.o(19136);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(19165);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setAlpha(paramFloat);
      AppMethodBeat.o(19165);
      return;
    }
    getView().setAlpha(paramFloat);
    AppMethodBeat.o(19165);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    AppMethodBeat.i(19158);
    this.flexAttr.setAspectRatio(paramFloat);
    AppMethodBeat.o(19158);
  }
  
  public void setBackgroundColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19220);
    if (KindaGlobalAnimator.hasAnimate())
    {
      Log.d("base_MMKView", "进入动画setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(ColorUtil.getColorByMode(paramDynamicColor))));
      this.mAnimatorProxy.setBackgroundColor(paramDynamicColor);
      AppMethodBeat.o(19220);
      return;
    }
    Log.d("base_MMKView", "进入View设置属性的setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(ColorUtil.getColorByMode(paramDynamicColor))));
    this.backgroundColor = paramDynamicColor;
    if (ColorUtil.getColorByMode(this.backgroundColor) >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBackgroundColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.backgroundColor)));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(19220);
  }
  
  public void setBorderColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19228);
    this.borderColor = paramDynamicColor;
    if (ColorUtil.getColorByMode(this.borderColor) >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBorderColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.borderColor)));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(19228);
  }
  
  public void setBorderPressedColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19229);
    this.borderPressedColor = paramDynamicColor;
    if (ColorUtil.getColorByMode(this.borderPressedColor) >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBorderPressedColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.borderPressedColor)));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(19229);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(19227);
    this.borderWidth = paramFloat;
    if (this.borderWidth > 0.0F)
    {
      paramFloat = a.fromDPToPix(MMApplicationContext.getContext(), (int)paramFloat);
      checkIfNeedCreateBorderDrawable().setBorderWidth(paramFloat);
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(19227);
  }
  
  public void setBottom(float paramFloat)
  {
    AppMethodBeat.i(19148);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setBottom(paramFloat);
      AppMethodBeat.o(19148);
      return;
    }
    this.flexAttr.setBottom(paramFloat);
    AppMethodBeat.o(19148);
  }
  
  public void setBottomLeftCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(19233);
    this.bottomLeftBorderRadius = paramFloat;
    if (this.bottomLeftBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setBottomLeftBorderRadius(a.fromDPToPix(MMApplicationContext.getContext(), (int)this.bottomLeftBorderRadius));
    }
    AppMethodBeat.o(19233);
  }
  
  public void setBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19183);
    this.flexAttr.setBottomPercent(paramFloat);
    AppMethodBeat.o(19183);
  }
  
  public void setBottomRightCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(19234);
    this.bottomRightBorderRadius = paramFloat;
    if (this.bottomRightBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setBottomRightBorderRadius(a.fromDPToPix(MMApplicationContext.getContext(), (int)this.bottomRightBorderRadius));
    }
    AppMethodBeat.o(19234);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(19221);
    getView().setClickable(paramBoolean);
    AppMethodBeat.o(19221);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(19230);
    this.borderRadius = paramFloat;
    if (this.borderRadius >= 0.0F)
    {
      checkIfNeedCreateBorderDrawable().setBorderRadius(a.fromDPToPix(MMApplicationContext.getContext(), (int)this.borderRadius));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(19230);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setEnableHighLight(boolean paramBoolean)
  {
    AppMethodBeat.i(19164);
    this.isHighlight = paramBoolean;
    if ((getView() != null) && (this.isHighlight)) {
      getView().setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(19121);
          if (MMKView.this.isHighlight)
          {
            if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 2))
            {
              MMKView.access$102(MMKView.this, MMKView.this.backgroundColor);
              MMKView.access$200(MMKView.this).setBackgroundColor(MMKView.this.mContext.getResources().getColor(R.color.list_devider_color));
              MMKView.this.setViewBackground(MMKView.this.backgroundDrawable);
            }
          }
          else if (MMKView.this.onTouchCallback != null)
          {
            paramAnonymousView = TouchAction.DOWN;
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
          }
          for (;;)
          {
            paramAnonymousView = new TouchEvent(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY(), paramAnonymousView);
            MMKView.this.onTouchCallback.onTouch(paramAnonymousView);
            AppMethodBeat.o(19121);
            return false;
            if ((paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 3)) {
              break;
            }
            MMKView.access$200(MMKView.this).setBackgroundColor((int)ColorUtil.getColorByMode(MMKView.this.tmpSaveBgColor));
            MMKView.this.setViewBackground(MMKView.this.backgroundDrawable);
            break;
            paramAnonymousView = TouchAction.DOWN;
            continue;
            paramAnonymousView = TouchAction.MOVE;
            continue;
            paramAnonymousView = TouchAction.UP;
          }
        }
      });
    }
    AppMethodBeat.o(19164);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    AppMethodBeat.i(19138);
    this.flexAttr.setFlexBasis(paramFloat);
    AppMethodBeat.o(19138);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    AppMethodBeat.i(19160);
    this.flexAttr.setFlexGrow(paramFloat);
    AppMethodBeat.o(19160);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    AppMethodBeat.i(19162);
    this.flexAttr.setFlexShrink(paramFloat);
    AppMethodBeat.o(19162);
  }
  
  public void setFrameImpl(KRect paramKRect, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(264162);
    setTranslateX(paramKRect.mOrigin.mX);
    setTranslateY(paramKRect.mOrigin.mY);
    setWidth(paramKRect.mSize.mWidth);
    setHeight(paramKRect.mSize.mHeight);
    this.view.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(263957);
        paramVoidCallback.call();
        AppMethodBeat.o(263957);
      }
    });
    AppMethodBeat.o(264162);
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(19134);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setHeight(paramFloat);
      AppMethodBeat.o(19134);
      return;
    }
    this.flexAttr.setHeight(paramFloat);
    AppMethodBeat.o(19134);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(19186);
    this.flexAttr.setHeightPercent(paramFloat);
    AppMethodBeat.o(19186);
  }
  
  public void setIsRefreshing(boolean paramBoolean) {}
  
  public void setLeft(float paramFloat)
  {
    AppMethodBeat.i(19142);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setLeft(paramFloat);
      AppMethodBeat.o(19142);
      return;
    }
    this.flexAttr.setLeft(paramFloat);
    AppMethodBeat.o(19142);
  }
  
  public void setLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19177);
    this.flexAttr.setLeftPercent(paramFloat);
    AppMethodBeat.o(19177);
  }
  
  public void setMarginBottom(float paramFloat)
  {
    AppMethodBeat.i(19210);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setMarginBottom(paramFloat);
      AppMethodBeat.o(19210);
      return;
    }
    this.flexAttr.setMarginBottom(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).bottomMargin = ((int)MMKViewUtil.dpToPx(this.mContext, getMarginBottom()));
    }
    AppMethodBeat.o(19210);
  }
  
  public void setMarginBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19194);
    this.flexAttr.setMarginBottomPercent(paramFloat);
    AppMethodBeat.o(19194);
  }
  
  public void setMarginLeft(float paramFloat)
  {
    AppMethodBeat.i(19204);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setMarginLeft(paramFloat);
      AppMethodBeat.o(19204);
      return;
    }
    this.flexAttr.setMarginLeft(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).leftMargin = ((int)MMKViewUtil.dpToPx(this.mContext, getMarginLeft()));
    }
    AppMethodBeat.o(19204);
  }
  
  public void setMarginLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19188);
    this.flexAttr.setMarginLeftPercent(paramFloat);
    AppMethodBeat.o(19188);
  }
  
  public void setMarginRight(float paramFloat)
  {
    AppMethodBeat.i(19208);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setMarginRight(paramFloat);
      AppMethodBeat.o(19208);
      return;
    }
    this.flexAttr.setMarginRight(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).rightMargin = ((int)MMKViewUtil.dpToPx(this.mContext, getMarginRight()));
    }
    AppMethodBeat.o(19208);
  }
  
  public void setMarginRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19192);
    this.flexAttr.setMarginRightPercent(paramFloat);
    AppMethodBeat.o(19192);
  }
  
  public void setMarginTop(float paramFloat)
  {
    AppMethodBeat.i(19206);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setMarginTop(paramFloat);
      AppMethodBeat.o(19206);
      return;
    }
    this.flexAttr.setMarginTop(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).topMargin = ((int)MMKViewUtil.dpToPx(this.mContext, getMarginTop()));
    }
    AppMethodBeat.o(19206);
  }
  
  public void setMarginTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19190);
    this.flexAttr.setMarginTopPercent(paramFloat);
    AppMethodBeat.o(19190);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(19156);
    this.flexAttr.setMaxHeight(paramFloat);
    AppMethodBeat.o(19156);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    AppMethodBeat.i(19152);
    this.flexAttr.setMaxWidth(paramFloat);
    AppMethodBeat.o(19152);
  }
  
  public void setMinHeight(float paramFloat)
  {
    AppMethodBeat.i(19154);
    this.flexAttr.setMinHeight(paramFloat);
    AppMethodBeat.o(19154);
  }
  
  public void setMinWidth(float paramFloat)
  {
    AppMethodBeat.i(19150);
    this.flexAttr.setMinWidth(paramFloat);
    AppMethodBeat.o(19150);
  }
  
  public void setOnClickCallback(KViewOnClickCallback paramKViewOnClickCallback)
  {
    AppMethodBeat.i(19235);
    this.onClickCallback = paramKViewOnClickCallback;
    getView().setOnClickListener(new MMKView.2(this));
    AppMethodBeat.o(19235);
  }
  
  public void setOnLongClickCallback(KViewOnLongClickCallback paramKViewOnLongClickCallback)
  {
    AppMethodBeat.i(19236);
    this.onLongClickCallback = paramKViewOnLongClickCallback;
    getView().setOnLongClickListener(new MMKView.3(this));
    AppMethodBeat.o(19236);
  }
  
  public void setOnTouchCallback(KViewOnTouchCallback paramKViewOnTouchCallback)
  {
    AppMethodBeat.i(19237);
    this.onTouchCallback = paramKViewOnTouchCallback;
    if (getView() != null) {
      getView().setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(19124);
          if (MMKView.this.onTouchCallback != null)
          {
            paramAnonymousView = TouchAction.DOWN;
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
          }
          for (;;)
          {
            paramAnonymousView = new TouchEvent(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY(), paramAnonymousView);
            MMKView.this.onTouchCallback.onTouch(paramAnonymousView);
            AppMethodBeat.o(19124);
            return false;
            paramAnonymousView = TouchAction.DOWN;
            continue;
            paramAnonymousView = TouchAction.MOVE;
            continue;
            paramAnonymousView = TouchAction.UP;
          }
        }
      });
    }
    AppMethodBeat.o(19237);
  }
  
  public void setPaddingBottom(float paramFloat)
  {
    AppMethodBeat.i(19218);
    this.flexAttr.setPaddingBottom(paramFloat);
    AppMethodBeat.o(19218);
  }
  
  public void setPaddingBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19202);
    this.flexAttr.setPaddingBottomPercent(paramFloat);
    AppMethodBeat.o(19202);
  }
  
  public void setPaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(19212);
    this.flexAttr.setPaddingLeft(paramFloat);
    AppMethodBeat.o(19212);
  }
  
  public void setPaddingLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19196);
    this.flexAttr.setPaddingLeftPercent(paramFloat);
    AppMethodBeat.o(19196);
  }
  
  public void setPaddingRight(float paramFloat)
  {
    AppMethodBeat.i(19216);
    this.flexAttr.setPaddingRight(paramFloat);
    AppMethodBeat.o(19216);
  }
  
  public void setPaddingRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19200);
    this.flexAttr.setPaddingRightPercent(paramFloat);
    AppMethodBeat.o(19200);
  }
  
  public void setPaddingTop(float paramFloat)
  {
    AppMethodBeat.i(19214);
    this.flexAttr.setPaddingTop(paramFloat);
    AppMethodBeat.o(19214);
  }
  
  public void setPaddingTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19198);
    this.flexAttr.setPaddingTopPercent(paramFloat);
    AppMethodBeat.o(19198);
  }
  
  public void setPositionType(PositionType paramPositionType)
  {
    AppMethodBeat.i(19140);
    this.flexAttr.setPositionType(paramPositionType);
    AppMethodBeat.o(19140);
  }
  
  public void setRight(float paramFloat)
  {
    AppMethodBeat.i(19146);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setRight(paramFloat);
      AppMethodBeat.o(19146);
      return;
    }
    this.flexAttr.setRight(paramFloat);
    AppMethodBeat.o(19146);
  }
  
  public void setRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19181);
    this.flexAttr.setRightPercent(paramFloat);
    AppMethodBeat.o(19181);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(19171);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setRotation(paramFloat);
      AppMethodBeat.o(19171);
      return;
    }
    getView().setRotation(paramFloat);
    AppMethodBeat.o(19171);
  }
  
  public void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(19173);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setScaleX(paramFloat);
      AppMethodBeat.o(19173);
      return;
    }
    getView().setScaleX(paramFloat);
    AppMethodBeat.o(19173);
  }
  
  public void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(19175);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setScaleY(paramFloat);
      AppMethodBeat.o(19175);
      return;
    }
    getView().setScaleY(paramFloat);
    AppMethodBeat.o(19175);
  }
  
  public void setSecure(boolean paramBoolean)
  {
    AppMethodBeat.i(264154);
    int i = ((b)h.ae(b.class)).a(b.a.vLh, 1);
    Log.i("base_MMKView", "setSecure %s, enableValue: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
    if (i != 1)
    {
      AppMethodBeat.o(264154);
      return;
    }
    this.isSecure = paramBoolean;
    if ((this.uiPageDelegate != null) && (this.uiPageDelegate.get() != null))
    {
      UIPagePlatformDelegateImpl localUIPagePlatformDelegateImpl = (UIPagePlatformDelegateImpl)this.uiPageDelegate.get();
      Context localContext = localUIPagePlatformDelegateImpl.getContext();
      if ((localContext != null) && ((localContext instanceof Activity)))
      {
        Activity localActivity = (Activity)localContext;
        if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          AppMethodBeat.o(264154);
          return;
        }
        if (this.isSecure)
        {
          localUIPagePlatformDelegateImpl.addSecureView(hashCode());
          ((Activity)localContext).getWindow().addFlags(8192);
          AppMethodBeat.o(264154);
          return;
        }
        localUIPagePlatformDelegateImpl.removeSecureView(Integer.valueOf(hashCode()));
        if (localUIPagePlatformDelegateImpl.getSecureViews().size() <= 0) {
          ((Activity)localContext).getWindow().clearFlags(8192);
        }
      }
    }
    AppMethodBeat.o(264154);
  }
  
  public void setShadowColor(DynamicColor paramDynamicColor)
  {
    this.shadowColor = paramDynamicColor;
  }
  
  public void setShadowOffset(float paramFloat) {}
  
  public void setShadowRadius(float paramFloat) {}
  
  public void setTop(float paramFloat)
  {
    AppMethodBeat.i(19144);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTop(paramFloat);
      AppMethodBeat.o(19144);
      return;
    }
    this.flexAttr.setTop(paramFloat);
    AppMethodBeat.o(19144);
  }
  
  public void setTopLeftCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(19231);
    this.topLeftBorderRadius = paramFloat;
    if (this.topLeftBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setTopLeftBorderRadius(a.fromDPToPix(MMApplicationContext.getContext(), (int)this.topLeftBorderRadius));
    }
    AppMethodBeat.o(19231);
  }
  
  public void setTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19179);
    this.flexAttr.setTopPercent(paramFloat);
    AppMethodBeat.o(19179);
  }
  
  public void setTopRightCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(19232);
    this.topRightBorderRadius = paramFloat;
    if (this.topRightBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setTopRightBorderRadius(a.fromDPToPix(MMApplicationContext.getContext(), (int)this.topRightBorderRadius));
    }
    AppMethodBeat.o(19232);
  }
  
  public void setTranslateX(float paramFloat)
  {
    AppMethodBeat.i(19167);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTranslateX(paramFloat);
      AppMethodBeat.o(19167);
      return;
    }
    getView().setTranslationX(paramFloat);
    AppMethodBeat.o(19167);
  }
  
  public void setTranslateY(float paramFloat)
  {
    AppMethodBeat.i(19169);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTranslateY(paramFloat);
      AppMethodBeat.o(19169);
      return;
    }
    getView().setTranslationY(paramFloat);
    AppMethodBeat.o(19169);
  }
  
  protected final void setView(T paramT)
  {
    this.view = paramT;
  }
  
  protected void setViewBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(19238);
    this.backgroundDrawable = paramDrawable;
    if ((this.backgroundDrawable == null) && (this.internalDrawable != null))
    {
      getView().setBackground(this.internalDrawable);
      AppMethodBeat.o(19238);
      return;
    }
    if ((this.internalDrawable == null) && (this.backgroundDrawable != null))
    {
      getView().setBackground(this.backgroundDrawable);
      AppMethodBeat.o(19238);
      return;
    }
    if (this.internalDrawable != null)
    {
      this.internalDrawable.setInsetDrawable(this.backgroundDrawable);
      getView().setBackground(this.internalDrawable);
    }
    AppMethodBeat.o(19238);
  }
  
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(19130);
    this.id = paramString;
    this.flexAttr.setTestId(paramString);
    MMKViewUtil.setId4KindaImplView(this.mContext, paramString, getView());
    AppMethodBeat.o(19130);
  }
  
  public void setVisible(Visible paramVisible)
  {
    AppMethodBeat.i(19223);
    switch (7.$SwitchMap$com$tencent$kinda$gen$Visible[paramVisible.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19223);
      return;
      getView().setVisibility(0);
      this.flexAttr.setVisibility(0);
      resumeYogaNode();
      continue;
      getView().setVisibility(4);
      this.flexAttr.setVisibility(4);
      continue;
      getView().setVisibility(8);
      this.flexAttr.setVisibility(8);
      removeYogaNode();
    }
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(19132);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setWidth(paramFloat);
      AppMethodBeat.o(19132);
      return;
    }
    this.flexAttr.setWidth(paramFloat);
    AppMethodBeat.o(19132);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(19184);
    this.flexAttr.setWidthPercent(paramFloat);
    AppMethodBeat.o(19184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView
 * JD-Core Version:    0.7.0.1
 */