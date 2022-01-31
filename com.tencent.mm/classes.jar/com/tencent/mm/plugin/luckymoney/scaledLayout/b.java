package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;

public abstract class b
{
  protected final RecyclerView.i ahB;
  private int ahC = -2147483648;
  final Rect hV = new Rect();
  
  private b(RecyclerView.i parami)
  {
    this.ahB = parami;
  }
  
  public static b a(RecyclerView.i parami, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("invalid orientation");
    case 0: 
      return new b.1(parami);
    }
    return new b.2(parami);
  }
  
  public abstract int bNs();
  
  public abstract int bl(View paramView);
  
  public abstract int bm(View paramView);
  
  public abstract int iI();
  
  public abstract int iK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b
 * JD-Core Version:    0.7.0.1
 */