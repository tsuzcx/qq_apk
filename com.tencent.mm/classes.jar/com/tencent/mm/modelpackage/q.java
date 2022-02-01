package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String fileName;
  public int maxSize;
  public int oQU;
  public int oQX;
  public int oQY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150830);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.g(1, this.fileName);
      }
      paramVarArgs.bS(2, this.oQU);
      paramVarArgs.bS(3, this.oQX);
      paramVarArgs.bS(4, this.oQY);
      paramVarArgs.bS(5, this.maxSize);
      AppMethodBeat.o(150830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = i.a.a.b.b.a.h(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.oQU);
      int j = i.a.a.b.b.a.cJ(3, this.oQX);
      int k = i.a.a.b.b.a.cJ(4, this.oQY);
      int m = i.a.a.b.b.a.cJ(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(150830);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150830);
          return -1;
        case 1: 
          localq.fileName = locala.ajGk.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localq.oQU = locala.ajGk.aar();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localq.oQX = locala.ajGk.aar();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localq.oQY = locala.ajGk.aar();
          AppMethodBeat.o(150830);
          return 0;
        }
        localq.maxSize = locala.ajGk.aar();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelpackage.q
 * JD-Core Version:    0.7.0.1
 */