package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginIPC$a
  implements a
{
  static final a eEQ;
  
  static
  {
    AppMethodBeat.i(126207);
    eEQ = new a();
    AppMethodBeat.o(126207);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126206);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(126206);
      return;
      ab.v(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(126206);
      return;
      ab.d(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(126206);
      return;
      ab.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(126206);
      return;
      ab.w(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(126206);
      return;
      ab.e(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(126206);
      return;
      ab.e(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.a
 * JD-Core Version:    0.7.0.1
 */