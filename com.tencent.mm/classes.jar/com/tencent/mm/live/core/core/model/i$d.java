package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "", "(Ljava/lang/String;I)V", "LIVE_OUT_ROOM", "LIVE_IN_ROOM", "LIVE_JOIN_ROOM", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum i$d
{
  static
  {
    AppMethodBeat.i(247936);
    mOb = new d("LIVE_OUT_ROOM", 0);
    mOc = new d("LIVE_IN_ROOM", 1);
    mOd = new d("LIVE_JOIN_ROOM", 2);
    mOe = new d[] { mOb, mOc, mOd };
    AppMethodBeat.o(247936);
  }
  
  private i$d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.i.d
 * JD-Core Version:    0.7.0.1
 */