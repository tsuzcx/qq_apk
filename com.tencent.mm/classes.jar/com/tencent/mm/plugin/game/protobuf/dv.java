package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IHo;
  public String ILH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41832);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILH != null) {
        paramVarArgs.g(1, this.ILH);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.IGI != null) {
        paramVarArgs.g(3, this.IGI);
      }
      AppMethodBeat.o(41832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILH == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.ILH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGI);
      }
      AppMethodBeat.o(41832);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41832);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41832);
          return -1;
        case 1: 
          localdv.ILH = locala.ajGk.readString();
          AppMethodBeat.o(41832);
          return 0;
        case 2: 
          localdv.IHo = locala.ajGk.readString();
          AppMethodBeat.o(41832);
          return 0;
        }
        localdv.IGI = locala.ajGk.readString();
        AppMethodBeat.o(41832);
        return 0;
      }
      AppMethodBeat.o(41832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */