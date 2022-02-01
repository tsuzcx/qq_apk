package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class y
  extends com.tencent.mm.bx.a
{
  public int nDG;
  public String nEj;
  public int nEk;
  public int nEm;
  public int nEn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22130);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEj == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22130);
        throw paramVarArgs;
      }
      if (this.nEj != null) {
        paramVarArgs.d(1, this.nEj);
      }
      paramVarArgs.aS(2, this.nEk);
      paramVarArgs.aS(3, this.nEm);
      paramVarArgs.aS(4, this.nEn);
      paramVarArgs.aS(5, this.nDG);
      AppMethodBeat.o(22130);
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
      int m = f.a.a.b.b.a.bz(5, this.nDG);
      AppMethodBeat.o(22130);
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
          AppMethodBeat.o(22130);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22130);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22130);
          return -1;
        case 1: 
          localy.nEj = locala.NPN.readString();
          AppMethodBeat.o(22130);
          return 0;
        case 2: 
          localy.nEk = locala.NPN.zc();
          AppMethodBeat.o(22130);
          return 0;
        case 3: 
          localy.nEm = locala.NPN.zc();
          AppMethodBeat.o(22130);
          return 0;
        case 4: 
          localy.nEn = locala.NPN.zc();
          AppMethodBeat.o(22130);
          return 0;
        }
        localy.nDG = locala.NPN.zc();
        AppMethodBeat.o(22130);
        return 0;
      }
      AppMethodBeat.o(22130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.y
 * JD-Core Version:    0.7.0.1
 */