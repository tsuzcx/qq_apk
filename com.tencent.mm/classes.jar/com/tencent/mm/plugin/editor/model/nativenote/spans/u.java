package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b xCm;
  public static final r xCn;
  public static final c xCo;
  public static final j xCp;
  public static final i xCq;
  public static final ArrayList<t> xCr;
  
  static
  {
    AppMethodBeat.i(181970);
    xCm = new b();
    xCn = new r();
    xCo = new c();
    xCp = new j();
    xCq = new i();
    ArrayList localArrayList = new ArrayList();
    xCr = localArrayList;
    localArrayList.add(xCm);
    xCr.add(xCo);
    xCr.add(xCp);
    xCr.add(xCn);
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
    a(paramWXRTEditText, xCq, paramVarArgs);
    a(paramWXRTEditText, xCo, paramVarArgs);
    a(paramWXRTEditText, xCp, paramVarArgs);
    a(paramWXRTEditText, xCn, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */