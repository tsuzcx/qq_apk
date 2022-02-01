package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m$b
{
  public static final b sGO;
  public final int sGP;
  public final boolean sGQ;
  public final boolean sGR;
  public final boolean useCronet;
  
  static
  {
    AppMethodBeat.i(328677);
    sGO = new b(-1, false, false);
    AppMethodBeat.o(328677);
  }
  
  public m$b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.sGP = paramInt;
    this.sGQ = paramBoolean1;
    this.useCronet = false;
    this.sGR = paramBoolean2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(328684);
    String str = "ExtraInfo{fixNotifyErrorChannel=" + this.sGP + ", lockCache=" + this.sGQ + ", useCronet=" + this.useCronet + ", interruptCache=" + this.sGR + '}';
    AppMethodBeat.o(328684);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m.b
 * JD-Core Version:    0.7.0.1
 */