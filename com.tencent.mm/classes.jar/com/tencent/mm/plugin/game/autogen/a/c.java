package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public String IcC;
  public long IcG;
  public boolean IcH;
  public long IcI;
  public String IcJ;
  public String IcK;
  public String IcL;
  public String Md5;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275459);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.IcG);
      paramVarArgs.di(2, this.IcH);
      if (this.IcC != null) {
        paramVarArgs.g(3, this.IcC);
      }
      paramVarArgs.bv(4, this.IcI);
      if (this.IcJ != null) {
        paramVarArgs.g(5, this.IcJ);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(6, this.Md5);
      }
      if (this.oOI != null) {
        paramVarArgs.g(7, this.oOI);
      }
      if (this.IcK != null) {
        paramVarArgs.g(8, this.IcK);
      }
      if (this.IcL != null) {
        paramVarArgs.g(9, this.IcL);
      }
      AppMethodBeat.o(275459);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.IcG) + 0 + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.IcC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IcC);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.IcI);
      paramInt = i;
      if (this.IcJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IcJ);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Md5);
      }
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.oOI);
      }
      i = paramInt;
      if (this.IcK != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IcK);
      }
      paramInt = i;
      if (this.IcL != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.IcL);
      }
      AppMethodBeat.o(275459);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275459);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275459);
        return -1;
      case 1: 
        localc.IcG = locala.ajGk.aaw();
        AppMethodBeat.o(275459);
        return 0;
      case 2: 
        localc.IcH = locala.ajGk.aai();
        AppMethodBeat.o(275459);
        return 0;
      case 3: 
        localc.IcC = locala.ajGk.readString();
        AppMethodBeat.o(275459);
        return 0;
      case 4: 
        localc.IcI = locala.ajGk.aaw();
        AppMethodBeat.o(275459);
        return 0;
      case 5: 
        localc.IcJ = locala.ajGk.readString();
        AppMethodBeat.o(275459);
        return 0;
      case 6: 
        localc.Md5 = locala.ajGk.readString();
        AppMethodBeat.o(275459);
        return 0;
      case 7: 
        localc.oOI = locala.ajGk.readString();
        AppMethodBeat.o(275459);
        return 0;
      case 8: 
        localc.IcK = locala.ajGk.readString();
        AppMethodBeat.o(275459);
        return 0;
      }
      localc.IcL = locala.ajGk.readString();
      AppMethodBeat.o(275459);
      return 0;
    }
    AppMethodBeat.o(275459);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.c
 * JD-Core Version:    0.7.0.1
 */