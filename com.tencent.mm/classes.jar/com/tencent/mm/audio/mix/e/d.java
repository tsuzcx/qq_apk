package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d
  implements i
{
  private h cgF;
  private int cgG = 4;
  
  public final com.tencent.mm.audio.mix.a.b G(List<com.tencent.mm.audio.mix.a.d> paramList)
  {
    AppMethodBeat.i(137116);
    if (this.cgF == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
      AppMethodBeat.o(137116);
      return null;
    }
    com.tencent.mm.audio.mix.a.b localb = com.tencent.mm.audio.mix.b.a.CY().CZ();
    if (!this.cgF.a(localb, paramList))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mix audio fail");
      AppMethodBeat.o(137116);
      return null;
    }
    AppMethodBeat.o(137116);
    return localb;
  }
  
  public final void init()
  {
    AppMethodBeat.i(137115);
    Object localObject;
    if (this.cgF == null) {
      switch (this.cgG)
      {
      default: 
        localObject = new j();
      }
    }
    for (;;)
    {
      this.cgF = ((h)localObject);
      AppMethodBeat.o(137115);
      return;
      localObject = new n();
      continue;
      localObject = new a();
      continue;
      localObject = new k();
      continue;
      localObject = new j();
      continue;
      localObject = new m();
      continue;
      localObject = new o();
      continue;
      localObject = new l();
      continue;
      localObject = new b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.d
 * JD-Core Version:    0.7.0.1
 */