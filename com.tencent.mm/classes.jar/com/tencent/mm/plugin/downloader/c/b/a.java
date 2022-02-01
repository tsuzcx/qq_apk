package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public long pqE;
  public long pqF;
  public String pqG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.pqE);
      paramVarArgs.aZ(2, this.pqF);
      if (this.pqG != null) {
        paramVarArgs.d(3, this.pqG);
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.pqE) + 0 + f.a.a.b.b.a.p(2, this.pqF);
      paramInt = i;
      if (this.pqG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pqG);
      }
      AppMethodBeat.o(153058);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153058);
        return -1;
      case 1: 
        locala1.pqE = locala.OmT.zd();
        AppMethodBeat.o(153058);
        return 0;
      case 2: 
        locala1.pqF = locala.OmT.zd();
        AppMethodBeat.o(153058);
        return 0;
      }
      locala1.pqG = locala.OmT.readString();
      AppMethodBeat.o(153058);
      return 0;
    }
    AppMethodBeat.o(153058);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.a
 * JD-Core Version:    0.7.0.1
 */