package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eo
  extends com.tencent.mm.bw.a
{
  public int nJA;
  public String uvN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.uvN != null) {
        paramVarArgs.d(2, this.uvN);
      }
      AppMethodBeat.o(221904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.uvN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvN);
      }
      AppMethodBeat.o(221904);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221904);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eo localeo = (eo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221904);
        return -1;
      case 1: 
        localeo.nJA = locala.OmT.zc();
        AppMethodBeat.o(221904);
        return 0;
      }
      localeo.uvN = locala.OmT.readString();
      AppMethodBeat.o(221904);
      return 0;
    }
    AppMethodBeat.o(221904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.eo
 * JD-Core Version:    0.7.0.1
 */