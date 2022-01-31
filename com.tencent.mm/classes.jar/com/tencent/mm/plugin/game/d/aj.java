package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aj
  extends com.tencent.mm.bv.a
{
  public cb nrA;
  public cb nrB;
  public cz nrC;
  public cb nrz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111576);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nrz != null)
      {
        paramVarArgs.iQ(1, this.nrz.computeSize());
        this.nrz.writeFields(paramVarArgs);
      }
      if (this.nrA != null)
      {
        paramVarArgs.iQ(2, this.nrA.computeSize());
        this.nrA.writeFields(paramVarArgs);
      }
      if (this.nrB != null)
      {
        paramVarArgs.iQ(3, this.nrB.computeSize());
        this.nrB.writeFields(paramVarArgs);
      }
      if (this.nrC != null)
      {
        paramVarArgs.iQ(4, this.nrC.computeSize());
        this.nrC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrz == null) {
        break label774;
      }
    }
    label774:
    for (int i = e.a.a.a.iP(1, this.nrz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nrA != null) {
        paramInt = i + e.a.a.a.iP(2, this.nrA.computeSize());
      }
      i = paramInt;
      if (this.nrB != null) {
        i = paramInt + e.a.a.a.iP(3, this.nrB.computeSize());
      }
      paramInt = i;
      if (this.nrC != null) {
        paramInt = i + e.a.a.a.iP(4, this.nrC.computeSize());
      }
      AppMethodBeat.o(111576);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111576);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111576);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaj.nrz = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111576);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaj.nrA = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111576);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaj.nrB = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111576);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaj.nrC = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111576);
        return 0;
      }
      AppMethodBeat.o(111576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aj
 * JD-Core Version:    0.7.0.1
 */