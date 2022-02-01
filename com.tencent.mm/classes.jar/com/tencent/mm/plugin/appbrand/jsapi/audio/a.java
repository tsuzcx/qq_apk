package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements d, Runnable
{
  private long oze = 0L;
  private long ozf = 0L;
  
  public final void bPY()
  {
    this.oze = System.currentTimeMillis();
    adj();
  }
  
  public final void bsM()
  {
    this.oze = System.currentTimeMillis();
    b.ab(this);
  }
  
  public void callback()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.ozf = 0L;
      this.oze = 0L;
    }
  }
  
  public void run()
  {
    this.ozf = System.currentTimeMillis();
    adj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */