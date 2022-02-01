package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.util.List;

public final class d
  implements i
{
  private h htt;
  private int htu = 4;
  
  public final com.tencent.mm.audio.mix.a.b bm(List<e> paramList)
  {
    AppMethodBeat.i(136865);
    if (this.htt == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
      AppMethodBeat.o(136865);
      return null;
    }
    com.tencent.mm.audio.mix.a.b localb = com.tencent.mm.audio.mix.b.b.aFj().aFk();
    if (!this.htt.a(localb, paramList))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mix audio fail");
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
    if (this.htt == null) {
      switch (this.htu)
      {
      default: 
        localObject = new j();
      }
    }
    for (;;)
    {
      this.htt = ((h)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.d
 * JD-Core Version:    0.7.0.1
 */