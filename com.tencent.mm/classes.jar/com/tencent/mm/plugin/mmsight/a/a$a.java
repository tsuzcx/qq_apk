package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  int scene;
  int source;
  
  public a$a(int paramInt)
  {
    AppMethodBeat.i(94384);
    this.source = 2;
    if (paramInt == 1)
    {
      this.scene = 1;
      AppMethodBeat.o(94384);
      return;
    }
    if (paramInt == 2)
    {
      this.scene = 2;
      AppMethodBeat.o(94384);
      return;
    }
    if (paramInt == 512)
    {
      this.source = 1;
      this.scene = 2;
      AppMethodBeat.o(94384);
      return;
    }
    if (paramInt == 4) {
      this.scene = 4;
    }
    AppMethodBeat.o(94384);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94385);
    String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.source + '}';
    AppMethodBeat.o(94385);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a.a
 * JD-Core Version:    0.7.0.1
 */