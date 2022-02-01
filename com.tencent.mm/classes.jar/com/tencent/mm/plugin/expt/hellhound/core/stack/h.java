package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dno;

public final class h
{
  public static boolean a(dno paramdno1, dno paramdno2)
  {
    AppMethodBeat.i(121912);
    if ((paramdno1 == null) || (paramdno2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramdno1.activityName)) || (TextUtils.isEmpty(paramdno2.activityName)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramdno1.activityName.equals(paramdno2.activityName);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */