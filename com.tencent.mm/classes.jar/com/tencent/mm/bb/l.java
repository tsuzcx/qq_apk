package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String fileName;
  public int jhn;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223635);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.e(1, this.fileName);
      }
      paramVarArgs.aM(2, this.jhn);
      paramVarArgs.aM(4, this.size);
      AppMethodBeat.o(223635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = g.a.a.b.b.a.f(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.jhn);
      int j = g.a.a.b.b.a.bu(4, this.size);
      AppMethodBeat.o(223635);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(223635);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(223635);
          return -1;
        case 1: 
          locall.fileName = locala.UbS.readString();
          AppMethodBeat.o(223635);
          return 0;
        case 2: 
          locall.jhn = locala.UbS.zi();
          AppMethodBeat.o(223635);
          return 0;
        }
        locall.size = locala.UbS.zi();
        AppMethodBeat.o(223635);
        return 0;
      }
      AppMethodBeat.o(223635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bb.l
 * JD-Core Version:    0.7.0.1
 */