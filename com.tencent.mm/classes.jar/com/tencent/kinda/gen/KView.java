package com.tencent.kinda.gen;

public abstract interface KView
{
  public abstract void accessibilityClickFrom(KView paramKView);
  
  public abstract void accessibilityTraitsType(TraitsType paramTraitsType);
  
  public abstract void addBlurEffect(int paramInt);
  
  public abstract KPoint convertPointToScreen(KPoint paramKPoint);
  
  public abstract KPoint convertPointToView(KPoint paramKPoint, KView paramKView);
  
  public abstract void expandHitSize(float paramFloat1, float paramFloat2);
  
  public abstract String getAccessibilityString();
  
  public abstract boolean getAccessible();
  
  public abstract Align getAlignSelf();
  
  public abstract float getAlpha();
  
  public abstract float getAspectRatio();
  
  public abstract DynamicColor getBackgroundColor();
  
  public abstract DynamicColor getBorderColor();
  
  public abstract DynamicColor getBorderPressedColor();
  
  public abstract float getBorderWidth();
  
  public abstract float getBottom();
  
  public abstract float getBottomLeftCornerRadius();
  
  public abstract float getBottomPercent();
  
  public abstract float getBottomRightCornerRadius();
  
  public abstract boolean getClickable();
  
  public abstract float getCornerRadius();
  
  public abstract boolean getEnableHighLight();
  
  public abstract float getFlexBasis();
  
  public abstract float getFlexGrow();
  
  public abstract float getFlexShrink();
  
  public abstract float getFrameOriginX();
  
  public abstract float getFrameOriginY();
  
  public abstract float getHeight();
  
  public abstract float getHeightPercent();
  
  public abstract boolean getIsRefreshing();
  
  public abstract float getLeft();
  
  public abstract float getLeftPercent();
  
  public abstract float getMarginBottom();
  
  public abstract float getMarginBottomPercent();
  
  public abstract float getMarginLeft();
  
  public abstract float getMarginLeftPercent();
  
  public abstract float getMarginRight();
  
  public abstract float getMarginRightPercent();
  
  public abstract float getMarginTop();
  
  public abstract float getMarginTopPercent();
  
  public abstract float getMaxHeight();
  
  public abstract float getMaxWidth();
  
  public abstract float getMinHeight();
  
  public abstract float getMinWidth();
  
  public abstract float getPaddingBottom();
  
  public abstract float getPaddingBottomPercent();
  
  public abstract float getPaddingLeft();
  
  public abstract float getPaddingLeftPercent();
  
  public abstract float getPaddingRight();
  
  public abstract float getPaddingRightPercent();
  
  public abstract float getPaddingTop();
  
  public abstract float getPaddingTopPercent();
  
  public abstract PositionType getPositionType();
  
  public abstract String getReportId();
  
  public abstract float getRight();
  
  public abstract float getRightPercent();
  
  public abstract float getRotation();
  
  public abstract float getScaleX();
  
  public abstract float getScaleY();
  
  public abstract boolean getSecure();
  
  public abstract DynamicColor getShadowColor();
  
  public abstract float getShadowOffset();
  
  public abstract float getShadowRadius();
  
  public abstract boolean getSupportDynamicSize();
  
  public abstract float getTop();
  
  public abstract float getTopLeftCornerRadius();
  
  public abstract float getTopPercent();
  
  public abstract float getTopRightCornerRadius();
  
  public abstract float getTranslateX();
  
  public abstract float getTranslateY();
  
  public abstract String getViewId();
  
  public abstract Visible getVisible();
  
  public abstract float getWidth();
  
  public abstract float getWidthPercent();
  
  public abstract void initWithPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  public abstract void removeBlurEffect();
  
  public abstract void requestFrameImpl(VoidKRectCallback paramVoidKRectCallback);
  
  public abstract void requestLayout();
  
  public abstract void setAccessibilityString(String paramString);
  
  public abstract void setAccessible(boolean paramBoolean);
  
  public abstract void setAlignSelf(Align paramAlign);
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAspectRatio(float paramFloat);
  
  public abstract void setBackgroundColor(DynamicColor paramDynamicColor);
  
  public abstract void setBorderColor(DynamicColor paramDynamicColor);
  
  public abstract void setBorderPressedColor(DynamicColor paramDynamicColor);
  
  public abstract void setBorderWidth(float paramFloat);
  
  public abstract void setBottom(float paramFloat);
  
  public abstract void setBottomLeftCornerRadius(float paramFloat);
  
  public abstract void setBottomPercent(float paramFloat);
  
  public abstract void setBottomRightCornerRadius(float paramFloat);
  
  public abstract void setClickable(boolean paramBoolean);
  
  public abstract void setCornerRadius(float paramFloat);
  
  public abstract void setEnableHighLight(boolean paramBoolean);
  
  public abstract void setFlexBasis(float paramFloat);
  
  public abstract void setFlexGrow(float paramFloat);
  
  public abstract void setFlexShrink(float paramFloat);
  
  public abstract void setFrameImpl(KRect paramKRect, VoidCallback paramVoidCallback);
  
  public abstract void setHeight(float paramFloat);
  
  public abstract void setHeightPercent(float paramFloat);
  
  public abstract void setIsRefreshing(boolean paramBoolean);
  
  public abstract void setLeft(float paramFloat);
  
  public abstract void setLeftPercent(float paramFloat);
  
  public abstract void setMarginBottom(float paramFloat);
  
  public abstract void setMarginBottomPercent(float paramFloat);
  
  public abstract void setMarginLeft(float paramFloat);
  
  public abstract void setMarginLeftPercent(float paramFloat);
  
  public abstract void setMarginRight(float paramFloat);
  
  public abstract void setMarginRightPercent(float paramFloat);
  
  public abstract void setMarginTop(float paramFloat);
  
  public abstract void setMarginTopPercent(float paramFloat);
  
  public abstract void setMaxHeight(float paramFloat);
  
  public abstract void setMaxWidth(float paramFloat);
  
  public abstract void setMinHeight(float paramFloat);
  
  public abstract void setMinWidth(float paramFloat);
  
  public abstract void setOnClickCallback(KViewOnClickCallback paramKViewOnClickCallback);
  
  public abstract void setOnLongClickCallback(KViewOnLongClickCallback paramKViewOnLongClickCallback);
  
  public abstract void setOnTouchCallback(KViewOnTouchCallback paramKViewOnTouchCallback);
  
  public abstract void setPaddingBottom(float paramFloat);
  
  public abstract void setPaddingBottomPercent(float paramFloat);
  
  public abstract void setPaddingLeft(float paramFloat);
  
  public abstract void setPaddingLeftPercent(float paramFloat);
  
  public abstract void setPaddingRight(float paramFloat);
  
  public abstract void setPaddingRightPercent(float paramFloat);
  
  public abstract void setPaddingTop(float paramFloat);
  
  public abstract void setPaddingTopPercent(float paramFloat);
  
  public abstract void setPositionType(PositionType paramPositionType);
  
  public abstract void setReportId(String paramString);
  
  public abstract void setRight(float paramFloat);
  
  public abstract void setRightPercent(float paramFloat);
  
  public abstract void setRotation(float paramFloat);
  
  public abstract void setScaleX(float paramFloat);
  
  public abstract void setScaleY(float paramFloat);
  
  public abstract void setSecure(boolean paramBoolean);
  
  public abstract void setShadowColor(DynamicColor paramDynamicColor);
  
  public abstract void setShadowOffset(float paramFloat);
  
  public abstract void setShadowRadius(float paramFloat);
  
  public abstract void setSupportDynamicSize(boolean paramBoolean);
  
  public abstract void setTop(float paramFloat);
  
  public abstract void setTopLeftCornerRadius(float paramFloat);
  
  public abstract void setTopPercent(float paramFloat);
  
  public abstract void setTopRightCornerRadius(float paramFloat);
  
  public abstract void setTranslateX(float paramFloat);
  
  public abstract void setTranslateY(float paramFloat);
  
  public abstract void setViewId(String paramString);
  
  public abstract void setVisible(Visible paramVisible);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void setWidthPercent(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.gen.KView
 * JD-Core Version:    0.7.0.1
 */