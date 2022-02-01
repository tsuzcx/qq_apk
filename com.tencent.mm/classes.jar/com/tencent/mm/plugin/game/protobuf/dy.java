package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dy
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int IKq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41835);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41835);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.IKq);
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      AppMethodBeat.o(41835);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IKq) + 0;
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      AppMethodBeat.o(41835);
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
      if (this.IGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41835);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41835);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dy localdy = (dy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41835);
        return -1;
      case 1: 
        localdy.IKq = locala.ajGk.aar();
        AppMethodBeat.o(41835);
        return 0;
      }
      localdy.IGU = locala.ajGk.readString();
      AppMethodBeat.o(41835);
      return 0;
    }
    AppMethodBeat.o(41835);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dy
 * JD-Core Version:    0.7.0.1
 */