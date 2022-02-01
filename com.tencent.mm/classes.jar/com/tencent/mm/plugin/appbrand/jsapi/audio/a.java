package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements f, Runnable
{
  private long rCW = 0L;
  private long rCX = 0L;
  
  public final void bQt()
  {
    this.rCW = System.currentTimeMillis();
    b.ah(this);
  }
  
  public void callback()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.rCX = 0L;
      this.rCW = 0L;
    }
  }
  
  public final void cqe()
  {
    this.rCW = System.currentTimeMillis();
    aFi();
  }
  
  public void run()
  {
    this.rCX = System.currentTimeMillis();
    aFi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */