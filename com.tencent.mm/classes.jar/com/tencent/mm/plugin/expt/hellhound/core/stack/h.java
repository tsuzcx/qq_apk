package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcm;

public final class h
{
  public static boolean a(dcm paramdcm1, dcm paramdcm2)
  {
    AppMethodBeat.i(121912);
    if ((paramdcm1 == null) || (paramdcm2 == null))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    if ((TextUtils.isEmpty(paramdcm1.activityName)) || (TextUtils.isEmpty(paramdcm2.activityName)))
    {
      AppMethodBeat.o(121912);
      return false;
    }
    boolean bool = paramdcm1.activityName.equals(paramdcm2.activityName);
    AppMethodBeat.o(121912);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */