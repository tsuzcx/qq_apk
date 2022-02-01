package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.cd.a
{
  public LinkedList<Long> rVA;
  public LinkedList<String> rVz;
  
  public i()
  {
    AppMethodBeat.i(22110);
    this.rVz = new LinkedList();
    this.rVA = new LinkedList();
    AppMethodBeat.o(22110);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22111);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.rVz);
      paramVarArgs.e(2, 3, this.rVA);
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.rVz);
      int i = g.a.a.a.c(2, 3, this.rVA);
      AppMethodBeat.o(22111);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rVz.clear();
      this.rVA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22111);
        return -1;
      case 1: 
        locali.rVz.add(locala.abFh.readString());
        AppMethodBeat.o(22111);
        return 0;
      }
      locali.rVA.add(Long.valueOf(locala.abFh.AN()));
      AppMethodBeat.o(22111);
      return 0;
    }
    AppMethodBeat.o(22111);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.i
 * JD-Core Version:    0.7.0.1
 */