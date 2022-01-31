package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bt
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String npU;
  public String nqY;
  public String ntk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111626);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntk == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogoURL");
        AppMethodBeat.o(111626);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111626);
        throw paramVarArgs;
      }
      if (this.nqY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(111626);
        throw paramVarArgs;
      }
      if (this.npU == null)
      {
        paramVarArgs = new b("Not all required fields were included: WebURL");
        AppMethodBeat.o(111626);
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
      AppMethodBeat.o(111626);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntk == null) {
        break label586;
      }
    }
    label586:
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
      AppMethodBeat.o(111626);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ntk == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogoURL");
          AppMethodBeat.o(111626);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111626);
          throw paramVarArgs;
        }
        if (this.nqY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(111626);
          throw paramVarArgs;
        }
        if (this.npU == null)
        {
          paramVarArgs = new b("Not all required fields were included: WebURL");
          AppMethodBeat.o(111626);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111626);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bt localbt = (bt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111626);
          return -1;
        case 1: 
          localbt.ntk = locala.CLY.readString();
          AppMethodBeat.o(111626);
          return 0;
        case 2: 
          localbt.Title = locala.CLY.readString();
          AppMethodBeat.o(111626);
          return 0;
        case 3: 
          localbt.nqY = locala.CLY.readString();
          AppMethodBeat.o(111626);
          return 0;
        }
        localbt.npU = locala.CLY.readString();
        AppMethodBeat.o(111626);
        return 0;
      }
      AppMethodBeat.o(111626);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bt
 * JD-Core Version:    0.7.0.1
 */