package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kt$d
  extends kt.l
{
  private volatile boolean a;
  
  public final void a()
  {
    AppMethodBeat.i(226044);
    if (this.a)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Already released");
      AppMethodBeat.o(226044);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(226044);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kt.d
 * JD-Core Version:    0.7.0.1
 */