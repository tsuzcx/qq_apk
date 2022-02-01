package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b oqC;
  public static final r oqD;
  public static final c oqE;
  public static final j oqF;
  public static final i oqG;
  public static final ArrayList<t> oqH;
  
  static
  {
    AppMethodBeat.i(181970);
    oqC = new b();
    oqD = new r();
    oqE = new c();
    oqF = new j();
    oqG = new i();
    ArrayList localArrayList = new ArrayList();
    oqH = localArrayList;
    localArrayList.add(oqC);
    oqH.add(oqE);
    oqH.add(oqF);
    oqH.add(oqD);
    AppMethodBeat.o(181970);
  }
  
  private static void a(WXRTEditText paramWXRTEditText, m paramm, t... paramVarArgs)
  {
    AppMethodBeat.i(181969);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramm == paramVarArgs[i])
      {
        AppMethodBeat.o(181969);
        return;
      }
      i += 1;
    }
    paramm.a(paramWXRTEditText, null, null);
    AppMethodBeat.o(181969);
  }
  
  public static void a(WXRTEditText paramWXRTEditText, t... paramVarArgs)
  {
    AppMethodBeat.i(181968);
    a(paramWXRTEditText, oqG, paramVarArgs);
    a(paramWXRTEditText, oqE, paramVarArgs);
    a(paramWXRTEditText, oqF, paramVarArgs);
    a(paramWXRTEditText, oqD, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */