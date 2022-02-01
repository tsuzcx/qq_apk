package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b pxM;
  public static final r pxN;
  public static final c pxO;
  public static final j pxP;
  public static final i pxQ;
  public static final ArrayList<t> pxR;
  
  static
  {
    AppMethodBeat.i(181970);
    pxM = new b();
    pxN = new r();
    pxO = new c();
    pxP = new j();
    pxQ = new i();
    ArrayList localArrayList = new ArrayList();
    pxR = localArrayList;
    localArrayList.add(pxM);
    pxR.add(pxO);
    pxR.add(pxP);
    pxR.add(pxN);
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
    a(paramWXRTEditText, pxQ, paramVarArgs);
    a(paramWXRTEditText, pxO, paramVarArgs);
    a(paramWXRTEditText, pxP, paramVarArgs);
    a(paramWXRTEditText, pxN, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */