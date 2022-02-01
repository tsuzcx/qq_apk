package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public int hYb;
  public int oQA;
  public int oQB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150799);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hYb);
      paramVarArgs.bS(2, this.oQA);
      paramVarArgs.bS(3, this.oQB);
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.hYb);
      int i = i.a.a.b.b.a.cJ(2, this.oQA);
      int j = i.a.a.b.b.a.cJ(3, this.oQB);
      AppMethodBeat.o(150799);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(150799);
        return -1;
      case 1: 
        localj.hYb = locala.ajGk.aar();
        AppMethodBeat.o(150799);
        return 0;
      case 2: 
        localj.oQA = locala.ajGk.aar();
        AppMethodBeat.o(150799);
        return 0;
      }
      localj.oQB = locala.ajGk.aar();
      AppMethodBeat.o(150799);
      return 0;
    }
    AppMethodBeat.o(150799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelpackage.j
 * JD-Core Version:    0.7.0.1
 */