package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class k
  extends com.tencent.mm.bw.a
{
  public int nIH;
  public int nII;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nIH);
      paramVarArgs.aS(2, this.nII);
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nIH) + 0 + f.a.a.b.b.a.bz(2, this.nII);
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nIJ);
      }
      AppMethodBeat.o(22114);
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
      if (this.nIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22114);
        return -1;
      case 1: 
        localk.nIH = locala.OmT.zc();
        AppMethodBeat.o(22114);
        return 0;
      case 2: 
        localk.nII = locala.OmT.zc();
        AppMethodBeat.o(22114);
        return 0;
      }
      localk.nIJ = locala.OmT.readString();
      AppMethodBeat.o(22114);
      return 0;
    }
    AppMethodBeat.o(22114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */