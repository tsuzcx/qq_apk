package com.google.android.flexbox;

import android.os.Parcelable;

abstract interface FlexItem
  extends Parcelable
{
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
  
  public abstract int rm();
  
  public abstract boolean rn();
  
  public abstract float ro();
  
  public abstract int rp();
  
  public abstract int rq();
  
  public abstract int rr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.flexbox.FlexItem
 * JD-Core Version:    0.7.0.1
 */