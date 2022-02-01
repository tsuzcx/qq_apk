package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a
  implements d, Runnable
{
  private long kzj = 0L;
  private long kzk = 0L;
  
  public void BK()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      System.currentTimeMillis();
      this.kzk = 0L;
      this.kzj = 0L;
    }
  }
  
  public final void aPa()
  {
    this.kzj = System.currentTimeMillis();
    b.U(this);
  }
  
  public final void bjk()
  {
    this.kzj = System.currentTimeMillis();
    Ov();
  }
  
  public void run()
  {
    this.kzk = System.currentTimeMillis();
    Ov();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.a
 * JD-Core Version:    0.7.0.1
 */