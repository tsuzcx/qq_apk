package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bx.a
{
  public String iiW;
  public String lang;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iiW != null) {
        paramVarArgs.d(1, this.iiW);
      }
      if (this.lang != null) {
        paramVarArgs.d(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iiW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.iiW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lang != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(150796);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150796);
          return -1;
        case 1: 
          locale.iiW = locala.NPN.readString();
          AppMethodBeat.o(150796);
          return 0;
        }
        locale.lang = locala.NPN.readString();
        AppMethodBeat.o(150796);
        return 0;
      }
      AppMethodBeat.o(150796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.e
 * JD-Core Version:    0.7.0.1
 */