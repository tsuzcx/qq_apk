package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esj;

public final class h
{
  public static boolean a(esj paramesj1, esj paramesj2)
  {
    AppMethodBeat.i(121912);
    if ((paramesj1 == null) || (paramesj2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramesj1.activityName)) || (TextUtils.isEmpty(paramesj2.activityName)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramesj1.activityName.equals(paramesj2.activityName);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */