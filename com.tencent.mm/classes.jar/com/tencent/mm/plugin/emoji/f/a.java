package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class a
  extends ap
{
  private static int lhY;
  private static a lhZ;
  private static q lia;
  private static f lic;
  
  static
  {
    AppMethodBeat.i(53092);
    lhY = 0;
    lic = new a.1();
    AppMethodBeat.o(53092);
  }
  
  private a()
  {
    super(new a.a(), true);
    AppMethodBeat.i(53091);
    AppMethodBeat.o(53091);
  }
  
  public static final a blw()
  {
    AppMethodBeat.i(53087);
    if (lhZ == null) {}
    for (;;)
    {
      try
      {
        if (lhZ == null) {
          lhZ = new a();
        }
        a locala = lhZ;
        AppMethodBeat.o(53087);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(53087);
      }
      lhZ.stopTimer();
    }
  }
  
  public static void blx()
  {
    AppMethodBeat.i(53088);
    lhY = 0;
    lia = new q("com.tencent.xin.emoticon.tusiji", 1);
    g.RK().eHt.a(lia, 0);
    g.RK().eHt.a(413, lic);
    ab.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(53088);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(53090);
    if (lia != null) {
      g.RK().eHt.a(lia);
    }
    g.RK().eHt.b(413, lic);
    ab.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(53090);
  }
  
  public final void bly()
  {
    AppMethodBeat.i(53089);
    stopTimer();
    i.blu().g(com.tencent.mm.plugin.emoji.h.a.bnx(), 3, lhY, "");
    removeListener();
    AppMethodBeat.o(53089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */