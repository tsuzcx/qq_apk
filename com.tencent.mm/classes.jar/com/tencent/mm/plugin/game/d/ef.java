package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ef
  extends com.tencent.mm.bx.a
{
  public int nEf;
  public String ukq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.ukq != null) {
        paramVarArgs.d(2, this.ukq);
      }
      AppMethodBeat.o(199592);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.ukq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukq);
      }
      AppMethodBeat.o(199592);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(199592);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ef localef = (ef)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199592);
        return -1;
      case 1: 
        localef.nEf = locala.NPN.zc();
        AppMethodBeat.o(199592);
        return 0;
      }
      localef.ukq = locala.NPN.readString();
      AppMethodBeat.o(199592);
      return 0;
    }
    AppMethodBeat.o(199592);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ef
 * JD-Core Version:    0.7.0.1
 */