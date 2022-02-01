package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;

public final class l
{
  public static int r(bu parambu)
  {
    AppMethodBeat.i(150131);
    if (parambu.cTc())
    {
      parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parambu == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = parambu.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int s(bu parambu)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (parambu.cTc())
      {
        parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
        if ((parambu == null) || (TextUtils.isEmpty(parambu.hBw)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(parambu.hBw);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception parambu)
    {
      ad.m("AppMessageHelper", "", new Object[] { parambu });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.l
 * JD-Core Version:    0.7.0.1
 */