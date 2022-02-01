package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b pEq;
  public static final r pEr;
  public static final c pEs;
  public static final j pEt;
  public static final i pEu;
  public static final ArrayList<t> pEv;
  
  static
  {
    AppMethodBeat.i(181970);
    pEq = new b();
    pEr = new r();
    pEs = new c();
    pEt = new j();
    pEu = new i();
    ArrayList localArrayList = new ArrayList();
    pEv = localArrayList;
    localArrayList.add(pEq);
    pEv.add(pEs);
    pEv.add(pEt);
    pEv.add(pEr);
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
    a(paramWXRTEditText, pEu, paramVarArgs);
    a(paramWXRTEditText, pEs, paramVarArgs);
    a(paramWXRTEditText, pEt, paramVarArgs);
    a(paramWXRTEditText, pEr, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */