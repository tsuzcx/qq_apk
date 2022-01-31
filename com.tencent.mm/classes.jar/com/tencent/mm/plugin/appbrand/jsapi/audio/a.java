package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements c, Runnable
{
  private long hBy = 0L;
  private long hBz = 0L;
  
  public final void aBL()
  {
    this.hBy = System.currentTimeMillis();
    b.G(this);
  }
  
  public final void aBM()
  {
    this.hBy = System.currentTimeMillis();
    Dh();
  }
  
  public void run()
  {
    this.hBz = System.currentTimeMillis();
    Dh();
  }
  
  public void tU()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.hBz = 0L;
      this.hBy = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */