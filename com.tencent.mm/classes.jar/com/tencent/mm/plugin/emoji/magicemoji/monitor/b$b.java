package com.tencent.mm.plugin.emoji.magicemoji.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class b$b
  extends u
  implements a<Integer>
{
  public static final b xJA;
  
  static
  {
    AppMethodBeat.i(270173);
    xJA = new b();
    AppMethodBeat.o(270173);
  }
  
  b$b()
  {
    super(0);
  }
  
  private static Integer dzb()
  {
    AppMethodBeat.i(270168);
    c.a locala = c.a.yRR;
    if (!BuildInfo.IS_ARM64) {
      locala = c.a.yRS;
    }
    String str2;
    for (String str1 = "{\"ram\":5,\"exit\":1,\"reload\":{\"low\":1,\"mid\":1,\"high\":1},\"reloadtime\":{\"low\":5,\"mid\":5,\"high\":5},\"benchmark\":{\"low\":11,\"high\":21}}";; str2 = "")
    {
      str1 = ((c)h.ax(c.class)).a(locala, str1);
      try
      {
        i = new i(str1).getInt("ram");
        AppMethodBeat.o(270168);
        return Integer.valueOf(i);
      }
      catch (g localg)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.monitor.b.b
 * JD-Core Version:    0.7.0.1
 */