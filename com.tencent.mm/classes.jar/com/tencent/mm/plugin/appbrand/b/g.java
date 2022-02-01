package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.sdk.d.c;

public abstract class g
  extends c
{
  private final h iRG;
  
  public g(h paramh)
  {
    this.iRG = paramh;
  }
  
  public void enter()
  {
    super.enter();
    this.iRG.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.g
 * JD-Core Version:    0.7.0.1
 */