package com.tencent.mm.plugin.ext.c;

public final class e$a
{
  public int jLl;
  private boolean jLm = false;
  public int type;
  public String url;
  
  public e$a()
  {
    this.jLm = true;
  }
  
  public e$a(int paramInt1, String paramString, int paramInt2)
  {
    this.type = paramInt1;
    this.url = paramString;
    this.jLm = false;
    this.jLl = paramInt2;
  }
  
  public final String toString()
  {
    return "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.jLm + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.a
 * JD-Core Version:    0.7.0.1
 */