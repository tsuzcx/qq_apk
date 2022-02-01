package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  implements f
{
  private String appId;
  
  public c(String paramString)
  {
    this.appId = paramString;
  }
  
  public final void aFi()
  {
    AppMethodBeat.i(136752);
    b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "runTask, appId:%s", new Object[] { this.appId });
    com.tencent.mm.audio.mix.b.f localf = com.tencent.mm.audio.mix.b.f.aFr();
    synchronized (localf.hri)
    {
      Iterator localIterator = localf.hrh.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)localf.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).recycle();
        }
      }
    }
    localObject2.hrh.clear();
    localObject2.cache.clear();
    b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "delete all pcm cache File");
    ??? = com.tencent.mm.audio.mix.b.f.aFr().aFt();
    if (((ArrayList)???).size() > 0) {
      a.c(this.appId, (ArrayList)???);
    }
    AppMethodBeat.o(136752);
  }
  
  public final void end()
  {
    AppMethodBeat.i(136753);
    b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "end task");
    AppMethodBeat.o(136753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.c
 * JD-Core Version:    0.7.0.1
 */