package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String fVj;
  public int fVk;
  public String fVl;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.fVj != null) {
        paramVarArgs.d(2, this.fVj);
      }
      paramVarArgs.aS(3, this.fVk);
      if (this.fVl != null) {
        paramVarArgs.d(4, this.fVl);
      }
      AppMethodBeat.o(42662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fVj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fVj);
      }
      i += f.a.a.b.b.a.bz(3, this.fVk);
      paramInt = i;
      if (this.fVl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fVl);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(42662);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42662);
          return -1;
        case 1: 
          localb.userName = locala.NPN.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.fVj = locala.NPN.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.fVk = locala.NPN.zc();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.fVl = locala.NPN.readString();
        AppMethodBeat.o(42662);
        return 0;
      }
      AppMethodBeat.o(42662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */