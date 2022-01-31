package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bv.a
{
  public String elx;
  public int ely;
  public String elz;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59616);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      if (this.elx != null) {
        paramVarArgs.e(2, this.elx);
      }
      paramVarArgs.aO(3, this.ely);
      if (this.elz != null) {
        paramVarArgs.e(4, this.elz);
      }
      AppMethodBeat.o(59616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.elx != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.elx);
      }
      i += e.a.a.b.b.a.bl(3, this.ely);
      paramInt = i;
      if (this.elz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.elz);
      }
      AppMethodBeat.o(59616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(59616);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(59616);
          return -1;
        case 1: 
          localb.userName = locala.CLY.readString();
          AppMethodBeat.o(59616);
          return 0;
        case 2: 
          localb.elx = locala.CLY.readString();
          AppMethodBeat.o(59616);
          return 0;
        case 3: 
          localb.ely = locala.CLY.sl();
          AppMethodBeat.o(59616);
          return 0;
        }
        localb.elz = locala.CLY.readString();
        AppMethodBeat.o(59616);
        return 0;
      }
      AppMethodBeat.o(59616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */