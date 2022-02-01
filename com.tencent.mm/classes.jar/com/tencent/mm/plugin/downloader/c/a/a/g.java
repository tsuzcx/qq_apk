package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String pjK;
  public String pjL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pjK != null) {
        paramVarArgs.d(1, this.pjK);
      }
      if (this.pjL != null) {
        paramVarArgs.d(2, this.pjL);
      }
      AppMethodBeat.o(153048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pjK == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.pjK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pjL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.pjL);
      }
      AppMethodBeat.o(153048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153048);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153048);
          return -1;
        case 1: 
          localg.pjK = locala.NPN.readString();
          AppMethodBeat.o(153048);
          return 0;
        }
        localg.pjL = locala.NPN.readString();
        AppMethodBeat.o(153048);
        return 0;
      }
      AppMethodBeat.o(153048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */