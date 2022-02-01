package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String gCv;
  public int gCw;
  public String gCx;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      if (this.gCv != null) {
        paramVarArgs.e(2, this.gCv);
      }
      paramVarArgs.aM(3, this.gCw);
      if (this.gCx != null) {
        paramVarArgs.e(4, this.gCx);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gCv != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.gCv);
      }
      i += g.a.a.b.b.a.bu(3, this.gCw);
      paramInt = i;
      if (this.gCx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.gCx);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
          localb.userName = locala.UbS.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.gCv = locala.UbS.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.gCw = locala.UbS.zi();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.gCx = locala.UbS.readString();
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