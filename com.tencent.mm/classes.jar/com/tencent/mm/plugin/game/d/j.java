package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class j
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String IconUrl;
  public String Title;
  public String npR;
  public String nqt;
  public int nqv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111550);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(111550);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111550);
        throw paramVarArgs;
      }
      if (this.npR == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(111550);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.npR != null) {
        paramVarArgs.e(4, this.npR);
      }
      paramVarArgs.aO(5, this.nqv);
      if (this.nqt != null) {
        paramVarArgs.e(6, this.nqt);
      }
      AppMethodBeat.o(111550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label646;
      }
    }
    label646:
    for (int i = e.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npR);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.nqv);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nqt);
      }
      AppMethodBeat.o(111550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(111550);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111550);
          throw paramVarArgs;
        }
        if (this.npR == null)
        {
          paramVarArgs = new b("Not all required fields were included: JumpUrl");
          AppMethodBeat.o(111550);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111550);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111550);
          return -1;
        case 1: 
          localj.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(111550);
          return 0;
        case 2: 
          localj.Title = locala.CLY.readString();
          AppMethodBeat.o(111550);
          return 0;
        case 3: 
          localj.Desc = locala.CLY.readString();
          AppMethodBeat.o(111550);
          return 0;
        case 4: 
          localj.npR = locala.CLY.readString();
          AppMethodBeat.o(111550);
          return 0;
        case 5: 
          localj.nqv = locala.CLY.sl();
          AppMethodBeat.o(111550);
          return 0;
        }
        localj.nqt = locala.CLY.readString();
        AppMethodBeat.o(111550);
        return 0;
      }
      AppMethodBeat.o(111550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.j
 * JD-Core Version:    0.7.0.1
 */