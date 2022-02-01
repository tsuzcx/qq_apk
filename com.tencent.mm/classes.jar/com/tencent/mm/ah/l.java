package com.tencent.mm.ah;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;

public final class l
{
  public static int r(bo parambo)
  {
    AppMethodBeat.i(150131);
    if (parambo.cKN())
    {
      parambo = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parambo == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = parambo.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int s(bo parambo)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (parambo.cKN())
      {
        parambo = k.b.az(parambo.field_content, parambo.field_reserved);
        if ((parambo == null) || (TextUtils.isEmpty(parambo.hjn)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(parambo.hjn);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception parambo)
    {
      ac.m("AppMessageHelper", "", new Object[] { parambo });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.l
 * JD-Core Version:    0.7.0.1
 */