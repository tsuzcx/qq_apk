package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class kt$c
  extends kt.l
{
  private volatile RuntimeException a;
  
  public final void a()
  {
    AppMethodBeat.i(226056);
    if (this.a != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Already released", this.a);
      AppMethodBeat.o(226056);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(226056);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(226063);
    if (paramBoolean)
    {
      this.a = new RuntimeException("Released");
      AppMethodBeat.o(226063);
      return;
    }
    this.a = null;
    AppMethodBeat.o(226063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kt.c
 * JD-Core Version:    0.7.0.1
 */