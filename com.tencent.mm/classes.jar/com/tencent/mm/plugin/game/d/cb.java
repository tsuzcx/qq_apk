package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Title;
  public String npR;
  public String ntw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111636);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      if (this.ntw != null) {
        paramVarArgs.e(4, this.ntw);
      }
      AppMethodBeat.o(111636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npR);
      }
      paramInt = i;
      if (this.ntw != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntw);
      }
      AppMethodBeat.o(111636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111636);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cb localcb = (cb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111636);
          return -1;
        case 1: 
          localcb.Title = locala.CLY.readString();
          AppMethodBeat.o(111636);
          return 0;
        case 2: 
          localcb.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(111636);
          return 0;
        case 3: 
          localcb.npR = locala.CLY.readString();
          AppMethodBeat.o(111636);
          return 0;
        }
        localcb.ntw = locala.CLY.readString();
        AppMethodBeat.o(111636);
        return 0;
      }
      AppMethodBeat.o(111636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cb
 * JD-Core Version:    0.7.0.1
 */