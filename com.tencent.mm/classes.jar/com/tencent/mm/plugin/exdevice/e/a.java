package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public int rBx;
  public String rBy;
  public String rBz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23482);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.rBx);
      if (this.rBy != null) {
        paramVarArgs.e(2, this.rBy);
      }
      if (this.rBz != null) {
        paramVarArgs.e(3, this.rBz);
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.rBx) + 0;
      paramInt = i;
      if (this.rBy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.rBy);
      }
      i = paramInt;
      if (this.rBz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.rBz);
      }
      AppMethodBeat.o(23482);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(23482);
        return -1;
      case 1: 
        locala1.rBx = locala.UbS.zi();
        AppMethodBeat.o(23482);
        return 0;
      case 2: 
        locala1.rBy = locala.UbS.readString();
        AppMethodBeat.o(23482);
        return 0;
      }
      locala1.rBz = locala.UbS.readString();
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