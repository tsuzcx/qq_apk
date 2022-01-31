package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bv.a
{
  public h kWR;
  public h kWS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35533);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWR != null)
      {
        paramVarArgs.iQ(1, this.kWR.computeSize());
        this.kWR.writeFields(paramVarArgs);
      }
      if (this.kWS != null)
      {
        paramVarArgs.iQ(2, this.kWS.computeSize());
        this.kWS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(35533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWR == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.a.iP(1, this.kWR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWS != null) {
        i = paramInt + e.a.a.a.iP(2, this.kWS.computeSize());
      }
      AppMethodBeat.o(35533);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35533);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localg.kWR = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35533);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localg.kWS = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35533);
        return 0;
      }
      AppMethodBeat.o(35533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.g
 * JD-Core Version:    0.7.0.1
 */