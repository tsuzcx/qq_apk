package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> nDk;
  public LinkedList<Long> nDl;
  
  public i()
  {
    AppMethodBeat.i(22110);
    this.nDk = new LinkedList();
    this.nDl = new LinkedList();
    AppMethodBeat.o(22110);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22111);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.nDk);
      paramVarArgs.e(2, 3, this.nDl);
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.nDk);
      int i = f.a.a.a.c(2, 3, this.nDl);
      AppMethodBeat.o(22111);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nDk.clear();
      this.nDl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(22111);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22111);
        return -1;
      case 1: 
        locali.nDk.add(locala.NPN.readString());
        AppMethodBeat.o(22111);
        return 0;
      }
      locali.nDl.add(Long.valueOf(locala.NPN.zd()));
      AppMethodBeat.o(22111);
      return 0;
    }
    AppMethodBeat.o(22111);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.i
 * JD-Core Version:    0.7.0.1
 */