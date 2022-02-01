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
  private static final Map<String, List<Pair<String, String>>> qXf;
  private static final b qXg;
  
  static
  {
    AppMethodBeat.i(195843);
    qXf = new HashMap();
    qXg = new a.1();
    AppMethodBeat.o(195843);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(195842);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("killProcess", "(I)V"));
    qXf.put("android/os/Process", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exit", "(I)V"));
    qXf.put("java/lang/System", localArrayList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(qXf, qXg);
    AppMethodBeat.o(195842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a
 * JD-Core Version:    0.7.0.1
 */