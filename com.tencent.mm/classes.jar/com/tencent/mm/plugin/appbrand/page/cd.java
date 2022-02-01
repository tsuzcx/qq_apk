package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class cd
{
  final String tBx;
  final int tBy;
  final String url;
  
  public cd(String paramString, int paramInt)
  {
    AppMethodBeat.i(324954);
    this.tBx = paramString;
    this.url = m.fL(paramString);
    this.tBy = paramInt;
    AppMethodBeat.o(324954);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof cd)) && (((cd)paramObject).tBy == this.tBy);
  }
  
  public final int hashCode()
  {
    return this.tBy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cd
 * JD-Core Version:    0.7.0.1
 */