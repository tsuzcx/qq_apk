package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public int fBI;
  public String tcR;
  public String tcS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fBI);
      if (this.tcR != null) {
        paramVarArgs.d(2, this.tcR);
      }
      if (this.tcS != null) {
        paramVarArgs.d(3, this.tcS);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.fBI) + 0;
      paramInt = i;
      if (this.tcR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tcR);
      }
      i = paramInt;
      if (this.tcS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tcS);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91251);
        return -1;
      case 1: 
        localf.fBI = locala.KhF.xS();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        localf.tcR = locala.KhF.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      localf.tcS = locala.KhF.readString();
      AppMethodBeat.o(91251);
      return 0;
    }
    AppMethodBeat.o(91251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.f
 * JD-Core Version:    0.7.0.1
 */