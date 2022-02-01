package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.cd.a
{
  public String fileName;
  public int lXQ;
  public int lXT;
  public int lXU;
  public int maxSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.f(1, this.fileName);
      }
      paramVarArgs.aY(2, this.lXQ);
      paramVarArgs.aY(3, this.lXT);
      paramVarArgs.aY(4, this.lXU);
      paramVarArgs.aY(5, this.maxSize);
      AppMethodBeat.o(150830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.g(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.lXQ);
      int j = g.a.a.b.b.a.bM(3, this.lXT);
      int k = g.a.a.b.b.a.bM(4, this.lXU);
      int m = g.a.a.b.b.a.bM(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(150830);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150830);
          return -1;
        case 1: 
          localp.fileName = locala.abFh.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localp.lXQ = locala.abFh.AK();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localp.lXT = locala.abFh.AK();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localp.lXU = locala.abFh.AK();
          AppMethodBeat.o(150830);
          return 0;
        }
        localp.maxSize = locala.abFh.AK();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.p
 * JD-Core Version:    0.7.0.1
 */