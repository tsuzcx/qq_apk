package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"})
public final class a
{
  public static final a jZC;
  
  static
  {
    AppMethodBeat.i(14779);
    jZC = new a();
    AppMethodBeat.o(14779);
  }
  
  public static final void aXc()
  {
    AppMethodBeat.i(14778);
    long l2 = b.aXf();
    if (1L <= l2) {
      for (long l1 = 1L;; l1 += 1L)
      {
        b.hW(l1).clear();
        if (l1 == l2) {
          break;
        }
      }
    }
    AppMethodBeat.o(14778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a
 * JD-Core Version:    0.7.0.1
 */