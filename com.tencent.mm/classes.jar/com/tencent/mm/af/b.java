package com.tencent.mm.af;

public final class b
{
  public String appId = "";
  public String bFM = "";
  public int bFN = 0;
  public String ceM = "";
  public int eaN = 0;
  public boolean eaO = false;
  public boolean eaP = false;
  public long eaQ = 0L;
  public double eaR = 1.0D;
  public long eaS = 0L;
  public long eaT = 0L;
  public long eaU = 0L;
  public e eaV;
  public String filePath = "";
  public int fromScene = 0;
  public String processName = "";
  public int startTime = 0;
  
  public final boolean a(b paramb)
  {
    if (paramb == null) {}
    while ((this.bFM == null) || (!this.bFM.equalsIgnoreCase(paramb.bFM)) || (this.ceM == null) || (!this.ceM.equalsIgnoreCase(paramb.ceM))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.af.b
 * JD-Core Version:    0.7.0.1
 */