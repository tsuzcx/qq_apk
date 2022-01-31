package com.tencent.mm.plugin.appbrand.b;

abstract class h
  extends com.tencent.mm.plugin.appbrand.report.h
{
  private final i fGo;
  
  h(i parami)
  {
    this.fGo = parami;
  }
  
  public void enter()
  {
    super.enter();
    this.fGo.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.h
 * JD-Core Version:    0.7.0.1
 */