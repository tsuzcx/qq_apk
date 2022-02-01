package com.google.android.flexbox;

import android.os.Parcelable;

abstract interface FlexItem
  extends Parcelable
{
  public abstract int Vf();
  
  public abstract boolean Vg();
  
  public abstract float Vh();
  
  public abstract int Vi();
  
  public abstract int Vj();
  
  public abstract int Vk();
  
  public abstract float getFlexGrow();
  
  public abstract float getFlexShrink();
  
  public abstract int getHeight();
  
  public abstract int getMarginBottom();
  
  public abstract int getMaxHeight();
  
  public abstract int getMaxWidth();
  
  public abstract int getMinHeight();
  
  public abstract int getMinWidth();
  
  public abstract int getOrder();
  
  public abstract int getWidth();
  
  public abstract void setMinHeight(int paramInt);
  
  public abstract void setMinWidth(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.flexbox.FlexItem
 * JD-Core Version:    0.7.0.1
 */