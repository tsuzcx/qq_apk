package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class bv$17
  extends bv.a
{
  bv$17(bv parambv)
  {
    super(parambv, (byte)0);
  }
  
  public final void a(bt parambt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72634);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      parambt.fnF = paramVarArgs[0];
    }
    AppMethodBeat.o(72634);
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(72635);
    if ((System.currentTimeMillis() - parambt.ePF > 3600000L) && (parambt.fnF.length() > 0))
    {
      bv.v(parambt.key, parambt.fnF);
      parambt.fnF = "";
      parambt.ePF = System.currentTimeMillis();
      AppMethodBeat.o(72635);
      return true;
    }
    AppMethodBeat.o(72635);
    return false;
  }
  
  public final bt d(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72633);
    bt localbt = new bt();
    localbt.key = paramInt;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localbt.fnF = paramVarArgs[0];
    }
    localbt.ePF = 0L;
    AppMethodBeat.o(72633);
    return localbt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bv.17
 * JD-Core Version:    0.7.0.1
 */