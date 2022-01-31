package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> jJw;
  public LinkedList<Long> jJx;
  
  public j()
  {
    AppMethodBeat.i(18055);
    this.jJw = new LinkedList();
    this.jJx = new LinkedList();
    AppMethodBeat.o(18055);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18056);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.jJw);
      paramVarArgs.e(2, 3, this.jJx);
      AppMethodBeat.o(18056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 1, this.jJw);
      int i = e.a.a.a.c(2, 3, this.jJx);
      AppMethodBeat.o(18056);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jJw.clear();
      this.jJx.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18056);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18056);
        return -1;
      case 1: 
        localj.jJw.add(locala.CLY.readString());
        AppMethodBeat.o(18056);
        return 0;
      }
      localj.jJx.add(Long.valueOf(locala.CLY.sm()));
      AppMethodBeat.o(18056);
      return 0;
    }
    AppMethodBeat.o(18056);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.j
 * JD-Core Version:    0.7.0.1
 */