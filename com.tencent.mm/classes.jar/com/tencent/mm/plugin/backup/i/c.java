package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class c
  extends com.tencent.mm.bw.a
{
  public int oTl;
  public b oTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22103);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oTl);
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      AppMethodBeat.o(22103);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oTl) + 0;
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.oTm);
      }
      AppMethodBeat.o(22103);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(22103);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22103);
        return -1;
      case 1: 
        localc.oTl = locala.UbS.zi();
        AppMethodBeat.o(22103);
        return 0;
      }
      localc.oTm = locala.UbS.hPo();
      AppMethodBeat.o(22103);
      return 0;
    }
    AppMethodBeat.o(22103);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.c
 * JD-Core Version:    0.7.0.1
 */