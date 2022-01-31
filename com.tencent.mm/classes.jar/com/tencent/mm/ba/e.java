package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bv.a
{
  public String fMx;
  public String lang;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(78442);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fMx != null) {
        paramVarArgs.e(1, this.fMx);
      }
      if (this.lang != null) {
        paramVarArgs.e(2, this.lang);
      }
      AppMethodBeat.o(78442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fMx == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.fMx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lang != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.lang);
      }
      AppMethodBeat.o(78442);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(78442);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(78442);
          return -1;
        case 1: 
          locale.fMx = locala.CLY.readString();
          AppMethodBeat.o(78442);
          return 0;
        }
        locale.lang = locala.CLY.readString();
        AppMethodBeat.o(78442);
        return 0;
      }
      AppMethodBeat.o(78442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ba.e
 * JD-Core Version:    0.7.0.1
 */