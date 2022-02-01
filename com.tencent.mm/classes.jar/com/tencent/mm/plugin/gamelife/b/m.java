package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public int ybm;
  public String ybn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225900);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ybm);
      if (this.ybn != null) {
        paramVarArgs.e(2, this.ybn);
      }
      AppMethodBeat.o(225900);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.ybm) + 0;
      paramInt = i;
      if (this.ybn != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ybn);
      }
      AppMethodBeat.o(225900);
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
      AppMethodBeat.o(225900);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(225900);
        return -1;
      case 1: 
        localm.ybm = locala.UbS.zi();
        AppMethodBeat.o(225900);
        return 0;
      }
      localm.ybn = locala.UbS.readString();
      AppMethodBeat.o(225900);
      return 0;
    }
    AppMethodBeat.o(225900);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.m
 * JD-Core Version:    0.7.0.1
 */