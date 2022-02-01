package com.tencent.matrix.report;

import java.util.HashSet;

public class d
{
  private final a cFI;
  private final HashSet<String> cFJ = new HashSet();
  
  public d(a parama)
  {
    this.cFI = parama;
  }
  
  protected final void b(c paramc)
  {
    if (this.cFI == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.cFI.onDetectIssue(paramc);
  }
  
  protected void dR(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.cFJ.add(paramString);
  }
  
  protected boolean dS(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.cFJ.contains(paramString);
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