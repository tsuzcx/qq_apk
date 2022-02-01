package com.tencent.matrix.report;

import java.util.HashSet;

public class d
{
  private final a cFb;
  private final HashSet<String> cFc = new HashSet();
  
  public d(a parama)
  {
    this.cFb = parama;
  }
  
  protected final void b(c paramc)
  {
    if (this.cFb == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.cFb.onDetectIssue(paramc);
  }
  
  protected void dO(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.cFc.add(paramString);
  }
  
  protected boolean dP(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.cFc.contains(paramString);
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