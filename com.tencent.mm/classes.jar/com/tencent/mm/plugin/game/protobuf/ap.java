package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ap
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public int IHl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149413);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHl);
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      AppMethodBeat.o(149413);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IHl) + 0;
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      AppMethodBeat.o(149413);
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
      AppMethodBeat.o(149413);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ap localap = (ap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149413);
        return -1;
      case 1: 
        localap.IHl = locala.ajGk.aar();
        AppMethodBeat.o(149413);
        return 0;
      }
      localap.IGI = locala.ajGk.readString();
      AppMethodBeat.o(149413);
      return 0;
    }
    AppMethodBeat.o(149413);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */