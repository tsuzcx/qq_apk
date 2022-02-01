package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String fyo;
  public int fyp;
  public String fyq;
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
      if (this.fyo != null) {
        paramVarArgs.d(2, this.fyo);
      }
      paramVarArgs.aR(3, this.fyp);
      if (this.fyq != null) {
        paramVarArgs.d(4, this.fyq);
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
      if (this.fyo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fyo);
      }
      i += f.a.a.b.b.a.bA(3, this.fyp);
      paramInt = i;
      if (this.fyq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fyq);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localb.userName = locala.KhF.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.fyo = locala.KhF.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.fyp = locala.KhF.xS();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.fyq = locala.KhF.readString();
        AppMethodBeat.o(42662);
        return 0;
      }
      AppMethodBeat.o(42662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */