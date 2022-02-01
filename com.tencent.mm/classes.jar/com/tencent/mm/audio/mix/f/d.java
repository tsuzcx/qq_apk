package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.util.List;

public final class d
  implements i
{
  private h dwA;
  private int dwB = 4;
  
  public final com.tencent.mm.audio.mix.a.b P(List<e> paramList)
  {
    AppMethodBeat.i(136865);
    if (this.dwA == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
      AppMethodBeat.o(136865);
      return null;
    }
    com.tencent.mm.audio.mix.a.b localb = com.tencent.mm.audio.mix.b.b.YD().YE();
    if (!this.dwA.a(localb, paramList))
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixer", "mix audio fail");
      AppMethodBeat.o(136865);
      return null;
    }
    AppMethodBeat.o(136865);
    return localb;
  }
  
  public final void init()
  {
    AppMethodBeat.i(136864);
    Object localObject;
    if (this.dwA == null) {
      switch (this.dwB)
      {
      default: 
        localObject = new j();
      }
    }
    for (;;)
    {
      this.dwA = ((h)localObject);
      AppMethodBeat.o(136864);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */