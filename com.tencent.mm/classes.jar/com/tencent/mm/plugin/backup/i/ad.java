package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ad
  extends com.tencent.mm.bw.a
{
  public String nJE;
  public int nJF;
  public int nJH;
  public int nJI;
  public int nJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.nJE != null) {
        paramVarArgs.d(1, this.nJE);
      }
      paramVarArgs.aS(2, this.nJF);
      paramVarArgs.aS(3, this.nJH);
      paramVarArgs.aS(4, this.nJI);
      paramVarArgs.aS(5, this.nJK);
      AppMethodBeat.o(22136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJE == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.nJE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJF);
      int j = f.a.a.b.b.a.bz(3, this.nJH);
      int k = f.a.a.b.b.a.bz(4, this.nJI);
      int m = f.a.a.b.b.a.bz(5, this.nJK);
      AppMethodBeat.o(22136);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nJE == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(22136);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22136);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22136);
          return -1;
        case 1: 
          localad.nJE = locala.OmT.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.nJF = locala.OmT.zc();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.nJH = locala.OmT.zc();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.nJI = locala.OmT.zc();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.nJK = locala.OmT.zc();
        AppMethodBeat.o(22136);
        return 0;
      }
      AppMethodBeat.o(22136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */