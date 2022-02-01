package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import com.tencent.mm.pointers.PInt;

public abstract interface f
{
  public abstract boolean F(String paramString, long paramLong);
  
  public abstract boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2);
  
  public abstract int aNC();
  
  public abstract int aND();
  
  @TargetApi(5)
  public abstract boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2);
  
  public abstract int dw(int paramInt1, int paramInt2);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.a.f
 * JD-Core Version:    0.7.0.1
 */