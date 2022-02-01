package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ea
  extends com.tencent.mm.bx.a
{
  public String ukj;
  public String ukk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ukj == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.ukk == null)
      {
        paramVarArgs = new b("Not all required fields were included: TimeDesc");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.ukj != null) {
        paramVarArgs.d(1, this.ukj);
      }
      if (this.ukk != null) {
        paramVarArgs.d(2, this.ukk);
      }
      AppMethodBeat.o(41844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukj == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.ukj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ukk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ukk);
      }
      AppMethodBeat.o(41844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ukj == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        if (this.ukk == null)
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
        ea localea = (ea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41844);
          return -1;
        case 1: 
          localea.ukj = locala.NPN.readString();
          AppMethodBeat.o(41844);
          return 0;
        }
        localea.ukk = locala.NPN.readString();
        AppMethodBeat.o(41844);
        return 0;
      }
      AppMethodBeat.o(41844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ea
 * JD-Core Version:    0.7.0.1
 */