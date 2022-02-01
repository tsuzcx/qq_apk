package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.cd.a
{
  public String CqY;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40866);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.f(1, this.desc);
      }
      if (this.CqY != null) {
        paramVarArgs.f(2, this.CqY);
      }
      AppMethodBeat.o(40866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CqY != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CqY);
      }
      AppMethodBeat.o(40866);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40866);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40866);
          return -1;
        case 1: 
          localc.desc = locala.abFh.readString();
          AppMethodBeat.o(40866);
          return 0;
        }
        localc.CqY = locala.abFh.readString();
        AppMethodBeat.o(40866);
        return 0;
      }
      AppMethodBeat.o(40866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.c
 * JD-Core Version:    0.7.0.1
 */