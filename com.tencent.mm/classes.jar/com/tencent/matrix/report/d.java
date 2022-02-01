package com.tencent.matrix.report;

import java.util.HashSet;

public class d
{
  private final a cWg;
  private final HashSet<String> cWh = new HashSet();
  
  public d(a parama)
  {
    this.cWg = parama;
  }
  
  protected final void b(c paramc)
  {
    if (this.cWg == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.cWg.onDetectIssue(paramc);
  }
  
  protected void eB(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.cWh.add(paramString);
  }
  
  protected boolean eC(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.cWh.contains(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onDetectIssue(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.d
 * JD-Core Version:    0.7.0.1
 */