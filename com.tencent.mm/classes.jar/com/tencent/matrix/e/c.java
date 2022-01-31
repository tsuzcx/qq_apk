package com.tencent.matrix.e;

import java.util.HashSet;

public class c
{
  private final HashSet<String> bOA = new HashSet();
  private final a bOz;
  
  public c(a parama)
  {
    this.bOz = parama;
  }
  
  protected final void b(b paramb)
  {
    if (this.bOz == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.bOz.onDetectIssue(paramb);
  }
  
  protected boolean cA(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.bOA.contains(paramString);
  }
  
  protected void cz(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.bOA.add(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onDetectIssue(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.c
 * JD-Core Version:    0.7.0.1
 */