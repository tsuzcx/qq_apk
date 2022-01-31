package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Visible;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class MMKView<T extends View>
  extends ViewBase
  implements MMKViewBase<T>, KView
{
  public static final String TAG = "base_MMKView";
  protected long backgroundColor;
  private Drawable backgroundDrawable;
  protected long borderColor;
  protected long borderPressedColor;
  protected float borderRadius;
  protected float borderWidth;
  private float bottomLeftBorderRadius;
  private float bottomRightBorderRadius;
  private String id;
  private MMKViewBackgroundBorderDrawable internalDrawable;
  private boolean isHighlight;
  private KViewAnimatorProxy mAnimatorProxy;
  private KViewOnClickCallback onClickCallback;
  private KViewOnLongClickCallback onLongClickCallback;
  private KViewOnTouchCallback onTouchCallback;
  protected long shadowColor;
  protected float shadowOffset;
  protected float shadowRadius;
  private long tmpSaveBgColor;
  private float topLeftBorderRadius;
  private float topRightBorderRadius;
  protected T view;
  
  public MMKView()
  {
    AppMethodBeat.i(144967);
    this.topLeftBorderRadius = 0.0F;
    this.topRightBorderRadius = 0.0F;
    this.bottomLeftBorderRadius = 0.0F;
    this.bottomRightBorderRadius = 0.0F;
    this.mAnimatorProxy = new KViewAnimatorProxy(this);
    AppMethodBeat.o(144967);
  }
  
  private MMKViewBackgroundBorderDrawable checkIfNeedCreateBorderDrawable()
  {
    AppMethodBeat.i(144968);
    if (this.internalDrawable == null) {
      this.internalDrawable = new MMKViewBackgroundBorderDrawable(getView());
    }
    MMKViewBackgroundBorderDrawable localMMKViewBackgroundBorderDrawable = this.internalDrawable;
    AppMethodBeat.o(144968);
    return localMMKViewBackgroundBorderDrawable;
  }
  
  private void removeYogaNode()
  {
    AppMethodBeat.i(145065);
    if (node().getParent() != null)
    {
      int i = node().getParent().indexOf(node());
      node().getParent().removeChildAt(i);
    }
    AppMethodBeat.o(145065);
  }
  
  private void resumeYogaNode()
  {
    AppMethodBeat.i(145066);
    if (node().getParent() != null)
    {
      AppMethodBeat.o(145066);
      return;
    }
    if ((getView().getParent() != null) && ((getView().getParent() instanceof YogaLayout)))
    {
      YogaLayout localYogaLayout = (YogaLayout)getView().getParent();
      int i = localYogaLayout.indexOfChild(getView());
      localYogaLayout.getYogaNode().addChildAt(node(), i);
    }
    AppMethodBeat.o(145066);
  }
  
  public T createView(Context paramContext)
  {
    AppMethodBeat.i(144969);
    paramContext = new View(paramContext);
    AppMethodBeat.o(144969);
    return paramContext;
  }
  
  public String getAccessibilityString()
  {
    return null;
  }
  
  public boolean getAccessible()
  {
    return false;
  }
  
  public Align getAlignSelf()
  {
    AppMethodBeat.i(144978);
    Align localAlign = this.flexAttr.getAlignSelf();
    AppMethodBeat.o(144978);
    return localAlign;
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(145007);
    float f = getView().getAlpha();
    AppMethodBeat.o(145007);
    return f;
  }
  
  public float getAspectRatio()
  {
    AppMethodBeat.i(145000);
    float f = this.flexAttr.getAspectRatio();
    AppMethodBeat.o(145000);
    return f;
  }
  
  public long getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public long getBorderColor()
  {
    return this.borderColor;
  }
  
  public long getBorderPressedColor()
  {
    return this.borderPressedColor;
  }
  
  public float getBorderWidth()
  {
    return this.borderWidth;
  }
  
  public float getBottom()
  {
    AppMethodBeat.i(144990);
    float f = this.flexAttr.getBottom();
    AppMethodBeat.o(144990);
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
    AppMethodBeat.i(145063);
    boolean bool = getView().isClickable();
    AppMethodBeat.o(145063);
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
    AppMethodBeat.i(144980);
    float f = this.flexAttr.getFlexBasis();
    AppMethodBeat.o(144980);
    return f;
  }
  
  public float getFlexGrow()
  {
    AppMethodBeat.i(145002);
    float f = this.flexAttr.getFlexGrow();
    AppMethodBeat.o(145002);
    return f;
  }
  
  public float getFlexShrink()
  {
    AppMethodBeat.i(145004);
    float f = this.flexAttr.getFlexShrink();
    AppMethodBeat.o(145004);
    return f;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(144976);
    float f = this.flexAttr.getHeight();
    AppMethodBeat.o(144976);
    return f;
  }
  
  public float getHeightPercent()
  {
    AppMethodBeat.i(145028);
    float f = this.flexAttr.getHeightPercent();
    AppMethodBeat.o(145028);
    return f;
  }
  
  public float getLeft()
  {
    AppMethodBeat.i(144984);
    float f = this.flexAttr.getLeft();
    AppMethodBeat.o(144984);
    return f;
  }
  
  public float getLeftPercent()
  {
    AppMethodBeat.i(145019);
    float f = this.flexAttr.getLeftPercent();
    AppMethodBeat.o(145019);
    return f;
  }
  
  public float getMarginBottom()
  {
    AppMethodBeat.i(145052);
    float f = this.flexAttr.getMarginBottom();
    AppMethodBeat.o(145052);
    return f;
  }
  
  public float getMarginBottomPercent()
  {
    AppMethodBeat.i(145036);
    float f = this.flexAttr.getMarginBottomPercent();
    AppMethodBeat.o(145036);
    return f;
  }
  
  public float getMarginLeft()
  {
    AppMethodBeat.i(145046);
    float f = this.flexAttr.getMarginLeft();
    AppMethodBeat.o(145046);
    return f;
  }
  
  public float getMarginLeftPercent()
  {
    AppMethodBeat.i(145030);
    float f = this.flexAttr.getMarginLeftPercent();
    AppMethodBeat.o(145030);
    return f;
  }
  
  public float getMarginRight()
  {
    AppMethodBeat.i(145050);
    float f = this.flexAttr.getMarginRight();
    AppMethodBeat.o(145050);
    return f;
  }
  
  public float getMarginRightPercent()
  {
    AppMethodBeat.i(145034);
    float f = this.flexAttr.getMarginRightPercent();
    AppMethodBeat.o(145034);
    return f;
  }
  
  public float getMarginTop()
  {
    AppMethodBeat.i(145048);
    float f = this.flexAttr.getMarginTop();
    AppMethodBeat.o(145048);
    return f;
  }
  
  public float getMarginTopPercent()
  {
    AppMethodBeat.i(145032);
    float f = this.flexAttr.getMarginTopPercent();
    AppMethodBeat.o(145032);
    return f;
  }
  
  public float getMaxHeight()
  {
    AppMethodBeat.i(144998);
    float f = this.flexAttr.getMaxHeight();
    AppMethodBeat.o(144998);
    return f;
  }
  
  public float getMaxWidth()
  {
    AppMethodBeat.i(144994);
    float f = this.flexAttr.getMaxWidth();
    AppMethodBeat.o(144994);
    return f;
  }
  
  public float getMinHeight()
  {
    AppMethodBeat.i(144996);
    float f = this.flexAttr.getMinHeight();
    AppMethodBeat.o(144996);
    return f;
  }
  
  public float getMinWidth()
  {
    AppMethodBeat.i(144992);
    float f = this.flexAttr.getMinWidth();
    AppMethodBeat.o(144992);
    return f;
  }
  
  public float getPaddingBottom()
  {
    AppMethodBeat.i(145060);
    float f = this.flexAttr.getPaddingBottom();
    AppMethodBeat.o(145060);
    return f;
  }
  
  public float getPaddingBottomPercent()
  {
    AppMethodBeat.i(145044);
    float f = this.flexAttr.getPaddingBottomPercent();
    AppMethodBeat.o(145044);
    return f;
  }
  
  public float getPaddingLeft()
  {
    AppMethodBeat.i(145054);
    float f = this.flexAttr.getPaddingLeft();
    AppMethodBeat.o(145054);
    return f;
  }
  
  public float getPaddingLeftPercent()
  {
    AppMethodBeat.i(145038);
    float f = this.flexAttr.getPaddingLeftPercent();
    AppMethodBeat.o(145038);
    return f;
  }
  
  public float getPaddingRight()
  {
    AppMethodBeat.i(145058);
    float f = this.flexAttr.getPaddingRight();
    AppMethodBeat.o(145058);
    return f;
  }
  
  public float getPaddingRightPercent()
  {
    AppMethodBeat.i(145042);
    float f = this.flexAttr.getPaddingRightPercent();
    AppMethodBeat.o(145042);
    return f;
  }
  
  public float getPaddingTop()
  {
    AppMethodBeat.i(145056);
    float f = this.flexAttr.getPaddingTop();
    AppMethodBeat.o(145056);
    return f;
  }
  
  public float getPaddingTopPercent()
  {
    AppMethodBeat.i(145040);
    float f = this.flexAttr.getPaddingTopPercent();
    AppMethodBeat.o(145040);
    return f;
  }
  
  public PositionType getPositionType()
  {
    AppMethodBeat.i(144982);
    PositionType localPositionType = this.flexAttr.getPositionType();
    AppMethodBeat.o(144982);
    return localPositionType;
  }
  
  public float getRight()
  {
    AppMethodBeat.i(144988);
    float f = this.flexAttr.getRight();
    AppMethodBeat.o(144988);
    return f;
  }
  
  public float getRightPercent()
  {
    AppMethodBeat.i(145023);
    float f = this.flexAttr.getRightPercent();
    AppMethodBeat.o(145023);
    return f;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(145013);
    float f = getView().getRotation();
    AppMethodBeat.o(145013);
    return f;
  }
  
  public float getScaleX()
  {
    AppMethodBeat.i(145015);
    float f = getView().getScaleX();
    AppMethodBeat.o(145015);
    return f;
  }
  
  public float getScaleY()
  {
    AppMethodBeat.i(145017);
    float f = getView().getScaleY();
    AppMethodBeat.o(145017);
    return f;
  }
  
  public long getShadowColor()
  {
    return 0L;
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
    AppMethodBeat.i(144986);
    float f = this.flexAttr.getTop();
    AppMethodBeat.o(144986);
    return f;
  }
  
  public float getTopLeftCornerRadius()
  {
    return this.topLeftBorderRadius;
  }
  
  public float getTopPercent()
  {
    AppMethodBeat.i(145021);
    float f = this.flexAttr.getTopPercent();
    AppMethodBeat.o(145021);
    return f;
  }
  
  public float getTopRightCornerRadius()
  {
    return this.topRightBorderRadius;
  }
  
  public float getTranslateX()
  {
    AppMethodBeat.i(145009);
    float f = getView().getTranslationX();
    AppMethodBeat.o(145009);
    return f;
  }
  
  public float getTranslateY()
  {
    AppMethodBeat.i(145011);
    float f = getView().getTranslationY();
    AppMethodBeat.o(145011);
    return f;
  }
  
  public final T getView()
  {
    return this.view;
  }
  
  public String getViewId()
  {
    AppMethodBeat.i(144972);
    if (bo.isNullOrNil(this.id))
    {
      AppMethodBeat.o(144972);
      return "";
    }
    String str = this.id;
    AppMethodBeat.o(144972);
    return str;
  }
  
  public Visible getVisible()
  {
    AppMethodBeat.i(145067);
    switch (getView().getVisibility())
    {
    default: 
      localVisible = Visible.VISIBLE;
      AppMethodBeat.o(145067);
      return localVisible;
    case 0: 
      localVisible = Visible.VISIBLE;
      AppMethodBeat.o(145067);
      return localVisible;
    case 4: 
      localVisible = Visible.INVISIBLE;
      AppMethodBeat.o(145067);
      return localVisible;
    }
    Visible localVisible = Visible.GONE;
    AppMethodBeat.o(145067);
    return localVisible;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(144974);
    float f = this.flexAttr.getWidth();
    AppMethodBeat.o(144974);
    return f;
  }
  
  public float getWidthPercent()
  {
    AppMethodBeat.i(145026);
    float f = this.flexAttr.getWidthPercent();
    AppMethodBeat.o(145026);
    return f;
  }
  
  public final void initWithPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
  {
    AppMethodBeat.i(144970);
    if ((paramIUIPagePlatformDelegate instanceof UIPagePlatformDelegateImpl)) {
      setView(createView(((UIPagePlatformDelegateImpl)paramIUIPagePlatformDelegate).getContext()));
    }
    AppMethodBeat.o(144970);
  }
  
  protected void notifyChanged()
  {
    AppMethodBeat.i(145080);
    if ((node().isMeasureDefined()) && (!node().isDirty())) {
      node().dirty();
    }
    getView().requestLayout();
    AppMethodBeat.o(145080);
  }
  
  protected void onFlexAttribute()
  {
    AppMethodBeat.i(145081);
    notifyChanged();
    AppMethodBeat.o(145081);
  }
  
  public void setAccessibilityString(String paramString) {}
  
  public void setAccessible(boolean paramBoolean) {}
  
  public void setAlignSelf(Align paramAlign)
  {
    AppMethodBeat.i(144977);
    this.flexAttr.setAlignSelf(paramAlign);
    AppMethodBeat.o(144977);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(145006);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setAlpha(paramFloat);
      AppMethodBeat.o(145006);
      return;
    }
    getView().setAlpha(paramFloat);
    AppMethodBeat.o(145006);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    AppMethodBeat.i(144999);
    this.flexAttr.setAspectRatio(paramFloat);
    AppMethodBeat.o(144999);
  }
  
  public void setBackgroundColor(long paramLong)
  {
    AppMethodBeat.i(145061);
    if (KindaGlobalAnimator.hasAnimate())
    {
      ab.d("base_MMKView", "进入动画setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(paramLong)));
      this.mAnimatorProxy.setBackgroundColor(paramLong);
      AppMethodBeat.o(145061);
      return;
    }
    ab.d("base_MMKView", "进入View设置属性的setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(paramLong)));
    this.backgroundColor = paramLong;
    if (this.backgroundColor >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBackgroundColor(MMKViewUtil.argbColor(this.backgroundColor));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(145061);
  }
  
  public void setBorderColor(long paramLong)
  {
    AppMethodBeat.i(145069);
    this.borderColor = paramLong;
    if (this.borderColor >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBorderColor(MMKViewUtil.argbColor(this.borderColor));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(145069);
  }
  
  public void setBorderPressedColor(long paramLong)
  {
    AppMethodBeat.i(145070);
    this.borderPressedColor = paramLong;
    if (this.borderPressedColor >= 0L)
    {
      checkIfNeedCreateBorderDrawable().setBorderPressedColor(MMKViewUtil.argbColor(this.borderPressedColor));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(145070);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(145068);
    this.borderWidth = paramFloat;
    if (this.borderWidth > 0.0F)
    {
      paramFloat = a.fromDPToPix(ah.getContext(), (int)paramFloat);
      checkIfNeedCreateBorderDrawable().setBorderWidth(paramFloat);
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(145068);
  }
  
  public void setBottom(float paramFloat)
  {
    AppMethodBeat.i(144989);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setBottom(paramFloat);
      AppMethodBeat.o(144989);
      return;
    }
    this.flexAttr.setBottom(paramFloat);
    AppMethodBeat.o(144989);
  }
  
  public void setBottomLeftCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(145074);
    this.bottomLeftBorderRadius = paramFloat;
    if (this.bottomLeftBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setBottomLeftBorderRadius(a.fromDPToPix(ah.getContext(), (int)this.bottomLeftBorderRadius));
    }
    AppMethodBeat.o(145074);
  }
  
  public void setBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(145024);
    this.flexAttr.setBottomPercent(paramFloat);
    AppMethodBeat.o(145024);
  }
  
  public void setBottomRightCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(145075);
    this.bottomRightBorderRadius = paramFloat;
    if (this.bottomRightBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setBottomRightBorderRadius(a.fromDPToPix(ah.getContext(), (int)this.bottomRightBorderRadius));
    }
    AppMethodBeat.o(145075);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(145062);
    getView().setClickable(paramBoolean);
    AppMethodBeat.o(145062);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(145071);
    this.borderRadius = paramFloat;
    if (this.borderRadius >= 0.0F)
    {
      checkIfNeedCreateBorderDrawable().setBorderRadius(a.fromDPToPix(ah.getContext(), (int)this.borderRadius));
      setViewBackground(this.backgroundDrawable);
    }
    AppMethodBeat.o(145071);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setEnableHighLight(boolean paramBoolean)
  {
    AppMethodBeat.i(145005);
    this.isHighlight = paramBoolean;
    if ((getView() != null) && (this.isHighlight)) {
      getView().setOnTouchListener(new MMKView.1(this));
    }
    AppMethodBeat.o(145005);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    AppMethodBeat.i(144979);
    this.flexAttr.setFlexBasis(paramFloat);
    AppMethodBeat.o(144979);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    AppMethodBeat.i(145001);
    this.flexAttr.setFlexGrow(paramFloat);
    AppMethodBeat.o(145001);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    AppMethodBeat.i(145003);
    this.flexAttr.setFlexShrink(paramFloat);
    AppMethodBeat.o(145003);
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(144975);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setHeight(paramFloat);
      AppMethodBeat.o(144975);
      return;
    }
    this.flexAttr.setHeight(paramFloat);
    AppMethodBeat.o(144975);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(145027);
    this.flexAttr.setHeightPercent(paramFloat);
    AppMethodBeat.o(145027);
  }
  
  public void setLeft(float paramFloat)
  {
    AppMethodBeat.i(144983);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setLeft(paramFloat);
      AppMethodBeat.o(144983);
      return;
    }
    this.flexAttr.setLeft(paramFloat);
    AppMethodBeat.o(144983);
  }
  
  public void setLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(145018);
    this.flexAttr.setLeftPercent(paramFloat);
    AppMethodBeat.o(145018);
  }
  
  public void setMarginBottom(float paramFloat)
  {
    AppMethodBeat.i(145051);
    this.flexAttr.setMarginBottom(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).bottomMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), getMarginBottom()));
    }
    AppMethodBeat.o(145051);
  }
  
  public void setMarginBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(145035);
    this.flexAttr.setMarginBottomPercent(paramFloat);
    AppMethodBeat.o(145035);
  }
  
  public void setMarginLeft(float paramFloat)
  {
    AppMethodBeat.i(145045);
    this.flexAttr.setMarginLeft(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).leftMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), getMarginLeft()));
    }
    AppMethodBeat.o(145045);
  }
  
  public void setMarginLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(145029);
    this.flexAttr.setMarginLeftPercent(paramFloat);
    AppMethodBeat.o(145029);
  }
  
  public void setMarginRight(float paramFloat)
  {
    AppMethodBeat.i(145049);
    this.flexAttr.setMarginRight(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).rightMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), getMarginRight()));
    }
    AppMethodBeat.o(145049);
  }
  
  public void setMarginRightPercent(float paramFloat)
  {
    AppMethodBeat.i(145033);
    this.flexAttr.setMarginRightPercent(paramFloat);
    AppMethodBeat.o(145033);
  }
  
  public void setMarginTop(float paramFloat)
  {
    AppMethodBeat.i(145047);
    this.flexAttr.setMarginTop(paramFloat);
    if ((getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)getView().getLayoutParams()).topMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), getMarginTop()));
    }
    AppMethodBeat.o(145047);
  }
  
  public void setMarginTopPercent(float paramFloat)
  {
    AppMethodBeat.i(145031);
    this.flexAttr.setMarginTopPercent(paramFloat);
    AppMethodBeat.o(145031);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(144997);
    this.flexAttr.setMaxHeight(paramFloat);
    AppMethodBeat.o(144997);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    AppMethodBeat.i(144993);
    this.flexAttr.setMaxWidth(paramFloat);
    AppMethodBeat.o(144993);
  }
  
  public void setMinHeight(float paramFloat)
  {
    AppMethodBeat.i(144995);
    this.flexAttr.setMinHeight(paramFloat);
    AppMethodBeat.o(144995);
  }
  
  public void setMinWidth(float paramFloat)
  {
    AppMethodBeat.i(144991);
    this.flexAttr.setMinWidth(paramFloat);
    AppMethodBeat.o(144991);
  }
  
  public void setOnClickCallback(KViewOnClickCallback paramKViewOnClickCallback)
  {
    AppMethodBeat.i(145076);
    this.onClickCallback = paramKViewOnClickCallback;
    getView().setOnClickListener(new MMKView.2(this));
    AppMethodBeat.o(145076);
  }
  
  public void setOnLongClickCallback(KViewOnLongClickCallback paramKViewOnLongClickCallback)
  {
    AppMethodBeat.i(145077);
    this.onLongClickCallback = paramKViewOnLongClickCallback;
    getView().setOnLongClickListener(new MMKView.3(this));
    AppMethodBeat.o(145077);
  }
  
  public void setOnTouchCallback(KViewOnTouchCallback paramKViewOnTouchCallback)
  {
    AppMethodBeat.i(145078);
    this.onTouchCallback = paramKViewOnTouchCallback;
    if (getView() != null) {
      getView().setOnTouchListener(new MMKView.4(this));
    }
    AppMethodBeat.o(145078);
  }
  
  public void setPaddingBottom(float paramFloat)
  {
    AppMethodBeat.i(145059);
    this.flexAttr.setPaddingBottom(paramFloat);
    AppMethodBeat.o(145059);
  }
  
  public void setPaddingBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(145043);
    this.flexAttr.setPaddingBottomPercent(paramFloat);
    AppMethodBeat.o(145043);
  }
  
  public void setPaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(145053);
    this.flexAttr.setPaddingLeft(paramFloat);
    AppMethodBeat.o(145053);
  }
  
  public void setPaddingLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(145037);
    this.flexAttr.setPaddingLeftPercent(paramFloat);
    AppMethodBeat.o(145037);
  }
  
  public void setPaddingRight(float paramFloat)
  {
    AppMethodBeat.i(145057);
    this.flexAttr.setPaddingRight(paramFloat);
    AppMethodBeat.o(145057);
  }
  
  public void setPaddingRightPercent(float paramFloat)
  {
    AppMethodBeat.i(145041);
    this.flexAttr.setPaddingRightPercent(paramFloat);
    AppMethodBeat.o(145041);
  }
  
  public void setPaddingTop(float paramFloat)
  {
    AppMethodBeat.i(145055);
    this.flexAttr.setPaddingTop(paramFloat);
    AppMethodBeat.o(145055);
  }
  
  public void setPaddingTopPercent(float paramFloat)
  {
    AppMethodBeat.i(145039);
    this.flexAttr.setPaddingTopPercent(paramFloat);
    AppMethodBeat.o(145039);
  }
  
  public void setPositionType(PositionType paramPositionType)
  {
    AppMethodBeat.i(144981);
    this.flexAttr.setPositionType(paramPositionType);
    AppMethodBeat.o(144981);
  }
  
  public void setRight(float paramFloat)
  {
    AppMethodBeat.i(144987);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setRight(paramFloat);
      AppMethodBeat.o(144987);
      return;
    }
    this.flexAttr.setRight(paramFloat);
    AppMethodBeat.o(144987);
  }
  
  public void setRightPercent(float paramFloat)
  {
    AppMethodBeat.i(145022);
    this.flexAttr.setRightPercent(paramFloat);
    AppMethodBeat.o(145022);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(145012);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setRotation(paramFloat);
      AppMethodBeat.o(145012);
      return;
    }
    getView().setRotation(paramFloat);
    AppMethodBeat.o(145012);
  }
  
  public void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(145014);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setScaleX(paramFloat);
      AppMethodBeat.o(145014);
      return;
    }
    getView().setScaleX(paramFloat);
    AppMethodBeat.o(145014);
  }
  
  public void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(145016);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setScaleY(paramFloat);
      AppMethodBeat.o(145016);
      return;
    }
    getView().setScaleY(paramFloat);
    AppMethodBeat.o(145016);
  }
  
  public void setShadowColor(long paramLong) {}
  
  public void setShadowOffset(float paramFloat) {}
  
  public void setShadowRadius(float paramFloat) {}
  
  public void setTop(float paramFloat)
  {
    AppMethodBeat.i(144985);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTop(paramFloat);
      AppMethodBeat.o(144985);
      return;
    }
    this.flexAttr.setTop(paramFloat);
    AppMethodBeat.o(144985);
  }
  
  public void setTopLeftCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(145072);
    this.topLeftBorderRadius = paramFloat;
    if (this.topLeftBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setTopLeftBorderRadius(a.fromDPToPix(ah.getContext(), (int)this.topLeftBorderRadius));
    }
    AppMethodBeat.o(145072);
  }
  
  public void setTopPercent(float paramFloat)
  {
    AppMethodBeat.i(145020);
    this.flexAttr.setTopPercent(paramFloat);
    AppMethodBeat.o(145020);
  }
  
  public void setTopRightCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(145073);
    this.topRightBorderRadius = paramFloat;
    if (this.topRightBorderRadius >= 0.0F) {
      checkIfNeedCreateBorderDrawable().setTopRightBorderRadius(a.fromDPToPix(ah.getContext(), (int)this.topRightBorderRadius));
    }
    AppMethodBeat.o(145073);
  }
  
  public void setTranslateX(float paramFloat)
  {
    AppMethodBeat.i(145008);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTranslateX(paramFloat);
      AppMethodBeat.o(145008);
      return;
    }
    getView().setTranslationX(paramFloat);
    AppMethodBeat.o(145008);
  }
  
  public void setTranslateY(float paramFloat)
  {
    AppMethodBeat.i(145010);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setTranslateY(paramFloat);
      AppMethodBeat.o(145010);
      return;
    }
    getView().setTranslationY(paramFloat);
    AppMethodBeat.o(145010);
  }
  
  protected final void setView(T paramT)
  {
    this.view = paramT;
  }
  
  protected void setViewBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(145079);
    this.backgroundDrawable = paramDrawable;
    if ((this.backgroundDrawable == null) && (this.internalDrawable != null))
    {
      getView().setBackground(this.internalDrawable);
      AppMethodBeat.o(145079);
      return;
    }
    if ((this.internalDrawable == null) && (this.backgroundDrawable != null))
    {
      getView().setBackground(this.backgroundDrawable);
      AppMethodBeat.o(145079);
      return;
    }
    if (this.internalDrawable != null)
    {
      this.internalDrawable.setInsetDrawable(this.backgroundDrawable);
      getView().setBackground(this.internalDrawable);
    }
    AppMethodBeat.o(145079);
  }
  
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(144971);
    this.id = paramString;
    this.flexAttr.setTestId(paramString);
    getView().setContentDescription(paramString);
    AppMethodBeat.o(144971);
  }
  
  public void setVisible(Visible paramVisible)
  {
    AppMethodBeat.i(145064);
    switch (5.$SwitchMap$com$tencent$kinda$gen$Visible[paramVisible.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(145064);
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
    AppMethodBeat.i(144973);
    if (KindaGlobalAnimator.hasAnimate())
    {
      this.mAnimatorProxy.setWidth(paramFloat);
      AppMethodBeat.o(144973);
      return;
    }
    this.flexAttr.setWidth(paramFloat);
    AppMethodBeat.o(144973);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(145025);
    this.flexAttr.setWidthPercent(paramFloat);
    AppMethodBeat.o(145025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView
 * JD-Core Version:    0.7.0.1
 */