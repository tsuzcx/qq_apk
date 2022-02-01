package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b oUc;
  public static final r oUd;
  public static final c oUe;
  public static final j oUf;
  public static final i oUg;
  public static final ArrayList<t> oUh;
  
  static
  {
    AppMethodBeat.i(181970);
    oUc = new b();
    oUd = new r();
    oUe = new c();
    oUf = new j();
    oUg = new i();
    ArrayList localArrayList = new ArrayList();
    oUh = localArrayList;
    localArrayList.add(oUc);
    oUh.add(oUe);
    oUh.add(oUf);
    oUh.add(oUd);
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
    a(paramWXRTEditText, oUg, paramVarArgs);
    a(paramWXRTEditText, oUe, paramVarArgs);
    a(paramWXRTEditText, oUf, paramVarArgs);
    a(paramWXRTEditText, oUd, paramVarArgs);
    AppMethodBeat.o(181968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */