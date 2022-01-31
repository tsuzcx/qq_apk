package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class da
  extends com.tencent.mm.bv.a
{
  public String npU;
  public String nqa;
  public String nud;
  public String nue;
  public String nuf;
  public boolean nug;
  public boolean nuh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111668);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqa != null) {
        paramVarArgs.e(1, this.nqa);
      }
      if (this.nud != null) {
        paramVarArgs.e(2, this.nud);
      }
      if (this.nue != null) {
        paramVarArgs.e(3, this.nue);
      }
      if (this.nuf != null) {
        paramVarArgs.e(4, this.nuf);
      }
      if (this.npU != null) {
        paramVarArgs.e(5, this.npU);
      }
      paramVarArgs.aS(6, this.nug);
      paramVarArgs.aS(7, this.nuh);
      AppMethodBeat.o(111668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqa == null) {
        break label546;
      }
    }
    label546:
    for (int i = e.a.a.b.b.a.f(1, this.nqa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nud != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nud);
      }
      i = paramInt;
      if (this.nue != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nue);
      }
      paramInt = i;
      if (this.nuf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nuf);
      }
      i = paramInt;
      if (this.npU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.npU);
      }
      paramInt = e.a.a.b.b.a.eW(6);
      int j = e.a.a.b.b.a.eW(7);
      AppMethodBeat.o(111668);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111668);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        da localda = (da)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111668);
          return -1;
        case 1: 
          localda.nqa = locala.CLY.readString();
          AppMethodBeat.o(111668);
          return 0;
        case 2: 
          localda.nud = locala.CLY.readString();
          AppMethodBeat.o(111668);
          return 0;
        case 3: 
          localda.nue = locala.CLY.readString();
          AppMethodBeat.o(111668);
          return 0;
        case 4: 
          localda.nuf = locala.CLY.readString();
          AppMethodBeat.o(111668);
          return 0;
        case 5: 
          localda.npU = locala.CLY.readString();
          AppMethodBeat.o(111668);
          return 0;
        case 6: 
          localda.nug = locala.CLY.emu();
          AppMethodBeat.o(111668);
          return 0;
        }
        localda.nuh = locala.CLY.emu();
        AppMethodBeat.o(111668);
        return 0;
      }
      AppMethodBeat.o(111668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.da
 * JD-Core Version:    0.7.0.1
 */