package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class c
  extends com.tencent.mm.bv.a
{
  public int jJg;
  public b jJh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18046);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jJg);
      if (this.jJh != null) {
        paramVarArgs.c(2, this.jJh);
      }
      AppMethodBeat.o(18046);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jJg) + 0;
      paramInt = i;
      if (this.jJh != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.jJh);
      }
      AppMethodBeat.o(18046);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18046);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18046);
        return -1;
      case 1: 
        localc.jJg = locala.CLY.sl();
        AppMethodBeat.o(18046);
        return 0;
      }
      localc.jJh = locala.CLY.eqS();
      AppMethodBeat.o(18046);
      return 0;
    }
    AppMethodBeat.o(18046);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.c
 * JD-Core Version:    0.7.0.1
 */