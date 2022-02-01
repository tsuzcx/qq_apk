package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final Map<String, List<Pair<String, String>>> sxm;
  private static final com.tencent.mm.hellhoundlib.a.b sxn;
  
  static
  {
    AppMethodBeat.i(220263);
    sxm = new HashMap();
    sxn = new b.1();
    AppMethodBeat.o(220263);
  }
  
  public static void cMH()
  {
    AppMethodBeat.i(220262);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("killProcess", "(I)V"));
    sxm.put("android/os/Process", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exit", "(I)V"));
    sxm.put("java/lang/System", localArrayList);
    a.axP();
    a.a(sxm, sxn);
    AppMethodBeat.o(220262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.b
 * JD-Core Version:    0.7.0.1
 */