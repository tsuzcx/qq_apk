package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class y
  extends com.tencent.mm.bw.a
{
  public String nJE;
  public int nJF;
  public int nJH;
  public int nJI;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22130);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22130);
        throw paramVarArgs;
      }
      if (this.nJE != null) {
        paramVarArgs.d(1, this.nJE);
      }
      paramVarArgs.aS(2, this.nJF);
      paramVarArgs.aS(3, this.nJH);
      paramVarArgs.aS(4, this.nJI);
      paramVarArgs.aS(5, this.nJb);
      AppMethodBeat.o(22130);
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
      int m = f.a.a.b.b.a.bz(5, this.nJb);
      AppMethodBeat.o(22130);
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
          localy.nJE = locala.OmT.readString();
          AppMethodBeat.o(22130);
          return 0;
        case 2: 
          localy.nJF = locala.OmT.zc();
          AppMethodBeat.o(22130);
          return 0;
        case 3: 
          localy.nJH = locala.OmT.zc();
          AppMethodBeat.o(22130);
          return 0;
        case 4: 
          localy.nJI = locala.OmT.zc();
          AppMethodBeat.o(22130);
          return 0;
        }
        localy.nJb = locala.OmT.zc();
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