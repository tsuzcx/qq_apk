package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dv
  extends com.tencent.mm.cd.a
{
  public int CNe;
  public LinkedList<v> CNl;
  
  public dv()
  {
    AppMethodBeat.i(207062);
    this.CNl = new LinkedList();
    AppMethodBeat.o(207062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207065);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CNe);
      paramVarArgs.e(2, 8, this.CNl);
      AppMethodBeat.o(207065);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.CNe);
      i = g.a.a.a.c(2, 8, this.CNl);
      AppMethodBeat.o(207065);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207065);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dv localdv = (dv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207065);
        return -1;
      case 1: 
        localdv.CNe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207065);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        v localv = new v();
        if ((localObject != null) && (localObject.length > 0)) {
          localv.parseFrom((byte[])localObject);
        }
        localdv.CNl.add(localv);
        paramInt += 1;
      }
      AppMethodBeat.o(207065);
      return 0;
    }
    AppMethodBeat.o(207065);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */