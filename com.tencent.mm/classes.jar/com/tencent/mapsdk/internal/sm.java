package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sm
  implements no
{
  private nt a;
  private sr b;
  private np c;
  private boolean d;
  
  public sm(sj paramsj, String paramString)
  {
    AppMethodBeat.i(224048);
    this.b = paramsj;
    this.a = new sp(paramsj.G(), paramString);
    this.c = new sn(paramsj.G(), paramString);
    AppMethodBeat.o(224048);
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final void b()
  {
    this.d = true;
  }
  
  public final nt c()
  {
    return this.a;
  }
  
  public final lc d()
  {
    AppMethodBeat.i(224071);
    sl localsl = new sl(this.b);
    AppMethodBeat.o(224071);
    return localsl;
  }
  
  public final np e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sm
 * JD-Core Version:    0.7.0.1
 */