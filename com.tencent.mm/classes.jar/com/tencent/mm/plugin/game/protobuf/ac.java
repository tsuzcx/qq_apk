package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String hAP;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276916);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.yts != null) {
        paramVarArgs.g(3, this.yts);
      }
      AppMethodBeat.o(276916);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.yts);
      }
      AppMethodBeat.o(276916);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(276916);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(276916);
          return -1;
        case 1: 
          localac.hAP = locala.ajGk.readString();
          AppMethodBeat.o(276916);
          return 0;
        case 2: 
          localac.IGG = locala.ajGk.readString();
          AppMethodBeat.o(276916);
          return 0;
        }
        localac.yts = locala.ajGk.readString();
        AppMethodBeat.o(276916);
        return 0;
      }
      AppMethodBeat.o(276916);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */