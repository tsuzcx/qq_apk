package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20197);
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(20197);
      return false;
    }
    if (Util.getInt(paramArrayOfString[1], 0) > 0) {}
    for (com.tencent.mm.plugin.hardcoder.a.yjb = true;; com.tencent.mm.plugin.hardcoder.a.yjb = false)
    {
      AppMethodBeat.o(20197);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.a.a
 * JD-Core Version:    0.7.0.1
 */