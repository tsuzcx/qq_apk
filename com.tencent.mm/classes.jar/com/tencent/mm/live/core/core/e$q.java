package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$SEIMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SEIMode_OFF", "SEIMode_GAMEREPORT", "SEIMode_SUBTITLE", "SEIMode_LINKMIC", "SEIMode_OWD", "SEIMode_ANCHOR_INFO", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e$q
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(248190);
    mLH = new q("SEIMode_OFF", 0, 0);
    mLI = new q("SEIMode_GAMEREPORT", 1, 1);
    mLJ = new q("SEIMode_SUBTITLE", 2, 2);
    mLK = new q("SEIMode_LINKMIC", 3, 4);
    mLL = new q("SEIMode_OWD", 4, 8);
    mLM = new q("SEIMode_ANCHOR_INFO", 5, 16);
    mLN = new q[] { mLH, mLI, mLJ, mLK, mLL, mLM };
    AppMethodBeat.o(248190);
  }
  
  private e$q(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.q
 * JD-Core Version:    0.7.0.1
 */