package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public int gKk;
  public int gKl;
  public String gKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.gKk);
      paramVarArgs.aR(2, this.gKl);
      if (this.gKm != null) {
        paramVarArgs.d(3, this.gKm);
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.gKk) + 0 + f.a.a.b.b.a.bA(2, this.gKl);
      paramInt = i;
      if (this.gKm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gKm);
      }
      AppMethodBeat.o(116410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116410);
        return -1;
      case 1: 
        localo.gKk = locala.KhF.xS();
        AppMethodBeat.o(116410);
        return 0;
      case 2: 
        localo.gKl = locala.KhF.xS();
        AppMethodBeat.o(116410);
        return 0;
      }
      localo.gKm = locala.KhF.readString();
      AppMethodBeat.o(116410);
      return 0;
    }
    AppMethodBeat.o(116410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.o
 * JD-Core Version:    0.7.0.1
 */