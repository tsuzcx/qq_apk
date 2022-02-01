package com.tencent.kinda.gen;

public abstract interface KListView
  extends KView
{
  public abstract void addFooter(KView paramKView);
  
  public abstract void addHeader(KView paramKView);
  
  public abstract boolean getShowScrollBar();
  
  public abstract boolean getVertical();
  
  public abstract void setImpl(KListViewCallback paramKListViewCallback);
  
  public abstract void setOnScrollCallback(KListViewOnScrollCallback paramKListViewOnScrollCallback);
  
  public abstract void setShowScrollBar(boolean paramBoolean);
  
  public abstract void setVertical(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KListView
 * JD-Core Version:    0.7.0.1
 */