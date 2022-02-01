package com.tencent.theme;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.LongSparseArray;

@TargetApi(16)
public class h
  extends LongSparseArray<Drawable.ConstantState>
{
  private int a;
  private g b;
  
  public h(int paramInt, g paramg)
  {
    this.a = paramInt;
    this.b = paramg;
  }
  
  public Drawable.ConstantState a(int paramInt)
  {
    return (Drawable.ConstantState)this.b.b[this.a].valueAt(paramInt);
  }
  
  public Drawable.ConstantState a(long paramLong)
  {
    return this.b.a(this.a, paramLong);
  }
  
  public void a(long paramLong, Drawable.ConstantState paramConstantState)
  {
    this.b.b[this.a].put(paramLong, paramConstantState);
  }
  
  public int size()
  {
    return this.b.b[this.a].size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.h
 * JD-Core Version:    0.7.0.1
 */