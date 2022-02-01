package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> nIF;
  public LinkedList<Long> nIG;
  
  public j()
  {
    AppMethodBeat.i(22112);
    this.nIF = new LinkedList();
    this.nIG = new LinkedList();
    AppMethodBeat.o(22112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.nIF);
      paramVarArgs.e(2, 3, this.nIG);
      AppMethodBeat.o(22113);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.nIF);
      int i = f.a.a.a.c(2, 3, this.nIG);
      AppMethodBeat.o(22113);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nIF.clear();
      this.nIG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(22113);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22113);
        return -1;
      case 1: 
        localj.nIF.add(locala.OmT.readString());
        AppMethodBeat.o(22113);
        return 0;
      }
      localj.nIG.add(Long.valueOf(locala.OmT.zd()));
      AppMethodBeat.o(22113);
      return 0;
    }
    AppMethodBeat.o(22113);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.j
 * JD-Core Version:    0.7.0.1
 */