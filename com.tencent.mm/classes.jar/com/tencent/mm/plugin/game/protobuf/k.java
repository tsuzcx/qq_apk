package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.cd.a
{
  public LinkedList<h> CNp;
  public LinkedList<dv> CNq;
  
  public k()
  {
    AppMethodBeat.i(207310);
    this.CNp = new LinkedList();
    this.CNq = new LinkedList();
    AppMethodBeat.o(207310);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207313);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CNp);
      paramVarArgs.e(2, 8, this.CNq);
      AppMethodBeat.o(207313);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.CNp);
      i = g.a.a.a.c(2, 8, this.CNq);
      AppMethodBeat.o(207313);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNp.clear();
      this.CNq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207313);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207313);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new h();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((h)localObject2).parseFrom((byte[])localObject1);
          }
          localk.CNp.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207313);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dv();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dv)localObject2).parseFrom((byte[])localObject1);
        }
        localk.CNq.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(207313);
      return 0;
    }
    AppMethodBeat.o(207313);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.k
 * JD-Core Version:    0.7.0.1
 */