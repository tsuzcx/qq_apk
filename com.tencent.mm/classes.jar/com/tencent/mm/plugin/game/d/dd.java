package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dd
  extends com.tencent.mm.bx.a
{
  public String ujy;
  public String ujz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(182780);
        throw paramVarArgs;
      }
      if (this.ujy != null) {
        paramVarArgs.d(1, this.ujy);
      }
      if (this.ujz != null) {
        paramVarArgs.d(2, this.ujz);
      }
      AppMethodBeat.o(182780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ujy == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.ujy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ujz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ujz);
      }
      AppMethodBeat.o(182780);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ujy == null)
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
        dd localdd = (dd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(182780);
          return -1;
        case 1: 
          localdd.ujy = locala.NPN.readString();
          AppMethodBeat.o(182780);
          return 0;
        }
        localdd.ujz = locala.NPN.readString();
        AppMethodBeat.o(182780);
        return 0;
      }
      AppMethodBeat.o(182780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dd
 * JD-Core Version:    0.7.0.1
 */