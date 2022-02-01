package com.tencent.mm.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String displayName;
  public int lPN;
  public String lPO;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42662);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.g(1, this.userName);
      }
      if (this.displayName != null) {
        paramVarArgs.g(2, this.displayName);
      }
      paramVarArgs.bS(3, this.lPN);
      if (this.lPO != null) {
        paramVarArgs.g(4, this.lPO);
      }
      AppMethodBeat.o(42662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.displayName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.displayName);
      }
      i += i.a.a.b.b.a.cJ(3, this.lPN);
      paramInt = i;
      if (this.lPO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.lPO);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(42662);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42662);
          return -1;
        case 1: 
          localb.userName = locala.ajGk.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.displayName = locala.ajGk.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.lPN = locala.ajGk.aar();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.lPO = locala.ajGk.readString();
        AppMethodBeat.o(42662);
        return 0;
      }
      AppMethodBeat.o(42662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.a.a.b
 * JD-Core Version:    0.7.0.1
 */