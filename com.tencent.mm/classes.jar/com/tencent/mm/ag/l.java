package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class l
{
  public static int t(ca paramca)
  {
    AppMethodBeat.i(150131);
    if (paramca.dOQ())
    {
      paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (paramca == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = paramca.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int u(ca paramca)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (paramca.dOQ())
      {
        paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
        if ((paramca == null) || (TextUtils.isEmpty(paramca.iyq)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(paramca.iyq);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception paramca)
    {
      Log.printInfoStack("AppMessageHelper", "", new Object[] { paramca });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.l
 * JD-Core Version:    0.7.0.1
 */