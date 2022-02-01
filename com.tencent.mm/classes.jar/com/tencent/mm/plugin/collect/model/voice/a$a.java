package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.mm.autogen.a.cv;
import com.tencent.mm.autogen.a.cv.a;

public final class a$a
{
  public long delay;
  public int fee;
  public String hCH;
  public String hCI;
  public String hCJ;
  public String hCK;
  public int source;
  
  public a$a(a parama, cv paramcv)
  {
    this.fee = paramcv.hCG.fee;
    this.hCH = paramcv.hCG.hCH;
    this.hCI = paramcv.hCG.hCI;
    this.hCJ = paramcv.hCG.hCJ;
    this.delay = paramcv.hCG.delay;
    this.source = paramcv.hCG.source;
    this.hCK = paramcv.hCG.hCK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.a
 * JD-Core Version:    0.7.0.1
 */