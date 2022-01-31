package com.tencent.matrix.c;

import java.util.HashSet;

public class c
{
  private final a boM;
  private final HashSet<String> boN = new HashSet();
  
  public c(a parama)
  {
    this.boM = parama;
  }
  
  public void bx(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.boN.add(paramString);
  }
  
  public boolean by(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.boN.contains(paramString);
  }
  
  public final void c(b paramb)
  {
    if (this.boM == null) {
      throw new RuntimeException("publish issue, but issue listener is null");
    }
    this.boM.a(paramb);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.c.c
 * JD-Core Version:    0.7.0.1
 */