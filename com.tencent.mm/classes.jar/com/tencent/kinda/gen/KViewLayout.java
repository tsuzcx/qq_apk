package com.tencent.kinda.gen;

public abstract interface KViewLayout
  extends KView
{
  public abstract void addView(KView paramKView);
  
  public abstract void addView(KView paramKView, int paramInt);
  
  public abstract Align getAlignContent();
  
  public abstract Align getAlignItems();
  
  public abstract FlexDirection getFlexDirection();
  
  public abstract Wrap getFlexWrap();
  
  public abstract Justify getJustifyContent();
  
  public abstract void removeAllViews();
  
  public abstract void removeView(KView paramKView);
  
  public abstract void setAlignContent(Align paramAlign);
  
  public abstract void setAlignItems(Align paramAlign);
  
  public abstract void setFlexDirection(FlexDirection paramFlexDirection);
  
  public abstract void setFlexWrap(Wrap paramWrap);
  
  public abstract void setFocusableInTouchMode(boolean paramBoolean);
  
  public abstract void setJustifyContent(Justify paramJustify);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewLayout
 * JD-Core Version:    0.7.0.1
 */