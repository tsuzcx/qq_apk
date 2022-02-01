package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ej
  extends com.tencent.mm.bx.a
{
  public String IGH;
  public String IGI;
  public String IHI;
  public int IMf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGH != null) {
        paramVarArgs.g(1, this.IGH);
      }
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      paramVarArgs.bS(3, this.IMf);
      if (this.IHI != null) {
        paramVarArgs.g(4, this.IHI);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGH == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGI);
      }
      i += i.a.a.b.b.a.cJ(3, this.IMf);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHI);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localej.IGH = locala.ajGk.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localej.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localej.IMf = locala.ajGk.aar();
          AppMethodBeat.o(41838);
          return 0;
        }
        localej.IHI = locala.ajGk.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */