package com.tencent.mm.message;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;

public final class l
{
  public static int v(cc paramcc)
  {
    AppMethodBeat.i(150131);
    if (paramcc.fxR())
    {
      paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramcc == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = paramcc.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int w(cc paramcc)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (paramcc.fxR())
      {
        paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
        if ((paramcc == null) || (TextUtils.isEmpty(paramcc.nSK)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(paramcc.nSK);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception paramcc)
    {
      Log.printInfoStack("AppMessageHelper", "", new Object[] { paramcc });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.l
 * JD-Core Version:    0.7.0.1
 */