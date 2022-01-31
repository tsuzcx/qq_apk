package com.tencent.kinda.framework.widget.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Visible;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class KViewAnimatorProxy
  implements KView
{
  private KView mKView;
  
  public KViewAnimatorProxy(KView paramKView)
  {
    this.mKView = paramKView;
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
  
  public long getBackgroundColor()
  {
    return 0L;
  }
  
  public long getBorderColor()
  {
    return 0L;
  }
  
  public long getBorderPressedColor()
  {
    return 0L;
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
  
  public float getHeight()
  {
    return 0.0F;
  }
  
  public float getHeightPercent()
  {
    return 0.0F;
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
    return 0.0F;
  }
  
  public float getMarginBottomPercent()
  {
    return 0.0F;
  }
  
  public float getMarginLeft()
  {
    return 0.0F;
  }
  
  public float getMarginLeftPercent()
  {
    return 0.0F;
  }
  
  public float getMarginRight()
  {
    return 0.0F;
  }
  
  public float getMarginRightPercent()
  {
    return 0.0F;
  }
  
  public float getMarginTop()
  {
    return 0.0F;
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
  
  public void setAccessibilityString(String paramString) {}
  
  public void setAccessible(boolean paramBoolean) {}
  
  public void setAlignSelf(Align paramAlign) {}
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(144704);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "alpha", new float[] { this.mKView.getAlpha(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144704);
  }
  
  public void setAspectRatio(float paramFloat) {}
  
  public void setBackgroundColor(long paramLong)
  {
    AppMethodBeat.i(144703);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)this.mKView.getBackgroundColor(), (float)paramLong });
    localValueAnimator.addUpdateListener(new KViewAnimatorProxy.1(this));
    KindaGlobalAnimator.addAnimator(localValueAnimator);
    AppMethodBeat.o(144703);
  }
  
  public void setBorderColor(long paramLong) {}
  
  public void setBorderPressedColor(long paramLong) {}
  
  public void setBorderWidth(float paramFloat) {}
  
  public void setBottom(float paramFloat)
  {
    AppMethodBeat.i(144702);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "bottom", new float[] { this.mKView.getBottom(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144702);
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
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(144698);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "height", new float[] { this.mKView.getHeight(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144698);
  }
  
  public void setHeightPercent(float paramFloat) {}
  
  public void setLeft(float paramFloat)
  {
    AppMethodBeat.i(144699);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "left", new float[] { this.mKView.getLeft(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144699);
  }
  
  public void setLeftPercent(float paramFloat) {}
  
  public void setMarginBottom(float paramFloat) {}
  
  public void setMarginBottomPercent(float paramFloat) {}
  
  public void setMarginLeft(float paramFloat) {}
  
  public void setMarginLeftPercent(float paramFloat) {}
  
  public void setMarginRight(float paramFloat) {}
  
  public void setMarginRightPercent(float paramFloat) {}
  
  public void setMarginTop(float paramFloat) {}
  
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
    AppMethodBeat.i(144701);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "right", new float[] { this.mKView.getRight(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144701);
  }
  
  public void setRightPercent(float paramFloat) {}
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(144707);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "rotation", new float[] { this.mKView.getRotation(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144707);
  }
  
  public void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(144708);
    ab.d("base_MMKView", "setScaleX此时进入动画setter状态。");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "scaleX", new float[] { this.mKView.getScaleX(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144708);
  }
  
  public void setScaleY(float paramFloat)
  {
    AppMethodBeat.i(144709);
    ab.d("base_MMKView", "setScaleY此时进入动画setter状态。");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "scaleY", new float[] { this.mKView.getScaleY(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144709);
  }
  
  public void setShadowColor(long paramLong) {}
  
  public void setShadowOffset(float paramFloat) {}
  
  public void setShadowRadius(float paramFloat) {}
  
  public void setTop(float paramFloat)
  {
    AppMethodBeat.i(144700);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "top", new float[] { this.mKView.getTop(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144700);
  }
  
  public void setTopLeftCornerRadius(float paramFloat) {}
  
  public void setTopPercent(float paramFloat) {}
  
  public void setTopRightCornerRadius(float paramFloat) {}
  
  public void setTranslateX(float paramFloat)
  {
    AppMethodBeat.i(144705);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "translateX", new float[] { this.mKView.getTranslateX(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144705);
  }
  
  public void setTranslateY(float paramFloat)
  {
    AppMethodBeat.i(144706);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "translateY", new float[] { this.mKView.getTranslateY(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144706);
  }
  
  public void setViewId(String paramString) {}
  
  public void setVisible(Visible paramVisible) {}
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(144697);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mKView, "width", new float[] { this.mKView.getWidth(), paramFloat });
    localObjectAnimator.setDuration(KindaGlobalAnimator.animateDuration());
    KindaGlobalAnimator.addAnimator(localObjectAnimator);
    AppMethodBeat.o(144697);
  }
  
  public void setWidthPercent(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KViewAnimatorProxy
 * JD-Core Version:    0.7.0.1
 */