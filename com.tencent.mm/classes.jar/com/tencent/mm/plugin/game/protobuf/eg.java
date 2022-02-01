package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eg
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public int IHK;
  public int ILU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276892);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ILU);
      paramVarArgs.bS(2, this.IHK);
      if (this.IHI != null) {
        paramVarArgs.g(3, this.IHI);
      }
      AppMethodBeat.o(276892);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ILU) + 0 + i.a.a.b.b.a.cJ(2, this.IHK);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IHI);
      }
      AppMethodBeat.o(276892);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276892);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eg localeg = (eg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(276892);
        return -1;
      case 1: 
        localeg.ILU = locala.ajGk.aar();
        AppMethodBeat.o(276892);
        return 0;
      case 2: 
        localeg.IHK = locala.ajGk.aar();
        AppMethodBeat.o(276892);
        return 0;
      }
      localeg.IHI = locala.ajGk.readString();
      AppMethodBeat.o(276892);
      return 0;
    }
    AppMethodBeat.o(276892);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eg
 * JD-Core Version:    0.7.0.1
 */