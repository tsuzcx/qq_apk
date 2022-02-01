package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static final Map<String, List<Pair<String, String>>> yFK;
  private static final b yFL;
  
  static
  {
    AppMethodBeat.i(273672);
    yFK = new HashMap();
    yFL = new f.1();
    AppMethodBeat.o(273672);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(273670);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("loadLibrary", "(Ljava/lang/String;)V"));
    yFK.put("java/lang/System", localArrayList);
    a.aYh();
    a.a(yFK, yFL);
    AppMethodBeat.o(273670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.f
 * JD-Core Version:    0.7.0.1
 */