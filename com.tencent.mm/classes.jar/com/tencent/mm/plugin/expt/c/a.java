package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final Map<String, List<Pair<String, String>>> qPk;
  private static final b qPl;
  
  static
  {
    AppMethodBeat.i(210202);
    qPk = new HashMap();
    qPl = new a.1();
    AppMethodBeat.o(210202);
  }
  
  public static void cnf()
  {
    AppMethodBeat.i(210201);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("killProcess", "(I)V"));
    qPk.put("android/os/Process", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exit", "(I)V"));
    qPk.put("java/lang/System", localArrayList);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(qPk, qPl);
    AppMethodBeat.o(210201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a
 * JD-Core Version:    0.7.0.1
 */