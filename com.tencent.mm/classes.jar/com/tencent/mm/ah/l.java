package com.tencent.mm.ah;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;

public final class l
{
  public static int r(bv parambv)
  {
    AppMethodBeat.i(150131);
    if (parambv.cVH())
    {
      parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parambv == null)
      {
        AppMethodBeat.o(150131);
        return 0;
      }
      int i = parambv.type;
      AppMethodBeat.o(150131);
      return i;
    }
    AppMethodBeat.o(150131);
    return 0;
  }
  
  public static int s(bv parambv)
  {
    AppMethodBeat.i(150132);
    try
    {
      if (parambv.cVH())
      {
        parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
        if ((parambv == null) || (TextUtils.isEmpty(parambv.hEk)))
        {
          AppMethodBeat.o(150132);
          return 0;
        }
        int i = Integer.parseInt(parambv.hEk);
        AppMethodBeat.o(150132);
        return i;
      }
    }
    catch (Exception parambv)
    {
      ae.m("AppMessageHelper", "", new Object[] { parambv });
      AppMethodBeat.o(150132);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.l
 * JD-Core Version:    0.7.0.1
 */