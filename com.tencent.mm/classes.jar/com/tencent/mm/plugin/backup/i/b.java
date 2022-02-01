package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int oTl;
  public com.tencent.mm.bw.b oTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22102);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oTl);
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oTl) + 0;
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.oTm);
      }
      AppMethodBeat.o(22102);
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
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22102);
        return -1;
      case 1: 
        localb.oTl = locala.UbS.zi();
        AppMethodBeat.o(22102);
        return 0;
      }
      localb.oTm = locala.UbS.hPo();
      AppMethodBeat.o(22102);
      return 0;
    }
    AppMethodBeat.o(22102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.b
 * JD-Core Version:    0.7.0.1
 */