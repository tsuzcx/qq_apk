package com.tencent.mm.plugin.appbrand.widget.recentview;

public final class b$a
{
  public StringBuilder hCA;
  public StringBuilder hCB;
  public String hCv;
  public StringBuilder hCw;
  public StringBuilder hCx;
  public StringBuilder hCy;
  public StringBuilder hCz;
  
  public b$a(String paramString)
  {
    this.hCv = paramString;
    this.hCw = new StringBuilder();
    this.hCx = new StringBuilder();
    this.hCy = new StringBuilder();
    this.hCz = new StringBuilder();
    this.hCA = new StringBuilder();
    this.hCB = new StringBuilder();
  }
  
  public final String toString()
  {
    return String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.hCv, this.hCw.toString(), this.hCx.toString(), this.hCy.toString(), this.hCz.toString(), this.hCA.toString(), this.hCB.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b.a
 * JD-Core Version:    0.7.0.1
 */