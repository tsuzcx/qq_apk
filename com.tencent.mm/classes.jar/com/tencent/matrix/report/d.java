package com.tencent.matrix.report;

import java.util.HashSet;

public class d
{
  private final a cwX;
  private final HashSet<String> cwY = new HashSet();
  
  public d(a parama)
  {
    this.cwX = parama;
  }
  
  protected final void b(c paramc)
  {
    if (this.cwX == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.cwX.onDetectIssue(paramc);
  }
  
  protected void cW(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.cwY.add(paramString);
  }
  
  protected boolean cX(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.cwY.contains(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onDetectIssue(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.d
 * JD-Core Version:    0.7.0.1
 */