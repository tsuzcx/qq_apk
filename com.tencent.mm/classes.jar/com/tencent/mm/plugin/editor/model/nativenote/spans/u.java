package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b uvN;
  public static final r uvO;
  public static final c uvP;
  public static final j uvQ;
  public static final i uvR;
  public static final ArrayList<t> uvS;
  
  static
  {
    AppMethodBeat.i(181970);
    uvN = new b();
    uvO = new r();
    uvP = new c();
    uvQ = new j();
    uvR = new i();
    ArrayList localArrayList = new ArrayList();
    uvS = localArrayList;
    localArrayList.add(uvN);
    uvS.add(uvP);
    uvS.add(uvQ);
    uvS.add(uvO);
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
    a(paramWXRTEditText, uvR, paramVarArgs);
    a(paramWXRTEditText, uvP, paramVarArgs);
    a(paramWXRTEditText, uvQ, paramVarArgs);
    a(paramWXRTEditText, uvO, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */