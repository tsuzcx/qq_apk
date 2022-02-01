package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "", "(Ljava/lang/String;I)V", "MMLiveStreamSwitchMode_Fixed", "MMLiveStreamSwitchMode_Auto", "MMLiveStreamSwitchMode_ML", "plugin-core_release"})
public enum a
{
  static
  {
    AppMethodBeat.i(196444);
    a locala1 = new a("MMLiveStreamSwitchMode_Fixed", 0);
    hyD = locala1;
    a locala2 = new a("MMLiveStreamSwitchMode_Auto", 1);
    hyE = locala2;
    a locala3 = new a("MMLiveStreamSwitchMode_ML", 2);
    hyF = locala3;
    hyG = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(196444);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */