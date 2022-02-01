package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dx
  extends com.tencent.mm.bx.a
{
  public String IGH;
  public String IGI;
  public int ILN;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41834);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      if (this.IGH != null) {
        paramVarArgs.g(3, this.IGH);
      }
      paramVarArgs.bS(4, this.ILN);
      AppMethodBeat.o(41834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      i = paramInt;
      if (this.IGH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGH);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.ILN);
      AppMethodBeat.o(41834);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41834);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dx localdx = (dx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41834);
          return -1;
        case 1: 
          localdx.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 2: 
          localdx.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 3: 
          localdx.IGH = locala.ajGk.readString();
          AppMethodBeat.o(41834);
          return 0;
        }
        localdx.ILN = locala.ajGk.aar();
        AppMethodBeat.o(41834);
        return 0;
      }
      AppMethodBeat.o(41834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dx
 * JD-Core Version:    0.7.0.1
 */