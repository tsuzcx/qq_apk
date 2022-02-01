package com.tencent.mm.plugin.appbrand;

public abstract class AppBrandRuntime$b
{
  AppBrandRuntime.a jxC;
  
  public void BI()
  {
    if (this.jxC != null) {
      this.jxC.done();
    }
  }
  
  public void interrupt() {}
  
  public abstract void prepare();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
 * JD-Core Version:    0.7.0.1
 */