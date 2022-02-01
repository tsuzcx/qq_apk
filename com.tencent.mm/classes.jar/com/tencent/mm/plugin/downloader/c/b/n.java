package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public String prF;
  public String prG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.prF != null) {
        paramVarArgs.d(1, this.prF);
      }
      if (this.prG != null) {
        paramVarArgs.d(2, this.prG);
      }
      AppMethodBeat.o(153074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.prF == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.prF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.prG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.prG);
      }
      AppMethodBeat.o(153074);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153074);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153074);
          return -1;
        case 1: 
          localn.prF = locala.OmT.readString();
          AppMethodBeat.o(153074);
          return 0;
        }
        localn.prG = locala.OmT.readString();
        AppMethodBeat.o(153074);
        return 0;
      }
      AppMethodBeat.o(153074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.n
 * JD-Core Version:    0.7.0.1
 */