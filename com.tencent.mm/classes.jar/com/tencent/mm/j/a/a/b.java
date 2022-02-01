package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String fBV;
  public int fBW;
  public String fBX;
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
      if (this.fBV != null) {
        paramVarArgs.d(2, this.fBV);
      }
      paramVarArgs.aR(3, this.fBW);
      if (this.fBX != null) {
        paramVarArgs.d(4, this.fBX);
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
      if (this.fBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fBV);
      }
      i += f.a.a.b.b.a.bx(3, this.fBW);
      paramInt = i;
      if (this.fBX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fBX);
      }
      AppMethodBeat.o(42662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localb.userName = locala.LVo.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 2: 
          localb.fBV = locala.LVo.readString();
          AppMethodBeat.o(42662);
          return 0;
        case 3: 
          localb.fBW = locala.LVo.xF();
          AppMethodBeat.o(42662);
          return 0;
        }
        localb.fBX = locala.LVo.readString();
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