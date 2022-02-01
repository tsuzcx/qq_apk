package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$LocalAudioState;", "", "()V", "STATE_BREAK", "", "getSTATE_BREAK", "()I", "STATE_NORMAL", "getSTATE_NORMAL", "STATE_OVERFLOW", "getSTATE_OVERFLOW", "STATE_SILENT", "getSTATE_SILENT", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$i
{
  public static final i mLb;
  private static final int mLc;
  private static final int mLd;
  private static final int mLe;
  
  static
  {
    AppMethodBeat.i(248128);
    mLb = new i();
    mLc = 1;
    mLd = 2;
    mLe = 3;
    AppMethodBeat.o(248128);
  }
  
  public static int bdk()
  {
    return mLc;
  }
  
  public static int bdl()
  {
    return mLd;
  }
  
  public static int bdm()
  {
    return mLe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.i
 * JD-Core Version:    0.7.0.1
 */