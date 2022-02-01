package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements d, Runnable
{
  private long lDC = 0L;
  private long lDD = 0L;
  
  public final void bEy()
  {
    this.lDC = System.currentTimeMillis();
    YC();
  }
  
  public final void bjm()
  {
    this.lDC = System.currentTimeMillis();
    b.Z(this);
  }
  
  public void callback()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.lDD = 0L;
      this.lDC = 0L;
    }
  }
  
  public void run()
  {
    this.lDD = System.currentTimeMillis();
    YC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */