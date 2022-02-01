package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String IGT;
  public String IIu;
  public String UserName;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41724);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.IIu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.IGT != null) {
        paramVarArgs.g(2, this.IGT);
      }
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.IIu != null) {
        paramVarArgs.g(4, this.IIu);
      }
      AppMethodBeat.o(41724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label486;
      }
    }
    label486:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGT);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAP);
      }
      paramInt = i;
      if (this.IIu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IIu);
      }
      AppMethodBeat.o(41724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        if (this.IIu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41724);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41724);
          return -1;
        case 1: 
          localag.UserName = locala.ajGk.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 2: 
          localag.IGT = locala.ajGk.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 3: 
          localag.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41724);
          return 0;
        }
        localag.IIu = locala.ajGk.readString();
        AppMethodBeat.o(41724);
        return 0;
      }
      AppMethodBeat.o(41724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */