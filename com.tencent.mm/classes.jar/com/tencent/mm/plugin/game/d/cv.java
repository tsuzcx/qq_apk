package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cv
  extends com.tencent.mm.bx.a
{
  public String sdv;
  public String sdw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdv == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(182780);
        throw paramVarArgs;
      }
      if (this.sdv != null) {
        paramVarArgs.d(1, this.sdv);
      }
      if (this.sdw != null) {
        paramVarArgs.d(2, this.sdw);
      }
      AppMethodBeat.o(182780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdv == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdw);
      }
      AppMethodBeat.o(182780);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sdv == null)
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
          localcv.sdv = locala.KhF.readString();
          AppMethodBeat.o(182780);
          return 0;
        }
        localcv.sdw = locala.KhF.readString();
        AppMethodBeat.o(182780);
        return 0;
      }
      AppMethodBeat.o(182780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cv
 * JD-Core Version:    0.7.0.1
 */