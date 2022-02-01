package com.tencent.matrix.report;

import java.util.HashSet;

public class g
{
  private final a dab;
  private final HashSet<String> dac = new HashSet();
  
  public g(a parama)
  {
    this.dab = parama;
  }
  
  protected final void b(f paramf)
  {
    if (this.dab == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.dab.onDetectIssue(paramf);
  }
  
  protected void fw(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.dac.add(paramString);
  }
  
  protected boolean fx(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.dac.contains(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onDetectIssue(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.g
 * JD-Core Version:    0.7.0.1
 */