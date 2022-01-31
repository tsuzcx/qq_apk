package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dq
  extends com.tencent.mm.bv.a
{
  public String nqt;
  public dr nut;
  public ab nuu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111681);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nut != null)
      {
        paramVarArgs.iQ(1, this.nut.computeSize());
        this.nut.writeFields(paramVarArgs);
      }
      if (this.nuu != null)
      {
        paramVarArgs.iQ(2, this.nuu.computeSize());
        this.nuu.writeFields(paramVarArgs);
      }
      if (this.nqt != null) {
        paramVarArgs.e(3, this.nqt);
      }
      AppMethodBeat.o(111681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nut == null) {
        break label526;
      }
    }
    label526:
    for (int i = e.a.a.a.iP(1, this.nut.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nuu != null) {
        paramInt = i + e.a.a.a.iP(2, this.nuu.computeSize());
      }
      i = paramInt;
      if (this.nqt != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqt);
      }
      AppMethodBeat.o(111681);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111681);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdq.nut = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111681);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ab();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdq.nuu = ((ab)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111681);
          return 0;
        }
        localdq.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111681);
        return 0;
      }
      AppMethodBeat.o(111681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dq
 * JD-Core Version:    0.7.0.1
 */