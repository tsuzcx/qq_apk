package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public String IGM;
  public String IGN;
  public String IGO;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276884);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IGM != null) {
        paramVarArgs.g(2, this.IGM);
      }
      if (this.IGN != null) {
        paramVarArgs.g(3, this.IGN);
      }
      if (this.IGO != null) {
        paramVarArgs.g(4, this.IGO);
      }
      AppMethodBeat.o(276884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGM);
      }
      i = paramInt;
      if (this.IGN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGN);
      }
      paramInt = i;
      if (this.IGO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGO);
      }
      AppMethodBeat.o(276884);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(276884);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(276884);
          return -1;
        case 1: 
          locald.oOI = locala.ajGk.readString();
          AppMethodBeat.o(276884);
          return 0;
        case 2: 
          locald.IGM = locala.ajGk.readString();
          AppMethodBeat.o(276884);
          return 0;
        case 3: 
          locald.IGN = locala.ajGk.readString();
          AppMethodBeat.o(276884);
          return 0;
        }
        locald.IGO = locala.ajGk.readString();
        AppMethodBeat.o(276884);
        return 0;
      }
      AppMethodBeat.o(276884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.d
 * JD-Core Version:    0.7.0.1
 */