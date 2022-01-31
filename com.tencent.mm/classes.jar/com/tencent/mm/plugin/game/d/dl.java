package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dl
  extends com.tencent.mm.bv.a
{
  public String num;
  public String nun;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111679);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.num == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(111679);
        throw paramVarArgs;
      }
      if (this.nun == null)
      {
        paramVarArgs = new b("Not all required fields were included: TimeDesc");
        AppMethodBeat.o(111679);
        throw paramVarArgs;
      }
      if (this.num != null) {
        paramVarArgs.e(1, this.num);
      }
      if (this.nun != null) {
        paramVarArgs.e(2, this.nun);
      }
      AppMethodBeat.o(111679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.num == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.num) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nun != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nun);
      }
      AppMethodBeat.o(111679);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.num == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(111679);
          throw paramVarArgs;
        }
        if (this.nun == null)
        {
          paramVarArgs = new b("Not all required fields were included: TimeDesc");
          AppMethodBeat.o(111679);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111679);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dl localdl = (dl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111679);
          return -1;
        case 1: 
          localdl.num = locala.CLY.readString();
          AppMethodBeat.o(111679);
          return 0;
        }
        localdl.nun = locala.CLY.readString();
        AppMethodBeat.o(111679);
        return 0;
      }
      AppMethodBeat.o(111679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dl
 * JD-Core Version:    0.7.0.1
 */