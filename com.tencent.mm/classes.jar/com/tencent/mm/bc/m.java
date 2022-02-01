package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public String fileName;
  public int ijo;
  public int ijp;
  public int ijq;
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
      paramVarArgs.aS(2, this.ijo);
      paramVarArgs.aS(3, this.ijp);
      paramVarArgs.aS(4, this.ijq);
      paramVarArgs.aS(5, this.maxSize);
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
      int i = f.a.a.b.b.a.bz(2, this.ijo);
      int j = f.a.a.b.b.a.bz(3, this.ijp);
      int k = f.a.a.b.b.a.bz(4, this.ijq);
      int m = f.a.a.b.b.a.bz(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localm.fileName = locala.NPN.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localm.ijo = locala.NPN.zc();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localm.ijp = locala.NPN.zc();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localm.ijq = locala.NPN.zc();
          AppMethodBeat.o(150830);
          return 0;
        }
        localm.maxSize = locala.NPN.zc();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.m
 * JD-Core Version:    0.7.0.1
 */