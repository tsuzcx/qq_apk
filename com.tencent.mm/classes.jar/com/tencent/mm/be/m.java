package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.cd.a
{
  public String fileName;
  public int lXQ;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.f(1, this.fileName);
      }
      paramVarArgs.aY(2, this.lXQ);
      paramVarArgs.aY(4, this.size);
      AppMethodBeat.o(190990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = g.a.a.b.b.a.g(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.lXQ);
      int j = g.a.a.b.b.a.bM(4, this.size);
      AppMethodBeat.o(190990);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(190990);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(190990);
          return -1;
        case 1: 
          localm.fileName = locala.abFh.readString();
          AppMethodBeat.o(190990);
          return 0;
        case 2: 
          localm.lXQ = locala.abFh.AK();
          AppMethodBeat.o(190990);
          return 0;
        }
        localm.size = locala.abFh.AK();
        AppMethodBeat.o(190990);
        return 0;
      }
      AppMethodBeat.o(190990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.m
 * JD-Core Version:    0.7.0.1
 */