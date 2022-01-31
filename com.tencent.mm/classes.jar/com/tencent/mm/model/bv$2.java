package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class bv$2
  extends bv.a
{
  bv$2(bv parambv)
  {
    super(parambv, (byte)0);
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(72618);
    if ((System.currentTimeMillis() - parambt.ePF > 1800000L) && (bo.getInt(parambt.fnF, 0) > 0))
    {
      bv.v(parambt.key, parambt.fnF);
      parambt.fnF = "0";
      parambt.ePF = System.currentTimeMillis();
      AppMethodBeat.o(72618);
      return true;
    }
    AppMethodBeat.o(72618);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bv.2
 * JD-Core Version:    0.7.0.1
 */