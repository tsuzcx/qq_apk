package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.cd.a
{
  public String lXu;
  public String lang;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lXu != null) {
        paramVarArgs.f(1, this.lXu);
      }
      if (this.lang != null) {
        paramVarArgs.f(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lXu == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.lXu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lang != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(150796);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150796);
          return -1;
        case 1: 
          localf.lXu = locala.abFh.readString();
          AppMethodBeat.o(150796);
          return 0;
        }
        localf.lang = locala.abFh.readString();
        AppMethodBeat.o(150796);
        return 0;
      }
      AppMethodBeat.o(150796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.f
 * JD-Core Version:    0.7.0.1
 */