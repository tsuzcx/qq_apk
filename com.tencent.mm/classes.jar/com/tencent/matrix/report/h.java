package com.tencent.matrix.report;

import java.util.HashSet;

public class h
{
  private final a eYB;
  private final HashSet<String> eYC = new HashSet();
  
  public h(a parama)
  {
    this.eYB = parama;
  }
  
  protected final void b(g paramg)
  {
    if (this.eYB == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.eYB.onDetectIssue(paramg);
  }
  
  protected void gX(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.eYC.add(paramString);
  }
  
  protected boolean gY(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.eYC.contains(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onDetectIssue(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.h
 * JD-Core Version:    0.7.0.1
 */