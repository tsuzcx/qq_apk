package com.facebook.yoga;

public abstract class YogaNode
{
  public abstract void addChildAt(YogaNode paramYogaNode, int paramInt);
  
  public abstract void calculateLayout(float paramFloat1, float paramFloat2);
  
  public abstract YogaNode cloneWithChildren();
  
  public abstract YogaNode cloneWithoutChildren();
  
  public abstract void copyStyle(YogaNode paramYogaNode);
  
  public abstract void dirty();
  
  public abstract YogaAlign getAlignContent();
  
  public abstract YogaAlign getAlignItems();
  
  public abstract YogaAlign getAlignSelf();
  
  public abstract float getAspectRatio();
  
  public abstract float getBorder(YogaEdge paramYogaEdge);
  
  public abstract YogaNode getChildAt(int paramInt);
  
  public abstract int getChildCount();
  
  public abstract Object getData();
  
  public abstract YogaDisplay getDisplay();
  
  public abstract float getFlex();
  
  public abstract YogaValue getFlexBasis();
  
  public abstract YogaFlexDirection getFlexDirection();
  
  public abstract float getFlexGrow();
  
  public abstract float getFlexShrink();
  
  public abstract YogaValue getHeight();
  
  public abstract YogaJustify getJustifyContent();
  
  public abstract float getLayoutBorder(YogaEdge paramYogaEdge);
  
  public abstract YogaDirection getLayoutDirection();
  
  public abstract float getLayoutHeight();
  
  public abstract float getLayoutMargin(YogaEdge paramYogaEdge);
  
  public abstract float getLayoutPadding(YogaEdge paramYogaEdge);
  
  public abstract float getLayoutWidth();
  
  public abstract float getLayoutX();
  
  public abstract float getLayoutY();
  
  public abstract YogaValue getMargin(YogaEdge paramYogaEdge);
  
  public abstract YogaValue getMaxHeight();
  
  public abstract YogaValue getMaxWidth();
  
  public abstract YogaValue getMinHeight();
  
  public abstract YogaValue getMinWidth();
  
  public abstract YogaOverflow getOverflow();
  
  public abstract YogaNode getOwner();
  
  public abstract YogaValue getPadding(YogaEdge paramYogaEdge);
  
  @Deprecated
  public abstract YogaNode getParent();
  
  public abstract YogaValue getPosition(YogaEdge paramYogaEdge);
  
  public abstract YogaPositionType getPositionType();
  
  public abstract YogaDirection getStyleDirection();
  
  public abstract YogaValue getWidth();
  
  public abstract YogaWrap getWrap();
  
  public abstract boolean hasNewLayout();
  
  public abstract int indexOf(YogaNode paramYogaNode);
  
  public abstract boolean isBaselineDefined();
  
  public abstract boolean isDirty();
  
  public abstract boolean isMeasureDefined();
  
  public abstract boolean isReferenceBaseline();
  
  public abstract void markLayoutSeen();
  
  public abstract void print();
  
  public abstract YogaNode removeChildAt(int paramInt);
  
  public abstract void reset();
  
  public abstract void setAlignContent(YogaAlign paramYogaAlign);
  
  public abstract void setAlignItems(YogaAlign paramYogaAlign);
  
  public abstract void setAlignSelf(YogaAlign paramYogaAlign);
  
  public abstract void setAspectRatio(float paramFloat);
  
  public abstract void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction);
  
  public abstract void setBorder(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setData(Object paramObject);
  
  public abstract void setDirection(YogaDirection paramYogaDirection);
  
  public abstract void setDisplay(YogaDisplay paramYogaDisplay);
  
  public abstract void setFlex(float paramFloat);
  
  public abstract void setFlexBasis(float paramFloat);
  
  public abstract void setFlexBasisAuto();
  
  public abstract void setFlexBasisPercent(float paramFloat);
  
  public abstract void setFlexDirection(YogaFlexDirection paramYogaFlexDirection);
  
  public abstract void setFlexGrow(float paramFloat);
  
  public abstract void setFlexShrink(float paramFloat);
  
  public abstract void setHeight(float paramFloat);
  
  public abstract void setHeightAuto();
  
  public abstract void setHeightPercent(float paramFloat);
  
  public abstract void setIsReferenceBaseline(boolean paramBoolean);
  
  public abstract void setJustifyContent(YogaJustify paramYogaJustify);
  
  public abstract void setMargin(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setMarginAuto(YogaEdge paramYogaEdge);
  
  public abstract void setMarginPercent(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setMaxHeight(float paramFloat);
  
  public abstract void setMaxHeightPercent(float paramFloat);
  
  public abstract void setMaxWidth(float paramFloat);
  
  public abstract void setMaxWidthPercent(float paramFloat);
  
  public abstract void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction);
  
  public abstract void setMinHeight(float paramFloat);
  
  public abstract void setMinHeightPercent(float paramFloat);
  
  public abstract void setMinWidth(float paramFloat);
  
  public abstract void setMinWidthPercent(float paramFloat);
  
  public abstract void setOverflow(YogaOverflow paramYogaOverflow);
  
  public abstract void setPadding(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setPaddingPercent(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setPosition(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setPositionPercent(YogaEdge paramYogaEdge, float paramFloat);
  
  public abstract void setPositionType(YogaPositionType paramYogaPositionType);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void setWidthAuto();
  
  public abstract void setWidthPercent(float paramFloat);
  
  public abstract void setWrap(YogaWrap paramYogaWrap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.YogaNode
 * JD-Core Version:    0.7.0.1
 */