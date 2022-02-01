package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$SEIMsgAnchorInfo;", "", "()V", "playStatus", "", "getPlayStatus", "()Ljava/lang/String;", "serverTime", "getServerTime", "songId", "getSongId", "userId", "getUserId", "userStatus", "getUserStatus", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$r
{
  public static final r mLO;
  private static final String mLP;
  private static final String mLQ;
  private static final String mLR;
  private static final String mLS;
  private static final String userId;
  
  static
  {
    AppMethodBeat.i(248205);
    mLO = new r();
    userId = "userId";
    mLP = "userStatus";
    mLQ = "songId";
    mLR = "playStatus";
    mLS = "st";
    AppMethodBeat.o(248205);
  }
  
  public static String bdI()
  {
    return mLP;
  }
  
  public static String bdJ()
  {
    return mLQ;
  }
  
  public static String bdK()
  {
    return mLR;
  }
  
  public static String bdL()
  {
    return mLS;
  }
  
  public static String getUserId()
  {
    return userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.r
 * JD-Core Version:    0.7.0.1
 */