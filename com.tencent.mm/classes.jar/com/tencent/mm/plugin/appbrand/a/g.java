package com.tencent.mm.plugin.appbrand.a;

import com.tencent.mm.sdk.statemachine.State;

public abstract class g
  extends State
{
  private final h kRF;
  
  public g(h paramh)
  {
    this.kRF = paramh;
  }
  
  public void enter()
  {
    super.enter();
    this.kRF.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */