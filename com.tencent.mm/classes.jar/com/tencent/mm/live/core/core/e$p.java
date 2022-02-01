package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$SEIMsgAnchorInfo;", "", "()V", "playStatus", "", "getPlayStatus", "()Ljava/lang/String;", "songId", "getSongId", "userId", "getUserId", "userStatus", "getUserStatus", "plugin-core_release"})
public final class e$p
{
  private static final String kkT = "userStatus";
  private static final String kkU = "songId";
  private static final String kkV = "playStatus";
  public static final p kkW;
  private static final String userId = "userId";
  
  static
  {
    AppMethodBeat.i(200364);
    kkW = new p();
    userId = "userId";
    kkT = "userStatus";
    kkU = "songId";
    kkV = "playStatus";
    AppMethodBeat.o(200364);
  }
  
  public static String aKM()
  {
    return kkT;
  }
  
  public static String aKN()
  {
    return kkU;
  }
  
  public static String aKO()
  {
    return kkV;
  }
  
  public static String getUserId()
  {
    return userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.p
 * JD-Core Version:    0.7.0.1
 */