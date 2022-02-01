package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements d, Runnable
{
  private long kvU = 0L;
  private long kvV = 0L;
  
  public void BJ()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.kvV = 0L;
      this.kvU = 0L;
    }
  }
  
  public final void aOD()
  {
    this.kvU = System.currentTimeMillis();
    b.W(this);
  }
  
  public final void biB()
  {
    this.kvU = System.currentTimeMillis();
    Ox();
  }
  
  public void run()
  {
    this.kvV = System.currentTimeMillis();
    Ox();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */