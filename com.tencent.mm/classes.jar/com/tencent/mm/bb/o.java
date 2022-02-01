package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public String fileName;
  public int jhn;
  public int jhq;
  public int jhr;
  public int maxSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.e(1, this.fileName);
      }
      paramVarArgs.aM(2, this.jhn);
      paramVarArgs.aM(3, this.jhq);
      paramVarArgs.aM(4, this.jhr);
      paramVarArgs.aM(5, this.maxSize);
      AppMethodBeat.o(150830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.f(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.jhn);
      int j = g.a.a.b.b.a.bu(3, this.jhq);
      int k = g.a.a.b.b.a.bu(4, this.jhr);
      int m = g.a.a.b.b.a.bu(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(150830);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150830);
          return -1;
        case 1: 
          localo.fileName = locala.UbS.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localo.jhn = locala.UbS.zi();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localo.jhq = locala.UbS.zi();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localo.jhr = locala.UbS.zi();
          AppMethodBeat.o(150830);
          return 0;
        }
        localo.maxSize = locala.UbS.zi();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bb.o
 * JD-Core Version:    0.7.0.1
 */