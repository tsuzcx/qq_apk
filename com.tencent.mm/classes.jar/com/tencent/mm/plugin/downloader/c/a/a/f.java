package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String knV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35514);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.e(1, this.desc);
      }
      if (this.knV != null) {
        paramVarArgs.e(2, this.knV);
      }
      AppMethodBeat.o(35514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.knV != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.knV);
      }
      AppMethodBeat.o(35514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35514);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(35514);
          return -1;
        case 1: 
          localf.desc = locala.CLY.readString();
          AppMethodBeat.o(35514);
          return 0;
        }
        localf.knV = locala.CLY.readString();
        AppMethodBeat.o(35514);
        return 0;
      }
      AppMethodBeat.o(35514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */