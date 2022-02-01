package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public String fileName;
  public int hpA;
  public int hpy;
  public int hpz;
  public int maxSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.d(1, this.fileName);
      }
      paramVarArgs.aR(2, this.hpy);
      paramVarArgs.aR(3, this.hpz);
      paramVarArgs.aR(4, this.hpA);
      paramVarArgs.aR(5, this.maxSize);
      AppMethodBeat.o(150830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.hpy);
      int j = f.a.a.b.b.a.bA(3, this.hpz);
      int k = f.a.a.b.b.a.bA(4, this.hpA);
      int m = f.a.a.b.b.a.bA(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(150830);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150830);
          return -1;
        case 1: 
          localm.fileName = locala.KhF.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localm.hpy = locala.KhF.xS();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localm.hpz = locala.KhF.xS();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localm.hpA = locala.KhF.xS();
          AppMethodBeat.o(150830);
          return 0;
        }
        localm.maxSize = locala.KhF.xS();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.m
 * JD-Core Version:    0.7.0.1
 */