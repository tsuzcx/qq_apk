package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "", "(Ljava/lang/String;I)V", "MMLiveStreamSwitchMode_Fixed", "MMLiveStreamSwitchMode_Auto", "MMLiveStreamSwitchMode_ML", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  static
  {
    AppMethodBeat.i(247908);
    mMz = new a("MMLiveStreamSwitchMode_Fixed", 0);
    mMA = new a("MMLiveStreamSwitchMode_Auto", 1);
    mMB = new a("MMLiveStreamSwitchMode_ML", 2);
    mMC = new a[] { mMz, mMA, mMB };
    AppMethodBeat.o(247908);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.a
 * JD-Core Version:    0.7.0.1
 */