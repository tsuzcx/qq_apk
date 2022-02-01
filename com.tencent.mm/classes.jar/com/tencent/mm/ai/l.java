package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;

public final class l
{
  public static int r(bl parambl)
  {
    AppMethodBeat.i(150131);
    if (parambl.cxB())
    {
      parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parambl == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = parambl.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int s(bl parambl)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (parambl.cxB())
      {
        parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
        if ((parambl == null) || (TextUtils.isEmpty(parambl.gIN)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(parambl.gIN);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception parambl)
    {
      ad.m("AppMessageHelper", "", new Object[] { parambl });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.l
 * JD-Core Version:    0.7.0.1
 */