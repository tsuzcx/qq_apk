package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class bv$20
  extends bv.a
{
  bv$20(bv parambv)
  {
    super(parambv, (byte)0);
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(72638);
    if ((System.currentTimeMillis() - parambt.ePF > 3600000L) && (bo.getInt(parambt.fnF, 0) > 0))
    {
      bv.v(parambt.key, parambt.fnF);
      parambt.fnF = "0";
      parambt.ePF = System.currentTimeMillis();
      AppMethodBeat.o(72638);
      return true;
    }
    AppMethodBeat.o(72638);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bv.20
 * JD-Core Version:    0.7.0.1
 */