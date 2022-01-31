package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String npQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111648);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.npQ != null) {
        paramVarArgs.e(2, this.npQ);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      AppMethodBeat.o(111648);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npQ);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Desc);
      }
      AppMethodBeat.o(111648);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111648);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111648);
          return -1;
        case 1: 
          localck.Title = locala.CLY.readString();
          AppMethodBeat.o(111648);
          return 0;
        case 2: 
          localck.npQ = locala.CLY.readString();
          AppMethodBeat.o(111648);
          return 0;
        }
        localck.Desc = locala.CLY.readString();
        AppMethodBeat.o(111648);
        return 0;
      }
      AppMethodBeat.o(111648);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ck
 * JD-Core Version:    0.7.0.1
 */