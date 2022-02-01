package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

final class i
{
  public static final i agZn;
  public static final i agZo;
  boolean agZp;
  String agZq;
  boolean agZr;
  Map<String, k<?>> agZs;
  
  static
  {
    AppMethodBeat.i(231622);
    agZn = new i();
    i locali = new i().jQv();
    locali.agZp = true;
    agZo = locali;
    AppMethodBeat.o(231622);
  }
  
  public i()
  {
    AppMethodBeat.i(231608);
    this.agZp = false;
    this.agZq = "__content__";
    this.agZr = false;
    this.agZs = Collections.emptyMap();
    AppMethodBeat.o(231608);
  }
  
  private i(boolean paramBoolean1, String paramString, boolean paramBoolean2, Map<String, k<?>> paramMap)
  {
    AppMethodBeat.i(231612);
    this.agZp = paramBoolean1;
    this.agZq = paramString;
    this.agZr = paramBoolean2;
    this.agZs = Collections.unmodifiableMap(paramMap);
    AppMethodBeat.o(231612);
  }
  
  private i jQv()
  {
    AppMethodBeat.i(231616);
    i locali = new i(this.agZp, this.agZq, this.agZr, this.agZs);
    AppMethodBeat.o(231616);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.i
 * JD-Core Version:    0.7.0.1
 */