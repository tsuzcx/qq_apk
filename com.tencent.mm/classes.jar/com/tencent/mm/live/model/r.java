package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveTimeUtil;", "", "()V", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final a mZi;
  
  static
  {
    AppMethodBeat.i(246503);
    mZi = new a((byte)0);
    AppMethodBeat.o(246503);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveTimeUtil$Companion;", "", "()V", "AN_HOUR", "", "formatAnchorLikeCount", "", "likeCnt", "formatDuration", "durationMs", "", "splitStr", "formatDurationSecond", "duration", "showH", "", "showM", "showS", "formatTime", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String I(int paramInt, String paramString)
    {
      AppMethodBeat.i(246472);
      s.u(paramString, "splitStr");
      if (paramInt < 3600)
      {
        paramString = a(paramInt, paramString, false, false, false, 24);
        AppMethodBeat.o(246472);
        return paramString;
      }
      paramString = a(paramInt, paramString, true, false, false, 24);
      AppMethodBeat.o(246472);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.r
 * JD-Core Version:    0.7.0.1
 */