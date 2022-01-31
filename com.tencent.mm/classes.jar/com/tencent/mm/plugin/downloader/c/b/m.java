package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bv.a
{
  public String kXh;
  public String kXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35539);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kXh != null) {
        paramVarArgs.e(1, this.kXh);
      }
      if (this.kXi != null) {
        paramVarArgs.e(2, this.kXi);
      }
      AppMethodBeat.o(35539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kXh == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.kXh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kXi != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kXi);
      }
      AppMethodBeat.o(35539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35539);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(35539);
          return -1;
        case 1: 
          localm.kXh = locala.CLY.readString();
          AppMethodBeat.o(35539);
          return 0;
        }
        localm.kXi = locala.CLY.readString();
        AppMethodBeat.o(35539);
        return 0;
      }
      AppMethodBeat.o(35539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.m
 * JD-Core Version:    0.7.0.1
 */