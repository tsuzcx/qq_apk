package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
{
  public static m a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(15532);
    Object localObject = null;
    if ((paramInt == 2) || (paramInt == 4) || (paramInt == 4) || (paramInt == 6) || (paramInt == 3)) {
      TXCLog.e("TXSDKUtil", "create player error not support type : ".concat(String.valueOf(paramInt)));
    }
    for (paramContext = localObject;; paramContext = new e(paramContext))
    {
      AppMethodBeat.o(15532);
      return paramContext;
    }
  }
  
  public static String a()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.o
 * JD-Core Version:    0.7.0.1
 */