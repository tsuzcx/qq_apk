package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ay
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IHI;
  public int IHK;
  public String IJd;
  public boolean IJe;
  public boolean IJf;
  public String IJg;
  public String IJh;
  public int IJi;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41742);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.IJd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IJd != null) {
        paramVarArgs.g(2, this.IJd);
      }
      if (this.IGI != null) {
        paramVarArgs.g(3, this.IGI);
      }
      paramVarArgs.di(4, this.IJe);
      paramVarArgs.di(5, this.IJf);
      if (this.IJg != null) {
        paramVarArgs.g(6, this.IJg);
      }
      if (this.IJh != null) {
        paramVarArgs.g(7, this.IJh);
      }
      paramVarArgs.bS(8, this.IJi);
      paramVarArgs.bS(9, this.IHK);
      if (this.IHI != null) {
        paramVarArgs.g(10, this.IHI);
      }
      AppMethodBeat.o(41742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label786;
      }
    }
    label786:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IJd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IJd);
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGI);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.IJg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IJg);
      }
      i = paramInt;
      if (this.IJh != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IJh);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.IJi) + i.a.a.b.b.a.cJ(9, this.IHK);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.IHI);
      }
      AppMethodBeat.o(41742);
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
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.IJd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NavKey");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41742);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localay.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localay.IJd = locala.ajGk.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localay.IGI = locala.ajGk.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localay.IJe = locala.ajGk.aai();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localay.IJf = locala.ajGk.aai();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localay.IJg = locala.ajGk.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localay.IJh = locala.ajGk.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localay.IJi = locala.ajGk.aar();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localay.IHK = locala.ajGk.aar();
          AppMethodBeat.o(41742);
          return 0;
        }
        localay.IHI = locala.ajGk.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */