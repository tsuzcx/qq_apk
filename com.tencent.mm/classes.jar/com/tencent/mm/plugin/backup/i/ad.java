package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ad
  extends com.tencent.mm.bx.a
{
  public String nEj;
  public int nEk;
  public int nEm;
  public int nEn;
  public int nEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEj == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.nEj != null) {
        paramVarArgs.d(1, this.nEj);
      }
      paramVarArgs.aS(2, this.nEk);
      paramVarArgs.aS(3, this.nEm);
      paramVarArgs.aS(4, this.nEn);
      paramVarArgs.aS(5, this.nEp);
      AppMethodBeat.o(22136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEj == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.nEj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nEk);
      int j = f.a.a.b.b.a.bz(3, this.nEm);
      int k = f.a.a.b.b.a.bz(4, this.nEn);
      int m = f.a.a.b.b.a.bz(5, this.nEp);
      AppMethodBeat.o(22136);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nEj == null)
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
          localad.nEj = locala.NPN.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.nEk = locala.NPN.zc();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.nEm = locala.NPN.zc();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.nEn = locala.NPN.zc();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.nEp = locala.NPN.zc();
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