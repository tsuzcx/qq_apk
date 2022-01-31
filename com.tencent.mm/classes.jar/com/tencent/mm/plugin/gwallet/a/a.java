package com.tencent.mm.plugin.gwallet.a;

public final class a
  extends Exception
{
  c liX;
  
  public a(int paramInt, String paramString)
  {
    this(new c(paramInt, paramString));
  }
  
  private a(c paramc)
  {
    this(paramc, null);
  }
  
  private a(c paramc, Exception paramException)
  {
    super(paramc.ljq, paramException);
    this.liX = paramc;
  }
  
  public a(String paramString, Exception paramException)
  {
    this(new c(-1001, paramString), paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.a
 * JD-Core Version:    0.7.0.1
 */