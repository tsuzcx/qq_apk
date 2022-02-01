package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b pAI;
  public b pAJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAW != null)
      {
        paramVarArgs.ln(1, this.pAW.computeSize());
        this.pAW.writeFields(paramVarArgs);
      }
      if (this.pAI != null) {
        paramVarArgs.c(2, this.pAI);
      }
      if (this.pAJ != null) {
        paramVarArgs.c(3, this.pAJ);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAW == null) {
        break label439;
      }
    }
    label439:
    for (int i = f.a.a.a.lm(1, this.pAW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pAI != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.pAI);
      }
      i = paramInt;
      if (this.pAJ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.pAJ);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(23490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23490);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.pAW = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.pAI = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.pAJ = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */