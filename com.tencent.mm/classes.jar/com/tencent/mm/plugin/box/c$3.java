package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gjd;
import java.util.Comparator;

final class c$3
  implements Comparator<gjd>
{
  private static int a(gjd paramgjd1, gjd paramgjd2)
  {
    AppMethodBeat.i(278687);
    try
    {
      int i = paramgjd2.weight - paramgjd1.weight;
      if (i == 0)
      {
        i = paramgjd2.vFa.length();
        int j = paramgjd1.vFa.length();
        AppMethodBeat.o(278687);
        return i - j;
      }
      AppMethodBeat.o(278687);
      return i;
    }
    catch (Exception paramgjd1)
    {
      AppMethodBeat.o(278687);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.3
 * JD-Core Version:    0.7.0.1
 */