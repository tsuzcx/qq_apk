package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ji$a<D extends jh>
  extends kp<String, D>
{
  private jg.b<D> a;
  
  public ji$a(int paramInt, jg.b<D> paramb)
  {
    super(paramInt);
    this.a = paramb;
  }
  
  private static int a(D paramD)
  {
    AppMethodBeat.i(225935);
    if (paramD != null)
    {
      int i = paramD.a();
      AppMethodBeat.o(225935);
      return i;
    }
    AppMethodBeat.o(225935);
    return 0;
  }
  
  private void a(boolean paramBoolean, D paramD)
  {
    AppMethodBeat.i(225945);
    if ((paramBoolean) && (this.a != null)) {
      this.a.a(paramD);
    }
    AppMethodBeat.o(225945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ji.a
 * JD-Core Version:    0.7.0.1
 */