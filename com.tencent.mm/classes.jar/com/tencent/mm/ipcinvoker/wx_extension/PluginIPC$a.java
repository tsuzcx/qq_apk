package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class PluginIPC$a
  implements a
{
  static final a hnD;
  
  static
  {
    AppMethodBeat.i(146421);
    hnD = new a();
    AppMethodBeat.o(146421);
  }
  
  public final void printLog(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(146420);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(146420);
      return;
      Log.v(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      Log.d(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      Log.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      Log.w(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      Log.e(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      Log.e(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.a
 * JD-Core Version:    0.7.0.1
 */