package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

public final class kl$a
  implements kt.h
{
  int a = 3;
  String b = "TT";
  
  private a a(int paramInt)
  {
    AppMethodBeat.i(221606);
    kl.b().incrementAndGet();
    this.a = paramInt;
    AppMethodBeat.o(221606);
    return this;
  }
  
  private a a(String paramString)
  {
    AppMethodBeat.i(221600);
    kl.b().incrementAndGet();
    this.b = paramString;
    AppMethodBeat.o(221600);
    return this;
  }
  
  public final kt.l a()
  {
    AppMethodBeat.i(221633);
    kt.d locald = new kt.d();
    AppMethodBeat.o(221633);
    return locald;
  }
  
  public final void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(221624);
    kl.b().incrementAndGet();
    kl.a(this.a, this.b, paramVarArgs);
    kl.c().a(this);
    AppMethodBeat.o(221624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kl.a
 * JD-Core Version:    0.7.0.1
 */