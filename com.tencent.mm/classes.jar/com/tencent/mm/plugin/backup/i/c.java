package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class c
  extends com.tencent.mm.bw.a
{
  public int nIp;
  public b nIq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nIp);
      if (this.nIq != null) {
        paramVarArgs.c(2, this.nIq);
      }
      AppMethodBeat.o(22103);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nIp) + 0;
      paramInt = i;
      if (this.nIq != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.nIq);
      }
      AppMethodBeat.o(22103);
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
      AppMethodBeat.o(22103);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22103);
        return -1;
      case 1: 
        localc.nIp = locala.OmT.zc();
        AppMethodBeat.o(22103);
        return 0;
      }
      localc.nIq = locala.OmT.gCk();
      AppMethodBeat.o(22103);
      return 0;
    }
    AppMethodBeat.o(22103);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.c
 * JD-Core Version:    0.7.0.1
 */