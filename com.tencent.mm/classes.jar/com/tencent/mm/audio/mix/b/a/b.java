package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.d;
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
  
  public final void Dh()
  {
    AppMethodBeat.i(137002);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", new Object[] { this.appId });
    d.De().clearCache();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
    ArrayList localArrayList = d.De().Dg();
    if (localArrayList.size() > 0) {
      a.b(this.appId, localArrayList);
    }
    AppMethodBeat.o(137002);
  }
  
  public final void end()
  {
    AppMethodBeat.i(137003);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
    AppMethodBeat.o(137003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.b
 * JD-Core Version:    0.7.0.1
 */