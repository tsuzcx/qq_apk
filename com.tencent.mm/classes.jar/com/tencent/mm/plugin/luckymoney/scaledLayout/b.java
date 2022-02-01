package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

public abstract class b
{
  final Rect Ui = new Rect();
  protected final RecyclerView.LayoutManager arI;
  private int arJ = -2147483648;
  
  private b(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.arI = paramLayoutManager;
  }
  
  public static b b(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("invalid orientation");
    case 0: 
      return new b.1(paramLayoutManager);
    }
    return new b.2(paramLayoutManager);
  }
  
  public abstract int bs(View paramView);
  
  public abstract int bt(View paramView);
  
  public abstract int efm();
  
  public abstract int kH();
  
  public abstract int kJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b
 * JD-Core Version:    0.7.0.1
 */