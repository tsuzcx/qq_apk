package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dl
  extends com.tencent.mm.bw.a
{
  public String uuW;
  public String uuX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(182780);
        throw paramVarArgs;
      }
      if (this.uuW != null) {
        paramVarArgs.d(1, this.uuW);
      }
      if (this.uuX != null) {
        paramVarArgs.d(2, this.uuX);
      }
      AppMethodBeat.o(182780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuW == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uuX);
      }
      AppMethodBeat.o(182780);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uuW == null)
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
        dl localdl = (dl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(182780);
          return -1;
        case 1: 
          localdl.uuW = locala.OmT.readString();
          AppMethodBeat.o(182780);
          return 0;
        }
        localdl.uuX = locala.OmT.readString();
        AppMethodBeat.o(182780);
        return 0;
      }
      AppMethodBeat.o(182780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dl
 * JD-Core Version:    0.7.0.1
 */