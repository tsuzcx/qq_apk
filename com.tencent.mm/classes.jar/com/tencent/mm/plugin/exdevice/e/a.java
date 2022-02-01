package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public int qkC;
  public String qkD;
  public String qkE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qkC);
      if (this.qkD != null) {
        paramVarArgs.d(2, this.qkD);
      }
      if (this.qkE != null) {
        paramVarArgs.d(3, this.qkE);
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.qkC) + 0;
      paramInt = i;
      if (this.qkD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qkD);
      }
      i = paramInt;
      if (this.qkE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qkE);
      }
      AppMethodBeat.o(23482);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locala1.qkC = locala.OmT.zc();
        AppMethodBeat.o(23482);
        return 0;
      case 2: 
        locala1.qkD = locala.OmT.readString();
        AppMethodBeat.o(23482);
        return 0;
      }
      locala1.qkE = locala.OmT.readString();
      AppMethodBeat.o(23482);
      return 0;
    }
    AppMethodBeat.o(23482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */