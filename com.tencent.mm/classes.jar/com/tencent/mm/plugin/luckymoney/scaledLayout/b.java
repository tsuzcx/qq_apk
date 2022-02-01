package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;

public abstract class b
{
  final Rect TW = new Rect();
  protected final RecyclerView.i arw;
  private int arx = -2147483648;
  
  private b(RecyclerView.i parami)
  {
    this.arw = parami;
  }
  
  public static b b(RecyclerView.i parami, int paramInt)
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
  
  public abstract int br(View paramView);
  
  public abstract int bs(View paramView);
  
  public abstract int dlr();
  
  public abstract int kB();
  
  public abstract int kD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.b
 * JD-Core Version:    0.7.0.1
 */