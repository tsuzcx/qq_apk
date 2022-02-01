package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum i$b
{
  static
  {
    AppMethodBeat.i(247926);
    mNU = new b("NO_LINK_MIC", 0);
    mNV = new b("AUDIO_LINK_MIC", 1);
    mNW = new b("VIDEO_LINK_MIC", 2);
    mNX = new b[] { mNU, mNV, mNW };
    AppMethodBeat.o(247926);
  }
  
  private i$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.i.b
 * JD-Core Version:    0.7.0.1
 */