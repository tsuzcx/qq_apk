package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dol;

public final class h
{
  public static boolean a(dol paramdol1, dol paramdol2)
  {
    AppMethodBeat.i(121912);
    if ((paramdol1 == null) || (paramdol2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramdol1.activityName)) || (TextUtils.isEmpty(paramdol2.activityName)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramdol1.activityName.equals(paramdol2.activityName);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */