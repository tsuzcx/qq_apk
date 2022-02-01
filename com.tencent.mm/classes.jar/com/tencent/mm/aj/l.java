package com.tencent.mm.aj;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class l
{
  public static int v(ca paramca)
  {
    AppMethodBeat.i(150131);
    if (paramca.erk())
    {
      paramca = k.b.aG(paramca.field_content, paramca.field_reserved);
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
  
  public static int w(ca paramca)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (paramca.erk())
      {
        paramca = k.b.aG(paramca.field_content, paramca.field_reserved);
        if ((paramca == null) || (TextUtils.isEmpty(paramca.lnG)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(paramca.lnG);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.l
 * JD-Core Version:    0.7.0.1
 */