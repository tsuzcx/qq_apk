package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class k
  extends com.tencent.mm.bv.a
{
  public String Url;
  public String nqA;
  public String nqB;
  public String nqz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111551);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(111551);
        throw paramVarArgs;
      }
      if (this.nqA == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(111551);
        throw paramVarArgs;
      }
      if (this.nqB == null)
      {
        paramVarArgs = new b("Not all required fields were included: CancelBtn");
        AppMethodBeat.o(111551);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(111551);
        throw paramVarArgs;
      }
      if (this.nqz != null) {
        paramVarArgs.e(1, this.nqz);
      }
      if (this.nqA != null) {
        paramVarArgs.e(2, this.nqA);
      }
      if (this.nqB != null) {
        paramVarArgs.e(3, this.nqB);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      AppMethodBeat.o(111551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqz == null) {
        break label586;
      }
    }
    label586:
    for (int i = e.a.a.b.b.a.f(1, this.nqz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqA);
      }
      i = paramInt;
      if (this.nqB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqB);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Url);
      }
      AppMethodBeat.o(111551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(111551);
          throw paramVarArgs;
        }
        if (this.nqA == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(111551);
          throw paramVarArgs;
        }
        if (this.nqB == null)
        {
          paramVarArgs = new b("Not all required fields were included: CancelBtn");
          AppMethodBeat.o(111551);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(111551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111551);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111551);
          return -1;
        case 1: 
          localk.nqz = locala.CLY.readString();
          AppMethodBeat.o(111551);
          return 0;
        case 2: 
          localk.nqA = locala.CLY.readString();
          AppMethodBeat.o(111551);
          return 0;
        case 3: 
          localk.nqB = locala.CLY.readString();
          AppMethodBeat.o(111551);
          return 0;
        }
        localk.Url = locala.CLY.readString();
        AppMethodBeat.o(111551);
        return 0;
      }
      AppMethodBeat.o(111551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.k
 * JD-Core Version:    0.7.0.1
 */