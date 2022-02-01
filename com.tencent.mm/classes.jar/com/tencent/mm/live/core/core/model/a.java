package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "", "(Ljava/lang/String;I)V", "MMLiveStreamSwitchMode_Fixed", "MMLiveStreamSwitchMode_Auto", "MMLiveStreamSwitchMode_ML", "plugin-core_release"})
public enum a
{
  static
  {
    AppMethodBeat.i(200128);
    a locala1 = new a("MMLiveStreamSwitchMode_Fixed", 0);
    klz = locala1;
    a locala2 = new a("MMLiveStreamSwitchMode_Auto", 1);
    klA = locala2;
    a locala3 = new a("MMLiveStreamSwitchMode_ML", 2);
    klB = locala3;
    klC = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(200128);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.a
 * JD-Core Version:    0.7.0.1
 */