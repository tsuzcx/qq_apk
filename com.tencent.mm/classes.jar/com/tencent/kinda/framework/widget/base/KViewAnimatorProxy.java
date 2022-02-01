package com.tencent.kinda.framework.widget.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KRect;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Visible;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidKRectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KViewAnimatorProxy
  implements KView
{
  private KView mKView;
  
  public KViewAnimatorProxy(KView paramKView)
  {
    this.mKView = paramKView;
  }
  
  public void addBlurEffect(int paramInt) {}
  
  public KPoint convertPointToScreen(KPoint paramKPoint)
  {
    return null;
  }
  
  public KPoint convertPointToView(KPoint paramKPoint, KView paramKView)
  {
    return null;
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
    return null;
  }
  
  public float getAlpha()
  {
    return 0.0F;
  }
  
  public float getAspectRatio()
  {
    return 0.0F;
  }
  
  public DynamicColor getBackgroundColor()
  {
    return null;
  }
  
  public DynamicColor getBorderColor()
  {
    return null;
  }
  
  public DynamicColor getBorderPressedColor()
  {
    return null;
  }
  
  public float getBorderWidth()
  {
    return 0.0F;
  }
  
  public float getBottom()
  {
    return 0.0F;
  }
  
  public float getBottomLeftCornerRadius()
  {
    return 0.0F;
  }
  
  public float getBottomPercent()
  {
    return 0.0F;
  }
  
  public float getBottomRightCornerRadius()
  {
    return 0.0F;
  }
  
  public boolean getClickable()
  {
    return false;
  }
  
  public float getCornerRadius()
  {
    return 0.0F;
  }
  
  public boolean getEnableHighLight()
  {
    return false;
  }
  
  public float getFlexBasis()
  {
    return 0.0F;
  }
  
  public float getFlexGrow()
  {
    return 0.0F;
  }
  
  public float getFlexShrink()
  {
    return 0.0F;
  }
  
  public float getFrameOriginX()
  {
    return 0.0F;
  }
  
  public float getFrameOriginY()
  {
    return 0.0F;
  }
  
  public float getHeight()
  {
    return 0.0F;
  }
  
  public float getHeightPercent()
  {
    return 0.0F;
  }
  
  public boolean getIsRefreshing()
  {
    return false;
  }
  
  public float getLeft()
  {
    return 0.0F;
  }
  
  public float getLeftPercent()
  {
    return 0.0F;
  }
  
  public float getMarginBottom()
  {
    AppMethodBeat.i(263352);
    float f = this.mKView.getMarginBottom();
    AppMethodBeat.o(263352);
    return f;
  }
  
  public float getMarginBottomPercent()
  {
    return 0.0F;
  }
  
  public float getMarginLeft()
  {
    AppMethodBeat.i(178771);
    float f = this.mKView.getMarginLeft();
    AppMethodBeat.o(178771);
    return f;
  }
  
  public float getMarginLeftPercent()
  {
    return 0.0F;
  }
  
  public float getMarginRight()
  {
    AppMethodBeat.i(263350);
    float f = this.mKView.getMarginRight();
    AppMethodBeat.o(263350);
    return f;
  }
  
  public float getMarginRightPercent()
  {
    return 0.0F;
  }
  
  public float getMarginTop()
  {
    AppMethodBeat.i(263348);
    float f = this.mKView.getMarginTop();
    AppMethodBeat.o(263348);
    return f;
  }
  
  public float getMarginTopPercent()
  {
    return 0.0F;
  }
  
  public float getMaxHeight()
  {
    return 0.0F;
  }
  
  public float getMaxWidth()
  {
    return 0.0F;
  }
  
  public float getMinHeight()
  {
    return 0.0F;
  }
  
  public float getMinWidth()
  {
    return 0.0F;
  }
  
  public float getPaddingBottom()
  {
    return 0.0F;
  }
  
  public float getPaddingBottomPercent()
  {
    return 0.0F;
  }
  
  public float getPaddingLeft()
  {
    return 0.0F;
  }
  
  public float getPaddingLeftPercent()
  {
    return 0.0F;
  }
  
  public float getPaddingRight()
  {
    return 0.0F;
  }
  
  public float getPaddingRightPercent()
  {
    return 0.0F;
  }
  
  public float getPaddingTop()
  {
    return 0.0F;
  }
  
  public float getPaddingTopPercent()
  {
    return 0.0F;
  }
  
  public PositionType getPositionType()
  {
    return null;
  }
  
  public float getRight()
  {
    return 0.0F;
  }
  
  public float getRightPercent()
  {
    return 0.0F;
  }
  
  public float getRotation()
  {
    return 0.0F;
  }
  
  public float getScaleX()
  {
    return 0.0F;
  }
  
  public float getScaleY()
  {
    return 0.0F;
  }
  
  public boolean getSecure()
  {
    return false;
  }
  
  public DynamicColor getShadowColor()
  {
    return null;
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
    return 0.0F;
  }
  
  public float getTopLeftCornerRadius()
  {
    return 0.0F;
  }
  
  public float getTopPercent()
  {
    return 0.0F;
  }
  
  public float getTopRightCornerRadius()
  {
    return 0.0F;
  }
  
  public float getTranslateX()
  {
    return 0.0F;
  }
  
  public float getTranslateY()
  {
    return 0.0F;
  }
  
  public String getViewId()
  {
    return null;
  }
  
  public Visible getVisible()
  {
    return null;
  }
  
  public float getWidth()
  {
    return 0.0F;
  }
  
  public float getWidthPercent()
  {
    return 0.0F;
  }
  
  public void initWithPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate) {}
  
  public void removeBlurEffect() {}
  
  public void requestFrameImpl(VoidKRectCallback paramVoidKRectCallback) {}
  
  public void requestLayout() {}
  
  public void setAccessibilityString(String paramString) {}
  
  public void setAccessible(boolean paramBoolean) {}
  
  public void setAlignSelf(Align paramAlign) {}
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(18816);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "alpha", new float[] { this.mKView.getAlpha(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18816);
  }
  
  public void setAspectRatio(float paramFloat) {}
  
  public void setBackgroundColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18815);
    paramDynamicColor = ValueAnimator.ofFloat(new float[] { (float)ColorUtil.getColorByMode(this.mKView.getBackgroundColor()), (float)ColorUtil.getColorByMode(paramDynamicColor) });
    paramDynamicColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(18808);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = new DynamicColor(f, 0L);
        KViewAnimatorProxy.this.mKView.setBackgroundColor(paramAnonymousValueAnimator);
        Log.d("base_MMKView", "已经给背景颜色设置动画KView：" + KViewAnimatorProxy.this.mKView + "，value：" + Long.toHexString(ColorUtil.absColor(f)));
        AppMethodBeat.o(18808);
      }
    });
    KindaGlobalAnimator.addAnimator(paramDynamicColor);
    AppMethodBeat.o(18815);
  }
  
  public void setBorderColor(DynamicColor paramDynamicColor) {}
  
  public void setBorderPressedColor(DynamicColor paramDynamicColor) {}
  
  public void setBorderWidth(float paramFloat) {}
  
  public void setBottom(float paramFloat)
  {
    AppMethodBeat.i(18814);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "bottom", new float[] { this.mKView.getBottom(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18814);
  }
  
  public void setBottomLeftCornerRadius(float paramFloat) {}
  
  public void setBottomPercent(float paramFloat) {}
  
  public void setBottomRightCornerRadius(float paramFloat) {}
  
  public void setClickable(boolean paramBoolean) {}
  
  public void setCornerRadius(float paramFloat) {}
  
  public void setEnableHighLight(boolean paramBoolean) {}
  
  public void setFlexBasis(float paramFloat) {}
  
  public void setFlexGrow(float paramFloat) {}
  
  public void setFlexShrink(float paramFloat) {}
  
  public void setFrameImpl(KRect paramKRect, VoidCallback paramVoidCallback) {}
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(18810);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "height", new float[] { this.mKView.getHeight(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18810);
  }
  
  public void setHeightPercent(float paramFloat) {}
  
  public void setIsRefreshing(boolean paramBoolean) {}
  
  public void setLeft(float paramFloat)
  {
    AppMethodBeat.i(18811);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "left", new float[] { this.mKView.getLeft(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18811);
  }
  
  public void setLeftPercent(float paramFloat) {}
  
  public void setMarginBottom(float paramFloat)
  {
    AppMethodBeat.i(263351);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "marginBottom", new float[] { this.mKView.getMarginBottom(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(263351);
  }
  
  public void setMarginBottomPercent(float paramFloat) {}
  
  public void setMarginLeft(float paramFloat)
  {
    AppMethodBeat.i(178770);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "marginLeft", new float[] { this.mKView.getMarginLeft(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(178770);
  }
  
  public void setMarginLeftPercent(float paramFloat) {}
  
  public void setMarginRight(float paramFloat)
  {
    AppMethodBeat.i(263349);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "marginRight", new float[] { this.mKView.getMarginRight(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(263349);
  }
  
  public void setMarginRightPercent(float paramFloat) {}
  
  public void setMarginTop(float paramFloat)
  {
    AppMethodBeat.i(263347);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "marginTop", new float[] { this.mKView.getMarginTop(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(263347);
  }
  
  public void setMarginTopPercent(float paramFloat) {}
  
  public void setMaxHeight(float paramFloat) {}
  
  public void setMaxWidth(float paramFloat) {}
  
  public void setMinHeight(float paramFloat) {}
  
  public void setMinWidth(float paramFloat) {}
  
  public void setOnClickCallback(KViewOnClickCallback paramKViewOnClickCallback) {}
  
  public void setOnLongClickCallback(KViewOnLongClickCallback paramKViewOnLongClickCallback) {}
  
  public void setOnTouchCallback(KViewOnTouchCallback paramKViewOnTouchCallback) {}
  
  public void setPaddingBottom(float paramFloat) {}
  
  public void setPaddingBottomPercent(float paramFloat) {}
  
  public void setPaddingLeft(float paramFloat) {}
  
  public void setPaddingLeftPercent(float paramFloat) {}
  
  public void setPaddingRight(float paramFloat) {}
  
  public void setPaddingRightPercent(float paramFloat) {}
  
  public void setPaddingTop(float paramFloat) {}
  
  public void setPaddingTopPercent(float paramFloat) {}
  
  public void setPositionType(PositionType paramPositionType) {}
  
  public void setRight(float paramFloat)
  {
    AppMethodBeat.i(18813);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "right", new float[] { this.mKView.getRight(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18813);
  }
  
  public void setRightPercent(float paramFloat) {}
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(18819);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "rotation", new float[] { this.mKView.getRotation(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18819);
  }
  
  public void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(18820);
    Log.d("base_MMKView", "setScaleX此时进入动画setter状态。");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "scaleX", new float[] { this.mKView.getScaleX(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18820);
  }
  
  public void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(18821);
    Log.d("base_MMKView", "setScaleY此时进入动画setter状态。");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "scaleY", new float[] { this.mKView.getScaleY(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18821);
  }
  
  public void setSecure(boolean paramBoolean) {}
  
  public void setShadowColor(DynamicColor paramDynamicColor) {}
  
  public void setShadowOffset(float paramFloat) {}
  
  public void setShadowRadius(float paramFloat) {}
  
  public void setTop(float paramFloat)
  {
    AppMethodBeat.i(18812);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "top", new float[] { this.mKView.getTop(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18812);
  }
  
  public void setTopLeftCornerRadius(float paramFloat) {}
  
  public void setTopPercent(float paramFloat) {}
  
  public void setTopRightCornerRadius(float paramFloat) {}
  
  public void setTranslateX(float paramFloat)
  {
    AppMethodBeat.i(18817);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "translateX", new float[] { this.mKView.getTranslateX(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18817);
  }
  
  public void setTranslateY(float paramFloat)
  {
    AppMethodBeat.i(18818);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "translateY", new float[] { this.mKView.getTranslateY(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18818);
  }
  
  public void setViewId(String paramString) {}
  
  public void setVisible(Visible paramVisible) {}
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(18809);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "width", new float[] { this.mKView.getWidth(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(18809);
  }
  
  public void setWidthPercent(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KViewAnimatorProxy
 * JD-Core Version:    0.7.0.1
 */