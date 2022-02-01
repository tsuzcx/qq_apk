package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class k
  extends com.tencent.mm.bw.a
{
  public int ncP;
  public int ncQ;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ncP);
      paramVarArgs.aR(2, this.ncQ);
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ncP) + 0 + f.a.a.b.b.a.bx(2, this.ncQ);
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ncR);
      }
      AppMethodBeat.o(22114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22114);
        return -1;
      case 1: 
        localk.ncP = locala.LVo.xF();
        AppMethodBeat.o(22114);
        return 0;
      case 2: 
        localk.ncQ = locala.LVo.xF();
        AppMethodBeat.o(22114);
        return 0;
      }
      localk.ncR = locala.LVo.readString();
      AppMethodBeat.o(22114);
      return 0;
    }
    AppMethodBeat.o(22114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */