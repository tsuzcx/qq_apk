package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cr
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IHo;
  public String IKS;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.IGI != null) {
        paramVarArgs.g(3, this.IGI);
      }
      if (this.IKS != null) {
        paramVarArgs.g(4, this.IKS);
      }
      AppMethodBeat.o(41801);
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
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGI);
      }
      paramInt = i;
      if (this.IKS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKS);
      }
      AppMethodBeat.o(41801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41801);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41801);
          return -1;
        case 1: 
          localcr.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 2: 
          localcr.IHo = locala.ajGk.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 3: 
          localcr.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41801);
          return 0;
        }
        localcr.IKS = locala.ajGk.readString();
        AppMethodBeat.o(41801);
        return 0;
      }
      AppMethodBeat.o(41801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */