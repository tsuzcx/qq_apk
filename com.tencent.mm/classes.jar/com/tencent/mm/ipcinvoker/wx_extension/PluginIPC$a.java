package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.sdk.platformtools.ad;

final class PluginIPC$a
  implements a
{
  static final a fZR;
  
  static
  {
    AppMethodBeat.i(146421);
    fZR = new a();
    AppMethodBeat.o(146421);
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(146420);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(146420);
      return;
      ad.v(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      ad.d(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      ad.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      ad.w(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      ad.e(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(146420);
      return;
      ad.e(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.a
 * JD-Core Version:    0.7.0.1
 */