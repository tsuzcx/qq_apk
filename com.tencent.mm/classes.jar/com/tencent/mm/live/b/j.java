package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveTimeUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class j
{
  public static final a zaQ;
  
  static
  {
    AppMethodBeat.i(202682);
    zaQ = new a((byte)0);
    AppMethodBeat.o(202682);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveTimeUtil$Companion;", "", "()V", "formatDuration", "", "durationMs", "", "splitStr", "formatDurationSecond", "duration", "", "plugin-logic_release"})
  public static final class a
  {
    public static String aT(int paramInt, String paramString)
    {
      AppMethodBeat.i(202681);
      k.h(paramString, "splitStr");
      int i = paramInt % 60;
      int j = paramInt / 60 % 60;
      paramInt = paramInt / 60 / 24;
      String str1;
      String str2;
      if (i < 10)
      {
        str1 = "0".concat(String.valueOf(i));
        if (j >= 10) {
          break label133;
        }
        str2 = "0".concat(String.valueOf(j));
        label66:
        if (paramInt >= 10) {
          break label142;
        }
      }
      label133:
      label142:
      for (String str3 = "0".concat(String.valueOf(paramInt));; str3 = String.valueOf(paramInt))
      {
        paramString = str3 + paramString + str2 + paramString + str1;
        AppMethodBeat.o(202681);
        return paramString;
        str1 = String.valueOf(i);
        break;
        str2 = String.valueOf(j);
        break label66;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */