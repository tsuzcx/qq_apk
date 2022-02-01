package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class y
  extends com.tencent.mm.bw.a
{
  public String ncR;
  public String tiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41725);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.tiv == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.tiv != null) {
        paramVarArgs.d(2, this.tiv);
      }
      AppMethodBeat.o(41725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tiv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tiv);
      }
      AppMethodBeat.o(41725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncR == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        if (this.tiv == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41725);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41725);
          return -1;
        case 1: 
          localy.ncR = locala.LVo.readString();
          AppMethodBeat.o(41725);
          return 0;
        }
        localy.tiv = locala.LVo.readString();
        AppMethodBeat.o(41725);
        return 0;
      }
      AppMethodBeat.o(41725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.y
 * JD-Core Version:    0.7.0.1
 */