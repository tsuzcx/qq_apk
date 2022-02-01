package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eb
  extends com.tencent.mm.bw.a
{
  public String xJt;
  public int xJv;
  public int xNu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256652);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xNu);
      paramVarArgs.aM(2, this.xJv);
      if (this.xJt != null) {
        paramVarArgs.e(3, this.xJt);
      }
      AppMethodBeat.o(256652);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xNu) + 0 + g.a.a.b.b.a.bu(2, this.xJv);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xJt);
      }
      AppMethodBeat.o(256652);
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
      AppMethodBeat.o(256652);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eb localeb = (eb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(256652);
        return -1;
      case 1: 
        localeb.xNu = locala.UbS.zi();
        AppMethodBeat.o(256652);
        return 0;
      case 2: 
        localeb.xJv = locala.UbS.zi();
        AppMethodBeat.o(256652);
        return 0;
      }
      localeb.xJt = locala.UbS.readString();
      AppMethodBeat.o(256652);
      return 0;
    }
    AppMethodBeat.o(256652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eb
 * JD-Core Version:    0.7.0.1
 */