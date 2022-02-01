package com.tencent.mm.live.core.mini;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveMiniState;", "", "(Ljava/lang/String;I)V", "STATE_NORMAL", "STATE_DISCONNECT", "STATE_FINISH", "plugin-core_release"})
public enum d
{
  static
  {
    AppMethodBeat.i(196593);
    d locald1 = new d("STATE_NORMAL", 0);
    hCV = locald1;
    d locald2 = new d("STATE_DISCONNECT", 1);
    hCW = locald2;
    d locald3 = new d("STATE_FINISH", 2);
    hCX = locald3;
    hCY = new d[] { locald1, locald2, locald3 };
    AppMethodBeat.o(196593);
  }
  
  private d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.d
 * JD-Core Version:    0.7.0.1
 */