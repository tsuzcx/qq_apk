package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  public static boolean a(ckn paramckn1, ckn paramckn2)
  {
    AppMethodBeat.i(73386);
    if ((paramckn1 == null) || (paramckn2 == null))
    {
      AppMethodBeat.o(73386);
      return false;
    }
    if ((TextUtils.isEmpty(paramckn1.activityName)) || (TextUtils.isEmpty(paramckn2.activityName)))
    {
      AppMethodBeat.o(73386);
      return false;
    }
    boolean bool = l(paramckn1.activityName, paramckn1.wXg, paramckn2.activityName, paramckn2.wXg);
    AppMethodBeat.o(73386);
    return bool;
  }
  
  public static boolean l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(73387);
    ab.d("TokenWrapper", "habbyge-mali, TokenWrapper.equals: " + paramString1 + "=" + paramString2 + "/" + paramString3 + "=" + paramString4);
    boolean bool = paramString1.equals(paramString3);
    AppMethodBeat.o(73387);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.h
 * JD-Core Version:    0.7.0.1
 */