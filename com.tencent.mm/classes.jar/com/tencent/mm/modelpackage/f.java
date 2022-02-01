package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public String lang;
  public String oQy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150796);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oQy != null) {
        paramVarArgs.g(1, this.oQy);
      }
      if (this.lang != null) {
        paramVarArgs.g(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oQy == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.oQy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lang != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.lang);
      }
      AppMethodBeat.o(150796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(150796);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150796);
          return -1;
        case 1: 
          localf.oQy = locala.ajGk.readString();
          AppMethodBeat.o(150796);
          return 0;
        }
        localf.lang = locala.ajGk.readString();
        AppMethodBeat.o(150796);
        return 0;
      }
      AppMethodBeat.o(150796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelpackage.f
 * JD-Core Version:    0.7.0.1
 */