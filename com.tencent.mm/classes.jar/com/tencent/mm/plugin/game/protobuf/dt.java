package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dt
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGH;
  public String IGI;
  public String IHI;
  public String IKJ;
  public String hAP;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IKJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.IKJ != null) {
        paramVarArgs.g(1, this.IKJ);
      }
      if (this.IGH != null) {
        paramVarArgs.g(2, this.IGH);
      }
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.IHI != null) {
        paramVarArgs.g(5, this.IHI);
      }
      if (this.IGI != null) {
        paramVarArgs.g(6, this.IGI);
      }
      if (this.oOI != null) {
        paramVarArgs.g(7, this.oOI);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IKJ == null) {
        break label622;
      }
    }
    label622:
    for (int i = i.a.a.b.b.a.h(1, this.IKJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGH);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAP);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.IHI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IHI);
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IGI);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.oOI);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IKJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(41829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41829);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localdt.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localdt.IGH = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localdt.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localdt.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localdt.IHI = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localdt.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localdt.oOI = locala.ajGk.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dt
 * JD-Core Version:    0.7.0.1
 */