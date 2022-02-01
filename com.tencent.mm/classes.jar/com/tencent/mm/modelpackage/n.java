package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String fileName;
  public int oQU;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.g(1, this.fileName);
      }
      paramVarArgs.bS(2, this.oQU);
      paramVarArgs.bS(4, this.size);
      AppMethodBeat.o(231001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = i.a.a.b.b.a.h(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.oQU);
      int j = i.a.a.b.b.a.cJ(4, this.size);
      AppMethodBeat.o(231001);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231001);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(231001);
          return -1;
        case 1: 
          localn.fileName = locala.ajGk.readString();
          AppMethodBeat.o(231001);
          return 0;
        case 2: 
          localn.oQU = locala.ajGk.aar();
          AppMethodBeat.o(231001);
          return 0;
        }
        localn.size = locala.ajGk.aar();
        AppMethodBeat.o(231001);
        return 0;
      }
      AppMethodBeat.o(231001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelpackage.n
 * JD-Core Version:    0.7.0.1
 */