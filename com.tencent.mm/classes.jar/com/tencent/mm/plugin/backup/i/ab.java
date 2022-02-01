package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ab
  extends com.tencent.mm.bx.a
{
  public int nCU;
  public b nCV;
  public long nDF;
  public int nEu;
  public int nEv;
  public long nEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nCU);
      if (this.nCV != null) {
        paramVarArgs.c(2, this.nCV);
      }
      paramVarArgs.aS(3, this.nEu);
      paramVarArgs.aS(4, this.nEv);
      paramVarArgs.aY(5, this.nEw);
      paramVarArgs.aY(6, this.nDF);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nCU) + 0;
      paramInt = i;
      if (this.nCV != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.nCV);
      }
      i = f.a.a.b.b.a.bz(3, this.nEu);
      int j = f.a.a.b.b.a.bz(4, this.nEv);
      int k = f.a.a.b.b.a.p(5, this.nEw);
      int m = f.a.a.b.b.a.p(6, this.nDF);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localab.nCU = locala.NPN.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.nCV = locala.NPN.gxI();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.nEu = locala.NPN.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.nEv = locala.NPN.zc();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.nEw = locala.NPN.zd();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.nDF = locala.NPN.zd();
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