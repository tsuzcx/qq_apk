package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public int oXh;
  public String oXi;
  public String oXj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oXh);
      if (this.oXi != null) {
        paramVarArgs.d(2, this.oXi);
      }
      if (this.oXj != null) {
        paramVarArgs.d(3, this.oXj);
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.oXh) + 0;
      paramInt = i;
      if (this.oXi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oXi);
      }
      i = paramInt;
      if (this.oXj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oXj);
      }
      AppMethodBeat.o(23482);
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
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(23482);
        return -1;
      case 1: 
        locala1.oXh = locala.KhF.xS();
        AppMethodBeat.o(23482);
        return 0;
      case 2: 
        locala1.oXi = locala.KhF.readString();
        AppMethodBeat.o(23482);
        return 0;
      }
      locala1.oXj = locala.KhF.readString();
      AppMethodBeat.o(23482);
      return 0;
    }
    AppMethodBeat.o(23482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */