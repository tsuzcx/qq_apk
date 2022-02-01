package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cv
  extends com.tencent.mm.bw.a
{
  public String tlp;
  public String tlq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(182780);
        throw paramVarArgs;
      }
      if (this.tlp != null) {
        paramVarArgs.d(1, this.tlp);
      }
      if (this.tlq != null) {
        paramVarArgs.d(2, this.tlq);
      }
      AppMethodBeat.o(182780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlp == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlq);
      }
      AppMethodBeat.o(182780);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tlp == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(182780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(182780);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(182780);
          return -1;
        case 1: 
          localcv.tlp = locala.LVo.readString();
          AppMethodBeat.o(182780);
          return 0;
        }
        localcv.tlq = locala.LVo.readString();
        AppMethodBeat.o(182780);
        return 0;
      }
      AppMethodBeat.o(182780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cv
 * JD-Core Version:    0.7.0.1
 */