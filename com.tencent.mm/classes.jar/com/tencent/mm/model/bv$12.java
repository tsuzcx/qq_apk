package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class bv$12
  extends bv.a
{
  bv$12(bv parambv)
  {
    super(parambv, (byte)0);
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(72628);
    if ((System.currentTimeMillis() - parambt.ePF > 3600000L) && (bo.getInt(parambt.fnF, 0) > 0))
    {
      bv.v(23, parambt.fnF + "_43");
      parambt.fnF = "0";
      parambt.ePF = System.currentTimeMillis();
      AppMethodBeat.o(72628);
      return true;
    }
    AppMethodBeat.o(72628);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bv.12
 * JD-Core Version:    0.7.0.1
 */