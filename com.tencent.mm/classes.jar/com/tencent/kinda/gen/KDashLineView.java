package com.tencent.kinda.gen;

public abstract interface KDashLineView
  extends KView
{
  public abstract DynamicColor getDashColor();
  
  public abstract float getDashWidth();
  
  public abstract boolean getVertical();
  
  public abstract void setDashColor(DynamicColor paramDynamicColor);
  
  public abstract void setDashWidth(float paramFloat);
  
  public abstract void setVertical(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KDashLineView
 * JD-Core Version:    0.7.0.1
 */