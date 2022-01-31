package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b lGM;
  public b lGN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19423);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lHa != null)
      {
        paramVarArgs.iQ(1, this.lHa.computeSize());
        this.lHa.writeFields(paramVarArgs);
      }
      if (this.lGM != null) {
        paramVarArgs.c(2, this.lGM);
      }
      if (this.lGN != null) {
        paramVarArgs.c(3, this.lGN);
      }
      AppMethodBeat.o(19423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lHa == null) {
        break label439;
      }
    }
    label439:
    for (int i = e.a.a.a.iP(1, this.lHa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lGM != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.lGM);
      }
      i = paramInt;
      if (this.lGN != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.lGN);
      }
      AppMethodBeat.o(19423);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(19423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(19423);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, i.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localf.lHa = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19423);
          return 0;
        case 2: 
          localf.lGM = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(19423);
          return 0;
        }
        localf.lGN = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(19423);
        return 0;
      }
      AppMethodBeat.o(19423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.f
 * JD-Core Version:    0.7.0.1
 */