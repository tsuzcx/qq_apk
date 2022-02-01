package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGI;
  public String IGU;
  public String IHW;
  public int IHX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHW != null) {
        paramVarArgs.g(1, this.IHW);
      }
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.IGG != null) {
        paramVarArgs.g(3, this.IGG);
      }
      if (this.IGI != null) {
        paramVarArgs.g(4, this.IGI);
      }
      paramVarArgs.bS(5, this.IHX);
      AppMethodBeat.o(41718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHW == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.IHW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGG);
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGI);
      }
      i = i.a.a.b.b.a.cJ(5, this.IHX);
      AppMethodBeat.o(41718);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41718);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41718);
          return -1;
        case 1: 
          localu.IHW = locala.ajGk.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 2: 
          localu.IGU = locala.ajGk.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 3: 
          localu.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 4: 
          localu.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41718);
          return 0;
        }
        localu.IHX = locala.ajGk.aar();
        AppMethodBeat.o(41718);
        return 0;
      }
      AppMethodBeat.o(41718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.u
 * JD-Core Version:    0.7.0.1
 */