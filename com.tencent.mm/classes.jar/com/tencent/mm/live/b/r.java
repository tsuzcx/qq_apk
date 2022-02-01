package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveTimeUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class r
{
  public static final a kvH;
  
  static
  {
    AppMethodBeat.i(188334);
    kvH = new a((byte)0);
    AppMethodBeat.o(188334);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveTimeUtil$Companion;", "", "()V", "AN_HOUR", "", "formatAnchorLikeCount", "", "likeCnt", "formatDuration", "durationMs", "", "splitStr", "formatDurationSecond", "duration", "showH", "", "showM", "showS", "formatTime", "plugin-logic_release"})
  public static final class a
  {
    public static String H(int paramInt, String paramString)
    {
      AppMethodBeat.i(195724);
      p.k(paramString, "splitStr");
      if (paramInt < 3600)
      {
        paramString = a(paramInt, paramString, false, false, false, 24);
        AppMethodBeat.o(195724);
        return paramString;
      }
      paramString = a(paramInt, paramString, true, false, false, 24);
      AppMethodBeat.o(195724);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.r
 * JD-Core Version:    0.7.0.1
 */