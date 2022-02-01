package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import java.util.ArrayList;

public final class b
  implements f
{
  private String appId;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public final void adj()
  {
    AppMethodBeat.i(136750);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", new Object[] { this.appId });
    com.tencent.mm.audio.mix.b.f.ads().clearCache();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
    ArrayList localArrayList = com.tencent.mm.audio.mix.b.f.ads().adu();
    if (localArrayList.size() > 0) {
      a.c(this.appId, localArrayList);
    }
    AppMethodBeat.o(136750);
  }
  
  public final void end()
  {
    AppMethodBeat.i(136751);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
    AppMethodBeat.o(136751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.b
 * JD-Core Version:    0.7.0.1
 */