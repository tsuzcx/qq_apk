package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.sdk.statemachine.State;

public abstract class g
  extends State
{
  private final h qLB;
  
  public g(h paramh)
  {
    this.qLB = paramh;
  }
  
  public void enter()
  {
    super.enter();
    this.qLB.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.g
 * JD-Core Version:    0.7.0.1
 */