package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eq
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGH;
  public String IMi;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41845);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.IMi != null) {
        paramVarArgs.g(3, this.IMi);
      }
      if (this.IGH != null) {
        paramVarArgs.g(4, this.IGH);
      }
      AppMethodBeat.o(41845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.IMi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMi);
      }
      paramInt = i;
      if (this.IGH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGH);
      }
      AppMethodBeat.o(41845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41845);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41845);
          return -1;
        case 1: 
          localeq.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 2: 
          localeq.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 3: 
          localeq.IMi = locala.ajGk.readString();
          AppMethodBeat.o(41845);
          return 0;
        }
        localeq.IGH = locala.ajGk.readString();
        AppMethodBeat.o(41845);
        return 0;
      }
      AppMethodBeat.o(41845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */