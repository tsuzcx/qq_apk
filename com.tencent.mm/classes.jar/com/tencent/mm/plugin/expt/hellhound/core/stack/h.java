package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhz;

public final class h
{
  public static boolean a(dhz paramdhz1, dhz paramdhz2)
  {
    AppMethodBeat.i(121912);
    if ((paramdhz1 == null) || (paramdhz2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramdhz1.activityName)) || (TextUtils.isEmpty(paramdhz2.activityName)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramdhz1.activityName.equals(paramdhz2.activityName);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */