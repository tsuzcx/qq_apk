package com.tencent.mm.model;

import com.tencent.mm.as.q;

final class w$c
{
  boolean dVs = false;
  String dVt;
  String filename;
  int pos;
  String url;
  
  public w$c(w paramw, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.url = paramString1;
    if ((q.OQ()) && (paramw.dVk)) {
      this.url = q.mo(this.url);
    }
    this.filename = paramString2;
    this.pos = paramInt;
    this.dVs = false;
    this.dVt = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.w.c
 * JD-Core Version:    0.7.0.1
 */