package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class a
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String npQ;
  public String npR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111542);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111542);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.npQ != null) {
        paramVarArgs.e(3, this.npQ);
      }
      if (this.npR != null) {
        paramVarArgs.e(4, this.npR);
      }
      AppMethodBeat.o(111542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label442;
      }
    }
    label442:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.npQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npQ);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npR);
      }
      AppMethodBeat.o(111542);
      return paramInt;
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
          AppMethodBeat.o(111542);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111542);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111542);
          return -1;
        case 1: 
          locala1.Title = locala.CLY.readString();
          AppMethodBeat.o(111542);
          return 0;
        case 2: 
          locala1.Desc = locala.CLY.readString();
          AppMethodBeat.o(111542);
          return 0;
        case 3: 
          locala1.npQ = locala.CLY.readString();
          AppMethodBeat.o(111542);
          return 0;
        }
        locala1.npR = locala.CLY.readString();
        AppMethodBeat.o(111542);
        return 0;
      }
      AppMethodBeat.o(111542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.a
 * JD-Core Version:    0.7.0.1
 */