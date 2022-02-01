package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b qTH;
  public static final r qTI;
  public static final c qTJ;
  public static final j qTK;
  public static final i qTL;
  public static final ArrayList<t> qTM;
  
  static
  {
    AppMethodBeat.i(181970);
    qTH = new b();
    qTI = new r();
    qTJ = new c();
    qTK = new j();
    qTL = new i();
    ArrayList localArrayList = new ArrayList();
    qTM = localArrayList;
    localArrayList.add(qTH);
    qTM.add(qTJ);
    qTM.add(qTK);
    qTM.add(qTI);
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
    a(paramWXRTEditText, qTL, paramVarArgs);
    a(paramWXRTEditText, qTJ, paramVarArgs);
    a(paramWXRTEditText, qTK, paramVarArgs);
    a(paramWXRTEditText, qTI, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */