package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import com.tencent.mm.pointers.PInt;

public abstract interface f
{
  public abstract boolean L(String paramString, long paramLong);
  
  public abstract boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2);
  
  public abstract int aRn();
  
  public abstract int aRo();
  
  @TargetApi(5)
  public abstract boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2);
  
  public abstract int dy(int paramInt1, int paramInt2);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.a.f
 * JD-Core Version:    0.7.0.1
 */