package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.recovery.util.Util;

class SnsTextUtil
{
  static String getReceiverText(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(144606);
    String str = e.nE(paramString1);
    paramString1 = str;
    if (str != null)
    {
      paramString1 = str;
      if (str.length() > 10) {
        paramString1 = str.substring(0, 10) + paramContext.getString(2131305528);
      }
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramContext = paramString2;
      if (!Util.isNullOrNil(paramString1)) {
        paramContext = e.awc(paramString2);
      }
    }
    for (paramContext = paramString1 + "(" + paramContext + ")";; paramContext = paramString1)
    {
      AppMethodBeat.o(144606);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.SnsTextUtil
 * JD-Core Version:    0.7.0.1
 */