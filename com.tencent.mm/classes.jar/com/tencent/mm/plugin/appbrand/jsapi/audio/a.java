package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements c, Runnable
{
  private long jBc = 0L;
  private long jBd = 0L;
  
  public void AI()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.jBd = 0L;
      this.jBc = 0L;
    }
  }
  
  public final void aEC()
  {
    this.jBc = System.currentTimeMillis();
    b.V(this);
  }
  
  public final void aYb()
  {
    this.jBc = System.currentTimeMillis();
    MQ();
  }
  
  public void run()
  {
    this.jBd = System.currentTimeMillis();
    MQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */