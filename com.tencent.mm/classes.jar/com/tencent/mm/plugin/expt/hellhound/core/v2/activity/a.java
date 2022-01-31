package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  static void Mi(String paramString)
  {
    AppMethodBeat.i(73388);
    ab.i("ActivityActionWrapper", "habbyge-mali, setFinishAction_resume: ".concat(String.valueOf(paramString)));
    c.brO().mah.Mi(paramString);
    AppMethodBeat.o(73388);
  }
  
  static void Mj(String paramString)
  {
    AppMethodBeat.i(73389);
    ab.i("ActivityActionWrapper", "habbyge-mali, setFinishAction_pause: ".concat(String.valueOf(paramString)));
    c.brO().mah.Mj(paramString);
    AppMethodBeat.o(73389);
  }
  
  public static int brJ()
  {
    AppMethodBeat.i(156825);
    int i = c.brO().mah.brJ();
    AppMethodBeat.o(156825);
    return i;
  }
  
  public static void vm(int paramInt)
  {
    AppMethodBeat.i(73390);
    ab.d("ActivityActionWrapper", "habbyge-mali, setActivityMethod: ".concat(String.valueOf(paramInt)));
    c.brO().mah.vm(paramInt);
    AppMethodBeat.o(73390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a
 * JD-Core Version:    0.7.0.1
 */