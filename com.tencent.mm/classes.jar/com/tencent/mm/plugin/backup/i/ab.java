package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ab
  extends com.tencent.mm.bw.a
{
  public int nIp;
  public b nIq;
  public int nJP;
  public int nJQ;
  public long nJR;
  public long nJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nIp);
      if (this.nIq != null) {
        paramVarArgs.c(2, this.nIq);
      }
      paramVarArgs.aS(3, this.nJP);
      paramVarArgs.aS(4, this.nJQ);
      paramVarArgs.aZ(5, this.nJR);
      paramVarArgs.aZ(6, this.nJa);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nIp) + 0;
      paramInt = i;
      if (this.nIq != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.nIq);
      }
      i = f.a.a.b.b.a.bz(3, this.nJP);
      int j = f.a.a.b.b.a.bz(4, this.nJQ);
      int k = f.a.a.b.b.a.p(5, this.nJR);
      int m = f.a.a.b.b.a.p(6, this.nJa);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22134);
        return -1;
      case 1: 
        localab.nIp = locala.OmT.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.nIq = locala.OmT.gCk();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.nJP = locala.OmT.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.nJQ = locala.OmT.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.nJR = locala.OmT.zd();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.nJa = locala.OmT.zd();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */