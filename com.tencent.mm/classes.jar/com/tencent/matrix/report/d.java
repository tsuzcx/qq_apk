package com.tencent.matrix.report;

import java.util.HashSet;

public class d
{
  private final a cug;
  private final HashSet<String> cuh = new HashSet();
  
  public d(a parama)
  {
    this.cug = parama;
  }
  
  protected final void b(c paramc)
  {
    if (this.cug == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.cug.onDetectIssue(paramc);
  }
  
  protected void cL(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.cuh.add(paramString);
  }
  
  protected boolean cM(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.cuh.contains(paramString);
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