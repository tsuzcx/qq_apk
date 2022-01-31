package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class by
  extends com.tencent.mm.bv.a
{
  public dg ntr;
  public co nts;
  public u ntt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111632);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntr != null)
      {
        paramVarArgs.iQ(1, this.ntr.computeSize());
        this.ntr.writeFields(paramVarArgs);
      }
      if (this.nts != null)
      {
        paramVarArgs.iQ(2, this.nts.computeSize());
        this.nts.writeFields(paramVarArgs);
      }
      if (this.ntt != null)
      {
        paramVarArgs.iQ(3, this.ntt.computeSize());
        this.ntt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntr == null) {
        break label618;
      }
    }
    label618:
    for (int i = e.a.a.a.iP(1, this.ntr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nts != null) {
        paramInt = i + e.a.a.a.iP(2, this.nts.computeSize());
      }
      i = paramInt;
      if (this.ntt != null) {
        i = paramInt + e.a.a.a.iP(3, this.ntt.computeSize());
      }
      AppMethodBeat.o(111632);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111632);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localby.ntr = ((dg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111632);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localby.nts = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111632);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new u();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localby.ntt = ((u)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111632);
        return 0;
      }
      AppMethodBeat.o(111632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.by
 * JD-Core Version:    0.7.0.1
 */