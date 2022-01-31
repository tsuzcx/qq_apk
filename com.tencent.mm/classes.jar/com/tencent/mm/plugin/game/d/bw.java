package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bw
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String npU;
  public String nqY;
  public String ntk;
  public String ntn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111630);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111630);
        throw paramVarArgs;
      }
      if (this.ntk != null) {
        paramVarArgs.e(1, this.ntk);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.nqY != null) {
        paramVarArgs.e(3, this.nqY);
      }
      if (this.npU != null) {
        paramVarArgs.e(4, this.npU);
      }
      if (this.ntn != null) {
        paramVarArgs.e(5, this.ntn);
      }
      AppMethodBeat.o(111630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntk == null) {
        break label502;
      }
    }
    label502:
    for (int i = e.a.a.b.b.a.f(1, this.ntk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.nqY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqY);
      }
      paramInt = i;
      if (this.npU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npU);
      }
      i = paramInt;
      if (this.ntn != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ntn);
      }
      AppMethodBeat.o(111630);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111630);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111630);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111630);
          return -1;
        case 1: 
          localbw.ntk = locala.CLY.readString();
          AppMethodBeat.o(111630);
          return 0;
        case 2: 
          localbw.Title = locala.CLY.readString();
          AppMethodBeat.o(111630);
          return 0;
        case 3: 
          localbw.nqY = locala.CLY.readString();
          AppMethodBeat.o(111630);
          return 0;
        case 4: 
          localbw.npU = locala.CLY.readString();
          AppMethodBeat.o(111630);
          return 0;
        }
        localbw.ntn = locala.CLY.readString();
        AppMethodBeat.o(111630);
        return 0;
      }
      AppMethodBeat.o(111630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bw
 * JD-Core Version:    0.7.0.1
 */