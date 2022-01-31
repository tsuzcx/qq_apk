package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.bv.a
{
  public LinkedList<cr> ntQ;
  public String ntR;
  public String ntj;
  
  public cq()
  {
    AppMethodBeat.i(111654);
    this.ntQ = new LinkedList();
    AppMethodBeat.o(111654);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111655);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ntQ);
      if (this.ntj != null) {
        paramVarArgs.e(2, this.ntj);
      }
      if (this.ntR != null) {
        paramVarArgs.e(3, this.ntR);
      }
      AppMethodBeat.o(111655);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.ntQ) + 0;
      paramInt = i;
      if (this.ntj != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntj);
      }
      i = paramInt;
      if (this.ntR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntR);
      }
      AppMethodBeat.o(111655);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ntQ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(111655);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cq localcq = (cq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(111655);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cr();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcq.ntQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111655);
        return 0;
      case 2: 
        localcq.ntj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111655);
        return 0;
      }
      localcq.ntR = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(111655);
      return 0;
    }
    AppMethodBeat.o(111655);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cq
 * JD-Core Version:    0.7.0.1
 */