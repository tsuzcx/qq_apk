package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements c, Runnable
{
  private long gih = 0L;
  private long gii = 0L;
  
  public final void ahU()
  {
    this.gih = System.currentTimeMillis();
    b.y(this);
  }
  
  public final void ahV()
  {
    this.gih = System.currentTimeMillis();
    ahX();
  }
  
  public void pQ()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.gii = 0L;
      this.gih = 0L;
    }
  }
  
  public void run()
  {
    this.gii = System.currentTimeMillis();
    ahX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */