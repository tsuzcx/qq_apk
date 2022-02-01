package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public int pAs;
  public String pAt;
  public String pAu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.pAs);
      if (this.pAt != null) {
        paramVarArgs.d(2, this.pAt);
      }
      if (this.pAu != null) {
        paramVarArgs.d(3, this.pAu);
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.pAs) + 0;
      paramInt = i;
      if (this.pAt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pAt);
      }
      i = paramInt;
      if (this.pAu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pAu);
      }
      AppMethodBeat.o(23482);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        locala1.pAs = locala.LVo.xF();
        AppMethodBeat.o(23482);
        return 0;
      case 2: 
        locala1.pAt = locala.LVo.readString();
        AppMethodBeat.o(23482);
        return 0;
      }
      locala1.pAu = locala.LVo.readString();
      AppMethodBeat.o(23482);
      return 0;
    }
    AppMethodBeat.o(23482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */