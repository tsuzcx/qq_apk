package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bv.a
{
  public c lGZ;
  public int lHc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19428);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lGZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BasePush");
        AppMethodBeat.o(19428);
        throw paramVarArgs;
      }
      if (this.lGZ != null)
      {
        paramVarArgs.iQ(1, this.lGZ.computeSize());
        this.lGZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lHc);
      AppMethodBeat.o(19428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lGZ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = e.a.a.a.iP(1, this.lGZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.lHc);
      AppMethodBeat.o(19428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.lGZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: BasePush");
          AppMethodBeat.o(19428);
          throw paramVarArgs;
        }
        AppMethodBeat.o(19428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(19428);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localm.lGZ = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19428);
          return 0;
        }
        localm.lHc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(19428);
        return 0;
      }
      AppMethodBeat.o(19428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.m
 * JD-Core Version:    0.7.0.1
 */