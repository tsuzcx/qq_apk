package com.tencent.mm.plugin.appbrand.a;

import com.tencent.mm.sdk.statemachine.State;

public abstract class g
  extends State
{
  private final h nLN;
  
  public g(h paramh)
  {
    this.nLN = paramh;
  }
  
  public void enter()
  {
    super.enter();
    this.nLN.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */