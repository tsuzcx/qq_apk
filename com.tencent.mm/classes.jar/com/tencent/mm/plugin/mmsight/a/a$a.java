package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  int cpt;
  int scene;
  
  public a$a(int paramInt)
  {
    AppMethodBeat.i(54953);
    this.cpt = 2;
    if (paramInt == 1)
    {
      this.scene = 1;
      AppMethodBeat.o(54953);
      return;
    }
    if (paramInt == 2)
    {
      this.scene = 2;
      AppMethodBeat.o(54953);
      return;
    }
    if (paramInt == 512)
    {
      this.cpt = 1;
      this.scene = 2;
      AppMethodBeat.o(54953);
      return;
    }
    if (paramInt == 4) {
      this.scene = 4;
    }
    AppMethodBeat.o(54953);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(54954);
    String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.cpt + '}';
    AppMethodBeat.o(54954);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a.a
 * JD-Core Version:    0.7.0.1
 */