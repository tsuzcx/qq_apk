package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class p
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGI;
  public String IHI;
  public int IHK;
  public String IHo;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41715);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHo == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.IGI == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.IHo != null) {
        paramVarArgs.g(1, this.IHo);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(3, this.IGG);
      }
      if (this.IGI != null) {
        paramVarArgs.g(4, this.IGI);
      }
      paramVarArgs.bS(5, this.IHK);
      if (this.IHI != null) {
        paramVarArgs.g(6, this.IHI);
      }
      AppMethodBeat.o(41715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHo == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.b.b.a.h(1, this.IHo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGG);
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IHK);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IHI);
      }
      AppMethodBeat.o(41715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHo == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.IGI == null)
        {
          paramVarArgs = new b("Not all required fields were included: JumpUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41715);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41715);
          return -1;
        case 1: 
          localp.IHo = locala.ajGk.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 2: 
          localp.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 3: 
          localp.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 4: 
          localp.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 5: 
          localp.IHK = locala.ajGk.aar();
          AppMethodBeat.o(41715);
          return 0;
        }
        localp.IHI = locala.ajGk.readString();
        AppMethodBeat.o(41715);
        return 0;
      }
      AppMethodBeat.o(41715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.p
 * JD-Core Version:    0.7.0.1
 */