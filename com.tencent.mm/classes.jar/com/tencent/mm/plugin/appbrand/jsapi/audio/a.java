package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements c, Runnable
{
  private long kby = 0L;
  private long kbz = 0L;
  
  public void Am()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.kbz = 0L;
      this.kby = 0L;
    }
  }
  
  public final void aLt()
  {
    this.kby = System.currentTimeMillis();
    b.X(this);
  }
  
  public final void beY()
  {
    this.kby = System.currentTimeMillis();
    MO();
  }
  
  public void run()
  {
    this.kbz = System.currentTimeMillis();
    MO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */