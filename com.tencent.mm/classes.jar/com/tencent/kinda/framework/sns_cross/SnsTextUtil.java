package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.framework.R.string;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.recovery.util.Util;

class SnsTextUtil
{
  static String getReceiverText(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(18718);
    String str = i.getDisplayName(paramString1);
    paramString1 = str;
    if (str != null)
    {
      paramString1 = str;
      if (str.length() > 10) {
        paramString1 = str.substring(0, 10) + paramContext.getString(R.string.wallet_pwd_dialog_omit);
      }
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramContext = paramString2;
      if (!Util.isNullOrNil(paramString1)) {
        paramContext = i.bEN(paramString2);
      }
    }
    for (paramContext = paramString1 + "(" + paramContext + ")";; paramContext = paramString1)
    {
      AppMethodBeat.o(18718);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.SnsTextUtil
 * JD-Core Version:    0.7.0.1
 */