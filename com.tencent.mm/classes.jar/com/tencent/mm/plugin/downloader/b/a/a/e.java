package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public LinkedList<g> xkV;
  public long xkW;
  
  public e()
  {
    AppMethodBeat.i(153045);
    this.xkV = new LinkedList();
    AppMethodBeat.o(153045);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153046);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xkV);
      paramVarArgs.bv(2, this.xkW);
      AppMethodBeat.o(153046);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.xkV);
      i = i.a.a.b.b.a.q(2, this.xkW);
      AppMethodBeat.o(153046);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xkV.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153046);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153046);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          g localg = new g();
          if ((localObject != null) && (localObject.length > 0)) {
            localg.parseFrom((byte[])localObject);
          }
          locale.xkV.add(localg);
          paramInt += 1;
        }
        AppMethodBeat.o(153046);
        return 0;
      }
      locale.xkW = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(153046);
      return 0;
    }
    AppMethodBeat.o(153046);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */