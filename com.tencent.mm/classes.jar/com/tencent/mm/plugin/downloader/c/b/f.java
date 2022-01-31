package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public b kWM;
  public i kWN;
  public boolean kWO;
  public int kWP;
  public boolean kWQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35532);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWM != null)
      {
        paramVarArgs.iQ(1, this.kWM.computeSize());
        this.kWM.writeFields(paramVarArgs);
      }
      if (this.kWN != null)
      {
        paramVarArgs.iQ(2, this.kWN.computeSize());
        this.kWN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.kWO);
      paramVarArgs.aO(4, this.kWP);
      paramVarArgs.aS(5, this.kWQ);
      AppMethodBeat.o(35532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWM == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.a.iP(1, this.kWM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWN != null) {
        i = paramInt + e.a.a.a.iP(2, this.kWN.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.bl(4, this.kWP);
      int k = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(35532);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35532);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35532);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localf.kWM = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35532);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localf.kWN = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35532);
          return 0;
        case 3: 
          localf.kWO = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(35532);
          return 0;
        case 4: 
          localf.kWP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35532);
          return 0;
        }
        localf.kWQ = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(35532);
        return 0;
      }
      AppMethodBeat.o(35532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.f
 * JD-Core Version:    0.7.0.1
 */