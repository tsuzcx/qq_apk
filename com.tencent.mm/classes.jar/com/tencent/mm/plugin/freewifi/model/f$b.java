package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;

public final class f$b
{
  public long mKe;
  public String mKo;
  public String mKp;
  public String mKq;
  public boolean mKr;
  
  f$b(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(20720);
    this.mKo = m.Ou(paramString1);
    this.mKp = paramString2;
    this.mKq = paramString3;
    this.mKe = paramLong;
    this.mKr = false;
    AppMethodBeat.o(20720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.f.b
 * JD-Core Version:    0.7.0.1
 */