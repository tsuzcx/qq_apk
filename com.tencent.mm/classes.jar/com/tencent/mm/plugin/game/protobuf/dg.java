package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dg
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGG != null) {
        paramVarArgs.g(1, this.IGG);
      }
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      AppMethodBeat.o(41816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGG == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGI);
      }
      AppMethodBeat.o(41816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41816);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41816);
          return -1;
        case 1: 
          localdg.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41816);
          return 0;
        }
        localdg.IGI = locala.ajGk.readString();
        AppMethodBeat.o(41816);
        return 0;
      }
      AppMethodBeat.o(41816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */