package com.tencent.matrix.a.b.a;

public abstract class a
  implements g
{
  protected com.tencent.matrix.a.b.c cSq;
  
  public void Se()
  {
    com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onTurnOn", new Object[0]);
  }
  
  public void Sf()
  {
    com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onTurnOff", new Object[0]);
  }
  
  public void ba(long paramLong)
  {
    com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onBackgroundCheck, since background started millis = ".concat(String.valueOf(paramLong)), new Object[0]);
  }
  
  public void d(com.tencent.matrix.a.b.c paramc)
  {
    com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#configure", new Object[0]);
    this.cSq = paramc;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onForeground, foreground = ".concat(String.valueOf(paramBoolean)), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */