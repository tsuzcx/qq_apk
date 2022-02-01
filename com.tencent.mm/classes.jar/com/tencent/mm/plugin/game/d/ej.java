package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ej
  extends com.tencent.mm.bw.a
{
  public String uvG;
  public String uvH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.uvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: TimeDesc");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.uvG != null) {
        paramVarArgs.d(1, this.uvG);
      }
      if (this.uvH != null) {
        paramVarArgs.d(2, this.uvH);
      }
      AppMethodBeat.o(41844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvG == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uvH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uvH);
      }
      AppMethodBeat.o(41844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uvG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        if (this.uvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: TimeDesc");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41844);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41844);
          return -1;
        case 1: 
          localej.uvG = locala.OmT.readString();
          AppMethodBeat.o(41844);
          return 0;
        }
        localej.uvH = locala.OmT.readString();
        AppMethodBeat.o(41844);
        return 0;
      }
      AppMethodBeat.o(41844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ej
 * JD-Core Version:    0.7.0.1
 */