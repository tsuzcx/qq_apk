package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230998);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.userName != null) {
        paramVarArgs.g(2, this.userName);
      }
      AppMethodBeat.o(230998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.userName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.userName);
      }
      AppMethodBeat.o(230998);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(230998);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230998);
          return -1;
        case 1: 
          localh.appId = locala.ajGk.readString();
          AppMethodBeat.o(230998);
          return 0;
        }
        localh.userName = locala.ajGk.readString();
        AppMethodBeat.o(230998);
        return 0;
      }
      AppMethodBeat.o(230998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelpackage.h
 * JD-Core Version:    0.7.0.1
 */