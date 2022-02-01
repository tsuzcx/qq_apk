package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fns;

public final class h
{
  public static boolean a(fns paramfns1, fns paramfns2)
  {
    AppMethodBeat.i(121912);
    if ((paramfns1 == null) || (paramfns2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramfns1.AtM)) || (TextUtils.isEmpty(paramfns2.AtM)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramfns1.AtM.equals(paramfns2.AtM);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */