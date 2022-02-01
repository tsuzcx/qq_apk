package com.tencent.live2.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$f
{
  public int a = 2;
  public boolean b = false;
  public boolean c = false;
  
  public a$f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean2;
    this.c = paramBoolean1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211545);
    String str = "[qualityIndex:" + this.a + "][enableAdjRes:" + this.b + "][enableAdjBitrate:" + this.c + "]";
    AppMethodBeat.o(211545);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.live2.impl.a.f
 * JD-Core Version:    0.7.0.1
 */