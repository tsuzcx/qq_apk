package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"})
public enum e$b
{
  static
  {
    AppMethodBeat.i(216823);
    b localb1 = new b("NO_LINK_MIC", 0);
    gHT = localb1;
    b localb2 = new b("AUDIO_LINK_MIC", 1);
    gHU = localb2;
    b localb3 = new b("VIDEO_LINK_MIC", 2);
    gHV = localb3;
    gHW = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(216823);
  }
  
  private e$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e.b
 * JD-Core Version:    0.7.0.1
 */