package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public String jmB;
  public int jmC;
  public String jmD;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.f(1, this.userName);
      }
      if (this.jmB != null) {
        paramVarArgs.f(2, this.jmB);
      }
      paramVarArgs.aY(3, this.jmC);
      if (this.jmD != null) {
        paramVarArgs.f(4, this.jmD);
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
    for (paramInt = g.a.a.b.b.a.g(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jmB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jmB);
      }
      i += g.a.a.b.b.a.bM(3, this.jmC);
      paramInt = i;
      if (this.jmD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jmD);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(42662);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42662);
          return -1;
        case 1: 
          localb.userName = locala.abFh.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.jmB = locala.abFh.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.jmC = locala.abFh.AK();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.jmD = locala.abFh.readString();
        AppMethodBeat.o(42662);
        return 0;
      }
      AppMethodBeat.o(42662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */