package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;

final class c$a
{
  public RecyclerView.v abS;
  public RecyclerView.v abT;
  public int abU;
  public int abV;
  public int abW;
  public int abX;
  
  private c$a(RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    this.abS = paramv1;
    this.abT = paramv2;
  }
  
  c$a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramv1, paramv2);
    this.abU = paramInt1;
    this.abV = paramInt2;
    this.abW = paramInt3;
    this.abX = paramInt4;
  }
  
  public final String toString()
  {
    return "ChangeInfo{oldHolder=" + this.abS + ", newHolder=" + this.abT + ", fromX=" + this.abU + ", fromY=" + this.abV + ", toX=" + this.abW + ", toY=" + this.abX + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.a
 * JD-Core Version:    0.7.0.1
 */