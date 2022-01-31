package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class bv$1
  extends bv.a
{
  bv$1(bv parambv)
  {
    super(parambv, (byte)0);
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(72617);
    if ((System.currentTimeMillis() - parambt.ePF > 3600000L) && (bo.getInt(parambt.fnF, 0) > 0))
    {
      bv.v(23, parambt.fnF + "_3");
      parambt.fnF = "0";
      parambt.ePF = System.currentTimeMillis();
      AppMethodBeat.o(72617);
      return true;
    }
    AppMethodBeat.o(72617);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bv.1
 * JD-Core Version:    0.7.0.1
 */