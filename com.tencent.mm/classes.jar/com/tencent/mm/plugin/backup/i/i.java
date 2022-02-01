package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> vgP;
  public LinkedList<Long> vgQ;
  
  public i()
  {
    AppMethodBeat.i(22110);
    this.vgP = new LinkedList();
    this.vgQ = new LinkedList();
    AppMethodBeat.o(22110);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22111);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.vgP);
      paramVarArgs.e(2, 3, this.vgQ);
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 1, this.vgP);
      int i = i.a.a.a.c(2, 3, this.vgQ);
      AppMethodBeat.o(22111);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vgP.clear();
      this.vgQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22111);
        return -1;
      case 1: 
        locali.vgP.add(locala.ajGk.readString());
        AppMethodBeat.o(22111);
        return 0;
      }
      locali.vgQ.add(Long.valueOf(locala.ajGk.aaw()));
      AppMethodBeat.o(22111);
      return 0;
    }
    AppMethodBeat.o(22111);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.i
 * JD-Core Version:    0.7.0.1
 */